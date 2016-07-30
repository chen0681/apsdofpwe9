package com.free.testspring;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class StreamTest {

	@Test
	public void testLib() {
		// String s =
		// Stream.of("1","2","3").collect(Collectors.joining(",","(",")"));
		// System.out.println(s);
		// IntStream.range(1, 3).forEach(System.out::println);
		// IntStream.rangeClosed(1, 3).forEach(System.out::println);
		// Stream.iterate(0, n -> n+1).limit(10).forEach(System.out::println);;

//		Stream<List<Integer>> inputStream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
//		Stream<Integer> outputStream = inputStream.flatMap((childList) -> childList.stream());
//		outputStream.forEach(System.out::println);
		
//		Stream.of("one", "two", "three", "four")
////		 .filter(e -> e.length() > 3)
//		 .peek(e -> System.out.println("Filtered value: " + e))
//		 .map(String::toUpperCase)
//		 .peek(e -> System.out.println("Mapped value: " + e))
//		 .collect(Collectors.toList());
		
//		Optional.ofNullable("xxxx").ifPresent(System.out::println);
//		
//		int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
		
		List<String> persons = new ArrayList<>();
		 for (int i = 1; i <= 5; i++) {
			 String person = new String("name" + i);
			 persons.add(person);
		 }
		List<String> personList2 = persons.stream().sorted((p1, p2) -> 
		p1.compareTo(p2)).limit(2).collect(Collectors.toList());
		System.out.println(personList2);
		
//		BufferedReader br = null;
//		br.lines()
	}
}
