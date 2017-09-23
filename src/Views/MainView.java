package Views;

import Controllers.CatalogController;
import Models.Catalog;
import Models.Product;
import SupportClasses.Observer;
import SupportClasses.Subject;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;



/**
 * Created by stefano on 16/09/17.
 */
public class MainView extends Observer{
    private JPanel mainPanel;
    private JButton cartButton;
    private JFormattedTextField usernameText;
    private JPasswordField passwordText;
    private JButton loginButton;
    private JTable catalogTable;
    private JToolBar mainToolbar;
    private JLabel titleLabel;
    private JScrollPane scrollPane;
    private Catalog _catalog;
    DefaultTableModel _model;

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
        SetupView();
    }

    public void SetupView()
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
        //TableColumn testColumn = new TableColumn();
        //testColumn.setHeaderValue(String.valueOf("test"));

        //catalogTable.addColumn(testColumn);
        _model = new DefaultTableModel(1, 1);
        catalogTable = new JTable(_model);
        _catalog = new Catalog();
        _catalog.attach(this);
        CatalogController _catalogController = new CatalogController(_catalog);

        catalogTable.setVisible(true);
        scrollPane.setViewportView(catalogTable);

        cartButton.addActionListener(  e -> new CartView() );
        loginButton.addActionListener( e -> JOptionPane.showMessageDialog(null, "ayy lmao") ); //TODO gestire evento per login
    }

    @Override
    public void update(Subject obj)
    {
        _model.setRowCount(0);
        Object row[];
        _catalog = (Catalog)obj;
        for (Product p : _catalog.getCatalogProducts())
        {
            row = new Object[]{p.get_title()};
            _model.addRow(row);
        }
    }
}
