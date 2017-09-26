package Views;

import Controllers.CartController;
import Models.Cart;
import SupportClasses.TableFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CartView extends JFrame{

    private JPanel _cartPanel;
    private JTable _table1;
    private JScrollPane _scrollPane1;
    private DefaultTableModel _model;
    private TableFactory _factory;
    private Cart _cart;
    CartController _cartController;


    public CartView(Cart c)
    {
        this.setContentPane(this._cartPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setSize(400, 400 );
        setupView(c);
    }

    public void setupView(Cart c){

        _factory = new TableFactory();

        _model = _factory.getTableModel("MainView");
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
        _scrollPane1.setViewportView(_table1);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    //
}
