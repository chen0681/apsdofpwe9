/**
 * 
 */
package com.free.testspring;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.cxf.common.util.StringUtils;
import org.junit.Test;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

/**
 * @author Administrator
 *
 */
public class ClassReaderTest {

	@Test
	public void testClassReader() throws IOException, SecurityException, NoSuchMethodException {
		
		LocalVariableTableParameterNameDiscoverer disconver = new LocalVariableTableParameterNameDiscoverer();
		
		Method getMethod =  TestVisitor.class.getDeclaredMethod("getVal", String.class,String.class);
		String[] str =  disconver.getParameterNames(getMethod);
		
		System.out.println();
	}
	
	public static class TestVisitor {
		public String getVal(String val1, String val2) {
			return null;
		}
	}
}
