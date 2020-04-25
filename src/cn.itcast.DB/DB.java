package cn.itcast.DB;

import mysql.CRUD_Book;

import java.sql.SQLException;
import java.util.Map;

public class DB {
    private static Map map = null;
    static {
        /*map.put("1",new Book("1","温向前游记","温向前",99.99,"个人自述"));
        map.put("2",new Book("2","c++","李虎",88.99,"编程"));
        map.put("3",new Book("3","java","张鹏",77.99,"编程"));
        map.put("4",new Book("4","html","包子",66.99,"编程"));
        map.put("5",new Book("5","mvc设计模式","邓家辉",55.99,"编程"));
        map.put("6",new Book("6","计算机文化基础","麦烧",44.99,"计算机文化"));
        map.put("7",new Book("7","计算机网络基础","乐吧薯片",33.99,"计算机网络"));
        map.put("8",new Book("8","xxx","123",33.99,"计算机网络"));
        map.put("9",new Book("9","lll","456",33.99,"计算机网络"));
        map.put("10",new Book("10","pppp","乐吧薯片",33.99,"计算机网络"));
        map.put("11",new Book("11","iii","复古风格",33.99,"计算机网络"));
        map.put("12",new Book("12","kkk","胜多负少",33.99,"计算机网络"));
        map.put("13",new Book("13","yyy","符合规划",33.99,"计算机网络"));
        map.put("14",new Book("14","rrr","发过火",33.99,"计算机网络"));
        map.put("15",new Book("15","www","很困惑",33.99,"计算机网络"));
        map.put("16",new Book("16","sss","吃饱饭",33.99,"计算机网络"));
        map.put("17",new Book("17","ggg","废柴兄弟鬼地方",33.99,"计算机网络"));
        map.put("18",new Book("18","ddd","古风几个月",33.99,"计算机网络"));*/

        try {
            map = CRUD_Book.Find_returnBook();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*for (Object key : map.keySet()){
            Book book = (Book) map.get(key);
            System.out.println(book.getName());
            System.out.println(book.getAuthor());
            System.out.println(book.getUnit_price());
            System.out.println(book.getDescription());
        }*/

    }
    public static Map getAll(){
        try {
            map = CRUD_Book.Find_returnBook();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
}
