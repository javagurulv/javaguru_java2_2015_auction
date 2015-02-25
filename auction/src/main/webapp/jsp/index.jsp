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
    <div  class="content index-page">
        <h1 class="content-header">Главная</h1>
        <h2>Рекомендуемые предложения</h2>
        <div class="record-line">
            <% for(int i = 0; i < 4; i++) { %> <!-- Showing 4 records with java -->
                <div class="inline-record">
                    <div class="image-container"><img src="https://placekitten.com/g/230/230"/></div>
                    <h1>Самый лучший в мире котик</h1>
                    <p>Цена: <em>150$</em><p>
                    <span>22.02.15</span>
                </div>
            <%}%>
        </div><!-- End of record-line -->
        <h2>Последние просмотренные</h2>
        <div class="record-line">
            <% for(int i = 0; i < 4; i++) { %> <!-- Showing 4 records with java -->
                <div class="inline-record">
                    <div class="image-container"><img src="https://placekitten.com/g/230/230"/></div>
                    <h1>Самый лучший в мире котик</h1>
                    <p>Цена: <em>150$</em><p>
                    <span>22.02.15</span>
                </div>
            <%}%>
        </div><!-- End of record-line 2-->
    </div> <!-- End of content -->
</div> <!-- End of content-wrap -->
<%@ include file="components/footer.jsp" %> <!-- footer -->
</body>
</html>
