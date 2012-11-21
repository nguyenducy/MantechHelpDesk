<%-- 
    Document   : sitemap
    Created on : Oct 24, 2012, 10:39:51 AM
    Author     : NGUYEN
--%>

<%@page import="mantech.mod.article.entity.Article"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Sitemap - Sitemap Page </title>
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

    <body id="page6" onload="new ElementMaxHeight();">
        <!-- header -->
        <jsp:include page="header.jsp"/>
        <!-- content -->
        <div id="content"><div class="inner_copy">More <a href="http://www.templates.com/">Website Templates</a> @ Templates.com!</div>
            <div class="container">
                <div class="wrapper">
                    <div class="aside maxheight">
                        <div class="indent">
                            <h2>Latest News</h2><%
                                        List<Article> articles = (List<Article>) session.getAttribute("listArticle");
                            %>
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
                            <h2>Site Map</h2>
                            <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum.</p>
                            <ul class="list">
                                <li><a href="home.jsp">Home</a></li>
                                <li><a href="about.jsp">About Us</a></li>
                                <li><a href="services.jsp">Services</a></li>
                                <li><a href="support.jsp">Support</a></li>
                                <li><a href="contacts.jsp">Complaint</a></li>
                                <li><a href="sitemap.html">Site Map</a></li>
                            </ul>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ornare lobortis elit vel venenatis. Vivamus magna arcu, placerat in elementum quis, luctus et magna. Aenean pharetra quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio.</p>
						Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque.
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
					Copyright - Type in your name here<br />
					Designed by &nbsp;<a href="http://www.templates.com/"><img src="images/t-com_logo.gif" alt="website templates" title="templates.com - website templates provider" /></a>&nbsp; Your <a href="http://www.templates.com/product/3d-models/">3D Models</a> Marketplace
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript"> Cufon.now(); </script>
    </body>
</html>