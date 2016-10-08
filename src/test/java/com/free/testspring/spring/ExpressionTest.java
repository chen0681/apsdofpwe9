package com.free.testspring.spring;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class ExpressionTest {

	@Test
	public void testExpression() {
		Aldcc aa = new Aldcc();
		aa.setAa("bb");
		StandardEvaluationContext context = new StandardEvaluationContext(aa);
		ExpressionParser parser = new SpelExpressionParser();
		
		String valu = parser.parseExpression("aa == 'bb'").getValue(context, String.class);
		System.out.println(valu);
	}
	
	public static class  Aldcc {
		private String aa;

		public String getAa() {
			return aa;
		}

		public void setAa(String aa) {
			this.aa = aa;
		}
		
	}
}
