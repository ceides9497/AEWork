<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${error == true }">
		<div style="text-align:center;padding-top:50px;font-family:'Source Sans Pro';font-weight:400;font-size:18px;color:crimson;">
		Couldn't Access the Test Plans.
		</div>
	</c:when>
	<c:otherwise>
	<div style="padding-left: 25px;padding-top: 25px;height: 92%">
	  <div class="sideHeading" style="height: 30px !important;">
	  	Test Plan :  
	  </div>
	  <div class="leftData" style="height: 30px !important;"> 	
	  	${tpDetails.name }
	  </div>
	  <div class="sideHeading" style="height: 30px !important;">
	  	Test Case :  
	  </div>
	  <div class="leftData" style="height: 30px !important;"> 	
	  	${tcDetails.title }
	  </div>
	  <div class="sideHeading"  style="height: 87px !important;">
	  	Description :  
	  </div>
	  <div class="leftData" style="height: 87px !important;">
		<textarea class="textArea" style="height: 85px !important;" readonly="true">${tcDetails.description }</textarea>
	  </div>
	  <div class="sideHeading" style="margin-top: 10px">
	  	Procedure :  
	  </div>
	  <div class="leftData" style="margin-top: 10px">
		<textarea class="textArea" readonly="true">${tcDetails.proceedure }</textarea>
	  </div>
	  <div class="sideHeading" style="margin-top: 15px">
	  	Expected Results :  
	  </div>
	  <div class="leftData" style="margin-top: 15px">
		<textarea class="textArea" readonly="true">${tcDetails.expectedResults }</textarea>
	  </div>
	  <br><br>
	</div>
	</c:otherwise>
</c:choose>
<div class="exit_modal_button" data-dismiss="modal"></div>
</body>
</html>