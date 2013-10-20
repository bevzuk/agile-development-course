package ru.unn.agile.dichotomy;

public class DichotomyParametrBuilderWithWrongAB extends DichotomyParametrBuilder{
	protected DichotomyParametr parametr = new DichotomyParametr();
	
	@Override
	public void buildA(){
		this.parametr.setA(3);
	}

	@Override
	public void buildB(){
		this.parametr.setB(2);
	}

	@Override
	public void buildEps(){
		this.parametr.setEps(0.01F);	
	}

	@Override
	public void buildSigma(){
		this.parametr.setSigma(0.5F);	
	}

	@Override
	public void buildFunction(){
		this.parametr.setFunction(new FunctionLnOfXplusOne());
	}
	
	public DichotomyParametr getDichotomyParametr(){
		return this.parametr;
	}
}
