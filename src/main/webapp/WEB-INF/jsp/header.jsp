<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>	
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="institute.title"/></title>
<spring:url value="/static/css/style.css" var="coreCss" />
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/logo.png" type="image/png">
<link href="${coreCss}" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>
<style type="text/css">
        /*
Code snippet by maridlcrmn for Bootsnipp.com
Follow me on Twitter @maridlcrmn
*/

.navbar-brand { position: relative; z-index: 2; }

.navbar-nav.navbar-right .btn { position: relative; z-index: 2; padding: 4px 20px; margin: 10px auto; transition: transform 0.3s; }

.navbar .navbar-collapse { position: relative; overflow: hidden !important; }
.navbar .navbar-collapse .navbar-right > li:last-child { padding-left: 22px; }

.navbar .nav-collapse { position: absolute; z-index: 1; top: 0; left: 0; right: 0; bottom: 0; margin: 0; padding-right: 120px; padding-left: 80px; width: 100%; }
.navbar.navbar-default .nav-collapse { background-color: #f8f8f8; }
.navbar.navbar-inverse .nav-collapse { background-color: #222; }
.navbar .nav-collapse .navbar-form { border-width: 0; box-shadow: none; }
.nav-collapse>li { float: right; }

.btn.btn-circle { border-radius: 50px; }
.btn.btn-outline { background-color: transparent; }

.navbar-nav.navbar-right .btn:not(.collapsed) {
    background-color: rgb(111, 84, 153);
    border-color: rgb(111, 84, 153);
    color: rgb(255, 255, 255);
}

.navbar.navbar-default .nav-collapse,
.navbar.navbar-inverse .nav-collapse {
    height: auto !important;
    transition: transform 0.3s;
    transform: translate(0px,-50px);
}
.navbar.navbar-default .nav-collapse.in,
.navbar.navbar-inverse .nav-collapse.in {
    transform: translate(0px,0px);
}
</style> 
</head>
<spring:url value="/bootsample" var="urlHome" />
<spring:url value="/new-task" var="urlNewTask" />
<spring:url value="/all-tasks" var="urlAllTask" />
<spring:url value="/studentList" var="urlStudentList" />
<spring:url value="/login" var="urlLogin" />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="loginUser" value="${pageContext.request.remoteUser}"/>
<c:set var="username" value="${fn:toUpperCase(loginUser)}" />
<div role="navigation">
	<div class="navbar navbar-inverse navbar-fixed-top">
		<a href="${pageContext.request.contextPath}/admin/registration" class="navbar-brand"><c:out value="${username }"></c:out></a>
		<div class="navbar-collapse collapse">
			<div style="padding-top:8px;">
			      <div class="container" style="width:100%;">
			        <!-- Collect the nav links, forms, and other content for toggling -->
			        <div class="collapse navbar-collapse" id="navbar-collapse-3">
			          <ul class="nav navbar-nav navbar-right">
			            <li>
			              <a class="btn btn-default btn-outline btn-circle collapsed"  data-toggle="collapse" href="#nav-collapse3" aria-expanded="false">Search</a>
			            </li>
			            <li>
			            	<form action="${pageContext.request.contextPath}/logout" method="post">
								<input type="submit" class="btn btn-primary pull-right" value="Sign Out" id=signout /> 
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							</form>
						</li>
			          </ul>
			          <div class="collapse slide-down" id="nav-collapse3">
			            <form class="navbar-form navbar-right" role="search" method="post" action="${pageContext.request.contextPath}/admin/searchCandidate">
			                <div class="form-group">
				                <input type="text" class="form-control" name ="name" placeholder="Name" />
				  	           </div>
				             <div class="form-group">
				                <input type="text" class="form-control" name="email" placeholder="E-mail" />
				              </div>
				              <div class="form-group">
				                 <input type="text" class="form-control" name="mobileNumber" placeholder="Mobile Number" />
				              </div>
				              <div class="form-group">
				                 <input type="date" class="form-control" name="date" placeholder="Test Date" class="datepicker" disabled/>
				              </div>
			              <button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
			              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			            </form>
			          </div>
			        </div>
			      </div>
			</div>
		</div>
	</div>
</div>
	<%-- <div id="top-header" class="tb-main-header js-banner-height-offset" style="margin-top: 0px;background: #333;">
	<div class="form-group pull-left">
	<a href="#" class="navbar-brand"><c:out value="${pageContext.request.remoteUser}"></c:out></a>
	</div>
 	<div class="panel-body" >
        <div class="form-group pull-right">
			<div class="navbar-collapse collapse">
				<div style="padding-top:8px;">
				<form action="/logout" method="post">
					<input type="submit" class="button red big pull-right" value="Sign Out" id=signout /> 
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
				</div>
			</div>
		</div>
    </div>
</div> --%>
<script>
function myFunction() {
    var x = document.getElementById("state").value;
    document.getElementById("demo").innerHTML = "You selected: " + x;
}
</script>
