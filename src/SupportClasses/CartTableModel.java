package SupportClasses;

import javax.swing.table.DefaultTableModel;

/**
 * Created by stef on 25/09/2017.
 */
public class CartTableModel extends DefaultTableModel{

    public CartTableModel()
    {
        super(null, new String[]{"Immagine", "Titolo", "Prezzo", "Autore", "Genere"});
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }


    @Override
    public boolean isCellEditable(int row, int column) {
        if(column==5)
            return true;
        return false;
    }


}
