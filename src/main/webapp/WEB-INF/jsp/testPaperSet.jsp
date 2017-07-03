<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div align="center">
	<form class="navbar-form" method="post" action="javascript:void(0)" id="testSetForm">
        <div class="form-group">
        	<input type="text" class="form-control" name ="questionSet" placeholder="Name of Question Set" />
      	</div>
      	<div class="form-group">
         	<input type="text" class="form-control" name="timeInMin" placeholder="Time in Minuts" />
       	</div>
      <input type="submit" class="btn btn-danger" value="Submit" id ="testSetButton"/>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
 </div>
<div class="container text-center" id="tasksDiv">
	<div class="table-responsive">
			<table class="table table-striped table-bordered text-left table-hover">
				<thead>
					<tr class="info" id="tableHeading">
						<th>S.No</th>
						<th>Question Set</th>
						<th>Time in Minuts</th>
						<th>Is Enabled</th>
						<th>Assign To</th>
						<th>Add Question</th>
						<th>Update Time</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody align="center">
					<c:forEach var="testSet" items="${testSetList}" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td><a href ="${pageContext.request.contextPath}/showTestPaper?id=${testSet.id}" style="text-decoration: none;">${testSet.questionSet}</a></td>
							<td><input id="timeInMin_${testSet.id}" name="timeInMin" type="text" class="form-control input-md " value="${testSet.timeInMin}" style="width: 60px;"></td>
							<td>
								<c:choose>
										<c:when test="${testSet.isEnabled == true}">
											<label class="switch">
											  <input type="checkbox" checked="checked" id="check" name="${testSet.id}" onClick="testSetFunction(this.name)" />
											  <div class="slider"> </div>
											</label>
								  		</c:when>
										  <c:otherwise>
											  <label class="switch">
												  <input type="checkbox" id="check" name="${testSet.id}" onClick="testSetFunction(this.name)" />
												  <div class="slider"> </div>
											  </label>
										  </c:otherwise>
								</c:choose>
							</td>
							<td><a href ="${pageContext.request.contextPath}/admin/assignTo?testSetId=${testSet.id}" style="text-decoration: none;">AssignTo</a></td>
							<td><a href="${pageContext.request.contextPath}/addQuestion?testSetId=${testSet.id}">Add</a></td>
							<td><a href="javascript:void(0)" id="${testSet.id}" onClick="updateFunction(this.id)">Edit</a><span id="success${testSet.id}" style="display:none"><img src="${pageContext.request.contextPath}/images/CheckMark.png" width="20px" height="20px" align="middle"></span></td>
							<td><a href="javascript:void(0)" id="${testSet.id}" onClick="deleteFunction(this.id)"><span class="glyphicon glyphicon-trash"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
<script type="text/javascript">
$('input#testSetButton').click(function(){
	 var form = $("#testSetForm").serialize();
	 $.ajax({
         url: '${pageContext.request.contextPath}/admin/create/testSet',
         type: 'post',
         data:form,
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
</script>
<script type="text/javascript">
 function testSetFunction(testSetId){
	 var testSetId = testSetId;
        if ($("#check").is(":checked")) {
          $.ajax({
              url: '${pageContext.request.contextPath}/admin/isEnabled/testSet?id='+testSetId,
              type: 'GET',
              date: "id="+testSetId,
              headers: {"Authorization": localStorage.getItem('token')},
              success: function (data){
              	 $("#check").attr("checked","checked");
               }
          });
        }else{
        	 $.ajax({
                 url: '${pageContext.request.contextPath}/admin/isEnabled/testSet?id='+testSetId,
                 type: 'GET',
                 date: "id="+testSetId,
                 headers: {"Authorization": localStorage.getItem('token')},
                 success: function (data){
                	 $("#check").removeAttr("checked","checked");
                  }
             });
        }
    }

</script>