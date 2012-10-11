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
        <meta charset="utf-8"/>
        <title>Admin : <decorator:title/></title>

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css" type="text/css" media="screen" />
        <!--[if lt IE 9]>
	<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
        <script src="${pageContext.request.contextPath}/js/jquery-1.5.2.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/hideshow.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.tablesorter.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.equalHeight.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js"/>
        <script type="text/javascript">
            $(document).ready(function()
            {
                $(".tablesorter").tablesorter();
            }
        );
            $(document).ready(function() {

                //When page loads...
                $(".tab_content").hide(); //Hide all content
                $("ul.tabs li:first").addClass("active").show(); //Activate first tab
                $(".tab_content:first").show(); //Show first tab content

                //On Click Event
                $("ul.tabs li").click(function() {

                    $("ul.tabs li").removeClass("active"); //Remove any "active" class
                    $(this).addClass("active"); //Add "active" class to selected tab
                    $(".tab_content").hide(); //Hide all tab content

                    var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
                    $(activeTab).fadeIn(); //Fade in the active ID content
                    return false;
                });

            });
        </script>
        <script type="text/javascript">
            $(function(){
                $('.column').equalHeight();
            });
        </script>
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

