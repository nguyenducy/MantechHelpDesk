<%-- 
    Document   : viewfaq
    Created on : Oct 22, 2012, 8:03:32 PM
    Author     : NGUYEN
--%>

<%@page import="java.util.List"%>
<%@page import="mantech.mod.article.entity.Faq"%>
<%@page import="mantech.mod.article.api.FAQBiz"%>
<%@page import="javax.naming.InitialContext"%>
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
            <%
                        InitialContext context = null;
                        try {
                            context = new InitialContext();
                            FAQBiz biz = (FAQBiz) context.lookup("ejb/mantech/saigon/FAQBiz");
                            List<Faq> list = biz.listAllFAQ();
                            for (Faq f : list) {
            %>
            <tr>
                <td><%= f.getId() %></td>
                <td><%= f.getQuestion() %></td>
                <td><%= f.getAnswer() %></td>
                <td>
                    <a href="${pageContext.request.contextPath}/FAQ/DeleteFAQModal.jsp?id=<%= f.getId() %>"><img src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash"/></a>
                    <a href="${pageContext.request.contextPath}/FAQ/ChangeAnswerModal.jsp?id=<%= f.getId() %>&ques=<%= f.getQuestion() %>&ans=<%= f.getAnswer() %>"><img src="${pageContext.request.contextPath}/images/icn_edit.png" title="Edit"/></a>
                </td>
            </tr>
            <%                     }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            context.close();
                        }
            %>
        </tbody>
    </table>
</div><!-- end of #tab1 -->
