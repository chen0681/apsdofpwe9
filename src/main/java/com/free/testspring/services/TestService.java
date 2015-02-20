package com.free.testspring.services;


public class TestService implements ITestService {

	public TestService() {
		System.out.println("");
	}

	@Override
	public String testValue(String value) {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public String testValue(String value1, String value2) {
		// TODO Auto-generated method stub
		return value1+ "_" + value2;
	}
}
