<link rel="stylesheet" href="<c:url value="/resources/css/actionsButtons.css"/>"/>

<div id="actionButtonsBlock" class ="actionButtonsBlock">
  <div ng-app="actionButtons_App" ng-cloak>
	<div class="actionButtons_inner_table">
	  <div ng-controller="actionButtonsCtrl" class="actionButtons_container">	
		<div id ="actionButtons">
		  <scrollable-table watch="visibleProjects">
			<table id="actionButtons_table" class="actionButtons_table_class">
			  <thead>
				<tr>
				  <th style="text-align: left" class="actionButtons_table_th" title=" ">
					<select id="tab_dropdown" style="border: 0;width: 150px;cursor: pointer;">
					  <option id="Call Processing">Call Processing</option>
					  <option id="Admin Actions">Admin Actions</option>
					  <option id="Miscellaneous">Miscellaneous</option>
				  	</select>
				  </th>
				</tr>
			  </thead>
			   <tbody id="actions_tbody" style="display: block;margin-top: -16px;">
			  <tr>
			  	<td style="text-align:left;" class="actionButtons_table_td">
			  		<button id="Start" style="cursor: pointer" onClick="fromToModal(this.id)" class="start"></button> <br><br></td>
			  </tr>
			  <tr>
			  	<td style="text-align:left;" class="actionButtons_table_td">
			  	<button id="Answer" disabled style="cursor: default;color:#818181" onClick="singlePhoneModal(this.id)" class="answer disabled"></button> <br><br></td>
			  </tr>
			  <tr>
			  	<td style="text-align:left" class="actionButtons_table_td">
			  	<button id="Park" style="cursor: pointer" onClick="singlePhoneModal(this.id)" class="park"></button> <br><br></td>
			  </tr>
			  <tr>
			  	<td style="text-align:left;" class="actionButtons_table_td"">
			  	<button id="UnattendedTransferStart" disabled style="cursor: default;color:#818181" onClick="fromToModal(this.id)" class="unattendedxfer disabled"></button> <br><br></td>
			  </tr>
			  <tr>
			  	<td style="text-align:left" class="actionButtons_table_td">
			  	<button id="hold" disabled style="cursor: default;color:#818181" onClick="singlePhoneModal(this.id)" class="hold disabled"></button> <br><br></td>
			  </tr>
			  <tr>
			  	<td style="text-align:left;" class="actionButtons_table_td">
			  	<button id="TransfStart" disabled style="cursor: default;color:#818181" onClick="fromToModal(this.id)" class="xferStart disabled"></button> <br><br></td>
			  </tr>
			  <tr>
			  	<td style="text-align:left;" class="actionButtons_table_td">
			  	<button id="TransfComp" disabled style="cursor: default;color:#818181" onClick="singlePhoneModal(this.id)" class="xferComp disabled"></button> <br><br></td>
			  </tr>
			  <tr>
			  	<td style="text-align:left;" class="actionButtons_table_td">
			  	<button id="ConfStart" disabled style="cursor: default;color:#818181" onClick="fromToModal(this.id)" class="confStart disabled"></button> <br><br></td>
			  </tr>
			  <tr>
			  	<td style="text-align:left;" class="actionButtons_table_td">
			  	<button id="ConfComp" disabled style="cursor: default;color:#818181" onClick="singlePhoneModal(this.id)" class="confComp disabled"></button> <br><br></td>
			  </tr>
			  <tr>
				<td style="text-align:left;" class="actionButtons_table_td">
				<button id="End" disabled style="cursor: default;color:#818181" onClick="singlePhoneModal(this.id)" class="end disabled"></button> <br><br></td>
			  </tr>
			  <tr>
				<td style="text-align:left;" class="actionButtons_table_td">
				<button id="RemoveParty" disabled style="cursor: default;color:#818181" onClick="removePartyModal(this.id)" class="removeParty disabled"></button> 
				<div class="questionHelp" onClick="removePartyHelpFunc()"></div>
				<br><br></td>
			  </tr>
			  </tbody>
			  
			  <tbody id="admin_tbody" style="display: none;margin-top: -16px;">
			    <tr>
			  	<td style="text-align:left;" class="actionButtons_table_td">
			  	<button id="Login" onClick="adminModal(this.id)" class="login"></button><br><br></td>
			    </tr>
			    <tr>
			  	<td style="text-align:left;" class="actionButtons_table_td">
			  	<button id="Logout" onClick="adminModal(this.id)" class="logout"></button><br><br></td>
			    </tr>
			    <tr>
			  	<td style="text-align:left;" class="actionButtons_table_td">
			  	<button id="ForceLogout" onClick="adminModal(this.id)" class="forcelogout"></button><br><br></td>
			    </tr>
			    <tr>
			  	<td style="text-align:left;" class="actionButtons_table_td">
			  	<button id="ChangePassword" onClick="adminModal(this.id)" class="changepassword"></button><br><br></td>
			    </tr>
			  </tbody>
			  
			  <tbody id="miscellaneous_tbody" style="display: none;margin-top: -16px;">
				<tr>
				  <td style="text-align:left;" class="actionButtons_table_td">
				  <button id="MwiMacro" onClick="fromToModal(this.id)" class="mwimacro"></button>
				  <div class="questionHelp" onClick="mwiMacroHelpFunc()"></div><br><br>
				  </td>
				</tr>
				<tr>
				  <td style="text-align:left;" class="actionButtons_table_td">
				  <button id="CheckMwi" onClick="miscModal(this.id)" class="checkmwi"></button><br><br></td>
				</tr>		  
				<tr>
				  <td style="text-align:left;" class="actionButtons_table_td">
				  <button id="CheckPresence" onClick="miscModal(this.id)" class="checkpresence"></button><br><br></td>
				</tr>		
				<tr>
				  <td style="text-align:left;" class="actionButtons_table_td">
				  <button id="CallRecording" onClick="miscModal(this.id)" class="callrecording"></button><br><br></td>
				</tr>
				<tr>
				  <td style="text-align:left;" class="actionButtons_table_td">
				  <button id="DND" onClick="miscModal(this.id)" class="dnd"></button><br><br></td>
				</tr>
				<tr>
				  <td style="text-align:left;" class="actionButtons_table_td">
				  <button id="Privacy" onClick="miscModal(this.id)" class="privacy"></button><br><br></td>
				</tr>
				<tr>
			  	<td style="text-align:left;" class="actionButtons_table_td">
			  		<button id="checkHistory" style="cursor: pointer" onClick="miscModal(this.id)" class="checkHistory"></button> <br><br></td>
			  </tr>
				
				<tr>
			  	<td style="text-align:left;" class="actionButtons_table_td">
			  		<button id="callBack" style="cursor: pointer" onClick="miscModal(this.id)" class="callback"></button> <br><br></td>
			  </tr>
				
			  </tbody>
			</table>
		  </scrollable-table>
		</div>
	  </div>	
	</div>
  </div>
