<%-- 
    Document   : viewusers
    Created on : Oct 9, 2012, 10:15:03 AM
    Author     : NGUYEN
--%>

<header><h3 class="tabs_involved">Account Manager</h3>
    <ul class="tabs">
        <li><a href="#tab1">Accounts</a></li>
    </ul>
</header>

<div id="tab1" class="tab_content">
    <table class="tablesorter" cellspacing="0">
        <thead>
            <tr>
                <th></th>
                <th>ID</th>
                <th>Fullname</th>
                <th>Username</th>
                <th>Role</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>Lorem Ipsum Dolor Sit Amet</td>
                <td>Lorem Ipsum Dolor Sit Amet</td>
                <td>Articles</td>
                <td>Admin</td>
                <td>
                    <a href="${pageContext.request.contextPath}/Accounts/DeleteModal.jsp?id=1"><img src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash"/></a>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>Lorem Ipsum Dolor Sit Amet</td>
                <td>Lorem Ipsum Dolor Sit Amet</td>
                <td>Articles</td>
                <td>Admin</td>
                <td>
                    <a href="${pageContext.request.contextPath}/Accounts/DeleteModal.jsp"><img src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash"/></a>
                </td>
            </tr>
            <tr>
                <td>3</td>
                <td>Lorem Ipsum Dolor Sit Amet</td>
                <td>Lorem Ipsum Dolor Sit Amet</td>
                <td>Articles</td>
                <td>Admin</td>
                <td>
                    <a href="${pageContext.request.contextPath}/Accounts/DeleteModal.jsp"><img src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash"/></a>
                </td>
            </tr>

        </tbody>
    </table>
</div><!-- end of #tab1 -->

