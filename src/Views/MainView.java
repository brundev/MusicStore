package Views;

import Controllers.CartController;
import Controllers.CatalogController;
import Models.*;
import SupportClasses.DBConnSingleton;
import SupportClasses.LoginManager;
import SupportClasses.Observer;
import SupportClasses.Subject;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;


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
    private JComboBox comboBox;
    private JTextField searchText;
    private JButton searchButton;
    private JButton registerButton;
    private Catalog _catalog;
    private CatalogController _catalogController;
    private DefaultTableModel _model;
    private LoginManager _loginManager;
    private Cart _cart;
    private CartController _cartController;
    private User _user;

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
        SetupDBConn();
        SetupView();
        _loginManager = new LoginManager();
    }

    public void SetupView()
    {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("resources/cart.png"));
        Image image = imageIcon.getImage();
        imageIcon = new ImageIcon(image.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        cartButton.setIcon(imageIcon);
        cartButton.setSize(30, 100);
        cartButton.setText("");

        comboBox.addItem("");
        comboBox.addItem("Artista");
        comboBox.addItem("Genere");
        comboBox.addItem("Prezzo");
        comboBox.addItem("Nome CD/DVD");

        searchButton.setFocusPainted(false);

        usernameText.setSize(40,300);
        passwordText.setSize(40,300);

        usernameText.setText("username");
        passwordText.setText("password");

        LineBorder lineBorder = new LineBorder(Color.white, 2, true);
        lineBorder.getRoundedCorners();

        usernameText.setBorder(lineBorder);

        passwordText.setBorder(lineBorder);

        cartButton.setFocusPainted(false);

        registerButton.setFocusPainted(false);
        registerButton.setBorder(lineBorder);
        loginButton.setFocusPainted(false);
        loginButton.setBorder(lineBorder);

        //catalogTable.addColumn(testColumn);
        String[] columnNames = {"Titolo", "Immagine", "Prezzo", "Descrizione", "Autore", "Genere"};
        _model = new DefaultTableModel(null, columnNames);
        catalogTable = new JTable(_model);
        _catalog = new Catalog();
        _catalog.attach(this);
        _catalogController = new CatalogController(_catalog);

        catalogTable.setVisible(true);
        scrollPane.setViewportView(catalogTable);

        catalogTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = catalogTable.rowAtPoint(evt.getPoint());
                new ProductView(_catalog.getCatalogProducts().get(row));
            }
        });

        usernameText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usernameText.setText("");
            }
        });

        passwordText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordText.setText("");
            }
        });


        cartButton.addActionListener(e -> onCartButtonClicked());

        //TODO gestire evento per login
        loginButton.addActionListener( e -> makeLogin() );
        registerButton.addActionListener( e -> JOptionPane.showMessageDialog(null, "Registrazione da fare"));//TODO registrazione
        searchButton.addActionListener(e -> onSearchButtonClicked());
    }

    public static void SetupDBConn()
    {
        DBConnSingleton.getInstance();
    }

    public void onCartButtonClicked()
    {
        if(_user!=null)
        {
            if(_user.get_isEmployee())
            {
                //TODO vista della schermata gestione employee
            }
            else
            {
                new CartView();
            }
        }
    }

    public void makeLogin()
    {
        if(_loginManager.checkUser(usernameText.getText(), passwordText.getText()))
        {
            _user = _loginManager.getUser();

            if(!_user.get_isEmployee()) {
                _cart = new Cart(_user);
                _cartController = new CartController(_cart);
                JOptionPane.showMessageDialog(null, "Loggato come Cliente");
            }
            else
            {
                ImageIcon imageIcon = new ImageIcon(getClass().getResource("resources/gear.png"));
                Image image = imageIcon.getImage();
                imageIcon = new ImageIcon(image.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
                cartButton.setIcon(imageIcon);
                JOptionPane.showMessageDialog(null, "Loggato come Impiegato");
            }

        }
        else
        {
            JOptionPane.showMessageDialog(null, "username o password non validi");
        }
    }

    public void onSearchButtonClicked()
    {
        try {
            switch ((String) comboBox.getSelectedItem()) {
                case "":
                    _catalogController.setProductList();
                    break;
                case "Artista":
                    _catalogController.getProductByArtist(searchText.getText());
                    break;
                case "Genere":
                    _catalogController.getProductByGenre(searchText.getText());
                    break;
                case "Prezzo":
                    _catalogController.getProductByPrice(searchText.getText());
                    break;
                case "Nome CD/DVD":
                    _catalogController.getProductByTitle(searchText.getText());
                    break;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Subject obj)
    {
        _model.setRowCount(0);
        Object row[];
        _catalog = (Catalog)obj;
        for (Product p : _catalog.getCatalogProducts())
        {
            row = new Object[]{p.get_title(), p.get_coverImage(), p.get_price() + " €", p.get_description(), p.get_artist(), p.get_genre()};
            _model.addRow(row);
        }
    }
}
