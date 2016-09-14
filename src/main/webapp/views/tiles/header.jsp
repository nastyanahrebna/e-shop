<%--
  Created by IntelliJ IDEA.
  User: wild_bo
  Date: 22.07.16
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div>
    <div class="col-lg-4">
        <a href="/"><img src="/resources/images/log1.png" alt="logo" class="img-responsive"></a>
    </div>

    <div class="col-lg-4">
        <form action="/search" method="post">
            <div class="input-group" style="margin-top: 8%">
                <input type="text" name="model" class="form-control" id="sizing-addon1" placeholder="Search for...">
                <span class="input-group-btn">
                    <button class="btn btn-default" type="button">Go!</button>
                </span>
            </div>
        </form>
    </div>


    <div class="col-lg-4">

            <table class="loginForm" style="border-spacing: 5px; border-collapse: inherit; margin: auto;">

                <form:form action="/loginprocessing" method="post">

                <sec:authorize access="isAnonymous()">

                    <tr>
                        <td><label for="login">Логін:</label></td>
                        <td><input id="login" type="text" name="username" placeholder="enter email" required></td>
                    </tr>
                    <tr>
                        <td><label for="password">Пароль:</label></td>
                        <td><input id="password" type="password" name="password" placeholder="enter password" required></td>
                    </tr>
                    <tr>
                        <td><button type="submit" class="btn btn-warning btn-sm">SING-UP</button></td>
                        <td style="text-align: center;"><a href="/registration"><button type="button" class="btn btn-warning btn-sm">SING-IN</button></a></td>
                    </tr>

                </sec:authorize>

                    <sec:authorize access="isAuthenticated()">

                    <form:form action="/logout" method="post">
                        <tr>
                            <td><button style="width: 150px; margin-top: 12%;" type="submit" class="btn btn-warning btn-sm">LOGOUT</button></td>
                        </tr>
                        <tr>
                            <td><p style="width: 150px;" class="btn btn-warning btn-sm"><a href="/cart">CART</a></p></td>
                        </tr>

                    </form:form>

                </sec:authorize>

                </form:form>

            </table>

    </div>

</div>

