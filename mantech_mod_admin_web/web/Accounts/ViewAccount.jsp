<%-- 
    Document   : ViewAccount
    Created on : Oct 9, 2012, 10:09:48 AM
    Author     : NGUYEN
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <h4 class="alert_info">Welcome to the free MediaLoot admin panel template, this could be an informative message.</h4>



    <article class="module width_3_quarter">
        <div class="tab_container">
            <jsp:include page="../includes/modules/viewusers.jsp"/>
        </div><!-- end of .tab_container -->

    </article><!-- end of content manager article -->

    <article class="module width_quarter">
        <jsp:include page="../includes/modules/updateacccount.jsp"/>
    </article><!-- end of messages article -->

    <div class="clear"></div>


    <div class="spacer"></div>
</body>
</html>
