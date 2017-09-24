package Controllers;

import Models.Catalog;
import Models.Product;
import SupportClasses.DBConnSingleton;

import java.math.BigDecimal;
import java.sql.*;

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

    public void setProductList() throws SQLException
    {
        String q = "select * from products as p join musician as m on p.artist = m.id;";
        PreparedStatement pst = DBConnSingleton.getConn().prepareStatement(q);
        setProductList(pst);
    }

    public void setProductList(PreparedStatement pst) throws SQLException
    {

        ResultSet rs = pst.executeQuery() ;
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

    public void getProductByGenre(String genre) throws SQLException
    {
            String q = "select * from products as p join musician as m on p.artist = m.id where p.genre ilike ?;";
            PreparedStatement pst = DBConnSingleton.getConn().prepareStatement(q);
            pst.setString(1, "%" + genre + "%");
            setProductList(pst);
    }

    public void getProductByPrice(String price) throws SQLException
    {
            String q = "select * from products as p join musician as m on p.artist = m.id where p.price <= ?;";
            PreparedStatement pst = DBConnSingleton.getConn().prepareStatement(q);
            pst.setBigDecimal(1, new BigDecimal(price));
            setProductList(pst);
    }

    public void getProductByTitle(String title) throws SQLException
    {
            String q = "select * from products as p join musician as m on p.artist = m.id where p.title ilike ?;";
            PreparedStatement pst = DBConnSingleton.getConn().prepareStatement(q);
            pst.setString(1, title + "%");
            setProductList(pst);

    }

    public void getProductByArtist(String name) throws SQLException
    {
            String q = "select * from products as p join musician as m on p.artist = m.id where m.name ilike ? or array_to_string(involvedartists, ?) ilike ?";
            PreparedStatement pst = DBConnSingleton.getConn().prepareStatement(q);
            pst.setString(1,name + "%");
            pst.setString(2,",");
            pst.setString(3,"%" + name + "%");
            setProductList(pst);

    }
}
