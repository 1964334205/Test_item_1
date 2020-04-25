package jdbc;

import java.sql.*;

public final class jdbcUtils {
    private jdbcUtils(){}
    private static String url = "jdbc:mysql://localhost:3306";//如果访问本机，那么主机名称和端口号可以省略"jdbc:mysql:///"
    private static String name = "root";
    private static String password = "123456";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, name, password);
    }
    public static void free(ResultSet resultSet, Statement statement,Connection connection){
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
