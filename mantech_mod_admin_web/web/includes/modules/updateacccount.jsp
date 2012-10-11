<%-- 
    Document   : updateacccount
    Created on : Oct 9, 2012, 10:22:57 AM
    Author     : NGUYEN
--%>


<script>
    $(document).ready(function(){
        $("#updateAccountForm").validate({
            rules:{
                username: {required: true},
                password: {required: true},
                newPassword: {required: true}           
            }
        });
    });
</script>

<header><h3>Change Username OR Password</h3></header>
<form class="post_message" action="" id="updateAccountForm" >
    <div class="message_list">
        <div class="module_content">
            <table>
                <tr>
                    <td><div class="message">Username: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="username"/></div></td>
                </tr>
                <tr>
                    <td><div class="message">Old-Password: &nbsp;&nbsp;<input type="password" name="password"/></div></td>
                </tr>
                <tr>
                    <td><div class="message">New-Password: <input type="password" name="newPassword"/></div></td>
                </tr>
            </table>        
        </div>
    </div>
    <footer>
        <input type="submit"  value="Change" />
        <input type="reset" value="Reset"/>
    </footer>
</form>