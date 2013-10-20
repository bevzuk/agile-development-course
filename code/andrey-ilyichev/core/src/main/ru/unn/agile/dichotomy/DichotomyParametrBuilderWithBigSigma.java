package ru.unn.agile.dichotomy;

public class DichotomyParametrBuilderWithBigSigma extends DichotomyParametrBuilder{
	protected DichotomyParametr parametr = new DichotomyParametr();
	
	@Override
	public void buildA(){
		this.parametr.setA(1);
	}

	@Override
	public void buildB(){
		this.parametr.setB(2);
	}

	@Override
	public void buildEps(){
		this.parametr.setEps(10);
	}

	@Override
	public void buildSigma(){
		this.parametr.setSigma(1.0F);
	}

	@Override
	public void buildFunction(){
		this.parametr.setFunction(new FunctionLnOfXplusOne());
	}

	@Override
	public DichotomyParametr getDichotomyParametr(){
		return this.parametr;
	}
}
