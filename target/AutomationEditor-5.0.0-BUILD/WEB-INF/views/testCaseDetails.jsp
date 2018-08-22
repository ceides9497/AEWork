<link rel="stylesheet" href="<c:url value="/resources/css/testCaseDetails.css"/>"/>

<div id="testCaseDetailsBlock" class ="testCaseDetailsBlock">
	<div class="sideHeadings">Test Case Id : &nbsp <text class="tcData"> ${testCase.testCaseId}</text></div>
	<div class="sideHeadings">Test Case : </div>
		<div class="tcData"><span>${testCase.title }</span></div>
	<div class="sideHeadings">Test Plan : </div>
		<div class="tcData"><span>${testPlan.name }</span></div>
	<div class="sideHeadings" style="cursor: pointer;"
	onclick="javascript:var w = window.open('./procedure', 'Procedure', 'width=500,height=600,scrollbars=yes,top=0,left=0');w.focus();">
		<u>Procedure</u> </div>
	<div class="sideHeadings" style="cursor: pointer;"
	onclick="javascript:var w = window.open('./expectedResults', 'Expected Results', 'width=600,height=500,scrollbars=yes,top=0,left=0');w.focus();">
	<u>Expected Results</u></div>
</div>