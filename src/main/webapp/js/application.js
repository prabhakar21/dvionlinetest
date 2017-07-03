//Global Functions
function updateInvestTxt(amount, txtBoxId){
  $('#'+txtBoxId).val(amount);
}
//Global Functions
//Ajax global settings
$(document).ajaxStart(function() {
	$(document.body).addClass("loading");
});

$(document).ajaxStop(function() {
	$(document.body).removeClass("loading");
});
//Ajax global settings
//$.getScript('//connect.facebook.net/en_UK/all.js', function(){
//    FB.init({
//      appId: '752890731395642',
//    });
//});

function facebookPost(element){
	var component = $(element);
	FB.ui({
		method : 'feed',
		link : 'https://www.micrograam.com/' + component.attr('data-url'),
		name : component.attr('data-name'),
		caption : component.attr('data-caption'),
		description : component.attr('data-description')
	}, function(response) {
		if (response && response.post_id) {
	      //alert('Post was published.');
	    } else {
	      //alert('Post was not published.');
	    }
	});
};

function linkedinPost(element){
	 var component = $(element);
	 var articleUrl = encodeURIComponent('https://www.micrograam.com/' + component.attr('data-url'));
     var articleTitle = encodeURIComponent(component.attr('data-name') + " " + component.attr('data-caption'));
     var articleSummary = encodeURIComponent(component.attr('data-description'));
     var articleSource = encodeURIComponent("");
     var gotourl = 'http://www.linkedin.com/shareArticle?mini=true'+
         '&url='+articleUrl+
         '&title='+articleTitle+
         '&summary='+articleSummary+
         '&source='+articleSource;
     window.open(gotourl, "LinkedIn", "width=660,height=400,scrollbars=no;resizable=no");
     return false;
};

function twitterPost(element){
	 var component = $(element);
	 var articleUrl = encodeURIComponent('https://www.micrograam.com/' + component.attr('data-url'));
     var articleTitle = encodeURIComponent(component.attr('data-name') + " " + component.attr('data-caption'));
     var articleSummary = encodeURIComponent(component.attr('data-description'));
     var articleSource = encodeURIComponent("");
    var gotourl = 'https://twitter.com/intent/tweet?'+
        '&url='+articleUrl+
        '&text='+articleTitle;
    window.open(gotourl, "Twitter", "width=660,height=400,scrollbars=no;resizable=no");
    return false;
};

