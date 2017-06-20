<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Update Notification</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/practice1.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/practice2.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/practice3.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/practice.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.5.2.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery/validation-engine/jquery.validationEngine-en.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery/validation-engine/jquery.validationEngine.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/instruction.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/notification.css">
<link rel="icon" href="${pageContext.request.contextPath}/images/logo.png" type="image/gif">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/validationEngine.jquery.css">
</head>
<body>
<c:set var="loginUser" value="${pageContext.request.remoteUser}"/>
<c:set var="username" value="${fn:toUpperCase(loginUser)}" />
<div id="top-header" class="tb-main-header js-banner-height-offset" style="margin-top: 0px;background: #333;">
	<div class="form-group pull-left" style="">
		<h3 style="margin-top: 0px;"><a href="javascript:void(0)" class="navbar-brand" style="text-decoration: none;"><c:out value="${username }"></c:out></a></h3>
		<!-- <a href="/admin/registration"><img alt="" src="/images/logo.png" height="42" width="42"></a> -->
	</div>
	<div class="">
		<div style="padding-top:8px;">
		<form action="${pageContext.request.contextPath}/logout" method="post">
			<input type="submit" class="btn btn-primary pull-right" value="Sign Out" id=signout /> 
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
		</div>
	</div>
</div>       
<div align="center" style="padding-top:80px;">
	<form action="${pageContext.request.contextPath}/admin/update/notification" method="post" class="form-horizontal" id="formID" accept-charset="ISO-8859-1">
	<div class="form-group">
	  <label class="col-md-4 control-label" for="password">Update Notification:</label>
	  <div class="col-md-6">
	    <input id="message" name="message" type="text" placeholder="Please Enter Update Notification" class="form-control input-md validate[required]">
	  </div>
	</div>
		<input type="submit" class="btn btn-danger" value="Submit"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</div>
<div class="container" align="center" style="padding-top:10px;">
	<c:choose>
		<c:when test="${mode == 'MODE_NOTIFICATION'}">
			<div class="table-responsive">
						<table class="table table-striped table-bordered text-left table-hover">
							<thead>
								<tr class="info" id="tableHeading">
									<th>S.No</th>
									<th>Update Notification Message</th>
									<th>Delete</th>
								</tr>
							</thead>
							<tbody align="center">
								<c:forEach var="notification" items="${updateNotification}" varStatus="status">
									<tr>
										<td>${status.count}</td>
										<td>${notification.message}</td>
										<td><a href="${pageContext.request.contextPath}/admin/deleteNotification?id=${notification.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
		</c:when>
	</c:choose>
</div>
 <jsp:include page ="../jsp/footer.jsp"/>
</body>
<script type="text/javascript">
$(document).ready(function() {
	 $("#formID").validationEngine();
});
</script>
</html>