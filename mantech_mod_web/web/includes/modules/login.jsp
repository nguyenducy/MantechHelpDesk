<%-- 
    Document   : login
    Created on : Nov 2, 2012, 11:21:46 PM
    Author     : NGUYEN
--%>

<%@page import="mantech.mod.session.SessionName"%>
<%
            HttpSession s = request.getSession(true);
            String name = (String) s.getValue(SessionName.Name);
            if (name == null) {
%>
<form action="Authentication" id="login-form">
    <table>
        <tr>
            <td>Username: <input name="username" title="Username" alt="Username"/></td>
        </tr>
        <tr>
            <td>Password: &nbsp;<input name="password" type="password" title="Password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Login" class="alt_btn"/></td>
        </tr>
        <tr>
            <td><input name="return" type="hidden" value="<%= request.getServletPath()%>" /></td>
        </tr>
    </table>
</form>
<%
                            } else {

%>
<form action="Logout" method="post">
    <table>
        <tr>
            <td>Hi, <%= name%></td>
        </tr>
        <tr>
            <td><input type="submit" value="Logout" class="alt_btn"/></td>
        </tr>
        <tr>
            <td><input name="return" type="hidden" value="<%= request.getServletPath()%>" /></td>
        </tr>
    </table>
</form>
<%                                          }
%>
