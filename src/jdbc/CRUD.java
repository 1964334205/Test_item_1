package jdbc;

import java.sql.*;

/*
* 增删改查
* */
public class CRUD {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        read();//读取操作
        System.out.println("插入");
        create();//插入操作
        read();//读取操作
        System.out.println("修改");
        date();//修改操作
        read();//读取操作
        System.out.println("删除");
        delete();//删除操作
        read();//读取操作
    }
    static  void  date() throws ClassNotFoundException, SQLException {
        //一个严谨的规范的连接方式
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //注册
            //Class.forName("com.mysql.jdbc.Driver");

            //连接
            connection = jdbcUtilssing.getjdbcUtilssing().getConnection();

            //创建语句
            statement = connection.createStatement();

            //执行语句
            String sql = "update halloword.wxq1 set sfz='411024199906098588' where name='王志强'";
            int i = statement.executeUpdate(sql);
            System.out.println(i);
            //
            //释放资源
        } finally {
            jdbcUtilssing.getjdbcUtilssing().free(resultSet, statement, connection);
        }
    }
    static  void  delete() throws ClassNotFoundException, SQLException {
        //一个严谨的规范的连接方式
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //注册
            //Class.forName("com.mysql.jdbc.Driver");

            //连接
            connection = jdbcUtilssing.getjdbcUtilssing().getConnection();

            //创建语句
            statement = connection.createStatement();

            //执行语句
            String sql = "delete from halloword.wxq1 where name='王志强'";
            int i = statement.executeUpdate(sql);
            System.out.println(i);
            //
            //释放资源
        } finally {
            jdbcUtilssing.getjdbcUtilssing().free(resultSet, statement, connection);
        }
    }
    static  void  create() throws ClassNotFoundException, SQLException {
        //一个严谨的规范的连接方式
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //注册
            //Class.forName("com.mysql.jdbc.Driver");

            //连接
            connection = jdbcUtilssing.getjdbcUtilssing().getConnection();

            //创建语句
            statement = connection.createStatement();

            //执行语句
            String sql = "insert into halloword.wxq1 values (null,'王志强','123456789101112131','18p计信2班',1,'2018-09-12','男')";
            int i = statement.executeUpdate(sql);
            System.out.println(i);
            //
            //释放资源
        } finally {
            jdbcUtilssing.getjdbcUtilssing().free(resultSet, statement, connection);
        }
    }
    static  void  read() throws ClassNotFoundException, SQLException {
        //一个严谨的规范的连接方式
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //注册
            //Class.forName("com.mysql.jdbc.Driver");

            //连接
            connection = jdbcUtilssing.getjdbcUtilssing().getConnection();

            //创建语句
            statement = connection.createStatement();

            //执行语句获取结果
            //在这里不建议使用*号获取数据，可读性差
            resultSet = statement.executeQuery("select ID,name,sfz,class_and_grade,major,time_of_enrollment,gender from halloword.wxq1");
            while (resultSet.next()) {
                //在这里不建议使用列号来获取，建议使用列名称获取
                System.out.println(resultSet.getObject("ID") + "---"
                        + resultSet.getObject("name") + "---"
                        + resultSet.getObject("sfz") + "---"
                        + resultSet.getObject("class_and_grade") + "---"
                        + resultSet.getObject("major") + "---"
                        + resultSet.getObject("time_of_enrollment") + "---"
                        + resultSet.getObject("gender") + "---"
                );
            }
            //释放资源
        } finally {
            jdbcUtilssing.getjdbcUtilssing().free(resultSet, statement, connection);
        }
    }
}




