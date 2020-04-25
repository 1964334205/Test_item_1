package junit.test;

import cn.itcast.dao.impl.UserDaoImo1;
import cn.itcast.domain.User;
import org.dom4j.DocumentException;

import java.sql.SQLException;
import java.util.Date;

public class UserDaoImo1Test {
    @org.junit.Test
    public void add() {
        User user = new User();
        user.setEmail("1964334206@qq.com");
        user.setBirthday(new Date());
        user.setID("1234");
        user.setUsername("温向前1");
        user.setPassword("123456789");
        user.setNickname("小温1");
        UserDaoImo1 daoImo1 = new UserDaoImo1();
        daoImo1.add(user);
    }

    @org.junit.Test
    public void findreturnuser() {
        UserDaoImo1 daoImo1 = new UserDaoImo1();
        User user = null;
        try {
            user = daoImo1.find("温向前2","Qy9FtExDJBTS+X3w5XQ4GA==");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(user.getID());
    }

    @org.junit.Test
    public void findboolean() throws DocumentException {
        UserDaoImo1 daoImo1 = new UserDaoImo1();
        try {
            System.out.println(daoImo1.find("aaa"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}