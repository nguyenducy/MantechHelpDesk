<%-- 
    Document   : CompletedForm
    Created on : Oct 23, 2012, 1:51:20 PM
    Author     : NGUYEN
--%>

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
                        "Complete": function(){
                            var url = "UpdateServlet?category="+category.val();
                            window.location.href = url;
                            $(this).dialog("close");
                        },
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
                    String name = "Kevin";

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
                                <th style="color: black;">Completed</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>Lorem Ipsum Dolor Sit Amet</td>
                                <td>Lorem Ipsum Dolor Sit Amet</td>
                                <td>Articles</td>
                                <td>5th April 2011</td>
                                <td>Lorem Ipsum Dolor Sit Amet</td>
                                <td><input type="checkbox" name="" value="" /></td>
                            </tr>
                        </tbody>
                    </table>
                </div><!-- end of #tab1 -->
            </form>
        </div>
    </body>
</html>
