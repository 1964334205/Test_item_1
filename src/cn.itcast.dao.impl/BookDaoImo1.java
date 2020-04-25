package cn.itcast.dao.impl;

import cn.itcast.DB.DB;
import cn.itcast.domain.Book;

import java.util.Map;

//添加物品，查询用户所有物品并返回，查看物品是否存在
public class BookDaoImo1 implements cn.itcast.dao.BookDao {
    @Override
    public Map getAll(){
        return DB.getAll();
    }

    @Override
    public Book find(String id){

        return (Book) DB.getAll().get(id);
    }

}
