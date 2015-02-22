<%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 22-Feb-15
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
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

        <h1>Title</h1> <!--No comments needed, but ok, Title-->
        Description: description<!-- Product description must be here--><br/>
        Category: Great<!--Product category--><br/>
        Price: 9.99$ <!--Product price--> <button type="submit">BUY</button> <br/>
        <img src="<%=resPath%>/images/cat.jpg"/> <!--image of the product--> Date: <time>2.01.2015</time>


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