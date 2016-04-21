package com.free.testspring;

import java.io.IOException;

public class FinalTest {

	public static void main(String[] args) throws IOException {
		 String val = "aaa";
		 final String val2 = val;
		 val = "bbbb";
		 val = "bbbb";
		System.out.println(val2 + "," + val);
		System.in.read();
	}
}
