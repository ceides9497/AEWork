<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Cache-control" content="no-cache">
	<title>SIP Validation Editor</title>
	<script>
		var error = false;
		var error1 = false;
		var error2 = false;
	</script>
	
	<%@include file="importLinks.jsp" %>
	<link rel="stylesheet" href="<c:url value="/resources/css/home.css"/>"/>
	<link rel="stylesheet" href="<c:url value="/resources/css/sipeditor.css"/>"/>
	<link rel="stylesheet" href="<c:url value="/resources/css/testCases.css"/>"/>
	
	<style type="text/css">
        .head
        {
            /* for IE */
            filter: alpha(opacity=50);
            /* CSS 3 standard */
            opacity: 0.5;
        }
        .seperator
        {
            border-right: 1px solid #818181;
        }
    </style>
    <script src="resources/js/sdpexpressions.js" type="text/javascript"></script>
    <script src="resources/js/headerexpressions.js" type="text/javascript"></script>
    <script src="resources/js/xmlheaderexpressions.js" type="text/javascript"></script>
    <script type="text/javascript">
    selectedActionRowId = "";
    $(document).ready(function () {
        $("#mytabs").tabs({ fx: {opacity: 'toggle'} });
     });
        $(document).ready(function () {
            $('#btnQuery').click(function () {
                error = false;
                var con = getCondition('.query >table');
                if(con!=null){
	                var k = getQuery(con);
	                bootbox.alert(k).find("div.modal-content").addClass("modalalert");
                }
            });
            addqueryroot('.query', true);

            $('#headerBtnQuery').click(function () {
                error1 = false;
                var headercon = getHeaderCondition('.header_query >table');
                if(headercon!=null){
	                var k = getHeaderQuery(headercon);
	                bootbox.alert(k).find("div.modal-content").addClass("modalalert");
                }
            });
            addHeaderQueryRoot('.header_query', true);

            $('#xmlHeaderBtnQuery').click(function () {
                error2 = false;
                var xmlheadercon = getXmlHeaderCondition('.xml_header_query >table');
                if(xmlheadercon!=null){
	                var k = getXmlHeaderQuery(xmlheadercon);
	                bootbox.alert(k).find("div.modal-content").addClass("modalalert");
                }
            });
            addXmlHeaderQueryRoot('.xml_header_query', true);
            

            $("#sipValidateForm").submit(function(e) {
                e.preventDefault();
            });

            $('#sipValidateForm input').keypress(function(event){
                if (event.keyCode === 10 || event.keyCode === 13) 
                    event.preventDefault();
            });

            $("#rtpValidateForm").submit(function(e) {
                e.preventDefault();
            });

        	$('.enteredActionsBlock .scrollArea').scrollTop($('.enteredActionsBlock .scrollArea')[0].scrollHeight);

        	$('.enteredActionsBlock table tbody').delegate('tr', 'click' , function(){
        		var row = $(this);                 //cache the row

        	    if(!row.hasClass('selected')){
        	        row.addClass('selected')       //add class to clicked row
        	            .siblings()                //get the other rows
        	            .removeClass('selected');  //remove their classes
        	    }else{
        	    	$(this).removeClass('selected');
        		}
        		selectedActionRowId=this.id;	
        		 //selectedKeyPressRowId=$(this).attr("class").split(" ")[0];
        	});
        });
    </script>
</head>

<body class="baseContainer">

<div id="wrapper">

<div style="padding-left: 40px">
<a href="http://www.tekvizion.com/"><img style="width:150px;height:32px;cursor: pointer;" src="<c:url value="/resources/images/home/TekVizion Logo.png"/>"></a>

</div>
<div class="upper_top_bar">
	<div class="automation_text">Automation Editor</div>
	<ul class="settings_div">
		<!-- <li class="settings_text">User : ${userName}</li>  -->
		<!-- <c:if test="${!allActionEnable}"><a href="logout"><li class="settings_text logout_button">Logout</li></a></c:if> -->
	</ul>
</div>

<div id="content">

<div class="buttonsDiv" style="width:100%;height:35px;float: left;">
	<a href="editor"><button title="Back to TestCase Editor" class="backButton"></button></a>
	<div class="sip_testcase_heading">
		<div class="sideHeadings">Test Case ID : </div>
		<div class="tcData" style="width: 100px"><span>${testCase.testCaseId }</span></div>
		
		<div class="sideHeadings" title="View Test Case Details"><u class="testCaseModal" style="cursor: pointer;">Test Case : </u></div>
		<div class="tcData" style="width: 550px"><span>${testCase.title }</span></div>
	</div>
	<div id="help" title="Help"></div>
</div>

<div class="sipValidate">


