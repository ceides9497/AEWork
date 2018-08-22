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
		<link rel="stylesheet" href="<c:url value="/resources/css/testPlans.css"/>"/>
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
	<div style="float: left;padding-left: 35px;padding-top: 20px">
	<div style="color: #1414a4;font-weight: 400;font-size: 23px;padding: 10px">List Of Test Plans</div>

<div id="testPlansBlock" class ="testPlansBlock">
  <div ng-app="testPlans_App" ng-cloak>
	<div class="testPlans_inner_table">
	  <div ng-controller="testPlansCtrl" class="testPlans_container">	
		<div id ="testPlans">
		  <scrollable-table watch="visibleProjects">
			<table id="testPlans_table" class="testPlans_table_class table-striped">
			  <thead>
				<tr>
				  <th style="text-align: left;padding-left: 10px!important" class="testPlans_table_th">Plan Name</th>
				  <th style="text-align: left" class="testPlans_table_th">Program</th>
				  <th style="text-align: left" class="testPlans_table_th">Sub Program</th>
				  <th style="text-align: left" class="testPlans_table_th">Test Type</th>
				  <th style="text-align: left;padding-left: 20px!important" class="testPlans_table_th">Version</th>
				</tr>
			  </thead>
			  <tbody>
			  <c:choose>
			  	 <c:when test="${error == true }">
			  	 	<div style="text-align:center;padding-top:50px;font-family:'Source Sans Pro';font-weight:400;font-size:18px;color:crimson;">
					Couldn't Access the Test Plans.
				  </div>
			  	 </c:when>
			  	 <c:otherwise>
			 	 <c:forEach var="tp" items="${wsTestPlans}">
					<tr>
						<td style="text-align:left;padding-left:10px;min-width:230px;max-width: 230px" class="testPlans_table_td">
							<a class="planName" href="testCases?id=${tp.id}"><u>${tp.name}</u></a></td>
						<td style="text-align:left;min-width:120px;max-width: 120px" class="testPlans_table_td">${tp.program}</td>
						<td style="text-align:left;min-width:120px;max-width: 120px" class="testPlans_table_td">${tp.subProgram}</td>
						<td style="text-align:left;min-width:150px;max-width: 150px" class="testPlans_table_td">${tp.testType}</td>
						<td style="text-align:left;padding-left:20px;min-width:100px;max-width: 100px" class="testPlans_table_td">${tp.ver}</td>
						<td style="display: none" >${tp.id}</td>
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
	
	</div>
	<div style="color: #1414a4;font-weight: 400;font-size: 16px;padding-left: 35px;float: left;">
	Total Number Of Test Plans : ${totalTestplans } 
	</div>
<div id="footer">
</div>
</div>
</div>
<script>angular.bootstrap(document.getElementById("testPlansBlock"), ['testPlans_App']);</script>
</body>
<script>

$('.planName').click(function () {
	$.blockUI({ message: '<img src="resources/images/loading.gif" />' });
});

</script>
</html>