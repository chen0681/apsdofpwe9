package com.free.testspring;

public class JVMtest {

	public static void main(String args[]) {
		JVMtest test = new JVMtest();
		Subclass me = test.new Subclass();
		me.exampleMethod();
	}
	public class Superclass {
	    private void interestingMethod() {
	        System.out.println("Superclass's interesting method.");
	    }
	 
	    void exampleMethod() {
	        interestingMethod();
	    }
	}

	public class Subclass extends Superclass {
		
		public void interestingMethod() {
	        System.out.println("Subclass's interesting method.");
	    }
	}
}