<div style="background-color: #818181;font-size:15px;color:rgb(111,111,111);padding"></div>
<form id="sipValidateForm" style="height: 385px;margin-bottom: 0px">

	<div class="blockheading">SIP Validate</div>
	<div class="headerSpacer"></div>
	
	<div class="linespace">
		<div class="labelheader" >Action:</div>
		<select id="sip_action_id" style="cursor: pointer;width: 100px">
			<option>Check</option>
		</select>	
	</div>
	
	<div class="linespace">
		<div class="labelheader" >Method:</div>
		<select id="sip_method" style="cursor: pointer;width: 100px">
			<option>INVITE</option>
			<option>ACK</option>
			<option>CANCEL</option>
			<option>BYE</option>
			<option>PRACK</option>
			<option>SUBSCRIBE</option>
			<option>PUBLISH</option>
			<option>OPTIONS</option>
			<option>REGISTER</option>
			<option>INFO</option>
			<option>UPDATE</option>
			<option>NOTIFY</option>
			<option>MESSAGE</option>
			<option>REFER</option>
			<option value="INVITE | UPDATE">REINVITE/UPDATE</option>
		</select>	
	</div>
	
	<div class="linespace">
		<div class="labelheader" >From:</div>
		<select id="fromPhone" style="cursor: pointer;width: 100px">
			<option value="">SELECT</option>
			<c:forEach var="res" items="${resources}">
				<option value="${res.id }">${res.name}	</option>
		 	</c:forEach>
		</select>	
	</div>
	
	<div class="linespace" style="margin-left: 40px;">
		<div class="labelheader" style="width: 45px;">To:</div>
		<select id="toPhone" style="cursor: pointer;width: 100px">
			<option value="">SELECT</option>
			<c:forEach var="res" items="${resources}">
				<option value="${res.id }">${res.name}	</option>
		 	</c:forEach>
		</select>	
	</div>

	<div class="linespace">
		<div class="labelheader" >Source:</div>
		<select id="sourcePhone" style="cursor: pointer;width: 100px">
			<option value="">SELECT</option>
			<c:forEach var="res" items="${resources}">
				<option value="${res.id }">${res.name}	</option>
		 	</c:forEach>
		</select>	
	</div>
	
	<div class="linespace">
		<div class="labelheader" >Destination:</div>
		<select id="destinationPhone" style="cursor: pointer;width: 100px">
			<option value="">SELECT</option>
			<c:forEach var="res" items="${resources}">
				<option value="${res.id }">${res.name}	</option>
		 	</c:forEach>
		</select>	
	</div>
		
	<div class="linespace">
		<div class="labelheader">Type:</div>
		<input type="radio" name="msgtype" value="Request" checked> Request 
		<input type="radio" name="msgtype" value="Response" style="margin-left: 6px;"> Response
	</div>
	
	<div id="statusblock" class="linespace" style="margin-left: 40px"> 
		<div class="labelheader" style="width: 50px" >Status:</div>
		<input id="statusno" disabled style="width:50px ">
	</div>
	
	<div class="linespace">
		<div class="labelheader" >SDP:</div>
		<input type="radio" name="sdpheader" value="true" checked> True
		<input type="radio" name="sdpheader" value="false" style="margin-left:10px;"> False
	</div>
	
	<div class="linespace" style="float: right;;margin-right: 159px">
		<div class="labelheader">Desc:</div>
		<textarea id="sip_desc" style="width: 145px;height: 25px"></textarea> 
	</div>
	
	<div style="width: 775px;float: left;height: 235px;padding-left: 15px;padding-top: 5px">
		<ul class="tab">
		  <li><a id="sdpTab" class="tablinks active" onclick="openTab('Sdp')">SDP</a></li>
		  <li><a id="headersTab" class="tablinks" onclick="openTab('Headers')">HEADERS</a></li>
  		  <li style="width: 34%"><a id="xmlheadersTab" class="tablinks" onclick="openTab('Xml')" style="border: none">XML</a></li>
		</ul>

		<div id="Sdp" class="tabcontent" style="width: 760px;height: 203px;display: block;">
			<div id="sdpstatements" class="linespace" style="margin-top: 0px;margin-left: 5px">
				<div><input type="checkbox" name="sdpval" checked> SDP Value</div>
				<div id="sdpvalue_id" style="float: left;margin-top: 5px;width: 748px;height: 170px;outline: 1px solid #ccc;padding:5px;display: block ">
					<div style="float: left;width: 100%">
						<div id="btnQuery" title="Preview SDP Condition Statement" class="preview_sdp"></div>
					</div>
					<div style="float: left;width: 740px;height: 140px;overflow: auto">
						<div class="query"></div>
					</div>
				</div>
			</div>
		</div>
	
		<div id="Headers" class="tabcontent" style="width: 760px;height: 203px;display: none">
			<div id="headerstatements" class="linespace" style="margin-top: 0px;margin-left: 5px">
				<div><input type="checkbox" name="addHeaders">Add Headers</div>
				<div id="headers_value_id" style="float: left;margin-top: 5px;width: 748px;height: 170px;outline: 1px solid #ccc;padding:5px;display: none ">
					<div style="float: left;width: 100%">
						<button id="headerBtnQuery" title="Preview Headers Condition Statement" class="preview_headers"></button>
					</div>
					<div style="float: left;width: 735px;height: 140px;overflow: auto">
						<div class="header_query"></div>
					</div>
				</div>
			</div>
		</div>

		<div id="XmlHeaders" class="tabcontent" style="width: 760px;height: 203px;display: none">
			<div id="xmlstatements" class="linespace" style="margin-top: 0px;margin-left: 5px">
				<div><input type="checkbox" name="addXmlHeaders">Add XML Headers</div>
				<div id="xml_headers_value_id" style="float: left;margin-top: 5px;width: 748px;height: 170px;outline: 1px solid #ccc;padding:5px;display: none ">
					<div style="float: left;width: 100%">
						<button id="xmlHeaderBtnQuery" title="Preview XML Headers Condition Statement" class="preview_xml_headers"></button>
					</div>
					<div style="float: left;width: 735px;height: 140px;overflow: auto">
						<div class="xml_header_query"></div>
					</div>
				</div>
			</div>
		</div>
	
	</div>
	
	<button style="margin-left: 35px;float: right;margin-right: 15px" type="reset" class="resetSipValidate"></button>
	<button style="float: right;" class="addSipValidate"></button>