</div>

<!-- Modal to select From and To Phones for Action -->
	<div class="modal fade" id="from_to_modal" role="dialog">
	  <div class="modal-dialog" style="margin-top: 325px;position:relative;width: 375px;height:425px;margin-bottom: 0px;">
		<!-- Modal content-->
		<div class="modal-content" style="height: inherit;">
		  <div class="modal-body" style="padding:0px;">
		  <form id="from_to_modal_form">
		  	<div style="padding-left:10px;padding-right: 10px;padding-top: 15px">
		  	<div id="headingId" class="callHeading" style="margin-bottom: 5px">CALL </div>
		  	
			<div class="innerLabel">
			<div id="from_phone">
			<text id="fromId">From : </text> 
				<select id="origin" style="float: right;margin-right: 45px;width:100px;cursor: pointer;">
					<c:forEach var="res" items="${resources}">
						<option value="${res.id }">${res.name}	</option>
				 	</c:forEach>
				</select>
			</div>
			<div id="to_phone" style="display: block;padding-top: 10px;">
			To : <select id="terminator" style="float: right;margin-right: 45px;width:100px;cursor: pointer;">
					<c:forEach var="res" items="${resources}">
						<option value="${res.id }">${res.name}	</option>
				 	</c:forEach>
				 </select>
			</div>
			
			<div id="via" style="display: block;padding-top: 10px">
			Via : <div style="float: right;"><input type="radio" name="via" value="Internal" checked> Internal
	  			  <input type="radio" name="via" value="External"> External</div>	
			</div>

			<div id="from_line_no" style="display: block;padding-top: 10px;">
			From Line : <select id="fromlineno" style="float: right;margin-right: 45px;width:100px;cursor: pointer;">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
						<option>11</option>
						<option>12</option>
						<option>13</option>
						<option>14</option>
						<option>15</option>
						<option>16</option>
				   </select>
			</div>
			
			<div id="to_line_no" style="display: block;padding-top: 10px;">
			<text id="linenum">To Line :</text>
				<select id="tolineno" style="float: right;margin-right: 45px;width:100px;cursor: pointer;">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
						<option>11</option>
						<option>12</option>
						<option>13</option>
						<option>14</option>
						<option>15</option>
						<option>16</option>
				   </select>
			</div>
			
			<div id="wait_for_voicemail" style="display: none;padding-top: 10px">
			Wait : <div style="float: right;">
	  			  <input id="waittime" type="number" value="35" style="float: right;margin-right: 45px;width:100px;height:20px; "/> </div>	
			</div>
			
			<div id="toturretblock" style="background-color: lightgrey;color: darkgrey">
			</div>
			
			<div id="fromturretblock" style="background-color: lightgrey;color: darkgrey">
	
			<div id="sidediv" style="display: block;font-size: 14px;padding-top: 10px;">
			Side : <select id="side" style="float: right;margin-right: 45px;width:100px;cursor: pointer;">
						<option id="checkAvailable">Available</option>
						<option>Left</option>
						<option>Right</option>
				   </select>
			</div>
			
			<div id="privacy" style="display: block;font-size: 14px;padding-top: 10px">
			Privacy : <div style="float: right;padding-right: 33px">
			
					<input type="radio" name="privacy" value="Off" checked> Off
	  			  	<input type="radio" name="privacy" value="On" style="margin-left: 48px"> On</div>	
			</div>
			
			<div id="recording" style="display: block;font-size: 14px;padding-top: 10px">
			Recording : <div style="float: right;padding-right: 33px">
						<input type="radio" name="recording" value="Off" checked> Off
	  			  		<input type="radio" name="recording" value="On" style="margin-left: 48px"> On</div>	
			</div>
			
			<div id="typediv" style="display: block;font-size: 14px;padding-top: 10px">
			Type : <select id="type" style="float: right;margin-right: 45px;width:100px;cursor: pointer;" onchange="editCheckType()">
						<option>DialTone</option>
						<option>PointToPoint</option>
						<option>Group</option>
						<option>Private</option>
						<option>MWI</option>
						<option>Hunt</option>
						<option>GICM</option>
						<option>GTBK</option>
						<option>GANS</option>
						<option>ICM</option>
				   </select>	
			</div>
			
			<div id="device" style="display: block;font-size: 14px;padding-top: 10px">
			Device : <div style="float: right;"><input type="radio" name= "device" value="HandsFreeModule" > Handsfree
	  			  <input type="radio" name="device" value="Handset"  style="margin-left: 5px" checked> Handset </div>	
			</div>
			
			<div id="suppressCLI" style="display: block;font-size: 14px;padding-top: 10px">
			Anonymous : <div style="float: right;padding-right: 19px">
			
					<input type="radio" name="suppressCLI" value="true" > True
	  			  	<input type="radio" name="suppressCLI" value="false" style="margin-left: 42px" checked> False</div>	
			</div>
			
			<div id="intermediateline" style="display: none;font-size: 14px;padding-top: 10px;padding-bottom: 10px">
			<text>Intermediate Line :</text>
				<select id="intermediatelineno" style="float: right;margin-right: 45px;width:100px;cursor: pointer;">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
						<option>11</option>
						<option>12</option>
						<option>13</option>
						<option>14</option>
						<option>15</option>
						<option>16</option>
				   </select>
			</div>
			
			</div>
			
			<div id="holdcall" style="display: none;font-size: 14px;padding-top: 10px">
			Call Hold : <div style="float: right;padding-right: 20px">
					<input type="radio" name="holdValue" value="hold" checked> Hold
			  		<input type="radio" name="holdValue" value="unhold" style="margin-left: 19px"> Resume
			  	</div>
	  		</div>
	  		
	  		<div id="parkcall" style="display: none;font-size: 14px;padding-top: 10px">
			Call Park : <div style="float: right;padding-right: 20px">
					<input type="radio" name="parkValue" value="CallPark" checked> Park
			  		<input type="radio" name="parkValue" value="CallRetrieve" style="margin-left: 19px"> Retrieve
			  	</div>
	  		</div>
	  		
			</div>
			<div id="buttons_div" style="width: 100%;float: left;padding-top: 10px">
				<button style="float: right" type="reset" class="cancelCall" data-dismiss="modal"></button>
				<button style="float: right;margin-right: 10px" class="addAction"></button>
			</div>
			</div>
			</form>
		  </div>
		</div>
	  </div>
	</div>
