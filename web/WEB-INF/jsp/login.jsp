<%--
  Created by IntelliJ IDEA.
  User: wxq
  Date: 2020/2/19
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login登录界面</title>
</head>
<body>
    <div id="container">
        <div id="image">
            <div id="form">
                <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
                    <div>
                        用户名:<input type="text" name="username">
                    </div>
                    <div>
                        密码:<input type="password" name="password">
                    </div>
                    <div id="btn">
                        <input type="submit" value="登陆" >
                        <input type="submit" value="注册">
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
