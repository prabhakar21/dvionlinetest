<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/css/app.css"rel="stylesheet"
	type="text/css"></link>
<title>Spring Security Example - ProgrammingFree</title>
</head>
<body class="security-app">
	<div class="details">
		<h2>Page not found</h2>
	</div>
	<div class="lc-block" style="margin-top:5%;">		
		<div class="alert-danger">
			<h3>You do not have permission to access this page!</h3>	
		</div>
		<form action="${pageContext.request.contextPath}/logout" method="post">
			<input type="submit" class="button red big" value="Sign in as different user" /> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>		
	</div>	
</body>
</html>
