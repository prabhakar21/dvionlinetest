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
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/logo.png" type="image/png">
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/instruction.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
</head>
<body style="background-color:#d9d9db;">
<div>
	<div style=" position: absolute; visibility: visible;margin-top:480px;margin-left:340px;text-align:center;font-size: 12px;">
		<div id="copyright">Copyright &copy; 2017 
			<spring:message code="institute.name"/>. All Rights Reserved.&nbsp;
				<a title="Privacy Policy" href="javascript:void(0)" target="_blank" style="text-decoration: none;">Privacy Policy</a>&nbsp;| <a title="Terms and Conditions" href="javascript:void(0)" target="_blank" style="text-decoration: none;">www.polyvalent.com</a>
		</div>
	</div> 
 	<div role="navigation">
		<div class="navbar navbar-inverse navbar-fixed-top">
		   <span style="margin-left:10px;"><img src="${pageContext.request.contextPath}/images/logo.png" width="100" height="120"></span>
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
	<div style="margin-top:130px;"><marquee behavior="alternate"><font color="red">Website Under Maintenance</font></marquee></div>
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
				<a href ="${pageContext.request.contextPath}/forgetPassword" class=""style="padding-left:150px;text-decoration: none;">Forget Password</a>
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
	</div><footer>
    <div class="footer" id="footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-2  col-md-2 col-sm-4 col-xs-6">
                    <h3> About us </h3>
                    <ul>
                        <li> <a href="#"> How it works </a> </li>
                        <li> <a href="#"> Terms & Canditions </a> </li>
                        <li> <a href="#"> Instructions </a> </li>
                        <li> <a href="#"> Company </a> </li>
                    </ul>
                </div>
                <div class="col-lg-2  col-md-2 col-sm-4 col-xs-6">
                    <h3> Contact us </h3>
                    <ul>
                        <li> billionloans, #370, 4th cross, J P  </li>
                        <li> Nagar 3rd phase,Bangalore-560078  </li>
                        <li> (Landmark-Close to Vijaya Bank). </li>
                    </ul>
                </div>
                <div class="col-lg-2  col-md-2 col-sm-4 col-xs-6">
                    <h3> Call us </h3>
                    <ul>
                        <li> <spring:message code="institute.contactNumber"/> </li>
                    </ul>
                </div>
                <div class="col-lg-2  col-md-2 col-sm-4 col-xs-6">
                    <h3> Email-Id </h3>
                    <ul>
                        <li> <spring:message code="institute.mail.id"/> </li>
                    </ul>
                </div>
                <div class="col-lg-3  col-md-3 col-sm-6 col-xs-12 ">
                    <h3> Contact Us </h3>
                    <ul>
                        <li>
                            <div class="input-append newsletter-box text-center">
                           		 <form method="post" action="${pageContext.request.contextPath}/user/contactUs">
                                	<input type="text" class="form-control text-center" placeholder="Enter Name " name="name">
                                	<input type="text" class="form-control text-center" placeholder="Enter Email" name="email">
                                	<textarea class="form-control"  name="comment" placeholder="Enter Comment"> </textarea>
                                	<button class="btn  bg-gray" type="button"> Contact Us  </button>
                                	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                </form>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <!--/.row--> 
        </div>
        <!--/.container--> 
    </div>
    <!--/.footer-->
    
    <div class="footer-bottom">
        <div class="container">
            <p class="pull-left"> Copyright © 2017. All right reserved. </p>
        </div>
    </div>
    <!--/.footer-bottom--> 
</footer>
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