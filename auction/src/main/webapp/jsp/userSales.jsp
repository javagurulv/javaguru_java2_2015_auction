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
        <h1 class="content-header">Торговля</h1>
        <!-- Left menu -->
        <div class="menu-list" style="float: left;">
            <%@ include file="components/sales-menu-content.jsp" %> <!-- left-content -->
        </div><!--End of menu-list -->
        <div class="right-container">
            <p>Размещённые лоты</p>
            <div class="product-list">
                <% for(int i = 0; i < 4; i++) {%>
                    <div class="product-record">
                        <div class="img-box">
                            <img src="https://placekitten.com/g/200/250"/>
                        </div>
                        <div class="descr-box">
                            <h1>Великолепный котик</h1>
                            <p> Описание Описание Описание</p>

                        </div>
                        <div  class="price-box">
                            <p>Цена: 14.99$</p>
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
