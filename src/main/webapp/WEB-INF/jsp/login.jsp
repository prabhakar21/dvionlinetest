<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/css/app.css" />" rel="stylesheet" type="text/css">
<title><spring:message code="institute.title"/></title>
<spring:url value="/static/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/static/css/style.css" var="coreCss" />
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/logo.png" type="image/png">
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/instruction.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
</head>
<style type="text/css">
.social li {
    display: block;
    -webkit-transition: -webkit-transform .7s;
    -moz-transition: -moz-transform .7s;
    -ms-transition: -ms-transform .7s;
    -o-transition: -o-transform .7s;
    transition: transform .7s;
    -webkit-transform: rotate(45deg);
    -moz-transform: rotate(45deg);
    -ms-transform: rotate(45deg);
    -o-transform: rotate(45deg);
    transform: rotate(45deg);
    text-align: center;
    width: 4em;

}

.social a {
    color: #fffdf0;
    display: block;
    -webkit-transform: rotate(-45deg);
    -moz-transform: rotate(-45deg);
    -ms-transform: rotate(-45deg);
    -o-transform: rotate(-45deg);
    transform: rotate(-45deg);
    width: 4em; 
  
}

.social li:hover {
  -webkit-transform: scale(1.3,1.3) rotate(45deg);
    -moz-transform: scale(1.3,1.3) rotate(45deg);
  -ms-transform: scale(1.3,1.3) rotate(45deg);
    -o-transform: scale(1.3,1.3) rotate(45deg);
  transform: scale(1.3,1.3) rotate(45deg);
}

.facebook {
    background: #155b9d;
    left: 0;
    top: 0%;
}

.twitter {
    background: #1a9ec4;
    bottom: 0;
    left: 25%;
}
.facebook2 {
    background: #155b9d;
    left: 50%;
    top: 0%;
}

.twitter2 {
    background: #1a9ec4;
    bottom: 0;
    left: 25%;
}

.pinterest {
    background: #e11a30;
    left: 50%;
    top: 0%;
}
.behance {
    background: #3f7aa3;
    bottom: 0;
    left: 75%;
}
.behance2 {
    background: #3f7aa3;
    top: 0%;
    left: 50%;
}
.behance3 {
    background: #3f7aa3;
    bottom: 0;
    left: 75%;
}

    </style>
<body style="background-color:#d9d9db;">
<div>
	<div style=" position: absolute; visibility: visible;margin-top:480px;margin-left:340px;text-align:center;font-size: 12px;">
		<div id="copyright">Copyright &copy; 2017 
			<spring:message code="institute.name"/>. All Rights Reserved.&nbsp;
				<a title="Privacy Policy" href="https://colorlib.com/wp/privacy-policy/" target="_blank" style="text-decoration: none;">Privacy Policy</a>&nbsp;| <a title="Terms and Conditions" href="https://colorlib.com/wp/terms-conditions/" target="_blank" style="text-decoration: none;">www.polyvalent.com</a>
		</div>
	</div> 
 	<div role="navigation">
		<div class="navbar navbar-inverse navbar-fixed-top">
		   <span style="margin-left:10px;"><img src="${pageContext.request.contextPath}/images/logo.png" width="150" height="120"></span>
			<span style="margin-left:260px;"><img src="<spring:message code="institute.name.image"/>"  width="500" height="50"></span>
			<span style=" position: absolute; visibility: visible;margin-top:15px;font-size: 15px;">
				<img src="${pageContext.request.contextPath}/images/contact.png" style="margin-left:100px" width="30px" height="30px" align="middle">
				<font color="#40aaf3">+91-8954789589</font>
			</span>
			<span style=" position: absolute; visibility: visible;margin-top:40px;font-size: 15px;">
				<img src="${pageContext.request.contextPath}/images/mail.png" style="margin-left:100px" width="30px" height="30px" align="middle">
				<font color="#40aaf3"><spring:message code="institute.mail.id"/></font>
			</span>
		</div>
	</div>
	<div style="margin-top:130px;"><marquee behavior="alternate"><font color="red">${updateNotification.message}</font></marquee></div>
	<div class="pull-right" style="padding-right:20px;margin-top:7%;">
         <ul class="social">
          <li class="facebook"  style=" width:2em; height:2em;"><a href="http://facebook.com/alterowo" ><i class="" ><img src="${pageContext.request.contextPath}/images/facebooklinkicon.png" alt="image" title="" style="margin-bottom:100px;margin-left:40px" width="30px" height="30px" align="middle"></i></a></li>
          <li class="twitter" style="width:2em; height:2em;"><a href="http://twitter.com/Kyokushinowa"><i class=""><img src="${pageContext.request.contextPath}/images/twitterlinkicon.png" alt="image" title="" style="margin-bottom:140px;margin-left:52px" width="50px" height="50px" align="middle"></i></a></li>
          <li class="facebook" style="width:2em; height:2em;"><a href="http://www.pinterest.com/beatagibalska/"><i class=""><img src="${pageContext.request.contextPath}/images/linkedlinkicon.png" alt="image" title="" style="margin-bottom:120px;margin-left:48px" width="35px" height="35px" align="middle"></i></a></li>
          <li class="pinterest" style="width:2em; height:2em;"><a href="https://www.behance.net/Kurnikowa"><i class=""><img src="${pageContext.request.contextPath}/images/gplus.png" alt="image" title="" style="margin-bottom:70px;margin-left:32px" width="23px" height="23px" align="middle"></i></a></li>
        </ul>
  	</div>
	<div style="text-align:center;">
	<%-- <div style="margin-top:100;margin-right:22%;"><img src="${pageContext.request.contextPath}/images/pleaseLogin.png"  width="100" height="30"></div> --%>
		<form action="${pageContext.request.contextPath}/login" method="post">
			<div class="lc-block">
				<div>
					<input type="text" class="style-4" name="email" placeholder="Username" required/>
				</div>
				<div>
					<input type="password" class="style-4" name="password" placeholder="Password" required />
				</div>
				<a href ="${pageContext.request.contextPath}/forgetPassword" class=""style="padding-left:190px;text-decoration: none;">Forget Password</a>
				<div>
					<input type="submit" value="Sign In" class="button red small" />
				</div>
				<c:if test="${param.error ne null}">
					<div class="alert-danger">Invalid username and password.</div>
				</c:if>
				<c:if test="${param.logout ne null}">
					<div class="alert-normal">You have been logged out.</div>
				</c:if>
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>
<%--  <div id="footer-bottom" class="clr"data-position="fixed"  style="text-align:center;margin-top:100px;">
	<div id="footer-bottom-inner" class="container clr"  >
		<div id="copyright" class="clr" role="contentinfo">Copyright &copy; 2017 
			<spring:message code="institute.name"/>. All Rights Reserved.&nbsp;
				<a title="Privacy Policy" href="https://colorlib.com/wp/privacy-policy/" target="_blank" style="text-decoration: none;">Privacy Policy</a>&nbsp;| <a title="Terms and Conditions" href="https://colorlib.com/wp/terms-conditions/" target="_blank" style="text-decoration: none;">www.polyvalent.com</a></div><!-- #copyright -->
	</div><!-- #footer-bottom-inner -->
</div>  --%>
</div>
</body>
</html>
