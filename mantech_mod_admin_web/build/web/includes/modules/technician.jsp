<%-- 
    Document   : technician
    Created on : Oct 9, 2012, 11:05:24 AM
    Author     : NGUYEN
--%>

<%@page import="mantech.mod.account.entity.Department"%>
<%@page import="mantech.mod.account.api.DepartmentBiz"%>
<%@page import="mantech.mod.account.entity.Profile"%>
<%@page import="mantech.mod.account.api.ProfileBiz"%>
<%@page import="java.util.List"%>
<%@page import="javax.naming.InitialContext"%>

<script>
    $(function() {
        var fullname = $( "#fullName" ),
        department = $( "#department" ),
        address = $( "#address" ),
        telephone = $( "#telephone" ),
        email = $( "#email" ),
        image = $("#image"),
        allFields = $( [] ).add(fullname ).add(department).add( address ).add(telephone).add(email).add(image),
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
            height: 400,
            width: 508,
            modal: true,
            buttons: {
                "Create a technician": function() {
                    var bValid = true;
                    allFields.removeClass( "ui-state-error" );
                    bValid = bValid && checkRequired(fullname, 'Full Name', 'is required');
                    bValid = bValid && checkLength(fullname, 'Full Name', 0, 31);
                    bValid = bValid && checkRequired(address, 'Address', 'is required');
                    bValid = bValid && checkLength(address, 'Address', 0, 1001);
                    bValid = bValid && checkRequired(telephone, 'Telephone', 'is required');
                    bValid = bValid && checkRegexp(telephone, /^\d+$/, 'A valid telephone is numbers ');
                    bValid = bValid && checkLength(telephone, 'Telephone', 8, 13);
                    bValid = bValid && checkRequired(email, 'Email', 'is required');
                    bValid = bValid && checkRegexp(email, /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i , 'Enter a valid email');
                    bValid = bValid && checkLength(email, 'Email', 0, 51);
                    bValid = bValid && checkRegexp(image, /\.(jpg|jpeg|png)$/i, 'Only png and jpg');
                    if(bValid){
                        var d = department.children(':selected').val();
                        var url = "../InsertTechnicianServlet?fullName="+fullname.val()+"&department="+d+"&address="
                            +address.val()+"&telephone="+telephone.val()+"email="+email.val();
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
<header><h3 class="tabs_involved">My Technicians</h3>
    <ul class="tabs">
        <li><a href="#tab1">Technicians</a></li>
    </ul>
</header>


<div id="tab1" class="tab_content">
    <table class="tablesorter" cellspacing="0">
        <thead>
            <tr>
                <th>ID</th>
                <th>Full Name</th>
                <th>Department</th>
                <th>Address</th>
                <th>Telephone</th>
                <th>Email</th>
                <th>Image</th>
            </tr>
        </thead>
        <tbody>
            <%
                        InitialContext context = null;
                        try {
                            context = new InitialContext();
                            ProfileBiz biz = (ProfileBiz) context.lookup("ejb/mantech/saigon/ProfileBiz");
                            List<Profile> list = biz.findTechnician();
                            for (Profile t : list) {
            %>
            <tr>
                <td><%= t.getId()%></td>
                <td><%= t.getFullName()%></td>
                <td><%= t.getDepartment().getName()%></td>
                <td><%= t.getAddress()%></td>
                <td><%= t.getTelephone()%></td>
                <td><%= t.getEmail()%></td>
                <td><%= t.getImage()%></td>
            </tr>
            <%                     }

            %>
        </tbody>
    </table>
</div><!-- end of #tab1 -->

<button id="create-category" >Create new techician</button>

<div id="dialog-form" title="Create new technician">
    <p class="validateTips">All fields are required.</p>
    <form action="../InsertTechnicianServlet" method="post" id="newCategoryForm">
        <fieldset class="modalForm">
            <table>
                <tr>
                    <td><label for="fullName">Full Name</label></td>
                    <td><textarea id="fullName" name="fullName" class="text ui-widget-content ui-corner-all"></textarea></td>
                </tr>
                <tr>
                    <td><label for="department">Department</label></td>
                    <td>
                        <select name="department" id="department">
                            <%

                                                        DepartmentBiz departmentBiz = (DepartmentBiz) context.lookup("ejb/mantech/saigon/DepartmentBiz");
                                                        List<Department> listD = departmentBiz.findAll();
                                                        for (Department d : listD) {
                            %>
                            <option value="<%= d.getId().toString()%>" ><%= d.getName()%></option>
                            <%
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        } finally {
                                            context.close();
                                        }
                            %>
                        </select>
                    <td>
                </tr>
                <tr>
                    <td><label for="address">Address</label></td>
                    <td><textarea id="address" name="address" class="text ui-widget-content ui-corner-all"></textarea> </td>
                </tr>
                <tr>
                    <td><label for="telephone">Telephone</label></td>
                    <td><textarea id="telephone" name="telephone" class="text ui-widget-content ui-corner-all"></textarea> </td>
                </tr>
                <tr>
                    <td><label for="email">Email</label></td>
                    <td><textarea id="email" name="email" class="text ui-widget-content ui-corner-all"></textarea> </td>
                </tr>
                <tr>
                    <td><label for="image">Image</label></td>
                    <td><input type="file" id="image" name="image"/></td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>


