package com.free.testspring;

import java.io.IOException;
import java.io.PrintWriter;

public class ShellTest {

	public static void main(String[] args) throws IOException {
		Process proc = Runtime.getRuntime().exec("bash");
		
		PrintWriter pw = new PrintWriter(proc.getOutputStream());
		pw.println("export MAVEN_OPTS='-xms256 -xmx1024'");
		pw.println("");
	}
}
