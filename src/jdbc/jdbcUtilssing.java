package jdbc;

import java.sql.*;

public final class jdbcUtilssing {
    //单例设计

    private String url = "jdbc:mysql://localhost:3306";//如果访问本机，那么主机名称和端口号可以省略"jdbc:mysql:///"
    private String name = "root";
    private String password = "123456";
    private static jdbcUtilssing instancs = null;
    private jdbcUtilssing(){}
    public static jdbcUtilssing getjdbcUtilssing(){
        //延迟加载形式
        if (instancs == null){
            //避免多线程问题
            synchronized (jdbcUtilssing.class){
                if (instancs == null) {
                    instancs = new jdbcUtilssing();
                }
            }

        }
        return instancs;
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, name, password);
    }
    public void free(ResultSet resultSet, Statement statement,Connection connection){
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
