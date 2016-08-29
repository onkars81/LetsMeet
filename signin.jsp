<%@ include file="/WEB-INF/views/template/header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Let's Meet</title>
<link href="<c:url value='/resources/css/bootstrap.min.css'/>"
	rel="stylesheet">

<link href="<c:url value='/resources/css/login.css'/>" rel="stylesheet">
</head>
<body>
	<%@ include file="/WEB-INF/views/template/nav.jsp"%>

	<div class="container">
	
	
		<c:url value="/perform_login" var="varlogin" />
	  	<form action="${varlogin}" method="post"  class="form-signin">
	
	
				<c:if test="${not empty logout}">
			        <div class="msg"  style="color: #0000ff;" >${logout}</div>
			    </c:if>
							
	  			<c:if test="${not empty error}">
                    <div class="error" style="color: #0000ff;">${error}</div>
                </c:if>
                <c:if test="${not empty deactive}">
                    <div class="deactive" style="color: #0000ff;">${error}</div>
                </c:if>
                

			<h1 class="text-center">Sign In</h1>

			<p>
			<label  class="sr-only">Username</label>
			 <input type="text" name="username" placeholder="Username" class="form-control" /><br>
			</p>
			<p>
			<label type="password" class="sr-only">Password</label>
				 <input type="password" name="password" placeholder="Password" class="form-control" /><br>
			</p>
			 <p class="checkbox">
				<label><input type="checkbox" />Remember me</label>
			</p>
			<button type="submit" class="btn btn-block btn-primary">Sign
				In</button>
				
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		
		</form>
	</div>
	<%@ include file="/WEB-INF/views/template/footer.jsp"%>