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


                        <% String data = (String)request.getAttribute("model");
                           if (data != null) {%>
                              <%=data +" "%>

                           <%}
                        %>


                        Регистрационная информация
                    </th>
                </tr>
                <tr>
                    <td class="inright">
                        Имя:
                    </td>
                    <td>
                        <input type="text" name="firstName"/>
                    </td>
                </tr>
                <tr>
                    <td class="inright">
                        Фамилия:
                    </td>
                    <td>
                        <input type="text" name="lastName"/>
                    </td>
                </tr>
                <tr>
                    <td class="inright">
                        Логин:
                    </td>
                    <td>
                        <input type="text" name="login"/>
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
                        <input type="password" name="password"/>
                    </td>
                </tr>
                <tr>
                    <td class="inright">
                        Пол:
                    </td>
                    <td>
                        <input type="radio" name="avatar" value="male">Мужской</input></br>
                        <input type="radio" name="avatar" value="female">Женский</input></br>
                        <input type="radio" name="avatar" value="undefined">Не определедился</input>
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
            <div class="message">
                <p><% if (data!=null){%><%=data%><%}%> </p>
            </div>
        </form>
    </div> <!-- End of content -->
</div> <!-- End of content-wrap -->
<%@ include file="components/footer.jsp" %> <!-- footer -->
</body>
</html>