//Function to make a table dynamic assuming there is a row already in the table calling this function
jQuery.fn.extend({

	escapeId : function(id){
		if (id.indexOf(".") >= 0) {
			id = id.replace('.', '\\.');
		}
		if (id.indexOf("[") >= 0) {
			id = id.replace('[', '\\[');
		}
		if (id.indexOf("]") >= 0) {
			id = id.replace(']', '\\]');
		}
		return "#" + id;
	},

	dynamicAddRow : function(inAddBtnTxt){
		if(!$(this).is("table")){
		return false;
		}
		var table = $(this);
		var addBtnTxt = inAddBtnTxt;
		if(addBtnTxt == undefined || addBtnTxt == ''){
		addBtnTxt = "Add Row"
		}
		//Assuming table already has a tr for header and one tr with data
		if(table.find("tr").length < 1){
		alert('Sorry! To use this function table needs to have a default row');
		return;
		}
		//Check table already has tfoot if has tfoor add delete button into tfoot
		//Else create tfoot and append delete button to it
		//var foot = table.find('thead tr');
		//   if (!head.length){
		var foot = table.find('tfoot tr');
		foot.append($('<tr><th style="padding-top:5px;" colspan="'+table.find('tbody tr td').length+'"><a href="javascript:void(0);" class="btn btn-sm btn-primary add" >'+addBtnTxt+'</a></th></tr>'));
		 //  }else{
		  // 	head.append($('<th colspan="'+table.find('tbody tr td').length+'"><a href="javascript:void(0);" class="btn btn-sm btn-primary add">'+addBtnTxt+'</a></th>'))
		 //  }
		   //foot.append($('<tr><td colspan="'+table.find('tbody tr td').length+'"><a href="javascript:void(0);" class="btn pull-right add">'+addBtnTxt+'</a></td></tr>'));
		   //Hide the delete action from the first row
//		   table.find('tbody tr:first-child td a').each(function(){
//		    	$(this).hide();
//		    });
			table.find('tbody tr').not(':last').each(function(){
		    	$(this).find('td a').each(function(){
		    		$(this).hide();
		    	});
		    });
		   $('table#tbl > tbody > tr').not(':first')
		   //Click handler whe button with class .add clicked
		table.on('click','.add', function(){
		var rowCount = table.find('tbody tr').length;
		    var lastRowContent =table.find('tbody tr').get(0).innerHTML;
		    var newRowContent = lastRowContent.replace(/_[0-9]_/g, '_' + rowCount + '_');
		    newRowContent = newRowContent.replace(/\[[0-9]\]/g, '[' + rowCount + ']');
		    var newRow = '<tr>'+newRowContent+'</tr>';
		    table.append(newRow).show('slow');
		    table.find('tbody tr:last-child input').each(function(){
		    $(this).val('');
		    });
		    table.find('tbody tr:last-child td a').each(function(){
		    $(this).show();
		    });
		    table.find('tbody tr').not(':last').each(function(){
		    	$(this).find('td a').each(function(){
		    		$(this).hide();
		    	});
		    });
		    if(table.find('tr:last-child td select').length > 0){
		    table.find('tr:last-child td select').each(function(){
		    $(this).prop('selectedIndex',0);
		    });
		    }
		});
		table.on('click','.delete',function(){
		var rowCount = table.find('tbody tr').length;
		if(rowCount === 1){
			alert('Please add a row before deleting this!');
			return;
		}
		$(this).parent().parent().prev().find('td a').each(function(){
			$(this).show();
		});
		$(this).parent().parent().remove().show('slow');
		});
	},
	/*
	 * @config : {
	 * 	url : <Mandatory to have URL> - required,
	 *  selectBox : Jquery - selectBox Element(base select box) - required,
	 *	targetSelectBox : Jquery - selectBox Element(selects box the value needs to be populated) - required,
	 *  mandatory : boolean - Whether to have -- Select -- has default value) - not required - defaults to false,
	 *	valueKey : String - JSON value key - required,
	 *	labelKey : String - JSON label key - required
	 * }
	 *
	 * */
	dynamicSelectBox : function(config){
		var value = config.selectBox.val();
		var labelJson = config.labelKey;
		if(config.labelKey == undefined){
			labelJson = config.valueKey;
		}
		if(value != "" || value != "-1"){
    		$.getJSON(config.url, function(response) {
    			config.targetSelectBox.empty();
    			config.targetSelectBox.trigger("change");
    			var options = "";
    			if(config.mandatory == undefined || !config.mandatory){
    				options = '<option value="">--Select--</option>'
    			}
    			$.each(response, function() {
    				options += '<option value="'+this[config.valueKey]+'">' + this[labelJson]+ '</option>';
    			});
    			config.targetSelectBox.append(options);
    		});
		}
	},

	/*
	 * Functions related to grid.tagx
	 *
	 */
	addCopyToTxtAndMakeNumberOnly :function(tableId){
		 $($.fn.escapeId(tableId) +" input.form-control").each(function(){
			var $this = $(this);
			var id="'"+$this[0].id+"'";
			if(id != ''){
				var rowId="'"+$this.parent().parent()[0].id+"'";
				$this.popover(
					{trigger : 'focus',
						container: 'body',
						html:true,
						placement:'bottom',
						content:'<a href="javascript:void(0);" class="btn btn-link pull-left" onclick="$.fn.copyValue('+tableId+','+id+','+rowId+');">Copy</a>'
					});
				// (Jquery) Making textfield only accept numeric values
				$this.keydown(function(event) {
					// Allow only backspace and delete
					if ( event.keyCode == 46 || event.keyCode == 8 ) {
						// let it happen, don't do anything
					}else {
						// Ensure that it is a number and stop the keypress
						if (event.keyCode < 48 || event.keyCode > 57 ) {
							event.preventDefault();
						}
					}
				});
			}
		});
	 },
	//Copy value to all the textbox in the same row
	copyValue : function(tableId,elementId, rowId){
		 var table = $(tableId);
		 var row = table.find('#'+rowId);
		 var inputTxt = row.find("#"+elementId);
		 var canCopy = false;
		 var lastElement = null;
		 row.find("td input:not(.row-total)").each(function() {
			 if(elementId === $(this)[0].id){
				 canCopy = true;
			 }
			 if(canCopy){
				 $(this).val(inputTxt.val());
				 lastElement = $(this);
			 }
	    });
		if(lastElement != null){
			lastElement.trigger('blur', lastElement);
		}
	 },
	//Row sum
	rowSummarize :function(tableId){
		 tableId = $.fn.escapeId(tableId);
		 for (var i=0;i<$(tableId+" tbody tr").length;i++){
		 	var row = $($(tableId+" tbody tr")[i]);
	 		var inputs = row.find("td input:not(.row-total)");
	 		var rowsum = 0;
	 		inputs.each(function() {
	 			if(this.value.trim() != "" && !isNaN(this.value.trim())){
	 				rowsum += parseInt(this.value);
	 			}

	    	});
	 		var table = $(tableId);
	 		table.find("#"+row[0].id).find(".row-total").val(isNaN(rowsum) ? 0 : rowsum);
		 }
	 },
	 //Column sum
	 columnSummarize :function(tableId){
		 var table = $($.fn.escapeId(tableId));
		 for (var i=0;i<12;i++){
			 var colsum = 0;
			 table.find("input.column-"+i).each(function(){
				 if(this.value.trim() != "" && !isNaN(this.value.trim())){
				 	colsum += parseInt(this.value);
				 }
			 });
			 table.find("input.total-col-"+i).val(isNaN(colsum) ? 0 : colsum);
		 }
		 if($.isFunction(window.gridDelta)){
			 gridDelta();
		 }
	 },
	 //Grand total
	 grandTotal :function(tableId){
		 var table = $($.fn.escapeId(tableId));
		 var grandTotal = 0;
		 table.find("input.row-total").each(function(){
			 if(this.value.trim() != "" && !isNaN(this.value.trim())){
				 grandTotal += parseInt(this.value);
			}
		 });
		table.find("input.grand-total").val(isNaN(grandTotal) ? 0 : grandTotal);
		if($.isFunction(window.gridDelta)){
			 gridDelta();
		 }
	 },
	 //Summarize
	 summarize : function(inTableId,element){
		 var tableId;
		 if(element == undefined){
			 var tableId = inTableId;
		 }else{
			 var txtElement = $(element);
			 tableId = txtElement.closest('table')[0].id;
		 }
		 $.fn.rowSummarize(tableId);
		 $.fn.columnSummarize(tableId);
		 $.fn.grandTotal(tableId);
	 },

	 intializeFormStateChange : function(){
		 var dirtyFormOptions= {
	        denoteDirtyForm: true,
	        denoteDirtyOptions:true,
	        dirtyOptionClass:"",
	        trimText:true,
	        formChangeCallback: function(result,dirtyFieldsArray) {
	        	isFormDirty = result;
	        }
		 };
		 $('form').each(function() {
			$(this).dirtyFields(dirtyFormOptions);
		});
	 },

	 validateForGreaterThan : function(){
		 $(this).
		 	on({
	    		blur: function(){
	        		var $this = $(this);
	        		var defaultValue = $this.attr('data-defaultValue');
	        		var currentValue = $this.val();
	        		var currentValueInt = parseInt(currentValue);
	        		if(isNaN(currentValueInt)) $this.val(defaultValue);
	        		if(currentValue === '') $this.val(defaultValue);
	        		$this.val(currentValueInt);
	        		if(currentValueInt > defaultValue) $this.val(defaultValue);
	   			}
			});
	 },

	 validateForBetweenMinAndMax : function(){
		 $(this).
		 	on({
		 		blur: function(){
				 var $this = $(this);
				 var minNoOfInstallment = $this.attr('min-number');
				 var maxNoOfInstallment = $this.attr('max-number');
				 var currentValue = $this.val();
				 if(isNaN(currentValue)){
					 alert("Enter valid number");
					 currentValue = 0;
				 }
				 if(currentValue == ''){
					 currentValue = 0;
				 }
				 var currentValueInt = parseInt(currentValue);
				 if(currentValueInt < minNoOfInstallment || currentValueInt > maxNoOfInstallment){
					 alert("Enter the value between "+minNoOfInstallment+" and "+maxNoOfInstallment);
					 $this.val('');
				 }else if(currentValueInt == 0){
					 $this.val('');
				 }
				 else{
					 $this.val(currentValueInt);
				 }
			 }
		 });
	 },

	 validateForBetweenMinAndMaxWithoutRoundUp : function(){
		 $(this).
		 	on({
		 		blur: function(){
				 var $this = $(this);
				 var minNoOfInstallment = $this.attr('min-number');
				 var maxNoOfInstallment = $this.attr('max-number');
				 var currentValue = $this.val();
				 if(isNaN(currentValue)){
					 alert("Enter valid number");
					 $(this).empty();
				 }
				 if(currentValue < minNoOfInstallment || currentValue > maxNoOfInstallment){
					 alert("Enter the value between "+minNoOfInstallment+" and "+maxNoOfInstallment);
					 $this.val('');
				 }else{
					 $this.val(currentValue);
				 }
			 }
		 });
	 }
});
