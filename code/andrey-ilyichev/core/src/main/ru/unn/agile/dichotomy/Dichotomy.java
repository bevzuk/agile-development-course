package ru.unn.agile.dichotomy;
public class Dichotomy {
	private float a;
	private float b;
	private float sigma;
	private float eps;
	private IFunction function;
	
	public Dichotomy(DichotomyParametr parametr) throws IllegalArgumentException{
		if (parametr.getA()>parametr.getB())
		{
			throw new IllegalArgumentException("A more than B");
		}
		this.a = parametr.getA();
		this.b = parametr.getB();		
		
		if ((parametr.getSigma()<=0)||(parametr.getSigma()>=(parametr.getB()-parametr.getA())/2))
		{
			throw new IllegalArgumentException("Sigma is incorrect");
		}
		this.sigma = parametr.getSigma();
		
		if (parametr.getEps() < 0)
		{
			throw new IllegalArgumentException("Eps is negative");
		}

		this.eps = parametr.getEps();
		
		this.function = parametr.getFunction();
	}
	
	private float getCurrentSigma(float a, float b){
		float ratio = this.sigma / (this.b - this.a);
		return (b-a)*ratio;
	}
	
	public float findMinimum(){
		float currentA = this.a, currentB = this.b;
		do{
			float currentSigma = this.getCurrentSigma(currentA, currentB);
			float x1 = (currentA+currentB-2*currentSigma)/2;
			float x2 = (currentA+currentB+2*currentSigma)/2;
			
			if (this.function.getValue(x1)>this.function.getValue(x2))
			{
				currentA = x1;
			}
			else 
			{
				currentB = x2;
			}
		}while(2*this.eps<(currentB - currentA));
		
		float middlePoint = (currentA + currentB)/2;
		return this.function.getValue(middlePoint);
	}
}
