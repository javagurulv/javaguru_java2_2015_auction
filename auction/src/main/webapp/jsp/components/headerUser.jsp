<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 2/28/2015
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- This header context will be displayed if user is logged in -->
<div class="logo">
    <span>Logo</span>
</div>

<div class="avatar">
    <img src="http://99px.ru/sstorage/56/2011/01/image_562501111926578518190.jpg"/>
</div>
<div class="name">
    Vasja123
    <p><a href="<%=request.getContextPath()%>/logoff">Выйти</a></p>
</div>
<div class="balance">
    <img src="<%=request.getContextPath()%>/staticRes/images/balance.jpg"/>
    На счету: 110$
</div>

