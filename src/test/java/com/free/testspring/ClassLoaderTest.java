package com.free.testspring;

import org.junit.Test;

public class ClassLoaderTest {
	
	@Test
	public void 	testClassLoader() throws ClassNotFoundException {
		ClassLoader clsLoader = new CustomClassLoader();
		Class<?> cls = clsLoader.loadClass("com.free.testspring.xxxxx");
		System.out.println();
	}
	
	
	public static class CustomClassLoader extends ClassLoader {
		@Override
		protected Class<?> findClass(String name) throws ClassNotFoundException {
			// TODO Auto-generated method stub
			return super.findClass(name);
		}
		
		@Override
		public Class<?> loadClass(String name) throws ClassNotFoundException {
			// TODO Auto-generated method stub
			
			return super.loadClass(name);
		}
		
	}
}
