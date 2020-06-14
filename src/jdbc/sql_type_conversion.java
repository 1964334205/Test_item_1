package jdbc;

import java.sql.*;
/*
* 在写入sql时需要注意的数据类型的不同，需要进行转换
* 分为写入数据库时和读取数据库时
* */
public class sql_type_conversion {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String name = "王志强";
        String sfz = "123456789101112131";
        String class_and_grade = "18p计信2班";
        int major = 1;
        java.util.Date time_of_enrollment = Date.valueOf("2018-09-12");
        String gender = "男";
        //写入时
        //create_read_in(name,sfz,class_and_grade,major,time_of_enrollment,gender);
        //add();
        //读取时
        create_read(1);
    }

    //写入时
    static  void  create_read_in(String name,String sfz,String class_and_grade,int major,java.util.Date time_of_enrollment,String gender) throws ClassNotFoundException, SQLException {
        //一个严谨的规范的连接方式
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //注册
            //Class.forName("com.mysql.jdbc.Driver");

            //连接
            connection = jdbcUtilssing.getjdbcUtilssing().getConnection();

            //创建语句
            String sql = "insert into halloword.wxq1(name,sfz,class_and_grade,major,time_of_enrollment,gender) values (?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);

            //补全语句
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,sfz);
            preparedStatement.setString(3,class_and_grade);
            preparedStatement.setInt(4,major);
            //需要注意字段类型转换时的不同
            preparedStatement.setDate(5,new java.sql.Date(time_of_enrollment.getTime()));
            preparedStatement.setString(6,gender);

            //执行语句
            preparedStatement.executeUpdate();
            //
            //释放资源
        } finally {
            jdbcUtilssing.getjdbcUtilssing().free(resultSet, preparedStatement, connection);
        }
    }

    //读取时
    public static void add() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //注册
            Class.forName("com.mysql.jdbc.Driver");

            //连接
            connection = jdbcUtilssing.getjdbcUtilssing().getConnection();
            String ID = "1";
            String name = "lihuli";
            String password = "123456";
            String email = "123456789";
            java.util.Date birthday = Date.valueOf("2018-09-12");
            String nickname = "温向前";
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
    static  void  create_read(int ID) throws ClassNotFoundException, SQLException {
        //一个严谨的规范的连接方式
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        java.util.Date date = null;
        try {
            //注册
            //Class.forName("com.mysql.jdbc.Driver");

            //连接
            connection = jdbcUtilssing.getjdbcUtilssing().getConnection();

            //创建语句
            String sql = "DROP TABLE Bookstore.wxq_shopping_cart";
            statement = connection.createStatement();

            //执行语句获取结果
            //在这里不建议使用*号获取数据，可读性差
            statement.executeUpdate(sql);
            //释放资源
        } finally {
            jdbcUtilssing.getjdbcUtilssing().free(resultSet, statement, connection);
        }
    }
}
