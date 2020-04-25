<%--
  Created by IntelliJ IDEA.
  User: wxq
  Date: 2020/2/17
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript">
        function f(img) {
            img.src = img.src+"?"+new Date().getTime();
        }
    </script>
    <title>Title</title>
</head>
<body>
    <div id="main">
        <form action="${pageContext.request.contextPath}\RegisterServlet" method="post">
        <table id="formtable">
            <tr>
                <td>登陆账号:</td>
                <td>
                    <input type="text" name="username" value="${registerForm.username}">
                    <span>${registerForm.erros.username}</span>
                </td>
            </tr>
            <tr>
                <td>重复密码:</td>
                <td>
                    <input type="password" name="password" value="${registerForm.password}">
                    <span>${registerForm.erros.password}</span>
                </td>
            </tr>
            <tr>
                <td>确认密码:</td>
                <td>
                    <input type="password" name="password2" value="${registerForm.password2}" >
                    <span>${registerForm.erros.password2}</span>
                </td>
            </tr>
            <tr>
                <td>电子邮箱:</td>
                <td>
                    <input type="text" name="email" value="${registerForm.email}">
                    <span>${registerForm.erros.email}</span>
                </td>
            </tr>
            <tr>
                <td>出生日期:</td>
                <td>
                    <input type="text" name="birthday" id="birthday" value="${registerForm.birthday}">
                    <span>${registerForm.erros.birthday}</span>
                    <script src="${pageContext.request.contextPath}/js/laydate/laydate.js"></script> <!-- 改成你的路径 -->
                    <script>
                        lay('#version').html('-v'+ laydate.v);
                        //执行一个laydate实例
                        laydate.render({
                            elem: '#birthday' //指定元素
                        });
                    </script>
                </td>
            </tr>
            <tr>
                <td>您的昵称:</td>
                <td>
                    <input type="text" name="nickname" value="${registerForm.nickname}">
                    <span>${registerForm.erros.nickname}</span>
                </td>
            </tr>
            <tr>
                <td>图片认证:</td>
                <td>
                    <input type="text" name="verification_code" value="${registerForm.verification_code}">
                    <img src="${pageContext.request.contextPath}/verification_code" onclick="f(this)" alt="换一张" style="cursor:pointer">
                <td>
                <td>${registerForm.erros.verification_code}</td>
            </tr>
        </table>
        <div id="formasubmit">
            <span><input type="reset" name="reset" value="重置"></span>
            &nbsp;&nbsp;
            <span><input type="submit" name="submit" value="注册"></span>
        </div>
        </form>
        <div id="footer">
        </div>
    </div>
</body>
</html>
