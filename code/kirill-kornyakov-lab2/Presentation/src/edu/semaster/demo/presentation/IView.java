package edu.semaster.demo.presentation;

public interface IView
{
    String getRe1();
    String getIm1();

    String getRe2();
    String getIm2();

    void setResult(String string);

    void setMessage(String string);
    String getMessage();

    String getResult();

    public enum Operation { ADD, MULTIPLY }
    Operation getOperation();

    void setCalcActionHandler(ClickHandler handler);
}
