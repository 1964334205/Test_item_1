<%--
  Created by IntelliJ IDEA.
  User: wxq
  Date: 2020/2/15
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body style="text-align: center">
    <h2>温向前的网站</h2>
    <%--
    xxxxxx
    --%>
    <br/>

    <div style="text-align: right">
      <c:if test="${user!=null}">
        欢迎您:${user.nickname} <a href="${pageContext.request.contextPath}/LogoutServlet">注销</a>
      </c:if>
      <c:if test="${user==null}">
        <a href="${pageContext.request.contextPath}/UIRegisterUIServlet">注册</a>
        <a href="${pageContext.request.contextPath}/LoginUIServlet">登陆</a>
      </c:if>


      <a href="${pageContext.request.contextPath}/ListBookServlet">浏览书籍</a>
    </div>
    <hr>
  </body>
</html>
