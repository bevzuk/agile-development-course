package edu.semaster.demo.model.tests;

import junit.framework.Assert;

import org.junit.Test;

import edu.semaster.demo.model.*;

public class FormatterTests {
	
	@Test (expected=IllegalArgumentException.class)
	public void throwsOnNegativeDouble() {
		double x = -1.0;
		Formatter.formatPositiveDouble(x);
	}
	
	@Test
	public void canFormatToIntegerWith6Digits()
	{
		double x = 123456.123;
		Assert.assertEquals("123456.12", Formatter.formatPositiveDouble(x));
	}
	
	@Test
	public void canConvertToString()
	{
		ComplexNumber z = new ComplexNumber(1, 2);
		Assert.assertEquals("1.0 + 2.0i", z.toString());
	}

	@Test
	public void canConvertFloatingComplexNumberToString()
	{
		ComplexNumber z = new ComplexNumber(3.14, 2);
		Assert.assertEquals("3.14 + 2.0i", z.toString());
	}

	@Test
	public void canConvertScientificFormatToString()
	{
		ComplexNumber z = new ComplexNumber(1, 1.2456e-2);
		Assert.assertEquals("1.0 + 0.01i", z.toString());
	}

	@Test
	public void canConvertNegativeRealPartToString()
	{
		ComplexNumber z = new ComplexNumber(-1, 1);
		Assert.assertEquals("-1.0 + 1.0i", z.toString());
	}

	@Test
	public void canConvertNegativeImaginaryPartToString()
	{
		ComplexNumber z = new ComplexNumber(1, -1);
		Assert.assertEquals("1.0 - 1.0i", z.toString());
	}
}
