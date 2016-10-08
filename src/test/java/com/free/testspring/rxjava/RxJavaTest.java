package com.free.testspring.rxjava;

import org.junit.Test;

import rx.Observable;
import rx.functions.Action1;

public class RxJavaTest {

	@Test
	public void hello() {
		String[] names = {"11","22"};
		Observable.from("11").subscribe(new Action1<String>() {

	        @Override
	        public void call(String s) {
	            System.out.println("Hello " + s + "!");
	        }

	    });
	}
}
