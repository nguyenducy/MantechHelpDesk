<%-- 
    Document   : services
    Created on : Oct 24, 2012, 10:39:16 AM
    Author     : NGUYEN
--%>

<%@page import="mantech.mod.account.entity.Department"%>
<%@page import="java.util.List"%>
<%@page import="mantech.mod.account.api.DepartmentBiz"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Services - Services Page </title>
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

    <body id="page3" onload="new ElementMaxHeight();">
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
                            <h2>Services</h2>
                            <p>The complete information regarding our services you will find on the "Service" page.</p>
                            <ul class="img-list">
                                <%
                                            InitialContext context = null;
                                            try {
                                                context = new InitialContext();
                                                DepartmentBiz biz = (DepartmentBiz) context.lookup("ejb/mantech/saigon/DepartmentBiz");
                                                List<Department> list = biz.findAll();
                                                for (Department d : list) {
                                %>
                                <li>
                                    <img src="images/img5.jpg" alt="" />
                                    <h3><a href="#"><%= d.getName() %></a></h3>
                                    <%= d.getLocation() %>
                                </li>
                                <%                                              }
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            } finally {
                                                context.close();
                                            }
                                %>
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
