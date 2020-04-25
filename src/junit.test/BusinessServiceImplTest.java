package junit.test;

import cn.itcast.domain.User;
import cn.itcast.exception.UserExitException;
import cn.itcast.servlet.impl.BusinessServiceImpl;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;

public class BusinessServiceImplTest {

    @Test
    public void register() {
        User user = new User();
        user.setEmail("1964334206@qq.com");
        user.setBirthday(new Date());
        user.setID("1234");
        user.setUsername("温向前2");
        user.setPassword("12345678910");
        user.setNickname("小温1");
        BusinessServiceImpl businessService = new BusinessServiceImpl();
        try {
            try {
                businessService.register(user);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("注册成功");
        } catch (UserExitException e) {
            System.out.println("用户已存在");
        }
    }

    @Test
    public void login() {
        BusinessServiceImpl businessService = new BusinessServiceImpl();
        User user = businessService.login("温向前2","12345678910");
        System.out.println(user.getPassword());

    }
}