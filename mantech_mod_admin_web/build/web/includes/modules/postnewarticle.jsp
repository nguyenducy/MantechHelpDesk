<%-- 
    Document   : postnewarticle
    Created on : Sep 29, 2012, 8:05:08 PM
    Author     : NGUYEN
--%>
<script>
    $(document).ready(function(){
        $("#newArticleForm").validate({
            rules:{
                article: {required: true},
                content: {required: true},
                thumbnail: {required: true, extension: "png|jpeg"}
            }
        });

        jQuery.validator.addMethod("extension", function(value, element, param) {
            param = typeof param === "string" ? param.replace(/,/g, '|') : "png|jpeg|gif";
            return this.optional(element) || value.match(new RegExp(".(" + param + ")$", "i"));
        }, jQuery.format("Only PNG or JPEG extenstion."));
    });
</script>

<form action="" method="post" id="newArticleForm">
    <header><h3>Post New Article</h3></header>
    <div class="module_content">
        <fieldset>
            <label>Title Article</label>
            <input type="text" name="article">
        </fieldset>
        <fieldset>
            <label>Content</label>
            <textarea rows="12" name="content"></textarea>
        </fieldset>
        <fieldset style="width:48%;  margin-right: 3%;"> <!-- to make two field float next to one another, adjust values accordingly -->
            <label>Thumbnail</label>
            <input type="file" name="thumbnail"/>
        </fieldset>

    </div>
    <footer>
        <div class="submit_link">

            <input type="submit" value="Publish" class="alt_btn">
            <input type="submit" value="Reset">
        </div>
    </footer>
</form>