</form>
</div>

<div class="rtpValidate">
	<form id="rtpValidateForm">
		<div class="blockheading">RTP Validate</div>
		<div class="headerSpacer"></div>
		
		<div class="linespace">
			<div class="labelheader" >Action:</div>
			<select id="rtp_action_id" style="cursor: pointer;width: 100px">
				<option>Check</option>
			</select>	
		</div>
		
		<div class="linespace">
			<div class="labelheader" >From:</div>
			<select id="rtp_fromPhone" style="cursor: pointer;width: 100px">
				<option value="">SELECT</option>
				<c:forEach var="res" items="${resources}">
					<option value="${res.id }">${res.name}	</option>
			 	</c:forEach>
			</select>	
		</div>
		
		<div class="linespace">
			<div class="labelheader" >To:</div>
			<select id="rtp_toPhone" style="cursor: pointer;width: 100px">
				<option value="">SELECT</option>
				<c:forEach var="res" items="${resources}">
					<option value="${res.id }">${res.name}	</option>
			 	</c:forEach>
			</select>	
		</div>
		
		<div class="linespace">
		<div class="labelheader" style="width:150px" >Check Bi-direction:</div>
			<input type="checkbox" style="cursor: pointer;" name="bidirection">
		</div>
		
		<div class="linespace">
		<div class="labelheader" style="width:100px" >Payload Type:</div>
			<select id="payload_type_value" style="cursor: pointer;width: 170px;margin-top: 5px">
				<option value="">SELECT</option>
				<option>ITUT-T G.711 PCMU</option>
				<option>G.721</option>
				<option>GSM</option>
				<option>TELEPHONE EVENT</option>
				<option>G.723</option>
				<option>DVI4_8K</option>
				<option>DVI4_16K</option>
				<option>LPC</option>
				<option>ITUT-T G.711 PCMA</option>
				<option>G.722</option>
				<option>L16_2CH</option>
				<option>L16_1CH</option>
				<option>QCELP</option>
				<option>CN</option>
				<option>MPA</option>
				<option>G.728</option>
				<option>G.729</option>
				<option>CELB</option>
				<option>JPEG</option>
				<option>NV</option>
				<option>H261</option>
				<option>MPV</option>
				<option>MP2T</option>
				<option>H263</option>
			</select>
		</div>
		
		<div class="linespace">
		<div class="labelheader">Event:</div>
			<input id="event_id" style="width: 100px;"/>
		</div>	
		
		<div class="linespace">
		<div class="labelheader" style="width: 85px;">End Of Event:</div>
			<input type="radio" style="cursor: pointer;" name="endEvent" value="true">True
			<input type="radio" style="cursor: pointer;" name="endEvent" value="false">False
		</div>	
		
		<div class="linespace">
		<div class="labelheader" style="width:100px" >Description:</div>
			<textarea id="rtp_desc" style="width: 170px;;height: 40px;margin-top: 5px"></textarea>
		</div>	
		
		<div style="width: 100%;float: left; margin-left: 15px">
			<button class="addRtpValidate"></button>
			<button style="margin-left: 33px;" type="reset" class="resetRtpValidate"></button>
		</div>
		
	</form>
</div>

<%@include file="sipActions.jsp" %>

<div class="sipXmlBlock">
	<div class="blockheading">
		SIP Validate
		<button class="generateXML"></button>
	</div>
	<div class="headerSpacer"></div>
	<textarea id="script_xml" style="resize : none;" readonly="true"></textarea>
</div>

<div class="buttonsDiv" style="width:66%;height:35px;float: left;">
	<button style="margin-left: 5px;margin-top: 10px;" class="up"></button>
	<button style="margin-left: 0px;margin-top: 10px;" class="down"></button>
	<button style="margin-left: 0px;margin-top: 10px;" class="selectAll"></button>
	<button style="margin-left: 0px;margin-top: 10px;" class="de-selectAll"></button>
	<button style="margin-left: 0px;margin-top: 10px;" class="deleteActions"></button>
	<button style="margin-left: 0px;margin-top: 10px;" class="multiCheck"></button>
	<button style="margin-left: 0px;margin-top: 10px;" class="eitherCheck"></button>
	
	<div class="uploadSip"><input name="files" id="files" class="uploadTSip" type="file" ></div>
	<!-- <div class="saveSip"></div>-->
	
</div>
<div class="buttonsDiv" style="height:35px;float: left;color: #1414a4;font-weight: 600;font-size: 14px">
	<input type="checkbox" style="cursor: pointer;" class="markCompleted" name="markCompleted">Completed
</div>
<div class="buttonsDiv" style="width:26%;height:35px;float: left;">
	<button style="float: right;margin-right: 5px" class="saveXML"></button>
</div>
	
<!-- Modal to show test case details -->
<div class="modal fade" id="testCaseDetails" role="dialog">
  <div class="modal-dialog" style="margin-top: 275px;position:relative;width:600px;height:585px;margin-bottom: 0px;">
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

