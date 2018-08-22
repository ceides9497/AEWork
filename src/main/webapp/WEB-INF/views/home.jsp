<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Cache-control" content="no-cache">
	<title>Automation Editor</title>
	<%@include file="importLinks.jsp" %>
	<link rel="stylesheet" href="<c:url value="/resources/css/home.css"/>"/>
</head>
<script type="text/javascript">
current_state="initialState";
var buttons = ["Start", "Answer","Park", "hold", "TransfStart", "TransfComp", "ConfStart", "ConfComp", "UnattendedTransferStart", "End","RemoveParty"];
selectedActionRowId = "";
selectedKeyPressRowId = "";
fromCall = "";
toCall = "";

$(document).ready(function() {
	current_state = "${states}";
	if("${allActionEnable}"=="true"){
		for(var i =0;i<buttons.length;i++){
			var divid = '#'+buttons[i];
			$(divid).css("color","#000000");
			$(divid).removeAttr('disabled');
			$(divid).css("cursor","pointer");
			$(divid).removeClass("disabled");
		}
	}else{
	<c:forEach items="${actionList}" var="action" varStatus="loop">
		var divid2 = '#'+'${action.actionName}';
			if("${action.enabled}"=="true"){
				$(divid2).css("color","#000000");
				$(divid2).removeAttr('disabled');
				$(divid2).css("cursor","pointer");
				$(divid2).removeClass("disabled");
			}
			else{
				$(divid2).attr('disabled','disabled');
				$(divid2).css("color","#818181");
				$(divid2).css("cursor","default");
				$(divid2).addClass("disabled");
			}
	</c:forEach>
	}
	
	$('.enteredActionsBlock .scrollArea').scrollTop($('.enteredActionsBlock .scrollArea')[0].scrollHeight);

	$('.enteredActionsBlock table tbody').delegate('tr', 'click' , function(){
		var row = $(this);                 //cache the row

	    if(!row.hasClass('selected')){
	        row.addClass('selected')       //add class to clicked row
	            .siblings()                //get the other rows
	            .removeClass('selected');  //remove their classes
	    }else{
	    	$(this).removeClass('selected');
		}
		selectedActionRowId=this.id;	
		 //selectedKeyPressRowId=$(this).attr("class").split(" ")[0];
	});

	$('.keyPressBlock1 table tbody').delegate('tr', 'click' , function(){
		var row = $(this);                 //cache the row

	    if(!row.hasClass('selected')){
	        row.addClass('selected')       //add class to clicked row
	            .siblings()                //get the other rows
	            .removeClass('selected');  //remove their classes
	    }else{
	    	$(this).removeClass('selected');
		}
	    selectedKeyPressRowId=this.id;	
	});
	
	$(".enteredActionsBlock .select_all_actions").click(function(){
		if(this.checked){
			$('#enteredActions_table input[type=checkbox]').each(function() {
		        this.checked = true;
			});
		}else{
			$('#enteredActions_table input[type=checkbox]').each(function() {
		        this.checked = false;
			});
		}
	});
	
	$(".enteredActionsBlock table tbody").delegate("input[name='checkAction']","change", function(){
		var allchecked = true;
		$('#enteredActions_table tbody input[type=checkbox]').each(function() {
			if(this.checked){
			}else{
				allchecked = false;
			}
		});
		if(allchecked){
			$('.enteredActionsBlock input[class=select_all_actions]').each(function() {
		        this.checked = true;
			});
		}else{
			$('.enteredActionsBlock input[class=select_all_actions]').each(function() {
		        this.checked = false;
			});
		}
	});
});


function showValidate(){
	validateHide.style.display = "none";
	validateBlock.style.display = "block";
	hideKeyPress();
	hidePause();
	hideValidateAudio();
}

function hideValidate(){
	validateHide.style.display = "block";
	validateBlock.style.display = "none";
}

function showKeyPress(){
	keyPressHide.style.display = "none";
	keyPressBlock.style.display = "block";
	hideValidate();
	hidePause();
	hideValidateAudio();
}

