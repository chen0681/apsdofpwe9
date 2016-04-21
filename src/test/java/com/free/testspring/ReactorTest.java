/**
 * 
 */
package com.free.testspring;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.reactivestreams.Processor;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import reactor.Environment;
import reactor.core.Dispatcher;
import reactor.core.DispatcherSupplier;
import reactor.core.processor.RingBufferProcessor;
import reactor.fn.BiConsumer;
import reactor.fn.Consumer;
import reactor.fn.Function;
import reactor.fn.Supplier;
import reactor.fn.tuple.Tuple;
import reactor.io.buffer.Buffer;
import reactor.rx.BiStreams;
import reactor.rx.Stream;
import reactor.rx.Streams;
import reactor.rx.broadcast.Broadcaster;

/**
 * @author Administrator
 *
 */
public class ReactorTest {

	@Test
	public void testReactor1() throws InterruptedException {
		Environment env = Environment.initializeIfEmpty();
		
		 Broadcaster<String> sink = Broadcaster.create(Environment.get()); 

		    sink.dispatchOn(Environment.cachedDispatcher()).map( new Function<String, String>() {
		    	public String apply(String arg0) {
		    		return arg0.toUpperCase();
		    	};
			}).consume(new Consumer<String>() {
				public void accept(String arg0) {
					System.out.printf("s=%s%n", arg0);
				};
			});

		    sink.onNext("Hello World!"); 

		    Thread.sleep(500); 
	}
	
//	@Test
	public void testReactor2() {
		//Initialize context and get default dispatcher
		Environment.initialize();

		//RingBufferDispatcher with 8192 slots by default
		Dispatcher dispatcher = Environment.sharedDispatcher();

		//Create a callback
		Consumer<Integer> c = new Consumer<Integer>() {
			@Override
			public void accept(Integer arg0) {
				 System.out.println("some data arrived: " + arg0);
			}
		};

		//Create an error callback
		Consumer<Throwable> errorHandler = new Consumer<Throwable>() {
			@Override
			public void accept(Throwable arg0) {
				arg0.printStackTrace();
			}
		};

		//Dispatch data asynchronously
		dispatcher.dispatch(1234, c, errorHandler);

		Environment.terminate();
	}
	
//	@Test
	public void testReactor3() {
		//standalone async processor
		RingBufferProcessor<Integer> processor = RingBufferProcessor.<Integer>create();

		//send data, will be kept safe until a subscriber attaches to the processor
		processor.onNext(1234);
		processor.onNext(5678);

		//consume integer data
		processor.subscribe(new Subscriber<Integer>(){

		@Override
		 public void onSubscribe(Subscription s){
		    //unbounded subscriber
		    s.request(Long.MAX_VALUE);
		  }

		@Override
		 public void onNext(Integer data){
		    System.out.println("onNext=" + data);
		  }

		@Override
		 public void onError(Throwable err){
		    err.printStackTrace();
		  }

		@Override
		 public void onComplete(){
			  System.out.println("done!");
		  }
		});

		//Shutdown internal thread and call complete
		processor.onComplete();
	}
	
//	@Test
	public void testReactor4() {
		Consumer<String> consumer = new Consumer<String>(){
	        @Override
	        public void accept(String value){
	                System.out.println(value);
	        }
		};
		
		//Now in Java 8 style for brievety
		Function<Integer, String> transformation = new Function<Integer, String>() {
			@Override
			public String apply(Integer arg0) {
				return String.valueOf(arg0);
			}
		};
		
		Supplier<Integer> supplier = new Supplier<Integer>() {
			@Override
			public Integer get() {
				return 123;
			}
		};
		
		BiConsumer<Consumer<String>, String> biConsumer = new BiConsumer<Consumer<String>, String>() {
			@Override
			public void accept(Consumer<String> arg0, String arg1) {
				for(int i = 0; i < 10; i++){
	                //lazy evaluate the final logic to run
					arg0.accept(arg1);
				}
			}
		};
		
		//note how the execution flows from supplier to biconsumer
		biConsumer.accept(
		        consumer,
		        transformation.apply(
		                supplier.get()
		        )
		);
	}
	
//	@Test
	public void testDispathers1() {
//		Environment.initialize();
		//....

		//Create an anonymous pool of 2 dispatchers with automatic default settings (same type than default dispatcher, default backlog size...)
		DispatcherSupplier supplier = Environment.newCachedDispatchers(2);

		Dispatcher d1 = supplier.get();
		Dispatcher d2 = supplier.get();
		Dispatcher d3 = supplier.get();
		Dispatcher d4 = supplier.get();

		Assert.assertTrue( d1 == d3  && d2 == d4);
		supplier.shutdown();

		//Create and register a new pool of 3 dispatchers
		DispatcherSupplier supplier1 = Environment.newCachedDispatchers(3, "myPool");
		DispatcherSupplier supplier2 = Environment.cachedDispatchers("myPool");

		Assert.assertTrue( supplier1 == supplier2 );
		supplier1.shutdown();
	}
	
//	@Test
	public void testRingBufferProcessor() {
		Processor<Integer, Integer> p = RingBufferProcessor.create("test", 32); 
		Stream<Integer> s = Streams.wrap(p); 

		Consumer<Integer> consumer =	new Consumer<Integer>() {
			@Override
			public void accept(Integer arg0) {
				System.out.println(Thread.currentThread() + " data=" +arg0);
			}
		};
		s.consume(consumer); 
		s.consume(consumer); 
		s.consume(consumer); 

		s.subscribe(p);
	}
	
//	@Test
	public void testBuffer() throws IOException {
		Buffer buff = new Buffer();
		Buffer fullBuff = Buffer.wrap("Hello World!");
		 buff.append(fullBuff);

		Assert.assertTrue( buff.position() == 12);
		Assert.assertTrue( buff.flip().asString() != "Hello World!");
		
		buff.close();
	}
	
//	@Test
	public void testBuffer2() {
		byte delimiter = (byte) ';';
		byte innerDelimiter = (byte) ',';

		Buffer buffer = Buffer.wrap("a;b-1,b-2;c;d;");

		List<Buffer.View> views = buffer.split(delimiter);

		int viewCount = views.size();
		Assert.assertTrue(viewCount == 4);

		for (Buffer.View view : views) {
		    System.out.println(view.get().asString()); //prints "a" then "b-1,b-2", then "c" and finally "d"

		    if(view.get().indexOf(innerDelimiter) != -1) {
		      for(Buffer.View innerView : view.get().split(innerDelimiter)){
		        System.out.println(innerView.get().asString()); //prints "b-1" and "b-2"
		      }
		    }
		}
	}

	@Test
	public void TestStream() {
		Environment.initializeIfEmpty();
		String[] str = {"asdasd","aa","bb","cc" , "dd", "ee","ff","gfds","qwqw"};
		//find the top 10 words used in a list of Strings
		Streams.from(str)
		  .dispatchOn(Environment.sharedDispatcher())
		  .flatMap(sentence ->
		    Streams.from(sentence.split(" "))
		      .dispatchOn(Environment.cachedDispatcher())
		      .filter(word -> !word.trim().isEmpty())
		      .observe(word -> System.out.println(word))
		  )
		  .map(word -> Tuple.of(word, 1))
		  .window(1, TimeUnit.SECONDS)
		  .flatMap(words ->
		    BiStreams.reduceByKey(words, (prev, next) -> prev + next)
		      .sort((wordWithCountA, wordWithCountB) -> -wordWithCountA.t2.compareTo(wordWithCountB.t2))
		      .take(10)
		      .finallyDo(event -> System.out.println("---- window complete! ----"))
		  )
		  .consume(
		    wordWithCount -> System.out.println(wordWithCount.t1 + ": " + wordWithCount.t2),
		    error -> System.out.println( error)
		  );
		  
	}
 }
