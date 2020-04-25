package jdbc;

import java.sql.*;

public class SQLinject {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        read();
    }
    static  void  read() throws ClassNotFoundException, SQLException {
        //一个严谨的规范的连接方式
        Connection connection = null;
        //PreparedStatement可以防止sql注入，会对sql的执行语句进行规范处理
        //PreparedStatement可以防止sql注入，PreparedStatement的运行速度会比Statement快一些
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //注册
            //Class.forName("com.mysql.jdbc.Driver");

            //连接
            connection = jdbcUtilssing.getjdbcUtilssing().getConnection();

            //创建语句
            String inject = "' or 1 ro '";//模拟sql注入
            String x = "我先去";
            System.out.println("select ID,name,sfz,class_and_grade,major,time_of_enrollment,gender from halloword.wxq1 where name='"+inject+"'");
            //String sql = "select ID,name,sfz,class_and_grade,major,time_of_enrollment,gender from halloword.wxq1 where name=?";
            String sql = "select ID,name,sfz,class_and_grade,major,time_of_enrollment,gender from halloword.wxq1 where name='"+x+"'";
            //添加sql语句
            preparedStatement = connection.prepareStatement(sql);

            //对sql语句进行处理，防止注入

            //preparedStatement.setString(1,inject);
            //执行sql语句
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //在这里不建议使用列号来获取，建议使用列名称获取
                //不止有getObject方法，还有getint，getlong等可以使用
                System.out.println(resultSet.getInt("ID") + "---"
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
            jdbcUtilssing.getjdbcUtilssing().free(resultSet, preparedStatement, connection);
        }
    }
}
