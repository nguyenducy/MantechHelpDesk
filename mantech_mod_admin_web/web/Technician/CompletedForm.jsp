<%-- 
    Document   : CompletedForm
    Created on : Oct 23, 2012, 1:51:20 PM
    Author     : NGUYEN
--%>

<%@page import="mantech.mod.account.entity.Profile"%>
<%@page import="mantech.mod.account.entity.Account"%>
<%@page import="mantech.mod.account.api.AccountBiz"%>
<%@page import="mantech.mod.complaint.entity.Complaint"%>
<%@page import="java.util.List"%>
<%@page import="mantech.mod.complaint.api.ComplaintBiz"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Completed Form</title>
    </head>
    <body>
        <script type="text/javascript">
            $(function(){           
                var name = $("#name"),
                table = $("#tab1"),
                allFields = $([]).add(name).add(table);
                
                $("#dialog-form").dialog({
                    autoOpen: false,
                    height: 284,
                    width: 1062,
                    modal: true,
                    buttons:{
                        Cancel: function(){
                            var url = "../login.html";
                            window.location.href = url;
                            $(this).dialog("close");
                        }
                    },
                    close: function(){
                        allFields.val( "" ).removeClass( "ui-state-error" );
                    }
                });

                $( "#dialog-form" ).dialog( "open" );
            });
            
        </script>

        <%
                    String name = (String) request.getSession(true).getValue("username");

        %>

        <div id="dialog-form" title="Completed Form">
            <form action="" method="" id="newCategoryForm"      
                  <p id="name">Hi, <%= name%></p>
                <div id="tab1" class="tab_content">
                    <table class="tablesorter" cellspacing="0">
                        <thead>
                            <tr>
                                <th style="color: black;">ID</th>
                                <th style="color: black;">Category</th>
                                <th style="color: black;">Department</th>
                                <th style="color: black;">Employee</th>
                                <th style="color: black;">Created On</th>
                                <th style="color: black;">Note</th>
                                <th style="color: black;">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                        InitialContext context = null;
                                        String id = (String) request.getSession(true).getValue("idCurrentUser");
                                        try {
                                            context = new InitialContext();
                                            AccountBiz biz = (AccountBiz) context.lookup("ejb/mantech/saigon/AccountBiz");
                                            ComplaintBiz complaintBiz = (ComplaintBiz) context.lookup("ejb/mantech/saigon/ComplaintBiz");
                                            Account a = biz.findByID(Integer.parseInt(id));
                                            List<Complaint> list = complaintBiz.findByTechnicianIDAndNotCompleted(a.getProfile().getId());
                                            for (Complaint c : list) {

                            %>
                            <tr>
                                <td><%= c.getId()%></td>
                                <td><%= c.getCategory().getName()%></td>
                                <td><%= c.getProfile().getDepartment().getName()%></td>
                                <td><%= c.getProfile().getFullName()%></td>
                                <td><%= c.getCreatedDate()%></td>
                                <td><%= c.getNote()%></td>
                                <td><a href="../UpdateCompletedServlet?id=<%= c.getId() %>" style="background-color: red">Complete</a></td>
                            </tr>
                            <%                                            }
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
        </div>
    </body>
</html>
