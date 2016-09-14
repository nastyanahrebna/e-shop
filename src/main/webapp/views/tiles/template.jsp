<%--
  Created by IntelliJ IDEA.
  User: wild_bo
  Date: 22.07.16
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title>My store</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <script src="//vk.com/js/api/openapi.js?122" type="text/javascript"></script>

    <script src="/resources/js/jquery-3.0.0.min.js"></script>
    <%--<script src="/resources/js/script.js"></script>--%>

    <script src="/resources/js/jquery-3.1.0.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
    <%--<script src="/resources/js/bootstrap.js"></script>--%>

    <%--<link rel="stylesheet" href="/resources/css/style.css">--%>

</head>




<body class="container-fluid">
    <div class="row">
        <header><tiles:insertAttribute name="header"/></header>
        <nav style="clear: both;"><tiles:insertAttribute name="menu"/></nav>
        <div class="content">
            <aside><tiles:insertAttribute name="aside"/></aside>
            <main><tiles:insertAttribute name="body"/></main>
        </div>
        <footer><tiles:insertAttribute name="footer"/></footer>
    </div>
</body>
</html>
