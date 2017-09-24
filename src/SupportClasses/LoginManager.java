package SupportClasses;

import Models.Customer;
import Models.Product;
import Models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginManager {

    private Customer _user;

    public boolean checkUser(String username, String password)
    {
        boolean flag = false;

        try
        {
            String q = "select * from customer as c where c.username ilike ? and c.password ilike ?;";
            PreparedStatement pst = DBConnSingleton.getConn().prepareStatement(q);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if(rs.next())
            {
                while(rs.next()) {
                    _user = new Customer();
                    _user.set_CF(rs.getString(1));
                    _user.set_username(rs.getString(2));
                    _user.set_password(rs.getString(3));
                    _user.set_name(rs.getString(4));
                    _user.set_surname(rs.getString(5));
                    _user.set_address(rs.getString(6));
                    _user.set_telephone(rs.getString(7));
                    _user.set_cellphone(rs.getString(8));
                }

                flag = true;
            }
        }
        catch(SQLException e )
        {
            e.printStackTrace();
        }

        return flag;
    }

    public Customer getUser()
    {
        return _user;
    }
}
