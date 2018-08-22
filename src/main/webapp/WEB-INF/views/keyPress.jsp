<link rel="stylesheet" href="<c:url value="/resources/css/keyPress.css"/>"/>

<div id="keyPressHide" class="keyPressHide" onClick="showKeyPress()">
<p class="textValidate">Key Press</p>
<p class="dropdown" style="float: right;margin-top: 7px;margin-right: 45px"></p>
</div>

<div id="keyPressBlock" class ="keyPressBlock">
  <div ng-app="keyPress_App" ng-cloak>
	<div class="keyPress_inner_table">
	  <div ng-controller="keyPressCtrl" class="keyPress_container">	
		<div id ="keyPress">
		  <scrollable-table watch="visibleProjects">
			<table id="keyPress_table" class="keyPress_table_class">
			  <thead>
				<tr style="cursor: pointer;" onClick="hideKeyPress()" >
				  <th style="text-align: left" class="keyPress_table_th" title=" ">Key Press</th>
				  <th title =" ">
				  	<div style="margin-top: 7px;margin-right: 32px;float: right;" class="dropdown" ></div></th>
				</tr>
			  </thead>
			  <tbody>
				<tr>
					<td style="text-align:left;" class="keyPress_table_td">Phone</td>
					<td style="text-align:left;" class="keyPress_table_td">
						<select id="phoneKeyPress" style="cursor: pointer;width: 100px">
							<c:forEach var="res" items="${resources}">
								<option value="${res.id }">${res.name}	</option>
						 	</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td style="text-align:left;padding-top: 5px" class="keyPress_table_td">Line</td>
					<td style="text-align:left;padding-top: 5px" class="keyPress_table_td">
						<button style="margin-right: 10px" id="Line1" onClick="keyPress_click(this.id)" class="lineNo">Line1</button>
						<button id="Line2" onClick="keyPress_click(this.id)" class="lineNo">Line2</button>
						<!-- 
						<br><br>
						<button style="margin-right: 10px" id="Line3" onClick="keyPress_click(this.id)" class="lineNo">Line3</button>
						<button id="Line4" onClick="keyPress_click(this.id)" class="lineNo">Line4</button>
						 -->
					</td>
				</tr>	
				<tr>
					<td style="text-align:left;" class="keyPress_table_td"></td>
					<td style="text-align:left;" class="keyPress_table_td">
						<button style="margin-right: 10px;background-color: lavender" id="Handsfree" onClick="keyPress_click(this.id)" class="lineNo">HandsFree</button>
					</td>
				</tr>
				<tr>
					<td style="text-align:left;padding-top: 5px" class="keyPress_table_td">Soft Key</td>
					<td style="text-align:left;padding-top: 5px" class="keyPress_table_td">
						<button style="margin-right: 5px" id="SoftKey1" onClick="keyPress_click(this.id)" class="softKey">1</button>
						<button style="margin-right: 5px" id="SoftKey2" onClick="keyPress_click(this.id)" class="softKey">2</button>
						<button style="margin-right: 5px" id="SoftKey3" onClick="keyPress_click(this.id)" class="softKey">3</button>
						<button style="margin-right: 5px" id="SoftKey4" onClick="keyPress_click(this.id)" class="softKey">4</button>
						<button id="SoftKey5" onClick="keyPress_click(this.id)" class="softKey">5</button>
					</td>
				</tr>
				<tr>
					<td style="text-align:left;padding-top: 5px" class="keyPress_table_td">KeyPad </td>
					<td style="text-align:left;padding-top: 5px" class="keyPress_table_td">
						<button style="margin-right: 10px" id="Dialpad1" onClick="keyPress_click(this.id)" class="dialpadKey">1</button>
						<button style="margin-right: 10px" id="Dialpad2" onClick="keyPress_click(this.id)" class="dialpadKey">2</button>
						<button id="Dialpad3" onClick="keyPress_click(this.id)" class="dialpadKey">3</button><br><br>
						<button style="margin-right: 10px" id="Dialpad4" onClick="keyPress_click(this.id)" class="dialpadKey">4</button>
						<button style="margin-right: 10px" id="Dialpad5" onClick="keyPress_click(this.id)" class="dialpadKey">5</button>
						<button id="Dialpad6" onClick="keyPress_click(this.id)" class="dialpadKey">6</button><br><br>
						<button style="margin-right: 10px" id="Dialpad7" onClick="keyPress_click(this.id)" class="dialpadKey">7</button>
						<button style="margin-right: 10px" id="Dialpad8" onClick="keyPress_click(this.id)" class="dialpadKey">8</button>
						<button id="Dialpad9" onClick="keyPress_click(this.id)" class="dialpadKey">9</button><br><br>
						<button style="margin-right: 10px" id="DialpadStar" onClick="keyPress_click(this.id)" class="dialpadKey">*</button>
						<button style="margin-right: 10px" id="Dialpad0" onClick="keyPress_click(this.id)" class="dialpadKey">0</button>
						<button id="DialpadPound" onClick="keyPress_click(this.id)" class="dialpadKey">#</button>
					</td>
				</tr>	
			  </tbody>
			</table>
			<div id="keyPressBlock1" class ="keyPressBlock1">
			<div class="keyPress_inner_table1">
				<div id ="keyPress1">
					  <scrollable-table watch="visibleProjects">
						<table id="keyPress_table1" class="keyPress_table_class">
						<tbody>
						</tbody>
						</table>
					</scrollable-table>
				</div>
			</div>
			</div>
		  </scrollable-table>
		</div>
	  </div>	
	</div>
  </div>
  	<button style="margin-left: 0px;float: right;margin-right: 5px" class="deleteKeyPress"></button>
	<button style="float: right;margin-right: 5px" class="addKeyPress"></button>
	<button style="float: left;" class="up"></button>
	<button style="float: left;margin-left: 5px" class=down></button>
	
