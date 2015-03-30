<%@ page import="lv.javaguru.java2.domain.User" %>
<%@ page import="lv.javaguru.java2.services.security.UserPrincipal" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 2/28/2015
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    UserPrincipal userPrincipal = (UserPrincipal)auth.getPrincipal();
    user = userPrincipal.getDomainUser();
%>


<!-- This header context will be displayed if user is logged in -->
<div class="logo">
    <span>Logo</span>
</div>

<div class="avatar">
    <img src="http://99px.ru/sstorage/56/2011/01/image_562501111926578518190.jpg"/>
</div>
<div class="name">
    <%=user.getFirstName()%>
    <p><a href="<%=request.getContextPath()%>/logoff">Выйти</a></p>
</div>
<div class="balance">
    <img src="<%=request.getContextPath()%>/staticRes/images/balance.jpg"/>
    <em>На счету:</em> <%=user.getBalance()%>$
</div>