<!-- /.modal -->

<!-- Modal to show admin actions -->
	<div class="modal fade" id="loginModal" role="dialog">
	  <div class="modal-dialog" style="margin-top: 325px;position:relative;width: 375px;height:255px;margin-bottom: 0px;">
		<!-- Modal content-->
		<div class="modal-content" style="height: inherit;">
		  <div class="modal-body" style="padding:0px;">
		   <form id="loginModal_form">
		  	<div style="padding-left:10px;padding-right: 10px;padding-top: 15px">
		  		<div id="adminHeadingId" class="callHeading" style="margin-bottom: 20px"> </div>
			
			<div class="innerLabel">
			<div id="login_phone_id" style="display: block;padding-top: 10px;">
			Phone : <select id="login_phone" style="float: right;margin-right: 45px;width:135px;cursor: pointer;">
					<c:forEach var="res" items="${resources}">
						<option value="${res.id }">${res.name}	</option>
				 	</c:forEach>
				 </select>
			</div>
			
			<div id="user_phone" style="display: block;padding-top: 10px;">
			User : <select id="login_user" style="float:right; margin-right: 45px;width:135px;cursor: pointer;">
						<option>User1</option>
						<option>User2</option>
						<option>User3</option>
						<option>User4</option>
						<option>User5</option>
						<option>User6</option>
						<option>User7</option>
						<option>User8</option>
						<option>User9</option>
						<option>User10</option>
					</select>
			</div>	
			
			<div id="login_option" style="padding-top: 10px">Default Password?
			<input type="checkbox" id="default_password" checked style="float:right;margin-right: 165px;width:15px;"></input>
			</div>
			
			<div id="custom_pswd" style="display: block;padding-top: 10px;padding-bottom: 10px;">
			Custom Password : 
			<input type="text" id="login_password_custom" style="float:right;margin-right: 45px;border:1px solid darkgray;width:135px;height: 22px;"/>
			</div>

			
			<div id="new_pswd" style="display: block;padding-top: 10px;padding-bottom: 10px;">
			New Password : 
			<input type="text" id="login_password_new" style="float:right;margin-right: 45px;border:1px solid darkgray;width:135px;height: 22px;"/>
			</div>
			

			</div>
			<div id="buttons_div" style="width: 100%;float: left;padding-top: 10px">
				<button style="float: right" type="reset" class="cancelCall" data-dismiss="modal"></button>
				<button style="float: right;margin-right: 10px" class="addLoginAction"></button>
			</div>
		  
		  </div>
		  </form>
		  </div>
		</div>
	  </div>
	</div>
<!-- /.modal -->

