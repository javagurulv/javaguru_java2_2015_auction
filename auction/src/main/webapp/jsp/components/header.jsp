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
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//
//    // Checking if authentication is anonymous or not!
//    if (!(auth instanceof AnonymousAuthenticationToken)) {
//        // Getting domain user!
//        UserPrincipal userPrincipal = (UserPrincipal)auth.getPrincipal();
//        user = userPrincipal.getDomainUser();
//    }
%>

<header>
    <% if (auth instanceof AnonymousAuthenticationToken){%>

        <jsp:include page="components/headerLogin.jsp"/>

    <%}else {%>

        <jsp:include page="components/headerUser.jsp"/>

    <%};%>
</header> <!-- End of header -->
