<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 2/18/2015
  Time: 6:02 PM
  To change this template use File | Settings | File Templates.
--%>

<%-- Declaring JSP variable--%>
<% String resPath = request.getContextPath()+"/staticRes";%>
<%-- Added by Vlad --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <div  class="content registr-wrap">
        <form name="registration" action="" method="post">
            <table>
                <colgroup>
                    <col class="col1">
                    <col class="col2">
                </colgroup>
                <tr>
                    <th colspan="2">
                        Регистрационная информация
                    </th>
                </tr>
                <tr>
                    <td class="inright">
                        Имя:
                    </td>
                    <td>
                        <input type="text" name="username"/>
                    </td>
                </tr>
                <tr>
                    <td class="inright">
                        Email:
                    </td>
                    <td>
                        <input type="text" name="email"/>
                    </td>
                </tr>
                <tr>
                    <td class="inright">
                        Пароль:
                    </td>
                    <td>
                        <input type="password" name="pass"/>
                    </td>
                </tr>
                <tr>
                    <td class="inright">
                        Пол:
                    </td>
                    <td>
                        <input type="radio" name="gender" value="male">Мужской</input></br>
                        <input type="radio" name="gender" value="female">Женский</input></br>
                        <input type="radio" name="gender" value="undefined">Не определедился</input>
                    </td>
                </tr>
                <tr>
                    <td class="reg-bottom" colspan="2">
                        <div>
                            <input type="submit" value="Отправить"/>
                        </div>
                    </td>
                </tr>
            </table>
        </form>
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
            <a href="http://twitter.com/" ><img class="social-icon resize-effect" src="<%=resPath%>/icon/tweeter.png"/></a>
            <a href="http://facebook.com/"><img class="social-icon resize-effect" src="<%=resPath%>/icon/fb.png"/></a>
            <a href="http://plus.google.com/"><img class="social-icon resize-effect" src="<%=resPath%>/icon/gplus.png"/></a>
            <a href="http://instagram.com/"><img class="social-icon-small resize-effect" src="<%=resPath%>/icon/insta.png"/></a>
            <a href="http://youtube.com/"><img class="social-icon-small resize-effect" src="<%=resPath%>/icon/ytube.png"/></a>
            <a href="http://vimeo.com/"><img class="social-icon-small resize-effect" src="<%=resPath%>/icon/vimeo.png"/></a>
            <a href="/rss/"><img class="social-icon-small resize-effect" src="<%=resPath%>/icon/tfeed.png"/></a>
        </div>
        <div id="footer-logo">
            <img src="<%=resPath%>/images/copyrightdemo.png" width="70%" height="70%" alt="copyright logo"/>
            <p>Copyright © 2014</p>.
        </div>
    </div><!-- End footerpan -->
</footer> <!-- End of footer -->
</body>
</html>