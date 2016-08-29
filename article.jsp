<%@ include file="/WEB-INF/views/template/header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Let's Meet</title>
<link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet">
<link href="<c:url value='/resources/css/default.css'/>" rel="stylesheet">
<link href="<c:url value='/resources/css/article.css'/>" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/views/template/nav.jsp"%>
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
				<article>
					<header>
						<h2>${blog.title}</h2>
					</header>
					<footer>
						<small>Posted on :${blog.bdate}</small>
					</footer>
					<div class="lead">
						<!-- A to Z alphabets I know very well.The whole Paragraph from data base -->
						${blog.content}
					</div>
				</article>

				
				<div id="comments">
				<h3>Comments</h3>
				 <c:if test="${user.userid == user_comment.users.userid}">	
				<c:forEach items="${commentList}" var="commentobj">
					<div class="row">
						<div class="col-md-11">
						
							<p>${commentobj.usercomment}</p>
						
						<footer>
							<small><b>${ commentobj.fullname} </b>Commented on :${commentobj.comment_date} </small>
						</footer>
						<hr>		
						</div> 			
						<div class="col-md-1 comment-num">
						${commentobj.commentid}
						</div>
						<aside>
						<ul class="clearfix">
						<img src="<c:url value='/resources/images/profileimg/${commentobj.users.userid}.jpg'/>"	alt="profile image" class="img-circle" width="5%"/>
						</ul>
						</aside>
					</div>
					
					</c:forEach>
				</c:if>
				
			
			 <c:forEach items="${users_comment}" var="user_comment">
					<div class="row">
						<div class="col-md-11">
						
							<p>${user_comment.usercomment}</p>
						
						<footer>
							<small><b>${ user_comment.fullname} </b>Commented on :${user_comment.comment_date} </small>
						</footer>
						<hr>		
						</div> 			
						<div class="col-md-1 comment-num">
						${user_comment.commentid}
						</div>
						<aside>
						<ul class="clearfix">
						<img src="<c:url value='/resources/images/profileimg/${user_comment.users.userid}.jpg'/>"	alt="profile image" class="img-circle" width="5%"/>
						</ul>
						</aside>
					</div>
					
			</c:forEach>
				
					 		
				<form:form method="post" action="${pageContext.request.contextPath}/comment/${blog.blogNo}" commandName="comments">
						<h3>Have your say !</h3>
						<p>
						<label class="sr-only">Message</label> 
						<form:errors path="usercomment" cssStyle="color:#ff0000" />
						<form:textarea class="form-control" name="usercomment" path="usercomment" placeholder="Message" id="usercomment"/>
						<!-- required autocomplete="false" ></textarea> -->
						</p>
						<p>
						<label class="sr-only">Full Name:</label>
						<form:errors path="fullname" cssStyle="color: #ff0000" />
						<form:input type="text" class="form-control" name="fullname" path="fullname" placeholder="Full Name" id="fullname"  />
						</p>
						<p>
						<label class="sr-only">Email</label>
						<form:errors path="email" cssStyle="color: #ff0000" />
						<form:input type="text" class="form-control" name="email" path="email" placeholder="Email" id="email"   />
						</p>
						
						<p>
						<form:button type="submit" class="btn btn-block btn-primary" >Add Message</form:button>
						</p>
						</form:form>
					</div>
				</div>
			</div>
		</div>

	<%@ include file="/WEB-INF/views/template/footer.jsp"%>