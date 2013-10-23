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

    private ClickHandler m_addHandler;
    private ClickHandler m_multiplyHandler;

    public Calculator() {
        btnCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                m_addHandler.onClick();
            }
        });
    }

    public String getReal1()
    {
        return txtZ1Re.getText();
    }

    public String getImaginary1()
    {
        return txtZ1Im.getText();
    }

    public String getReal2()
    {
        return txtZ2Re.getText();
    }

    public String getImaginary2()
    {
        return txtZ2Im.getText();
    }

    public void setResult(String string)
    {
        txtZ3Re.setText(string);
        txtZ3Im.setText(string);
    }

    public void setAddActionHandler(ClickHandler handler)
    {
        m_addHandler = handler;
    }

    public void setMultiplyActionHandler(ClickHandler handler)
    {
        m_multiplyHandler = handler;
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