<!-- Modal to show test case details -->
<div class="modal fade" id="helpmodal" role="dialog">
  <div class="modal-dialog" style="margin-top: 200px;position:relative;width: 600px;height:510px;margin-bottom: 0px;">
	<!-- Modal content-->
	<div class="modal-content" style="height: inherit;">
	  <div class="modal-body" style="padding:0px;">
	  <div style="text-align: center;color: #1414a4;font-size: 20px;padding-top: 10px;font-weight: 600">HELP WINDOW</div>
	  <div id="helpdetails" style="padding: 30px;font-size: 16px;color: rgb(154,154,154);line-height: 25px;text-align: justify;">
	  	<b style="color: #1414a4">MULTI CHECK<br><br></b>
	  		Multi Check is the option to check the presence of multiple Sip Messages irrespective of the order they come in the capture file. <br><br>
	  		You can select 2 or more actions you want to check the presence and mark them as Multi Check and the test case passes only if all 
	  		these messages are present in the capture file irrespective of the order they come in. <br><br>
	  		
	  	<b style="color: #1414a4">EITHER CHECK<br><br></b>
	  		Either Check is the option to check the presence of atleast one of the Sip Message among multiple messages and is used to 
	  		check either of the messages.<br><br>
	  		You can select 2 or more actions and mark them as either check which implies the test case passes if atleast one of the 
	  		selected messages appear in the	capture file.<br><br>
	  </div>
	  </div>
	</div>
  </div>
</div>
<!-- /.modal -->

<div id="footer"></div>

</div>
</div>
</body>

<script>

$('input:radio[name="msgtype"]').change(function() {
    if ($(this).val() == 'Response') {
    	$('#statusno').removeAttr('disabled');
    } else {
    	$('#statusno').attr({'disabled': 'disabled'});
    }
});

$('input:radio[name="sdpheader"]').change(function() {
    if ($(this).val() == 'true') {
    	$('#sdpstatements').css("display","block");
    } else {
    	$('#sdpstatements').css("display","none");
    }
});

$(document).on('change', '.operator1', function() {
	var tr = $(this).closest('div');
	if($(this).val()=="COUNT"){
		tr.find('.input1').attr({'disabled': 'disabled'});
		tr.find('.operator2').css("display","block");
		tr.find('.parameter2').css("display","block");
		if(tr.find('.parameter2').val()=="Number"){
			tr.find('.input2').css("display","block");
			tr.find('.input2').val('');
			tr.find('.parameter3').css("display","none");
		}else{
			tr.find('.input2').css("display","none");
			tr.find('.parameter3').css("display","block");
		}
		tr.find('.input1').val('');
	}else{
		tr.find('.input1').removeAttr('disabled');
		tr.find('.operator2').css("display","none");
		tr.find('.parameter2').css("display","none");
		tr.find('.input2').css("display","none");
		tr.find('.parameter3').css("display","none");
	}
});

$(document).on('change', '.parameter2', function() {
	var tr = $(this).closest('div');
	if($(this).val()=="Number"){
		tr.find('.input2').css("display","block");
		tr.find('.input2').val('');
		tr.find('.parameter3').css("display","none");
	}else{
		tr.find('.input2').css("display","none");
		tr.find('.input2').val('');
		tr.find('.parameter3').css("display","block");
	}
});

$(document).on('click', '.remove_icon', function() {
	$(this).parent().remove();
});

$('input:checkbox[name="sdpval"]').change(function() {
    if(this.checked) {
    	$('#sdpvalue_id').css("display","block");
    } else {
    	$('#sdpvalue_id').css("display","none");
    }
});

$('input:checkbox[name="addHeaders"]').change(function() {
    if(this.checked) {
    	$('#headers_value_id').css("display","block");
    } else {
    	$('#headers_value_id').css("display","none");
    }
});

$('input:checkbox[name="addXmlHeaders"]').change(function() {
    if(this.checked) {
    	$('#xml_headers_value_id').css("display","block");
    } else {
    	$('#xml_headers_value_id').css("display","none");
    }
});

