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
	 $("#package").click(function(){
		 $.ajax({
             url: '${pageContext.request.contextPath}/admin/packageDetails',
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
function toggle(source) {
    var checkboxes = document.querySelectorAll('input[id="chk"]');
    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i] != source)
            checkboxes[i].checked = source.checked;
    }
}
function openPackage(id) {
	var name = $("#"+id).text()
	$('#myModal').modal('show');
	$("#name").attr("value",name);
	$("#candidateId").attr("value",id);
}
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
}
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
$(window).load(function() {
	// Animate loader off screen
	$(".se-pre-con").fadeOut("slow");;
});