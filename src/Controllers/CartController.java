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

        Product p;

        for(int i=0;i<b.length;i++)
        {

            query = "select title,price,coverimage from Products where id = ?;";
            stmt = conn.prepareStatement(query);
            stmt.setInt( 1,b[i]);
            rs = stmt.executeQuery();

            rs.next();

            p = new Product();
            p.set_code((b[i]));
            p.set_title(rs.getString(1));
            p.set_price(rs.getFloat(2));
            p.set_coverImage(rs.getString(3));
            _cart.addToCart(p);
        }
    }



    public void addToCart(Product p){

        String cartUser = _cart.get_user().get_username();

        try {
            Connection conn = DBConnSingleton.getConn();
            String query = "select products from sale where sale.username ILIKE ?;";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,cartUser);
            ResultSet rs = stmt.executeQuery();
            rs.next();

            Array a = rs.getArray(1);
            Integer b []= (Integer[])a.getArray();
            Integer c[] = new Integer[b.length+1];

            for(int i=0;i<b.length;i++){
                c[i]=b[i];
            }

            c[b.length]=p.get_code();

            query = "UPDATE sale SET products = '"+conn.createArrayOf(a.getBaseTypeName(),c)+"' where sale.username ILIKE ?;";
            stmt = conn.prepareStatement(query);
            stmt.setString(1,cartUser);
            stmt.executeUpdate();

            _cart.addToCart(p);


        }catch (SQLException e){
            e.printStackTrace();
        }

    }


    //TODO
    public void removeFromCart(Product p){

        String cartUser = _cart.get_user().get_username();

        try {
            Connection conn = DBConnSingleton.getConn();
            String query = "select products from sale where sale.username ILIKE ?;";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,cartUser);
            ResultSet rs = stmt.executeQuery();
            rs.next();

            Array a = rs.getArray(1);
            Integer b []= (Integer[])a.getArray();
            Integer c[] = new Integer[b.length-1];

            int ct=0;
            int position= 0;
            boolean removed=false;

            for(int i=0;i<b.length;i++){
                if(p.get_code()!=b[i] || removed) {
                    c[ct] = b[i];
                    ct++;
                }
                else
                {
                    removed=true;
                    position=i;
                }
            }

            query = "UPDATE sale SET products = '"+conn.createArrayOf(a.getBaseTypeName(),c)+"' where sale.username ILIKE ?;";
            stmt = conn.prepareStatement(query);
            stmt.setString(1,cartUser);
            stmt.executeUpdate();

            _cart.removeFromCart(position);

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
