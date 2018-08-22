<link rel="stylesheet" href="<c:url value="/resources/css/resourceManagement.css"/>"/>

<div id="validateHide" class="validateHide" onClick="showValidate()">
    <p class="textValidate">Resource Management</p>
    <p class="dropdown" style="float: right;margin-top: 7px;margin-right: 45px"></p>
</div>

<div id="resourceManagementBlock" class ="resourceManagementBlock">
    <form id="validateForm">
        <div ng-app="resourceManagement_App" ng-cloak>
            <div class="validate_inner_table">
                <div ng-controller="resourceManagementCtrl" class="validate_container">
                    <div id ="validate">
                        <scrollable-table watch="visibleProjects">
                            <table id="validate_table" class="validate_table_class">
                                <thead>
                                <tr style ="cursor: pointer;" onClick="hideValidate()">
                                    <th style="text-align: left" class="validate_table_th" title=" ">Validate</th>
                                    <th style="text-align: left" class="validate_table_th" title=" ">
                                        <div style="margin-top: 7px;margin-right: 32px;float: right;" class="dropdown" ></div></th>
                                </tr>
                                </thead>
                                <tbody>

                                <tr>
                                    <td style="text-align:left;" class="validate_table_td">Phone</td>
                                    <td style="text-align:left;" class="validate_table_td">
                                        <select id="phoneValidate" style="cursor: pointer;width: 100px">
                                            <c:forEach var="res" items="${resources}">
                                                <option value="${res.id }">${res.name}	</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="text-align:left;" class="validate_table_td">Line</td>
                                    <td style="text-align:left;" class="validate_table_td">
                                        <select id="lineValidate" style="cursor: pointer;width: 100px">
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
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="text-align:left;" class="validate_table_td">Line State</td>
                                    <td style="text-align:left;padding-left: 10px" class="validate_table_td">
                                        <input type="radio" name="lineState" value="Inactive" checked> Inactive &nbsp&nbsp&nbsp
                                        <input type="radio" name="lineState" value="Active"> Active
                                    </td>
                                </tr>
                                <tr>
                                    <td style="text-align:left;" class="validate_table_td">Call Type</td>
                                    <td style="text-align:left;padding-left: 10px" class="validate_table_td">
                                        <input type="radio" name="callType" value="None" checked> None<br>
                                        <input type="radio" name="callType" value="Incoming" > Incoming	&nbsp&nbsp&nbsp
                                        <input type="radio" name="callType" value="Outgoing"> Outgoing
                                    </td>
                                </tr>
                                <tr>
                                    <td style="text-align:left;" class="validate_table_td">Call Type 2</td>
                                    <td style="text-align:left;padding-left: 10px" class="validate_table_td">
                                        <input type="radio" name="callType2" value="None" checked> None<br>
                                        <input type="radio" name="callType2" value="Incoming" > Incoming	&nbsp&nbsp&nbsp
                                        <input type="radio" name="callType2" value="Outgoing"> Outgoing
                                    </td>
                                </tr>
                                <tr>
                                    <td style="text-align:left;" class="validate_table_td">Call State</td>
                                    <td style="text-align:left;padding-left: 10px" id="callState" class="validate_table_td">
                                        <!--  <input type="checkbox" name="callState" value="None" checked> None<br> -->
                                        <input type="checkbox" name="callState" value="Dialtone"> Dialtone	&nbsp&nbsp&nbsp
                                        <input type="checkbox" name="callState" value="Connected"> Connected<br>
                                        <input type="checkbox" name="callState" value="RingBack"> RingBack	&nbsp
                                        <input type="checkbox" name="callState" value="Offering"> Offering <br>
                                        <input type="checkbox" name="callState" value="Setup"> Setup &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                                        <input type="checkbox" name="callState" value="CallConference"> CallConf <br>
                                        <input type="checkbox" name="callState" value="CallHold"> CallHold	&nbsp&nbsp
                                        <input type="checkbox" name="callState" value="CallConfHold"> CallConfHold<br>
                                        <input type="checkbox" name="callState" value="CallHeld"> CallHeld
                                    </td>
                                </tr>
                                <tr>
                                    <td style="text-align:left;" class="validate_table_td">Call State 2</td>
                                    <td style="text-align:left;padding-left: 10px" id="callState2" class="validate_table_td">
                                        <!-- <input type="checkbox" name="callState2" value="None" checked> None<br>-->
                                        <input type="checkbox" name="callState2" value="Dialtone"> Dialtone	&nbsp&nbsp&nbsp
                                        <input type="checkbox" name="callState2" value="Connected"> Connected<br>
                                        <input type="checkbox" name="callState2" value="RingBack"> RingBack	&nbsp
                                        <input type="checkbox" name="callState2" value="Offering"> Offering <br>
                                        <input type="checkbox" name="callState2" value="Setup"> Setup &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                                        <input type="checkbox" name="callState2" value="CallConference"> CallConf <br>
                                        <input type="checkbox" name="callState2" value="CallHold"> CallHold	&nbsp&nbsp
                                        <input type="checkbox" name="callState2" value="CallConfHold"> CallConfHold<br>
                                        <input type="checkbox" name="callState2" value="CallHeld"> CallHeld
                                    </td>
                                </tr>
                                <tr>
                                    <td style="text-align:left;" class="validate_table_td">Description</td>
                                    <td style="text-align:left;padding-left: 5px" class="validate_table_td">
                                        <textarea id="validate_desc" name="validate_desc"></textarea></td>
                                </tr>
                                </tbody>
                            </table>
                        </scrollable-table>
                    </div>
                </div>
            </div>
        </div>
        <button style="margin-left: 30px;float: right;margin-right: 10px" type="reset" class="resetValidate"></button>
        <button style="float: right;" class="addValidate"></button>
    </form>
