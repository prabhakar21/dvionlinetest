<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta content="abc123blahblahauthenticitytoken" name="csrf-token">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Da Vinci Institute Bokaro</title>
	<meta http-equiv="Pragma" content="no-cache"> 
	<meta http-equiv="Cache-Control" content="no-cache"> 
	<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
	<script src="${pageContext.request.contextPath}/jquery/jquery-1.10.2.js"></script>
	<script src="${pageContext.request.contextPath}/jquery/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/jquery/jquery-1.11.3.min.js"></script>
	<script src="${pageContext.request.contextPath}/jquery/jquery-ui.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery/validation-engine/jquery.validationEngine-en.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery/validation-engine/jquery.validationEngine.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-theme.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/validationEngine.jquery.css">
</head> 
<jsp:include page ="../jsp/header.jsp"/>
<style>
.switch {
  position: relative;
  display: inline-block;
  width: 60px;
  height: 24px;
}

.switch input {display:none;}

.slider {
  position: absolute;
  cursor: pointer;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: #ef4d3b;
  -webkit-transition: .4s;
  transition: .4s;
}

.slider:before {
  position: absolute;
  content: "";
  height: 16px;
  width: 26px;
  left: 4px;
  bottom: 4px;
  background-color: white;
  -webkit-transition: .4s;
  transition: .4s;
}

input:checked + .slider {
  background-color: #6cc63f;
}

input:focus + .slider {
  box-shadow: 0 0 1px #2196F3;
}

input:checked + .slider:before {
  -webkit-transform: translateX(26px);
  -ms-transform: translateX(26px);
  transform: translateX(26px);
}

/* Rounded sliders */
.slider.round {
  border-radius: 34px;
}

.slider.round:before {
  border-radius: 50%;
}
#tableHeading th{
text-align: center;
}
.se-pre-con {
	position: fixed;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 9999;
	background: url(images/loading.gif) center no-repeat #fff;
}
#footer .footerwrap #footer-menu #top-footer-links {
    text-align: left;
}
div{
    margin: 0;
    padding: 0;
    border: 0;
    font-size: 100%;
    font: inherit;
    vertical-align: baseline;
}
</style>
<body>
<div>
	<%-- <h4><a href="${pageContext.request.contextPath}/registration">Condidate Registration</a></h4>
	</div>	
	<div style="padding-left:200px;margin-top:-28px;">
	<h4><a href="${pageContext.request.contextPath}/registration">Student List</a></h4> --%>
	<ul class="nav nav-pills" style="margin-top:60px">
      <li role="presentation"><a href="${pageContext.request.contextPath}/admin/registration">CANDIDATE REGISTRATION</a></li>
      <li role="presentation"><a href="${pageContext.request.contextPath}/admin/candidateList">CANDIDATE LIST</a></li>
      <li role="presentation"><a href="javascript:void(0)" id="testSet">PAPER SET</a></li>
      <li role="presentation"><a href="${pageContext.request.contextPath}/admin/changePassword">CHANGE PASSWORD</a></li>
      <li role="presentation"><a href="javascript:void(0)" class="dropdown-toggle " data-toggle="dropdown" aria-expanded="false">PACKAGE DETAILS<span class="caret"></span></a>
      	<ul class="dropdown-menu" role="menu">
         	<li class="active" role="presentation"><a href="javascript:void(0)" id="activePackage">ACTIVE PACKAGE</a></li>
           <li role="presentation"><a href="javascript:void(0)" id="expirePackage">EXPIRED PACKAGE</a></li>
           <li role="presentation"><a href="javascript:void(0)" id="assignPackage">ASSIGN PACKAGE</a></li>
  	  	</ul>
	  </li>
      <li role="presentation"><a href="javascript:void(0)" class="dropdown-toggle " data-toggle="dropdown" aria-expanded="false">CANDIDATE RESULT<span class="caret"></span></a>
      	<ul class="dropdown-menu" role="menu">
         	<li class="active" role="presentation"><a href="javascript:void(0)" id="resultList">CANDIDATE ALL</a></li>
           <li role="presentation"><a href="javascript:void(0)" id="passResult">PASS CANDIDATE</a></li>
           <li role="presentation"><a href="javascript:void(0)" id="failResult">FAIL CANDIDATE</a></li>
  	  	</ul>
      </li>
      <li class="">
          <a href="javascript:void(0)" class="dropdown-toggle " data-toggle="dropdown" aria-expanded="false">OTHER <span class="caret"></span>
		  </a>
          <ul class="dropdown-menu" role="menu">
          	<li class="active" role="presentation"><a href="${pageContext.request.contextPath}/admin/questionPaper">QUESTION PAPER</a></li>
            <li role="presentation"><a href="${pageContext.request.contextPath}/admin/backupImages">BACKUP IMAGES</a></li>
            <li role="presentation"><a href="${pageContext.request.contextPath}/admin/notification">UPDATE NOTIFICATION</a></li>
            <li role="presentation"><a href="${pageContext.request.contextPath}/admin/contactUs">CONTACT US</a></li>
	  	  </ul>
	 </li>
      <li style="padding-top:5px;padding-right:50px;" class="button red big pull-right"></li>
    </ul>
