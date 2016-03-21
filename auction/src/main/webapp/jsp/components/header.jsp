<%@ page import="lv.javaguru.java2.domain.User" %>
<%@ page import="lv.javaguru.java2.services.security.UserPrincipal" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.authentication.AnonymousAuthenticationToken" %>


<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 2/25/2015
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // Logic of showing login header or not!
//    User user = null;
    // Getting authentication object from SecurityContext
//
//    // Checking if authentication is anonymous or not!
//    if (!(auth instanceof AnonymousAuthenticationToken)) {
//        // Getting domain user!
//        UserPrincipal userPrincipal = (UserPrincipal)auth.getPrincipal();
//        user = userPrincipal.getDomainUser();
//    }
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    User user = null;
%>

<header>
    <% if (auth instanceof AnonymousAuthenticationToken){%>

        <%@ include file="headerLogin.jsp"%>


    <%}else {%>

        <%@ include file="headerUser.jsp"%>

    <%};%>
</header> <!-- End of header -->
