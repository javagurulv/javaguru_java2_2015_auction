<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 2/17/2015
  Time: 8:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- Declaring JSP variable--%>
<% String resPath = request.getContextPath()+"/staticRes";%>
<%-- Added by Vlad --%>

<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="<%=resPath%>/css/genStyles.css"/>
    <link type="text/css" rel="stylesheet" href="<%=resPath%>/css/itemStyles.css"/>
</head>
<body>
<div class="container">
    <%@ include file="components/header.jsp" %> <!-- Header -->
    <%@ include file="components/top-banner.jsp" %> <!-- Header -->
    <%@ include file="components/navigation.jsp" %> <!-- Navigation -->
    <%@ include file="components/search.jsp" %> <!-- Search -->
    <div  class="content request-wrap">
        <div class="category-list" style="float: left;">
            <h1>Категории</h1>
            <ul>
                <li>Котята<span> (0)</span></li>
                <li>Цветы<span> (0)</span></li>
                <li>Конфеты<span> (0)</span></li>
                <ul>
                    <li>Мормелад<span> (0)</span></li>
                    <li>Шоколад<span> (0)</span></li>
                </ul>
                <li>Ёлочные игрушки<span>  (0)</span></li>
            </ul>
        </div><!--End of category-list -->
        <div class="req-container">
            <p><strong>4</strong> результатов по запросу <strong>Котики</strong></p>
            <div class="merch-list">
                <% for (int i = 0; i < 4; i++) { %>
                    <div class="record">
                        <img src="<%=resPath%>/images/cat.jpg"/>
                        <span>Котята. Милые и пушистые! Спешите, товар огрвничен!</span>
                        <p>Котята отличаются особой мягкостью.
                            Котята отличаются особой мягкостью.
                            Котята отличаются особой мягкостью.
                        </p>
                    </div>
                <%}%>
            </div> <!-- End of merch-list-->
        </div><!-- End of req-container -->
    </div> <!-- End of content -->
</div> <!-- End of container -->
<%@ include file="components/footer.jsp" %> <!-- footer -->
</body>
</html>
