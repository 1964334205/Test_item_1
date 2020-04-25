package cn.itcast.dao;

import cn.itcast.domain.Book;

import java.util.Map;

public interface BookDao {
    Map getAll();

    Book find(String id);
}
