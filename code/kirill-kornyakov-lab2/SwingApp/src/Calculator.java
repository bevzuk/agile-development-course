import edu.semaster.demo.presentation.ClickHandler;
import edu.semaster.demo.presentation.IView;
import edu.semaster.demo.presentation.Presenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements IView
{
    private JTextField txtZ1Re;
    private JTextField txtZ1Im;
    private JTextField txtZ2Re;
    private JTextField txtZ2Im;
    private JTextField txtZ3Re;
    private JTextField txtZ3Im;
    private JComboBox cbOperation;
    private JButton btnCalc;
    private JPanel mainPanel;
    private JLabel lbStatusLabel;
    private JLabel lbStatus;

    private ClickHandler calcHandler;

    public Calculator() {
        btnCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                calcHandler.onClick();
            }
        });
    }

    public String getRe1()
    {
        return txtZ1Re.getText();
    }

    public String getIm1()
    {
        return txtZ1Im.getText();
    }

    public String getRe2()
    {
        return txtZ2Re.getText();
    }

    public String getIm2()
    {
        return txtZ2Im.getText();
    }

    public Operation getOperation() {
        String operation = cbOperation.getSelectedItem().toString();

        if (operation.equals("Add"))
            return Operation.ADD;
        else if (operation.equals("Mul"))
            return Operation.MULTIPLY;

        return null;
    }

    public void setResult(String string)
    {
        txtZ3Re.setText(string);
        txtZ3Im.setText(string);
    }

    public String getMessage()
    {
        return lbStatus.getText();
    }

    public void setMessage(String message)
    {
        lbStatus.setText(message);
    }

    public void setCalcActionHandler(ClickHandler handler)
    {
        calcHandler = handler;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        new Presenter(calculator);

        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(calculator.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
