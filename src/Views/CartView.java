package Views;

import Controllers.CartController;
import Models.Cart;
import Models.Catalog;
import Models.Product;
import SupportClasses.Observer;
import SupportClasses.Subject;
import SupportClasses.TableFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartView extends Observer {

    private JPanel _cartPanel;
    private JTable _table1;
    private JScrollPane _scrollPane;
    private JButton compraButton;
    private JButton eliminaButton;
    private DefaultTableModel _model;
    private TableFactory _factory;
    private Cart _cart;
    private CartController _cartController;


    public CartView(Cart c)
    {
        _cart = c;
        this.setContentPane(this._cartPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
              // _cart.resetCart();
            }
        });

        this.pack();
        this.setVisible(true);
        this.setSize(400, 400 );

        setupView();

    }

    public void setupView()
    {
        _cart.attach(this);

        _factory = new TableFactory();

        _model = _factory.getTableModel("CartView");
        _table1 = new JTable(_model)
        {
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };

        _table1.setRowHeight(60);
        _cartController = new CartController(_cart);
        _table1.setVisible(true);
        _scrollPane.setViewportView(_table1);
        try
        {
            _cartController.setCart();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        eliminaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < _model.getRowCount(); i++) {

                        ArrayList<Product> a = _cart.get_cartList();
                        Product p =a.get(i);
                        _cartController.removeFromCart(p);
                }
            }
        });

        compraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                new BuyView(_cart);

            }
        });

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    @Override
    public void update(Subject cart)
    {
        _model.setRowCount(0);
        Object row[];
        _cart = (Cart)cart;
        ImageIcon imageIcon;
        Image image;
        for (Product p : _cart.get_cartList())
        {
            if(!(p.get_code() == 0))
            {
                imageIcon = new ImageIcon(getClass().getResource(p.get_coverImage()));
                image = imageIcon.getImage();
                imageIcon = new ImageIcon(image.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
                row = new Object[]{imageIcon, p.get_title(), p.get_price() + " €", p.get_artist().get_name(), p.get_genre(),false};
                _model.addRow(row);
            }
        }
    }

    //
}
