<%--
  Created by IntelliJ IDEA.
  User: Marks Namavirs
  Date: 15.22.3
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String resPath = request.getContextPath()+"/staticRes";%>


<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">

    <link rel="stylesheet" type="text/css" href="<%=resPath%>/css/genStyles.css">
    <link rel="stylesheet" type="text/css" href="<%=resPath%>/css/itemStyles.css">


</head>
<body>
<div class="container">
    <%@ include file="components/header.jsp" %> <!-- Header -->
    <%@ include file="components/top-banner.jsp" %> <!-- Header -->
    <%@ include file="components/navigation.jsp" %> <!-- Navigation -->
    <%@ include file="components/search.jsp" %> <!-- Search -->
    <div  class="content index-page">
        <h1 class="content-header">Команда разработчиков</h1>
        <h2>Марк</h2>
        <h2>Владислав</h2>
        <h2>Александер</h2>
        <h2>Анатолий</h2>
        <h2>Денис</h2>
    </div> <!-- End of content -->
</div> <!-- End of content-wrap -->
<%@ include file="components/footer.jsp" %> <!-- footer -->
</body>
</html>
