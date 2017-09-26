package SupportClasses;

import javax.swing.table.DefaultTableModel;

/**
 * Created by stef on 25/09/2017.
 */
public class CartTableModel extends DefaultTableModel{

    public CartTableModel()
    {
        super(null, new String[]{"Immagine", "Titolo", "Prezzo", "Descrizione", "Autore", "Genere"});
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }


}
