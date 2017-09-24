package Views;

import Controllers.CatalogController;
import Models.Catalog;
import Models.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProductView extends JFrame{
    private JPanel productPanel;
    private JTable productTable;
    private JScrollPane scrollPane;
    private Product _product;
    private DefaultTableModel _model;

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
        String[] columnNames = {"",""};
        _model = new DefaultTableModel(null, columnNames);
        productTable = new JTable(_model);
        productTable.setVisible(true);
        Object[] o = {"Titolo", _product.get_title()};
        _model.addRow(o);
        o = new Object[]{"Descrizione", _product.get_description()};
        _model.addRow(o);
        o = new Object[]{"Data Inserimento", _product.get_firstAddedInStore()};
        _model.addRow(o);
        o = new Object[]{"Prezzo", _product.get_price()};
        _model.addRow(o);
        productTable.setVisible(true);
        scrollPane.setViewportView(productTable);
    }
}
