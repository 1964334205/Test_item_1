<%--
  Created by IntelliJ IDEA.
  User: wxq
  Date: 2020/2/20
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>书籍列表页面</title>
</head>
<body style="text-align: center">
    <h1>书籍列表</h1>
    <table width="70%" border="1">
        <tr>
            <td>书名</td>
            <td>作者</td>
            <td>单价</td>
            <td>描述</td>
            <td>操作</td>
        </tr>
        <c:forEach var="entry" items="${map}">
            <tr>
                <td>${entry.value.name}</td>
                <td>${entry.value.author}</td>
                <td>${entry.value.unit_price}</td>
                <td>${entry.value.description}</td>
                <td><a href="${pageContext.request.contextPath}/BuyServlet?id=${entry.value.id}" target="_blank">购买</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
