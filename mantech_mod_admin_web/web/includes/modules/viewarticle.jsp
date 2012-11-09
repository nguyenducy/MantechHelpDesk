<%-- 
    Document   : viewarticle
    Created on : Oct 12, 2012, 11:24:52 AM
    Author     : NGUYEN
--%>

<%@page import="mantech.mod.article.entity.Article"%>
<%@page import="java.util.List"%>
<%@page import="mantech.mod.article.api.ArticleBiz"%>
<%@page import="javax.naming.InitialContext"%>
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
             <%
                        InitialContext context = null;
                        try {
                            context = new InitialContext();
                            ArticleBiz biz = (ArticleBiz) context.lookup("ejb/mantech/saigon/ArticleBiz");
                            List<Article> list = biz.collectNewsArticle();
                            for (Article a : list) {
            %>
            <tr>
                <td><%= a.getId() %></td>
                <td><%= a.getArticle() %></td>
                <td><%= a.getContent() %></td>
                <td><%= a.getCreatedDate() %></td>
                <td><%= a.getRate() %></td>
                <td><%= a.getThumbnail() %></td>
                <td><a href="${pageContext.request.contextPath}/Articles/DeleteArticleModal.jsp?id=<%= a.getId()  %>"><img src="${pageContext.request.contextPath}/images/icn_trash.png" title="Trash" /></a>
                    <a href="${pageContext.request.contextPath}/Articles/ChangeArticleModal.jsp?id=<%= a.getId() %>&ar=<%= a.getArticle() %>&content=<%= a.getContent() %>&day=<%= a.getCreatedDate() %>&rate=<%= a.getRate() %>&thum=<%= a.getThumbnail() %>"><img src="${pageContext.request.contextPath}/images/icn_edit.png" title="Edit"/></a>
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


