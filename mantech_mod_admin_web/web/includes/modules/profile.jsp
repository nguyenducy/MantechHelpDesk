<%-- 
    Document   : profile
    Created on : Oct 9, 2012, 10:40:11 AM
    Author     : NGUYEN
--%>

<%@page import="java.util.List"%>
<%@page import="mantech.mod.complaint.entity.Complaint"%>
<%@page import="mantech.mod.complaint.api.ComplaintBiz"%>
<%@page import="mantech.mod.account.entity.Account"%>
<%@page import="mantech.mod.account.api.AccountBiz"%>
<%@page import="mantech.mod.account.entity.Profile"%>
<%@page import="mantech.mod.account.api.ProfileBiz"%>
<%@page import="javax.naming.InitialContext"%>
<header><h3 class="tabs_involved">My Profile</h3>
    <ul class="tabs">
        <li><a href="#tab1">Profile</a></li>
    </ul>
</header>


<div id="tab1" class="tab_content">
    <table class="tablesorter" cellspacing="0">
        <thead>
            <tr>
                <th>Full Name</th>
                <th>Address</th>
                <th>Telephone</th>
                <th>Department</th>
                <th>Email</th>
                <th>Image</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%
                        InitialContext context = null;
                        String id = (String) request.getSession(true).getValue("idCurrentUser");
                        try {
                            context = new InitialContext();
                            AccountBiz biz = (AccountBiz) context.lookup("ejb/mantech/saigon/AccountBiz");                  
                            Account a = biz.findByID(Integer.parseInt(id));
                            Profile p = a.getProfile();
            %>
            <tr>
                <td><%= p.getFullName() %></td>
                <td><%= p.getAddress() %></td>
                <td><%= p.getTelephone() %></td>
                <td><%= p.getDepartment().getName() %></td>
                <td><%= p.getEmail() %></td>
                <td><%= p.getImage() %></td>
                <td>
                    <a href="${pageContext.request.contextPath}/Profiles/EditProfileModal.jsp?id=<%= p.getId() %>&name=<%= p.getFullName() %>&addr=<%= p.getAddress() %>&tele=<%= p.getTelephone() %>&depa=<%= p.getDepartment().getId() %>&emai=<%= p.getEmail() %>&imag=<%= p.getImage() %>"><img src="${pageContext.request.contextPath}/images/icn_edit.png" title="Edit"/></a>
                </td>
            </tr>
            <%
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            context.close();
                        }
            %>
        </tbody>
    </table>
</div><!-- end of #tab1 -->


