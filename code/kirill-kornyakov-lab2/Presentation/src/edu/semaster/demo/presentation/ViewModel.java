package edu.semaster.demo.presentation;

import edu.semaster.demo.model.ComplexNumber;

public class ViewModel
{
    public String re1;
    public String im1;
    public String re2;
    public String im2;

    public enum Operation { ADD, MULTIPLY }
    public Operation op;
    public String result;
    public String message;

    public ClickHandler calcActionHandler;

    public ViewModel() {
        op = Operation.ADD;

        setCalcActionHandler(new ClickHandler() {
            public void onClick() {
                ViewModel.this.processCalcAction();
            }
        });
    }

    public void setCalcActionHandler(ClickHandler handler) {
        calcActionHandler = handler;
    }

    private void processCalcAction()
    {
        bind();

        ComplexNumber z1, z2;
        try {
            z1 = convertToComplexNumber(re1, im1);
            z2 = convertToComplexNumber(re2, im2);
        }
        catch (Exception e) {
            result = "NA";
            message = "Bad Format";
            unbind();
            return;
        }

        ComplexNumber resultZ = new ComplexNumber();
        switch (op) {
            case ADD:
                resultZ = z1.add(z2);
                break;
            case MULTIPLY:
                resultZ = z1.multiply(z2);
                break;
        }

        result = resultZ.toString();
        message = "Success";

        unbind();
    }

    private void bind() {}
    private void unbind() {}

    public ComplexNumber convertToComplexNumber(String re, String im) {
        return new ComplexNumber(Double.parseDouble(re), Double.parseDouble(im));
    }
}
