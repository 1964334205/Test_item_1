package cn.itcast.servlet;

import cn.itcast.dao.BookDao;
import cn.itcast.dao.impl.BookDaoImo1;
import cn.itcast.domain.Book;
import cn.itcast.domain.Cart;
import cn.itcast.domain.CartLtem;

import java.util.Map;
//业务类统一对web层提供所有服务
public class BusinessServiceBook {
    private BookDao bookDao = new BookDaoImo1();
    public Map getAllBook(){
        return bookDao.getAll();
    }
    public Book findBook(String id){
        return bookDao.find(id);
    }

    //删除购物车里面的购物项
    public void deleteCartItem(String id, Cart cart) {
        cart.getMap().remove(id);
    }
    //删除全部的购物项
    public void clearCartServlet(Cart cart) {
        cart.getMap().clear();
    }

    public void ChangeQuantity(String id, String quantity, Cart cart) {
            CartLtem cartLtem = cart.getMap().get(id);
            cartLtem.setQuantity(Integer.parseInt(quantity));
    }
}
