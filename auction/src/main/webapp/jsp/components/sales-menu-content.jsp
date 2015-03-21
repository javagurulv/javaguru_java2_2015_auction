<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>Меню</h1>
<ul>
    <a href="<%=request.getContextPath()%>/add"><li>Разместить товар</li></a>
    <a href="<%=request.getContextPath()%>/userSale"><li>Размещённые лоты</li></a>
    <a href="<%=request.getContextPath()%>/userBought"><li>Приобретённые лоты</li></a>
    <a href="<%=request.getContextPath()%>/category"><li>Управление категориями</li></a>
</ul>