<%-- 
    Document   : DeleteFAQModal
    Created on : Oct 22, 2012, 8:01:40 PM
    Author     : NGUYEN
--%>

<%@page import="mantech.mod.FAQ.parameter.ParameterFAQ.Parameter"%>
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
                            var url = "../deleteFAQ?<%=Parameter.FAQ_ID%>=" + id;
                            window.location.href = url;
                            $(this).dialog("close");
                        },
                        Cancel: function(){
                            var url = "../loadFAQ";
                            window.location.href = url;
                            $(this).dialog("close");
                        }
                    }
                });
            });
        </script>

        <%
            String id  = request.getParameter("id");
        %>

        <div id="dialog-confirm" title="Remove the FAQ?">
            <p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>These <span id="idcategory"><%= id %></span> will be permanently deleted and cannot be recovered. Are you sure?</p>
        </div>
    </body>
</html>

