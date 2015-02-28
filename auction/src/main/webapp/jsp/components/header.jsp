<%@ page import="lv.javaguru.java2.domain.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 2/25/2015
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User user = null;
    user = (User)session.getAttribute("User");
%>

<header>
    <% if (user==null){%>
        <jsp:include page="components/headerLogin.jsp"/>
    <%}else {%>
        <jsp:include page="components/headerUser.jsp"/>
    <%};%>
</header> <!-- End of header -->