$('.addSipValidate').on('click',  function () {
	var action = $('#sip_action_id').val();
	var method = $('#sip_method').val();
	var from = $('#fromPhone').val();
	var to = $('#toPhone').val();
	var source = $('#sourcePhone').val();
	var destination = $('#destinationPhone').val();
	var msgType = $('input:radio[name="msgtype"]:checked').val();
	var sdp = $('input:radio[name="sdpheader"]:checked').val();
	var status = "";
	var sdpValue  = "";
	var headersValue  = "";
	var xmlHeadersValue  = "";
	var sipDesc  = $('#sip_desc').val();

	if(from == "" && to == ""){
		bootbox.alert("Please Specify atleast one FROM or TO phone.").find("div.modal-content").addClass("modalfailure");
		return;
	}

	if(source != "" && destination != ""){
		bootbox.alert("Please Specify ONLY SOURCE or ONLY DESTINATION.").find("div.modal-content").addClass("modalfailure");
		return;
	}

	if(sipDesc.trim()==""){
		bootbox.alert("Please Provide a Valid Description.").find("div.modal-content").addClass("modalfailure");
		return;
	}

	if(msgType=="Response"){
		status = $('#statusno').val();
		if(status.trim()==""){
			bootbox.alert("Please Provide a Valid STATUS Code for the Response Message.").find("div.modal-content").addClass("modalfailure");
			return;
		}
	}
	
	if(sdp=='true'){
		if ($('input:checkbox[name="sdpval"]').is(':checked')) {
		error = false;
		var con = getCondition('.query >table');
			if(con!=null){
				sdpValue = getQuery(con);
			}else{
				return;
			}
		}
	}
	
	if ($('input:checkbox[name="addHeaders"]').is(':checked')) {
		error1 = false;
		var headercon = getHeaderCondition('.header_query >table');
			if(headercon!=null){
				headersValue = getHeaderQuery(headercon);
			}else{
				return;
			}
		}
	if ($('input:checkbox[name="addXmlHeaders"]').is(':checked')) {
		  error2 = false;
          var xmlheadercon = getXmlHeaderCondition('.xml_header_query >table');
          if(xmlheadercon!=null){
        	  xmlHeadersValue = getXmlHeaderQuery(xmlheadercon);
          }else{
                return;
          }
		}
	
	var data =	'action='+encodeURIComponent(action)
				+'&method='+encodeURIComponent(method)
				+'&fromPhone='+encodeURIComponent(from)
				+'&toPhone='+encodeURIComponent(to)
				+'&sourcePhone='+encodeURIComponent(source)
				+'&destinationPhone='+encodeURIComponent(destination)
				+'&msgType='+encodeURIComponent(msgType)
				+'&status='+encodeURIComponent(status)
				+'&sdp='+encodeURIComponent(sdp)
				+'&sdpVal='+encodeURIComponent(sdpValue)
				+'&headersVal='+encodeURIComponent(headersValue)
				+'&xmlHeadersVal='+encodeURIComponent(xmlHeadersValue)
				+'&sipDesc='+encodeURIComponent(sipDesc);

	$.ajax({
		type : 'POST',
		data: data,
		url : 'addSipValidate',
		success : function(resp) {
			$("#enteredActions_table tbody tr").remove(); 
			for(var i=0; i<resp['entered_actions'].length;i++){
				$('<tr id=\"'+i+'\">').html(
						"<td id=\"idCheck"+i+"\" style=\"width:25px;padding-left:5px\">"+"<input type=\"checkbox\" name=\"checkAction\" value="+i+"></td>"+
				        "<td id=\"idText"+i+"\" style="+"\"text-align:left;padding-left:10px\" "+"class="+"\"enteredActions_table_td\""+">" 
				        	+ resp['entered_actions'][i] + "</td>").appendTo('#enteredActions_table');
			}
   			$('.enteredActionsBlock .scrollArea').scrollTop($('.enteredActionsBlock .scrollArea')[0].scrollHeight);
   			
			selectedActionRowId = parseInt(selectedActionRowId)+1;
			var trId = "#"+selectedActionRowId;
			$(".enteredActionsBlock table tbody tr").each(function(i, row){
				$(this).removeClass('selected');
			});		
			$('.enteredActionsBlock').find(' '+trId).addClass('selected');	

			$('.resetSipValidate').trigger("click");
		},
		error : function(xhr, status, error) {
			bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
		}
	});
});

$('.resetSipValidate').on('click',  function () {

	$("#sipValidateForm").trigger("reset");
	$('#sdpstatements').css("display","block");
	$('#sdpvalue_id').css("display","block");
	$('#headers_value_id').css("display","none");
	$('#xml_headers_value_id').css("display","none");

	openTab('Sdp');

	$('#statusno').attr({'disabled': 'disabled'});

	$('.query').empty();
	addqueryroot('.query', true);
});

$('.addRtpValidate').on('click',  function () {
	var action = $('#rtp_action_id').val();
	var from = $('#rtp_fromPhone').val();
	var to = $('#rtp_toPhone').val();
	var payloadtype = $('#payload_type_value').val();
	var bidir = false;
	var rtpDesc = $('#rtp_desc').val();
	var eventId = $('#event_id').val().trim();
	var endOfevent = $('input:radio[name="endEvent"]:checked').val();

	if(endOfevent!="true" && endOfevent!="false"){
		endOfevent= "";
	}

	if(from == "" && to == ""){
		bootbox.alert("Please Specify atleast one FROM or TO phone.").find("div.modal-content").addClass("modalfailure");
		return;
	}

	if(rtpDesc.trim()==""){
		bootbox.alert("Please Provide a Valid Description.").find("div.modal-content").addClass("modalfailure");
		return;
	}
	
	if ($('input:checkbox[name="bidirection"]').is(':checked')) {
		bidir = true;
	}
	var data =	'action='+encodeURIComponent(action)
				+'&fromPhone='+encodeURIComponent(from)
				+'&toPhone='+encodeURIComponent(to)
				+'&payloadType='+encodeURIComponent(payloadtype)
				+'&bidirection='+encodeURIComponent(bidir)
				+'&rtpDesc='+encodeURIComponent(rtpDesc)
				+'&eventId='+encodeURIComponent(eventId)
				+'&endOfevent='+encodeURIComponent(endOfevent);

	$.ajax({
		type : 'POST',
		data: data,
		url : 'addRtpValidate',
		success : function(resp) {
			$("#enteredActions_table tbody tr").remove(); 
			for(var i=0; i<resp['entered_actions'].length;i++){
				$('<tr id=\"'+i+'\">').html(
						"<td id=\"idCheck"+i+"\" style=\"width:25px;padding-left:5px\">"+"<input type=\"checkbox\" name=\"checkAction\" value="+i+"></td>"+
				        "<td id=\"idText"+i+"\" style="+"\"text-align:left;padding-left:10px\" "+"class="+"\"enteredActions_table_td\""+">" 
				        	+ resp['entered_actions'][i] + "</td>").appendTo('#enteredActions_table');
			}
   			$('.enteredActionsBlock .scrollArea').scrollTop($('.enteredActionsBlock .scrollArea')[0].scrollHeight);
   			
			selectedActionRowId = parseInt(selectedActionRowId);
			var trId = "#"+selectedActionRowId;
			$(".enteredActionsBlock table tbody tr").each(function(i, row){
				$(this).removeClass('selected');
			});		
			$('.enteredActionsBlock').find(' '+trId).addClass('selected');	

		 $("#rtpValidateForm").trigger("reset");
		},
		error : function(xhr, status, error) {
			bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
		}
	});
});

