<%-- 
    Document   : viewarticle
    Created on : Oct 12, 2012, 11:24:52 AM
    Author     : NGUYEN
--%>

<header><h3 class="tabs_involved">All Articles</h3>
    <ul class="tabs">
        <li><a href="#tab1">Articles</a></li>
    </ul>
</header>


<div id="tab1" class="tab_content">
    <table class="tablesorter" cellspacing="0">
        <thead>
            <tr>
                <th>ID</th>
                <th>Article</th>
                <th>Content</th>
                <th>Created On</th>
                <th>Rate</th>
                <th>Thumnail</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>Lorem Ipsum Dolor Sit Amet</td>
                <td>Articles</td>
                <td>10/5/2012</td>
                <td>4</td>
                <td>Image1</td>
                <td><a href="${pageContext.request.contextPath}/Articles/DeleteArticleModal.jsp?id=1"><img src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash" /></a>
                    <a href="${pageContext.request.contextPath}/Articles/ChangeArticleModal.jsp?id=1&ar=Lorem Ipsum Dolor Sit Amet&content=Articles&day=10/5/2012&rate=4&thum=image1"><img src="${pageContext.request.contextPath}/images/icn_edit.png" title="Edit"/></a>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>Ipsum Lorem Dolor Sit Amet</td>
                <td>Freebies</td>
                <td>6th April 2011</td>
                <td></td>
                <td></td>
                <td><a href="${pageContext.request.contextPath}/Articles/DeleteArticleModal.jsp"><img src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash" /></a>
                    <a href="${pageContext.request.contextPath}/Articles/ChangeArticleModal.jsp?id=1&ar=Lorem Ipsum Dolor Sit Amet&content=Articles&day=5th April 2011&rate=4&thum=image1"><img src="${pageContext.request.contextPath}/images/icn_edit.png" title="Edit"/></a></td>
            </tr>
            <tr>
                <td>3</td>
                <td>Sit Amet Dolor Ipsum</td>
                <td>Tutorials</td>
                <td>10th April 2011</td>
                <td></td>
                <td></td>
                <td><a href="${pageContext.request.contextPath}/Articles/DeleteArticleModal.jsp"><img src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash" /></a>
                    <a href="${pageContext.request.contextPath}/Articles/ChangeArticleModal.jsp?id=1&ar=Lorem Ipsum Dolor Sit Amet&content=Articles&day=5th April 2011&rate=4&thum=image1"><img src="${pageContext.request.contextPath}/images/icn_edit.png" title="Edit"/></a></td>
            </tr>
            <tr>
                <td>4</td>
                <td>Dolor Lorem Amet</td>
                <td>Articles</td>
                <td>16th April 2011</td>
                <td></td>
                <td></td>
                <td><a href="${pageContext.request.contextPath}/Articles/DeleteArticleModal.jsp"><img src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash" /></a>
                    <a href="${pageContext.request.contextPath}/Articles/ChangeArticleModal.jsp?id=1&ar=Lorem Ipsum Dolor Sit Amet&content=Articles&day=5th April 2011&rate=4&thum=image1"><img src="${pageContext.request.contextPath}/images/icn_edit.png" title="Edit"/></a></td>
            </tr>
            <tr>
                <td>5</td>
                <td>Dolor Lorem Amet</td>
                <td>Articles</td>
                <td>16th April 2011</td>
                <td></td>
                <td></td>
                <td><a href="${pageContext.request.contextPath}/Articles/DeleteArticleModal.jsp"><img src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash" /></a>
                    <a href="${pageContext.request.contextPath}/Articles/ChangeArticleModal.jsp?id=1&ar=Lorem Ipsum Dolor Sit Amet&content=Articles&day=5th April 2011&rate=4&thum=image1"><img src="${pageContext.request.contextPath}/images/icn_edit.png" title="Edit"/></a></td>
            </tr>
        </tbody>
    </table>
</div><!-- end of #tab1 -->


