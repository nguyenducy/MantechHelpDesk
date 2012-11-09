<%-- 
    Document   : complaints
    Created on : Oct 9, 2012, 10:59:59 AM
    Author     : NGUYEN
--%>

<%@page import="mantech.mod.account.entity.Profile"%>
<%@page import="mantech.mod.account.api.ProfileBiz"%>
<%@page import="mantech.mod.complaint.entity.Complaint"%>
<%@page import="java.util.List"%>
<%@page import="mantech.mod.complaint.api.ComplaintBiz"%>
<%@page import="javax.naming.InitialContext"%>
<header><h3 class="tabs_involved">All Complaints</h3>
    <ul class="tabs">
        <li><a href="#tab1">Complaints</a></li>
    </ul>
</header>


<div id="tab1" class="tab_content">
    <table class="tablesorter" cellspacing="0">
        <thead>
            <tr>
                <th>ID</th>
                <th>Category</th>
                <th>Employee</th>
                <th>Created On</th>           
                <th>Pending</th>
                <th>Issued</th>
                <th>Completed</th>
                <th>Completed On</th>
                <th>Technician</th>
                <th>Note</th>
            </tr>
        </thead>
        <tbody>
            <%
                        InitialContext context = null;
                        try {
                            context = new InitialContext();
                            ComplaintBiz biz = (ComplaintBiz) context.lookup("ejb/mantech/saigon/ComplaintBiz");
                            List<Complaint> list = biz.find(10, 0);
                            for (Complaint c : list) {
                                ProfileBiz profileBiz = (ProfileBiz) context.lookup("ejb/mantech/saigon/ProfileBiz");
                                Profile p = profileBiz.find(c.getTechnicianID());
            %>
            <tr>
                <td><%= c.getId()%></td>
                <td><%= c.getCategory().getName()%></td>
                <td><%= c.getProfile().getFullName()%></td>
                <td><%= c.getCreatedDate()%></td>
                <td><input type="checkbox" checked="<%= c.getPending()%>" disabled="true" /></td>
                <td><input type="checkbox" checked="<%= c.getIssued()%>" disabled="true" /></td>
                <td><input type="checkbox" checked="<%= c.getCompleted()%>" disabled="true" /></td>
                <td><%= c.getCreatedDate()%></td>
                <td><%= p.getFullName()%></td>
                <td><%= c.getNote()%></td>
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


