package cn.itcast.web.controller;

import cn.itcast.domain.User;
import cn.itcast.exception.UserExitException;
import cn.itcast.servlet.impl.BusinessServiceImpl;
import cn.itcast.servlet.impl.BusinessServiceImpl_new_Shopping_cart;
import cn.itcast.utils.WebUtils;
import cn.itcast.web.formbean.RegisterForm;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//处理注册请求
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //2.不合法，跳回表单页面，回显不合法信息

        //3.合法，调用service处理注册请求

        //4.service处理失败，用户已存在，跳回注册页面，显示注册用户已存在

        //5.service处理失败，其他原因，

        //6.service处理成功，跳转网站的全局消息显示页面，为用户注册成功消息

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //格式设置
        //设置Request接受什么格式的编码
        req.setCharacterEncoding("UTF-8");
        /*设置response以什么码表向服务器写入*/
        resp.setCharacterEncoding("UTF-8");
        /*设置服务器向客户发送的响应头里面客户解析数据用的码表*/
        resp.setHeader("Content-Type","text/html;charset=UTF-8");

        //业务代码
        //1.对表单数据进行合法性判断(把表单数据封装到RegisterForm)
        RegisterForm registerForm = WebUtils.request2Bean(req, RegisterForm.class);
        ServletContext servletContext = this.getServletConfig().getServletContext();
        //System.out.println(servletContext.getAttribute("verification_code"));
        boolean b = registerForm.validate((String) servletContext.getAttribute("verification_code"));
        if (!b){
            //2.不合法，跳回表单页面，回显不合法信息
            req.setAttribute("registerForm",registerForm);
            req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req,resp);
            return;
        }

        //3.合法，调用service处理注册请求
        User user = new User();
        WebUtils.copyBean(registerForm,user);
        user.setID(WebUtils.generateID());
        BusinessServiceImpl businessService = new BusinessServiceImpl();
        BusinessServiceImpl_new_Shopping_cart businessServiceImpl_new_shopping_cart = new BusinessServiceImpl_new_Shopping_cart();
        try {
            System.out.println("开始注册");
            businessService.register(user);

            System.out.println("为用户创建购物车");
            businessServiceImpl_new_shopping_cart.register(user);
            //6.service处理成功，跳转网站的全局消息显示页面，为用户注册成功消息
            req.setAttribute("message","注册成功 五秒后自动跳转到网站首页 <meta http-equiv='refresh' content='5;url="+req.getContextPath()+"/index.jsp'>");
            req.getRequestDispatcher("/message.jsp").forward(req,resp);
            return;
        } catch (UserExitException e) {
            //4.service处理失败，用户已存在，跳回注册页面，显示注册用户已存在
            registerForm.setErros("username","注册的用户名已存在");
            req.setAttribute("registerForm",registerForm);
            req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req,resp);
            return;
        }catch (Exception e){
            //5.service处理失败，其他原因，跳转到全局消息显示页面，为用户显示友好错误消息

            req.setAttribute("message","服务器出现未知错误");
            req.getRequestDispatcher("/message.jsp").forward(req,resp);
            e.printStackTrace();
        }
    }
}
