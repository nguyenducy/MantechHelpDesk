<%-- 
    Document   : menu
    Created on : Sep 29, 2012, 7:29:38 PM
    Author     : NGUYEN
--%>
<%
    String user = (String)request.getSession(true).getValue("username");
%>
<div class="user">
    <p><%= user %></p>
    <!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
</div>
<div class="breadcrumbs_container">
    <article class="breadcrumbs"><a href="../index.jsp">Website Admin</a> <div class="breadcrumb_divider"></div> <a class="current">Dashboard</a></article>
</div>
