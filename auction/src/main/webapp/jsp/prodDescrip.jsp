<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.Objects" %>
<%@ page import="java.util.Map" %>
<%@ page import="lv.javaguru.java2.domain.Product" %>
<%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 22-Feb-15
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
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
    <div  class="content">
        <%

            // Getting data send from user
            Map<String, Object> model = (Map<String, Object>)request.getAttribute("model");
            Product product = (Product)model.get("product");

            boolean userIsLoggedIn = !(auth instanceof AnonymousAuthenticationToken);
            boolean productBelongsToUser = product.getUser().equals(user);
        %>


        <h1><%=product.getName()%></h1> <!--No comments needed, but ok, Title-->
        Описание: <%=product.getDescription()%><!-- Product description must be here--><br/>
        Категоря: <%=product.getCategory().getName()%><!--Product category--><br/>
        Цена: <%=product.getPrice()%>$ <!--Product price-->



         <%
          //Don't display button when not needed
          if ((!productBelongsToUser)&&(userIsLoggedIn)){
         %>
                <form method="post">
                    <input type="hidden" name="boughtProductID" value="<%=product.getProductID()%>">
                    <button type="submit">BUY</button>
                </form>
        <%}%>
        <br/>

        <img src="<%=resPath%>/images/cat.jpg"/> <!--image of the product--> Date: <time>2.01.2015</time>


        <!-- ------------------- -->
    </div> <!-- End of content -->
</div> <!-- End of content-wrap -->
<%@ include file="components/footer.jsp" %> <!-- footer -->
</body>
</html>