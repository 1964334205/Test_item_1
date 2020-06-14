package jdbc;

import java.sql.*;
/*
* 数据库的连接要尽量晚的建立，断开要尽量早的断开，尽可能的少占用数据库资源
* */
public class li1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        template();

    }
    static  void  template() throws ClassNotFoundException, SQLException {
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
            resultSet = statement.executeQuery("insert into halloword.wxq1 values (null,'王志强','1234567891011121314','18p计信2班',1,'2018-09-12','男')");
            /*while (resultSet.next()) {
                System.out.println(resultSet.getObject(1) + "---"
                        + resultSet.getObject(2) + "---"
                        + resultSet.getObject(3) + "---"
                        + resultSet.getObject(4) + "---"
                        + resultSet.getObject(5) + "---"
                        + resultSet.getObject(6) + "---"
                        + resultSet.getObject(7) + "---"
                );
            }*/
        //释放资源
        } finally {
            jdbcUtilssing.getjdbcUtilssing().free(resultSet,statement,connection);
        }
    }
    static  void  test() throws SQLException, ClassNotFoundException {
        //注册驱动 //推荐使用第二或者第三种方式，第一种对mysql驱动包存在依赖，如果驱动不存在编译会不存在
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //注册驱动第二种方法
        //System.setProperty("jdbc.drivers","com.mysql.jdbc.Driver");//此方式可以注册多个使用冒号分割 System.setProperty("jdbc.drivers","com.mysql.jdbc.Driver():xxxxxxxx:xxxxx:....n");
        //注册驱动第三种方法
        //Class.forName("com.mysql.jdbc.Driver");
        //Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary
        //翻译:驱动程序类是' com.mysql.cj.jdbc.Driver'。驱动程序是通过SPI自动注册的，手动加载驱动程序类通常是不必要的
        //可以不用进行手动注册了，SPI已经自动注册了


        //建立连接
        String url = "jdbc:mysql://localhost:3306";//如果访问本机，那么主机名称和端口号可以省略"jdbc:mysql:///"
        String root = "root";
        String password = "123456";
        /*
        * Connection会内部创建一个已注册驱动的池子，在连接数据库时会在池子里面尝试询问每个驱动能否创建连接。
        * */
        Connection conn = DriverManager.getConnection(url,root,password);

        //创建语句
        /*
        * Statement类似一个装载器，在Java中装载MySQL代码，把代码给数据库，装载数据库返回的结果，在返回给Java程序，反之亦然
        * */
        Statement statement = conn.createStatement();

        //执行语句
        /*
        * Statement返回结果之后给ResultSet，ResultSet在内部将数据装载成为一个二维表形式，在提供方法给Java代码访问
        * */
        ResultSet resultSet = statement.executeQuery("select * from halloword.wxq1");

        //取出结果
        /*
        * resultSet.next()设置当前访问行数，从第一行开始执行一次行数递加1，
        * resultSet.getObject(x)，获取next设置的行数中的指定列的数据
        * */
        while (resultSet.next()){
            System.out.println(resultSet.getObject(1)+"---"
                    +resultSet.getObject(2)+"---"
                    +resultSet.getObject(3)+"---"
                    +resultSet.getObject(4)+"---"
                    +resultSet.getObject(5)+"---"
                    +resultSet.getObject(6)+"---"
                    +resultSet.getObject(7)+"---"
            );
        }

        //释放资源
        /*
        * 数据库访问连接数是有限的，资源稀有，如果不需要就要立即关闭，不然远端数据库会变得很慢
        * */
        resultSet.close();
        statement.close();
        conn.close();
    }
}
