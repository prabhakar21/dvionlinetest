<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/css/app.css" />" rel="stylesheet" type="text/css">
<title><spring:message code="institute.title"/></title>
<spring:url value="/static/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/static/css/style.css" var="coreCss" />
<script src="${pageContext.request.contextPath}/jquery/jquery-1.10.2.js"></script>
<script src="${pageContext.request.contextPath}/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/jquery/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/jquery/jquery-ui.js"></script>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/logo.png" type="image/png">
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/instruction.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/forgetPassword.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css">
</head>
<body style="background-color:#d9d9db;">
<div>
 	<div role="navigation">
		<div class="navbar navbar-inverse navbar-fixed-top">
		   <span style="margin-left:10px;"><img src="${pageContext.request.contextPath}/images/logo.png" width="140" height="120"></span>
			<span style="margin-left:260px;"><img src="<spring:message code="institute.name.image"/>"  width="500" height="50"></span>
			<span style=" position: absolute; visibility: visible;margin-top:15px;font-size: 15px;">
				<img src="${pageContext.request.contextPath}/images/contact.png" style="margin-left:100px" width="30px" height="30px" align="middle">
				<font color="#40aaf3">+91-8954789589</font>
			</span>
			<span style=" position: absolute; visibility: visible;margin-top:40px;font-size: 15px;">
				<img src="${pageContext.request.contextPath}/images/mail.png" style="margin-left:100px" width="30px" height="30px" align="middle">
				<font color="#40aaf3"><spring:message code="institute.mail.id"/></font>
			</span>
			<span style=" position: absolute; visibility: visible;margin-top:20px;margin-left:300px;font-size: 15px;">
				<a href="${pageContext.request.contextPath}/login"><input type="submit" class="btn btn-primary" value="Login" id="emailId"></a>
			</span>
		</div>
	</div>
	<div style="margin-top:130px;"></div>
	<div class="pull-right" style="padding-right:20px;margin-top:7%;">
         <ul class="social">
          <li class="facebook"  style=" width:2em; height:2em;"><a href="http://facebook.com/alterowo" ><i class="" ><img src="${pageContext.request.contextPath}/images/facebooklinkicon.png" alt="image" title="" style="margin-bottom:100px;margin-left:40px" width="30px" height="30px" align="middle"></i></a></li>
          <li class="twitter" style="width:2em; height:2em;"><a href="http://twitter.com/Kyokushinowa"><i class=""><img src="${pageContext.request.contextPath}/images/twitterlinkicon.png" alt="image" title="" style="margin-bottom:140px;margin-left:52px" width="50px" height="50px" align="middle"></i></a></li>
          <li class="facebook" style="width:2em; height:2em;"><a href="http://www.pinterest.com/beatagibalska/"><i class=""><img src="${pageContext.request.contextPath}/images/linkedlinkicon.png" alt="image" title="" style="margin-bottom:120px;margin-left:48px" width="35px" height="35px" align="middle"></i></a></li>
          <li class="pinterest" style="width:2em; height:2em;"><a href="https://www.behance.net/Kurnikowa"><i class=""><img src="${pageContext.request.contextPath}/images/gplus.png" alt="image" title="" style="margin-bottom:70px;margin-left:32px" width="23px" height="23px" align="middle"></i></a></li>
        </ul>
  	</div>
