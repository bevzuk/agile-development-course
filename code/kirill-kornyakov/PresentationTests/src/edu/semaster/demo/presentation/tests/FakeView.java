package edu.semaster.demo.presentation.tests;

import edu.semaster.demo.presentation.ClickHandler;
import edu.semaster.demo.presentation.IView;


public class FakeView implements IView
{
	public String m_real1;
	public String m_imaginary1;
	public String m_real2;
	public String m_imaginary2;
	public String m_result;

	public ClickHandler m_addActionHandler;
	public ClickHandler m_multiplyActionHandler;

	public String getReal1()
	{
		return m_real1;
	}

	public String getImaginary1()
	{
		return m_imaginary1;
	}

	public String getReal2()
	{
		return m_real2;
	}

	public String getImaginary2()
	{
		return m_imaginary2;
	}

	public void setResult(String string)
	{
		m_result = string;
	}

	public void setAddActionHandler(ClickHandler handler)
	{
		m_addActionHandler = handler;
	}

	public void setMultiplyActionHandler(ClickHandler handler)
	{
		m_multiplyActionHandler = handler;
	}
}
