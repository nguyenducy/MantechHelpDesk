<%-- 
    Document   : faq
    Created on : Oct 8, 2012, 11:27:24 PM
    Author     : NGUYEN
--%>

<script type="text/javascript">
    $(document).ready(function(){
        $("#newFAQ").validate({
            rules:{
                question: {required: true},
                answer: {required: true}
            }
        });
    });
</script>

<form action="../InsertFAQServlet" method="post" id="newFAQ">
    <header><h3>Post New FAQ</h3></header>
    <div class="module_content">
        <fieldset>
            <label>Question</label>
            <textarea rows="12" name="question"></textarea>
            <div id="Info" style="color: red;"></div>
        </fieldset>
        <fieldset>
            <label>Answer</label>
            <textarea rows="12" name="answer"></textarea>
        </fieldset>


    </div>
    <footer>
        <div class="submit_link">

            <input type="submit" value="Publish" class="alt_btn">
            <input type="reset" value="Reset">
        </div>
    </footer>
</form>