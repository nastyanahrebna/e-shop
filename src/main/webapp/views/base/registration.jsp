<%--
  Created by IntelliJ IDEA.
  User: wild_bo
  Date: 01.08.16
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form action="/registration" method="post" modelAttribute="user">

    <h3 style="text-align: center">Registration form:</h3>

        <form:hidden path="id"/>
        <table style="margin: auto; text-align: center; border-spacing: 5px; border-collapse: inherit;">
            <tr>
        <td><form:label path="firstName">First name:</form:label></td>
        <td><form:input path="firstName"/></td>
        <td><form:errors path="firstName" cssStyle="color: #000;background-color: #ffEEEE;
        border: 1px solid #ff0000;"/></td>
            </tr>
            <tr>
        <td><form:label path="lastName">Last name:</form:label></td>
        <td><form:input path="lastName"/></td>
        <td><form:errors path="lastName" cssStyle="color: #000;background-color: #ffEEEE;
        border: 1px solid #ff0000;"/></td>
        </tr>
            <tr>
        <td><form:label path="password">Password:</form:label></td>
        <td><form:password path="password"/></td>
        <td><form:errors path="password" cssStyle="color: #000;background-color: #ffEEEE;
        border: 1px solid #ff0000;"/></td>
            </tr>
            <tr>
        <td><form:label path="passwordConfirm">Confirm password :</form:label></td>
        <td><form:password path="passwordConfirm"/></td>
        <td><form:errors path="passwordConfirm" cssStyle="color: #000;background-color: #ffEEEE;
        border: 1px solid #ff0000;"/></td>
            </tr>
            <tr>
        <td><form:label path="email">Email:</form:label></td>
        <td><form:input path="email"/></td>
        <td><form:errors path="email" cssStyle="color: #000;background-color: #ffEEEE;
        border: 1px solid #ff0000;"/></td>
            </tr>
        <tr><td colspan="2" align="center"><form:button class="btn btn-success">Sign up!</form:button></td></tr>
        </table>

</form:form>
