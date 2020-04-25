package mysql;

import cn.itcast.domain.Book;
import jdbc.jdbcUtilssing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class CRUD_Book {
    private static Map map = new LinkedHashMap();
    public static Map Find_returnBook() throws ClassNotFoundException, SQLException {
        //一个严谨的规范的连接方式
        Connection connection = null;
        //PreparedStatement可以防止sql注入，会对sql的执行语句进行规范处理
        //PreparedStatement可以防止sql注入，PreparedStatement的运行速度会比Statement快一些
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //注册
            Class.forName("com.mysql.jdbc.Driver");

            //连接
            connection = jdbcUtilssing.getjdbcUtilssing().getConnection();

            //创建语句
            String sql = "select ID,name,author,unit_price,description from Bookstore.Book";
            //添加sql语句
            preparedStatement = connection.prepareStatement(sql);

            //对sql语句进行处理，防止注入
            //preparedStatement.setString(1,username);

            //执行sql语句
            resultSet = preparedStatement.executeQuery();

            //对User对象赋值，并返回
            while (resultSet.next()) {

                //在这里不建议使用列号来获取，建议使用列名称获取
                //不止有getObject方法，还有getint，getlong等可以使用
                Book book = null;
                map.put(resultSet.getString("id"),book= new Book(resultSet.getString("ID"),resultSet.getString("name"),resultSet.getString("author"),resultSet.getFloat("unit_price"),resultSet.getString("description")));
            }
            //释放资源
        } finally {
            jdbcUtilssing.getjdbcUtilssing().free(resultSet, preparedStatement, connection);
        }
        return map;
    }
}
