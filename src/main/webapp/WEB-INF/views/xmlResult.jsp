<link rel="stylesheet" href="<c:url value="/resources/css/xmlResult.css"/>"/>

<div id="xmlResultBlock" class ="xmlResultBlock">
  <div ng-app="xmlResult_App" ng-cloak>
	<div class="xmlResult_inner_table">
	  <div ng-controller="xmlResultCtrl" class="xmlResult_container">	
		<div id ="xmlResult">
		  <scrollable-table watch="visibleProjects">
			<table id="xmlResult_table" class="xmlResult_table_class table-striped">
			  <thead>
				<tr>
				  <th style="text-align: left" class="xmlResult_table_th" title=" ">Script Result</th>
				  <th style="text-align: left" class="xmlResult_table_th" title=" ">
				  <div style="float: right;"><input type="checkbox" class="idleCheck" name="idlePhones" checked>Idle Phones</div></th>
				  <th style="text-align: left" class="xmlResult_table_th" title=" ">
				  <div style="float: right;">	<button class="generateXML"></button></div> 
				  </th>
				</tr>
			  </thead>
			  <tbody>
				  <textarea id="script_xml" style="resize : none;" readonly="true"></textarea>
			  </tbody>
			</table>
		  </scrollable-table>
		</div>
	  </div>	
	</div>
  </div>
</div>