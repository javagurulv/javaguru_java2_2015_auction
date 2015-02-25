<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 2/25/2015
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<header>
    <div class="logo">
        <span>Logo</span>
    </div>
    <div class="account">
        <form action="<%=request.getContextPath()%>/register">
            <button>Регистрация</button>
        </form>
        <form name="account" action="#" method="post">
            <input type="text" name="login" placeholder="Логин">
            <input type="password" name="password" placeholder="Пароль">
            <button type="submit">Войти</button>
        </form>
    </div>
</header> <!-- End of header -->
