<%@ page import="lv.javaguru.java2.domain.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
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
    <%
        // Getting model and splitting it into meaningfull components
        Map<String, Object> model = (Map<String, Object>)request.getAttribute("model");
        List<Product> products = (List<Product>)model.get("searchResult");
        Integer resultCount = (Integer)model.get("resultCount");

        List<String> categoryNames = (List<String>)model.get("categoryNames");
        List<Long> productsInCategory = (List<Long>)model.get("productsInCategory");
    %>

    <div  class="content request-wrap">
        <div class="category-list" style="float: left;">
            <h1>Категории</h1>
            <ul>

                <% for(int i = 0; i < categoryNames.size(); i++) { %>
                    <li>
                        <a href="<%=request.getContextPath()%>/prod?categ=<%=categoryNames.get(i)%>">
                            <%=categoryNames.get(i)%>
                        </a>
                        <span> (<%=productsInCategory.get(i)%>)</span>
                    </li>
                <%}%>

            </ul>
        </div><!--End of category-list -->
        <div class="req-container">

            <p> Найдено <strong><%=resultCount%></strong>
                результатов по запросу
                <strong>"<%=model.get("query")%>"</strong>
            </p>
            <div class="merch-list">

                <!-- Product- list -->
                <% for (Product product : products) { %>
                    <div class="record">
                        <a href="<%=request.getContextPath()%>/details?prod=<%=product.getProductID()%>">
                            <img src="<%=resPath%>/images/cat.jpg"/>
                        </a>

                        <a href="<%=request.getContextPath()%>/details?prod=<%=product.getProductID()%>">
                            <span><%=product.getName()%></span>
                        </a>

                        <a href="<%=request.getContextPath()%>/details?prod=<%=product.getProductID()%>">
                            <p>
                                <%=product.getDescription()%>
                            </p>
                        </a>
                        <span class="datetime"><%=product.getDate()%></span>

                    </div>
                <%}%>
                <!-- End of product list -->

            </div> <!-- End of merch-list-->
        </div><!-- End of req-container -->
    </div> <!-- End of content -->
</div> <!-- End of container -->
<%@ include file="components/footer.jsp" %> <!-- footer -->
</body>
</html>
