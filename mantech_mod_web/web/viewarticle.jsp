<%--
    Document   : home
    Created on : Oct 24, 2012, 10:36:32 AM
    Author     : NGUYEN
--%>

<%@page import="mantech.mod.article.entity.Faq"%>
<%@page import="org.apache.jasper.tagplugins.jstl.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="mantech.mod.article.api.ArticleBiz"%>
<%@page import="mantech.mod.article.entity.Article"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<c:if test="${empty sessionScope.listArticle}">
            <c:redirect url="/ListArticleServlet"/>
      </c:if>
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
   <%
        List<Article> articles = (List< Article>)session.getAttribute("listArticle");
   %>
    <body id="page1" onload="new ElementMaxHeight();">
        <!-- header -->
        <jsp:include page="header.jsp"/>
        <!-- content -->
        <div id="content"><div class="inner_copy">More <a href="http://www.templates.com/">Website Templates</a> @ Templates.com!</div>
            <div class="container">
                <div class="wrapper">
                    <div class="aside maxheight">
                        <div class="indent">
                            <h2>Latest News</h2>
                            <dl class="news">
                                 <%
                                   for(int i=0;i<=articles.size();i++){
                                       if(i==5){
                                           break;
                                           }
                                       Article article = articles.get(i);


                                %>
                                <dt><a href="ViewArticle?id=<%= article.getId().toString() %>"><%= article.getArticle() %></a></dt>
                                    <dd><%=article.getContent() %> ></dd>
                                 <%}%>
                            </dl>
                        </div>
                    </div>
                    <div class="mainContent maxheight">
                        <div class="indent">
                            <%--<div class="section">
                                <h2>Welcome High Technologies!</h2>
                                <p>High Technologies Site is a free websites template created by Templates.com team. This website template is optimized for 1024X768 screen resolution. It is also XHTML &amp; CSS valid.</p>
                                <p>The website template goes with two packages – with PSD source files and without them. PSD source files are available for free for the registered members of Templates.com. The basic package (without PSD is available for anyone without registration).</p>
							This website template has several pages: <a href="#">Home</a>, <a href="#">About us</a>, <a href="#">Services</a>, <a href="#">Support</a>, <a href="#">Contacts</a> (note that contact us form – doesn’t work), <a href="#">Site Map</a>.
                            </div>--%>
                            
                            <%
                                Article article = (Article)session.getAttribute("article");
                            %>

                            <ul class="img-list">
                               
                                <li>

                                    <dl>
                                        <dt><h2><%=article.getArticle() %></h2></dt>
                                        <img src="<%= article.getThumbnail() %>" alt="NotAvailable" height="300" width="300" />
                                        <dd> <%=article.getContent()%></dd>
                                    </dl>

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
