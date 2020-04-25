package mysql;

import cn.itcast.domain.User;
import jdbc.jdbcUtilssing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/*
* 用于操作数据库
* */
public class CRUD_User {
    //插入用户数据
    public static void add(User user) throws ClassNotFoundException, SQLException {
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
            String ID = user.getID();
            String name = user.getUsername();
            String password = user.getPassword();
            String email = user.getEmail();
            Date birthday = user.getBirthday();
            String nickname = user.getNickname();
            //创建语句
            String sql = "insert into Bookstore.User(ID,name,password,email,birthday,nickname) values (?,?,?,?,?,?)";
            //添加sql语句
            preparedStatement = connection.prepareStatement(sql);

            //对sql语句进行处理，防止注入

            preparedStatement.setString(1,ID);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,password);
            preparedStatement.setString(4,email);
            //需要注意字段类型转换时的不同
            preparedStatement.setDate(5,new java.sql.Date(birthday.getTime()));
            preparedStatement.setString(6,nickname);

            //执行sql语句
            preparedStatement.executeUpdate();
            //释放资源
        } finally {
            jdbcUtilssing.getjdbcUtilssing().free(resultSet, preparedStatement, connection);
        }
    }
    //查找用户并返回
    public static User Find_returnUser(String username, String password) throws ClassNotFoundException, SQLException {
        //一个严谨的规范的连接方式
        Connection connection = null;
        //PreparedStatement可以防止sql注入，会对sql的执行语句进行规范处理
        //PreparedStatement可以防止sql注入，PreparedStatement的运行速度会比Statement快一些
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = new User();
        try {
            //注册
            Class.forName("com.mysql.jdbc.Driver");

            //连接
            connection = jdbcUtilssing.getjdbcUtilssing().getConnection();

            //创建语句
            String sql = "select ID,name,password,email,birthday,nickname from Bookstore.User where name='"+username+"' and password='"+password+"'";
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
                user.setID(resultSet.getString("ID"));
                user.setUsername(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setBirthday(new java.sql.Date(resultSet.getDate("birthday").getTime()));
                user.setNickname(resultSet.getString("nickname"));
            }
            //释放资源
        } finally {
            jdbcUtilssing.getjdbcUtilssing().free(resultSet, preparedStatement, connection);
        }
        return user;
    }
    //删除用户
}
