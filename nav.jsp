<link href="<c:url value='/resources/css/notification.css'/>" rel="stylesheet"> 

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
	    
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand active" href="${pageContext.request.contextPath}/home">Let's Tweet</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
       
       <c:if test="${pageContext.request.userPrincipal.name != null && pageContext.request.userPrincipal.name !='admin'}">
       
        <li><a href="${pageContext.request.contextPath}/posts">Posts <span class="sr-only">(current)</span></a></li>
        <li><a href="${pageContext.request.contextPath}/profile">Profile <span class="sr-only">(current)</span></a></li>
        <li><a href="${pageContext.request.contextPath}/contacts">Contact<span class="sr-only">(current)</span></a></li>
        <li><a href="${pageContext.request.contextPath}/showChat">Start Chat<span class="sr-only">(current)</span></a></li>
      	<li><a href="${pageContext.request.contextPath}/forum">Forum<span class="sr-only">(current)</span></a></li>
      </c:if>
        <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
		<li><a href="${pageContext.request.contextPath}/admin/adminpage">Forum Requests <span class="sr-only">(current)</span></a></li>
       	<li><a href="${pageContext.request.contextPath}/admin/allusers">User Management <span class="sr-only">(current)</span></a></li>
       </c:if>
        
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
      <c:url value="/perform_logout" var="logoutUrl" />
				<form action="${logoutUrl}" method="post" id="logoutForm">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
      		<c:if test="${pageContext.request.userPrincipal.name != null}">
         	<li><a href="#" id="frndrqstclick" class="dropdown-toggle" data-toggle="dropdown">
         	<span class="glyphicon glyphicon-user"></span>
            <span id="frndnotifval" style="padding: 0px 3px; border-radius: 2px 2px 2px 2px; background-color: rgb(240, 61, 37); font-size: 12px; font-weight: bold; color: #fff; visibility: hidden;"></span>
            </a>
            <ul class="dropdown-menu" role="menu" id = "frndrqstdropdwn" style="width:300px;">
      		<li><a href="<c:url value="javascript:formSubmit()" />">Logout</a></li>
      		</ul>
                 
        <li id="notification_li">
		<span id="notification_count">3</span>
		<a href="#" id="notificationLink"><span class="glyphicon glyphicon-bell"></span></a>

		<div id="notificationContainer">
		<div id="notificationTitle">Notifications</div>
		<div id="notificationsBody" class="notifications"></div>
		<div id="notificationFooter"><a href="#">See All</a></div>
		</div>
		</li>
             <li><a><img src="<c:url value="/resources/images/profileimg/${user.userid}.jpg"/>" width="30px" class="img-circle">  Hi, ${pageContext.request.userPrincipal.name}</a></li>
      </c:if>
       <c:if test="${pageContext.request.userPrincipal.name == null}">
        <li><a href="${pageContext.request.contextPath}/signin">Login</a></li>
        <li><a href="${pageContext.request.contextPath}/register">Sign Up</a></li>
        </c:if>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
