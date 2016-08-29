<%@ include file="/WEB-INF/views/template/header.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Let's Meet</title>

<%@ include file="/WEB-INF/views/template/header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="<c:url value='/resources/css/default.css'/>" rel="stylesheet">
<link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet">
<link href="<c:url value='/resources/css/glyphicons/bootstrap.min.css'/>" rel="stylesheet">


<html ng-app="angularDatatableModule">
 <head>
  <title>AngularJS Datatable Example</title>
   
   
   <spring:url value="/resources/js/libs/" var="jquery" ></spring:url>
     <!-- JQUERY -->
     <script src="${jquery}/angular-datatables-master/vendor/jquery/dist/jquery.js"></script>     
     <script src="${jquery}/angular-datatables-master/vendor/datatables/media/js/jquery.dataTables.min.js"></script>
     <link rel="stylesheet" href="${jquery}/angular-datatables-master/vendor/datatables/media/css/jquery.dataTables.min.css">
  
     <!-- ANGULAR -->
     <script src="${jquery}/angular-datatables-master/vendor/angular/angular.js"></script>
   
     <script src="${jquery}/angular-datatables-master/src/angular-datatables.directive.js"></script>
     <script src="${jquery}/angular-datatables-master/src/angular-datatables.instances.js"></script>
     <script src="${jquery}/angular-datatables-master/src/angular-datatables.util.js"></script>
     <script src="${jquery}/angular-datatables-master/src/angular-datatables.renderer.js"></script>
     <script src="${jquery}/angular-datatables-master/src/angular-datatables.factory.js"></script>
     <script src="${jquery}/angular-datatables-master/src/angular-datatables.options.js"></script>
     <script src="${jquery}/angular-datatables-master/src/angular-datatables.js"></script>
 
     <!-- CUSTOM -->
     <script src='<c:url value="/resources/js/datatableController.js" />'></script>
 
 </head>
 <body>
   <%@ include file="/WEB-INF/views/template/nav.jsp"%> 
 
    <table datatable="" class="row-border hover">
      <thead >
       <tr>
       <th style="width: 328px; text-align:center;">Profile Picture</th>
       <th >Name</th>
       <th >Post</th>
       <th >Approve</th>
       <th >Decline</th>
       </tr>
      </thead>
      <tbody>
       <c:forEach items="${forumrequests}" var="forumreq">
       <tr>
         <td align="center">
         <img src="<c:url value="/resources/images/profileimg/${forumreq.user.userid}.jpg"/>"
          alt="profile image" class="img-circle"  width="20%"/></td>
         <td align="center">${forumreq.user.username}</td>
         <td align="center">${forumreq.forumpost}</td>
         <td align="center"><a href="<c:url value="/admin/acceptforum/${forumreq.forumid}"/>" class="btn btn-primary">Approve</a></td>
         <td align="center"> <a href="<c:url value="/admin/deleteforum/${forumreq.forumid}"/>" class="btn btn-primary btn-danger">Decline</a></td>
       </tr>
       </c:forEach>
      </tbody>
    </table>
   
 </body>
</html> 





