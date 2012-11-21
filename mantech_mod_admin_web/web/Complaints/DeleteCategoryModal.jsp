<%-- 
    Document   : newjspDeleteCategoryModa
    Created on : Nov 11, 2012, 5:14:33 PM
    Author     : NGUYEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Modal</title>
    </head>
    <body>
        <script type="text/javascript">
            $(function(){
                var id = $("#idcategory").text();
                $("#dialog-confirm").dialog({
                    resizable: true,
                    height: 200,
                    modal: true,
                    buttons:{
                        "Delete this item": function(){
                            var url = "../DeleteCategoryServlet?id=" + id;
                            window.location.href = url;
                            $(this).dialog("close");
                        },
                        Cancel: function(){
                            var url = "ViewCategory.jsp";
                            window.location.href = url;
                            $(this).dialog("close");
                        }
                    }
                });
            });
        </script>

        <%
                    String id = request.getParameter("id");
        %>

        <div id="dialog-confirm" title="Remove the category?">
            <p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>These <span id="idcategory"><%= id%></span> will be permanently deleted and cannot be recovered. Are you sure?</p>
        </div>
    </body>
</html>