function hideKeyPress(){
	keyPressHide.style.display = "block";
	keyPressBlock.style.display = "none";
}

function showPause(){
	pauseHide.style.display = "none";
	pauseBlock.style.display = "block";
	hideKeyPress();
	hideValidate();
	hideValidateAudio();

	$('#pause_input').focus();
}

function hidePause(){
	pauseHide.style.display = "block";
	pauseBlock.style.display = "none";
}

function showValidateAudio(){
	validateAudioHide.style.display = "none";
	validateAudioBlock.style.display = "block";
	hideKeyPress();
	hidePause();
	hideValidate();
}

function hideValidateAudio(){
	validateAudioHide.style.display = "block";
	validateAudioBlock.style.display = "none";
}
</script>
<body class="baseContainer">

<div id="wrapper">

<div style="padding-left: 40px">
<a href="http://www.tekvizion.com/"><img style="width:150px;height:32px;cursor: pointer;" src="<c:url value="/resources/images/home/TekVizion Logo.png"/>"></a>

</div>
<div class="upper_top_bar">

	<div class="automation_text">Automation Editor</div>
	
	<ul class="settings_div">
		<!-- <li class="settings_text">User : ${userName}</li>  -->
		<!-- <c:if test="${!allActionEnable}"><a href="logout"><li class="settings_text logout_button">Logout</li></a></c:if> -->
	</ul>
	
</div>

<div id="content">

<div class="buttonsDiv" style="width:100%;height:35px;float: left;">
		<a href="testCases?id=${testPlan.id}"><button class="backButton"></button></a>
		<a href="sipRedirectEditor?tcId=${testCase.id}&tpId=${testPlan.id}"><button class="sipEditor"></button></a>
		<div id="help" title="Help"></div>
</div>

<div style="width: 735px;float: left;margin-top: 15px;">

<%@include file="actionsButtons.jsp" %>
 
<%@include file="enteredActions.jsp" %>
<script>angular.bootstrap(document.getElementById("enteredActionsBlock"), ['enteredActions_App']);</script>

	<div class="buttonsDiv" style="width:100%;height:35px;float: left;">
	
		<button style="margin-left: 10px;margin-top: 10px;" class="enableAll"></button>
		<button style="margin-left: 45px;margin-top: 10px;" class="resetActions" onClick="reset_actions()"></button>
		
		<button style="margin-left: 25px;margin-top: 10px;" class="up"></button>
		<button style="margin-left: 0px;margin-top: 10px;" class="down"></button>
		<button style="margin-left: 0px;margin-top: 10px;" class="commentAction"></button>
		<button style="margin-left: 165px;margin-top: 10px;" class="editAction"></button>
		<!-- <button style="margin-left: 10px;margin-top: 10px;" class="selectAll"></button>-->
		<!-- <button style="margin-left: 0px;margin-top: 10px;" class="de-selectAll"></button>-->
		<button style="margin-left: 0px;margin-top: 10px;" class="deleteActions"></button>
		
		<!-- 
		<button style="margin-left:75px;margin-top: 10px; " class="saveResults""></button>
		<button style="margin-left: 5px;margin-top: 10px;" class="clearResults"></button>
	   	-->
	</div>

	<div class="buttonsDiv" style="width:100%;float: left;margin-top: 5px">
		<div class="upload_template"><input name="files" id="files" class="uploadT" type="file" ></div>
		<div class="save_template"></div>
	</div>

<%@include file="testCaseDetails.jsp" %>
 
