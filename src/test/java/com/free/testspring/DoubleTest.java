package com.free.testspring;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

public class DoubleTest {

	@Test
	public void testD() {
		double d1 = 0.01, d2 = 0.02, d3 = 0.03;
		int a1 = 5, a2 = 3, a3 = 4;
		
		BigDecimal bd1 = BigDecimal.valueOf(d1).multiply(new BigDecimal(a1));
		BigDecimal bd2 = BigDecimal.valueOf(d2).multiply(new BigDecimal(a2));
		BigDecimal bd3 = BigDecimal.valueOf(d3).multiply(new BigDecimal(a3));
		
		BigDecimal total = bd1.add(bd2).add(bd3);
		BigDecimal result = total.divide(BigDecimal.valueOf(10)).multiply(BigDecimal.valueOf(9));
		
		System.out.println("result=" + result +"," + result.setScale(2, RoundingMode.HALF_UP));
	}
}
