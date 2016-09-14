<%--
  Created by IntelliJ IDEA.
  User: wild_bo
  Date: 27.07.16
  Time: 1:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="button" uri="http://www.springframework.org/tags/form" %>

<div class="col-lg-10">

    <a href="/"><button style="float: left;"><--</button></a>

    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <div style="float: left;">
            <form:form cssStyle="float: left;" action="/productEdit/${product.id}" method="get">
                <button type="submit">EDIT</button>
            </form:form>
            <form:form cssStyle="float: left;" action="/del/${product.id}">
                <button>DEL</button>
            </form:form>
        </div>
    </sec:authorize>

    <h3>${product.manufacturer} ${product.model}</h3>


        <div class="product" style="float: left;">
            <img src="/resources/images/${product.id}/${product.productImages.get(0).name}" alt="${product.model}">
        </div>

        <div style="float: left;">

            <div style="margin: 30px;">
                <span style="float: left;">${product.price}</span>
                <form style="float: left; margin-left: 30px;" action="/cart/add/${product.id}" method="get">
                    <sec:authorize access="isAuthenticated()">
                        <button>Order</button>
                    </sec:authorize>
                    <sec:authorize access="isAnonymous()">
                        <a href="/registration">Order</a>
                    </sec:authorize>
                </form>
            </div>
            <div style="clear:both; float: left; margin: 30px 20px;; text-align: left;">
                <span>
                    <p>id product: ${product.id}</p>
                    <p>model product: ${product.model}</p>
                </span>
            </div>

        </div>

        <div style="clear:both; margin: 25px;">
            ${product.characteristics}
        </div>

</div>



