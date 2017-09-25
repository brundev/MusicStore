package Controllers;

import Models.Catalog;
import Models.Musician;
import Models.Product;
import SupportClasses.DBConnSingleton;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.Date;

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

            Array a = rs.getArray(3);
            ArrayList<String> b = new ArrayList(Arrays.asList(a));
            p.set_trackList(b);

            p.set_coverImage(rs.getString(4));
            p.set_price(rs.getFloat(5));
            p.set_firstAddedInStore(rs.getTimestamp(6).toLocalDateTime());
            p.set_description(rs.getString(7));

            //TODO artist
            p.set_genre(rs.getString(9));

            Array c = rs.getArray(10);
            ArrayList<Musician> d = new ArrayList(Arrays.asList(c));
            p.set_involvedArtists(d);

            Array e = rs.getArray(11);
            ArrayList<String> f = new ArrayList(Arrays.asList(e));
            p.set_usedInstruments(f);

            p.set_productStocks(rs.getInt(12));
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
            pst.setString(1, "%" + title + "%");
            setProductList(pst);

    }

    public void getProductByArtist(String name) throws SQLException
    {
            String q = "select * from products as p join musician as m on p.artist = m.id where m.name ilike ? or array_to_string(involvedartists, ?) ilike ?";
            PreparedStatement pst = DBConnSingleton.getConn().prepareStatement(q);
            pst.setString(1,"%" + name + "%");
            pst.setString(2,",");
            pst.setString(3,"%" + name + "%");
            setProductList(pst);

    }
}
