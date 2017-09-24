package SupportClasses;

import Models.Product;
import Models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginManager {

    private User _user;

    public boolean checkUser(String username, String password)
    {
        boolean flag = false;

        try
        {
            String q = "select * from products as p join musician as m on p.artist = m.id;";
            PreparedStatement pst = DBConnSingleton.getConn().prepareStatement(q);
            ResultSet rs = pst.executeQuery();

            Product p;
            while(rs.next())
            {

            }
        }
        catch(SQLException e )
        {
            e.printStackTrace();
        }

        return flag;
    }

    public User getUser()
    {
        return _user;
    }
}
