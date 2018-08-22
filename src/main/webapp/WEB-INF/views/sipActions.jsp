<link rel="stylesheet" href="<c:url value="/resources/css/sipActions.css"/>"/>

<style type="text/css">
@-moz-document url-prefix() {
    .downloadScript {
        margin-top : -20px;
    }
}
</style>

<div id="enteredActionsBlock" class ="enteredActionsBlock">
  <div ng-app="enteredActions_App" ng-cloak>
	<div class="enteredActions_inner_table">
	  <div ng-controller="enteredActionsCtrl" class="enteredActions_container">	
		<div id ="enteredActions">
		  <scrollable-table watch="visibleProjects">
			<table id="enteredActions_table" class="enteredActions_table_class table-striped">
			  <thead>
				<tr>
				  <th style="text-align: left" class="enteredActions_table_th" title=" ">
				  	Entered Actions  	
				  	<div style="float: right;"><button class="downloadScript" onclick="downloadScript()"></button></div>
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