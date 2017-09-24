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
        String query = "select products from sale where sale.username ILIKE ?;";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString( 1,cartUser);
        ResultSet rs = stmt.executeQuery();

        rs.next();
        Array a = rs.getArray(1);
        Integer b []= (Integer[])a.getArray();

        System.out.println(b[1]);

        Product p;

        for(int i=0;i<b.length;i++)
        {

            query = "select title,price,coverimage from Products where id = ?;";
            stmt = conn.prepareStatement(query);
            stmt.setInt( 1,b[i]);
            rs = stmt.executeQuery();

            rs.next();

            p = new Product();
            p.set_code(Integer.toString(b[i]));
            p.set_title(rs.getString(1));
            p.set_price(rs.getFloat(2));
            p.set_coverImage(rs.getString(3));
            _cart.addToCart(p);
        }

    }



   /* public void addToCart(Product p){


        try {
            Connection conn = DBConnSingleton.getConn();
            String query = "select products from sale where sale.username ILIKE ?;";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, );
            ResultSet rs = stmt.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }*/


    //TODO
    //public void removeFromCart(Product p)
    //
}
