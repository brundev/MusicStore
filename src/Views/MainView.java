package Views;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
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
    private JFormattedTextField usernameText;
    private JPasswordField passwordText;
    private JButton loginButton;
    private JTable catalogTable;
    private JToolBar mainToolbar;
    private JLabel titleLabel;
    private JScrollPane scrollPane;

    public static void main(String args[])
    {
        JFrame frame = new JFrame("Music Store App");
        frame.setContentPane(new MainView().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(900,900);
        frame.setVisible(true);
    }

    public MainView()
    {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("resources/cart.png"));
        Image image = imageIcon.getImage();
        imageIcon = new ImageIcon(image.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        cartButton.setIcon(imageIcon);
        cartButton.setSize(30, 100);
        cartButton.setText("");
        usernameText.setSize(40,300);
        passwordText.setSize(40,300);
        usernameText.setText("username");
        passwordText.setText("password");
        LineBorder lineBorder = new LineBorder(Color.white, 2, true);
        lineBorder.getRoundedCorners();
        usernameText.setBorder(lineBorder);
        passwordText.setBorder(lineBorder);
        cartButton.setFocusPainted(false);
        loginButton.setFocusPainted(false);
        loginButton.setBorder(lineBorder);
        int nmbrRows = 25;
        TableColumn testColumn = new TableColumn();
        testColumn.setHeaderValue((Object)String.valueOf("test"));
        DefaultTableModel model = new DefaultTableModel(1, 1);
        catalogTable.addColumn(testColumn);
        catalogTable = new JTable(model);
        Object row[] = {"test"};
        model.addRow(row);
        catalogTable.setVisible(true);
        scrollPane.setViewportView(catalogTable);

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

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null, "ayy lmao");
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
