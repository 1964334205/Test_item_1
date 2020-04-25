package cn.itcast.web.controller;

import cn.itcast.domain.Book;
import cn.itcast.domain.Cart;
import cn.itcast.servlet.BusinessServiceBook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//完成书籍购买
public class BuyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        BusinessServiceBook businessServiceBook = new BusinessServiceBook();
        Book book = businessServiceBook.findBook(id);

        //得到用户的购物车
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }

        //往客户购物车添加物品,完成购买
        cart.add(book);

        //resp.sendRedirect("/WEB-INF/jsp/listcart.jsp");
        req.getRequestDispatcher("/WEB-INF/jsp/listcart.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
