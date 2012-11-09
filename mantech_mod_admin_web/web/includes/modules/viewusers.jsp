<%-- 
    Document   : viewusers
    Created on : Oct 9, 2012, 10:15:03 AM
    Author     : NGUYEN
--%>

<%@page import="mantech.mod.account.entity.Account"%>
<%@page import="java.util.List"%>
<%@page import="mantech.mod.account.api.AccountBiz"%>
<%@page import="javax.naming.InitialContext"%>
<header><h3 class="tabs_involved">Account Manager</h3>
    <ul class="tabs">
        <li><a href="#tab1">Accounts</a></li>
    </ul>
</header>

<div id="tab1" class="tab_content">
    <table class="tablesorter" cellspacing="0">
        <thead>
            <tr>
                <th>ID</th>
                <th>Fullname</th>
                <th>Username</th>
                <th>Role</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%
                        InitialContext context = null;
                        try {
                            context = new InitialContext();
                            AccountBiz biz = (AccountBiz) context.lookup("ejb/mantech/saigon/AccountBiz");
                            List<Account> list = biz.findAll();
                            for (Account a : list) {
            %>
            <tr>
                <td><%= a.getId() %></td>
                <td><%= a.getProfile().getFullName() %></td>
                <td><%= a.getUsername() %></td>
                <td><%= a.getRole().getRole() %></td>
                <td>
                    <a href="${pageContext.request.contextPath}/Accounts/DeleteModal.jsp?id=<%= a.getId() %>"><img src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash"/></a>
                </td>
            </tr>
            <%                     }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            context.close();
                        }
            %>
        </tbody>
    </table>
</div><!-- end of #tab1 -->

