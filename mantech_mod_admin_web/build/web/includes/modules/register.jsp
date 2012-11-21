<%-- 
    Document   : register
    Created on : Oct 8, 2012, 11:38:22 PM
    Author     : NGUYEN
--%>
<%@page import="mantech.mod.account.entity.Job"%>
<%@page import="mantech.mod.account.api.JobBiz"%>
<%@page import="mantech.mod.account.entity.Role"%>
<%@page import="mantech.mod.account.api.RoleBiz"%>
<%@page import="mantech.mod.account.entity.Department"%>
<%@page import="java.util.List"%>
<%@page import="mantech.mod.account.api.DepartmentBiz"%>
<%@page import="javax.naming.InitialContext"%>

<script type="text/javascript">
    $(document).ready(function(){
        $("#grantForm").validate({
            rules:{
                username: {required: true, maxlength: 10},
                password: {required: true, maxlength: 15},
                confirmPassword: {required: true, maxlength: 15, equalTo: "#password"},
                fullName : {required: true, maxlength: 30},
                email: {required: true, email: true, maxlength: 50},
                address : {required: true, maxlength: 100},
                telephone: {required: true, digits :  true, rangelength: [9,12]},
                image : {required: true, extension: "png|jpeg|jpg"}
            },
            messages:{
                username: {
                    required: "Required",
                    maxlength: "Less than 11 characters"
                },
                password:{
                    required: "Required",
                    maxlength: "Less than 16 characters"
                },
                confirmPassword: {
                    required: "Required",
                    maxlength: "Less than 16 characters",
                    equalTo : "The same password again"
                },
                fullName:{
                    required: "Required",
                    maxlength: "Less than 31 characters"
                },
                email:{
                    required: "Required",
                    email: "A Invalid email",
                    maxlength: "Less than 51 characters"
                },
                address: {
                    required: "Required",
                    maxlength: "Less than 101 characters"
                },
                telephone:{
                    required: "Required",
                    digits: "Only numbers",
                    rangelength: "Between 9 and 12 digits"
                },
                image:{
                    required : "Required"
                }
            }
        });
        jQuery.validator.addMethod("extension", function(value, element, param) {
            param = typeof param === "string" ? param.replace(/,/g, '|') : "png|jpeg|gif";
            return this.optional(element) || value.match(new RegExp(".(" + param + ")$", "i"));
        }, jQuery.format("Only PNG or JPEG extenstion."));

        $("#username").blur(function(){
            $("#InfoUsername").load('../CheckUsernameAvaibleForGrantServlet', {username: $("#username").val()})
        });

        $("#email").blur(function(){
            $("#InfoEmail").load('../CheckEmailAvaibleServlet', {email: $("#email").val()});
            
        });

        $('#reset').click(function(){
            $('#Info').html("");
        });
    });
</script>


<form action="../InsertAccountServlet" id="grantForm" method="post" enctype="multipart/form-data">
    <header><h3>Grant</h3></header>
    <div class="module_content">
        <fieldset style="width: 30%">
            <label>User name</label>
            <input type="text" name="username" id="username" style="width: 70%">
            <div id="InfoUsername" style="color: red;"></div>
        </fieldset>
        <fieldset style="width: 30%">
            <label>Password</label>
            <input type="password" name="password" id="password" style="width: 70%">
        </fieldset>
        <fieldset style="width: 30%">
            <label>Confirm Password</label>
            <input type="password" name="confirmPassword" id="confirmPassword" style="width: 70%">
        </fieldset>
        <fieldset style="width: 30%">
            <label>Role</label>
            <select style="width: 50%" name="role">
                <%
                            InitialContext context = null;
                            try {
                                context = new InitialContext();
                                RoleBiz biz = (RoleBiz) context.lookup("ejb/mantech/saigon/RoleBiz");
                                List<Role> list = biz.findAll();
                                if (list != null) {
                                    for (Role r : list) {
                %>
                <option value="<%= r.getId()%>"><%= r.getRole()%></option>
                <%                       }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                %>
            </select>
        </fieldset>
        <fieldset style="width: 30%">
            <label>Job</label>
            <select style="width: 50%" name="job">
                <%
                            try {
                                JobBiz jobBiz = (JobBiz) context.lookup("ejb/mantech/saigon/JobBiz");
                                List<Job> listJob = jobBiz.findAll();
                                if (listJob != null) {
                                    for (Job j : listJob) {
                %>
                <option value="<%= j.getId()%>"><%= j.getJob()%></option>
                <%                       }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            } 
                %>
            </select>
        </fieldset>
        <fieldset style="width: 30%">
            <label>Full Name</label>
            <input type="text" name="fullName" style="width: 70%" id="fullName">
        </fieldset>
        <fieldset style="width: 30%">
            <label>Address</label>
            <input type="text" name="address" style="width: 70%" id="address" >
        </fieldset>
        <fieldset style="width: 30%">
            <label>Email</label>
            <input type="text" name="email" style="width: 70%"id="email" >
            <div id="InfoEmail" style="color: red;"></div>
        </fieldset>
        <fieldset style="width: 30%">
            <label>Telephone</label>
            <input type="text" name="telephone" style="width: 70%" >
        </fieldset>
        <fieldset style="width: 30%">
            <label>Department</label>
            <select style="width: 50%" name="department">
                <%
                            try {
                                DepartmentBiz biz = (DepartmentBiz) context.lookup("ejb/mantech/saigon/DepartmentBiz");
                                List<Department> list = biz.findAll();
                                if (list != null) {
                                    for (Department d : list) {
                %>
                <option value="<%= d.getId()%>"><%= d.getName()%></option>
                <%                       }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                %>
            </select>
        </fieldset>
        <fieldset style="width: 30%">
            <label>Image</label>
            <input type="file" name="image" style="width: 70%" >
        </fieldset>
    </div>
    <footer>
        <div class="submit_link">
            <input type="submit" value="Grant" class="alt_btn">
            <input type="reset" value="Reset" id="reset">
        </div>
    </footer>
</form>