<%@include file="xmlResult.jsp" %>
<script>angular.bootstrap(document.getElementById("xmlResultBlock"), ['xmlResult_App']);</script>
<!-- 
<%@include file="runResult.jsp" %>
<script>angular.bootstrap(document.getElementById("runResultBlock"), ['runResult_App']);</script>
 -->
 	<!-- <div class="buttonsDiv" style="height:35px;float: left;padding-left: 230px">
		<div class="editScript" style="cursor: pointer;" ></div>
	</div>
	 -->
	<div class="buttonsDiv" style="height:35px;float: left;padding-left: 500px;color: #1414a4;font-weight: 600;font-size: 14px">
		<input type="checkbox" class="markCompleted" name="markCompleted">Completed
	</div>
	<div class="buttonsDiv" style="height:35px;float: left;padding-left: 25px">
		<button class="saveXML"></button>
	</div>
</div>
<div style="float: left;width: 290px;margin-top: 15px;">

<!-- 
<div id="blocks_radio_id" class="blocks_radio">
<ul style="column-count: 3;margin: 0px;padding: 0px">
 <li class="textBlocks">
 	Validate
 	<input type="radio" name="block_radio" value="validate">
 </li>
 <li class="textBlocks" style="padding-left: 20px">
 	KeyPress
 	<input type="radio" name="block_radio" value="keypress">
 </li>
 <li class="textBlocks" style="padding-left: 20px">
 	Pause
 	<input type="radio" name="block_radio" value="pause">
 </li>
</ul>
</div>
 -->
 
 
 <!-- Modal to show edit script files -->
	<div class="modal fade" id="editScriptModal" role="dialog">
	  <div class="modal-dialog" style="margin-top: 200px;position:relative;width: 600px;height:585px;margin-bottom: 0px;">
		<!-- Modal content-->
		<div class="modal-content" style="height: inherit;">
		  <div class="modal-body" style="padding:0px;">
		  <div id="editScriptId">
		  	<textarea id="edit_script_xml" style="resize : none;width: 500px;height: 470px;margin-left: 50px;margin-top: 30px;padding: 10px"></textarea>
		  </div>
		  <div>
		  	<div class="exitEditScript" data-dismiss="modal"></div>
		  	<div class="saveEditScript"></div>
		  </div>
		  </div>
		</div>
	  </div>
	</div>
<!-- /.modal -->
 
 
 <!-- Modal to show help window -->
<div class="modal fade" id="helpmodal" role="dialog">
  <div class="modal-dialog" style="margin-top: 200px;position:relative;width: 600px;height:510px;margin-bottom: 0px;">
	<!-- Modal content-->
	<div class="modal-content" style="height: inherit;">
	  <div class="modal-body" style="padding:0px;">
	  <div style="text-align: center;color: #1414a4;font-size: 20px;padding-top: 10px;font-weight: 600">HELP WINDOW</div>
	  <div id="helpdetails" style="padding: 30px;font-size: 16px;color: rgb(154,154,154);line-height: 25px;text-align: justify;">
	  	<b style="color: #1414a4"><br><br></b>
	  	<b style="color: #1414a4"><br><br></b>
	  </div>
	  </div>
	</div>
  </div>
</div>
<!-- /.modal -->

 <!-- Modal to show Edit Action -->
<div class="modal fade" id="editActionmodal" role="dialog">
  <div class="modal-dialog" style="margin-top: 350px;position:relative;width: 650px;height:250px;margin-bottom: 0px;">
	<!-- Modal content-->
	<div class="modal-content" style="height: inherit;">
	  <div class="modal-body" style="padding:0px;">
		  <form style="padding-left:10px;padding-right: 10px;padding-top: 15px">
			  <div style="font-family: 'Source Sans Pro';font-weight: 600;font-size: 16px;color: #1414a4;text-align: center;">EDIT ACTION</div>
			  <div  style="margin: 10px;font-size: 16px;color: rgb(154,154,154);line-height: 25px;text-align: justify;">
			  	<input type="text" id="editActionId" style="display:none"/>
			  	<input type="text" id="editActionType" disabled style="border : 0;font-size: 16px!important;color: rgb(154,154,154);
			  					line-height: 25px;text-align: justify;background: transparent;margin-bottom:10px">
			  	<textarea type="text" id="editActionText" style="font-size: 16px!important;color: rgb(154,154,154);line-height: 25px;
			  					text-align: justify;width: 620px;height: 75px;font-weight:400!important "></textarea>
			  </div>
			  <div id="buttons_div" style="width: 100%;float: left;padding-top: 10px">
				<button style="float: right" type="reset" class="cancelEdit" data-dismiss="modal"></button>
				<button style="float: right;margin-right: 10px" class="saveEditAction"></button>
			  </div>
			  <div style="color:red">NOTE : Incorrect/Invalid data entries would lead to script errors and test case failures.</div>
		  </form>
	  
	  </div>
	</div>
  </div>