</div>
<div style="display:none;">
    <input type="text" value="15" id="cd_seconds"/>
</div>
<hr>
<div id = "registration">
	<c:choose>
		<c:when test="${mode == 'MODE_REGISTRATION'}">
			<c:if test="${error != NULL}">
				<div class="container">
					 <div class="alert alert-danger">
					    <strong><c:out value="${error}"></c:out></strong>
					  </div>
				</div>
	  		</c:if>
	  		<c:if test="${message != NULL}">
				<div class="container">
					 <div class="alert alert-success">
					    <strong><c:out value="${message}"></c:out></strong>
					  </div>
				</div>
	  		</c:if>
			<div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h4 class="modal-title" id="myModalLabel">Registration Form<span class="pull-right"><font size="1">(<span style="color:red">*</span>) is mandatory fields</font></span></h4>
			      </div>
			      <div class="modal-body">
			        <form class="form-horizontal" method ="post" action="${pageContext.request.contextPath}/admin/candidateRegistration" id="formID">
						<input type="hidden" value="${candidateRegistration.id}" name="id"/>
						<!-- Text input-->
						<div class="form-group">
						  <label class="col-md-4 control-label" for="email">Username:<span style="color:red">*</span></label>  
						  <div class="col-md-6">
						  	<input id="username" name="username" type="text" placeholder="Enter your username" value="${candidateRegistration.username}" class="form-control input-md validate[required]">
						  </div>
						</div>
						
						<div class="form-group">
						  <label class="col-md-4 control-label" for="name">Name:<span style="color:red">*</span></label>  
						  <div class="col-md-6">
						  	<input id="name" name="fullname" type="text" placeholder="Enter your name" value="${candidateRegistration.fullname}" class="form-control input-md validate[required]">
						  </div>
						</div>
						
						<!-- Text input-->
						<div class="form-group">
						  <label class="col-md-4 control-label" for="email">Email:<span style="color:red">*</span></label>  
						  <div class="col-md-6">
						  	<input id="email" name="email" type="email" placeholder="Enter your email id" value="${candidateRegistration.email}" class="form-control input-md validate[required]" >
						  </div>
						</div>
						
						<!-- DOB input-->
						<div class="form-group">
						  <label class="col-md-4 control-label" for="dateOfBirth">Date of Birth:</label>  
						  <div class="col-md-6">
						  	<input name="dateOfBirth" type="date" placeholder="Date of Birth" value="${candidateRegistration.dateOfBirth}" class="form-control input-md datepicker" >
						  </div>
						</div>
						
						<!-- Password input-->
						<div class="form-group">
						  <label class="col-md-4 control-label" for="password">Password:<span style="color:red">*</span></label>
						  <div class="col-md-6">
						    <input id="password" name="password" type="password" placeholder="Enter your password" class="form-control input-md validate[required]" >
						  </div>
						</div>
						
						<!-- Text input-->
						<div class="form-group">
						  <label class="col-md-4 control-label" for="confirmPassword">Confirm Password:<span style="color:red">*</span></label>  
						  <div class="col-md-6">
						  	<input name="confirmPassword" type="password" placeholder="Enter your confirm password." class="form-control input-md validate[required,equals[password]]">
						  </div>
						</div>
						
						<!-- Text input-->
						<div class="form-group">
						  <label class="col-md-4 control-label" for="contactNumber">Contact Number:<span style="color:red">*</span></label>  
						  <div class="col-md-6">
						  	<input id="contactNumber" name="contactNumber" type="text" placeholder="Enter your Contact Number" value="${candidateRegistration.contactNumber}" class="form-control input-md validate[required]">
						  </div>
						</div>
						
						<div class="form-group">
						  <label class="col-md-4 control-label" for="sex">Gender:</label>  
						  <div class="col-md-6">
						  	Male&nbsp;<input id="male" name="gender" type="radio" value="m">&nbsp;&nbsp;&nbsp;
						    Female&nbsp;<input id="female" name="gender" type="radio" value="f">
						  </div>
						</div>
						
						<!-- Text input-->
						<div class="form-group">
						  <label class="col-md-4 control-label" for="institute">Institute:</label>  
						  <div class="col-md-6">
						  	<input id="collage" name="institute" type="text" placeholder="Enter your Institute Name" value="${candidateRegistration.institute}" class="form-control input-md" >
						  </div>
						</div>
						
						<div class="form-group">
						  <label class="col-md-4 control-label" for="email">Heighest Qualification:</label>  
						  <div class="col-md-6">
						  <c:choose>
						  	<c:when test="${candidateRegistration != null }">
						  		<select id="qual" name="qualification" class="form-control"  onchange="myFunction()">
						  		<option value="${candidateRegistration.qualification}" selected>${candidateRegistration.qualification}</option>
						  		<option value="BE">BE</option>
							      <option value="B.Tech">B.Tech</option>
							      <option value="BCA">BCA</option>
							      <option value="B.Sc">B.Sc</option>
							      <option value="MCA">MCA</option>
							      <option value="MBA">MBA</option>
							      <option value="M.Tech">M.Tech</option>
							      </select>
						  	</c:when>
						  	<c:otherwise>
						  		<select id="qual" name="qualification" class="form-control" onchange="myFunction()">
							      <option value="" selected>----------------Select----------------</option>
							      <option value="BE">BE</option>
							      <option value="B.Tech">B.Tech</option>
							      <option value="BCA">BCA</option>
							      <option value="B.Sc">B.Sc</option>
							      <option value="MCA">MCA</option>
							      <option value="MBA">MBA</option>
							      <option value="M.Tech">M.Tech</option>
						    </select>
						  	</c:otherwise>
						  	</c:choose>
						  </div>
						</div>
						
						<!-- Select Basic -->
						<div class="form-group">
						  <label class="col-md-4 control-label" for="state">State:</label>
						  <div class="col-md-6">
						    <select id="state" name="state" class="form-control" onchange="stateFunction(this.value)">
						      <option value="" selected>----------------Select----------------</option>
						      <option value="Utter Pradesh">Utter Pradesh</option>
						      <option value="Bihar">Bihar</option>
						      <option value="Madhay Pradesh">Madhya Pradesh</option>
						      <option value="Rajhasthan">Rajasthan</option>
						      <option value="Bengal">Bengal</option>
						      <option value="Jharkhand">Jharkhanad</option>
						      <option value="Chhattisgarh">Chhattisgarh</option>
						      <option value="Odisa">Odisa</option>
						      <option value="Karnataka">Karnataka</option>
						      <option value="Tamilnadu">Tamilnadu</option>
						      <option value="Delhi">Delhi</option>
						      <option value="Maharastra">Maharastra</option>
						    </select>
						  </div>
						</div>
						
						<!-- Select Basic -->
						<div class="form-group">
						  <label class="col-md-4 control-label" for="city">City:</label>
						  <div class="col-md-6">
						    <select id="city" name="city" class="form-control">
						      <option value="" selected>----------------Select----------------</option>
						    </select>
						  </div>
						</div>
						<div class="modal-footer">
							 <input type="submit" class="btn btn-primary" value="Register"/>
							 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						</div>
						<p id="demo"></p>
			      </form>
			    </div>
			  </div>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_CADIDATELIST'}">
		<div id ="candidateList">
			<div class="container" id="tasksDiv">
			<c:if test="${error != NULL}">
				<div class="container">
					 <div class="alert alert-danger">
					    <strong><c:out value="${error}"></c:out></strong>
					  </div>
				</div>
	  		</c:if>
			<c:if test="${message != NULL}">
				<div class="alert alert-info">
		    		<strong>${message}</strong> 
		  		</div>
	  		</c:if>
			<div class="table-responsive">
					<table class="table table-striped table-bordered text-left table-hover">
						<thead>
							<tr class="info" id="tableHeading">
								<th><input type="checkbox" onclick="toggle(this);" /></th>
								<th>S.No</th>
								<th>Name</th>
								<th>Contact Number</th>
								<th>Username</th>
								<th>Email-Id</th>
								<th><a href="${pageContext.request.contextPath}/admin/candidate/enable?enable=enable" id="enable">Enable</a>/<a href="${pageContext.request.contextPath}/admin/candidate/enable?enable=disable" id="disable">Disable</a></th>
								<th>Update</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody align="center">
							<c:forEach var="candidate" items="${candidateList}" varStatus="status">
								<tr>
								<td><input type="checkbox" id="chk" value="${status.count}" name="chk[]"></td>
								<%-- <input type="hidden" name="${candidate.id}" id = "candidateId${candidate.id}" />
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
									<td>${status.count}</td>
									<td><a href ="javascript:void(0)" id="${candidate.id}" onClick="openPackage(this.id)" style="text-decoration: none;">${candidate.fullname}</a></td>
									<td>${candidate.contactNumber}</td>
									<td>${candidate.username}</td>
									<td>${candidate.email}</td>
									<td>
									<c:choose>
											<c:when test="${candidate.isEnabled == true}">
												<label class="switch">
												  <input type="checkbox" checked="checked" id="check" name="${candidate.id}" onClick="divFunction(this.name)" />
												  <div class="slider"> </div>
												</label>
									  		</c:when>
											  <c:otherwise>
												  <label class="switch">
													  <input type="checkbox" id="check" name="${candidate.id}" onClick="divFunction(this.name)" />
													  <div class="slider"> </div>
												  </label>
											  </c:otherwise>
									  </c:choose>
									</td>
									<td><a href="${pageContext.request.contextPath}/admin/updateCandidate?id=${candidate.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="${pageContext.request.contextPath}/admin/deleteCandidate?id=${candidate.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</c:when>
	</c:choose>
</div>
<div id="testSetData">  
		
</div>
<div id="testResult">  
		
</div>
<div id="packageDetails"> 
 
</div>	
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                <h4 class="modal-title" id="myModalLabel">Test Package<span class="pull-right"><font size="1">(<span style="color:red">*</span>) is mandatory fields</font></span></h4>
              </div>
              <div class="modal-body">
                <form class="form-horizontal" method ="post" action="${pageContext.request.contextPath}/admin/assignPackage" id="formID" name="myForm">
                
                	<input type="hidden" name="candidateId" id="candidateId"/>
               
                	<!-- Text input-->
                	<div class="form-group">
		  			<label class="col-md-4 control-label" for="name">Candidate Name:<span style="color:red">*</span></label>  
					  <div class="col-md-6">
					  	<input id="name" name="name" type="text" class="form-control input-md " disabled="disabled" >
					  </div>
					</div>
		
					<!-- Text input-->
					<div class="form-group">
					  <label class="col-md-4 control-label" for="noOfTest">No of Test:<span style="color:red">*</span></label>  
					  <div class="col-md-6">
					  	<input id="noOfTest" name="noOfTest" type="text" onkeyup="myFunction()" placeholder="No of Test" class="form-control input-md validate[required]">
					  </div>
					</div>
					
					<!-- Text input-->
					<div class="form-group">
					  <label class="col-md-4 control-label" for="actualAmount">Actual Amount:<span style="color:red">*</span></label>  
					  <div class="col-md-6">
					  	<input id="actualAmount" name="actualAmount" type="text" placeholder="0" class="form-control input-md validate[required]">
					  </div>
					</div>
					
					<!-- Text input-->
					<div class="form-group">
					  <label class="col-md-4 control-label" for="amountPaid">Amount Paid:<span style="color:red">*</span></label>  
					  <div class="col-md-6">
					  	<input id="amountPaid" name="amountPaid" type="text" onkeyup="myFunction()" placeholder="0" class="form-control input-md validate[required]" >
					  </div>
					</div>
					
					<!-- Password input-->
					<div class="form-group">
					  <label class="col-md-4 control-label" for="discount">Discount:<span style="color:red">*</span></label>
					  <div class="col-md-6">
					    <input id="discount" name="discount" type="text" placeholder="Total Discount" class="form-control input-md validate[required]" >
					  </div>
					</div>
					
					<!-- Text input-->
					<div class="form-group">
					  <label class="col-md-4 control-label" for="startDate">Start Date:<span style="color:red">*</span></label>  
					  <div class="col-md-6">
					  	<input name="startDate" type="date" placeholder="Enter Start Date" class="form-control input-md datepicker validate[required]">
					  </div>
					</div>
				
					<!-- Text input-->
					<div class="form-group">
					  <label class="col-md-4 control-label" for="endDate">End Date:<span style="color:red">*</span></label>  
					  <div class="col-md-6">
					  	<input name="endDate" type="date" placeholder="Enter End Date" class="form-control input-md datepicker validate[required]">
					  </div>
					</div>
					
					<div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		                <input type="submit" class="btn btn-primary" value="Assign Package"/>
		                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		            </div>
		      </form>
            </div>
          </div>
        </div>
     </div>
     <jsp:include page ="../jsp/footer.jsp"/>
</body>
<script type="text/javascript">
 function divFunction(candidateId){
	 var candidateId = candidateId;
        if ($("#check").is(":checked")) {
          $.ajax({
              url: '${pageContext.request.contextPath}/admin/permission?id='+candidateId,
              type: 'GET',
              date: "id="+candidateId,
              headers: {"Authorization": localStorage.getItem('token')},
              success: function (data){
              	 $("#check").attr("checked","checked");
               }
          });
        }else{
        	 $.ajax({
                 url: '${pageContext.request.contextPath}/admin/permission?id='+candidateId,
                 type: 'GET',
                 date: "id="+candidateId,
                 headers: {"Authorization": localStorage.getItem('token')},
                 success: function (data){
                	 $("#check").removeAttr("checked","checked");
                  }
             });
        }
    }

</script>
<script type="text/javascript">
$(document).ready(function() {
	 $("#timer").click(); 
	 $("#resultList").click(function(){
		 $.ajax({
             url: '${pageContext.request.contextPath}/admin/testResult',
             type: 'GET',
             success: function (data){
            	 $("#registration").attr("style","display:none;"); 
            	 if($("#packageDetails").text() != null){
            		 $("#packageDetails").attr("style","display:none;"); 
            		 $("#testResult").attr("style","");
            	 }
            	 if($("#testSetData").text() != null){
            		 $("#testSetData").attr("style","display:none;"); 
            		 $("#testResult").attr("style","");
            	 }
            	 $("#testResult").html(data);
              }
         });
	 });
	 $("#passResult").click(function(){
		 $.ajax({
             url: '${pageContext.request.contextPath}/admin/testResult/pass',
             type: 'GET',
             success: function (data){
            	 $("#registration").attr("style","display:none;"); 
            	 if($("#packageDetails").text() != null){
            		 $("#packageDetails").attr("style","display:none;"); 
            		 $("#testResult").attr("style","");
            	 }
            	 if($("#testSetData").text() != null){
            		 $("#testSetData").attr("style","display:none;"); 
            		 $("#testResult").attr("style","");
            	 }
            	 $("#testResult").html(data);
              }
         });
	 });
	 $("#failResult").click(function(){
		 $.ajax({
             url: '${pageContext.request.contextPath}/admin/testResult/fail',
             type: 'GET',
             success: function (data){
            	 $("#registration").attr("style","display:none;"); 
            	 if($("#packageDetails").text() != null){
            		 $("#packageDetails").attr("style","display:none;"); 
            		 $("#testResult").attr("style","");
            	 }
            	 if($("#testSetData").text() != null){
            		 $("#testSetData").attr("style","display:none;"); 
            		 $("#testResult").attr("style","");
            	 }
            	 $("#testResult").html(data);
              }
         });
	 });
	 $("#activePackage").click(function(){
		 $.ajax({
             url: '${pageContext.request.contextPath}/admin/activePackageDetails',
             type: 'GET',
             success: function (data){
            	 $("#registration").attr("style","display:none;"); 
            	 if($("#testResult").text() != null){
            		 $("#testResult").attr("style","display:none;"); 
            		 $("#packageDetails").attr("style","");
            	 }
            	 if($("#testSetData").text() != null){
            		 $("#testSetData").attr("style","display:none;"); 
            		 $("#packageDetails").attr("style","");
            	 }
            	 $("#packageDetails").html(data);
              }
         });
	 });
	  $("#expirePackage").click(function(){
		 $.ajax({
             url: '${pageContext.request.contextPath}/admin/expirePackageDetails',
             type: 'GET',
             success: function (data){
            	 $("#registration").attr("style","display:none;"); 
            	 if($("#testResult").text() != null){
            		 $("#testResult").attr("style","display:none;"); 
            		 $("#packageDetails").attr("style","");
            	 }
            	 if($("#testSetData").text() != null){
            		 $("#testSetData").attr("style","display:none;"); 
            		 $("#packageDetails").attr("style","");
            	 }
            	 $("#packageDetails").html(data);
              }
         });
	 }); 
	  $("#assignPackage").click(function(){
			 $.ajax({
	             url: '${pageContext.request.contextPath}/admin/assignPackageDetails',
	             type: 'GET',
	             success: function (data){
	            	 $("#registration").attr("style","display:none;"); 
	            	 if($("#testResult").text() != null){
	            		 $("#testResult").attr("style","display:none;"); 
	            		 $("#packageDetails").attr("style","");
	            	 }
	            	 if($("#testSetData").text() != null){
	            		 $("#testSetData").attr("style","display:none;"); 
	            		 $("#packageDetails").attr("style","");
	            	 }
	            	 $("#packageDetails").html(data);
	              }
	         });
		 }); 
	 $("#testSet").click(function(){
		 $.ajax({
             url: '${pageContext.request.contextPath}/admin/testSet',
             type: 'GET',
             success: function (data){
            	 $("#registration").attr("style","display:none;"); 
            	 if($("#packageDetails").text() != null){
            		 $("#packageDetails").attr("style","display:none;"); 
            		 $("#testSetData").attr("style","");
            	 }
            	 if($("#testResult").text() != null){
            		 $("#testResult").attr("style","display:none;"); 
            		 $("#testSetData").attr("style","");
            	 }
            	 $("#testSetData").html(data);
              }
         });
	 });
	 $("#formID").validationEngine();
});
</script>
<script type="text/javascript">
function toggle(source) {
    var checkboxes = document.querySelectorAll('input[id="chk"]');
    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i] != source)
            checkboxes[i].checked = source.checked;
    }
}
</script>
<script type="text/javascript">
function openPackage(id) {
	var name = $("#"+id).text()
	$('#myModal').modal('show');
	$("#name").attr("value",name);
	$("#candidateId").attr("value",id);
}
</script>
<script type="text/javascript">
function validFunction(id) {
	$.ajax({
        url: '${pageContext.request.contextPath}/admin/candidate/enable?enable='+id,
        type: 'GET',
        success: function (candidateList){
	       for(var i =0;i<candidateList.length();i++){
	    	   
	       }
         }
    });
}
function updateFunction(id) {
	var timeInMin = $("#timeInMin_"+id).val();
	$.ajax({
        url: '${pageContext.request.contextPath}/admin/testSet/updateTime?id='+id+'&timeInMin='+timeInMin,
        type: 'GET',
        success: function (data){
        	$("#success"+id).attr("style","");
	      }
    });
}
function deleteFunction(id) {
	$.ajax({
        url: '${pageContext.request.contextPath}/admin/testSet/delete?id='+id,
        type: 'GET',
        success: function (data){
        	$("#registration").attr("style","display:none;"); 
       	 	if($("#activePackageDetails").text() != null){
       		 	$("#activePackageDetails").attr("style","display:none;"); 
       		 	$("#testSetData").attr("style","");
       		 }
       	 	if($("#testResult").text() != null){
       		 	$("#testResult").attr("style","display:none;"); 
       		 	$("#testSetData").attr("style","");
       	 	}
       	 	$("#testSetData").html(data);
	    }
    });
}
</script>
<script type="text/javascript">
function myFunction() {
    var inputText = document.myForm.noOfTest.value;
    var amountPaid = document.myForm.amountPaid.value;
    var totalAmount = inputText*100;
    $("#actualAmount").attr("value",totalAmount);
    if(amountPaid != null && amountPaid != 0){
    	var discountAmount = totalAmount - amountPaid;
    	$("#discount").attr("value",discountAmount);
    }
}
</script>
<script type="text/javascript">
function stateFunction(state) {
	$.ajax({
        url: '${pageContext.request.contextPath}/admin/registration/state?state='+state,
        type: 'GET',
        success: function (data){
        	var full_list = ""
	       for(var i =0;i<data.length;i++){
	    	   if(i==0)
	    	   	full_list = full_list + '<option value="">'+data[i]+'</option>' + '<br>'
	    	   else
	    	   	full_list = full_list + '<option value="'+data[i]+'">'+data[i]+'</option>' + '<br>'
	       }
        	$("#city").html(full_list);  
         }
    });
}
</script>
<script type="text/javascript">
$(window).load(function() {
	// Animate loader off screen
	$(".se-pre-con").fadeOut("slow");;
});
</script>
<script type="text/javascript">
  $( function() {
    $( ".datepicker" ).datepicker({
    	dateFormat: 'yy-mm-dd',
    	changeMonth: true,
        changeYear: true,
        yearRange: '1980:2030'
    });
  } );
</script>
</html>
