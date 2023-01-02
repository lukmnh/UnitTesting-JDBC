package JDBC.tools;

import java.sql.*;

public class DBConnection {

    private Connection conn;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/test", "root", "AN@021nime20");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error + " + e.getMessage());

        }
        return conn;
    }
}

// public class DBConnection {

// private static String MYSQL_JDBC_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
// private static String MYSQL_DB_URL =
// "jdbc:mysql://localhost:3306/perusahaan";
// private static String MYSQL_DB_USER = "root";
// private static String MYSQL_DB_USER_PASSWORD = "AN@021nime20";
// private static String SQL_QUERY = "Select * from employee";

// public static void main(String[] args) {

// try (Connection connection = DriverManager.getConnection(MYSQL_DB_URL,
// MYSQL_DB_USER, MYSQL_DB_USER_PASSWORD)) {

// Class.forName(MYSQL_JDBC_DRIVER_CLASS);
// Statement statement = connection.createStatement();
// ResultSet resultSet = statement.executeQuery(SQL_QUERY);

// while (resultSet.next()) {
// System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
// }

// } catch (ClassNotFoundException e) {
// System.out.println("MySQL Driver class not found!");
// e.printStackTrace();
// } catch (SQLException e) {
// System.out.println("Error occured while executing query: " + SQL_QUERY);
// e.printStackTrace();
// }
// }

// }