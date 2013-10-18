package ru.unn.agile.dichotomy;
public class Dichotomy {
	private float a;
	private float b;
	private float sigma;
	private float eps;
	private IFunction f;
	
	public Dichotomy(float a, float b, float sigma, float eps, IFunction f) throws IllegalArgumentException
	{
		if (a>b)
		{
			throw new IllegalArgumentException("A more than B");
		}
		this.a = a;
		this.b = b;		
		
		if ((sigma<=0)||(sigma>=(b-a)/2))
		{
			throw new IllegalArgumentException("Sigma is incorrect");
		}
		this.sigma = sigma;
		
		if (eps < 0)
		{
			throw new IllegalArgumentException("Eps is negative");
		}

		this.eps = eps;
		
		this.f = f;
	}
	
	private float getCurrentSigma(float a, float b)
	{
		float ratio = this.sigma / (this.b - this.a);
		return (b-a)*ratio;
	}
	
	public float findMinimum()
	{
		float currentA = this.a, currentB = this.b;
		do{
			float currentSigma = this.getCurrentSigma(currentA, currentB);
			float x1 = (currentA+currentB-2*currentSigma)/2;
			float x2 = (currentA+currentB+2*currentSigma)/2;
			
			if (this.f.getValue(x1)>this.f.getValue(x2))
			{
				currentA = x1;
			}
			else 
			{
				currentB = x2;
			}
		}while(2*this.eps<(currentB - currentA));
		
		float middlePoint = (currentA + currentB)/2;
		return this.f.getValue(middlePoint);
	}
}
