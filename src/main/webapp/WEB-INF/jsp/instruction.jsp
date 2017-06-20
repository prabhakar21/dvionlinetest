<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/instruction.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/notification.css">
	<link rel="icon" href="${pageContext.request.contextPath}/images/logo.png" type="image/gif">
	  
</head>
<body>
<c:set var="loginUser" value="${pageContext.request.remoteUser}"/>
<c:set var="username" value="${fn:toUpperCase(loginUser)}" />
<div id="top-header" class="tb-main-header js-banner-height-offset" style="margin-top: 0px;background: #333;">
	<div class="form-group pull-left" style="">
		<a href="javascript:void(0)" class="navbar-brand" style="text-decoration: none;"><h3 style="margin-top: 10px;"><c:out value="${username }"></c:out></h3></a>
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

<div style="padding-top:60px;">
  <div class="inr">
    <div class="inr">
      <div id="headar">
        <div class="logo"><a href="#"><img src="<spring:message code="institute.onlinetest.image.path"/>" alt="image" width="240" height="120"></a>
        </div>
    </div>
  </div>
  </div><a href="${pageContext.request.contextPath}/user/changePassword" style="text-decoration: none;">Change Password</a>
<div id="inr">
  <div id="">
    <div class="">
      <div class="">
        <div>
          <div>
      <div class="ads">
            <table >
               <tbody><tr>
                 <td colspan="2" width="50%"><p><span class="style2">General Instructions:</span> 
                  Please read  the below instructions carefully while appearing for the online test at <spring:message code="institute.website"/> website.</p>
                   <ol>
	                   <ul>
	                     <li>Total number of questions 20. Total of 30 minutes duration will be  given to attempt all 20 questions.</li>
	                     <li>The clock has been set at the server and countdown timer displayed  at the top of the question numer pattern will update you on remaining time to  complete the exam. When the clock reached to 0 the exam will automatically  close and it will display the report page where you can find all the correct  and wrong question along with total marks.</li>
	                     <li>The question number box at the right side of the screen represents one  of the below status. Initially it is in black color when starting of the exam.  Red color indicates not attempted or skipped questions; Black color indicates  not visited questions. Green color indicates attempted questions.</li>
	                     <li>All twenty (20) questions are multiple choices. You can navigate to  any question by clicking the question number at the right side. It will  navigate to respective question. By clicking next option you can see upcoming  question. If you want to see answer for any question instance click on view  answer at the same way click solution for explanation.</li>
	                     <li>The weight age for each question is 1(one) mark. Penalty for wrong  answer is 0.25. No negative marks for skipped questions or un attempted  questions. To complete the test click on END TEST button. Do not refresh the  page while writing the exam. For any assist please contact admin by dropping a  mail which is available at contact us page. All the best. Keep visiting our  website for new updates. Thanks.</li>
	                   </ul>                   
                   </ol>
               	 </td>
               </tr>
                <form method="get" action="${pageContext.request.contextPath}/user/testSetForUser">
                  <tr>
                      <td align="center">
                         <input id="chkPassport" type="checkbox" name="agree"/><span >Agree</span>
                      </td>
                  </tr> 
                  <tr>
                    <td class="" width="50%" align="center">
                      <input value="Start Test.." id="txtPassportNumber" class="btn btn-primary" type="submit" disabled="disabled" >
                      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                      </td>
                  </tr>
                </form>
            </tbody></table>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</div>
</div>
<jsp:include page ="../jsp/footer.jsp"/>

<script type="text/javascript">
    $(function () {
        $("#chkPassport").click(function () {
            if ($(this).is(":checked")) {
                $("#txtPassportNumber").removeAttr("disabled");
            } else {
                $("#txtPassportNumber").attr("disabled", "disabled");
            }
        });
    });
</script>
<script>
$(document).ready(function(){
   $(function () {
        if ($("#chkPassport").is(":checked")) {
            $("#chkPassport").removeAttr("checked");
             $("#txtPassportNumber").attr("disabled", "disabled");
        }
    });
});
</script>

</body></html>