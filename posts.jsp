<%@ include file="/WEB-INF/views/template/header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Let's Meet</title>
<link href="<c:url value='/resources/css/bootstrap.min.css'/>"
	rel="stylesheet">
<link href="<c:url value='/resources/css/default.css'/>"
	rel="stylesheet">
<link rel="stylesheet" href="<c:url value='/resources/css/posts.css'/>">
</head>
<body>
	<%@ include file="/WEB-INF/views/template/nav.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-12 col-xs-12 profile">
				<aside>
					<div class="clearfix">
						<img src="<c:url value='/resources/images/profileimg/${user.userid}.jpg'/>"
							alt="profile image" class="img-circle" />
						<div class="profile-content">
							<h4>${user.name}</h4>
							<p></p>
							<a href="https://twitter.com/${user.username}"
								class="twitter-follow-button" data-show-count="true"
								data-lang="en"> Follow @ ${user.email} </a>
						</div>
						<hr class="hidden-xs hidden-sm">
						<div class="social_icons">
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
						</div>
					</div>
				</aside>
			</div>

				
			<div class="col-md-8">
			<c:forEach items="${bloggers}" var="blogger">
				<article>
					<header>
						<h2>${blogger.title}</h2>
					</header>
					<footer>
					<small>	Posted on: ${blogger.bdate}</small> 
					</footer>
					<div class="lead">${blogger.content} ...<a href="article/${blogger.blogNo}">Read More</a>
					</div>

					<footer>
						<span class="label label-default">alphabets</span> <span
							class="label label-default">code</span>
					</footer>

				
				</article>
				</c:forEach>
				<hr>
				
			
			
						<form:form method="post" action="${pageContext.request.contextPath}/posts" commandName="blogs">
						<h3>Add New Post :</h3>
						
						<p>
						<label class="sr-only">Username</label>
						<%-- <form:errors path="${user.userid}" cssStyle="color: #ff0000" /> --%>
						<%-- <form:hidden path="user" value="${user}" id="user"  /> --%>
						</p>
						
						<p>
						<label class="sr-only">Title</label>
						<form:errors path="title" cssStyle="color: #ff0000" />
						<form:input type="text" class="form-control" name="title" path="title" placeholder="Title " id="title"  />
						</p>
						
						<p>
						<label class="sr-only">Blog Post</label> 
						<form:errors path="content" cssStyle="color:#ff0000" />
						<form:textarea class="form-control" name="content" path="content" placeholder="Blog Post" id="content"/>
						<!-- required autocomplete="false" ></textarea> -->
						</p>
						
						<p>
						<form:button type="submit" class="btn btn-block btn-primary" >POST</form:button>
						</p>
						</form:form>

				</div>
			</div>
		</div>


	<%@ include file="/WEB-INF/views/template/footer.jsp"%>
	
	
	
	<!-- <article>
					<header>
						<h2>Alphabets</h2>
					</header>
					<footer>
						<small>Posted on 1 Jan 2016 </small>
					</footer>
					<div class="lead">
						A to Z alphabets I know very well.<a href="article">Read More</a>
					</div>

					<footer>
						<span class="label label-default">alphabets</span> <span
							class="label label-default">code</span>
					</footer>
				</article> -->