<%@ page import="java.util.List" %>
<%@ page import="lv.javaguru.java2.domain.ProductCategory" %>
<%--
  Created by IntelliJ IDEA.
  User: Marks Namavirs
  Date: 19.03.2015
--%>
<%--
    Use this html page template to create from it whatever you like!
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- Declaring JSP variable--%>
<% String resPath = request.getContextPath()+"/staticRes";%>


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
            <div class="product-form">
                <form name="category" action="" method="post">
                    <h3>Управление категориями</h3>


                    <div>
                        <h2>Введите названия категории для добавления</h2>
                        <input type="text" name="CategoryName">
                    </div>


                          <div class="button-container">
                              <input type="submit" value="Добавить" name="AddBTN">

                          </div>


                    <div>
                        <h2>Выберите категорию для удаления</h2>
                        <% List<ProductCategory> categoryList = (List<ProductCategory>)request.getAttribute("model");
                            if (categoryList != null) {
                        %>       <select name="DeleteCategory">
                                 <% for (ProductCategory category : categoryList) {%>
                                     <%= "<option value='"+category.getCategoryId()+"'>"+category.getName()+"</option>" %>

                                <%}
                                %> </select> <%
                            }
                                             %>
                    </div>


                    <div class="button-container">
                        <input type="submit" value="Удалисть" name="DeleteBTN">

                    </div>



                </form>

            </div><!-- End of product-form -->
        </div><!-- End of right-container -->
    </div> <!-- End of content -->

</div> <!-- End of content-wrap -->
<%@ include file="components/footer.jsp" %> <!-- footer -->
</body>
</html>
