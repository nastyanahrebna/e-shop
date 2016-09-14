<%--
  Created by IntelliJ IDEA.
  User: wild_bo
  Date: 20.08.16
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="col-lg-10">

    <div class="container-fluid">

    <c:forEach items="${products}" var="p">

        <div class="col-lg-3">
            <div class="row">
                <div class="col-lg-11">
                    <div class="thumbnail">
                        <img src="/resources/images/${p.id}/${p.productImages.get(0).name}" alt="${p.model}">
                        <div class="caption" style="height: 130px;">
                            <h3>${p.model}</h3>
                            <p><a href="#" class="btn btn-primary disabled" role="button">${p.price}</a> <a href="/product/${p.id}" class="btn btn-default" role="button">Info</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </c:forEach>

        <div style="clear: both;">
            <ul class="pagination">
                <li><a ${link1}>&laquo;</a></li>

                <c:forEach var="i" begin="1" end="${pages}">
                    <li><a href="${i}"><c:out value="${i}"/><span class="sr-only" style="background: #ffc846;">(current)</span></a></li>
                </c:forEach>

                <li><a ${link2}>&raquo;</a></li>
            </ul>

        </div>

    </div>
</div>




