<%-- 
    Document   : profile
    Created on : Oct 9, 2012, 10:40:11 AM
    Author     : NGUYEN
--%>

<%@page import="java.util.List"%>
<%@page import="mantech.mod.complaint.entity.Complaint"%>
<%@page import="mantech.mod.complaint.api.ComplaintBiz"%>
<%@page import="mantech.mod.account.entity.Account"%>
<%@page import="mantech.mod.account.api.AccountBiz"%>
<%@page import="mantech.mod.account.entity.Profile"%>
<%@page import="mantech.mod.account.api.ProfileBiz"%>
<%@page import="javax.naming.InitialContext"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<header><h3 class="tabs_involved">My Profile</h3>
    <ul class="tabs">
        <li><a href="#tab1">Profile</a></li>
    </ul>
</header>
<sql:setDataSource driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
                   url="jdbc:sqlserver://localhost:1433;database=Mantech"
                   user="mantech" password="123" var="ds" scope="page"/>

<div id="tab1" class="tab_content">
    <table class="tablesorter" cellspacing="0">
         <thead>
            <tr>

                <th>Full Name</th>
                <th>Department</th>
                <th>Address</th>
                <th>Telephone</th>
                <th>Email</th>
                <th>Image</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%
                       
                        String id = (String) request.getSession(true).getValue("idCurrentUser");
                        
            %>
 <sql:query var="profile" dataSource="${ds}">
    SELECT     dbo.Profile.ID, dbo.Profile.FullName, dbo.Profile.Address, dbo.Profile.Email, dbo.Profile.Telephone, dbo.Profile.Image, dbo.Department.Name,
                      dbo.Profile.DepartmentID
    FROM         dbo.Profile INNER JOIN
                      dbo.Department ON dbo.Profile.DepartmentID = dbo.Department.ID
    WHERE     (dbo.Profile.ID = ?)
    <sql:param value="<%=id%>"/>
</sql:query>
           <c:forEach var="row" begin="0" items="${profile.rowsByIndex}">
                <tr>

                        <td><c:out value="${row[1]}"/></td>
                        <td><c:out value="${row[6]}"/></td>
                        <td><c:out value="${row[2]}"/></td>
                        <td><c:out value="${row[4]}"/></td>
                        <td><c:out value="${row[3]}"/></td>
                <td><img src="${pageContext.request.contextPath}/ImageProfile/${row[5]}" width="50" height="50"/></td>
                <td><a href="${pageContext.request.contextPath}/Profiles/EditProfileModal.jsp?id=${row[0]}&fullName=${row[1]}&department=${row[7]}&address=${row[2]}&telephone=${row[4]}&email=${row[3]}"><img src="${pageContext.request.contextPath}/images/icn_edit.png" title="Edit" /></a></td>
            </tr>
           </c:forEach>
        </tbody>
    </table>
</div><!-- end of #tab1 -->


