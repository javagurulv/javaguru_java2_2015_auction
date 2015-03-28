<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 2/18/2015
  Time: 6:02 PM
  To change this template use File | Settings | File Templates.
--%>

<%-- Declaring JSP variable--%>
<% String resPath = request.getContextPath()+"/staticRes";%>
<%-- Added by Vlad --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <div  class="content registr-wrap" style="height: 300px;">
        <form name="authorization" action="<%=request.getContextPath()%>/login" method="post">
            <table>
                <colgroup>
                    <col class="col1">
                    <col class="col2">
                </colgroup>
                <tr>
                    <th colspan="2">
                        Авторизация
                    </th>
                </tr>
                <tr>
                    <td class="inright">
                        Логин:
                    </td>
                    <td>
                        <input type="text" name="username"/>
                    </td>
                </tr>
                <tr>
                    <td class="inright">
                        Пароль:
                    </td>
                    <td>
                        <input type="password" name="password"/>
                    </td>
                </tr>
                <tr>
                    <td class="reg-bottom" colspan="2">
                        <div>
                            <input type="submit" value="Войти"/>
                        </div>
                    </td>
                </tr>
            </table>
        </form>
        <div class="message">
            <p>Для того, чтоб по ссылке вам
                необхадимо авторизироваться в системе!
            </p>
        </div>
    </div> <!-- End of content -->
</div> <!-- End of content-wrap -->
<%@ include file="components/footer.jsp" %> <!-- footer -->
</body>
</html>