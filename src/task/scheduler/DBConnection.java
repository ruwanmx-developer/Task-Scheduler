package task.scheduler;

import java.sql.*;

public class DBConnection {

    private static Connection conn;

    public Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:./taskDatabase.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite database established.");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error connecting to SQLite database: " + e.getMessage());
        }
        return conn;
    }

    public void closeConnection() {
        try {
            conn.close();
            System.out.println("Connection to SQLite database closed.");
        } catch (SQLException e) {
            System.err.println("Error closing connection to SQLite database: " + e.getMessage());
        }

    }
}
