package jdbc;

import java.sql.*;

public class SQmeatDate {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        read();
    }
    static  void  read() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //注册
            //Class.forName("com.mysql.jdbc.Driver");

            //连接
            connection = jdbcUtilssing.getjdbcUtilssing().getConnection();


            //创建语句
            String sql = "select ID as id,name,sfz,class_and_grade,major,time_of_enrollment,gender from halloword.wxq1";
            //添加sql语句
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int count  = rsmd.getColumnCount();
            for (int i = 1; i < count; i++) {
                System.out.println(rsmd.getColumnClassName(i));//查询数据类型
                System.out.println(rsmd.getColumnName(i));//查询数据名称
                System.out.println(rsmd.getColumnLabel(i));//查询数据别名
            }
            //对sql语句进行处理，防止注入

            //释放资源
        } finally {
            jdbcUtilssing.getjdbcUtilssing().free(resultSet, preparedStatement, connection);
        }
    }
}