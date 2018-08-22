<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<meta http-equiv="cache-control" content="no-cache">
	<title>Automation Editor</title>
	<%@include file="importLinks.jsp" %>
	<link rel="stylesheet" href="<c:url value="/resources/css/home.css"/>"/>
		<link rel="stylesheet" href="<c:url value="/resources/css/testCases.css"/>"/>
</head>
<body class="baseContainer">

<div id="wrapper">

<div style="padding-left: 40px">
<a href="http://www.tekvizion.com/"><img style="width:150px;height:32px;cursor: pointer;" src="<c:url value="/resources/images/home/TekVizion Logo.png"/>"></a>

</div>
<div class="upper_top_bar">

	<div class="automation_text">Automation Editor</div>
	
</div>

<div id="content">

<div ng-app="actionButtons_App" ng-cloak></div>
<div class="buttonsDiv" style="width:100%;height:35px;float: left;color: #1414a4;font-weight: 400;font-size: 23px;margin-left: 35px">
	<a href="./"><button title="Back to TestCase Editor" class="backButton"></button></a>
</div>
<div style="float: left;padding-left: 35px;padding-top: 0px">
	<div style="color: #1414a4;font-weight: 400;font-size: 23px;padding: 10px">
		List Of Test Cases for Test Plan : <text style="color:#818181"> ${testPlan.name }</text>
	</div>
<div id="testCasesBlock" class ="testCasesBlock">
  <div ng-app="testCases_App" ng-cloak>
	<div class="testCases_inner_table">
	  <div ng-controller="testCasesCtrl" class="testCases_container">	
		<div id ="testCases">
		  <scrollable-table watch="visibleProjects">
			<table id="testCases_table" class="testCases_table_class table-striped">
			  <thead>
				<tr>
				  <th style="text-align: left" class="testCases_table_th">TC ID</th>
				  <th style="text-align: left" class="testCases_table_th">Test Case Name</th>
				  <th style="text-align: left" class="testCases_table_th">Description</th>
				  <th style="text-align: left" class="testCases_table_th">Auto</th>
				  <th style="text-align: left" class="testCases_table_th">Status</th>
				</tr>
			  </thead>
			  <tbody>
			   <c:choose>
		  	 <c:when test="${error == true }">
			  	 	<div style="text-align:center;padding-top:50px;font-family:'Source Sans Pro';font-weight:400;font-size:18px;color:crimson;">
					Couldn't Access the Test Cases.
				  </div>
			  	 </c:when>
			  	 <c:otherwise>
			 	 <c:forEach var="tc" items="${wsTestCases}">
					<tr>
						<td style="text-align:left;min-width:50px;max-width: 50px" class="testCases_table_td">${tc.testCaseId}</td>
						<td style="text-align:left;padding-right:10px;min-width:200px;max-width: 200px" class="testCases_table_td">
							<u class="tcTitle" style="cursor: pointer;color:#337ab7">${tc.title}</u></td>
						<td style="text-align:left;padding-right:10px;min-width:250px;max-width: 250px" class="testCases_table_td">${tc.description}</td>
						<td style="text-align:left;padding-right:10px;min-width:30px;max-width: 30px" class="testCases_table_td">${tc.auto}</td>
						<td style="text-align:left;padding-right:0px;min-width:25px;max-width: 25px" class="testCases_table_td">
							<c:if test="${tc.automationStatus==''}">
								UD
							</c:if>
							<c:if test="${tc.automationStatus!=null}">
								${tc.automationStatus}
							</c:if>
						</td>
						<td style="display: none">${tc.id}</td>
						<td style="display: none">${testPlan.id}</td>
						<td style="text-align: right;min-width:40px;max-width: 40px"><a href="testCaseEditor?tcId=${tc.id}&tpId=${testPlan.id}"><button class="editTc"></button></a></td>
					</tr>
				</c:forEach>
				</c:otherwise>
				</c:choose>
			  </tbody>
			</table>
		  </scrollable-table>
		</div>
	  </div>	
	</div>
  </div>
</div>


<!-- Modal to show test case details -->
	<div class="modal fade" id="testCaseDetails" role="dialog">
	  <div class="modal-dialog" style="margin-top: 200px;position:relative;width: 600px;height:585px;margin-bottom: 0px;">
		<!-- Modal content-->
		<div class="modal-content" style="height: inherit;">
		  <div class="modal-body" style="padding:0px;">
		  <div id="tcDetailsResult">
		  </div>
		  </div>
		</div>
	  </div>
	</div>
<!-- /.modal -->

	
	</div>
	
	<div style="color: #1414a4;font-weight: 400;font-size: 16px;padding-left: 35px;float: left;width:90% ">
	Total Number Of Test Cases : ${totalTestcases }
	<div style="float:right;padding-right:20px">  UD : ${UDcount} <text style="padding-left:40px">GA : ${GAcount}</text> </div>
	</div>
	
<div id="footer">
</div>
</div>
</div>
<script>angular.bootstrap(document.getElementById("testCasesBlock"), ['testCases_App']);</script>
</body>
<script>

$('.editTc').click(function () {
	$.blockUI({ message: '<img src="resources/images/loading.gif" />' });
});

$('.tcTitle').click(function () {
	$.blockUI({ message: '<img src="resources/images/loading.gif" />' });
	var tr = $(this).closest('tr');
	var tcID= $.trim(tr.find('td').eq(5).text());
	var tpID= $.trim(tr.find('td').eq(6).text());
	var data = "tcId="+encodeURIComponent(tcID)+"&tpId="+encodeURIComponent(tpID);
	
	 $.ajax({
			url : "testCaseDetails",
			data : data,
			type : "GET",

			success : function(result) {
				$.unblockUI();
				$('#testCaseDetails').modal('show');
				 $("#tcDetailsResult").html(result);
			},
			error : function(xhr, status, error) {
				$.unblockUI();
				if(error=="Not Found"){
					bootbox.alert("Session Expired..Please Login again..",function(){window.location = "login";
					}).find("div.modal-content").addClass("modalfailure");
				}
				else{
					bootbox.alert("Error occurred. Contact Tekvizion for support").find("div.modal-content").addClass("modalfailure");
				}
			}
		});
});
</script>
</html>