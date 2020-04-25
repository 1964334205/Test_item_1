package cn.itcast.web.controller;

import cn.itcast.domain.Cart;
import cn.itcast.servlet.BusinessServiceBook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeQuantityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String quantity = req.getParameter("quantity");


        //得到用户的购物车
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        //往客户购物车修改数量
        BusinessServiceBook businessServiceBook = new BusinessServiceBook();
        businessServiceBook.ChangeQuantity(id,quantity,cart);


        //resp.sendRedirect("/WEB-INF/jsp/listcart.jsp");
        req.getRequestDispatcher("/WEB-INF/jsp/listcart.jsp").forward(req,resp);


    }
}
