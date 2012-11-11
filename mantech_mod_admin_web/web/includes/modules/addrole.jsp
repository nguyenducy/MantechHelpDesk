<%-- 
    Document   : addrole
    Created on : Oct 10, 2012, 7:40:00 PM
    Author     : NGUYEN
--%>

<script>
    $(document).ready(function(){
        $("#newRoleForm").validate({
            rules:{
                role: {required: true, maxlength: 51}
            },
            messages:{
                role:{
                    required: "Required",
                    maxlength: "Less than 51 characters"
                }
            }
        });
        
        $("#role").blur(function(){
            $("#Info").load('../CheckRoleAvaibleServlet', {role: $("#role").val()})
        });

        $('#reset').click(function(){
            $('#Info').html("");
        });
    });
</script>

<header><h3>Add New Role</h3></header>
<form class="post_message" id="newRoleForm" action="../InsertRoleServlet" method="get">
    <div class="message_list">
        <div class="module_content">
            <div class="message">Role: <input name="role" id="role"/></div>
            <div id="Info" style="color: red;"></div>
        </div>
    </div>
    <footer>
        <input type="submit"  value="Add" class="alt_btn" />
        <input type="reset" value="Reset" id="reset"/>
    </footer>
</form>