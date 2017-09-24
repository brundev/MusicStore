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
        _catalog = new Catalog();
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

        Connection conn = DBConnSingleton.getConn();
        Statement stmt = conn.createStatement() ;
        String query = "select * from products as p join musician as m on p.artist = m.id;" ;
        ResultSet rs = stmt.executeQuery(query) ;

        Product p;
        while(rs.next())
        {
            p = new Product();
            p.set_title(rs.getString(2));
            //TODO gestire immagine di copertina
            p.set_price(rs.getFloat(5));
            p.set_description(rs.getString(7));
            p.set_genre(rs.getString(9));
            //p.set_artist(rs.getString(14));
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
