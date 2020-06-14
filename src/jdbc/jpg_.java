package jdbc;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
* 以二进制流的形式吧文件写入到数据库中！
* */
public class jpg_ {
    public static void main(String[] rgs) throws SQLException{
        read();
    }
    static  void  read() throws SQLException {
        //一个严谨的规范的连接方式
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //注册
            //Class.forName("com.mysql.jdbc.Driver");

            //连接
            connection = jdbcUtilssing.getjdbcUtilssing().getConnection();

            connection.setAutoCommit(false);//打开事务
            //创建语句
            String sql = "insert into halloword.picture(tupian) values (?)";//
            preparedStatement = connection.prepareStatement(sql);
            //File file = new File();
            InputStream inputStream = new BufferedInputStream(new FileInputStream("G:\\18p计信（2）温向前 大作业\\maya\\贾泽泰\\结果3.psd"));

            //补全语句
            preparedStatement.setBinaryStream(1,inputStream);

            //执行sql语句
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
            connection.commit();//提交事务
            //释放资源
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            connection.rollback();//回滚事务
        } catch (IOException e) {
            e.printStackTrace();
            connection.rollback();//回滚事务
        } finally {
            jdbcUtilssing.getjdbcUtilssing().free(resultSet, preparedStatement, connection);
        }
    }
}
