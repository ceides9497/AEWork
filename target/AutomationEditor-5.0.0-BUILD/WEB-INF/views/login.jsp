<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Automation Editor</title>
	<%@include file="importLinks.jsp" %>
	<link rel="stylesheet" href="<c:url value="/resources/css/home.css"/>"/>
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

	<div class="input_form">

		<form id="login" action="j_spring_security_check" method="POST" name="f" onsubmit="javascript:adddate()">

			<script type="text/javascript">
				function adddate() {
				$("#jdate").attr("value", new Date());
				}
			</script>
	
			<label class="form_text">Login ID:</label>
				<input type="text" id="j_username" name="j_username" class="form_input_box">
						
			<label class="form_text">Password:</label>
				<input type="password" id="j_password" name="j_password" class="form_input_box">
							
			<input class="login_button" type="submit">
		<!-- 	<a style="text-decoration: none;" href="changepassword" class="change_password">Change Password?</a> -->
			<a style="text-decoration: none;" class="change_password" onclick="forgetPassword()">Forgot Password?</a>
			<input id="jdate" type="hidden" name="jdate" value="" />
		</form>

		<c:if test ="${loginError}">
		<div style="color:tomato;font-weight: 600;font-size: 16px;text-align: right;">Invalid Email Address or Password. Please try again.</div>
		</c:if>
		
		<div id="forgotPassword" style="display: none;">
			<div style="color:tomato;padding-top:25px; text-align: center;font-weight: 600;font-size: 16px">Please contact your designated Admin or contact tekVizion at info@tekVizion.com	</div>
		</div>
		
	</div>

</div>
<div id="footer">
</div>

</div>

</body>

<script>
function forgetPassword() {
	 document.getElementById('forgotPassword').style.display='block';
}
</script>
</html>