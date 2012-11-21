<%-- 
    Document   : index
    Created on : Sep 29, 2012, 8:34:03 PM
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
        <h4 class="alert_info">Welcome to Index View.</h4>

    <article class="module width_full">
        <jsp:include page="includes/modules/stats.jsp"/>
    </article><!-- end of stats article -->

    <article class="module width_3_quarter">
        <div class="tab_container">
            <jsp:include page="includes/modules/contentmanager.jsp"/>
        </div><!-- end of .tab_container -->

    </article><!-- end of content manager article -->

    <article class="module width_quarter">
        <jsp:include page="includes/modules/messages.jsp"/>
    </article><!-- end of messages article -->

    <div class="clear"></div>

    <article class="module width_full">
        <jsp:include page="includes/modules/postnewarticle.jsp"/>
    </article><!-- end of post new article -->

    <jsp:include page="includes/modules/warningalert.jsp"/>

    <jsp:include page="includes/modules/errormessage.jsp"/>

    <jsp:include page="includes/modules/successmessage.jsp"/>

    <article class="module width_full">
        <header><h3>Basic Styles</h3></header>
        <div class="module_content">
            <h1>Header 1</h1>
            <h2>Header 2</h2>
            <h3>Header 3</h3>
            <h4>Header 4</h4>
            <p>Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Cras mattis consectetur purus sit amet fermentum. Maecenas faucibus mollis interdum. Maecenas faucibus mollis interdum. Cras justo odio, dapibus ac facilisis in, egestas eget quam.</p>

            <p>Donec id elit non mi porta <a href="#">link text</a> gravida at eget metus. Donec ullamcorper nulla non metus auctor fringilla. Cras mattis consectetur purus sit amet fermentum. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum.</p>

            <ul>
                <li>Donec ullamcorper nulla non metus auctor fringilla. </li>
                <li>Cras mattis consectetur purus sit amet fermentum.</li>
                <li>Donec ullamcorper nulla non metus auctor fringilla. </li>
                <li>Cras mattis consectetur purus sit amet fermentum.</li>
            </ul>
        </div>
    </article><!-- end of styles article -->
    <div class="spacer"></div>

    <a href="http://localhost:8080/Mantech/profiles/default_profile.jpg">Click</a>
</body>
</html>
