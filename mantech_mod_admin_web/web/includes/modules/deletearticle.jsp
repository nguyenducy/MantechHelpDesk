<%-- 
    Document   : deletearticle
    Created on : Oct 12, 2012, 11:11:36 AM
    Author     : NGUYEN
--%>

<script>
    $(document).ready(function(){
        $("#deleteAccountForm").validate({
            rules:{
                article: {required: true, maxlength: 50}
            },
            messages:{
                article:{
                    required: "Required",
                    maxlength: "Less than 51 characters"
                }
            }
        });
    });
</script>

<header><h3>Delete Article</h3></header>
<form class="post_message" action="" id="deleteAccountForm" >
    <div class="message_list">
        <div class="module_content">
            <table>
                <tr>
                    <td><div class="message">Article: <input name="article"/></div></td>
                </tr>
            </table>
        </div>
    </div>
    <footer>
        <input type="submit"  value="Delete" class="alt_btn" />
        <input type="reset" value="Reset"/>
    </footer>
</form>
