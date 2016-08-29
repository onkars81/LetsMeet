<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Let's Meet</title>
<link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet">
<link href="<c:url value='/resources/css/default.css'/>" rel="stylesheet">
<link href="<c:url value='/resources/css/login.css'/>" rel="stylesheet">

</head>
<body>
<%@ include file="/WEB-INF/views/template/nav.jsp" %>

    <div class="container">
        <div class="page-header">
            <h1>Sign Up:</h1>

            <p class="lead">Please fill in your information below:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/register"
                   method="post" commandName="user" enctype="multipart/form-data">
	
        <div class="form-group"><p>
            <label class="sr-only" for="name">Name</label>
            <form:errors path="name" cssStyle="color: #ff0000" />
            <form:input path="name" placeholder=" Your Name" id="name" class="form-Control" />
            </p>
        </div>

        <div class="form-group">
            <label class="sr-only" for="email">Email</label>
            <span style="color: #ff0000">${emailMsg}</span>
            <form:errors path="email" cssStyle="color: #ff0000" />
            <form:input path="email" id="email" placeholder=" Your E-mail" class="form-Control" />
        </div>

        <div class="form-group">
            <label class="sr-only"  for="username">Username</label>
            <span style="color: #ff0000">${usernameMsg}</span>
            <form:errors path="username" cssStyle="color: #ff0000" />
            <form:input path="username" id="username" placeholder=" Your User Name" class="form-Control" />
        </div>

        <div  class="form-group">
            <label class="sr-only" for="password">Password</label>
            <form:errors path="password" cssStyle="color: #ff0000" />
            <form:password path="password" id="password" placeholder=" Password" class="form-Control" />
        </div>
        
        <div class="form-group">
                <label class="control-label" for="image">Take a Snap</label>
                <form:input id="image" path="image" name="image" type="file" class="form:input-large" />
            </div>
        
          <br/><br/>

        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/" />" class="btn btn-default">Cancel</a>
        
</form:form>

		</div>
	

<%@ include file="/WEB-INF/views/template/footer.jsp" %>