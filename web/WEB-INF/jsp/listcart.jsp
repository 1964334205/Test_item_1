<%--
  Created by IntelliJ IDEA.
  User: wxq
  Date: 2020/2/21
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车列表</title>
    <script>
        function deleteitem(id) {
            var b = window.confirm("您确定删除吗？");
            if (b){
                window.location.href="${pageContext.request.contextPath}/DeleteCartItem?id="+id;
            }else {

            }
        }
        function clearcart() {
            var b = window.confirm("您确定清空购物车吗？");
            if (b){
                window.location.href="${pageContext.request.contextPath}/ClearCartServlet";
            }else {

            }
        }
        //修改数量
        function changeQuantity(inputthis,Original,id) {
            var quantityhttp = inputthis.value;//要修改的数量
            //判断是否为数字
            /*if (isNaN(document.getElementById("quantity").value)){
                alert("请输入数字");
                document.getElementById("quantity").value = Original;
                return;
            }*/
            if(quantityhttp<0 || quantityhttp!=parseInt(quantityhttp)){
                alert("请输入正整数");
                inputthis.value = Original;
                return;
            }

            var b = window.confirm("您确定要修改数量为"+quantityhttp);

            if (b){
                window.location.href="${pageContext.request.contextPath}/ChangeQuantityServlet?quantity="+quantityhttp+"&id="+id;
                quantityhttp = 0;
            }
        }
    </script>
</head>
<body style="text-align: center">
<h1>购物车列表</h1>
<!-- empty(cart.map)  的作用是判断传递的值是否为null和空""-->
<c:if test="${empty(cart.map)}">
    您没有购买任何商品
</c:if>
<c:if test="${!empty(cart.map)}">
<table width="70%" border="1">
    <tr>
        <td>书名</td>
        <td>作者</td>
        <td>单价</td>
        <td>数量</td>
        <td>小计</td>
        <td>操作</td>
    </tr>

    <c:forEach var="entry" items="${cart.map}">
        <tr>
            <td>${entry.value.book.name}</td>
            <td>${entry.value.book.author}</td>
            <td>${entry.value.book.unit_price}</td>
            <td>
                <input type="text" name="quantityhttp" id="quantityhttp" value="${entry.value.quantity}" style="width: 35px" onchange="changeQuantity(this,${entry.value.quantity},${entry.key})">
            </td>
            <td>${entry.value.unit_price}</td>
            <td><a href="javascript:void(0)" target="_top" onclick="deleteitem(${entry.key})">删除</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="3">总价</td>
        <td colspan="2">${cart.unit_price}元</td>
        <td colspan="1"><a href="javascript:void(0)" onclick="clearcart()">清空购物车</a></td>
    </tr>

</table>
</c:if>
</body>
</html>
