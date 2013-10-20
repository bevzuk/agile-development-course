package ru.unn.agile.dichotomy;

public class DichotomyParametr{
	private float a;
	private float b;
	private float sigma;
	private float eps;
	private IFunction function;
	
	public DichotomyParametr(){
		this(0,0,0,0,null);
	}
	public DichotomyParametr(float a, float b, float sigma, float eps, IFunction function){
		this.setA(a);
		this.setB(b);
		this.setSigma(sigma);
		this.setEps(eps);
		this.setFunction(function);
	}
	
	public float getA(){
		return a;
	}
	public void setA(float a){
		this.a = a;
	}
	
	public float getB(){
		return b;
	}
	public void setB(float b){
		this.b = b;
	}
	
	public float getSigma(){
		return sigma;
	}
	public void setSigma(float sigma){
		this.sigma = sigma;
	}
	
	public float getEps(){
		return eps;
	}
	public void setEps(float eps){
		this.eps = eps;
	}
	
	public IFunction getFunction(){
		return function;
	}
	public void setFunction(IFunction function){
		this.function = function;
	}
}
