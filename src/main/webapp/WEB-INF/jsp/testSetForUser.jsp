<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Online Test</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/practice1.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/practice2.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/practice3.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/practice.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.5.2.js"></script> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.min.js"></script>
	<link rel="icon" href="${pageContext.request.contextPath}/images/logo.png" type="image/gif">
	  
<style type="text/css">

.cop1 {
    width: 250px;
    height: auto;
    margin-left: 220px;
    float: left;

}
.mrq{
width:100%;
float:left;
color:#f30;font-size:small;
}
.wd60{
width:60%; float:left;margin:7px 0 0 0 !important;
}
.style2 {
  color: #FF0000;
  font-weight: bold;
}
.ads{
margin: 80 auto;
}
#tableHeading th{
text-align: center;
}
</style>
</head>
<body>
<c:set var="loginUser" value="${pageContext.request.remoteUser}"/>
<c:set var="username" value="${fn:toUpperCase(loginUser)}" />
<div id="top-header" class="tb-main-header js-banner-height-offset" style="margin-top: 0px;background: #333;">
	<div class="form-group pull-left" style="">
		<a href="javascript:void(0)" class="navbar-brand" style="text-decoration: none;"><h3 style="margin-top: 10px;"><c:out value="${username}"></c:out></h3></a>
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

<div id="wrp" style="padding-top:60px;width:100%;height:auto;margin:0;" align="center">
	<div id="inr" style="width:1000px;height:auto;margin:0 auto;">
		<div>
		    <div class="inr-content">
		    	<div class="inr-cnt-lft inr-lft">
		    	<c:if test="${message != NULL}">
					<div class="alert alert-info">
	    				<strong>Alert !</strong> ${message}<span style="color:red;">${candidateRegistration.fullname}</span>
	  				</div>
  				</c:if>
		      		<div class="ads">
		        		<table class="table table-striped table-bordered text-left table-hover">
							<thead>
								<tr class="info" id="tableHeading">
									<th>S.No</th>
									<th>Question Set</th>
									<th>Number of Question</th>
									<th>Time in Minuts</th>
									<th>Start Test</th>
								</tr>
							</thead>
							<tbody align="center">
								<c:forEach var="testSet" items="${testSetList}" varStatus="status">
									<tr>
										<td>${status.count}</td>
										<td>${testSet.questionSet}</td>
										<td>${testSet.noOfQuestion}</td>
										<td>${testSet.timeInMin}</td>
										<td><a href ="${pageContext.request.contextPath}/user/testStart/${testSet.id}/${testSet.timeInMin}" style="text-decoration: none;">Start</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
		      		</div>
		    	</div>
		  	</div>
		</div>
	</div>
</div>
<jsp:include page ="../jsp/footer.jsp"/>

</body>
</html>