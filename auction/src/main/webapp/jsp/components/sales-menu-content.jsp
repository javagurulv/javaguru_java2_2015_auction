<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>Меню</h1>
<ul>
    <a href="<%=request.getContextPath()%>/add"><li>Разместить товар</li></a>
    <a href="<%=request.getContextPath()%>/onSale"><li>Размещённые лоты</li></a>
    <li>Приобретённые лоты</li>
</ul>