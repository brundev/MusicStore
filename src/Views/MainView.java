package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by stefano on 16/09/17.
 */
public class MainView implements ActionListener, Observer {
    private JPanel mainPanel;
    private JButton cartButton;
    private JFormattedTextField usenameText ;
    private JPasswordField passwordText;
    private JList list1;

    public static void main(String args[])
    {
        JFrame frame = new JFrame("Music Store App");
        frame.setContentPane(new MainView().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1024, 1024 );
    }

    public MainView()
    {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("resources/cart.png"));
        Image image = imageIcon.getImage();
        imageIcon = new ImageIcon(image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
        cartButton.setIcon(imageIcon);
        cartButton.setSize(30, 100);
        cartButton.setText("");
        usenameText.setSize(30,300);
        passwordText.setSize(30,300);
        usenameText.setText("username");
        passwordText.setText("password");

        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //JOptionPane.showMessageDialog(null, "ayy lmao");
                //CartView cart = new CartView();
                CartView cartFrame = new CartView();
                //cartFrame.setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
