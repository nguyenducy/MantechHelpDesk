<%-- 
    Document   : EditCategoryModal
    Created on : Nov 11, 2012, 5:12:39 PM
    Author     : NGUYEN
--%>

<%
            String id = request.getParameter("id");
            String category = request.getParameter("category");
            String description = request.getParameter("des");
%>

<html>
    <head>
        <title></title>

    </head>
    <body>
        <script type="text/javascript">
            $(function(){
                var id = $("#id"),
                category = $("#category"),
                description = $("#description"),
                allFields = $([]).add(id).add(category).add(description),
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


                            bValid = bValid && checkRequired(category, 'Question', 'is required');
                            bValid = bValid && checkRequired(description, 'Answer', 'is required');

                            if(bValid){
                                var url = "../UpdateCategoryServlet?id="+id.val()+"&category="+category.val()+"&description="+description.val();
                                window.location.href = url;
                                $(this).dialog("close");
                            }

                        },
                        Cancel: function(){
                            var url = "ViewCategory.jsp"
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

        <div id="dialog-form" title="Update Catepgory">
            <p class="validateTips">All form fields are required.</p>
            <form action="" method="" id="newCategoryForm">
                <fieldset class="modalForm">
                    <table>
                        <tr>
                            <td><label for="id">ID</label></td>
                            <td><input name="id" id="id" class="text ui-widget-content ui-corner-all" value="<%= id%>" disabled="true" size="1"/></td>
                        </tr>
                        <tr>
                            <td><label for="question">Category</label></td>
                            <td>
                                <textarea cols="20" rows="3"  name="category" id="category" class="text ui-widget-content ui-corner-all"><%= category%></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="answer">Description</label></td>
                            <td><textarea cols="20" rows="10"  name="description" id="description" class="text ui-widget-content ui-corner-all" ><%= description%></textarea>
                        </tr>
                    </table>
                </fieldset>
            </form>
        </div>
    </body>
</html>
