<%--
  Created by IntelliJ IDEA.
  User: wild_bo
  Date: 22.07.16
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#responsive-menu">menu
            </button>
        </div>
        <div class="collapse navbar-collapse" id="responsive-menu">
            <ul class="nav navbar-nav">
                <li><a href="/catecorys/gopro/1">GoPro</a></li>
                <li><a href="/catecorys/sjcam/1">SJCAM</a></li>
                <li><a href="/catecorys/drone/1">Квадрокоптери</a></li>
                <li><a href="/catecorys/accessories/1">Аксесуари</a></li>
            </ul>
        </div>
    </div>
</nav>