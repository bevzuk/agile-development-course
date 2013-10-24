package edu.semaster.demo.presentation.tests;

import static junit.framework.Assert.*;

import edu.semaster.demo.presentation.IView;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.semaster.demo.model.ComplexNumber;
import edu.semaster.demo.presentation.Presenter;

public class PresenterTests
{
    private FakeView view;
    private Presenter presenter;

    @Before
    public void setUp()
    {
        view = new FakeView();
        presenter = new Presenter(view);
    }

    @After
    public void tearDown()
    {
        view = null;
    }

    @Test
    public void canConvertStringToComplexNumber()
    {
        String realString = "10";
        String imaginaryString = "20";
        ComplexNumber convertedNumber = presenter
                .convertToComplexNumber(realString,
                        imaginaryString);
        assertEquals(new ComplexNumber(10, 20), convertedNumber);
    }

    @Test
    public void canConvertStringToComplexNumberWithFloatingPointNumbers()
    {
        String realString = "3.14";
        String imaginaryString = "-1e3";
        ComplexNumber convertedNumber = presenter
                .convertToComplexNumber(realString,
                        imaginaryString);
        assertEquals(new ComplexNumber(3.14, -1e3),
                convertedNumber);
    }

    @Test
    public void canPerformCalcAction()
    {
        view.re1 = "1";   view.im1 = "2";
        view.re2 = "-10"; view.im2 = "-20";
        view.op = IView.Operation.ADD;

        view.calcActionHandler.onClick();

        assertEquals("-9.0 - 18.0i", view.result);
    }

    @Test
    public void canSetSuccessMessage()
    {
        view.re1 = "0"; view.im1 = "0";
        view.re2 = "0"; view.im2 = "0";

        view.calcActionHandler.onClick();

        assertEquals("Success", view.getMessage());
    }

    @Test
    public void canSetBadFormatMessage()
    {
        view.re1 = "a";

        view.calcActionHandler.onClick();

        assertEquals("Bad Format", view.getMessage());
    }

    @Test
    public void canMultiplyNumbers()
    {
        view.re1 = "1"; view.im1 = "0";
        view.re2 = "2"; view.im2 = "0";
        view.op = IView.Operation.MULTIPLY;

        view.calcActionHandler.onClick();

        assertEquals("2.0 + 0.0i", view.result);
    }

    @Test
    public void canPerformAddActionWithRealNumbers()
    {
        view.re1 = "1.2";   view.im1 = "2.3";
        view.re2 = "-10.4"; view.im2 = "-20.5";

        view.calcActionHandler.onClick();

        assertEquals("-9.2 - 18.2i", view.result);
    }
}
