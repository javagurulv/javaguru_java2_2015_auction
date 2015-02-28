<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 2/25/2015
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- This header context will be displayed if user have not logged in yet -->
<div class="logo">
    <span>Logo</span>
</div>
<div class="account">
    <form action="<%=request.getContextPath()%>/register">
        <button>Регистрация</button>
    </form>
    <form name="account-form" action="<%=request.getContextPath()%>/auth" method="post">
        <input type="hidden" name="type" value="account-form" />
        <input type="text" name="login" placeholder="Логин">
        <input type="password" name="password" placeholder="Пароль">
        <button type="submit">Войти</button>
    </form>
</div>

