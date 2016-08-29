<%@ include file="/WEB-INF/views/template/header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile page</title>
<link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet">
<link href="<c:url value='/resources/css/default.css'/>" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/views/template/nav.jsp" %>

<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-12 col-xs-12 profile">
				<aside>
					<div class="clearfix">
						<c:url value="/resources/images/profileimg/${user.userid}.jpg" var="profileimg"/>
						<img src="${profileimg}" alt="profile image" class="img-circle" />
						<div class="profile-content">
							<h4>${user.name}</h4>
							<p>${user.email}</p>
							<a href="https://twitter.com/${user.username}"
								class="twitter-follow-button" data-show-count="true"
								data-lang="en"> Follow @ ${user.username} </a>
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
				</div>
			</div>

</div>


<%@ include file="/WEB-INF/views/template/footer.jsp" %>