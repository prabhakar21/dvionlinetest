<!DOCTYPE HTML>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>	
<html><head>
<meta charset="UTF-8">
<title>DVI Online Test</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="Freeonline test">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/testPaper/style.css">
<script src="${pageContext.request.contextPath}/testPaper/jquery-1.8.1.min.js" type="text/javascript"></script>
   <script src="${pageContext.request.contextPath}/testPaper/script.js" type="text/javascript"></script>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/testPaper/nav-rs.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/testPaper/responsive.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/practice1.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/practice2.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/practice3.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/practice.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/instruction.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css">
	<link rel="icon" href="${pageContext.request.contextPath}/images/logo.png" type="image/gif">
<style type="text/css">
.cop1 {
  width: 250px;
  height: auto;
  margin-left: 220px;
  float: left;

}
/* Social - footer
========================== */

ul.social-networks {
  overflow: hidden;
  margin: 0px 0 0 0px;
  padding: 0 0 0 0px;
  float:right;

}
ul.social-networks li {
  float: left;
  margin: 20px 1px 0;
  list-style: none;
  border: none;
}

.icon-twitter a, .icon-facebook a, .icon-pinterest a, .icon-linkedin a, .icon-flickr a, .icon-dribbble a {
  float: left;
  background: url(http://www.freeonlinetest.in/images/social-sprite.png) no-repeat left bottom;
  text-indent: 8000px;
  width: 40px;
  height: 30px;
  -webkit-transition: all 0.3s ease-in-out;
  -moz-transition: all 0.3s ease-in-out;
  -o-transition: all 0.3s ease-in-out;
  transition: all 0.3s ease-in-out;
}
.icon-twitter a:hover, .icon-facebook a:hover, .icon-pinterest a:hover, .icon-linkedin a:hover, .icon-flickr a:hover, .icon-dribbble a:hover {
  background: url(images/social-sprite.png) no-repeat left top;
  -webkit-transition: all 0.3s ease-in-out;
  -moz-transition: all 0.3s ease-in-out;
  -o-transition: all 0.3s ease-in-out;
  transition: all 0.3s ease-in-out;
}

.icon-facebook, .icon-facebook a {
  background-position: -120px top;
}
.icon-facebook a:hover {
  background-position: -120px bottom;
}
.icon-twitter, .icon-twitter a {
  background-position: -80px top;
}
.icon-twitter a:hover {
  background-position: -80px bottom;
}
.icon-dribbble, .icon-dribbble a {
  background-position: -40px top;
}
.icon-dribbble a:hover {
  background-position: -40px bottom;
}
.icon-linkedin, .icon-linkedin a {
  background-position: 0px top;
}
.icon-linkedin a:hover {
  background-position: 0px bottom;
}
.mrq{
width:100%;
float:left;
color:#f30;font-size:small;
}
.wd60{
width:78% !important; float:left;margin:7px 0 0 0 !important;
}
.common_data, .img-s,/* .pagination */{
  float: left;
  width: 100%;
}
.q_dv  {
  width: 100%;
  float: left;
}
.ans_dv{
  width: 72%;
  float: left;
}
.q_pagin {
  background-color: #000000;
}
.q_skipped {
  background-color: #FF0000;
}
.q_attempt {
  background-color: #006600;
}
.wd60{
width:100%;
float: left;

}
</style>
</head>
<body>
<c:set var="loginUser" value="${pageContext.request.remoteUser}"/>
<c:set var="username" value="${fn:toUpperCase(loginUser)}" />
<div id="top-header" class="tb-main-header js-banner-height-offset" style="margin-top: 0px;background: #333;">
	<div class="form-group pull-left" style="margin-top:-10px;">
		<a href="${pageContext.request.contextPath}/admin/registration" class="navbar-brand"><h3><c:out value="${username}"></c:out></h3></a>
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
<div id="wrp">
  <div class="inr">
    <div class="inr">
      <div id="headar" style="padding-top: 60px;">
        <div class="logo"><a href="#"><img src="${pageContext.request.contextPath}/images/logo2.png" alt="image" width="120" height="60"></a></div>
   			<div class="wd60"></div>
    	</div>
  	  </div>
    </div>
  </div>
<div style="margin-left:210px;">
	<div class="marks">
		<h4 align="center"><span>Report</span> </h4>&nbsp;
			<h1 align="center"style="width:100%;"><span style="color:#fff !important;"></span> </h1>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
						</tr>
						<tr>
					  		<td width="78%">Total number of correct Answers</td>
					  		<td width="7%">:</td>
					  		<td width="15%"><span class="correctAnswerCount"><c:out value="${finalObject.correctAnswerCount }"></c:out></span></td>
						</tr>
					  	<tr>
					  		<td>Number of answered questions</td>
					  		<td>: </td>
					  		<td><span class="answeredCount"><c:out value="${finalObject.answeredCount }"></c:out></span></td>
						</tr>
				   		<tr>
					  		<td>Number of unattempted questions</td>
					  		<td>:</td>
					  		<td><span class="unAnsweredCount"><c:out value="${finalObject.unAnsweredCount }"></c:out></span></td>
						</tr>
						<tr>
							<td width="70%">Total Marks</td>
					  		<td width="5%">:</td>
					  		<td width="25%"><span class="totalMarks"><c:out value="${finalObject.totalMarks }"></c:out></span>
						 	</td>
						</tr>
				  	</tbody>
				  </table>
				</div>
				<div id="circle_main">  
				 <h1 id="trtr">Total Marks </h1> 
					<div id="circle">
						<table width="100%" border="0">
						  	<tbody>
						  		<tr>
									<td height="40" class="totalMarks"><c:out value="${finalObject.totalMarks }"></c:out></td>
						  		</tr>
						   		<tr>
									<td style="border-top:solid 1px #999;" class="totalCount"><c:out value="${finalObject.totalCount }"></c:out></td>
						  		</tr>
							</tbody>
						</table>
					</div>
				</div>
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
<script type="text/javascript">
(function (global) {
	if(typeof (global) === "undefined")
	{
		throw new Error("window is undefined");
	}
    var _hash = "!";
    var noBackPlease = function () {
        global.location.href += "#";

		// making sure we have the fruit available for juice....
		// 50 milliseconds for just once do not cost much (^__^)
        global.setTimeout(function () {
            global.location.href += "!";
        }, 50);
    };
	
	// Earlier we had setInerval here....
    global.onhashchange = function () {
        if (global.location.hash !== _hash) {
            global.location.hash = _hash;
        }
    };

    global.onload = function () {
        
		noBackPlease();

		// disables backspace on page except on input fields and textarea..
		document.body.onkeydown = function (e) {
            var elm = e.target.nodeName.toLowerCase();
            if (e.which === 8 && (elm !== 'input' && elm  !== 'textarea')) {
                e.preventDefault();
            }
            // stopping event bubbling up the DOM tree..
            e.stopPropagation();
        };
		
    };

})(window);
</script>
    <script type="text/javascript">
    var paperNo="jh";
    var qTimerNo =1;
    var questionTimer;
      function loading_show(){
      $('#loading').html("<img src='http://www.freeonlinetest.in/images/loading.gif'/>").fadeIn('fast');
        }
        function loading_hide()
    {
            $('#loading').fadeOut('fast');
        }          
  
  $('#container .pagination li.q_pagin').live({click : function(){
    
            var page = parseInt($(this).attr('qno'));
      //alert(page);
            var qq = parseInt($('.question_dv:visible').attr('qno'));
      sam(qq,page); 
            
        }});           
      
</script>
    <script type="text/javascript">
$('[id^="next"]').live({
  click:function(){
    var qno =parseInt($(this).attr('qno'));
    $('#question_inc').html(qno+1);
    sam(qno,qno+1);
    }
  });
  $('[id^="prev"]').live({
  click:function(){
    
    var qno =parseInt($(this).attr('qno'));
    
    $('#question_inc').html(qno-1);
    $('#container .pagination li.q_pagin').eq(qno-1).addClass('q_skipped');
    sam(qno,qno-1);
    }
  });
  $('[id^="answec"]').live({
  click:function(){
    
    var qno =parseInt($(this).attr('qno'));
    $('#question_inc').html(qno);
    sam(qno,false);
    }
  });
  questionTimer = setInterval(function(){
    var tme = parseInt($('#time'+qTimerNo).val())+1;
    $('#time'+qTimerNo).val(tme)
    },998)
  function sam(qno,qnext)
  {
    var aid = 0;
    if($("input:radio[name=answec"+qno+"]:checked").length>0)
    aid = $("input:radio[name=answec"+qno+"]:checked").val();
    var qid = $('#quesoid'+qno).val();
    var caid = $('#cansid'+qno).val();
    var tme = $('#time'+qno).val();
    var llen = $('.question_dv').length;
    
    //alert(aid);
    if(aid!=0)
    {
     $('#container .pagination li.q_pagin').eq(qno-1).addClass('q_attempt');
    }
    
    
  
    if(qnext!==false)
    {
      $('.total i').html(qnext);
    qTimerNo = qnext;

    if(qnext>qno)
    {
      sam(qno,false);
        $('#container .pagination li.q_pagin').eq(qno-1).addClass('q_skipped');
        
        $('#question_inc').html(qno+1);

    }
    if(qnext<qno)
    {
        sam(qno,false);
        $('#container .pagination li.q_pagin').eq(qno-1).addClass('q_skipped');
        //alert(k);
        $('#question_inc').html(qno-1);
      
    }
  
  //alert('ss');
    $('.question_dv').eq(qno-1).fadeOut(100,function(){
      $('#question_inc').html(qnext);
      $('.question_dv').eq(qnext-1).fadeIn()
    }); 
  }
  }
</script>
 <script type="text/javascript">
    $(function () {
      $(document).bind('contextmenu',function(e){
        e.preventDefault();
       
      });
    });
  </script>
</body>
</html>