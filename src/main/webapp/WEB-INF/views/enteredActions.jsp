<link rel="stylesheet" href="<c:url value="/resources/css/enteredActions.css"/>"/>

<div id="enteredActionsBlock" class ="enteredActionsBlock">
  <div ng-app="enteredActions_App" ng-cloak>
	<div class="enteredActions_inner_table">
	  <div ng-controller="enteredActionsCtrl" class="enteredActions_container">	
		<div id ="enteredActions">
		  <scrollable-table watch="visibleProjects">
			<table id="enteredActions_table" class="enteredActions_table_class table-striped">
			  <thead>
				<tr>
				  <th style="text-align: left;padding-left: 5px !important;width: 25px !important" class="enteredActions_table_th" title=" ">
				  	<input type="checkbox" class="select_all_actions">
				  </th>	
				  <th style="text-align: left;padding-left: 10px !important" class="enteredActions_table_th" title=" ">
				  	Entered Actions  	
				  </th>
				</tr>
			  </thead>
			  <tbody>
			  		<c:set var="count" value="0" scope="page" />
					<c:forEach var="entAct" items="${entAct.entered_actions}">
						<tr id="${count}">
						<td id="idCheck${count}" style="width:25px;padding-left:5px">
							<input type="checkbox" name="checkAction" value="${count}">
						</td>
						<td id="idText${count}" style="text-align:left;padding-left:10px" class="enteredActions_table_td">
							${entAct}
						</td>
						</tr>
					<c:set var="count" value="${count + 1}" scope="page"/>
					</c:forEach>			 
			  </tbody>
			</table>
		  </scrollable-table>
		</div>
	  </div>	
	</div>
  </div>
  
</div>

<!-- Modal for Comment box for Actions -->
	<div class="modal fade" id="comment_box_modal" role="dialog">
	  <div class="modal-dialog" style="margin-top: 325px;position:relative;width: 400px;height:140px;margin-bottom: 0px;">
		<!-- Modal content-->
		<div class="modal-content" style="height: inherit;">
		  <div class="modal-body" style="padding:0px;">
		  	<div style="padding:10px;">
		  	<div class="commentHeading">Comment </div>
			<textarea type="text" id="comment_desc" name="comment_desc" class="comment_box_input"></textarea>
			<button style="float: right;margin-left: 20px" class="cancelComment" data-dismiss="modal"></button>
			<button style="float: right" class="addComment"></button>
			</div>
		  </div>
		</div>
	  </div>
	</div>
<!-- /.modal -->

<script>

$('#comment_box_modal').on('shown.bs.modal', function () {
	$('#comment_desc').focus();
});

$("#comment_desc").keypress(function(event) {
    if (event.which == 13) {
        event.preventDefault();
        $('.addComment').click();
    }
});

$(".addComment").click(function(e){
	var data = "comment="+encodeURIComponent($("#comment_desc").val().trim());
	$.ajax({
		type : 'POST',
		data: data,
		url : 'addComment',
		success : function(resp) {
			$('#comment_box_modal').modal('hide');
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
});

$('#comment_box_modal').on('hidden.bs.modal', function (e) {
	$('#comment_desc').val(''); 
});
</script>