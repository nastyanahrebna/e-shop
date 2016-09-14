<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wild_bo
  Date: 22.07.16
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-lg-2">

    <a href="/product/shares/page/1"><div style="background: aliceblue; height: 40px; margin-top: 5px;">Акції</div></a>
    <a href="/product/discouns/page/1"><div style="background: aliceblue; height: 40px; margin-top: 5px;">Знижки</div></a>
    <c:forEach items="${specifics}" var="s">

        <a href="/catecory/${s.type.name}/${s.name}/1"><div style="background: aliceblue; height: 40px; margin-top: 5px;">${s.name}</div></a>

    </c:forEach>

    <div style="margin: 20px 0px;">
        <div id="vk_groups"></div>
        <script type="text/javascript">
            VK.Widgets.Group("vk_groups", { mode: 2, width: "200", height: "300"}, 1);
        </script>
    </div>

</div>


