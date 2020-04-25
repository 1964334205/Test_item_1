package cn.itcast.web.controller;

import cn.itcast.servlet.BusinessServiceBook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class ListBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BusinessServiceBook businessServiceBook = new BusinessServiceBook();
        Map map = businessServiceBook.getAllBook();
        req.setAttribute("map",map);
        req.getRequestDispatcher("/WEB-INF/jsp/listBook.jsp").forward(req,resp);
    }
}
