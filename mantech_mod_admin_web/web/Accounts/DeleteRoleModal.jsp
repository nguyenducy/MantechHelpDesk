<%-- 
    Document   : DeleteRoleModal
    Created on : Oct 31, 2012, 8:24:53 PM
    Author     : NGUYEN
--%>

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
                            var url = "../DeleteRoleServlet?id=" + id;
                            window.location.href = url;
                            $(this).dialog("close");
                        },
                        Cancel: function(){
                            var url = "ViewRole.jsp";
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
        <div id="dialog-confirm" title="Remove the role?">
            <p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>These <span id="idcategory"><%= id%></span> will be permanently deleted and cannot be recovered. Are you sure?</p>
        </div>
    </body>
</html>