</div>
<!-- /.modal -->
 
<%@include file="validate.jsp" %>
<script>angular.bootstrap(document.getElementById("validateBlock"), ['validate_App']);</script>

<%@include file="keyPress.jsp" %>
<script>angular.bootstrap(document.getElementById("keyPressBlock"), ['keyPress_App']);</script>

<%@include file="pause.jsp" %>
<script>angular.bootstrap(document.getElementById("pauseBlock"), ['pause_App']);</script>

<%@include file="validateAudio.jsp" %>
<script>angular.bootstrap(document.getElementById("validateAudioBlock"), ['validateAudio_App']);</script>

<%@include file="resourceManagement.jsp" %>
<script>angular.bootstrap(document.getElementById("resourceManagementBlock"), ['resourceManagement_App']);</script>

</div>

</div>
<div id="footer">
</div>

</div>

</body>

<script>
$('.buttonsDiv .up').click(function () {
	c = false;
	$(".enteredActionsBlock table tbody tr").each(function(i, row){
		if($(this).hasClass('selected'))
			c = true;
	});
	if(selectedActionRowId!=0 && c == true){
		var id = selectedActionRowId;
		var data='id='+encodeURIComponent(selectedActionRowId);
		$.ajax({
			type : 'POST',
			data: data,
			url : 'actionUp',
			success : function(resp) {
				$("#enteredActions_table tbody tr").remove(); 
				for(var i=0; i<resp['entered_actions'].length;i++){
					$('<tr id=\"'+i+'\">').html(
							"<td id=\"idCheck"+i+"\" style=\"width:25px;padding-left:5px\">"+"<input type=\"checkbox\" name=\"checkAction\" value="+i+"></td>"+
					        "<td id=\"idText"+i+"\" style="+"\"text-align:left;padding-left:10px\" "+"class="+"\"enteredActions_table_td\""+">" 
					        	+ resp['entered_actions'][i] + "</td>").appendTo('#enteredActions_table');
				}
	   			//$('.enteredActionsBlock .scrollArea').scrollTop($('.enteredActionsBlock .scrollArea')[0].scrollHeight);
	   			
				selectedActionRowId = selectedActionRowId-1;
				var trId = "#"+selectedActionRowId;
				$(".enteredActionsBlock table tbody tr").each(function(i, row){
					$(this).removeClass('selected');
				});		
				$('.enteredActionsBlock').find(' '+trId).addClass('selected');
				
				$('.enteredActionsBlock').find(' '+trId)[0].scrollIntoView({behavior: "instant", block: "center", inline: "nearest"});
			},
			error : function(xhr, status, error) {
				bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
			}
		});
	}
});

