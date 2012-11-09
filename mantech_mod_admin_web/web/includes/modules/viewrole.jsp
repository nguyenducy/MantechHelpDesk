<%-- 
    Document   : viewrole
    Created on : Oct 31, 2012, 8:20:45 PM
    Author     : NGUYEN
--%>

<%@page import="mantech.mod.account.entity.Role"%>
<%@page import="java.util.List"%>
<%@page import="mantech.mod.account.api.RoleBiz"%>
<%@page import="javax.naming.InitialContext"%>
<header><h3 class="tabs_involved">All Profile</h3>
    <ul class="tabs">
        <li><a href="#tab1">Profiles</a></li>
    </ul>
</header>


<div id="tab1" class="tab_content">
    <table class="tablesorter" cellspacing="0">
        <thead>
            <tr>
                <th>ID</th>
                <th>Role</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%
                        InitialContext context = null;
                        try {
                            context = new InitialContext();
                            RoleBiz biz = (RoleBiz) context.lookup("ejb/mantech/saigon/RoleBiz");
                            List<Role> list = biz.findAll();
                            for (Role p : list) {
            %>
            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getRole() %></td>
                <td><a href="${pageContext.request.contextPath}/Accounts/DeleteRoleModal.jsp?id=<%= p.getId() %>"><img src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash"/></a></td>
                
            </tr>
            <%                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            context.close();
                        }
            %>
        </tbody>
    </table>
</div><!-- end of #tab1 -->