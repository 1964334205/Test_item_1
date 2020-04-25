package cn.itcast.servlet.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImo1;
import cn.itcast.domain.User;
import cn.itcast.exception.UserExitException;
import cn.itcast.utils.ServiceUtils;
import jdbc.jdbcUtilssing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BusinessServiceImpl_new_Shopping_cart {
    private UserDao userDao = new UserDaoImo1();
    //为用户创建购物车服务
    public void register(User user) throws UserExitException, SQLException, ClassNotFoundException {
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
            System.out.println("create table Bookstore."+user.getUsername()+"_"+"Shopping_cart(" +
                    "id  int primary key," +
                    "book_id int comment '指向Book表中的id主键'," +
                    "constraint "+user.getUsername()+"_"+"book_id foreign key(book_id) references Book(id)" +
                    ")engine=Innodb charset utf8mb4");
            String sql = "create table Bookstore."+user.getUsername()+"_"+"Shopping_cart(" +
                    "id  int primary key," +
                    "book_id int comment '指向Book表中的id主键'," +
                    "constraint "+user.getUsername()+"_"+"book_id foreign key(book_id) references Book(id)" +
                    ")engine=Innodb charset utf8mb4";
            //添加sql语句
            preparedStatement = connection.prepareStatement(sql);

            //执行sql语句
            preparedStatement.executeUpdate();

            //释放资源
        } finally {
            jdbcUtilssing.getjdbcUtilssing().free(resultSet, preparedStatement, connection);
        }

    }
    //提供删除购物车服务
    public User login(String username,String password){
        password = ServiceUtils.md5(password);
        User user = null;
        try {
            user = userDao.find(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }
}