</div>


<script>
function keyPress_click(id){
	var key = id;
	var data = "keyPressed="+encodeURIComponent(key);
	$.ajax({
		type : 'POST',
		data : data,
		url : 'keyPressArray',
		success : function(response) {
			$("#keyPress_table1 tbody tr").remove(); 
			for(var i=0; i<response['keyPressArray'].length;i++){
				$('<tr id=\"'+i+'\">').html(
				"<td id=\"idKeyCheck"+i+"\" style=\"width:25px;padding-left:5px;\">"+"<input type=\"checkbox\" style=\"margin-top: 0px;\" name=\"checkKeyPress\" value="+i+"></td>"+
			    "<td id=\"idKeyText"+i+"\" style="+"\"text-align:left;padding-left:5px\" "+"class="+"\"keyPress_table1_td\""+">" 
			   	+ response['keyPressArray'][i] + "</td>").appendTo('#keyPress_table1');
			}
			$('.keyPressBlock1 .scrollArea').scrollTop($('.keyPressBlock1 .scrollArea')[0].scrollHeight);
		},
		error : function(xhr, status, error) {
			bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
		}
	});
}

$(".addKeyPress").click(function(e){
	var phoneId = $( "#phoneKeyPress option:selected" ).val();
	var data="phoneId="+encodeURIComponent(phoneId);
	$.ajax({
		type : 'POST',
		url : 'addkeyPress',
		data : data,
		success : function(resp) {
			if(resp!=""){
				$("#enteredActions_table tbody tr").remove(); 
				$("#keyPress_table1 tbody tr").remove(); 
				for(var i=0; i<resp['entered_actions'].length;i++){
					$('<tr id=\"'+i+'\">').html(
							"<td id=\"idCheck"+i+"\" style=\"width:25px;padding-left:5px\">"+"<input type=\"checkbox\" name=\"checkAction\" value="+i+"></td>"+
					        "<td id=\"idText"+i+"\" style="+"\"text-align:left;padding-left:10px\" "+"class="+"\"enteredActions_table_td\""+">" 
					        	+ resp['entered_actions'][i] + "</td>").appendTo('#enteredActions_table');
				}
	   			$('.enteredActionsBlock .scrollArea').scrollTop($('.enteredActionsBlock .scrollArea')[0].scrollHeight);
			}
			else{
				bootbox.alert("No Key Pressed to Add.").find("div.modal-content").addClass("modalfailure");
			}
		},
		error : function(xhr, status, error) {
			bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
		}
	});
});

