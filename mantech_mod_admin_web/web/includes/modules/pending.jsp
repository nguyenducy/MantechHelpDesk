<%-- 
    Document   : pending
    Created on : Oct 10, 2012, 6:28:22 PM
    Author     : NGUYEN
--%>

<%@page import="mantech.mod.account.entity.Profile"%>
<%@page import="mantech.mod.account.api.ProfileBiz"%>
<%@page import="java.util.List"%>
<%@page import="mantech.mod.complaint.entity.Complaint"%>
<%@page import="mantech.mod.complaint.api.ComplaintBiz"%>
<%@page import="javax.naming.InitialContext"%>
<script type="text/javascript">
    $(function(){
        $('#update').click(function(){
            var technicianID = $(this).parent().prev().children('').children(':selected').attr('value');
            var id = $(this).parent().parent().children(':first').html();
            var url = '../UpdateTechnicianServlet?id='+id+'&technicianID='+technicianID
            window.location.href = url;
        });
    });
</script>
<form action="../UpdateTechnicianServlet" method="get" >
    <header><h3 class="tabs_involved">All Pending Complaints</h3>
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
                    <th>Note</th>
                    <th>Technician</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                            InitialContext context = null;
                            try {
                                context = new InitialContext();
                                ComplaintBiz biz = (ComplaintBiz) context.lookup("ejb/mantech/saigon/ComplaintBiz");
                                ProfileBiz profileBiz = (ProfileBiz) context.lookup("ejb/mantech/saigon/ProfileBiz");
                                List<Complaint> list = biz.findPendingOnly();
                                List<Profile> technicians = profileBiz.findTechnician();
                                for (Complaint c : list) {

                %>
                <tr>
                    <td><%= c.getId()%></td>
                    <td><%= c.getCategory().getName()%></td>
                    <td><%= c.getProfile().getFullName()%></td>
                    <td><%= c.getCreatedDate()%> 4</td>
                    <td><%= c.getNote()%></td>
                    <td>
                        <select name="technicianID">
                            <%
                                                                for (Profile t : technicians) {
                            %>
                            <option   value="<%= t.getId()%>"><%= t.getFullName()%></option>
                            <%
                                                                }
                            %>
                        </select>
                    </td>
                    <td><p id="update" style="cursor: pointer">Update<p></td>
                </tr>
                <%
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                context.close();
                            }
                %>
            </tbody>
        </table>
    </div><!-- end of #tab1 -->

</form>
