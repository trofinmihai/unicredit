package hello;

import java.sql.*;

public class Database {

    public Connection GetConnection() throws Exception
    {
        try {
            Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/eticketshop?useSSL=false", "user", "password");
            return conn;
        }catch (SQLException e){
            throw e;
        }catch (Exception e){
            throw e;
        }
    }
}