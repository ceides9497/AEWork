//Helps in creating a structure will help later.
function makeStruct(names) {
    var names = names.split(' ');
    var count = names.length;
    function constructor() {
        for (var i = 0; i < count; i++) {
            this[names[i]] = arguments[i];
        }
    }
    return constructor;
}

var rootcondition = '<table><tr><td class="seperator" style="color: rgb(154,154,154);">'
					+'<img src="resources/images/sipeditor/remove.png" style="cursor:pointer" alt="Remove" class="remove" />'
					+'<select style="margin-right:5px"><option value="and">AND</option><option value="or">OR</option></select></td>';
rootcondition += '<td><div class="querystmts" style="float:left"></div>'
					+'<div style="float:left;margin-left:5px"><img class="add" style="cursor:pointer" src="resources/images/sipeditor/add icon.png" alt="Add" />'
					+'<button class="addroot" style="margin-left:5px;margin-top:5px;color: rgb(154,154,154);">+()</button></div>';
rootcondition += '</td></tr></table>';

var statement = '<div class="statementDiv" style="width:680px;float:left;margin-top:5px;color: rgb(154,154,154);">'
				+'<div class="remove_icon" style="float:left"></div>'
				+'<select class="parameter1" style="float:left;margin-left: 5px;width:110px">'
				+'<option value="a">Codec</option><option value="m">Media</option><option value="v">Version of Protocol</option>'
				+'<option value="o">Originator</option><option value="s">Session name</option><option value="i">Title</option>'
				+'<option value="u">URI</option><option value="e">Email</option><option value="p">Phone</option><option value="c">ConnectionInfo</option>'
				+'<option value="b">Bandwith</option><option value="z">TimeZone</option><option value="k">Encryption Key</option>'
				+'<option value="t">TimeSessionActive</option><option value="r">Repeat Times</option>'
				+'</select>'
				+'<select class="operator1" style="width: 105px;float:left;margin-left: 5px">'
				+'<option value=\"CONTAINS\">Contains</option><option value=\"NOT CONTAINS\">Not Contains</option>'
				+'<option value=\"EQUALS\">Equals</option><option>Not Equals</option><option value=\"GREATER\">'
				+'Greater Than</option><option value=\"LESS\">Less Than</option><option value=\"STARTS\">Starts With</option><option value=\"COUNT\">Count</option>'
				+'</select>'
				+'<input type="text" class="input1" style="width: 100px;float:left;margin-left: 5px"/>'
				+'<select class="operator2" style="display: none;width: 105px;float:left;margin-left: 5px">'
				+'<option value=\"EQUALS\">Equals</option><option>Not Equals</option><option value=\"GREATER\">Greater Than</option><option value=\"LESS\">Less Than</option>'
				+'</select>'
				+'<select class="parameter2" style="display: none;width: 95px;float:left;margin-left: 5px">'
				+'<option>Number</option><option value=\"COUNT\">CountOf</option>'
				+'</select>'
				+'<select class="parameter3" style="float:left;margin-left: 5px;display:none;width:110px">'
				+'<option value="a">Codec</option><option value="m">Media</option><option value="v">Version of Protocol</option>'
				+'<option value="o">Originator</option><option value="s">Session name</option><option value="i">Title</option>'
				+'<option value="u">URI</option><option value="e">Email</option><option value="p">Phone</option><option value="c">ConnectionInfo</option>'
				+'<option value="b">Bandwith</option><option value="z">TimeZone</option><option value="k">Encryption Key</option>'
				+'<option value="t">TimeSessionActive</option><option value="r">Repeat Times</option>'
				+'</select>'
				+'<input type="text" class="input2"  style="display: none;width: 110px;float:left;margin-left: 5px"/><br></div>';	

