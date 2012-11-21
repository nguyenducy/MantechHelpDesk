<%-- 
    Document   : EditTechnicianModal
    Created on : Nov 11, 2012, 5:52:05 PM
    Author     : NGUYEN
--%>

<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.List"%>
<%@page import="mantech.mod.account.entity.Department"%>
<%@page import="mantech.mod.account.api.DepartmentBiz"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%
            String id = request.getParameter("id");
            String fullName = request.getParameter("fullName");
            String department = request.getParameter("department");
            String address = request.getParameter("address");
            String telephone = request.getParameter("telephone");
            String email = request.getParameter("email");
%>
<html>
    <head>
        <title></title>

    </head>
    <body>

        <script type="text/javascript">
            $(function(){
                var id = $("#id"),
                fullName = $("#fullName"),
                department = $("#department"),
                address = $("#address"),
                telephone = $("#telephone"),
                email = $("#email"),
                allFields = $([]).add(id).add(fullName).add(department).add(address).add(telephone).add(email),
                tips = $( ".validateTips" );

                function updateTips( t ) {
                    tips
                    .text( t )
                    .addClass( "ui-state-highlight" );
                    setTimeout(function() {
                        tips.removeClass( "ui-state-highlight", 1500 );
                    }, 500 );
                }

                function checkLength( o, n, min, max ) {
                    if ( o.val().length > max || o.val().length < min ) {
                        o.addClass( "ui-state-error" );
                        updateTips( "Length of " + n + " must be between " +
                            min + " and " + max + "." );
                        return false;
                    } else {
                        return true;
                    }
                }

                function checkRegexp( o, regexp, n ) {
                    if ( !( regexp.test( o.val() ) ) ) {
                        o.addClass( "ui-state-error" );
                        updateTips( n );
                        return false;
                    } else {
                        return true;
                    }
                }

                function checkRequired(o, n, m){
                    if(o.val() == ''){
                        o.addClass( "ui-state-error" );
                        updateTips(n + ' ' + m);
                        return false;
                    }else{
                        return true;
                    }
                }

                $("#dialog-form").dialog({
                    autoOpen: false,
                    height: 400,
                    width: 400,
                    modal: true,
                    buttons:{
                        "Update": function(){
                            var bValid = true;
                            allFields.removeClass( "ui-state-error" );


                            bValid = bValid && checkRequired(fullName, 'Full Name', 'is required');
                            bValid = bValid && checkRequired(address, 'Address', 'is required');

                            if(bValid){
                                var url = "../EditTechnicianServlet?id="+id.val()+"&fullName="+fullName.val()+"&department="+department.val()
                                    +"&address="+address.val()+"&telephone="+telephone.val()+"&email="+email.val();
                                window.location.href = url;
                                $(this).dialog("close");
                            }

                        },
                        Cancel: function(){
                            var url = "ViewTechnicians.jsp"
                            window.location.href = url;
                            $(this).dialog("close");
                        }
                    },
                    close: function(){
                        allFields.val( "" ).removeClass( "ui-state-error" );
                    }
                });


                $( "#dialog-form" ).dialog( "open" );

                $('#department option:eq(<%= Integer.parseInt(department)-1%>)').attr("selected", "true");

            });
        </script>

        <div id="dialog-form" title="Update Technician">
            <p class="validateTips">All form fields are required.</p>
            <form action="" method="" id="newCategoryForm">
                <fieldset class="modalForm">
                    <table>
                        <tr>
                            <td><label for="id">ID</label></td>
                            <td><input name="id" id="id" class="text ui-widget-content ui-corner-all" value="<%= id%>" readonly size="1"/></td>
                        </tr>
                        <tr>
                            <td><label for="fullName">Full Name</label></td>
                            <td>
                                <textarea cols="20" rows="3"  name="fullName" id="fullName" class="text ui-widget-content ui-corner-all"><%= fullName%></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="department">Department</label></td>
                            <td>
                                <select id="department" name="department" class="ui-corner-all">
                                     <%
                                                        InitialContext context = new  InitialContext();
                                                        DepartmentBiz departmentBiz = (DepartmentBiz) context.lookup("ejb/mantech/saigon/DepartmentBiz");
                                                        List<Department> listD = departmentBiz.findAll();
                                                        for (Department d : listD) {
                                     %>
                            <option value="<%= d.getId().toString()%>" ><%= d.getName()%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="address">Address</label></td>
                            <td>
                                <textarea cols="20" rows="3"  name="address" id="address" class="text ui-widget-content ui-corner-all"><%= address%></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="telephone">Telephone</label></td>
                            <td>
                                <textarea cols="20" rows="3"  name="telephone" id="telephone" class="text ui-widget-content ui-corner-all"><%= telephone%></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="email">Email</label></td>
                            <td>
                                <textarea cols="20" rows="3"  name="email" id="email" class="text ui-widget-content ui-corner-all"><%= email%></textarea>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </form>
        </div>
    </body>
</html>

