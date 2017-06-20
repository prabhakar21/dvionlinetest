<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<html>
<head>
    <title>Arithmetic Operations</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/practice1.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/practice2.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/practice3.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/practice.css">
</head>
<body>
    <div id="top-header" class="tb-main-header js-banner-height-offset" style="margin-top: 0px;">
    <div class="row">
        <div id="js-header-main" class="col-xs-12 tb-main-header-inner">
            <a href="${pageContext.request.contextPath}/" class="logo">
                <img class="full" src="${pageContext.request.contextPath}/images/logo2.png">
                <img class="icon-logo" src="//storage.googleapis.com/testbook/static/assets/assets/img/brand/logo-without-text.png">
                <img class="white" src="//storage.googleapis.com/testbook/static/assets/assets/img/brand/logo-light.png">
            </a>
           	<div class="pull-right">
                <ul class="header-nav list-unstyled mar-b0">
                   <li>
                      <a href="#" title="" target=""> Practice </a>
                        <span class="label label-danger pad-b2 align-middle">New</span>
                    </li>
                   <li>
                    <a href="#" title="Testbook's blog" target="_blank"> Blog </a>
                    </li>
                    <li>
				       	 <div class="dropdown ">
				            <button class="course-btn dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"><span>Apps</span><i class="tb-icon tb-arrow-down-thin"></i>
				            </button>
				            <ul class="dropdown-menu tb-courses-list " aria-labelledby="">
				                <li class="d-arrow"></li>
				                <li class="tb-courses-list-inner">
					            	<ul class="list-unstyled"><li>
					                   <a href="#" target="_blank">Testbook App</a>
					                    </li><li>
					                        <a href="#" target="_blank">Current Affairs App</a>
					                    </li>
					            	 </ul>
				        		</li>
				    		</ul>
				    	</div>                    
				    </li>
                    <li>
                     <a href="#" title="Testbook's Offers" target=""> Offers </a>
                    </li>
                    <li>
                       <a href="#" title="" target=""> eCard/Promo </a>
                    </li>
                 	<li>
                 	<div style="padding-top:5px;">
	                    <form action="${pageContext.request.contextPath}/logout" method="post">
							<input type="submit" class="button red big pull-right" value="Sign Out" id="signout" /> 
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						</form>
						</div>
                   </li>
                    <li style="padding-top:11px;padding-right:50px;" class="button red big pull-right">
						<span id="cd_h">00</span>:
					    <span id="cd_m">00</span>:
					    <span id="cd_s">00</span>
					  </li>
                 </ul>
                <div class="dropdown mobile-view-nav">
                    <button class="dropdown-toggle" type="button" id="mobileViewHeaderNav" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                        <span></span>
                    </button>
                    <div class="dd-backdrop"></div>
                    <ul class="dropdown-menu dropdown-menu-right js-banner-height-offset" id="js-header-options-sidebar" aria-labelledby="mobileViewHeaderNav" style="margin-top: 0px;">
	                    <li>
	                       <a href="#">Practice<span class="label label-danger pad-b2 align-middle">New</span>                                </a>
	                    </li>
	                    <li>
	                       <a href="#">Blog                                                                    </a>
	                    </li>
	                    <li>
					        <div class="dropdown ">
					            <button class="course-btn dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"><span>Apps</span><i class="tb-icon tb-arrow-down-thin"></i>
					            </button>
					            <ul class="dropdown-menu tb-courses-list " aria-labelledby="">
					                <li class="d-arrow"></li>
					                <li class="tb-courses-list-inner">
							            <ul class="list-unstyled"><li>
							                        <a href="#" target="_blank">Testbook App</a>
							                    </li><li>
							                        <a href="#" target="_blank">Current Affairs App</a>
							                    </li>
							            </ul>
							        </li>
					   			 </ul>
					   		</div>  
					   	</li>
                        <li><a href="#">Offers</a></li>
                        <li><a href="#">eCard/Promo</a></li>
                        <li><a href="#">Login</a></li>
                        <li><a href="#">Sign Up</a></li>
                      </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<div style="margin-top: 0px;" class="content-wrapper js-tb-container">
    <div class="practice-container">
        <div class="clearfix practice-container-inner">
     		<div class="container-fluid practice-attempt-view">
       		 <div  class="row">
		         <div class="col-xs-12 mar-v24 ng-scope">
		                <div class="panel panel-default question-content">
		                    <div class="panel-body">
		                        <div class="row">
		                            <div class="col-xs-12">
		                                <p class="mar-v4 font-weight-semibold d-inline-block question-details ">
		                                    2 of 2 &nbsp;|&nbsp; <span class="text-capitalize ">consumer or customer</span>
		                                </p>
		                            </div>
		                            <div class="col-xs-12 mar-t24">
		                                <div class="overflow-x-auto " ><p>The basis for consumer market segmentation includes</p>
										</div>
		                            </div>
		                        </div>
		                    </div>
		                </div>
		                <div class="panel panel-default question-options ">
                   			 <div class="panel-body" >
                            	<span class="p-label p-size-2 font-weight-semibold"><input type="radio" name="answer1"></span>
                       				 <div class="option-content "><p>Age of consumer</p>
										</div>
                   			 </div>
               			 </div>
		                <div class="panel panel-default question-options" >
		                    <div class="panel-body">
		                            <span class="p-label p-size-2 font-weight-semibold"><input type="radio" name="answer1"></span>
		                        <div class="option-content " ><p>Location of consumer</p>
								</div>
		                    </div>
		                </div>
		                <div class="panel panel-default question-options " >
		                    <div class="panel-body" >
		                            <span class="p-label p-size-2 font-weight-semibold"><input type="radio" name="answer1"></span>
		                        <div class="option-content " ><p>Income of consumer</p>
								</div>
		                    </div>
		                </div>
		                <div class="panel panel-default question-options " >
		                    <div class="panel-body" >
		                            <span class="p-label p-size-2 font-weight-semibold"><input type="radio" name="answer1"></span>
		                        <div class="option-content " ><p>Sex of consumer</p>
								</div>
		                    </div>
		                </div>
		                <div class="panel panel-default question-options " ><!-- "attempted" -->
		                    <div class="panel-body">
		                            <span class="p-label p-size-2 font-weight-semibold"><input type="radio" name="answer1"></span>
		                        <div class="option-content " ><p>All of the above</p>
								</div>
		                    </div>
		                </div>
		            </div><!-- end ngIf: !hideQueUI && !isShowLoadingTemplate -->
        	</div>
         <div class="clearfix practice-question-nav js-banner-height-offset" style="margin-top: 0px;">
            <ul class="list-unstyled mar-b0 pad-v12 pad-h32 question-list js-question-list">
                <!-- ngRepeat: x in queNoArr | filter : {isShowOnFilter : true} track by $index --><li style="-webkit-transform: translateX(0px);-moz-transform: translateX(0px);transform: translateX(0px);"  class="ng-scope">
                    <div class="p-label p-size-3  p-skipped" ><!-- p-correct p-bookmarked p-wrong p-skipped-->
                        1
                        <i class="tb-icon tb-bookmark"></i>
                    </div>
                </li><!-- end ngRepeat: x in queNoArr | filter : {isShowOnFilter : true} track by $index --><li style="-webkit-transform: translateX(0px);-moz-transform: translateX(0px);transform: translateX(0px);" class="ng-scope">
                    <div class="p-label p-size-3  p-skipped" ><!-- p-correct p-bookmarked p-wrong p-skipped-->
                        2
                        <i class="tb-icon tb-bookmark"></i>
                    </div>
                </li><div class="current-arrow " style="-webkit-transform: translateX(98px);-moz-transform: translateX(98px);transform: translateX(98px);">
                </div><!-- end ngIf: !hideQueUI -->
          </ul>
        </div>
        <div class="clearfix practice-controls-bar attempt-controls" >
            <!-- ngIf: !hideQueUI --><div class="col-xs-6 ng-scope" >
                <button type="button" class="btn btn-lg btn-block"><!-- "js-loading" -->
                    <i class="tb-icon tb-arrow-left pull-left"></i>
                    <i class="tb-icon tb-spinner spin-me pull-left"></i>
                    <span class="text-capitalize">Previous</span>
                </button>
            </div><!-- end ngIf: !hideQueUI -->
            <div class="col-xs-6 ng-scope">
                <button type="button" class="btn btn-lg btn-block " id="jst-next-btn" >
                   <span  class="text-capitalize ">Next</span>
                    <i class="tb-icon tb-arrow-right pull-right"></i>
                    <i class="tb-icon tb-spinner spin-me pull-right"></i>
                </button>
            </div>
        </div>
    </div>
</div>
</div>
</div>
</body>
<script type="text/javascript">
function myFunction() {
	$("#signout").click();
} 
</script>
</html>