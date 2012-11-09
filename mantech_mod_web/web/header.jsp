<%-- 
    Document   : header
    Created on : Nov 2, 2012, 10:25:35 PM
    Author     : NGUYEN
--%>

<%@page import="mantech.mod.session.SessionName"%>
<div id="header">
    <div class="bg">
        <div class="container">
            <div class="row-1">
                <div class="wrapper">
                    <div class="fleft"><a href="home.jsp"><img src="images/logo.jpg" alt="" /></a></div>
                    <ul class="top-links">
                        <li class="first"><a href="home.jsp" class="home"></a></li>
                        <li><a href="contacts.jsp" class="mail"></a></li>
                        <li class="last"><a href="sitemap.jsp" class="sitemap"></a></li>
                    </ul>
                </div>
            </div>
            <div class="row-2">
                <!-- .nav -->
                <ul class="nav">
                    <li><a href="home.jsp">Home</a></li>
                    <li><a href="about.jsp" class="current">About</a></li>
                    <li><a href="services.jsp">Services</a></li>
                    <li><a href="support.jsp">Support</a></li>
                    <li><a href="contacts.jsp">Complaint</a></li>
                </ul>
                <!-- /.nav -->
            </div>
            <div class="row-3">
                <img src="images/slogan.jpg" alt="" class="slogan" /><br />
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip.</p>
                
                <jsp:include page="includes/modules/login.jsp"/>
            </div>
        </div>
    </div>
</div>
