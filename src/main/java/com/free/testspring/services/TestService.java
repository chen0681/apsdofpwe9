package com.free.testspring.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.free.testspring.dao.UsersDao;
import com.mongodb.util.JSON;

@Service
public class TestService implements ITestService {

	@Autowired
	private UsersDao usersDao;

	@Override
	public String testValue(String value) {
		// TODO Auto-generated method stub
		Long count = usersDao.getTestData();
	
		return String.valueOf(count);
	}
	@Override
	public String testValue(String value1, String value2) {
		// TODO Auto-generated method stub
		return value1 + "_" + value2;
	}
}
