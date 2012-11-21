<%-- 
    Document   : category
    Created on : Oct 9, 2012, 11:09:04 AM
    Author     : NGUYEN
--%>

<%@page import="java.util.List"%>
<%@page import="mantech.mod.complaint.entity.Category"%>
<%@page import="mantech.mod.complaint.api.CategoryBiz"%>
<%@page import="javax.naming.InitialContext"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<script>
    $(function() {
        var category = $( "#category" ),
        description = $( "#description" ),
        allFields = $( [] ).add(category ).add( description ),
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

        $( "#dialog-form" ).dialog({
            autoOpen: false,
            height: 300,
            width: 350,
            modal: true,
            buttons: {
                "Create an cateogry": function() {
                    var bValid = true;
                    allFields.removeClass( "ui-state-error" );
                    bValid = bValid && checkRequired(category, 'Category', 'is required');
                    bValid = bValid && checkLength(category, 'Category', 0, 51);
                    bValid = bValid && checkRequired(description, 'Description', 'is required');
                    bValid = bValid && checkLength(description, 'Description', 0, 5001);
                    if(bValid){
                        var url = "../InsertCategoryServlet?category="+category.val()+"&description="+description.val();
                        window.location.href = url;
                        $(this).dialog("close");
                    }
                },
                Cancel: function() {
                    $( this ).dialog( "close" );
                }
            },
            close: function() {
                allFields.val( "" ).removeClass( "ui-state-error" );
            }
        });

        $( "#create-category" )
        .button()
        .click(function() {
            $( "#dialog-form" ).dialog( "open" );
        });
    });
</script>
<header><h3 class="tabs_involved">All Categories</h3>
    <ul class="tabs">
        <li><a href="#tab1">Categories</a></li>
    </ul>
</header>
<sql:setDataSource driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
                   url="jdbc:sqlserver://localhost:1433;database=Mantech"
                   user="mantech" password="123" var="ds" scope="page"/>

<sql:query var="category" dataSource="${ds}">
    select ID,Name,[Description] from Category
</sql:query>
<div id="tab1" class="tab_content">
    <table class="tablesorter" cellspacing="0">
        <thead>
            <tr>
                <th>ID</th>
                <th>Category</th>
                <th>Description</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
             <c:forEach var="row" begin="0" items="${category.rowsByIndex}">
                <tr>
                        <td><c:out value="${row[0]}"/></td>
                        <td><c:out value="${row[1]}"/></td>
                        <td><c:out value="${row[2]}"/></td>
                        <td><a href="${pageContext.request.contextPath}/Complaints/DeleteCategoryModal.jsp?id=${row[0]}"><img src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash" /></a>
                    <a href="${pageContext.request.contextPath}/Complaints/EditCategoryModal.jsp?id=${row[0]}&category=${row[1]}&des=${row[2]}"><img src="${pageContext.request.contextPath}/images/icn_edit.png" title="Edit" /></a>
                </td>

               </tr>

            </c:forEach>
           <%-- <%
                        InitialContext context = null;
                        try {
                            context = new InitialContext();
                            CategoryBiz biz = (CategoryBiz) context.lookup("ejb/mantech/saigon/CategoryBiz");
                            List<Category> list = biz.findAll();
                            for (Category c : list) {
            %>
            <tr>
                <td><%= c.getId()%></td>
                <td><%= c.getName()%></td>
                <td><%= c.getDescription()%></td>
                <td><a href="${pageContext.request.contextPath}/Complaints/DeleteCategoryModal.jsp?id=<%= c.getId()  %>"><img src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash" /></a>
                    <a href="${pageContext.request.contextPath}/Complaints/EditCategoryModal.jsp?id=<%= c.getId()%>&category=<%=c.getName()%>&des=<%=c.getDescription() %> "><img src="${pageContext.request.contextPath}/images/icn_edit.png" title="Edit" /></a>
                </td>
            </tr>
            <%                     }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            context.close();
                        }
            %> --%>
        </tbody>
    </table>
</div><!-- end of #tab1 -->

<button id="create-category" >Create new category</button>

<div id="dialog-form" title="Create  new category">
    <p class="validateTips">All fields are required.</p>
    <form action="../InsertCategoryServlet" method="post" id="newCategoryForm">
        <fieldset class="modalForm">
            <table>
                <tr>
                    <td><label for="category">Category</label></td>
                    <td><textarea id="category" name="category" class="text ui-widget-content ui-corner-all"></textarea></td>
                </tr>
                <tr>
                    <td><label for="description">Description</label></td>
                    <td><textarea id="description" name="description" class="text ui-widget-content ui-corner-all"></textarea> </td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>


