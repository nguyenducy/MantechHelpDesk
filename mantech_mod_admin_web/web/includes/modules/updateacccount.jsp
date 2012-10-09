<%-- 
    Document   : updateacccount
    Created on : Oct 9, 2012, 10:22:57 AM
    Author     : NGUYEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<header><h3>Change Username OR Password</h3></header>
<form class="post_message">
    <div class="message_list">
        <div class="module_content">
            <div class="message">Username: <input name="username"/></div>
            <div class="message">Old-Password: <input type="password" name="password"/></div>
            <div class="message">New-Password: <input type="password" name="newPassword"/></div>
            
        </div>
    </div>
    <footer>
        <input type="submit"  value="Change" />
    </footer>
</form>