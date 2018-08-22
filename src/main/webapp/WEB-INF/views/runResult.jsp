<link rel="stylesheet" href="<c:url value="/resources/css/runResult.css"/>"/>

<div style="width:65px;height:400px;float: left;">
 <button style="margin-left: 10px;margin-top: 185px;" class="runResult"></button>
</div>

<div id="runResultBlock" class ="runResultBlock">
  <div ng-app="runResult_App" ng-cloak>
	<div class="runResult_inner_table">
	  <div ng-controller="runResultCtrl" class="runResult_container">	
		<div id ="runResult">
		  <scrollable-table watch="visibleProjects">
			<table id="runResult_table" class="runResult_table_class table-striped">
			  <thead>
				<tr>
				  <th style="text-align: left" class="runResult_table_th">Run Result</th>
				</tr>
			  </thead>
			  <tbody>
			  </tbody>
			</table>
		  </scrollable-table>
		</div>
	  </div>	
	</div>
  </div>

</div>