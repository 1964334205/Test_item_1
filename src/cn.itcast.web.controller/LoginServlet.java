package cn.itcast.web.controller;

import cn.itcast.domain.User;
import cn.itcast.servlet.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        BusinessServiceImpl service = new  BusinessServiceImpl();
        User user = service.login(username,password);
        if (user!= null){
            req.getSession().setAttribute("user",user);
            //让用户登陆成功之后跳转到首页
            req.setAttribute("message","登陆成功 五秒后自动跳转到网站首页 <meta http-equiv='refresh' content='5;url="+req.getContextPath()+"/index.jsp'>");
            req.getRequestDispatcher("/message.jsp").forward(req,resp);
            return;
        }
        req.setAttribute("message","用户名或密码错误！");
        req.getRequestDispatcher("/message.jsp").forward(req,resp);
    }
}
