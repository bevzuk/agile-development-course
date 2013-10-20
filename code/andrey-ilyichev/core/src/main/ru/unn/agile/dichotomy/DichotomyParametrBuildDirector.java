package ru.unn.agile.dichotomy;

public class DichotomyParametrBuildDirector{

	public void constructDichotomyParametr(DichotomyParametrBuilder dichotomyParametrBuilder){
		dichotomyParametrBuilder.buildA();
		dichotomyParametrBuilder.buildB();
		dichotomyParametrBuilder.buildEps();
		dichotomyParametrBuilder.buildSigma();
		dichotomyParametrBuilder.buildFunction();
	}
}
