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

public class CartView extends Observer {

    private JPanel _cartPanel;
    private JTable _table1;
    private JScrollPane _scrollPane;
    private DefaultTableModel _model;
    private TableFactory _factory;
    private Cart _cart;
    private CartController _cartController;


    public CartView(Cart c)
    {
        _cart = c;
        this.setContentPane(this._cartPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setSize(400, 400 );
        setupView(c);
    }

    public void setupView(Cart c)
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
        _cart = c;
       // _cart.attach(this);
        _cartController = new CartController(_cart);
        _table1.setVisible(true);
        _scrollPane.setViewportView(_table1);

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
            imageIcon = new ImageIcon(getClass().getResource(p.get_coverImage()));
            image = imageIcon.getImage();
            imageIcon = new ImageIcon(image.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
            row = new Object[]{imageIcon,p.get_title(), p.get_price() + " €", p.get_artist().get_name(), p.get_genre()};
            _model.addRow(row);
        }
    }

    //
}