$('.deleteActions').click(function () {
	if(jQuery('#enteredActions_table input[type=checkbox]:checked').length!=0) { 
		bootbox.confirm({
		    buttons: {
		    	confirm: {
		    		label: 'YES',
	        	},
		        cancel: {
		            label: 'NO',
		        }
		    },
		    message: 'Are you sure want to delete these Actions?',
		    callback: function(result) {
		    	if(result) {
			    	var chk = [];
					$('#enteredActions_table input[type=checkbox]:checked').each(function() {
						chk.push($(this).val());
					});
					var data='ids='+encodeURIComponent(chk);
					$.ajax({
						type : 'POST',
						data: data,
						url : 'deleteSipActions',
						success : function(resp) {
							$("#enteredActions_table tbody tr").remove(); 
							for(var i=0; i<resp['entered_actions'].length;i++){
								$('<tr id=\"'+i+'\">').html(
										"<td id=\"idCheck"+i+"\" style=\"width:25px;padding-left:5px\">"+"<input type=\"checkbox\" name=\"checkAction\" value="+i+"></td>"+
								        "<td id=\"idText"+i+"\" style="+"\"text-align:left;padding-left:10px\" "+"class="+"\"enteredActions_table_td\""+">" 
								        	+ resp['entered_actions'][i] + "</td>").appendTo('#enteredActions_table');
							}
				   			$('.enteredActionsBlock .scrollArea').scrollTop($('.enteredActionsBlock .scrollArea')[0].scrollHeight);
						},
						error : function(xhr, status, error) {
							bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
						}
					});
		    	}
		    }
		}).find("div.modal-content").addClass("modalalert");
	}
});

$('.selectAll').click(function () {
	$('#enteredActions_table input[type=checkbox]').each(function() {
        this.checked = true;
	});
});

$('.de-selectAll').click(function () {
	$('#enteredActions_table input[type=checkbox]').each(function() {
        this.checked = false;
	});
});

$('.buttonsDiv .up').click(function () {
	c = false;
	$(".enteredActionsBlock table tbody tr").each(function(i, row){
		if($(this).hasClass('selected'))
			c = true;
	});
	if(selectedActionRowId!=0 && c == true){
		var id = selectedActionRowId;
		var data='id='+encodeURIComponent(selectedActionRowId);
		$.ajax({
			type : 'POST',
			data: data,
			url : 'sipActionUp',
			success : function(resp) {
				$("#enteredActions_table tbody tr").remove(); 
				for(var i=0; i<resp['entered_actions'].length;i++){
					$('<tr id=\"'+i+'\">').html(
							"<td id=\"idCheck"+i+"\" style=\"width:25px;padding-left:5px\">"+"<input type=\"checkbox\" name=\"checkAction\" value="+i+"></td>"+
					        "<td id=\"idText"+i+"\" style="+"\"text-align:left;padding-left:10px\" "+"class="+"\"enteredActions_table_td\""+">" 
					        	+ resp['entered_actions'][i] + "</td>").appendTo('#enteredActions_table');
				}
	   			$('.enteredActionsBlock .scrollArea').scrollTop($('.enteredActionsBlock .scrollArea')[0].scrollHeight);

				selectedActionRowId = selectedActionRowId-1;
				var trId = "#"+selectedActionRowId;
				$(".enteredActionsBlock table tbody tr").each(function(i, row){
					$(this).removeClass('selected');
				});		
				$('.enteredActionsBlock').find(' '+trId).addClass('selected');		
			},
			error : function(xhr, status, error) {
				bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
			}
		});
	}
});

$('.buttonsDiv .down').click(function () {
	c = false;
	var rowCount = $('#enteredActions_table tr').length-1;
	$(".enteredActionsBlock table tbody tr").each(function(i, row){
		if($(this).hasClass('selected'))
			c = true;
	});
	if(parseInt(selectedActionRowId)+1!=rowCount && c == true){
		var id = selectedActionRowId;
		var data='id='+encodeURIComponent(selectedActionRowId);
		$.ajax({
			type : 'POST',
			data: data,
			url : 'sipActionDown',
			success : function(resp) {
				$("#enteredActions_table tbody tr").remove(); 
				for(var i=0; i<resp['entered_actions'].length;i++){
					$('<tr id=\"'+i+'\">').html(
							"<td id=\"idCheck"+i+"\" style=\"width:25px;padding-left:5px\">"+"<input type=\"checkbox\" name=\"checkAction\" value="+i+"></td>"+
					        "<td id=\"idText"+i+"\" style="+"\"text-align:left;padding-left:10px\" "+"class="+"\"enteredActions_table_td\""+">" 
					        	+ resp['entered_actions'][i] + "</td>").appendTo('#enteredActions_table');
				}
	   			$('.enteredActionsBlock .scrollArea').scrollTop($('.enteredActionsBlock .scrollArea')[0].scrollHeight);
	   			
				selectedActionRowId = parseInt(selectedActionRowId)+1;
				var trId = "#"+selectedActionRowId;
				$(".enteredActionsBlock table tbody tr").each(function(i, row){
					$(this).removeClass('selected');
				});		
				$('.enteredActionsBlock').find(' '+trId).addClass('selected');	
			},
			error : function(xhr, status, error) {
				bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
			}
		});
	}
});

