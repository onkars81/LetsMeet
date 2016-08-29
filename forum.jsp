<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Let's Meet</title>
<link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet">
<link href="<c:url value='/resources/css/default.css'/>" rel="stylesheet">
</head>
<body>

<%@ include file="/WEB-INF/views/template/nav.jsp" %>

<c:if test="${forumcreated==1}">
<%@ include file="/WEB-INF/views/forumsuccess.jsp" %>
</c:if>
<div class="container">

<div class="row">
		<div class="col-md-3 profile">
			<aside>
				<img src="<c:url value='/resources/images/profileimg/${user.userid}.jpg'/>"
					alt="profile image" class="img-circle" />
				<h4>${user.name}</h4>
				<p>${user.email}</p>
				<a href="https://twitter.com/${user.username}" class="twitter-follow-button"
					data-show-count="true" data-lang="en"> Follow @ ${user.name} </a>
				<hr>
				<p>Share this page:</p>
				<ul class="clearfix">
					<li><img
						src="<c:url value='/resources/images/social_icons/email.png'/>"></li>
					<li><img
						src="<c:url value='/resources/images/social_icons/facebook.png'/>"></li>
					<li><img
						src="<c:url value='/resources/images/social_icons/googleplus.png'/>"></li>
					<li><img
						src="<c:url value='/resources/images/social_icons/linkedin.png'/>"></li>
					<li><img
						src="<c:url value='/resources/images/social_icons/pinterest.png'/>"></li>
					<li><img
						src="<c:url value='/resources/images/social_icons/twitter.png'/>"></li>
				</ul>
			</aside>
		</div>
			<div class="col-md-8">
				
				
				<c:forEach items="${forumposters}" var="forumposter">
				<article>
					<header>
						<h2>${forumposter.forumpost}</h2><h4><a href="forumarticle/${forumposter.forumid}">Read More</a></h4>
					</header>
					<footer>
					<small>	Posted on: ${forumposter.j_date}</small> 
					<br>
					<small>	Posted by: ${fuser.username}</small> 
					</footer>
					<div class="lead">${forumposter.type}</div>

					<footer>
						<span class="label label-default">alphabets</span> <span
							class="label label-default">code</span>
					</footer>

				
				</article>
				</c:forEach>
			
				<hr>

				<form:form method="post" action="${pageContext.request.contextPath}/forum" commandName="forums">
						<h3>Add New Forum :</h3>
						
						<p>
						<label class="sr-only">Username</label>
						<%-- <form:errors path="${user.userid}" cssStyle="color: #ff0000" /> --%>
						<%-- <form:hidden path="user" value="${user}" id="user"  /> --%>
						</p>
						
						<p>
						<label class="sr-only">Type</label>
						<form:errors path="type" cssStyle="color: #ff0000" />
						<form:input type="text" class="form-control" name="type" path="type" placeholder="Type Of Post " id="type"  />
						</p>
						
						<p>
						<label class="sr-only">Blog Post</label> 
						<form:errors path="forumpost" cssStyle="color:#ff0000" />
						<form:textarea class="form-control" name="forumpost" path="forumpost" placeholder="Start Discussion On" id="forumpost"/>
						<!-- required autocomplete="false" ></textarea> -->
						</p>
						
						<p>
						<form:button type="submit" class="btn btn-block btn-primary" >Start Forum</form:button>
						</p>
						</form:form>
			
 		</div>
 	</div>
</div>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>