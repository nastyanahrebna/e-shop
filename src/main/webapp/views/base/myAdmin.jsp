<%--
  Created by IntelliJ IDEA.
  User: wild_bo
  Date: 28.07.16
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div style="margin: 10px auto;">
    <h4>Add product</h4>
    <hr>

    <form style="line-height: 2.5;" action="/admin/add" method="post" enctype="multipart/form-data">

        <label for="model">Model</label>
        <input type="text" id="model" name="model">
        <br>
        <label for="number">Number</label>
        <input type="text"  id="number" name="number">
        <br>
        <label for="price">Price</label>
        <input type="text" id="price" name="price">
        <br>
        <label for="characteristics">characteristics</label>
        <input type="text" id="characteristics" name="characteristics">
        <br>
        <label for="promotion">Promotion</label>
        <select id="promotion" name="promotion">
            <c:forEach items="${promotion}" var="p">
                <option value="${p}">${p}</option>
            </c:forEach>
        </select>
        <br>
        <label for="manufacturer">Manufacturer</label>
        <select id="manufacturer" name="manufacturer">
            <c:forEach items="${manufacturer}" var="m">
                <option value="${m.id}"/>${m.name}
            </c:forEach>
        </select>
        <br>
        <label for="specifics">Specifics</label>
        <select id="specifics" name="specifics">
            <c:forEach items="${specifics}" var="s">
                <option value="${s.id}"/>${s.name}
            </c:forEach>
        </select>
        <br>
        <label for="code">Code</label>
        <input type="text" id="code" name="code">
        <br>
        <label for="image1">Image</label>
        <input type="file" id="image1" name="img">
        <br>
        <label for="image2">Image</label>
        <input type="file" id="image2" name="img">
        <br>
        <label for="image3">Image</label>
        <input type="file" id="image3" name="img">
        <br>
        <label for="image4">Image</label>
        <input type="file" id="image4" name="productImages">
        <br>
        <button>add</button>
    </form>

</div>
