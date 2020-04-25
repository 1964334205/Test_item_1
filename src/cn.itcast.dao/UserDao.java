package cn.itcast.dao;

import cn.itcast.domain.User;

import java.sql.SQLException;

public interface UserDao {
    //添加注册用户的数据
    void add(User user);

    //查找注册的用户是否在数据库中存在
    User find(String username, String password) throws SQLException, ClassNotFoundException;

    //查找用户是否存在
    boolean find(String username) throws SQLException, ClassNotFoundException;
}
