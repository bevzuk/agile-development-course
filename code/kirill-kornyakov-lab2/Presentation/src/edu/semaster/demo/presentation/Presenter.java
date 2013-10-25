package edu.semaster.demo.presentation;

import edu.semaster.demo.model.ComplexNumber;

public class Presenter
{
    private IView view;

    public Presenter(IView view)
    {
        this.view = view;
        this.view.setCalcActionHandler(new ClickHandler() {
            public void onClick() {
                Presenter.this.processCalcAction();
            }
        });
    }

    private void processCalcAction()
    {
        ComplexNumber z1, z2;
        try {
            z1 = convertToComplexNumber(view.getRe1(), view.getIm1());
            z2 = convertToComplexNumber(view.getRe2(), view.getIm2());
        }
        catch (Exception e) {
            view.setMessage("Bad Format");
            view.setResult("NA");
            return;
        }

        ComplexNumber result = new ComplexNumber();
        switch (view.getOperation()) {
            case ADD:
                result = z1.add(z2);
                break;
            case MULTIPLY:
                result = z1.multiply(z2);
                break;
        }

        view.setResult(result.toString());
        view.setMessage("Success");
    }
    
    public ComplexNumber convertToComplexNumber(String re, String im) {
        return new ComplexNumber(Double.parseDouble(re), Double.parseDouble(im));
    }
}
