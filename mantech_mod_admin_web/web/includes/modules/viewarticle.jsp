<%-- 
    Document   : viewarticle
    Created on : Oct 12, 2012, 11:24:52 AM
    Author     : NGUYEN
--%>

<%@page import="java.util.List" %>
<%@page import="mantech.mod.article.entity.Article"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header><h3 class="tabs_involved">All Articles</h3>
    <ul class="tabs">
        <li><a href="#">Articles</a></li>
    </ul>
</header>
<% List<Article> listArticle = (List<Article>)session.getAttribute("listArticle");%>
<div id="tab1" class="tab_content">
    <table class="tablesorter" cellspacing="0">
        <thead>
            <tr>

                <th>ID</th>
                <th>Article</th>

                <%--<th>Content</th>--%>

                <th>Created On</th>
                <th>Rate</th>
                <th>Thumnail</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <% for(Article article: listArticle)
                {
                String thumbNail = getServletContext().getRealPath("/")+"imagesThumb"+"\\"+article.getThumbnail();
            %>
            <tr>
                <td><%= article.getId()%></td>
                <td><%=article.getArticle()%></td>
                
                <%--<td><%=article.getContent()%></td>--%>

                <td><%= article.getCreatedDate()%></td>
                <td> <%= article.getRate()%> </td>
                <td><%= article.getThumbnail()%></td>
                <td><a href="${pageContext.request.contextPath}/Articles/DeleteArticleModal.jsp?id=<%= article.getId()%>"><img src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash" /></a>
                    <a href="${pageContext.request.contextPath}/Articles/ChangeArticleModal.jsp?id=<%= article.getId()%>&ar=<%= article.getArticle()%>&content=<%=article.getContent()%>&day=<%= article.getCreatedDate()%>&rate=<%= article.getRate() %>&thum=<%=thumbNail%>"><img src="${pageContext.request.contextPath}/images/icn_edit.png" title="Edit"/></a>
                </td>
            </tr>
            <%}%>
        </tbody>
    </table>
</div><!-- end of #tab1 -->


