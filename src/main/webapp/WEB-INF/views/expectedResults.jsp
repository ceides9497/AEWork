<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Expected Results</title>
<style type="text/css">
	.textFormat{
		border: none;
		width: 400px;
		height: 300px;
		background-color: transparent;;
		font-family: 'Source Sans Pro';
		font-weight:400;
		font-size: 14px;
		color: #818181;
		line-height: 35px;
		resize : none;
		overflow : auto;
	}
	textarea, input { outline: none; }
</style>
</head>
<body>

<h4 style="color:#1414a4">
Test Case : <text style="color:#818181">${testCase.title }</text> <br></br>
Test Plan :  <text style="color:#818181">${testPlan.name }</text><br></br>
Expected Results</h4>
<textarea class="textFormat" readonly="true">${testCase.expectedResults}</textarea>

</body>
</html>