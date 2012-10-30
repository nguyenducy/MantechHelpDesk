<%-- 
    Document   : viewfaq
    Created on : Oct 22, 2012, 8:03:32 PM
    Author     : NGUYEN
--%>

<%@page import="mantech.mod.article.entity.Faq"%>
<%@page import="java.util.List"%>
<header><h3 class="tabs_involved">FAQ Manager</h3>
    <ul class="tabs">
        <li><a href="#tab1">FAQs</a></li>
    </ul>
</header>

<% List<Faq> listFAQ = (List<Faq>)session.getAttribute("listFAQ"); %>

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
            <% for(Faq faq:listFAQ){ %>
            <tr>
                <td><%=faq.getId()%> </td>
                <td><%=faq.getQuestion()%></td>
                <td><%=faq.getAnswer()%></td>
                <td>
                    <a href="${pageContext.request.contextPath}/FAQ/DeleteFAQModal.jsp?id=<%=faq.getId()%>"><img src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash"/></a>
                    <a href="${pageContext.request.contextPath}/FAQ/ChangeAnswerModal.jsp?id=<%=faq.getId()%>&ques=<%=faq.getQuestion()%>&ans=<%=faq.getAnswer()%>"><img src="${pageContext.request.contextPath}/images/icn_edit.png" title="Edit"/></a>
                </td>
            </tr>
            <%}%>
        </tbody>
    </table>
</div><!-- end of #tab1 -->
