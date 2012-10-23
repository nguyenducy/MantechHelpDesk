<%-- 
    Document   : admin-theme
    Created on : Sep 29, 2012, 7:32:15 PM
    Author     : NGUYEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        
        <title>Admin : <decorator:title/></title>
        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css" type="text/css" media="screen" />
        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/eggplant/jquery-ui-1.9.0.custom.min.css"/>
        <!--[if lt IE 9]>
	<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.js"></script>
        
        <script src="${pageContext.request.contextPath}/js/hideshow.js" type="text/javascript"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui-1.9.0.custom.min.js"></script>
    </head>
    <body>
    <header id="header">
        <jsp:include page="../includes/header.jsp"/>
    </header> <!-- end of header bar -->

    <section id="secondary_bar">
        <jsp:include page="../includes/menu.jsp"/>
    </section><!-- end of secondary bar -->

    <aside id="sidebar" class="column">
        <jsp:include page="../includes/left.jsp"/>
    </aside><!-- end of sidebar -->

    <section id="main" class="column">    
        <decorator:body/>
    </section>
</body>
</html>

