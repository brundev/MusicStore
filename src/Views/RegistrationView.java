package Views;

import javax.swing.*;

/**
 * Created by stefano on 26/09/17.
 */
public class RegistrationView extends JFrame{

    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button3;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;


    public RegistrationView()
    {
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setSize(500, 500 );
    }
}
