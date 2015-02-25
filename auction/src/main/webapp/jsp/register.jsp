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
    <div  class="content registr-wrap">
        <form name="registration" action="" method="post">
            <table>
                <colgroup>
                    <col class="col1">
                    <col class="col2">
                </colgroup>
                <tr>
                    <th colspan="2">
                        Регистрационная информация
                    </th>
                </tr>
                <tr>
                    <td class="inright">
                        Имя:
                    </td>
                    <td>
                        <input type="text" name="username"/>
                    </td>
                </tr>
                <tr>
                    <td class="inright">
                        Email:
                    </td>
                    <td>
                        <input type="text" name="email"/>
                    </td>
                </tr>
                <tr>
                    <td class="inright">
                        Пароль:
                    </td>
                    <td>
                        <input type="password" name="pass"/>
                    </td>
                </tr>
                <tr>
                    <td class="inright">
                        Пол:
                    </td>
                    <td>
                        <input type="radio" name="gender" value="male">Мужской</input></br>
                        <input type="radio" name="gender" value="female">Женский</input></br>
                        <input type="radio" name="gender" value="undefined">Не определедился</input>
                    </td>
                </tr>
                <tr>
                    <td class="reg-bottom" colspan="2">
                        <div>
                            <input type="submit" value="Отправить"/>
                        </div>
                    </td>
                </tr>
            </table>
        </form>
    </div> <!-- End of content -->
</div> <!-- End of content-wrap -->
<%@ include file="components/footer.jsp" %> <!-- footer -->
</body>
</html>