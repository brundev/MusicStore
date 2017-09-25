package SupportClasses;

import javax.swing.table.DefaultTableModel;

/**
 * Created by stef on 25/09/2017.
 */
public class CartTableModel extends DefaultTableModel{

    private String[] _columnNames = {"Titolo", "Immagine", "Prezzo", "Descrizione", "Autore", "Genere"};

    public CartTableModel() {
        DefaultTableModel a = new DefaultTableModel(null, _columnNames) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }};
    }


}
