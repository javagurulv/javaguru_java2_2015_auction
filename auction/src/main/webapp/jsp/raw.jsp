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
    <div class="content-wrap">
        <h1>Главный банер</h1>
    </div> <!-- End of content-wrap -->
    <nav>
        <a href="<%=request.getContextPath()%>/index"><div>Главная</div></a>
        <div>
            Торговля
        </div>
        <div>
            Управление
        </div>
        <div>
            О нас
        </div>
    </nav> <!-- End of navigation -->
    <div class="search-bar">
        <form name="search" action="list.html" method="get">
            <button type="submit">Искать</button>
            <input type="text" name="q" placeholder="Поиск">
        </form>
    </div>
    <div  class="content">
        <!-- add your stuff here -->
        content



        <!-- ------------------- -->
    </div> <!-- End of content -->
</div> <!-- End of content-wrap -->
<footer>
    <div id="footerpan">
        <div id="twitter">
            <h3>TWITTER FEED</h3>
            <time datetime="2012-10-23"><a href="#">23 oct</a></time>
            <p>Twitterfeed is not affiliated with Twitter, Inc.
                Twitterfeed licenses the trademark "Twitter" from Twitter, Inc.
            </p>
        </div>
        <div id="sitemap">
            <h3>Карта сайта</h3>
            <div>
                <a href="index.html">Главная</a>
            </div>
        </div>
        <div id="social">
            <h3>Социальные сети</h3>
            <a href="http://twitter.com/" ><img class="social-icon resize-effect" src="<%=resPath%>/icons/tweeter.png"/></a>
            <a href="http://facebook.com/"><img class="social-icon resize-effect" src="<%=resPath%>/icons/fb.png"/></a>
            <a href="http://plus.google.com/"><img class="social-icon resize-effect" src="<%=resPath%>/icons/gplus.png"/></a>
            <a href="http://instagram.com/"><img class="social-icon-small resize-effect" src="<%=resPath%>/icons/insta.png"/></a>
            <a href="http://youtube.com/"><img class="social-icon-small resize-effect" src="<%=resPath%>/icons/ytube.png"/></a>
            <a href="http://vimeo.com/"><img class="social-icon-small resize-effect" src="<%=resPath%>/icons/vimeo.png"/></a>
            <a href="/rss/"><img class="social-icon-small resize-effect" src="<%=resPath%>/icons/tfeed.png"/></a>
        </div>
        <div id="footer-logo">
            <img src="<%=resPath%>/images/copyrightdemo.png" width="70%" height="70%" alt="copyright logo"/>
            <p>Copyright © 2014</p>.
        </div>
    </div><!-- End footerpan -->
</footer> <!-- End of footer -->
</body>
</html>
