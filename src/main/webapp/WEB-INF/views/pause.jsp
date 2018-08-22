<link rel="stylesheet" href="<c:url value="/resources/css/pause.css"/>"/>

<div id="pauseHide" class="pauseHide" onClick="showPause()">
<p class="textValidate">Pause</p>
<p class="dropdown" style="float: right;margin-top: 7px;margin-right: 45px"></p>
</div>

<div id="pauseBlock" class ="pauseBlock">
  <div ng-app="pause_App" ng-cloak>
	<div class="pause_inner_table">
	  <div ng-controller="pauseCtrl" class="pause_container">	
		<div id ="pause">
		  <scrollable-table watch="visibleProjects">
			<table id="pause_table" class="pause_table_class">
			  <thead>
				<tr style="cursor: pointer;" onClick="hidePause()">
				  <th style="text-align: left;max-width: 10px" class="pause_table_th" title=" ">Pause</th>
				  <th title=" ">
				  		<div style="margin-top: 7px;margin-right: 32px;float:right;" class="dropdown"></div></th>
				</tr>
			  </thead>
			  <tbody>
				<tr>
					<td style="text-align:left;max-width: 180px" class="pause_table_td">Enter Pause Value(In Seconds)</td>
				</tr>
				<tr>
					<td style="text-align:left;" class="pause_table_td">
						<input type="number" id="pause_input" name="pause_input" class="pause_input" value="1" 
							ng-keypress="onEnter($event)" onfocus="this.value = this.value;">
					</td>
				</tr>
				<tr>
					<td style="text-align:left;max-width: 180px" class="pause_table_td">(Between 1 and 3600)</td>
				</tr>
			  </tbody>
			</table>
		  </scrollable-table>
		</div>
	  </div>	
	</div>
  </div>
	<button style="float: right;margin-right: 25px" class="addPause"></button>
		
</div>

<script>
$(".addPause").click(function(e){
	var pause = parseInt($("#pause_input").val().trim());
	if(pause>0 && pause<3600){
		var data = "pause="+encodeURIComponent($("#pause_input").val().trim());
		$.ajax({
			url : "addPause",
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
			},
			error : function(xhr, status, error) {
				bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
			}
		});
	}
	else{
		bootbox.alert("Invalid Value. Pause Value Should be between 1 and 3600 seconds.").find("div.modal-content").addClass("modalfailure");
	}
});
</script>
