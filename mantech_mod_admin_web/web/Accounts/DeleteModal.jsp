<%-- 
    Document   : DeleteModal
    Created on : Oct 22, 2012, 7:34:57 PM
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
                            var url = "DeleteServlet?id=" + id;
                            window.location.href = url;
                            $(this).dialog("close");
                        },
                        Cancel: function(){
                            var url = "ViewAccount.jsp";
                            window.location.href = url;
                            $(this).dialog("close");
                        }
                    }
                });
            });
        </script>
        
        <div id="dialog-confirm" title="Empty the recycle bin?">
            <p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>These <span id="idcategory"></span> will be permanently deleted and cannot be recovered. Are you sure?</p>
        </div>
    </body>
</html>
