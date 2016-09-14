<%--
  Created by IntelliJ IDEA.
  User: wild_bo
  Date: 27.08.16
  Time: 2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h3>Order</h3>

<p>${product.model} | ${product.price}</p>

<form action="/cart/order" method="post">

    <input type="hiden" name="id" value="${product.id}">
    <input type="text" name="name" value="${product.model}">
    <input type="text" name="price" value="${product.price}">
    <input type="number" name="number" value="1">
    <button>Add</button>

</form>

