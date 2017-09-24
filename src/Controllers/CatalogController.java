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
            setProductList("select * from products as p join musician as m on p.artist = m.id;");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void setProductList(String q) throws SQLException
    {

        Connection conn = DBConnSingleton.getConn();
        Statement stmt = conn.createStatement() ;
        String query = q;
        ResultSet rs = stmt.executeQuery(query) ;
        _catalog.clear();

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

    public void getProductByGenre(String genre)
    {
        try
        {
            setProductList("select * from products as p join musician as m on p.artist = m.id where p.genre ="+ genre +";");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void getProductByArtist()
    {
        //TODO query
    }

    //TODO altre possibili query
}
