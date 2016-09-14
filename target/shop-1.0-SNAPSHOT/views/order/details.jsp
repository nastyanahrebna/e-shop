<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: wild_bo
  Date: 12.09.16
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h3>Order details:</h3>

<form:form action="/cart/order/details" method="post" modelAttribute="user">
    <form:hidden path="id"/>
    <table style="margin: auto; text-align: center; border-spacing: 5px; border-collapse: inherit;">
        <tr>
        <td><form:label path="firstName">First name:</form:label></td>
        <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td><form:label path="lastName">Last name:</form:label></td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td><form:label path="email">Email:</form:label></td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td><form:label path="phone">Phone:</form:label></td>
            <td><form:input path="phone"/></td>
        </tr>
        <tr>
            <td><form:label path="address">Address</form:label></td>
            <td><form:input path="address"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><form:button class="btn btn-success">Add</form:button></td>
        </tr>
    </table>
</form:form>
