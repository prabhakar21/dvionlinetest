<!DOCTYPE html> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Question</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/practice1.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/practice2.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/practice3.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/practice.css">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/logo.png" type="image/png">
<script src="${pageContext.request.contextPath}/jquery/jquery-1.5.2.js"></script> 
</head>
<body>
<c:set var="loginUser" value="${pageContext.request.remoteUser}"/>
<c:set var="username" value="${fn:toUpperCase(loginUser)}" />
<div id="top-header" class="tb-main-header js-banner-height-offset" style="margin-top: 0px;background: #333;">
	<div class="form-group pull-left" style="margin-top: 6px;">
		<span class="navbar-brand" style="text-decoration: none;">
			<font color="#40aaf3">
	 			<a href="${pageContext.request.contextPath}/admin/registration" class="logo" style="text-decoration: none;">
	 				<c:out value="${username }"></c:out>
	 			</a>
	 		</font>
		 </span>
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
<div class="content-wrapper js-tb-container">
    <div class="practice-container">
        <div class="clearfix practice-container-inner">
     		<div class="container-fluid practice-attempt-view">
     			<c:forEach var="question" items="${questionList}" varStatus="status">
       		 	<div  class="row">
		         	<div class="col-xs-12 mar-v24 ng-scope">
		  				<c:choose>
		 					<c:when test="${question.questionType eq 'i'}">
			 					<div class="panel panel-default question-content">
			                    	<div class="panel-body">
			                        	<div class="row">
			                            	<div class="col-xs-12">
			                                	<p class="mar-v4 font-weight-semibold d-inline-block question-details ">
			                                    	${status.count} of <c:out value="${noOfSize}"></c:out> &nbsp;|&nbsp; <span class="text-capitalize ">${testSet.questionSet}</span>
			                                	</p>
			                                	<span class="pull-right">
			                                		<a href="${pageContext.request.contextPath}/admin/editQuestion/${question.id}">Edit</a>
			                                	</span>
			                            	</div>
			                            	<div class="col-xs-12 mar-t24">
			                                	<div class="overflow-x-auto " ><p><img src="${pageContext.request.contextPath}${question.question}" style="margin-left:20px;"></p>
												</div>
			                            	</div>
			                        	</div>
			                    	</div>
			                	</div>
		 					</c:when>
			 				<c:otherwise>
				 				<div class="panel panel-default question-content">
				                    <div class="panel-body">
				                        <div class="row">
				                            <div class="col-xs-12">
				                                <p class="mar-v4 font-weight-semibold d-inline-block question-details ">
				                                    ${status.count} of <c:out value="${noOfSize}"></c:out> &nbsp;|&nbsp; <span class="text-capitalize ">${testSet.questionSet}</span>
				                                </p>
				                                <span class="pull-right">
			                                		<a href="${pageContext.request.contextPath}/admin/editQuestion/${question.id}">Edit</a>
			                                	</span>
				                            </div>
				                            <div class="col-xs-12 mar-t24">
				                                <div class="overflow-x-auto " ><p>${question.question}</p></div>
				                            </div>
				                        </div>
				                    </div>
				                </div>
			 				</c:otherwise>
			 			</c:choose>
		        		<c:choose>
				           <c:when test="${question.correctAnswer != question.answer1}">
					            <c:choose>
						 			<c:when test="${question.answer1Type eq 'i'}">
						 				<div class="panel panel-default question-options ">
				                   			 <div class="panel-body" >
				                            	<span class="p-label p-size-2 font-weight-semibold"><input type="radio" name="answer1"></span>
				                       				<div class="option-content "><p><img src="${pageContext.request.contextPath}${question.answer1}" style="margin-left:20px;"></p>
													</div>
				                   			 </div>
				               			 </div>
						 			</c:when>
						 			<c:otherwise>
						 				<div class="panel panel-default question-options ">
				                   			 <div class="panel-body" >
				                            	<span class="p-label p-size-2 font-weight-semibold"><input type="radio" name="answer1"></span>
				                       				<div class="option-content "><p>${question.answer1}</p>
													</div>
				                   			 </div>
				               			 </div>
						 			</c:otherwise>
					 			</c:choose>
		               		</c:when>
	               			 <c:otherwise>
		               			 <c:choose>
						 			<c:when test="${question.answer1Type eq 'i'}">
						 				 <div class="panel panel-default question-options ">
				                   			 <div class="panel-body" >
				                            	<span class="p-label p-size-2 font-weight-semibold"><input type="radio" name="answer1"></span>
				                       				 <div class="option-content "><p><img src="${pageContext.request.contextPath}${question.answer1}" style="margin-left:20px;"></p>
												</div>
				                   			 </div>
				               			 </div>
						 			</c:when>
						 			<c:otherwise>
						 				 <div class="panel panel-default question-options ">
				                   			 <div class="panel-body" >
				                            	<span class="p-label p-size-2 font-weight-semibold"><input type="radio" name="answer1"></span>
				                       				 <div class="option-content "><p><font color="#07c130">${question.answer1}</font></p>
													</div>
				                   			 </div>
				               			 </div>
						 			</c:otherwise>
					 			</c:choose>
	               			 </c:otherwise>
               			</c:choose>
               			  <c:choose>
			                <c:when test="${question.correctAnswer != question.answer2}">
				                 <c:choose>
						 			<c:when test="${question.answer2Type eq 'i'}">
						 				<div class="panel panel-default question-options" >
						                    <div class="panel-body">
						                            <span class="p-label p-size-2 font-weight-semibold"><input type="radio" name="answer2"></span>
						                        <div class="option-content " ><p><img src="${pageContext.request.contextPath}${question.answer2}" style="margin-left:20px;"></p>
												</div>
						                    </div>
					               		 </div>
						 			</c:when>
						 			<c:otherwise>
						 				<div class="panel panel-default question-options" >
						                    <div class="panel-body">
						                            <span class="p-label p-size-2 font-weight-semibold"><input type="radio" name="answer2"></span>
						                        <div class="option-content " ><p>${question.answer2}</p>
												</div>
						                    </div>
					               		 </div>
						 			</c:otherwise>
				 				</c:choose>
	               			 </c:when>
	               			 <c:otherwise>
	               			 	<c:choose>
						 			<c:when test="${question.answer2Type eq 'i'}">
						 				<div class="panel panel-default question-options" >
				                   			 <div class="panel-body">
				                            	<span class="p-label p-size-2 font-weight-semibold"><input type="radio" name="answer2"></span>
				                        			<div class="option-content " ><p><img src="${pageContext.request.contextPath}${question.answer2}" style="margin-left:20px;"></p>
												</div>
				                    		</div>
				               			 </div>
						 			</c:when>
						 			<c:otherwise>
						 				<div class="panel panel-default question-options" >
				                    		<div class="panel-body">
				                            	<span class="p-label p-size-2 font-weight-semibold"><input type="radio" name="answer2"></span>
				                        			<div class="option-content " ><p><font color="#07c130">${question.answer2}</font></p>
												</div>
				                    		</div>
				                		</div>
						 			</c:otherwise>
				 				</c:choose>
	               			 </c:otherwise>
               			 </c:choose>
               			 <c:choose>
			                <c:when test="${question.correctAnswer != question.answer3}">
				                <c:choose>
							 		<c:when test="${question.answer3Type eq 'i'}">
							 			<div class="panel panel-default question-options " >
				                  			<div class="panel-body" >
				                            	<span class="p-label p-size-2 font-weight-semibold"><input type="radio" name="answer3"></span>
				                        			<div class="option-content " ><p><img src="${pageContext.request.contextPath}${question.answer3}" style="margin-left:20px;"></p>
												</div>
				                    		</div>
				                		</div>
							 		</c:when>
							 		<c:otherwise>
							 			<div class="panel panel-default question-options " >
				                    		<div class="panel-body" >
				                            	<span class="p-label p-size-2 font-weight-semibold"><input type="radio" name="answer3"></span>
				                        			<div class="option-content " ><p>${question.answer3}</p>
												</div>
				                    		</div>
				                		</div>
						 			</c:otherwise>
				 				</c:choose>
	               			 </c:when>
	               			 <c:otherwise>
		               			 <c:choose>
								 	<c:when test="${question.answer3Type eq 'i'}">
								 		<div class="panel panel-default question-options " >
				                    		<div class="panel-body" >
				                            	<span class="p-label p-size-2 font-weight-semibold"><input type="radio" name="answer3"></span>
				                        			<div class="option-content " ><p><img src="${pageContext.request.contextPath}${question.answer3}" style="margin-left:20px;"></p>
												</div>
				                    		</div>
				                		</div>
								 	</c:when>
								 	<c:otherwise>
								 		<div class="panel panel-default question-options " >
				                    		<div class="panel-body" >
				                            	<span class="p-label p-size-2 font-weight-semibold"><input type="radio" name="answer3"></span>
				                        			<div class="option-content " ><p><font color="#07c130"><b>${question.answer3}</b></font></p>
												</div>
				                    		</div>
				                		</div>
							 		</c:otherwise>
					 			</c:choose>
	               			 </c:otherwise>
               			 </c:choose>
               			 <c:choose>
			                <c:when test="${question.correctAnswer != question.answer4}">
			                	<c:choose>
							 		<c:when test="${question.answer4Type eq 'i'}">
							 			<div class="panel panel-default question-options " >
						                    <div class="panel-body" >
						                            <span class="p-label p-size-2 font-weight-semibold"><input type="radio" name="answer4"></span>
						                        <div class="option-content " ><p><img src="${pageContext.request.contextPath}${question.answer4}" style="margin-left:20px;"></p>
												</div>
						                    </div>
						                </div>
							 		</c:when>
							 		<c:otherwise>
							 			<div class="panel panel-default question-options " >
						                    <div class="panel-body" >
						                            <span class="p-label p-size-2 font-weight-semibold"><input type="radio" name="answer4"></span>
						                        <div class="option-content " ><p>${question.answer4}</p>
												</div>
						                    </div>
						                </div>
						 			</c:otherwise>
				 				</c:choose>
	               			 </c:when>
	               			 <c:otherwise>
	               			 <c:choose>
							 		<c:when test="${question.answer4Type eq 'i'}">
							 			<div class="panel panel-default question-options " >
		                    				<div class="panel-body" >
			                            		<span class="p-label p-size-2 font-weight-semibold"><input type="radio" name="answer4"></span>
				                        			<div class="option-content " ><p><img src="${pageContext.request.contextPath}${question.answer4}" style="margin-left:20px;"></p>
												</div>
			                    			</div>
		                				</div>
							 		</c:when>
							 		<c:otherwise>
							 			<div class="panel panel-default question-options " >
		                    				<div class="panel-body" >
			                            		<span class="p-label p-size-2 font-weight-semibold"><input type="radio" name="answer4"></span>
				                        			<div class="option-content " ><p><font color="#07c130">${question.answer4}</font></p>
												</div>
			                    			</div>
		                				</div>
						 			</c:otherwise>
				 				</c:choose>
	               			 </c:otherwise>
               			 </c:choose>
		            </div>
        		</div>
        </c:forEach>
    </div>
</div>
</div>
</div>
<jsp:include page ="../jsp/footer.jsp"/>
</body>
</html>