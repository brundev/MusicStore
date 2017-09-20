package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by stefano on 19/09/17.
 */
public class Database {

    private static Database instance = null;

    private Database(){
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://dbserver.scienze.univr.it/db0", "user0",
                    "secret");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static Database getDBConnection(){

        if(instance==null)
            instance = new Database();

        return instance;
    }

}
