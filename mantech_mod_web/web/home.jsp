<%-- 
    Document   : home
    Created on : Oct 24, 2012, 10:36:32 AM
    Author     : NGUYEN
--%>

<%@page import="mantech.mod.article.entity.Article"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Home - Home Page </title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="Content-Style-Type" content="text/css" />
        <link href="style.css" rel="stylesheet" type="text/css" />
        <script src="js/maxheight.js" type="text/javascript"></script>
        <script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>
        <script src="js/cufon-yui.js" type="text/javascript"></script>
        <script src="js/cufon-replace.js" type="text/javascript"></script>
        <script src="js/Myriad_Pro_300.font.js" type="text/javascript"></script>
        <script src="js/Myriad_Pro_400.font.js" type="text/javascript"></script>
    </head>

    <body id="page1" onload="new ElementMaxHeight();">
        <!-- header -->
        <div id="header">
            <div class="bg">
                <div class="container">
                    <div class="row-1">
                        <div class="wrapper">
                            <div class="fleft"><a href="home.jsp"><img src="images/logo.jpg" alt="" /></a></div>
                            <ul class="top-links">
                                <li class="first"><a href="home.jsp" class="home-current"></a></li>
                                <li><a href="contacts.jsp" class="mail"></a></li>
                                <li class="last"><a href="sitemap.jsp" class="sitemap"></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="row-2">
                        <!-- .nav -->
                        <ul class="nav">
                            <li><a href="home.jsp" class="current">Home</a></li>
                            <li><a href="about.jsp">About</a></li>
                            <li><a href="services.jsp">Services</a></li>
                            <li><a href="support.jsp">Support</a></li>
                            <li><a href="contacts.jsp">Complaint</a></li>
                        </ul>
                        <!-- /.nav -->
                    </div>
                    <div class="row-3">
                        <img src="images/slogan.jpg" alt="" class="slogan" /><br />
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip.</p>
                        <form action="" id="login-form">
                            <table>
                                <tr>
                                    <td>Username: <input name="username" title="Username" alt="Username"/></td>
                                </tr>
                                <tr>
                                    <td>Password: &nbsp;<input name="password" type="password" title="Password"/></td>
                                </tr>
                                <tr>
                                    <td><input type="submit" value="Login" class="alt_btn"/></td>
                                </tr>

                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- content -->
        <div id="content"><div class="inner_copy">More <a href="http://www.templates.com/">Website Templates</a> @ Templates.com!</div>
            <div class="container">
                <div class="wrapper">
                    <div class="aside maxheight">
                        <div class="indent">
                            <h2>Latest News</h2>
                            <dl class="news">
                                <dt><a href="#">February 15, 2010</a></dt>
                                <dd>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium.</dd>
                                <dt><a href="#">January 31, 2010</a></dt>
                                <dd>Totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae.</dd>
                                <dt><a href="#">January 22, 2010</a></dt>
                                <dd>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugitd quia.</dd>
                            </dl>
                        </div>
                    </div>
                    <div class="mainContent maxheight">
                        <div class="indent">
                            <div class="section">
                                <h2>Welcome High Technologies!</h2>
                                <p>High Technologies Site is a free websites template created by Templates.com team. This website template is optimized for 1024X768 screen resolution. It is also XHTML &amp; CSS valid.</p>
                                <p>The website template goes with two packages – with PSD source files and without them. PSD source files are available for free for the registered members of Templates.com. The basic package (without PSD is available for anyone without registration).</p>
							This website template has several pages: <a href="#">Home</a>, <a href="#">About us</a>, <a href="#">Services</a>, <a href="#">Support</a>, <a href="#">Contacts</a> (note that contact us form – doesn’t work), <a href="#">Site Map</a>.
                            </div>
                            <%
                                        InitialContext context = null;
                                        try {
                                            context = new InitialContext();
                                            
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        } finally {
                                            context.close();
                                        }

                            %>
                            <h2>Recent Articles</h2>
                            <ul class="img-list">
                                <li>
                                    <img src="images/img1.jpg" alt="" />
                                    <h3><a href="#">High Technologies</a></h3>
								Technical progress doesn’t stand still and picks up steam every year. The most innovative technologies are developed and put on the market.
                                </li>
                                <li>
                                    <img src="images/img1.jpg" alt="" />
                                    <h3><a href="#">About High Technologies Website</a></h3>
								Free 1024/768 Optimized Website Template from Templates.com. We really hope that you will like this template and use it for your website.
                                </li>
                                <li>
                                    <img src="images/img1.jpg" alt="" />
                                    <h3><a href="#">Our services</a></h3>
								The complete information regarding our services you will find on the "Service" page.
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- footer -->
        <div id="footer">
            <div class="bg">
                <div class="container">
                    <div class="indent">
					Copyright - mrnguyen<br />
					Designed by &nbsp;<a href="http://www.templates.com/"><img src="images/t-com_logo.gif" alt="website templates" title="templates.com - website templates provider" /></a>&nbsp; Your <a href="http://www.templates.com/product/3d-models/">3D Models</a> Marketplace
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript"> Cufon.now(); </script>
    </body>
</html>
