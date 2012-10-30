<%-- 
    Document   : ChangeAnswerModal
    Created on : Oct 22, 2012, 9:16:23 PM
    Author     : NGUYEN
--%>

<%@page import="mantech.mod.FAQ.parameter.ParameterFAQ.Parameter"%>
<html>
    <head>
        <title></title>

    </head>
    <body>
        <script type="text/javascript">
            $(function(){
                var id = $("#id"),
                question = $("#question"),
                answer = $("#answer"),
                allFields = $([]).add(id).add(question).add(answer),
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


                            bValid = bValid && checkRequired(question, 'Question', 'is required');
                            bValid = bValid && checkRequired(answer, 'Answer', 'is required');

                            if(bValid){
                                var url = "../updateFAQ?<%=Parameter.FAQ_ID%>="+${"id"}.val()+"&<%=Parameter.FAQ_QUESTION%>="+$("#question").val()+"&<%=Parameter.FAQ_ANSWER%>="+$("#answer").val();
                                window.location.href = url;
                                $(this).dialog("close");
                            }
                           
                        },
                        Cancel: function(){
                            var url = "../loadFAQ"
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
                    String ques = request.getParameter("ques");
                    String ans = request.getParameter("ans");
        %>

        <div id="dialog-form" title="Update FAQ">
            <p class="validateTips">All form fields are required.</p>
            <form action="" method="" id="newCategoryForm">
                <fieldset class="modalForm">
                    <table>
                        <tr>
                            <td><label for="id">ID</label></td>
                            <td><input name="id" id="id" class="text ui-widget-content ui-corner-all" value="<%= id%>" disabled="true" size="1"/></td>
                        </tr>
                        <tr>
                            <td><label for="question">Question</label></td>
                            <td>
                                <textarea name="question" id="question" class="text ui-widget-content ui-corner-all"><%= ques%></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="answer">Answer</label></td>
                            <td><textarea cols="" rows=""  name="answer" id="answer" class="text ui-widget-content ui-corner-all" ><%= ans%></textarea>
                        </tr>
                    </table>
                </fieldset>
            </form>
        </div>
    </body>
</html>


