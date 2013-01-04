package edu.semaster.demo.presentation;

public interface IView
{
    String getReal1();
	String getImaginary1();

	String getReal2();
	String getImaginary2();

	void setResult(String string);

	void setAddActionHandler(ClickHandler handler);
	void setMultiplyActionHandler(ClickHandler handler);
}
