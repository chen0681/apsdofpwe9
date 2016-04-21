package com.free.testspring.dubbo.service;

public class HelloServiceImpl implements HelloService{

	@Override
	public String sayHello(String word) {
		System.out.println("word is " + word);
		return "hello " + word;
	}

}
