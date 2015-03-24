<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 2/18/2015
  Time: 5:51 PM
--%>
<%--
    Use this html page template to create from it whatever you like!
--%>
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
        </div>
        <!--End of left-menu -->
        <div class="right-container">
            <div class="account-form">


                <h3>Профиль</h3>
                <form>
                    <fieldset class="profile-set">
                        <legend>Имя:</legend>
                        <p>Ваше имя: Vasja@Vasja.lv</p>

                        <input type="text" class="with-button">
                        <input type="submit" value="обновить" class="small-button">
                    </fieldset>
                </form>


                <form>
                    <fieldset class="profile-set">
                        <legend>Фамилия:</legend>
                        <p>Ваша фамилия: Vasja@Vasja.lv</p>

                        <input type="text" class="with-button">
                        <input type="submit" value="обновить" class="small-button">
                    </fieldset>
                </form>

                <form name="avatar-upload" action="" method="post" enctype="multipart/form-data">
                    <fieldset class="profile-set">
                        <legend>Аватар:</legend>
                        <p>Ваш аватар будет виден всем пользователям</p>

                        <input type="file" name="avatar"class="with-button">
                        <input type="submit" value="обновить" class="small-button">
                        <img src="https://placekitten.com/g/200/260">
                    </fieldset>
                </form>

            </div><!-- End of product-form -->
        </div><!-- End of right-container -->
    </div> <!-- End of content -->

</div> <!-- End of content-wrap -->
<%@ include file="components/footer.jsp" %> <!-- footer -->
</body>
</html>
