<%-- 
    Document   : left
    Created on : Sep 29, 2012, 7:29:13 PM
    Author     : NGUYEN
--%>

<form class="quick_search">
    <input type="text" value="Quick Search" onfocus="if(!this._haschanged){this.value=''};this._haschanged=true;">
</form>
<hr/>
<h3>Complaint</h3>
<ul class="toggle">
    <li class="icn_categories"><a href="${pageContext.request.contextPath}/Complaints/ViewComplaints.jsp">View complaints</a></li>
    <li class="icn_edit_article"><a href="${pageContext.request.contextPath}/Complaints/ViewPending.jsp">Pending</a></li>
    <li class="icn_tags"><a href="${pageContext.request.contextPath}/Complaints/ViewCategory.jsp">Categories</a></li>
    <li class="icn_view_users"><a href="${pageContext.request.contextPath}/Complaints/ViewTechnicians.jsp">Technicians</a></li>
</ul>
<h3>Account</h3>
<ul class="toggle">
    <li class="icn_add_user"><a href="${pageContext.request.contextPath}/Accounts/Grant.jsp">Add New User</a></li>
    <li class="icn_view_users"><a href="${pageContext.request.contextPath}/Accounts/ViewAccount.jsp">View Accounts</a></li>
    <li class="icn_security"><a href="${pageContext.request.contextPath}/Accounts/ChangePassword.jsp">Change Password</a></li>
    <li class="icn_view_users"><a href="${pageContext.request.contextPath}/Accounts/ViewUsers.jsp">View Users</a></li>
</ul>
<h3>Artilce</h3>
<ul class="toggle">
    <li class="icn_new_article"><a href="${pageContext.request.contextPath}/Articles/NewArticle.jsp">New Article</a></li>
    <li class="icn_folder"><a href="${pageContext.request.contextPath}/Articles/ViewArticle.jsp">View Articles</a></li>
    
</ul>
<h3>FAQ</h3>
<ul class="toggle">
    <li class="icn_photo"><a href="${pageContext.request.contextPath}/FAQ/FAQ.jsp">FAQ</a></li>
    <li class="icn_folder"><a href="${pageContext.request.contextPath}/FAQ/ViewFAQ.jsp">View FAQs</a></li>
    
    <!--<li class="icn_audio"><a href="#">Audio</a></li>
    <li class="icn_video"><a href="#">Video</a></li>-->
</ul>
<h3>Admin</h3>
<ul class="toggle">
    <li class="icn_settings"><a href="#">Options</a></li>
    <li class="icn_security"><a href="${pageContext.request.contextPath}/Accounts/NewRole.jsp">Add Role</a></li>
    <li class="icn_profile"><a href="${pageContext.request.contextPath}/Profiles/ViewProfile.jsp">My Profile</a></li>
    <li class="icn_jump_back"><a href="${pageContext.request.contextPath}/login.html">Logout</a></li>
</ul>

<footer>
    <jsp:include page="copyright.jsp"/>
</footer>
