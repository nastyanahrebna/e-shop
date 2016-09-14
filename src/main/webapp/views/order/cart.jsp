<%--
  Created by IntelliJ IDEA.
  User: wild_bo
  Date: 11.08.16
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>Order</h3>

<p><a href="/cart/remove/all"><button>Remove all</button></a></p>
<p><a href="/cart/order/details"><button>Order details</button></a></p>

<div class="col-lg-10">

    <div class="container-fluid">

        <table style="border-spacing: 20px; border-collapse: inherit;">
            <tr>
                <td>Name</td>
                <td>Price</td>
                <td>Number</td>
                <td>Del</td>
                <td>Buy</td>
            </tr>


                <c:forEach items="${products}" var="p">

                    <form action="/cart/order" method="post">
                        <input type="hidden" name="id" value="${p.id}">
                        <input type="hidden" name="price" value="${p.price}">

                        <tr>
                            <td>${p.model}</td>
                            <td>${p.price}</td>
                            <td><input type="number" name="number"></td>
                            <td><a href="/cart/del/${p.id}"><button type="button">Del</button></a></td>
                            <td><button>Buy</button></td>
                        </tr>
                    </form>

                </c:forEach>

        </table>

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