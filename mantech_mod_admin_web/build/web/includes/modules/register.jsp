<%-- 
    Document   : register
    Created on : Oct 8, 2012, 11:38:22 PM
    Author     : NGUYEN
--%>
<script>
    $(document).ready(function(){
        $("#grantForm").validate({
            rules:{
                username: {required: true, maxlength: 10},
                password: {required: true, maxlength: 15},
                confirmPassword: {required: true, maxlength: 15, equalTo: "#password"},
                fullName : {required: true, maxlength: 30},
                email: {required: true, email: true, maxlength: 50},
                address : {required: true, maxlength: 100},
                telephone: {required: true, digits :  true, maxlength: 12},
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
                    maxlength: "Less than 11 characters"
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
    });
</script>

<form action="" id="grantForm" method="post">
    <header><h3>Grant</h3></header>
    <div class="module_content">
        <fieldset style="width: 30%">
            <label>User name</label>
            <input type="text" name="username" id="username" style="width: 70%">
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
            <select style="width: 50%">
                <option>User</option>
                <option>Admin</option>
            </select>
        </fieldset>
        <fieldset style="width: 30%">
            <label>Full Name</label>
            <input type="text" name="fullName" style="width: 70%" >
        </fieldset>
        <fieldset style="width: 30%">
            <label>Address</label>
            <textarea name="address" style="width: 70%"></textarea>
        </fieldset>
        <fieldset style="width: 30%">
            <label>Email</label>
            <input type="text" name="email" style="width: 70%" >
        </fieldset>
        <fieldset style="width: 30%">
            <label>Telephone</label>
            <input type="text" name="telephone" style="width: 70%" >
        </fieldset>
        <fieldset style="width: 30%">
            <label>Department</label>
            <select style="width: 50%">
                <option>Education Services</option>
                <option>Learning Service</option>
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
            <input type="reset" value="Reset">
        </div>
    </footer>
</form>
