package org.example.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    public static Connection getPostgreSQLConnection(){
        String url = "jdbc:postgresql://localhost:5432/demo_jdbc";
        String user = "postgres";
        String password = "1426";

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,user,password);

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;

    }
}
