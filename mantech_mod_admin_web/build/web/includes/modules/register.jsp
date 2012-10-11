<%-- 
    Document   : register
    Created on : Oct 8, 2012, 11:38:22 PM
    Author     : NGUYEN
--%>
<script>
    $(document).ready(function(){
        $("#grantForm").validate({
            rules:{
                username: {required: true},
                password: {required: true},
                confirmPassword: {required: true},
                fullName : {required: true},
                address : {required: true},
                telephone: {required: true},
                image : {required: true, extension: "png|jpeg"}
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
            <input type="text" name="username" id="username" style="width: 70%" >
        </fieldset>
        <fieldset style="width: 30%">
            <label>Password</label>
            <input type="password" name="password"  style="width: 70%" >
        </fieldset>
        <fieldset style="width: 30%">
            <label>Confirm Password</label>
            <input type="password" name="confirmPassword" style="width: 70%" >
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
            <input type="text" name="address" style="width: 70%" >
        </fieldset>
        <fieldset style="width: 30%">
            <label>Telephone</label>
            <input type="text" name="telephone" style="width: 70%" >
        </fieldset>
        <fieldset style="width: 30%">
            <label>Role</label>
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
            <input type="submit" value="Reset">
        </div>
    </footer>
</form>
