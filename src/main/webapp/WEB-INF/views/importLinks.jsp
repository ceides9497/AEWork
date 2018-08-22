<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="icon" type="image/png" href="resources/images/favicon.ico">

<!-- Load all external java script files -->
 
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script type="text/javascript" src="https://code.angularjs.org/1.3.9/angular.js"></script>

<script type="text/javascript" src="./resources/js/angular-scrollable-table.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>  
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="https://ajax.cdnjs.com/ajax/libs/json2/20110223/json2.js"></script>

<!-- Load all external and internal css files -->
<link rel="stylesheet" href="<c:url value="/resources/css/base.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/css/login.css"/>"/>
<link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,200,200italic,300,300italic,400italic,600,600italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Exo+2:400,300,200' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">  

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.blockUI/2.66.0-2013.10.09/jquery.blockUI.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.blockUI.js"/>"></script>
	
	<script type="text/javascript" src="<c:url value="/resources/js/enteredActions.js"/>"> </script> 	
	<script type="text/javascript" src="<c:url value="/resources/js/actionButtons.js"/>"> </script> 	
	<script type="text/javascript" src="<c:url value="/resources/js/testCaseDetails.js"/>"> </script>
	<script type="text/javascript" src="<c:url value="/resources/js/runResult.js"/>"> </script>
	<script type="text/javascript" src="<c:url value="/resources/js/xmlResult.js"/>"> </script>
	<script type="text/javascript" src="<c:url value="/resources/js/validate.js"/>"> </script>
	<script type="text/javascript" src="<c:url value="/resources/js/keyPress.js"/>"> </script>
	<script type="text/javascript" src="<c:url value="/resources/js/pause.js"/>"> </script>
	<script type="text/javascript" src="<c:url value="/resources/js/validateAudio.js"/>"> </script>
	
	<script type="text/javascript" src="<c:url value="/resources/js/testPlans.js"/>"> </script>
	<script type="text/javascript" src="<c:url value="/resources/js/testCases.js"/>"> </script>
	
	 	
	<script type="text/javascript" src="./resources/js/scrollableCode.js"></script>
	
		<script type="text/javascript" src="<c:url value="/resources/js/bootbox.min.js"/>"></script>
		
		<script src="<c:url value="/resources/js/sorttable.js" />"></script>
		<script src="./resources/js/jquery.tablesorter.js"></script>
		
<script type="text/javascript">
$.ajaxSetup({ cache: false });
</script>