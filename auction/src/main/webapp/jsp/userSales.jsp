<%@ page import="java.util.Map" %>
<%@ page import="lv.javaguru.java2.domain.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- Declaring JSP variable--%>
<% String resPath = request.getContextPath()+"/staticRes";%>
<%-- Added by Vlad --%>

<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="<%=resPath%>/css/genStyles.css">
    <link type="text/css" rel="stylesheet" href="<%=resPath%>/css/itemStyles.css">
</head>
<body>
<div class="container">
    <%@ include file="components/header.jsp" %> <!-- Header -->
    <%@ include file="components/top-banner.jsp" %> <!-- Header -->
    <%@ include file="components/navigation.jsp" %> <!-- Navigation -->
    <%@ include file="components/search.jsp" %> <!-- Search -->
    <div  class="content sales-content">
        <%
            // Getting model and splitting it into meaningfull components
            Map<String, Object> model = (Map<String, Object>)request.getAttribute("model");
            List<Product> products = (List<Product>)model.get("products");
            String heading = (String)model.get("heading");
        %>

        <h1 class="content-header">Торговля</h1>
        <!-- Left menu -->
        <div class="menu-list" style="float: left;">
            <%@ include file="components/sales-menu-content.jsp" %> <!-- left-content -->
        </div><!--End of menu-list -->
        <div class="right-container">
            <p><%=heading%></p>
            <div class="product-list">
                <% for(Product product: products) {%>
                    <div class="product-record">
                        <div class="img-box">
                            <img src="https://placekitten.com/g/200/250"/>
                        </div>
                        <div class="descr-box">
                            <h1><%=product.getName()%></h1>
                            <p> <%=product.getDescription()%></p>

                        </div>
                        <div  class="price-box">
                            <p>Цена: <%=product.getPrice().toString()%>$</p>
                        </div>
                    </div> <!-- End of product-record-->

                <%}%>

            </div><!-- End of product-list -->
        </div><!-- End of right-container -->
    </div> <!-- End of content -->
</div> <!-- End of content-wrap -->
<%@ include file="components/footer.jsp" %> <!-- footer -->
</body>
</html>