$('.deleteKeyPress').click(function () {
	if(jQuery('#keyPress_table1 input[type=checkbox]:checked').length!=0) { 
		bootbox.confirm({
		    buttons: {
		    	confirm: {
		    		label: 'YES',
	        	},
		        cancel: {
		            label: 'NO',
		        }
		    },
		    message: 'Are you sure want to delete these KeyPress?',
		    callback: function(result) {
		    	if(result) {
			    	var chk = [];
					$('#keyPress_table1 input[type=checkbox]:checked').each(function() {
						chk.push($(this).val());
					});
					var data='ids='+encodeURIComponent(chk);
					$.ajax({
						type : 'POST',
						data: data,
						url : 'deleteKeyPressArray',
						success : function(response) {
							$("#keyPress_table1 tbody tr").remove(); 
							for(var i=0; i<response['keyPressArray'].length;i++){
								$('<tr id=\"'+i+'\">').html(
								"<td id=\"idKeyCheck"+i+"\" style=\"width:25px;padding-left:5px\">"+"<input type=\"checkbox\" name=\"checkKeyPress\" value="+i+"></td>"+
							    "<td id=\"idKeyText"+i+"\" style="+"\"text-align:left;padding-left:5px\" "+"class="+"\"keyPress_table1_td\""+">" 
							   	+ response['keyPressArray'][i] + "</td>").appendTo('#keyPress_table1');
							}
							$('.keyPressBlock1 .scrollArea').scrollTop($('.keyPressBlock1 .scrollArea')[0].scrollHeight);
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

$('.keyPressBlock .up').click(function () {
	c = false;
	$(".keyPressBlock1 table tbody tr").each(function(i, row){
		if($(this).hasClass('selected'))
			c = true;
	});
	if(selectedKeyPressRowId!=0 && c == true){
		var id = selectedKeyPressRowId;
		var data='id='+encodeURIComponent(selectedKeyPressRowId);
		$.ajax({
			type : 'POST',
			data: data,
			url : 'keyPressUp',
			success : function(resp) {
				$("#keyPress_table1 tbody tr").remove(); 
				for(var i=0; i<resp['keyPressArray'].length;i++){
					$('<tr id=\"'+i+'\">').html(
							"<td id=\"idKeyCheck"+i+"\" style=\"width:25px;padding-left:5px\">"+"<input type=\"checkbox\" name=\"checkKeyPress\" value="+i+"></td>"+
						    "<td id=\"idKeyText"+i+"\" style="+"\"text-align:left;padding-left:5px\" "+"class="+"\"keyPress_table1_td\""+">" 
						   	+ resp['keyPressArray'][i] + "</td>").appendTo('#keyPress_table1');
				}
	   			$('.keyPressBlock1 .scrollArea').scrollTop($('.keyPressBlock1 .scrollArea')[0].scrollHeight);
	   			
				selectedKeyPressRowId = selectedKeyPressRowId-1;
				var trId = "#"+selectedKeyPressRowId;
				$(".keyPressBlock1 table tbody tr").each(function(i, row){
					$(this).removeClass('selected');
				});		
				$('.keyPressBlock1').find(' '+trId).addClass('selected');		
			},
			error : function(xhr, status, error) {
				bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
			}
		});
	}
});

$('.keyPressBlock .down').click(function () {
	c = false;
	var rowCount = $('#keyPress_table1 tr').length;
	$(".keyPressBlock1 table tbody tr").each(function(i, row){
		if($(this).hasClass('selected'))
			c = true;
	});
	if(parseInt(selectedKeyPressRowId)+1!=rowCount && c == true){
		var id = selectedKeyPressRowId;
		var data='id='+encodeURIComponent(selectedKeyPressRowId);
		$.ajax({
			type : 'POST',
			data: data,
			url : 'keyPressDown',
			success : function(resp) {
				$("#keyPress_table1 tbody tr").remove(); 
				for(var i=0; i<resp['keyPressArray'].length;i++){
					$('<tr id=\"'+i+'\">').html(
							"<td id=\"idKeyCheck"+i+"\" style=\"width:25px;padding-left:5px\">"+"<input type=\"checkbox\" name=\"checkKeyPress\" value="+i+"></td>"+
						    "<td id=\"idKeyText"+i+"\" style="+"\"text-align:left;padding-left:5px\" "+"class="+"\"keyPress_table1_td\""+">" 
						   	+ resp['keyPressArray'][i] + "</td>").appendTo('#keyPress_table1');
				}
	   			$('.keyPressBlock1 .scrollArea').scrollTop($('.keyPressBlock1 .scrollArea')[0].scrollHeight);
	   			
				selectedKeyPressRowId = parseInt(selectedKeyPressRowId)+1;
				var trId = "#"+selectedKeyPressRowId;
				$(".keyPressBlock1 table tbody tr").each(function(i, row){
					$(this).removeClass('selected');
				});		
				$('.keyPressBlock1').find(' '+trId).addClass('selected');	
			},
			error : function(xhr, status, error) {
				bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
			}
		});
	}
});


</script>
