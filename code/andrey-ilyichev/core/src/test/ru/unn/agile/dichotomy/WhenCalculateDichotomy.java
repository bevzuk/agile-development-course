package ru.unn.agile.dichotomy;

//import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.fail;

public class WhenCalculateDichotomy {

	public Dichotomy solver;
	
	@Test(expected=IllegalArgumentException.class)
	public void throwExceptionIfAMoreB()
	{
		float a = 3; 
		float b = 2;
		float sigma = 0.5F;
		float eps = 0.01F;
		IFunction function = new FunctionLnOfXplusOne();
		
		solver = new Dichotomy(a,b,sigma,eps,function);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void throwExceptionIfSigmaIsNegative()
	{
		float a = 1; 
		float b = 2;
		float sigma = -0.5F;
		float eps = 0.01F;
		IFunction function = new FunctionLnOfXplusOne();
		
		solver = new Dichotomy(a,b,sigma,eps,function);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void throwExceptionIfEpsIsNegative()
	{
		float a = 1; 
		float b = 2;
		float sigma = 0.5F;
		float eps = -0.01F;
		IFunction function = new FunctionLnOfXplusOne();
		
		solver = new Dichotomy(a,b,sigma,eps,function);
	}	
	
	@Test(expected=IllegalArgumentException.class)
	public void throwExceptionIfSigmaIsBig()
	{
		float a = 1; 
		float b = 2;
		float sigma = 0.5F;
		float eps = 10;
		IFunction function = new FunctionLnOfXplusOne();
		
		solver = new Dichotomy(a,b,sigma,eps,function);
	}	
	
	@Test
	public void getMinusOneIfFunctionIsSqrXminusOne()
	{
		float a = -1; 
		float b = 2;
		float sigma = 0.5F;
		float eps = 0.01F;
		IFunction function = new FunctionSqrXminusOne();
		
		solver = new Dichotomy(a,b,sigma,eps,function);
		float result = solver.findMinimum();
		
		assertEquals(-1,result,0.1);
	}

	@Test
	public void getZeroIfFunctionIsLnOfXplusOne()
	{
		float a = 0; 
		float b = 1;
		float sigma = 0.4F;
		float eps = 0.0001F;
		IFunction function = new FunctionLnOfXplusOne();
		
		solver = new Dichotomy(a,b,sigma,eps,function);
		float result = solver.findMinimum();
		
		assertEquals(0,result,0.1);
	}
}
