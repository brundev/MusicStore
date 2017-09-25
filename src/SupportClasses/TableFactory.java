package SupportClasses;

import Models.Product;

import javax.swing.table.TableModel;

/**
 * Created by stef on 25/09/2017.
 */
public class TableFactory {

    public TableModel getTableModel(String table){

        if (table.equals("mainView")){
            return new CatalogTableModel();
        }

        if (table.equals("CartView"))
        {
            return new CartTableModel();
        }

        if (table.equals("ProductView")){
            return new ProductTableModel();
        }

        return null;
    }
}
