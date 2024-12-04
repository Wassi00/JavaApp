package services;

import java.sql.*;

public class DbConnection {
    public static Connection connection = null;

    public DbConnection() {
        connectToDatabase();
    }
    public void connectToDatabase() {
        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = "root2024";

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");
            // Perform database operations here

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Connection closed!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