$('.buttonsDiv .down').click(function () {
	c = false;
	var rowCount = $('#enteredActions_table tr').length-1;
	$(".enteredActionsBlock table tbody tr").each(function(i, row){
		if($(this).hasClass('selected'))
			c = true;
	});
	if(parseInt(selectedActionRowId)+1!=rowCount && c == true){
		var id = selectedActionRowId;
		var data='id='+encodeURIComponent(selectedActionRowId);
		$.ajax({
			type : 'POST',
			data: data,
			url : 'actionDown',
			success : function(resp) {
				$("#enteredActions_table tbody tr").remove(); 
				for(var i=0; i<resp['entered_actions'].length;i++){
					$('<tr id=\"'+i+'\">').html(
							"<td id=\"idCheck"+i+"\" style=\"width:25px;padding-left:5px\">"+"<input type=\"checkbox\" name=\"checkAction\" value="+i+"></td>"+
					        "<td id=\"idText"+i+"\" style="+"\"text-align:left;padding-left:10px\" "+"class="+"\"enteredActions_table_td\""+">" 
					        	+ resp['entered_actions'][i] + "</td>").appendTo('#enteredActions_table');
				}
	   			//$('.enteredActionsBlock .scrollArea').scrollTop($('.enteredActionsBlock .scrollArea')[0].scrollHeight);
	   			
				selectedActionRowId = parseInt(selectedActionRowId)+1;
				var trId = "#"+selectedActionRowId;
				$(".enteredActionsBlock table tbody tr").each(function(i, row){
					$(this).removeClass('selected');
				});		
				$('.enteredActionsBlock').find(' '+trId).addClass('selected');	
				
				$('.enteredActionsBlock').find(' '+trId)[0].scrollIntoView({behavior: "instant", block: "center", inline: "nearest"});
			},
			error : function(xhr, status, error) {
				bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
			}
		});
	}
});

$('.deleteActions').click(function () {
	if(jQuery('#enteredActions_table tbody input[type=checkbox]:checked').length!=0) { 
		bootbox.confirm({
		    buttons: {
		    	confirm: {
		    		label: 'YES',
	        	},
		        cancel: {
		            label: 'NO',
		        }
		    },
		    message: 'Are you sure want to delete these Actions?',
		    callback: function(result) {
		    	if(result) {
			    	var chk = [];
					$('#enteredActions_table tbody input[type=checkbox]:checked').each(function() {
						chk.push($(this).val());
					});
					var data='ids='+encodeURIComponent(chk);
					$.ajax({
						type : 'POST',
						data: data,
						url : 'deleteActions',
						success : function(resp) {
							$("#enteredActions_table tbody tr").remove(); 
							for(var i=0; i<resp['entered_actions'].length;i++){
								$('<tr id=\"'+i+'\">').html(
										"<td id=\"idCheck"+i+"\" style=\"width:25px;padding-left:5px\">"+"<input type=\"checkbox\" name=\"checkAction\" value="+i+"></td>"+
								        "<td id=\"idText"+i+"\" style="+"\"text-align:left;padding-left:10px\" "+"class="+"\"enteredActions_table_td\""+">" 
								        	+ resp['entered_actions'][i] + "</td>").appendTo('#enteredActions_table');
							}
				   			$('.enteredActionsBlock .scrollArea').scrollTop($('.enteredActionsBlock .scrollArea')[0].scrollHeight);
						},
						error : function(xhr, status, error) {
							bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
						}
					});
		    	}
		    }
		}).find("div.modal-content").addClass("modalalert");
	}
});

$('.selectAll').click(function () {
	$('#enteredActions_table input[type=checkbox]').each(function() {
        this.checked = true;
	});
});

$('.de-selectAll').click(function () {
	$('#enteredActions_table input[type=checkbox]').each(function() {
        this.checked = false;
	});
});

$('#blocks_radio_id input:radio').click(function() {
    if ($(this).val() === 'validate') {
      showValidate();
    } else if ($(this).val() === 'keypress') {
      showKeyPress();
    } else{
	  showPause();
    }
});

$('.commentAction').click(function () {
	$('#comment_box_modal').modal('show');
	 $('#comment_desc').focus();
});

$(".xmlResultBlock .generateXML").click(function () {
	$.ajax({
		type : 'POST',
		url : 'generateScript',
		data: "idlePhones=" + encodeURIComponent($(".idleCheck").is(':checked')),
		success : function(resp) {
			$('#script_xml').text(resp);
		},
		error : function(xhr, status, error) {
			bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
		}
	});
});

