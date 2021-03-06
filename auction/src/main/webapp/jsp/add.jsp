<%@ page import="java.util.Map" %>
<%@ page import="lv.javaguru.java2.domain.Product" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 2/18/2015
  Time: 5:51 PM
--%>
<%--
    Use this html page template to create from it whatever you like!
--%>
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
        <div class="menu-list" style="float: left;">
            <%@ include file="components/sales-menu-content.jsp" %> <!-- left-content -->
        </div><!--End of menu-list -->
        <div class="right-container">
            <%
                // Getting model and splitting it into meaningfull components
                Map<String, Object> model = (Map<String, Object>)request.getAttribute("model");

                List<String> categoryNames = (List<String>)model.get("categoryNames");
            %>

            <div class="product-form">
                <form name="add-product" method="POST" action="">
                    <h3>Разместить товар</h3>
                    <div>
                        <h2>Заголовок товара</h2>
                        <input type="text" name="name">
                        <p>Длина заголовка продукта должна составлять
                            не больше чем 50 символов.</p>
                    </div>
                    <div>
                        <h2>Категория</h2>
                        <select name="category">
                            <% for (String category : categoryNames){ %>
                                <option value="<%=category%>"><%=category%></option>
                            <%}%>
                        </select>
                    </div>
                    <div>
                        <h2>Фото товара</h2>
                        <input type="file" name="image">
                    </div>
                    <div>
                        <h2>Опишите</h2>
                        <textarea name="description" cols="40" rows="5" ... ></textarea>
                    </div>
                    <div class = "price-container">
                        <span>Цена</span>
                        <input type="text" name="price" class="price">

                    </div>
                    <div class="button-container">
                        <input type="submit" value="Добавить">
                        <input type="reset" value="Обнулить">
                        <input type="submit" value="Назат">
                    </div>
                </form>

            </div><!-- End of product-form -->
        </div><!-- End of right-container -->
    </div> <!-- End of content -->

</div> <!-- End of content-wrap -->
<%@ include file="components/footer.jsp" %> <!-- footer -->
</body>
</html>
