package Views;

import Controllers.CatalogController;
import Models.Catalog;
import Models.Product;
import SupportClasses.TableFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ProductView extends JFrame{
    private JPanel productPanel;
    private JTable productTable;
    private JScrollPane scrollPane;
    private Product _product;
    private DefaultTableModel _model;
    private TableFactory _factory;

    public ProductView(Product product)
    {
        _product = product;
        this.setContentPane(this.productPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setSize(400, 400 );
        SetupView();
    }

    public void SetupView()
    {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(_product.get_coverImage()));
        Image image = imageIcon.getImage();
        imageIcon = new ImageIcon(image.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        _model = new DefaultTableModel(null, new String[]{"",""});
        //_model = _factory.getTableModel("ProductView");
        productTable = new JTable(_model)
        {
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };
        productTable.setVisible(true);
        //Object[] o = {imageIcon};
        //_model.addRow(o);
        Object[] o = new Object[]{"Titolo", _product.get_title()};
        _model.addRow(o);
        o = new Object[]{"Descrizione", _product.get_description()};
        _model.addRow(o);
        o = new Object[]{"Data Inserimento", _product.get_firstAddedInStore()};
        _model.addRow(o);
        o = new Object[]{"Prezzo", _product.get_price()};
        _model.addRow(o);
        productTable.setRowHeight(60);
        productTable.setVisible(true);
        scrollPane.setViewportView(productTable);
    }
}