<!-- Modal to show Miscellaneous actions -->
	<div class="modal fade" id="miscModal" role="dialog">
	  <div class="modal-dialog" style="margin-top: 325px;position:relative;width: 375px;height:400px;margin-bottom: 0px;">
		<!-- Modal content-->
		<div class="modal-content" style="height: inherit;">
		  <div class="modal-body" style="padding:0px;">
		   <form id="miscModal_form">
		  	<div style="padding-left:10px;padding-right: 10px;padding-top: 15px">
		  		<div id="miscHeadingId" class="callHeading" style="margin-bottom: 20px"> </div>
			
			<div class="innerLabel">
			<div id="misc_phone_div" style="display: block;padding-top: 10px;">
			Phone : <select id="misc_phone" style="float: right;margin-right: 45px;width:135px;cursor: pointer;">
					<c:forEach var="res" items="${resources}">
						<option value="${res.id }">${res.name}	</option>
				 	</c:forEach>
				 </select>
			</div>
			
			
			<div id="misc_value_div" style="display: block;padding-top: 10px;">
			Value: 
			<select id="misc_value_select" style="float:right; margin-right: 45px;width:135px;cursor: pointer;">
				<option>DND</option>
				<option>AVAILABLE</option>
				<option>UNAVAILABLE</option>
				<option>BUSY</option>
				<option>AWAY</option>
			</select>
			<!-- <input type="text" id="misc_value_input" style="float:right;margin-right: 45px;border:1px solid darkgray;width:135px;height: 22px;"/> -->
			</div>
			<div id="privacy_value_div" style="display: block;padding-top: 10px;">
			Side: 
			<select id="privacy_value_select" style="float:right; margin-right: 45px;width:135px;cursor: pointer;">
				<option>Left</option>
				<option>Right</option>
			</select>
			<!-- <input type="text" id="misc_value_input" style="float:right;margin-right: 45px;border:1px solid darkgray;width:135px;height: 22px;"/> -->
			</div>
			<div id="dnd_value_div" style="display: block;padding-top: 10px;">
			Value: 
			<select id="dnd_value_select" style="float:right; margin-right: 45px;width:135px;cursor: pointer;">
				<option>true</option>
				<option>false</option>
			</select>
			<!-- <input type="text" id="misc_value_input" style="float:right;margin-right: 45px;border:1px solid darkgray;width:135px;height: 22px;"/> -->
			</div>
			
			
 			<div id="misc_line_div" style="display: block;padding-top: 10px;">
				<text>Line Number:</text>
					<select id="misc_lineno" style="float: right;margin-right: 45px;width:135px;cursor: pointer;">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
						<option>11</option>
						<option>12</option>
						<option>13</option>
						<option>14</option>
						<option>15</option>
						<option>16</option>
				   </select>
			</div> 
			
			<div id="misc_from_phone_div" style="display: block;padding-top: 10px;">
			From : <select id="misc_hist_from_phone" style="float: right;margin-right: 45px;width:135px;cursor: pointer;">
					<c:forEach var="res" items="${resources}">
						<option value="${res.id }">${res.name}	</option>
				 	</c:forEach>
				 </select>
			</div>
			
			<div id="misc_to_phone_div" style="display: block;padding-top: 10px;">
			To : <select id="misc_hist_to_phone" style="float: right;margin-right: 45px;width:135px;cursor: pointer;">
					<c:forEach var="res" items="${resources}">
						<option value="${res.id }">${res.name}	</option>
				 	</c:forEach>
				 </select>
			</div>
			
			<div id="misc_event_type_id" style="display: block;padding-top: 10px;">
			Event Type :<select id="misc_eventType" style="float: right;margin-right: 45px;width:135px;cursor: pointer;">
						<option>All</option>
						<option>Missed</option>
						<option>Received</option>
						<option>Initiated</option>
				   </select>
			</div>
			
			<div id="misc_side_div" style="display: block;font-size: 14px;padding-top: 10px;">
			Side : <select id="misc_side" style="float: right;margin-right: 45px;width:135px;cursor: pointer;">
						<option id="checkAvailable">Available</option>
						<option>Left</option>
						<option>Right</option>
				   </select>
			</div>
			
			<div id="misc_via_div" style="display: block;padding-top: 10px;margin-right:38px;">
			Via : <div style="float: right;"><input type="radio" name="miscVia" value="Internal" checked> Internal
	  			  <input type="radio" name="miscVia" value="External"> External</div>	
			</div>
			
			<div id="misc_from_line_div" style="display: block;padding-top: 10px;">
				<text>From Line:</text>
					<select id="misc_hist_from_line" style="float: right;margin-right: 45px;width:135px;cursor: pointer;">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
						<option>11</option>
						<option>12</option>
						<option>13</option>
						<option>14</option>
						<option>15</option>
						<option>16</option>
				   </select>
			</div> 
			
			<div id="misc_to_line_div" style="display: block;padding-top: 10px;">
				<text>To Line:</text>
					<select id="misc_hist_to_line" style="float: right;margin-right: 45px;width:135px;cursor: pointer;">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
						<option>11</option>
						<option>12</option>
						<option>13</option>
						<option>14</option>
						<option>15</option>
						<option>16</option>
				   </select>
			</div> 
			
			<div id="misc_privacy_div" style="display: block;font-size: 14px;padding-top:10px;margin-right:38px;">
			Privacy : <div style="float: right;padding-right: 33px">
			
					<input type="radio" name="misc_privacy" value="Off" checked> Off
	  			  	<input type="radio" name="misc_privacy" value="On" style="margin-left: 48px"> On</div>	
			</div>
			
			<div id="misc_recording_div" style="display: block;font-size: 14px;padding-top:10px;margin-right:38px;">
			Recording : <div style="float: right;padding-right: 33px">
						<input type="radio" name="misc_recording" value="Off" checked> Off
	  			  		<input type="radio" name="misc_recording" value="On" style="margin-left: 48px"> On</div>	
			</div>
			<div id="misc_device_dev" style="display: block;font-size: 14px;padding-top:10px;margin-right:38px;">
			Device : <div style="float: right;"><input type="radio" name= "misc_device" value="HandsFreeModule" checked> Handsfree
	  			  <input type="radio" name="misc_device" value="Handset"  style="margin-left: 5px"> Handset </div>	
			</div>
			
			<div id="misc_type_div" style="display: block;font-size: 14px;padding-top:10px">
			Type : <select id="misc_hist_Type" style="float: right;margin-right: 45px;width:135px;cursor: pointer;">
						<option>Resource</option>
						<option>ICM</option>
				   </select>	
			</div>
			
			</div>
			<div id="buttons_div" style="width: 100%;float: left;padding-top: 5px">
				<button style="float: right" type="reset" class="cancelCall" data-dismiss="modal"></button>
				<button style="float: right;margin-right: 10px" class="addMiscAction"></button>
			</div>
		  
		  </div>
		  </form>
		  </div>
		</div>
	  </div>
	</div>
<!-- /.modal -->
 
 <!-- Modal to show help window -->
<div class="modal fade" id="actionhelpmodal" role="dialog">
  <div class="modal-dialog" style="margin-top: 375px;position:relative;width: 450px;height:150px;margin-bottom: 0px;">
	<!-- Modal content-->
	<div class="modal-content" style="height: inherit;">
	  <div class="modal-body" style="padding:0px;">
	  <div style="text-align: center;color: #1414a4;font-size: 20px;padding-top: 10px;font-weight: 600" id="helpmodal_title">REMOVE PARTY FROM CONFERENCE</div>
	  <div style="padding: 25px;font-size: 16px;color: rgb(154,154,154);line-height: 25px;text-align: justify;white-space: pre-wrap;" id="helpmodal_content">
	  	This action is used only for the Turrets to Remove a Party from the Conference Bridge.
	  </div>
	  </div>
	</div>
  </div>
</div>
<!-- /.modal -->

<script>
var action = "";
function fromToModal(id){
	action = id;
	to_phone.style.display = "block";
	via.style.display = "block";
	from_line_no.style.display = "block";
	fromturretblock.style.display = "block";
	holdcall.style.display = "none";
	parkcall.style.display = "none";
	intermediateline.style.display = "none";
	wait_for_voicemail.style.display = "none";
	$('#fromId').html("From : ");
	$('#linenum').html("To Line :");
	$('#headingId').html(id.toUpperCase());
	$('#from_to_modal').modal('show');
	$('#from_to_modal .cancelCall').css("margin-top","0px");
	$('#from_to_modal .addAction').css("margin-top","0px");
	$('#from_to_modal .innerLabel').css("margin-top","0px");
	$('#from_to_modal .modal-dialog').css("height","425px");

	$("#toturretblock").css("background-color","lightgrey");
	$("#toturretblock").css("color","darkgrey");
	//$("#tolineno").attr("disabled",true);
	//$("#tolineno").css("background-color","lightgrey");

	$("#fromturretblock").css("background-color","lightgrey");
	$("#fromturretblock").css("color","darkgrey");
	
	$("#fromturretblock select").attr('disabled', true);
	$("#fromturretblock select").css("background-color","lightgrey");
	$("#fromturretblock input[type=radio]").attr('disabled', true);


	if(action.includes("ConfStart")){
		intermediateline.style.display = "block";
		$('#from_to_modal .modal-dialog').css("height","475px");
	}

	if(action.includes("MwiMacro")){
		wait_for_voicemail.style.display = "block";
		$('#from_to_modal .modal-dialog').css("height","475px");
	}
}