</div>

<script>
    $(".addValidate").click(function(e){
        var phoneId = $( "#phoneValidate option:selected" ).val();
        var line = $( "#lineValidate option:selected" ).val();
        var linestate = $('input[name=lineState]:checked').val();
        var calltype = $('input[name=callType]:checked').val();
        //var callstate = $('input[name=callState]:checked').val();
        var calltype2 = $('input[name=callType2]:checked').val();
        //var callstate2 = $('input[name=callState2]:checked').val();
        var desc = $("#validate_desc").val().trim();

        var callstate = [];
        $('#callState :checked').each(function() {
            callstate.push($(this).val());
        });

        var callstate2 = [];
        $('#callState2 :checked').each(function() {
            callstate2.push($(this).val());
        });

        var data = "phoneId="+encodeURIComponent(phoneId)
            +"&line="+encodeURIComponent(line)
            +"&ls="+encodeURIComponent(linestate)
            +"&ct="+encodeURIComponent(calltype)
            +"&cs="+encodeURIComponent(callstate)
            +"&ct2="+encodeURIComponent(calltype2)
            +"&cs2="+encodeURIComponent(callstate2)
            +"&desc="+encodeURIComponent(desc);
        $.ajax({
            url : "addValidate",
            data : data,
            type : "POST",

            success : function(resp) {
                $("#enteredActions_table tbody tr").remove();
                for(var i=0; i<resp['entered_actions'].length;i++){
                    $('<tr id=\"'+i+'\">').html(
                        "<td id=\"idCheck"+i+"\" style=\"width:25px;padding-left:5px\">"+"<input type=\"checkbox\" name=\"checkAction\" value="+i+"></td>"+
                        "<td id=\"idText"+i+"\" style="+"\"text-align:left;padding-left:10px\" "+"class="+"\"enteredActions_table_td\""+">"
                        + resp['entered_actions'][i] + "</td>").appendTo('#enteredActions_table');
                }
                $('.enteredActionsBlock .scrollArea').scrollTop($('.enteredActionsBlock .scrollArea')[0].scrollHeight);
                $("#validateForm").trigger('reset');
            },
            error : function(xhr, status, error) {
                bootbox.alert("Unknown Error occurred. Try again later").find("div.modal-content").addClass("modalfailure");
            }
        });
    });

</script>