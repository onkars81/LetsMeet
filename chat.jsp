<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<spring:url value="/resources/js" var="js" />
<spring:url value="/resources/css" var="css" />    

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Let's Meet</title>
<link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet">
<link href="<c:url value='/resources/css/default.css'/>" rel="stylesheet">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700" rel="stylesheet" type="text/css" />
    <link href="${css}/style.css'/>" rel="stylesheet" type="text/css" />
</head>

<body ng-app="chatApp">
<%@ include file="/WEB-INF/views/template/nav.jsp" %>
<div class="container">
    <div ng-controller="ChatCtrl" class="container">
      <form ng-submit="addMessage()" name="messageForm">
        <input type="text" placeholder="Compose a new message..." ng-model="message" />
        <div class="info">
          <span class="count" ng-bind="max - message.length" ng-class="{danger: message.length > max}">140</span>
          <button ng-disabled="message.length > max || message.length === 0">Send</button>
        </div>
      </form>
      <hr />
      <p ng-repeat="message in messages | orderBy:'time':true" class="message">
        <time>{{message.time | date:'HH:mm'}}</time>
        <span ng-class="{self: message.self}">{{message.message}}</span>
      </p>
    </div>
 

</div>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>



    <%-- <script src="${js}/libs/sockjs/sockjs.min.js" type="text/javascript"></script>
    <script src="${js}/libs/stomp-websocket/lib/stomp.min.js" type="text/javascript"></script>
    <script src="${js}/libs/angular/angular.min.js" type="text/javascript"></script>
    <script src="${js}/libs/lodash/dist/lodash.min.js" type="text/javascript"></script>
    <script src="${js}/app/app.js" type="text/javascript"></script>
    <script src="${js}/app/controllers.js" type="text/javascript"></script>
    <script src="${js}/app/services.js" type="text/javascript"></script> --%>
 