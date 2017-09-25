package SupportClasses;

import javax.swing.table.DefaultTableModel;

/**
 * Created by stef on 25/09/2017.
 */
public class ProductTableModel extends DefaultTableModel{

    public ProductTableModel()
    {
        super(null, new String[]{"Titolo", "Immagine", "Prezzo", "Descrizione", "Autore", "Genere"});
    }

    @Override
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }
}