$(".sipXmlBlock .generateXML").click(function () {
	$('#script_xml').text("");
	if($("#enteredActions_table tbody tr").length>0){
		$.ajax({
			type : 'POST',
			url : 'generateSipScript',
			success : function(resp) {
				if(resp=="expired"){
					  bootbox.alert("Error Occurred while Generating Script. Session Expired.",function(){window.location = "./";
					  }).find("div.modal-content").addClass("modalfailure");
					  return;
				}
				
				if(resp!=""){
					$('#script_xml').text(resp);
				}else{
					bootbox.alert("Error Occurred while Generating Script. Invalid Syntax.").find("div.modal-content").addClass("modalfailure");
				}
			},
			error : function(xhr, status, error) {
				bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
			}
		});
	}
});

$('.testCaseModal').click(function () {
	$.blockUI({ message: '<img src="resources/images/loading.gif" />' });
	var tcID= "${testCase.id}";
	var tpID= "${testPlan.id}";
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

$('.buttonsDiv .saveXML').click(function () {

	if($(".markCompleted").is(':checked')){
		markComplete = true;
	}else{
		markComplete = false;
	}
	var data = "tcId="+encodeURIComponent("${testCase.id}")
				+"&markComplete="+encodeURIComponent(markComplete);

	if($('#script_xml').text().trim()!=""){
		$.blockUI({ message: '<img src="resources/images/ajaxWait.gif" />' });
		$.ajax({
			type : 'POST',
			url : 'uploadSipScripts',
			data : data,
			success : function(response) {
				$.unblockUI();
				if(response=="success"){
					$('#script_xml').text("");
					bootbox.alert("Scripts Uploaded Successfully").find("div.modal-content").addClass("modalSuccess");
				}
				else{
					bootbox.alert("Error occurred... "+response).find("div.modal-content").addClass("modalfailure");
				}
			},
			error : function(xhr, status, error) {
				$.unblockUI();
				bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
			}
		});
	}else{
		bootbox.alert("Saving Test File Failed. Generate the script before saving. ").find("div.modal-content").addClass("modalfailure");
	}
});


function openTab(tabName) {
	if(tabName=="Sdp"){
		$("#sdpTab").addClass(" active");
		$("#Sdp").css("display","block");
		$("#Headers").css("display","none");
		$("#headersTab").removeClass(" active");
		$("#xmlheadersTab").removeClass(" active");
		$("#XmlHeaders").css("display","none");
	}else if(tabName=="Headers"){
		$("#headersTab").addClass(" active");
		$("#Headers").css("display","block");
		$("#Sdp").css("display","none");
		$("#sdpTab").removeClass(" active");
		$("#xmlheadersTab").removeClass(" active");
		$("#XmlHeaders").css("display","none");
	}else{
		$("#Sdp").css("display","none");
		$("#sdpTab").removeClass(" active");
		$("#Headers").css("display","none");
		$("#headersTab").removeClass(" active");
		$("#xmlheadersTab").addClass(" active");
		$("#XmlHeaders").css("display","block");
	}
}

function downloadScript(){
	$.ajax({
		type : 'POST',
		url : 'downloadSipTemplate',
		success : function(response) {
			if(response=="Empty"){
				bootbox.alert(" No Actions Recorded. Empty Template. ").find("div.modal-content").addClass("modalfailure");
				return;
			}
			if(response=="NoExist"){
				bootbox.alert(" Sorry Couldn't Save the template file. Try again later. ").find("div.modal-content").addClass("modalfailure");
			}
			else{
				window.location.href = '${pageContext.request.contextPath}/downloadSipTemplate';
				window.setTimeout(deletingSavedTemplate,2000);
			}
		},
		error : function(xhr, status, error) {
			if(error=="Not Found"){
				bootbox.alert("Session Expired..Please Login again..",function(){window.location = "login";
				}).find("div.modal-content").addClass("modalfailure");
			}
			else{
				bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
			}
		}
	});
}

function deletingSavedTemplate(){	
	$.ajax({
		type : 'POST',
		url : 'deleteSavedSipTemplate',
		success : function(response) {
		},
		error : function(xhr, status, error) {
		}
	});
}

var fileName = "";
$(".buttonsDiv input[type=file]").change(function(event) {
	if($(this).val().trim()==""){
		return;
	}
    fileName = $(this).val();

    if (!(fileName.lastIndexOf('.stc', fileName.length - 4) === fileName.length - 4)) {
    	bootbox.alert("Only Sip Test Case template files are allowed.").find("div.modal-content").addClass("modalfailure");
    	return;
    }
    files = event.target.files;
    var data = new FormData();
    data.append("file", files[0]);

    $.ajax( {
        url: 'uploadSipTemplate',
        type: 'POST',
        data: data,
        enctype: 'multipart/form-data',
        processData: false, 
        contentType:false,
        success : function(resp) {

            if(resp['emptyFile']==true){
            	bootbox.alert("Template File is Empty.").find("div.modal-content").addClass("modalfailure"); 
            }
            else
            if(resp['inValid']==true){
            	bootbox.alert("File Content is in Invalid Format.").find("div.modal-content").addClass("modalfailure"); 
            }
            else
			if(resp['emptyFile']==false && resp['inValid']==false){
				$("#enteredActions_table tbody tr").remove(); 
				for(var i=0; i<resp['entered_actions'].length;i++){
					$('<tr id=\"'+i+'\">').html(
							"<td id=\"idCheck"+i+"\" style=\"width:25px;padding-left:5px\">"+"<input type=\"checkbox\" name=\"checkAction\" value="+i+"></td>"+
					        "<td id=\"idText"+i+"\" style="+"\"text-align:left;padding-left:10px\" "+"class="+"\"enteredActions_table_td\""+">" 
					        	+ resp['entered_actions'][i] + "</td>").appendTo('#enteredActions_table');
				}
	   			$('.enteredActionsBlock .scrollArea').scrollTop($('.enteredActionsBlock .scrollArea')[0].scrollHeight);
            }
		},
		error : function(xhr, status, error) {
			if(error=="Not Found"){
				bootbox.alert("Session Expired..Please Login again..",function(){window.location = "login";
				}).find("div.modal-content").addClass("modalfailure");
			}
			else{
				bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
			}
		}
      });

    $(this).val("");
});

$('.buttonsDiv .multicheck').click(function () {
	if(jQuery('#enteredActions_table input[type=checkbox]:checked').length!=0) { 
		bootbox.confirm({
		    buttons: {
		    	confirm: {
		    		label: 'YES',
	        	},
		        cancel: {
		            label: 'NO',
		        }
		    },
		    message: 'Are you sure want to mark these Actions as Multi Check?',
		    callback: function(result) {
		    	if(result) {
			    	var chk = [];
					$('#enteredActions_table input[type=checkbox]:checked').each(function() {
						chk.push($(this).val());
					});
					if(jQuery('#enteredActions_table input[type=checkbox]:checked').length<=1) {
						bootbox.alert("Select more than one action to Multi Check.").find("div.modal-content").addClass("modalfailure");
						return;
					} 
					var data='ids='+encodeURIComponent(chk);
					$.ajax({
						type : 'POST',
						data: data,
						url : 'multiCheckSipActions',
						success : function(resp) {
							if(resp==""){
								bootbox.alert("Already checked Actions cannot be Multi Checked again.").find("div.modal-content").addClass("modalfailure");
								return;
							}
							$("#enteredActions_table tbody tr").remove(); 
							for(var i=0; i<resp['entered_actions'].length;i++){
								$('<tr id=\"'+i+'\">').html(
										"<td id=\"idCheck"+i+"\" style=\"width:25px;padding-left:5px\">"+"<input type=\"checkbox\" name=\"checkAction\" value="+i+"></td>"+
								        "<td id=\"idText"+i+"\" style="+"\"text-align:left;padding-left:10px\" "+"class="+"\"enteredActions_table_td\""+">" 
								        	+ resp['entered_actions'][i] + "</td>").appendTo('#enteredActions_table');
							}
				   			$('.enteredActionsBlock .scrollArea').scrollTop($('.enteredActionsBlock .scrollArea')[0].scrollHeight);
						},
						error : function(xhr, status, error) {
							bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
						}
					});
		    	}
		    }
		}).find("div.modal-content").addClass("modalalert");
	}
});

$('.buttonsDiv .eithercheck').click(function () {
	if(jQuery('#enteredActions_table input[type=checkbox]:checked').length!=0) { 
		bootbox.confirm({
		    buttons: {
		    	confirm: {
		    		label: 'YES',
	        	},
		        cancel: {
		            label: 'NO',
		        }
		    },
		    message: 'Are you sure want to check Either of the selected Actions?',
		    callback: function(result) {
		    	if(result) {
			    	var chk = [];
					$('#enteredActions_table input[type=checkbox]:checked').each(function() {
						chk.push($(this).val());
					});
					if(jQuery('#enteredActions_table input[type=checkbox]:checked').length<=1) {
						bootbox.alert("Select more than one action.").find("div.modal-content").addClass("modalfailure");
						return;
					} 
					var data='ids='+encodeURIComponent(chk);
					$.ajax({
						type : 'POST',
						data: data,
						url : 'eitherSipActions',
						success : function(resp) {
							if(resp==""){
								bootbox.alert("Already checked Actions cannot be Checked again.").find("div.modal-content").addClass("modalfailure");
								return;
							}
							$("#enteredActions_table tbody tr").remove(); 
							for(var i=0; i<resp['entered_actions'].length;i++){
								$('<tr id=\"'+i+'\">').html(
										"<td id=\"idCheck"+i+"\" style=\"width:25px;padding-left:5px\">"+"<input type=\"checkbox\" name=\"checkAction\" value="+i+"></td>"+
								        "<td id=\"idText"+i+"\" style="+"\"text-align:left;padding-left:10px\" "+"class="+"\"enteredActions_table_td\""+">" 
								        	+ resp['entered_actions'][i] + "</td>").appendTo('#enteredActions_table');
							}
				   			$('.enteredActionsBlock .scrollArea').scrollTop($('.enteredActionsBlock .scrollArea')[0].scrollHeight);
						},
						error : function(xhr, status, error) {
							bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
						}
					});
		    	}
		    }
		}).find("div.modal-content").addClass("modalalert");
	}
});

$('#help').click(function () {
	$('#helpmodal').modal('show');
});

</script>

</html>