var addqueryroot = function (sel, isroot) {
    $(sel).append(rootcondition);
    var q = $(sel).find('table');
    var l = q.length;
    var elem = q;
    if (l > 1) {
        elem = $(q[l - 1]);
    }

    //If root element remove the close image
    if (isroot) {
        elem.find('td >.remove').detach();
    }
    else {
        elem.find('td >.remove').click(function () {
            // td>tr>tbody>table
            $(this).parent().parent().parent().parent().detach();
        });
    }

    // Add the default staement segment to the root condition
    elem.find('td >.querystmts').append(statement);

    // Add the head class to the first statement
    elem.find('td >.querystmts div >.remove').addClass('head');

    // Handle click for adding new statement segment
    // When a new statement is added add a condition to handle remove click.
    elem.find('td div >.add').click(function () {
        $(this).parent().siblings('.querystmts').append(statement);
        var stmts = $(this).parent().siblings('.querystmts').find('div >.remove').filter(':not(.head)');
        stmts.unbind('click');
        stmts.click(function () {
            $(this).parent().detach();
        });
    });

    // Handle click to add new root condition
    elem.find('td div > .addroot').click(function () {
        addqueryroot($(this).parent(), false);
    });
};

//Recursive method to parse the condition and generate the query. Takes the selector for the root condition
var getCondition = function (rootsel) {
    //Get the columns from table (to find a clean way to do it later) //tbody>tr>td
    var elem = $(rootsel).children().children().children();
    //elem 0 is for operator, elem 1 is for expressions

    var q = {};
    var expressions = [];
    var nestedexpressions = [];
    var operator = $(elem[0]).find(':selected').val();
    q.operator = operator;
    // Get all the expressions in a condition
    var expressionelem = $(elem[1]).find('> .querystmts .statementDiv');
    for (var i = 0; i < expressionelem.length; i++) {
        expressions[i] = {};
        var parameter1 = $(expressionelem[i]).find('.parameter1 :selected');
        var operator1 = $(expressionelem[i]).find('.operator1 :selected');
        expressions[i].colval = parameter1.val();
        expressions[i].coldisp = parameter1.text();
        expressions[i].opval = operator1.val();
        expressions[i].opdisp = operator1.text();
        
        if(operator1.val()!="COUNT"){
        	if($(expressionelem[i]).find('.input1').val()==""){
        		bootbox.alert("Please Fill All the Fields of SDP.").find("div.modal-content").addClass("modalfailure");
        		error = true;
        		return null;
        	}
        	expressions[i].val = " '"+$(expressionelem[i]).find('.input1').val()+"' ";
        }else{
        	var op2 = $(expressionelem[i]).find('.operator2 :selected').val();
        	var param2 = $(expressionelem[i]).find('.parameter2 :selected').val();
        	var input2 = "";
        	var paramter3 = "";
	        	if(param2=="Number"){
	        		param2 = "";
	        		input2 = $(expressionelem[i]).find('.input2').val();
	        		if(input2.trim()==""){
	            		bootbox.alert("Please Fill All the Fields of SDP.").find("div.modal-content").addClass("modalfailure");
	            		error = true;
	            		return null;
	            	}
        		expressions[i].val = op2+" "+param2+" '"+input2+"' ";
	        	}else{
	        		input2 = $(expressionelem[i]).find('.parameter3 :selected').val();
	        		expressions[i].val = op2+" "+input2+" COUNT";
	        	}
        }
    }
    q.expressions = expressions;
    // Get all the nested expressions
	 if ($(elem[1]).find('> div > table').length != 0) {
       var len = $(elem[1]).find('> div > table').length;
        for (var k = 0; k < len; k++) {
           nestedexpressions[k] = getCondition($(elem[1]).find('> div > table')[k]);
        }
    }
	if(error == true){
		return null;
	}
    q.nestedexpressions = nestedexpressions;
    return q;
};

//Recursive method to iterate over the condition tree and generate the query
var getQuery = function (condition) {
    var op = [' ', condition.operator, ' '].join('');

    var e = [];
    var elen = condition.expressions.length;
    for (var i = 0; i < elen; i++) {
        var expr = condition.expressions[i];
        e.push(expr.colval + " " + expr.opval + " " + expr.val);
    }

    var n = [];
    var nlen = condition.nestedexpressions.length;
    for (var k = 0; k < nlen; k++) {
        var nestexpr = condition.nestedexpressions[k];
        var result = getQuery(nestexpr);
        n.push(result);
    }

    var q = [];
    if (e.length > 0)
        q.push(e.join(op));
		
    if (n.length > 0)
        q.push(n.join(op));

    return ['(', q.join(op), ')'].join(' ');
};