<%-- 
    Document   : updateacccount
    Created on : Oct 9, 2012, 10:22:57 AM
    Author     : NGUYEN
--%>


<script>
    $(document).ready(function(){
        $("#updateAccountForm").validate({
            rules:{
                username: {required: true, maxlength: 10},
                password: {required: true, maxlength: 15},
                newPassword: {required: true, maxlength: 15}
            },
            messages:{
                username:{
                    required: "Required",
                    maxlength: "Less than 11 characters"
                },
                password: {
                    required: "Required",
                    maxlength: "Less than 16 characters"
                },
                newPassword:{
                    required: "Required",
                    maxlength: "Less than 16 characters"
                }
            }
        });
    });
</script>

<header><h3>Change Username OR Password</h3></header>
<form class="post_message" action="../ChangePasswordServlet" id="updateAccountForm" >
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
        <input type="submit"  value="Change" class="alt_btn" />
        <input type="reset" value="Reset"/>
    </footer>
</form>