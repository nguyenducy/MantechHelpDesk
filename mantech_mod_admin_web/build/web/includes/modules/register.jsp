<%-- 
    Document   : register
    Created on : Oct 8, 2012, 11:38:22 PM
    Author     : NGUYEN
--%>

<header><h3>Grant</h3></header>
<div class="module_content">
    <fieldset style="width: 30%">
        <label>User name</label>
        <input type="text" name="username" style="width: 70%" >
    </fieldset>
    <fieldset style="width: 30%">
        <label>Password</label>
        <input type="text" name="password" style="width: 70%" >
    </fieldset>
    <fieldset style="width: 30%">
        <label>Confirm Password</label>
        <input type="text" name="confirmPassword" style="width: 70%" >
    </fieldset>
    <fieldset style="width: 30%">
        <label>Role</label>
        <select style="width: 50%">
            <option>User</option>
            <option>Admin</option>
        </select>
    </fieldset>

</div>
<footer>
    <div class="submit_link">

        <input type="submit" value="Grant" class="alt_btn">
        <input type="submit" value="Reset">
    </div>
</footer>

