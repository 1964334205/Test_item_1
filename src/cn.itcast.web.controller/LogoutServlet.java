package cn.itcast.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//处理用户注销请求
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);
        if (httpSession!= null){
            httpSession.removeAttribute("user");
        }
        //注销成功，跳转全局消息显示页面，并控制消息显示页面过3秒后跳转到首页
        req.setAttribute("message","注销成功 五秒后自动跳转到网站首页 <meta http-equiv='refresh' content='5;url="+req.getContextPath()+"/index.jsp'>");
        req.getRequestDispatcher("/message.jsp").forward(req,resp);
    }
}
