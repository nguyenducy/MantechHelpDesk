<%-- 
    Document   : addrole
    Created on : Oct 10, 2012, 7:40:00 PM
    Author     : NGUYEN
--%>

<script>
    $(document).ready(function(){
        $("#newRoleForm").validate({
            rules:{
                username: {required: true}
            }
        });
    });
</script>

<header><h3>Add New Role</h3></header>
<form class="post_message" id="newRoleForm" action="" method="get">
    <div class="message_list">
        <div class="module_content">
            <div class="message">Role: <input name="username"/></div>       
        </div>
    </div>
    <footer>
        <input type="submit"  value="Add" />
        <input type="reset" value="Reset"/>
    </footer>
</form>