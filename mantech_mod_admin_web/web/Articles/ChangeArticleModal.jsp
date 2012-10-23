<%-- 
    Document   : ChangeArticleModal
    Created on : Oct 22, 2012, 9:39:16 PM
    Author     : NGUYEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title></title>

    </head>
    <body>
        <script type="text/javascript">
            $(function(){
                var id = $("#id"),
                ar = $("#article"),
                content = $("#content"),
                day = $("#day"),
                rate = $("#rate"),
                thum = $("#thum"),
                allFields = $([]).add(id).add(ar).add(content).add(day).add(rate).add(thum),
                tips = $( ".validateTips" );

                function updateTips( t ) {
                    tips
                    .text( t )
                    .addClass( "ui-state-highlight" );
                    setTimeout(function() {
                        tips.removeClass( "ui-state-highlight", 1500 );
                    }, 500 );
                }

                function checkLength( o, n, min, max ) {
                    if ( o.val().length > max || o.val().length < min ) {
                        o.addClass( "ui-state-error" );
                        updateTips( "Length of " + n + " must be between " +
                            min + " and " + max + "." );
                        return false;
                    } else {
                        return true;
                    }
                }

                function checkRegexp( o, regexp, n ) {
                    if ( !( regexp.test( o.val() ) ) ) {
                        o.addClass( "ui-state-error" );
                        updateTips( n );
                        return false;
                    } else {
                        return true;
                    }
                }

                function checkRequired(o, n, m){
                    if(o.val() == ''){
                        o.addClass( "ui-state-error" );
                        updateTips(n + ' ' + m);
                        return false;
                    }else{
                        return true;
                    }
                }

                $("#dialog-form").dialog({
                    autoOpen: false,
                    height: 400,
                    width: 400,
                    modal: true,
                    buttons:{
                        "Update": function(){
                            var bValid = true;
                            allFields.removeClass( "ui-state-error" );


                            bValid = bValid && checkRequired(ar, 'Article', 'is required');
                            bValid = bValid && checkRequired(content, 'Content', 'is required');
                            bValid = bValid && checkRequired(day, 'Created Date', 'is required');
                            bValid = bValid && checkRegexp(day, /^((0?[1-9]|1[012])[- /.](0?[1-9]|[12][0-9]|3[01])[- /.](19|20)?[0-9]{2})*$/ , 'Enter a valid date (mm/dd/yyyy)');
                            bValid = bValid && checkRegexp(thum, /\.(jpg|jpeg|png)$/i, 'Only png and jpg');

                           
                            if(bValid){
                                var url = "ViewArticle.jsp";
                                window.location.href = url;
                                $(this).dialog("close");
                            }
                            
                        },
                        Cancel: function(){
                            var url = "ViewArticle.jsp"
                            window.location.href = url;
                            $(this).dialog("close");
                        }
                    },
                    close: function(){
                        allFields.val( "" ).removeClass( "ui-state-error" );
                    }
                });


                $( "#dialog-form" ).dialog( "open" );


            });
        </script>

        <%
                    String id = request.getParameter("id");
                    String ar = request.getParameter("ar");
                    String content = request.getParameter("content");
                    String day = request.getParameter("day");
                    String rate = request.getParameter("rate");
                    String thum = request.getParameter("thum");
        %>

        <div id="dialog-form" title="Update Article">
            <p class="validateTips">Article, Content and Create On fields are required.</p>
            <form action="" method="" id="newCategoryForm">
                <fieldset class="modalForm">
                    <table>
                        <tr>
                            <td><label for="id">ID</label></td>
                            <td><input name="id" id="id" class="text ui-widget-content ui-corner-all" value="<%= id%>" disabled="true" size="1"/></td>
                        </tr>
                        <tr>
                            <td><label for="article">Article</label></td>
                            <td>
                                <textarea cols="" rows=""  name="article" id="article" class="text ui-widget-content ui-corner-all"><%= ar%></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="content">Content</label></td>
                            <td><textarea cols="" rows=""  name="content" id="content" class="text ui-widget-content ui-corner-all" ><%= content%></textarea>
                        <tr>
                        <tr>
                            <td><label for="day">Created on</label></td>
                            <td><input name="day" id="day" class="text ui-widget-content ui-corner-all" value="<%= day%>" /></td>
                        </tr>
                        <tr>
                            <td><label for="rate">Rate</label></td>
                            <td><input name="rate" id="rate" class="text ui-widget-content ui-corner-all" value="<%= rate%>" size="1"></td>
                        </tr>
                        <tr>
                            <td><label for="thum">Thumbnail</label></td>
                            <td>
                                <input type="file" name="thum" value="<%= thum %>"/>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </form>
        </div>
    </body>
</html>
