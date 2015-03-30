<%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 22-Feb-15
  Time: 5:25 PM
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
        <!-- add your stuff here -->

        <div style="float: left">
            <div style="background-color: gainsboro; padding: 10px">
                <span style="font-size: 200%"> Добавить $5.00 USD</span> <br/>
                <form name="balance1" method="post">
                    <input type="hidden" name="reinforcement" value="5">
                    <button type="submit">Пополнить</button>
                </form>
            </div>

            <div style="background-color: gainsboro; padding: 10px">
                <span style="font-size: 200%"> Добавить $10.00 USD</span> <br/>
                <form name="balance2" method="post">
                    <input type="hidden" name="reinforcement" value="10">
                    <button type="submit">Пополнить</button>
                </form>
            </div>

            <div style="background-color: gainsboro; padding: 10px">
                <span style="font-size: 200%"> Добавить $15.00 USD</span> <br/>
                <form name="balance3" method="post">
                    <input type="hidden" name="reinforcement" value="15">
                    <button type="submit">Пополнить</button>
                </form>
            </div>

            <div style="background-color: gainsboro; padding: 10px">
                <span style="font-size: 200%"> Добавить $20.00 USD</span> <br/>
                <form name="balance4" method="post">
                    <input type="hidden" name="reinforcement" value="20">
                    <button type="submit">Пополнить</button>
                </form>
            </div>
        </div>

        <%
            String balance = (String)request.getAttribute("model");
        %>
        <div style="float: right; background-color: gainsboro; padding: 10px">
            <span style="font-size: 150%">Осталось на счету <span><%=balance%></span> </span> <!--Money stuff-->
            <button type="submit">Подробности</button>

        </div>


        <!-- ------------------- -->
    </div> <!-- End of content -->
</div> <!-- End of content-wrap -->
<%@ include file="components/footer.jsp" %> <!-- footer -->
</body>
</html>