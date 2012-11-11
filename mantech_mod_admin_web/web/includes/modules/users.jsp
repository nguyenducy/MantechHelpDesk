<%-- 
    Document   : users
    Created on : Oct 9, 2012, 10:50:41 AM
    Author     : NGUYEN
--%>

<%@page import="mantech.mod.account.entity.Profile"%>
<%@page import="java.util.List"%>
<%@page import="mantech.mod.account.api.ProfileBiz"%>
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
                <th>Full Name</th>
                <th>Address</th>
                <th>Telephone</th>
                <th>Department</th>
                <th>Email</th>
                <th>Image</th>
            </tr>
        </thead>
        <tbody>
            <%
                        InitialContext context = null;
                        try {
                            context = new InitialContext();
                            ProfileBiz biz = (ProfileBiz) context.lookup("ejb/mantech/saigon/ProfileBiz");
                            List<Profile> list = biz.find(5, 0);
                            for (Profile p : list) {
            %>
            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getFullName() %></td>
                <td><%= p.getAddress() %></td>
                <td><%= p.getTelephone() %></td>
                <td><%= p.getDepartment().getName() %></td>
                <td><%= p.getEmail() %></td>
                <td><img src="${pageContext.request.contextPath}/images/profiles/<%= p.getImage() %>" width="50" height="50"/></td>
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