function singlePhoneModal(id){
	action = id;
	to_phone.style.display = "none";
	via.style.display = "none";
	fromturretblock.style.display = "none";
	from_line_no.style.display = "none";
	wait_for_voicemail.style.display = "none";
	$('#fromId').html("By Phone :");
	$('#headingId').html(id.toUpperCase());

	if(id=="hold"){
		holdcall.style.display = "block";
	}else{
		holdcall.style.display = "none";
	}

	if(id=="Park"){
		parkcall.style.display = "block";
	}else{
		parkcall.style.display = "none";
	}

	$('#linenum').html("Line Number :");
	//$("#tolineno").attr("disabled",true);
	//$("#tolineno").css("background-color","lightgrey");
	$("#toturretblock").css("margin-top","5px");
	
	$('#from_to_modal .cancelCall').css("margin-top","15px");
	$('#from_to_modal .addAction').css("margin-top","15px");
	$('#from_to_modal .innerLabel').css("margin-top","15px");
	$('#from_to_modal .modal-dialog').css("height","200px");
	
	/*Disabling the code to automatically select answer phone and endphone before answer
	if(action=="Answer"){
		$('.addAction').click();
	}
	else if(action=="End" && current_state == "startCall"){
		$('.addAction').click();
	}
	else{ */
		$('#from_to_modal').modal('show');
	//}
}

function removePartyModal(id){
	action = id;
	via.style.display = "none";
	fromturretblock.style.display = "none";
	to_phone.style.display = "block";
	from_line_no.style.display = "block";
	holdcall.style.display = "none";
	parkcall.style.display = "none";
	wait_for_voicemail.style.display = "none";
	$('#fromId').html("From : ");
	$('#linenum').html("To Line :");
	$('#headingId').html(id.toUpperCase());
	$('#from_to_modal').modal('show');
	$('#from_to_modal .cancelCall').css("margin-top","0px");
	$('#from_to_modal .addAction').css("margin-top","0px");
	$('#from_to_modal .innerLabel').css("margin-top","0px");
	$('#from_to_modal .modal-dialog').css("height","210px");
	$('#headingId').html(id.toUpperCase());

	$('#from_to_modal').modal('show');
}

$('#from_to_modal').on('hidden.bs.modal', function (e) {
	$("#from_to_modal_form").trigger('reset');
});

$(document).on('change','#origin', function() {
	var originId = $( "#origin option:selected" ).text();
	if($("#to_phone").css("display")=="block"){

		if(originId.includes("Turret")){
			$("#fromturretblock").css("background-color","transparent");
			$("#fromturretblock").css("color","#818181");

			//$("#fromlineno").attr("disabled",false);
			//$("#fromlineno").css("background-color","transparent");
			
			$("#side").attr("disabled",false);
			$("#side").css("background-color","transparent");

			$("#type").attr("disabled",false);
			$("#type").css("background-color","transparent");

			$("#fromturretblock input[type=radio]").attr('disabled', false);

			if(action.includes("ConfStart")){
				$("#intermediatelineno").attr("disabled",false);
				$("#intermediatelineno").css("background-color","transparent");
			}
				
		}else{
			$("#fromturretblock").css("background-color","lightgrey");
			$("#fromturretblock").css("color","darkgrey");
			
			$("#fromturretblock select").attr('disabled', true);
			$("#fromturretblock select").css("background-color","lightgrey");

			$("#fromturretblock input[type=radio]").attr('disabled', true);

			if(action.includes("ConfStart")){
				$("#intermediatelineno").attr("disabled",true);
				$("#intermediatelineno").css("background-color","lightgrey");
			}
		}
	}else{
		if(originId.includes("Turret")){
			$("#toturretblock").css("background-color","transparent");
			$("#toturretblock").css("color","#818181");

			//$("#tolineno").attr("disabled",false);
			//$("#tolineno").css("background-color","transparent");
		}else{
			$("#toturretblock").css("background-color","lightgrey");
			$("#toturretblock").css("color","darkgrey");
			
			//$("#tolineno").attr("disabled",true);
			//$("#tolineno").css("background-color","lightgrey");
		}
	}
});

$(document).on('change','#terminator', function() {
	var terminId = $("#terminator option:selected" ).text();

	if(terminId.includes("Turret")){
		$("#toturretblock").css("background-color","transparent");
		$("#toturretblock").css("color","#818181");

		//$("#tolineno").attr("disabled",false);
		//$("#tolineno").css("background-color","transparent");
	}else{
		$("#toturretblock").css("background-color","lightgrey");
		$("#toturretblock").css("color","darkgrey");
		
		//$("#tolineno").attr("disabled",true);
		//$("#tolineno").css("background-color","lightgrey");
	}
});

