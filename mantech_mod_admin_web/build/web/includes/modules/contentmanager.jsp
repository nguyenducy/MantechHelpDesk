<%-- 
    Document   : contentmanager
    Created on : Sep 29, 2012, 7:59:42 PM
    Author     : NGUYEN
--%>

<header><h3 class="tabs_involved">Content Manager</h3>
    <ul class="tabs">
        <li><a href="#tab1">Posts</a></li>
    </ul>
</header>


<div id="tab1" class="tab_content">
    <table class="tablesorter" cellspacing="0">
        <thead>
            <tr>
                <th></th>
                <th>Entry Name</th>
                <th>Category</th>
                <th>Created On</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><input type="checkbox"></td>
                <td>Lorem Ipsum Dolor Sit Amet</td>
                <td>Articles</td>
                <td>5th April 2011</td>
                <td><input type="image" src="${pageContext.request.contextPath}/images/icn_edit.png" title="Edit"><input type="image" src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash"></td>
            </tr>
            <tr>
                <td><input type="checkbox"></td>
                <td>Ipsum Lorem Dolor Sit Amet</td>
                <td>Freebies</td>
                <td>6th April 2011</td>
                <td><input type="image" src="${pageContext.request.contextPath}/images/icn_edit.png" title="Edit"><input type="image" src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash"></td>
            </tr>
            <tr>
                <td><input type="checkbox"></td>
                <td>Sit Amet Dolor Ipsum</td>
                <td>Tutorials</td>
                <td>10th April 2011</td>
                <td><input type="image" src="${pageContext.request.contextPath}/images/icn_edit.png" title="Edit"><input type="image" src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash"></td>
            </tr>
            <tr>
                <td><input type="checkbox"></td>
                <td>Dolor Lorem Amet</td>
                <td>Articles</td>
                <td>16th April 2011</td>
                <td><input type="image" src="${pageContext.request.contextPath}/images/icn_edit.png" title="Edit"><input type="image" src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash"></td>
            </tr>
            <tr>
                <td><input type="checkbox"></td>
                <td>Dolor Lorem Amet</td>
                <td>Articles</td>
                <td>16th April 2011</td>
                <td><input type="image" src="${pageContext.request.contextPath}/images/icn_edit.png" title="Edit"><input type="image" src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash"></td>
            </tr>
        </tbody>
    </table>
</div><!-- end of #tab1 -->

