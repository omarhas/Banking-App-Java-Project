package bankingApplication.shared;

import java.sql.*;

public class Database {
    static String jdbcUrl = "jdbc:mysql://localhost:3306/bankApp";
    static String username = "khalil";
    static String password = "1234";

    public static ResultSet executeSelectQuery(String query){
        ResultSet resultSet = null;
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException exception) {
            System.out.println(exception);
        }
        return resultSet;
    }

    public static void executeUpdateQuery(String query) {
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            System.out.println("query executed successfully :)");
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }
}
