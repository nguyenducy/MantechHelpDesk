<%-- 
    Document   : deleteaccount
    Created on : Oct 12, 2012, 11:04:02 AM
    Author     : NGUYEN
--%>

<script>
    $(document).ready(function(){
        $("#deleteAccountForm").validate({
            rules:{
                username: {required: true, maxlength: 10}           
            },
            messages:{
                username:{
                    required: "Required",
                    maxlength: "Less than 11 characters"
                }
            }
        });
    });
</script>

<header><h3>Delete Account</h3></header>
<form class="post_message" action="" id="deleteAccountForm" >
    <div class="message_list">
        <div class="module_content">
            <table>
                <tr>
                    <td><div class="message">Username: <input name="username"/></div></td>
                </tr>
            </table>
        </div>
    </div>
    <footer>
        <input type="submit"  value="Delete" class="alt_btn" />
        <input type="reset" value="Reset"/>
    </footer>
</form>