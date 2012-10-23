<%-- 
    Document   : viewfaq
    Created on : Oct 22, 2012, 8:03:32 PM
    Author     : NGUYEN
--%>

<header><h3 class="tabs_involved">FAQ Manager</h3>
    <ul class="tabs">
        <li><a href="#tab1">FAQs</a></li>
    </ul>
</header>

<div id="tab1" class="tab_content">
    <table class="tablesorter" cellspacing="0">
        <thead>
            <tr>
                <th>ID</th>
                <th>Question</th>
                <th>Answer</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>Lorem Ipsum Dolor Sit Amet</td>
                <td>Articles</td>
                <td>
                    <a href="${pageContext.request.contextPath}/FAQ/DeleteFAQModal.jsp?id=1"><img src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash"/></a>
                    <a href="${pageContext.request.contextPath}/FAQ/ChangeAnswerModal.jsp?id=1&ques=Lorem Ipsum Dolor Sit Amet&ans=Articles"><img src="${pageContext.request.contextPath}/images/icn_edit.png" title="Edit"/></a>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>Lorem Ipsum Dolor Sit Amet</td>
                <td>Articles</td>
                <td>
                    <a href="${pageContext.request.contextPath}/FAQ/DeleteFAQModal.jsp"><img src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash"/></a>
                    <a href="${pageContext.request.contextPath}/FAQ/ChangeAnswerModal.jsp"><img src="${pageContext.request.contextPath}/images/icn_edit.png" title="Edit"/></a>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>Lorem Ipsum Dolor Sit Amet</td>
                <td>Articles</td>
                <td>
                    <a href="${pageContext.request.contextPath}/FAQ/DeleteFAQModal.jsp"><img src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash"/></a>
                    <a href="${pageContext.request.contextPath}/FAQ/ChangeAnswerModal.jsp"><img src="${pageContext.request.contextPath}/images/icn_edit.png" title="Edit"/></a>
                </td>
            </tr>
           <tr>
                <td></td>
                <td>Lorem Ipsum Dolor Sit Amet</td>
                <td>Articles</td>
                <td>
                    <a href="${pageContext.request.contextPath}/FAQ/DeleteFAQModal.jsp"><img src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash"/></a>
                    <a href="${pageContext.request.contextPath}/FAQ/ChangeAnswerModal.jsp"><img src="${pageContext.request.contextPath}/images/icn_edit.png" title="Edit"/></a>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>Lorem Ipsum Dolor Sit Amet</td>
                <td>Articles</td>
                <td>
                    <a href="${pageContext.request.contextPath}/FAQ/DeleteFAQModal.jsp"><img src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash"/></a>
                    <a href="${pageContext.request.contextPath}/FAQ/ChangeAnswerModal.jsp"><img src="${pageContext.request.contextPath}/images/icn_edit.png" title="Edit"/></a>
                </td>
            </tr>
        </tbody>
    </table>
</div><!-- end of #tab1 -->
