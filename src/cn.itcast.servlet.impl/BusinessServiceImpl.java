package cn.itcast.servlet.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImo1;
import cn.itcast.domain.User;
import cn.itcast.exception.UserExitException;
import cn.itcast.utils.ServiceUtils;

import java.sql.SQLException;

//对web层提供业务服务(注册与登陆)
public class BusinessServiceImpl {
    private UserDao userDao = new UserDaoImo1();
    //提供注册服务
    public void register(User user) throws UserExitException, SQLException, ClassNotFoundException {
        //判断用户名是否存在
        if (userDao.find(user.getUsername())){
            //用户已存在异常，抛出一个编译时异常，提醒web层处理这个异常，给用户一个友好提示
            throw new UserExitException();
        }else {
            //将密码进行加密为md5码格式
            user.setPassword(ServiceUtils.md5(user.getPassword()));
            //将加了密的用户存入数据库
            System.out.println("执行UserDaoImo1");
            userDao.add(user);
        }
    }
    //提供登陆服务
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
