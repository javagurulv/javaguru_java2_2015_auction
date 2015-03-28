<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>Меню</h1>
<ul>
    <a href="<%=request.getContextPath()%>/prot/add"><li>Разместить товар</li></a>
    <a href="<%=request.getContextPath()%>/prot/userSale"><li>Размещённые лоты</li></a>
    <a href="<%=request.getContextPath()%>/prot/userBought"><li>Приобретённые лоты</li></a>
    <a href="<%=request.getContextPath()%>/prot/category"><li>Управление категориями</li></a>
</ul>