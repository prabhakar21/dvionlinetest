<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta content="abc123blahblahauthenticitytoken" name="csrf-token">
<title>Da Vinci Institute Bokaro</title>
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
<script src="${pageContext.request.contextPath}/jquery/jquery-1.11.3.js"></script>
<script src="${pageContext.request.contextPath}/jquery/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery/validation-engine/jquery.validationEngine-en.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery/validation-engine/jquery.validationEngine.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-theme.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/validationEngine.jquery.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assignTo/jquery-ui.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assignTo/style.css"/>
<head>
<title>Assign to the Candidates</title>
</head>
<jsp:include page ="../jsp/header.jsp"/>
<style>
#tableHeading th{
text-align: center;
}
</style>
<body>
<div align="center" style="padding-top:80px;">
<label> Question Set :&nbsp;</label><font color="#40aaf3">${testSet.questionSet}</font>
	<form action="${pageContext.request.contextPath}/admin/candidate/assignTo" method="post">
		<input type="hidden" name="testSetId" value="${testSet.id}" />
		<label> Assing to :</label>
			<input type = "text" list="email" name="email" placeholder="Mail-Id" id="tags" size="50" required />
		<input type="submit" class="btn btn-danger" value="Assign To" id ="assignTo"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</div>
<div class="container" style="margin-top:10px;">
	<div class="table-responsive">
		<table class="table table-striped table-bordered text-left table-hover">
			<thead>
				<tr class="info" id="tableHeading">
					<th>S.No</th>
					<th>Name</th>
					<th>Email-Id</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach var="candidate" items="${candidateListOfTestSet}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${candidate.fullname}</td>
						<td>${candidate.email}</td>
						<td><a href="${pageContext.request.contextPath}/admin/deleteCandidateTestSetConfiguration/${candidate.candidateTestSetConfigurationId}/${testSet.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
					</tr>
				</c:forEach> 
			</tbody>
		</table>
	</div>
</div>
<jsp:include page ="../jsp/footer.jsp"/>
</body>
<script type="text/javascript">
  
  $( function() {
	  var mail = ${email};
	  var availableTags = mail;
    function split( val ) {
      return val.split( /,\s*/ );
    }
    function extractLast( term ) {
      return split( term ).pop();
    }
 
    $( "#tags" )
      // don't navigate away from the field on tab when selecting an item
      .on( "keydown", function( event ) {
        if ( event.keyCode === $.ui.keyCode.TAB &&
            $( this ).autocomplete( "instance" ).menu.active ) {
          event.preventDefault();
        }
      })
      .autocomplete({
        minLength: 0,
        source: function( request, response ) {
          // delegate back to autocomplete, but extract the last term
          response( $.ui.autocomplete.filter(
            availableTags, extractLast( request.term ) ) );
        },
        focus: function() {
          // prevent value inserted on focus
          return false;
        },
        select: function( event, ui ) {
          var terms = split( this.value );
          // remove the current input
          terms.pop();
          // add the selected item
          terms.push( ui.item.value );
          // add placeholder to get the comma-and-space at the end
          terms.push( "" );
          this.value = terms.join( "," );
          return false;
        }
      });
  } );
  </script>
</html>