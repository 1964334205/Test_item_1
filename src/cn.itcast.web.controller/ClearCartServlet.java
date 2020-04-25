package cn.itcast.web.controller;

import cn.itcast.domain.Cart;
import cn.itcast.servlet.BusinessServiceBook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClearCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        BusinessServiceBook businessServiceBook = new BusinessServiceBook();
        businessServiceBook.clearCartServlet(cart);

        req.getRequestDispatcher("/WEB-INF/jsp/listcart.jsp").forward(req,resp);
    }
}
