package SupportClasses;

import javax.swing.table.DefaultTableModel;

/**
 * Created by stef on 25/09/2017.
 */
public class CartTableModel extends DefaultTableModel{

    private String[] _columnNames = {"Titolo", "Immagine", "Prezzo", "Descrizione", "Autore", "Genere"};

    public CartTableModel()
    {
        super(null, new String[]{"Titolo", "Immagine", "Prezzo", "Descrizione", "Autore", "Genere"});
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }


}
