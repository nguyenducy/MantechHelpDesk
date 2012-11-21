<%-- 
    Document   : EditProfileModal
    Created on : Oct 31, 2012, 9:09:07 PM
    Author     : NGUYEN
--%>

<%@page import="mantech.mod.account.entity.Department"%>
<%@page import="java.util.List"%>
<%@page import="mantech.mod.account.api.DepartmentBiz"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.awt.Stroke"%>
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
                address = $("#address"),
                telephone = $("#telephone"),
                department = $("#department"),
                email = $("#email"),
                image = $("#image"),
                allFields = $([]).add(id).add(fullName).add(address).add(telephone).add(department).add(email).add(image),
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
                    width: 450,
                    modal: true,
                    buttons:{
                        "Update": function(){
                            var bValid = true;
                            allFields.removeClass( "ui-state-error" );
                            
                            bValid = bValid && checkRequired(fullName, 'Full Name', 'is required');
                            bValid = bValid && checkLength(fullName, 'Full Name', 0, 31);
                            bValid = bValid && checkRequired(address, 'Address', 'is required');
                            bValid = bValid && checkLength(address, 'Address', 0, 101);
                            Valid = bValid && checkRequired(telephone, 'Telephone', 'is required');
                            bValid = bValid && checkRegexp(telephone, /^\d+$/, 'A valid telephone is numbers ');
                            bValid = bValid && checkLength(telephone, 'Telephone', 8, 13);
                            bValid = bValid && checkRequired(email, 'Email', 'is required');
                            bValid = bValid && checkRegexp(email, /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i , 'Enter a valid email');
                            bValid = bValid && checkLength(email, 'Email', 0, 51);
                           
                            if(bValid){
                                $('#submitTechnician').trigger('click');
                                $(this).dialog("close");
                            }

                        },
                        Cancel: function(){
                            var url = "ViewProfile.jsp"
                            window.location.href = url;
                            $(this).dialog("close");
                        }
                    },
                    close: function(){
                        allFields.val( "" ).removeClass( "ui-state-error" );
                    }
                });


                $( "#dialog-form" ).dialog( "open" );
                $('#department option:eq(<%= Integer.parseInt(department) -1%>)').attr("selected", "true");
            });
        </script>



        <div id="dialog-form" title="Update Profile">
            <p class="validateTips">Full Name, Address, Telephone and Email fields are required.</p>
            <form action="../EditTechnicianServlet" method="get" id="newCategoryForm">
                <fieldset class="modalForm">
                    <table>
                        <tr>
                            <td><label for="id">ID</label></td>
                            <td><input name="id" id="id" class="text ui-widget-content ui-corner-all" value="<%= id%>" readonly size="1"/></td>
                        </tr>
                        <tr>
                            <td><label for="fullName">Full Name</label></td>
                            <td>
                                <textarea cols="" rows=""  name="fullName" id="fullName" class="text ui-widget-content ui-corner-all"><%= fullName%></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="address">Address</label></td>
                            <td>
                                <textarea cols="" rows=""  name="address" id="address" class="text ui-widget-content ui-corner-all"><%= address%></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="telephone">Telephone</label></td>
                            <td><input name="telephone" id="telephone" class="text ui-widget-content ui-corner-all" value="<%= telephone%>"/></td>
                        <tr>
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
                            <td><label for="email">Email</label></td>
                            <td><textarea cols="" rows=""  name="email" id="email" class="text ui-widget-content ui-corner-all"><%= email%></textarea></td>
                        </tr
                    </table>
                </fieldset>
                <input type="submit" style="visibility: hidden" id="submitTechnician"/>
            </form>
        </div>
    </body>
</html>
