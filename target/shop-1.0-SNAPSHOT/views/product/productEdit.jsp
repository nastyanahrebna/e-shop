<%--
  Created by IntelliJ IDEA.
  User: wild_bo
  Date: 02.08.16
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<sec:authorize access="hasRole('ROLE_ADMIN')">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div style="float: left;">
        <a href="/product/${product.id}"><button><--</button></a>
    </div>


    <form style="line-height: 2.5;" action="/productEdit/${product.id}" method="post" enctype="multipart/form-data">

        <label for="model">Model</label>
        <input type="text" max="45" id="model" name="model" value="${product.model}">
        <br>
        <label for="number">Number</label>
        <input type="text"  id="number" name="number" value="${product.number}">
        <br>
        <label for="price">Price</label>
        <input type="text" id="price" name="price" value="${product.price}">
        <br>
        <label for="characteristics">characteristics</label>
        <input type="text" id="characteristics" name="characteristics" value="${product.characteristics}">
        <br>
        <label for="promotion">Promotion</label>
        <select id="promotion" name="promotion">
            <c:forEach items="${promotion}" var="p">
                <option value="${p}">${p}</option>
            </c:forEach>
        </select>
        <br>
        <label for="code">Code</label>
        <input type="text" id="code" name="code" value="${product.code}">
        <br>
        <button>add</button>
    </form>

</sec:authorize>
