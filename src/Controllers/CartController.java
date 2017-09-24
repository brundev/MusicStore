package Controllers;

import Models.Cart;
import Models.Product;
import SupportClasses.DBConnSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stefano on 23/09/17.
 */
public class CartController {

    private Cart _cart;

    public CartController(Cart c)
    {
        _cart = c;

        try
        {
            setCart();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //TODO
    public void setCart() throws SQLException{

        String cartUser = _cart.get_user().get_username();

        Connection conn = DBConnSingleton.getConn();
        String query = "select products from sale where sale.username ILIKE 'john';";
        PreparedStatement stmt = conn.prepareStatement(query);
       // stmt.setString( 1,"john");
        ResultSet rs = stmt.executeQuery();

        Array a = rs.getArray(1);
        String[] nullable = (String[])a.getArray();

        System.out.println(nullable[0]);



        Product p;


        while(rs.next())
        {
            p = new Product();
            p.set_code(rs.getString(1));
            p.set_title(rs.getString(2));
            //p.set_trackList (rs.getArray(3));

            //rowValues.add(rs.getString(3));
            //p.set_trackList(rowValues);

            p.set_price(rs.getFloat(5));
            p.set_description(rs.getString(7));
            p.set_genre(rs.getString(9));
            //p.set_artist(rs.getString(14));
            _cart.addToCart(p);
        }

    }


    //TODO
    //public void addToCart(Product p)
    //

    //TODO
    //public void removeFromCart(Product p)
    //
}