$('.buttonsDiv .saveXML').click(function () {

	if($(".markCompleted").is(':checked')){
		markComplete = true;
	}
	else{
		markComplete = false;
	}

	var data = "tcId="+encodeURIComponent("${testCase.id}")
				+"&markComplete="+encodeURIComponent(markComplete);
	
	if($('#script_xml').text().trim()!=""){
		$.blockUI({ message: '<img src="resources/images/ajaxWait.gif" />' });
		$.ajax({
			type : 'POST',
			url : 'uploadScripts',
			data : data,
			success : function(response) {
				$.unblockUI();
					if(response=="success"){
						$('#script_xml').text("");
						bootbox.alert("Scripts Uploaded Successfully").find("div.modal-content").addClass("modalSuccess");
					}
					else{
						bootbox.alert("Error occurred... "+response).find("div.modal-content").addClass("modalfailure");
					}
			},
			error : function(xhr, status, error) {
				$.unblockUI();
				bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
			}
		});
	}else{
		bootbox.alert("Saving Test File Failed. Generate the script before saving. ").find("div.modal-content").addClass("modalfailure");
	}
});

$('.save_template').click(function () {
	$.ajax({
		type : 'POST',
		url : 'saveTemplate',
		success : function(response) {
			if(response=="Empty"){
				bootbox.alert(" No Actions Recorded. Empty Template. ").find("div.modal-content").addClass("modalfailure");
				return;
			}
			if(response=="NoExist"){
				bootbox.alert(" Sorry Couldn't Save the template file. Try again later. ").find("div.modal-content").addClass("modalfailure");
			}
			else{
				window.location.href = '${pageContext.request.contextPath}/saveTemplate';
				window.setTimeout(deletingSavedTemplate,2000);
			}
		},
		error : function(xhr, status, error) {
			if(error=="Not Found"){
				bootbox.alert("Session Expired..Please Login again..",function(){window.location = "login";
				}).find("div.modal-content").addClass("modalfailure");
			}
			else{
				bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
			}
		}
	});
});
function deletingSavedTemplate(){	
	$.ajax({
		type : 'POST',
		url : 'deleteSavedTemplate',
		success : function(response) {
		},
		error : function(xhr, status, error) {
		}
	});
}


var fileName = "";
$(".buttonsDiv input[type=file]").change(function(event) {
	if($(this).val().trim()==""){
		return;
	}
    fileName = $(this).val();

    if (!(fileName.lastIndexOf('.etc', fileName.length - 4) === fileName.length - 4)) {
    	bootbox.alert("Only Test Case template files are allowed.").find("div.modal-content").addClass("modalfailure");
    	return;
    }
    files = event.target.files;
    var data = new FormData();
    data.append("file", files[0]);

    $.ajax( {
        url: 'uploadTemplate',
        type: 'POST',
        data: data,
        enctype: 'multipart/form-data',
        processData: false, 
        contentType:false,
        success : function(resp) {

            if(resp['emptyFile']==true){
            	bootbox.alert("Template File is Empty.").find("div.modal-content").addClass("modalfailure"); 
            }
            else
            if(resp['inValid']==true){
            	bootbox.alert("File Content is in Invalid Format.").find("div.modal-content").addClass("modalfailure"); 
            }
            else
			if(resp['emptyFile']==false && resp['inValid']==false){
	            $("#enteredActions_table tbody tr").remove(); 
				for(var i=0; i<resp['entered_actions'].length;i++){
					$('<tr id=\"'+i+'\">').html(
							"<td id=\"idCheck"+i+"\" style=\"width:25px;padding-left:5px\">"+"<input type=\"checkbox\" name=\"checkAction\" value="+i+"></td>"+
					        "<td id=\"idText"+i+"\" style="+"\"text-align:left;padding-left:10px\" "+"class="+"\"enteredActions_table_td\""+">" 
					        	+ resp['entered_actions'][i] + "</td>").appendTo('#enteredActions_table');
				}
	   			$('.enteredActionsBlock .scrollArea').scrollTop($('.enteredActionsBlock .scrollArea')[0].scrollHeight);

	   			for(var i =0;i<buttons.length;i++){
	   				var divid = '#'+buttons[i];
	   				$(divid).css("color","#000000");
	   				$(divid).removeAttr('disabled');
	   				$(divid).css("cursor","pointer");
	   				$(divid).removeClass("disabled");
	   			}
            }
		},
		error : function(xhr, status, error) {
			if(error=="Not Found"){
				bootbox.alert("Session Expired..Please Login again..",function(){window.location = "login";
				}).find("div.modal-content").addClass("modalfailure");
			}
			else{
				bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
			}
		}
      });

    $(this).val("");
});