$(".addAction").click(function(e){
	e.preventDefault();
	var originId = $( "#origin option:selected" ).val();

	var lineno = $( "#lineno option:selected" ).val();

	var fromline = "";
	var toline = "";
	var side = "";
	var privacy = "";
	var recording = "";
	var type = "";
	var device = "";
	var linenum = "";
	var suppressCLI = "";
	var interline = "";

	var terminId = "";
	var via = "";
	var waittime = $("#waittime").val();;
	
	if($("#to_phone").css("display")=="block"){
		terminId = $("#terminator option:selected" ).val();
		via = $('input[name=via]:checked').val();
	}

	fromline = $("#fromlineno option:selected" ).val();
	toline = $("#tolineno option:selected" ).val();

		if(terminId=="" || originId!=terminId || fromline!=toline || action=="MwiMacro" ){
			$('#from_to_modal').modal('hide');

			/*Disabling the code to automatically select answer phone and endphone before answer
			if(action=="Start"){
				fromCall = $( "#origin option:selected" ).val();
				toCall = $("#terminator option:selected" ).val();
			}
			if(action=="Answer"){
				originId = toCall;
				terminId="";
			}
			if(action=="End" && current_state == "startCall"){
				originId = fromCall;
				terminId="";
			}
			*/
			if(terminId==""){
				linenum = $("#tolineno option:selected" ).val();
			}
			if($("#origin option:selected" ).text().includes("Turret")){
				if(terminId==""){
					linenum = $("#tolineno option:selected" ).val();
				}else if(action.includes('Party')){
					via = "";
				}else{
					fromline = $("#fromlineno option:selected" ).val();
					side = $( "#side option:selected" ).val();
					privacy = $('input[name=privacy]:checked').val();
					recording = $('input[name=recording]:checked').val();
					type = $( "#type option:selected" ).val();
					device = $('input[name=device]:checked').val();
					suppressCLI = $('input[name=suppressCLI]:checked').val();

					if(action.includes("ConfStart")){
						interline = $("#intermediatelineno option:selected" ).val();
					}
				}
			}
			if($("#terminator option:selected" ).text().includes("Turret")){
				toline = $("#tolineno option:selected" ).val();
			}


			if(action=="hold"){
				//if($("#origin option:selected" ).text().includes("Turret")){
					action = $('input[name=holdValue]:checked').val();
				//}
			}else if(action=="Park"){
				//if($("#origin option:selected" ).text().includes("Turret")){
					action = $('input[name=parkValue]:checked').val();
				//}
			}
			
			var data = 'currentState='
						+ encodeURIComponent(current_state)
						+'&action='
						+ encodeURIComponent(action)
						+'&originId='
						+ encodeURIComponent(originId)
						+'&terminatorId='
						+ encodeURIComponent(terminId)
						+'&via='
						+ encodeURIComponent(via)
						+'&fromlineno='
						+ encodeURIComponent(fromline)
						+'&tolineno='
						+ encodeURIComponent(toline)
						+'&waittime='
						+ encodeURIComponent(waittime)						
						+'&side='
						+ encodeURIComponent(side)
						+'&privacy='
						+ encodeURIComponent(privacy)
						+'&recording='
						+ encodeURIComponent(recording)
						+'&type='
						+ encodeURIComponent(type)
						+'&device='
						+ encodeURIComponent(device)
						+'&linenum='
						+ encodeURIComponent(linenum)
						+'&suppressCLI='
						+ encodeURIComponent(suppressCLI)
						+'&interline='
						+ encodeURIComponent(interline);

			$.ajax({
				type : 'POST',
				data : data,
				url : 'actionCall',
				success : function(resp) {
					
					if(resp.updateState){
						currentState = "<br>" + resp['states'];
						current_state = resp['states'];
						$('#current_state_id').html(currentState);
						
						if(resp['allActionEnable']==true){
							for(var i =0;i<buttons.length;i++){
								var divid = '#'+buttons[i];
								$(divid).css("color","#000000");
								$(divid).removeAttr('disabled');
								$(divid).css("cursor","pointer");
								$(divid).removeClass("disabled");
							}
						}
						else{									
							for(var i=0; i<resp['actions'].length;i++){
								var divid2 = '#'+resp['actions'][i].actionName;
								if(resp['actions'][i].enabled==true){
									$(divid2).css("color","#000000");
									$(divid2).removeAttr('disabled');
									$(divid2).css("cursor","pointer");
									$(divid2).removeClass("disabled");
								}
								else{
									$(divid2).attr('disabled','disabled');
									$(divid2).css("color","#818181");
									$(divid2).css("cursor","default");
									$(divid2).addClass("disabled");
								}
							}
						}
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
		else{
			bootbox.alert("Originator and Terminator cannot be the same with same lines.").find("div.modal-content").addClass("modalfailure");
		}
});

function reset_actions(){
	var buttons = ["Start", "Answer", "hold","Park","TransfStart", "TransfComp", "ConfStart", "ConfComp","UnattendedTransferStart", "BTransferStart", "End","RemoveParty"];
	bootbox.confirm({
	    buttons: {
	    	confirm: {
	    		label: 'YES',
        	},
	        cancel: {
	            label: 'NO',
	        }
	    },
	    message: 'Are you sure want to RESET?',
	    callback: function(result) {
	    	if(result) {
				$.ajax({
					type : 'POST',
					url : 'resetActions',
					success : function(resp) {
						console.log(resp);
						currentState = "<br>" + "initalState";
						current_state = "initialState";
						$("#enteredActions_table tbody tr").remove(); 
						if(resp['allActionEnable']==true){
							for(var i =0;i<buttons.length;i++){
								var divid = '#'+buttons[i];
								$(divid).css("color","#000000");
								$(divid).removeAttr('disabled');
								$(divid).css("cursor","pointer");
								$(divid).removeClass("disabled");
							}
						}
						else{
							for(var i=0;i<buttons.length;i++){
								var divid2 = '#'+buttons[i];
								if(buttons[i]!="Start"){
									$(divid2).attr('disabled','disabled');
									$(divid2).css("color","#818181");
									$(divid2).css("cursor","default");
									$(divid2).addClass("disabled");
								}
								else{
									$(divid2).css("color","#000000");
									$(divid2).removeAttr('disabled');
									$(divid2).css("cursor","pointer");
									$(divid2).removeClass("disabled");
								}
							}
						}
						$('#script_xml').text("");
					},
					error : function(xhr, status, error) {
						bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
					}
				});
			}
	    },
	}).find("div.modal-content").addClass("modalalert");
}

$(document).on('change','#tab_dropdown', function() {
	var tab_title = $( "#tab_dropdown option:selected" ).attr("id");

	if(tab_title.includes("Call")){
		$("#admin_tbody").css("display","none");
		$("#actions_tbody").css("display","block");
		$("#miscellaneous_tbody").css("display","none");
	}else if(tab_title.includes("Admin")){
		$("#actions_tbody").css("display","none");
		$("#admin_tbody").css("display","block");
		$("#miscellaneous_tbody").css("display","none");
	}else if(tab_title.includes("Miscellaneous")){
		$("#admin_tbody").css("display","none");
		$("#actions_tbody").css("display","none");
		$("#miscellaneous_tbody").css("display","block");
	}
	
});

$('#loginModal').on('hidden.bs.modal', function (e) {
	$("#loginModal_form").trigger('reset');
});

function adminModal(id){
	action = id;
	$('#adminHeadingId').html(id.toUpperCase());
	
	if(action=="Login"){
		login_phone_id.style.display = "block";
		user_phone.style.display = "block";
		login_option.style.display = "block";
		custom_pswd.style.display = "block";
		new_pswd.style.display = "none";
		
		$("#custom_pswd").css("background-color","lightgrey");
		$("#custom_pswd").css("color","darkgrey");
		
		$("#login_password_custom").attr('disabled', true);
		$("#login_password_custom").css("background-color","lightgrey");
		$('#loginModal .modal-dialog').css("height","255px");
		
	}else if(action.includes("Logout")){
		login_phone_id.style.display = "block";
		user_phone.style.display = "none";
		login_option.style.display = "none";
		custom_pswd.style.display = "none";
		new_pswd.style.display = "none";
		$('#loginModal .modal-dialog').css("height","170px");
	}else if(action=="ChangePassword"){
		login_phone_id.style.display = "block";
		user_phone.style.display = "block";
		login_option.style.display = "block";
		custom_pswd.style.display = "none";
		new_pswd.style.display = "block";

		$("#new_pswd").css("background-color","lightgrey");
		$("#new_pswd").css("color","darkgrey");

		$("#login_password_new").attr('disabled', true);
		$("#login_password_new").css("background-color","lightgrey");
		
		$('#loginModal .modal-dialog').css("height","255px");
	}else{
		login_phone_id.style.display = "block";
		user_phone.style.display = "none";
		login_option.style.display = "none";
		custom_pswd.style.display = "none";
		new_pswd.style.display = "none";
		$('#loginModal .modal-dialog').css("height","170px");
	}
	$('#loginModal').modal('show');
}

$('#default_password').change( function() {

	if($('#default_password').prop('checked')){
		$("#new_pswd, #custom_pswd").css("background-color","lightgrey");
		$("#new_pswd, #custom_pswd").css("color","darkgrey");
		
		$("#login_password_new, #login_password_custom").attr('disabled', true);
		$("#login_password_new, #login_password_custom").css("background-color","lightgrey");
			
	}else{

		$("#new_pswd, #custom_pswd").css("background-color","transparent");
		$("#new_pswd, #custom_pswd").css("color","#818181");
		
		$("#login_password_new, #login_password_custom").attr("disabled",false);
		$("#login_password_new, #login_password_custom").css("background-color","transparent");	
	}
});

$(".addLoginAction").click(function(e){
	e.preventDefault();

	var originId = $( "#login_phone option:selected" ).val();

	
	var user = "";
	var newpassword = "";
	var custompassword = "";
	
	if(!action.includes("Logout")){
		user = $( "#login_user option:selected" ).val();

		if(!$('#default_password').prop('checked')){
			if(action.includes("Login") ){
				newpassword = "";
				custompassword = $("#login_password_custom").val().trim();
				if(custompassword=="" || custompassword.length<4){
					bootbox.alert("Password cannot be less than 4 characters").find("div.modal-content").addClass("modalfailure");
					return;
				}
			}else if(action.includes("Password")){
				custompassword = "";
				newpassword = $("#login_password_new").val().trim();
				if(newpassword=="" || newpassword.length<4){
					bootbox.alert("Password cannot be less than 4 characters").find("div.modal-content").addClass("modalfailure");
					return;
				}
			}			
		}
	}


	$('#loginModal').modal('hide');

	var data = 'action='
				+ encodeURIComponent(action)
				+'&originId='
				+ encodeURIComponent(originId)
				+'&user='
				+ encodeURIComponent(user)
				+'&newpassword='
				+ encodeURIComponent(newpassword)
				+'&custompassword='
				+ encodeURIComponent(custompassword);

	$.ajax({
		type : 'POST',
		data : data,
		url : 'adminAction',
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
});

$('#miscModal').on('hidden.bs.modal', function (e) {
	$("#miscModal_form").trigger('reset');
});

function miscModal(id){
	action = id;
	$('#miscHeadingId').html(id.toUpperCase());
	misc_from_phone_div.style.display = "none";
	misc_to_phone_div.style.display = "none";
	misc_event_type_id.style.display = "none";
	misc_to_line_div.style.display = "none";
	misc_type_div.style.display ="none";
	misc_via_div.style.display = "none";
	misc_side_div.style.display = "none";
	misc_from_line_div.style.display = "none";
	misc_privacy_div.style.display = "none";
	misc_recording_div.style.display = "none";
	misc_device_dev.style.display = "none";
	if(action=="CheckPresence"){
		misc_phone_div.style.display = "block";
		misc_line_div.style.display = "none";
		misc_value_div.style.display = "block";
		dnd_value_div.style.display = "none";
		privacy_value_div.style.display = "none";
	}else if(action=="CheckMwi"){
		misc_phone_div.style.display = "block";
		misc_line_div.style.display = "block";
		misc_value_div.style.display = "none";
		dnd_value_div.style.display = "none";
		privacy_value_div.style.display = "none";
	}else if(action=="CallRecording"){
		misc_phone_div.style.display = "none";
		misc_line_div.style.display = "none";
		misc_value_div.style.display = "none";
		dnd_value_div.style.display = "none";
		privacy_value_div.style.display = "none";
	}else if(action=="DND"){
		misc_phone_div.style.display = "block";
		misc_line_div.style.display = "none";
		misc_value_div.style.display = "none";
		dnd_value_div.style.display = "block";
		privacy_value_div.style.display = "none";
	}else if(action=="Privacy"){
		misc_phone_div.style.display = "block";
		misc_line_div.style.display = "none";
		misc_value_div.style.display = "none";
		privacy_value_div.style.display = "block";
		dnd_value_div.style.display = "block";
		
	}else if(action=="checkHistory"){
		misc_from_phone_div.style.display = "block";
		misc_to_phone_div.style.display = "block";
		misc_event_type_id.style.display = "block";
		misc_to_line_div.style.display = "block";
		misc_type_div.style.display ="block";
		misc_phone_div.style.display = "none";
		misc_line_div.style.display = "none";
		misc_value_div.style.display = "none";
		privacy_value_div.style.display = "none";
		dnd_value_div.style.display = "none";
		misc_via_div.style.display = "none";
		misc_side_div.style.display = "none";
		misc_from_line_div.style.display = "none";
		misc_privacy_div.style.display = "none";
		misc_recording_div.style.display = "none";
		misc_device_dev.style.display = "none";
		
	}else if(action=="callBack"){
		misc_from_phone_div.style.display = "block";
		misc_event_type_id.style.display = "block";
		misc_via_div.style.display = "block";
		misc_side_div.style.display = "block";
		misc_from_line_div.style.display = "block";
		misc_privacy_div.style.display = "block";
		misc_recording_div.style.display = "block";
		misc_device_dev.style.display = "block";
		
		misc_type_div.style.display ="none";
		misc_to_line_div.style.display = "none";
		misc_to_phone_div.style.display = "none";
		misc_phone_div.style.display = "none";
		misc_line_div.style.display = "none";
		misc_value_div.style.display = "none";
		privacy_value_div.style.display = "none";
		dnd_value_div.style.display = "none";
		
	}
	$('#miscModal').modal('show');
}


$(".addMiscAction").click(function(e){
	e.preventDefault();
	
	var originId = $( "#misc_phone option:selected" ).val();
	var data = 'action='+ encodeURIComponent(action)
				+'&originId=' + encodeURIComponent(originId);
	var url = "";
	if(action.includes("CheckPresence")){
		var originPhone = $( "#misc_phone option:selected" ).text();
		if(!originPhone.includes("Turret")){
			bootbox.alert("Check Presence Action is only for the Turrets.").find("div.modal-content").addClass("modalfailure");
			return;
		}
		var checkValue = $( "#misc_value_select option:selected" ).val();
		data += '&miscValue=' + encodeURIComponent(checkValue);
		url = "checkPresenceAction";
	}else if(action.includes("CheckMwi")){
		var linenum = $("#misc_lineno option:selected" ).val();
		data += '&linenum=' + encodeURIComponent(linenum);
		url = "checkMwiAction";
	}else if(action.includes("CallRecording")){
		url = "addCallRecording";	
	}else if(action.includes("DND")){
		var originPhone = $( "#misc_phone option:selected" ).text();
		if(!originPhone.includes("Turret")){
			bootbox.alert("DND Action is only for the Turrets.").find("div.modal-content").addClass("modalfailure");
			return;
		}
		var checkValue = $( "#dnd_value_select option:selected" ).val();
		data += '&miscValue=' + encodeURIComponent(checkValue);
		url = "checkDNDAction";
	}else if(action.includes("Privacy")){
		var originPhone = $( "#misc_phone option:selected" ).text();
		if(!originPhone.includes("Turret")){
			bootbox.alert("Privacy Action is only for the Turrets.").find("div.modal-content").addClass("modalfailure");
			return;
		}
		var checkValue = $( "#dnd_value_select option:selected" ).val();
		var sideValue = $( "#privacy_value_select option:selected" ).val();
		//data += '&miscValue=' + encodeURIComponent(checkValue);
		  data += '&miscValue='+ encodeURIComponent($.trim(checkValue))
				  +'&&sideValue='+ encodeURIComponent($.trim(sideValue));
		url = "privacyAction";
	}else if(action.includes("checkHistory")){
		var miscFromPhone = $( "#misc_hist_from_phone option:selected" ).text();
		if(!miscFromPhone.includes("Turret")){
			bootbox.alert("Check History Action is only for the Turrets.").find("div.modal-content").addClass("modalfailure");
			return;
		}
		var eventType = $( "#misc_eventType option:selected" ).val();
		var toPhone = $( "#misc_hist_to_phone option:selected" ).text();
		var toLine = $( "#misc_hist_to_line option:selected" ).val();
		var histType = $( "#misc_hist_Type option:selected" ).val();
		data +=   '&miscFromPhone=' + encodeURIComponent($.trim(miscFromPhone))
			      +'&miscToPhone=' + encodeURIComponent($.trim(toPhone))
		          +'&miscEventType='+ encodeURIComponent($.trim(eventType))
				  +'&&miscToLine='+ encodeURIComponent($.trim(toLine))
				  +'&&miscHistType='+ encodeURIComponent($.trim(histType));
		url = "checkHistoryAction";
	}else if(action.includes("callBack")){
		var miscFromPhone = $( "#misc_hist_from_phone option:selected" ).text();
		if(!miscFromPhone.includes("Turret")){
			bootbox.alert("Call Back Action is only for the Turrets.").find("div.modal-content").addClass("modalfailure");
			return;
		}
		var eventType = $( "#misc_eventType option:selected" ).val();
		var fromLine = $( "#misc_hist_from_line option:selected" ).val();
		var via = $('input[name=miscVia]:checked').val();
		var side = $( "#misc_side option:selected" ).val();
		var privacy = $('input[name=misc_privacy]:checked').val();
		var recording = $('input[name=misc_recording]:checked').val();
		var device = $('input[name=misc_device]:checked').val();
		data +=   '&miscFromPhone=' + encodeURIComponent($.trim(miscFromPhone))
			      +'&miscFromLine=' + encodeURIComponent($.trim(fromLine))
		          +'&miscEventType='+ encodeURIComponent($.trim(eventType))
				  +'&&miscVia='+ encodeURIComponent($.trim(via))
				  +'&&miscSide='+ encodeURIComponent($.trim(side))
				  +'&&miscPrivacy='+ encodeURIComponent($.trim(privacy))
				  +'&&miscRecording='+ encodeURIComponent($.trim(recording))
				  +'&&miscDevice='+ encodeURIComponent($.trim(device));
		url = "callBackAction";
	}
	else{
		bootbox.alert("Invalid Action: " + action).find("div.modal-content").addClass("modalfailure");
		return;
	}

	$('#miscModal').modal('hide');

	$.ajax({
		type : 'POST',
		data : data,
		url : url,
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
});

function removePartyHelpFunc(){

	$('#actionhelpmodal #helpmodal_title').text("REMOVE PARTY FROM CONFERENCE");
	$('#actionhelpmodal #helpmodal_content').html("This action is used only for the Turrets to Remove a Party from the Conference Bridge.");
	$('#actionhelpmodal .modal-dialog').css("height","150px");
	$('#actionhelpmodal').modal('show');
}

function mwiMacroHelpFunc(){

	$('#actionhelpmodal #helpmodal_title').text("MWI COUNT MACRO");

	var help_content= "This Macro will create scripts to leave a voicemail message and check the MWI count on the Terminator.\n" +
					  "<span style='font-size:15px;'>* Originator and Terminator are ALLOWED to be same.\n"+
					  "* Adjust waiting time to have the call be forwarded to voicemail.</span>";
	$('#actionhelpmodal #helpmodal_content').html(help_content);

	$('#actionhelpmodal .modal-dialog').css("height","190px");
	$('#actionhelpmodal').modal('show');
}
function editCheckType(){
	var choosetype = $("#type").val();
	var sideVal = $("#side").val();
	if(choosetype == "ICM"){
		if(sideVal == "Available"){
			$("#checkAvailable").prop('disabled', true); 
			$("#side").val("Left");
		}
	}else{
		$("#checkAvailable").prop('disabled', false); 
	} 
}
</script>