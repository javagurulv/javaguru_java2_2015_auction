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

        <h1>Title</h1> <!--No comments needed, but ok, Title-->
        Description: description<!-- Product description must be here--><br/>
        Category: Great<!--Product category--><br/>
        Price: 9.99$ <!--Product price--> <button type="submit">BUY</button> <br/>
        <img src="<%=resPath%>/images/cat.jpg"/> <!--image of the product--> Date: <time>2.01.2015</time>


        <!-- ------------------- -->
    </div> <!-- End of content -->
</div> <!-- End of content-wrap -->
<%@ include file="components/footer.jsp" %> <!-- footer -->
</body>
</html>