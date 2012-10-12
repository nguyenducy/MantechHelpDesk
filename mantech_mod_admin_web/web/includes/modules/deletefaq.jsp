<%-- 
    Document   : deletefaq
    Created on : Oct 12, 2012, 11:15:47 AM
    Author     : NGUYEN
--%>

<script>
    $(document).ready(function(){
        $("#deleteAccountForm").validate({
            rules:{
                question: {required: true, maxlength: 10}
            },
            messages:{
                question:{
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
                    <td><div class="message">Question: <input name="question"/></div></td>
                </tr>
            </table>
        </div>
    </div>
    <footer>
        <input type="submit"  value="Delete" class="alt_btn" />
        <input type="reset" value="Reset"/>
    </footer>
</form>