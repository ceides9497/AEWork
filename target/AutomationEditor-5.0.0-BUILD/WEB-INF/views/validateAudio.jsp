<link rel="stylesheet" href="<c:url value="/resources/css/validateAudio.css"/>"/>

<div id="validateAudioHide" class="validateAudioHide" onClick="showValidateAudio()">
<p class="textValidate">Validate Audio</p>
<p class="dropdown" style="float: right;margin-top: 7px;margin-right: 45px"></p>
</div>

<div id="validateAudioBlock" class ="validateAudioBlock">
  <div ng-app="validateAudio_App" ng-cloak>
	<div class="validateAudio_inner_table">
	  <div ng-controller="validateAudioCtrl" class="validateAudio_container">	
		<div id ="validateAudio">
		  <scrollable-table watch="visibleProjects">
			<table id="validateAudio_table" class="validateAudio_table_class">
			  <thead>
				<tr style="cursor: pointer;" onClick="hideValidateAudio()">
				  <th style="text-align: left;max-width: 10px" class="validateAudio_table_th" title=" ">Validate Audio</th>
				  <th title=" ">
				  		<div style="margin-top: 7px;margin-right: 36px;float:right;" class="dropdown"></div></th>
				</tr>
			  </thead>
			  <tbody>
				<tr>
					<td style="text-align:left;" class="validateAudio_table_td">
						Validate
					</td>
					<td style="text-align:left;max-width: 180px" class="validateAudio_table_td">
					<select multiple id="phoneValidate" style="cursor: pointer;width: 120px;padding: 5px;height: 85px;">
							<c:forEach var="res" items="${resources}">
								<option value="${res.id }">${res.name}	</option>
						 	</c:forEach>
						</select>
					</td>
				</tr>
			  </tbody>
			</table>
		  </scrollable-table>
		</div>
	  </div>	
	</div>
  </div>
	<button style="float: right;margin-right: 25px;margin-top: 5px" class="addValidateAudio"></button>
		
</div>

<script>
$(".addValidateAudio").click(function(e){
	var validateAudioId = [];
	$( "#validateAudioBlock #phoneValidate option:selected" ).each(function(){
		validateAudioId.push($(this).val());
	});
	if(validateAudioId.length == 0){
		bootbox.alert("Select atleast one phone to Validate Audio").find("div.modal-content").addClass("modalfailure");
		return false;
	}
	var data = "validateAudioId="+encodeURIComponent(validateAudioId);
		$.ajax({
			url : "addValidateAudio",
			data : data,
			type : "POST",
			success : function(resp) {
				$("#enteredActions_table tbody tr").remove(); 
				for(var i=0; i<resp['entered_actions'].length;i++){
					$('<tr id=\"'+i+'\">').html(
							"<td id=\"idCheck"+i+"\" style=\"width:25px;padding-left:5px\">"+"<input type=\"checkbox\" name=\"checkAction\" value="+i+"></td>"+
					        "<td id=\"idText"+i+"\" style="+"\"text-align:left;padding-left:10px\" "+"class="+"\"enteredActions_table_td\""+">" 
					        	+ resp['entered_actions'][i] + "</td>").appendTo('#enteredActions_table');
				}
	   			$('.enteredActionsBlock .scrollArea').scrollTop($('.enteredActionsBlock .scrollArea')[0].scrollHeight);
	   			$("#validateAudioBlock #phoneValidate option:selected").removeAttr("selected");
			},
			error : function(xhr, status, error) {
				bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
			}
		});
});
</script>
