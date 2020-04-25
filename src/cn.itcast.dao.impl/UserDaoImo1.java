package cn.itcast.dao.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import mysql.CRUD_User;

import java.sql.SQLException;
//添加用户，查询用户并返回，判断用户是否存在
public class UserDaoImo1 implements UserDao {
    //添加注册用户的数据
    @Override
    public void add(User user){
        try {

            /*Document document = XMLUtils.getDocument();
            Element element = document.getRootElement();
            Element user_tag = element.addElement("user");
            user_tag.setAttributeValue("id",user.getID());
            user_tag.setAttributeValue("username",user.getUsername());
            user_tag.setAttributeValue("password",user.getPassword());
            user_tag.setAttributeValue("email",user.getEmail());
            //user_tag.setAttributeValue("birthday",user.getBirthday()==null?"":user.getBirthday().toLocaleString());
            user_tag.setAttributeValue("birthday", user.getBirthday()==null?"": Userdate.transform(user.getBirthday()));
            user_tag.setAttributeValue("nickname",user.getNickname());

            XMLUtils.write2Xml(document);*/
            System.out.println("执行sql");
            CRUD_User.add(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //查找注册的用户是否在数据库中存在
    @Override
    public User find(String username, String password) throws SQLException, ClassNotFoundException {
        /*try {
            Document document = (Document) XMLUtils.getDocument();
            Element element = (Element) document.selectSingleNode(String.format("//user[@username='%s' and @password='%s']", username, password));
            if (element == null){
                return  null;
            }
            User user = new User();
            String date = element.attributeValue("birthday");
            if (date == null || date.equals("")){
                user.setBirthday(null);
            }else {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                user.setBirthday(dateFormat.parse(date));
            }

            user.setEmail(element.attributeValue("email"));
            user.setID(element.attributeValue("id"));
            user.setNickname(element.attributeValue("nickname"));
            user.setPassword(element.attributeValue("password"));
            user.setUsername(element.attributeValue("username"));
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
        User user =  CRUD_User.Find_returnUser(username,password);
        if (user.getUsername() == null){
            return null;
        }
        if (user.getUsername().equals(username)){
            return user;
        }else {
            return null;
        }

    }
    //查找用户是否存在
    @Override
    public boolean find(String username) throws SQLException, ClassNotFoundException {

        /*Document document = null;
        try {
            document = (Document) XMLUtils.getDocument();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element element = (Element) document.selectSingleNode(String.format("//user[@username='%s']",username));
            if (element == null){
                return  false;
            }else {
                return true;
            }*/
        User user =  CRUD_User.Find_returnUser(username,"123");
        System.out.println(user.getUsername()+"---数据库数据");
        System.out.println(username+"---用户提交数据");
        System.out.println(user.getUsername() == username);
        if (user.getUsername() == null){
            return false;
        }
        if (user.getUsername().equals(username)){
            return true;
        }else {
            return false;
        }

    }
}