<div style="text-align:center;">
	<c:choose>
		<c:when test="${mode == 'MODE_VALIDEMAIL'}">
			<form  method="post" action="${pageContext.request.contextPath}/checkEmail" id="checkEmail">
			<div class="lc-block">
					<c:if test="${message ne NULL }">
						 <div class="alert alert-success">
						    <strong><c:out value="${message}"></c:out></strong>
						  </div>
					</c:if>
		        <div class="form-group">
		        	<input type="text" class="form-control" name ="email" placeholder="Enter Email" style="padding: 0;padding-left:10px;" required/>
		      	</div>
			      <input type="submit" class="btn btn-danger" value="Submit" id ="emailId"/>
			      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			      </div>
			</form>
		</c:when>
		<c:when test="${mode =='MODE_NEWPASSWORD'}">
			<form  method="post" action="${pageContext.request.contextPath}/changePassword" id="changePassword">
				<div class="lc-block">
					<c:choose>
						<c:when test="${message ne NULL }">
							 <div class="alert alert-success">
							    <strong><c:out value="${message}"></c:out></strong>
							  </div>
						</c:when>
						<c:otherwise>
							<div class="form-group">
							<input type="text" class="form-control" name ="email" value="${user.email}" style="padding: 0;padding-left:10px;" required/>
				      		</div>
						</c:otherwise>
					</c:choose>
			        <div class="form-group">
			        	<input type="password" class="form-control" name ="newPassword" placeholder="New Password" style="padding: 0;padding-left:10px;" required/>
			      	</div>
			      	<div class="form-group">
			        	<input type="password" class="form-control" name ="confirmPassword" placeholder="Confirm Password" style="padding: 0;padding-left:10px;" required/>
			      	</div>
				      <input type="submit" class="btn btn-danger" value="Submit" id ="emailId"/>
				      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			      </div>
			</form>
		</c:when>
	</c:choose>
</div>
<footer>
    <div class="footer" id="footer" style="margin-top:100px;">
        <div class="container">
            <div class="row">
                <div class="col-lg-2  col-md-2 col-sm-4 col-xs-6">
                    <h3> About us </h3>
                    <ul>
                        <li> <a href="#"> How it works </a> </li>
                        <li> <a href="#"> Terms & Canditions </a> </li>
                        <li> <a href="${pageContext.request.contextPath}/sendingEmail"> Send </a> </li>
                        <li> <a href="#"> Organization </a> </li>
                    </ul>
                </div>
                <div class="col-lg-2  col-md-2 col-sm-4 col-xs-6">
                    <h3> Address </h3>
                    <ul>
                        <li> billionloans, #370, 4th cross, J P  </li>
                        <li> Nagar 3rd phase,Bangalore-560078  </li>
                        <li> (Landmark-Close to Vijaya Bank). </li>
                    </ul>
                </div>
                <div class="col-lg-2  col-md-2 col-sm-4 col-xs-6">
                    <h3> Cantact us </h3>
                    <ul>
                        <li> <spring:message code="institute.contactNumber"/> </li>
                        <li> <spring:message code="institute.mail.id"/> </li>
                    </ul>
                </div>
                <div class="col-lg-2  col-md-2 col-sm-4 col-xs-6">
                    <h3> Our Services </h3>
                    <ul>
                        <li> Test Packages </li>
                        <li> Test Validity </li>
                    </ul>
                </div>
                <div class="col-lg-3  col-md-3 col-sm-6 col-xs-12 ">
                    <h3> Leave a Message </h3>
                    <ul>
                        <li>
                              <div class="input-append newsletter-box text-center">
                           		 <form action="${pageContext.request.contextPath}/contactUs" method="post" accept-charset="ISO-8859-1">
                                	<input type="text" class="form-control" placeholder="Enter Name" name="name" style="padding: 0;padding-left:10px;" required>
                                	<input type="email" class="form-control" placeholder="abc@gmail.com" name="email" required>
                                	<textarea class="form-control" placeholder="Comment (Optional)" rows="5" id="textareaChars" name="comment" maxlength="160"></textarea>
                                	<span id="chars">160</span> characters remaining
                                	<input type="submit" value="Send" class="btn  bg-gray" />
                                	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                </form>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    
    <div class="footer-bottom">
        <div class="container">
            <p class="pull-left"> Copyright © 2017. All right reserved. <span>Web Design By: <a href="javascript:void(0)"><spring:message code="company.website.name"/></a></span></p>
        </div>
    </div>
</footer>
</div>
</body>
<script type="text/javascript">
$(document).ready(function() {
	var maxLength = 160;
	$('textarea').keyup(function() {
	  var length = $(this).val().length;
	  var length = maxLength-length;
	  $('#chars').text(length);
	});
});
</script>
</html>