$('.enableAll').click(function () {
	$.ajax({
		type : 'POST',
		url : 'allActionEnable',
		success : function(resp) {
			if(resp['allActionEnable']==true){
				for(var i =0;i<buttons.length;i++){
					var divid = '#'+buttons[i];
					$(divid).css("color","#000000");
					$(divid).removeAttr('disabled');
					$(divid).css("cursor","pointer");
					$(divid).removeClass("disabled");
				}
			}
		},
		error : function(xhr, status, error) {
			if(error=="Not Found"){
				bootbox.alert("Session Expired..Please Login again..",function(){window.location = "login";
				}).find("div.modal-content").addClass("modalfailure");
			}
			else{
				bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
			}
		}
	});
});


$('.buttonsDiv .editScript').click(function () {

	if($('#script_xml').text().trim()!=""){
		 $('#edit_script_xml').text($('#script_xml').text().trim());
		 $('#editScriptModal').modal('show');
	}else{
		bootbox.alert("Generate the script before editing. ").find("div.modal-content").addClass("modalfailure");
	}
});

$('#help').click(function () {
	$('#helpmodal').modal('show');
});

$('.buttonsDiv .editAction').click(function () {
	c = false;
	$(".enteredActionsBlock table tbody tr").each(function(i, row){
		if($(this).hasClass('selected'))
			c = true;
	});
	if(c == true){
		var id = selectedActionRowId;
		var data='id='+encodeURIComponent(selectedActionRowId);
		
		var idT = "#idText"+id;
		
		$('#editActionId').val(id);
		if($('.enteredActionsBlock').find(idT).text().split('>').length>1){
			$('#editActionType').val($('.enteredActionsBlock').find(idT).text().split('>')[0].trim()+">");
			$('#editActionText').val($('.enteredActionsBlock').find(idT).text().split('>')[1].trim());
			$('#editActionmodal').modal('show');
		}
	}
});

$(".saveEditAction").click(function(e){
	e.preventDefault();
	var id = $('#editActionId').val();
	var action = ""+$('#editActionType').val()+" "+$('#editActionText').val();
	
	var data='id='+encodeURIComponent(id)
				+'&action='+encodeURIComponent(action);
	
	$('#editActionmodal').modal('hide');
	$.ajax({
		type : 'POST',
		data: data,
		url : 'editAction',
		success : function(resp) {
			$("#enteredActions_table tbody tr").remove(); 
			for(var i=0; i<resp['entered_actions'].length;i++){
				$('<tr id=\"'+i+'\">').html(
						"<td id=\"idCheck"+i+"\" style=\"width:25px;padding-left:5px\">"+"<input type=\"checkbox\" name=\"checkAction\" value="+i+"></td>"+
				        "<td id=\"idText"+i+"\" style="+"\"text-align:left;padding-left:10px\" "+"class="+"\"enteredActions_table_td\""+">" 
				        	+ resp['entered_actions'][i] + "</td>").appendTo('#enteredActions_table');
			}
			
			$(".enteredActionsBlock table tbody tr").each(function(i, row){
				$(this).removeClass('selected');
			});		
			$('.enteredActionsBlock').find('#'+id).addClass('selected');
		},
		error : function(xhr, status, error) {
			bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
		}
	});
});

</script>
</html>