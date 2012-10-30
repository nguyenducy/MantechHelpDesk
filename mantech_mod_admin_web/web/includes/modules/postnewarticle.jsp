<%-- 
    Document   : postnewarticle
    Created on : Sep 29, 2012, 8:05:08 PM
    Author     : NGUYEN
--%>
<%@page import="mantech.mod.article.parameter.ParameterArticle.Parameter"%>
<script>
    $(document).ready(function(){
        $("#newArticleForm").validate({
            rules:{
    <%=Parameter.ARTICLE_TITLE%>: {required: true, maxlength: 50},
    <%=Parameter.ARTICLE_CONTENT%>: {required: true},
    <%=Parameter.ARTICLE_THUMBNAIL%>: {required: true, extension: "png|jpeg|jpg"}
                },
                messages:{
    <%=Parameter.ARTICLE_TITLE%>:{
                    required: "Required",
                    maxlength: "Less than 51 characters"
                },
    <%=Parameter.ARTICLE_CONTENT%>: {
                required: "Required"
            },
    <%=Parameter.ARTICLE_THUMBNAIL%>:{
            required: "Required"
        }
    }
});

jQuery.validator.addMethod("extension", function(value, element, param) {
    param = typeof param === "string" ? param.replace(/,/g, '|') : "png|jpegjpg";
    return this.optional(element) || value.match(new RegExp(".(" + param + ")$", "i"));
}, jQuery.format("Only PNG or JPEG extenstion."));
});
</script>

<form action="../insertArticleServlet" method="post" id="newArticleForm" enctype="multipart/form-data">
    <header><h3>Post New Article</h3></header>
    <div class="module_content">
        <fieldset>
            <label>Title Article</label>
            <input type="text" name="<%=Parameter.ARTICLE_TITLE%>"">
        </fieldset>
        <fieldset>
            <label>Content</label>
            <textarea rows="12" name="<%=Parameter.ARTICLE_CONTENT%>"></textarea>
        </fieldset>
        <fieldset style="width:48%;  margin-right: 3%;"> <!-- to make two field float next to one another, adjust values accordingly -->
            <label>Thumbnail</label>
            <input type="file" name="<%=Parameter.ARTICLE_THUMBNAIL%>"/>
        </fieldset>

    </div>
    <footer>
        <div class="submit_link">

            <input type="submit" value="Publish" class="alt_btn">
            <input type="reset" value="Reset">
        </div>
    </footer>
</form>