package SupportClasses;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Created by stef on 25/09/2017.
 */
public class CatalogTableModel extends DefaultTableModel {

    public CatalogTableModel()
    {
        super(null, new String[]{"Immagine", "Titolo", "Prezzo", "Descrizione", "Autore", "Genere"});
    }

    @Override
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }

}
