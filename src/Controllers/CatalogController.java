package Controllers;

import Models.Catalog;
import Models.Product;
import SupportClasses.DBConnSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CatalogController
{
    private Catalog _catalog;

    public CatalogController(Catalog catalog)
    {
        _catalog = catalog;
        try
        {
            setProductList();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void setProductList() throws SQLException {
        //TODO query per ottenere la lista dei prodotti
        //simulo una query aggiungendo dei prodotti alla lista
        /*Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();
        p1.set_title("shadilay");
        p2.set_title("brainpower");
        p3.set_title("boh");
        _catalog.add(p1);
        _catalog.add(p2);
        _catalog.add(p3);*/

        Connection conn = DBConnSingleton.getConn();
        Statement stmt = conn.createStatement() ;
        String query = "select * from Product  ;" ;
        ResultSet rs = stmt.executeQuery(query) ;

        Product p;
        while(rs.next())
        {
            p = new Product();
            p.set_title(rs.getString(1));
            //TODO gestire immagine di copertina
            //p.set_coverImage( );
            p.set_price(rs.getFloat(3));
            p.set_description(rs.getString(4));
            //p.set_artist(rs.getString(5));
            p.set_genre(rs.getString(6));
            _catalog.add(p);
        }
    }

    public void getProductByGenre()
    {
        //TODO query
    }

    public void getProductByArtist()
    {
        //TODO query
    }

    public void getProductByInvolvedArtist()
    {
        //TODO query
    }

    //TODO altre possibili query
}
