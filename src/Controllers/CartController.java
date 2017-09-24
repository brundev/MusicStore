package Controllers;

import Models.Cart;
import Models.Product;
import SupportClasses.DBConnSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        Statement stmt = conn.createStatement() ;
        String query = "select product from Sale where sale.username = ;" ;
        ResultSet rs = stmt.executeQuery(query) ;



        Product p;

        ArrayList<String> rowValues = new ArrayList();



        while(rs.next())
        {
            p = new Product();
            p.set_code(rs.getString(1));
            p.set_title(rs.getString(2));
            //p.set_trackList (rs.getArray(3));

            rowValues.add(rs.getString(3));
            p.set_trackList(rowValues);

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
