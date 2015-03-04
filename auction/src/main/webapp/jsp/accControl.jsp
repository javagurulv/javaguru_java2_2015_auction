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
    <div  class="content sales-content">
        <h1 class="content-header">Управление</h1>
        <!-- Left menu -->
        <div class="menu-list" style="float: left;">
            <%@ include file="components/options-menu-content.jsp" %> <!-- left-content -->
        </div><!--End of menu-list -->
        <div class="right-container">
            <div class="account-form">

                <h3>Учётная запись</h3>



                <form>
                    <fieldset>
                        <legend>Электронная почта:</legend>
                        <p>Ваша почта: Vasja@Vasja.lv</p>

                        <input type="text" class="with-button">
                        <input type="submit" value="обновить" class="small-button">
                    </fieldset>
                </form>

                <form>
                    <fieldset>
                        <legend>Смена пароля:</legend>
                        Текуший пароль: <br><input type="text"><br>
                        Новый пароль: <br><input type="text"><br>
                        Повторить пароль: <br><input type="text"><br>
                        <br><input type="submit" value="сменить пароль">
                    </fieldset>
                </form>

            </div><!-- End of product-form -->

        </div><!-- End of right-container -->
    </div> <!-- End of content -->
</div> <!-- End of content-wrap -->
<%@ include file="components/footer.jsp" %> <!-- footer -->
</body>
</html>
