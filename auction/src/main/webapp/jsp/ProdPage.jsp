<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 2/17/2015
  Time: 8:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="../staticRes/css/genStyles.css">
    <link type="text/css" rel="stylesheet" href="../staticRes/css/itemStyles.css">
</head>
<body>
<div class="container">
    <header>
        <div class="logo">
            <span>Logo</span>
        </div>
        <div class="account">
            <form action="register.html">
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
        <div>
            Главная
        </div>
        <div>
            Кнопка
        </div>
        <div>
            Кнопка
        </div>
        <div>
            Кнопка
        </div>
    </nav> <!-- End of navigation -->
    <div class="search-bar">
        <form name="search" action="list.html" method="get">
            <button type="submit">Искать</button>
            <input type="text" name="q" placeholder="Поиск">
        </form>
    </div>
    <div  class="content request-wrap">
        <div class="category-list" style="float: left;">
            <h1>Категории</h1>
            <ul>
                <li>Котята<span> (0)</span></li>
                <li>Цветы<span> (0)</span></li>
                <li>Конфеты<span> (0)</span></li>
                <ul>
                    <li>Мормелад<span> (0)</span></li>
                    <li>Шоколад<span> (0)</span></li>
                </ul>
                <li>Ёлочные игрушки<span>  (0)</span></li>
            </ul>
        </div><!--End of category-list -->
        <div class="req-container">
            <p><strong>4</strong> результатов по запросу <strong>Котики</strong></p>
            <div class="merch-list">
                <div class="record">
                    <img src="../staticRes/images/cat.jpg"/>
                    <span>Котята. Милые и пушистые! Спешите, товар огрвничен!</span>
                    <p>Котята отличаются особой мягкостью.
                        Котята отличаются особой мягкостью.
                        Котята отличаются особой мягкостью.
                    </p>

                </div>
                <div class="record">
                    <img src="../staticRes/images/cat.jpg"/>
                    <span>Котята. Милые и пушистые! Спешите, товар огрвничен!</span>
                    <p>Котята отличаются особой мягкостью</p>
                </div>
                <div class="record">
                    <img src="../staticRes/images/cat.jpg"/>
                    <span>Котята. Милые и пушистые! Спешите, товар огрвничен!</span>
                </div>
                <div class="record">
                    <img src="../staticRes/images/cat.jpg"/>
                    <span>Котята. Милые и пушистые! Спешите, товар огрвничен!</span>
                </div>
            </div> <!-- End of merch-list-->
        </div><!-- End of req-container -->
    </div> <!-- End of content -->
</div> <!-- End of container -->
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
            <a href="http://twitter.com/" ><img class="social-icon resize-effect" src="../staticRes/icons/tweeter.png"/></a>
            <a href="http://facebook.com/"><img class="social-icon resize-effect" src="../staticRes/icons/fb.png"/></a>
            <a href="http://plus.google.com/"><img class="social-icon resize-effect" src="../staticRes/icons/gplus.png"/></a>
            <a href="http://instagram.com/"><img class="social-icon-small resize-effect" src="../staticRes/icons/insta.png"/></a>
            <a href="http://youtube.com/"><img class="social-icon-small resize-effect" src="../staticRes/icons/ytube.png"/></a>
            <a href="http://vimeo.com/"><img class="social-icon-small resize-effect" src="../staticRes/icons/vimeo.png"/></a>
            <a href="/rss/"><img class="social-icon-small resize-effect" src="../staticRes/icons/tfeed.png"/></a>
        </div>
        <div id="footer-logo">
            <img src="../staticRes/images/copyrightdemo.png" width="70%" height="70%" alt="copyright logo"/>
            <p>Copyright © 2014</p>.
        </div>
    </div><!-- End footerpan -->
</footer> <!-- End of footer -->
</body>
</html>
