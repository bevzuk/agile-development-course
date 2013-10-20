package ru.unn.agile.dichotomy;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

public class WhenCalculateDichotomy{

	private Dichotomy solver;
	private DichotomyParametr parametr;
	private DichotomyParametrBuildDirector dichotomyParametrBuildDirector;
	
	@Before
	public void SetUp(){
		dichotomyParametrBuildDirector = new DichotomyParametrBuildDirector();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void throwExceptionIfAMoreB(){
		DichotomyParametrBuilder dichotomyParametrBuilder = new DichotomyParametrBuilderWithWrongAB();
		dichotomyParametrBuildDirector.constructDichotomyParametr(dichotomyParametrBuilder);
		parametr = dichotomyParametrBuilder.getDichotomyParametr();
		
		solver = new Dichotomy(parametr);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void throwExceptionIfSigmaIsNegative(){
		DichotomyParametrBuilder dichotomyParametrBuilder = new DichotomyParametrBuilderWithNegativeSigma();
		dichotomyParametrBuildDirector.constructDichotomyParametr(dichotomyParametrBuilder);
		parametr = dichotomyParametrBuilder.getDichotomyParametr();
		
		solver = new Dichotomy(parametr);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void throwExceptionIfEpsIsNegative(){
		DichotomyParametrBuilder dichotomyParametrBuilder = new DichotomyParametrBuilderWithNegativeEps();
		dichotomyParametrBuildDirector.constructDichotomyParametr(dichotomyParametrBuilder);
		parametr = dichotomyParametrBuilder.getDichotomyParametr();
		
		solver = new Dichotomy(parametr);
	}	
	
	@Test(expected=IllegalArgumentException.class)
	public void throwExceptionIfSigmaIsBig(){
		DichotomyParametrBuilder dichotomyParametrBuilder = new DichotomyParametrBuilderWithBigSigma();
		dichotomyParametrBuildDirector.constructDichotomyParametr(dichotomyParametrBuilder);
		parametr = dichotomyParametrBuilder.getDichotomyParametr();
		
		solver = new Dichotomy(parametr);
	}	
	
	@Test
	public void getMinusOneIfFunctionIsSqrXminusOne(){
		parametr = new DichotomyParametr(-1, 2, 0.5F, 0.01F, new FunctionSqrXminusOne());
		solver = new Dichotomy(parametr);
		
		float result = solver.findMinimum();

		assertEquals(-1,result,0.1);
	}

	@Test
	public void getZeroIfFunctionIsLnOfXplusOne(){
		parametr = new DichotomyParametr(0, 1, 0.4F, 0.001F, new FunctionLnOfXplusOne());
		solver = new Dichotomy(parametr);
		
		float result = solver.findMinimum();

		assertEquals(0,result,0.1);
	}
}
