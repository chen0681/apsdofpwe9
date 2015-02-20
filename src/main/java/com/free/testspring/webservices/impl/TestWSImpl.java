package com.free.testspring.webservices.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.free.testspring.webservices.ITestWS;

@WebService
public class TestWSImpl implements ITestWS{

	@WebMethod
	@Override
	public String getValue(String value) {
		// TODO Auto-generated method stub
		return value;
	}

}
