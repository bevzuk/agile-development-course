package edu.semaster.demo.presentation.tests;

import edu.semaster.demo.presentation.ClickHandler;
import edu.semaster.demo.presentation.IView;


public class FakeView implements IView
{
    public String re1;
    public String im1;
    public String re2;
    public String im2;
    public Operation op;
    public String result;

    public ClickHandler calcActionHandler;
    private String message;

    public FakeView() {
        op = Operation.ADD;
    }

    public String getRe1() {
        return re1;
    }

    public String getIm1() {
        return im1;
    }

    public String getRe2() {
        return re2;
    }

    public String getIm2() {
        return im2;
    }

    public void setResult(String string) {
        result = string;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Operation getOperation() {
        return op;
    }

    public void setCalcActionHandler(ClickHandler handler) {
        calcActionHandler = handler;
    }
}
