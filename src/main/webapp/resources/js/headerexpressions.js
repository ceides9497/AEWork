var header_root = '<table><tr><td class="seperator" style="color: rgb(154,154,154);">'
					+'<img src="resources/images/sipeditor/remove.png" style="cursor:pointer" alt="Remove" class="remove" />'
					+'<select style="margin-right:5px"><option value="and">AND</option><option value="or">OR</option></select></td>';
header_root += '<td><div class="header_query" style="float:left"></div>'
					+'<div style="float:left;margin-left:5px"><img class="add" style="cursor:pointer" src="resources/images/sipeditor/add icon.png" alt="Add" />'
					+'<button class="addHeaderRoot" style="margin-left:20px;margin-top:5px;color: rgb(154,154,154);">+()</button></div>';
header_root += '</td></tr></table>';

var header_statement = '<div class="header_statementDiv" style="width:675px;float:left;margin-top:5px;color: rgb(154,154,154);">'
						+'<div class="remove_icon" style="float:left"></div>'
						+'<select class="header_param" style="float:left;margin-left: 20px">'
						+'<option>CallingLineID</option><option>From</option><option>To</option><option>Accept</option>'
						+'<option>Accept-Encoding</option><option>Accept-Language</option><option>Alert-Info</option>'
						+'<option>Allow</option><option>Authentication-Info</option><option>Authorization</option>'
						+'<option>Call-ID</option><option>Call-Info</option><option>Contact</option><option>Content-Disposition</option>'
						+'<option>Content-Encoding</option><option>Content-Language</option><option>Content-Length</option>'
						+'<option>Content-Type</option><option>CSeq</option><option>Error-Info</option><option>Expires</option>'
						+'<option>In-Reply-To</option><option>Max-Forwards</option><option>MIME-Version</option><option>Min-Expires</option>'
						+'<option>Organization</option><option>P-Asserted-Identity</option><option>Priority</option><option>Proxy-Authenticate</option>'
						+'<option>Proxy-Authorization</option><option>Proxy-Require</option><option>Reason</option><option>Record-Route</option>'
						+'<option>Remote-Party-ID</option><option>Reply-To</option><option>Require</option><option>Retry-After</option><option>Route</option>'
						+'<option>Server</option><option>Subject</option><option>Supported</option><option>Unsupported</option><option>User-Agent</option>'
						+'<option>Via</option><option>Warning</option><option>WWW-Authenticate</option>'
						+'</select>'
						+'<select class="header_operator" style="width: 105px;float:left;margin-left: 20px">'
						+'<option value=\"CONTAINS\">Contains</option><option value=\"NOT CONTAINS\">Not Contains</option>'
						+'<option value=\"EQUALS\">Equals</option><option>Not Equals</option><option value=\"GREATER\">'
						+'Greater Than</option><option value=\"LESS\">Less Than</option><option value=\"STARTS\">Starts With</option>'
						+'</select>'
						+'<input type="text" class="header_input" style="width: 120px;float:left;margin-left: 20px"/>'
						+'<br></div>';	

var addHeaderQueryRoot = function (sel, isroot) {
    $(sel).append(header_root);
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
    elem.find('td >.header_query').append(header_statement);

    // Add the head class to the first header_statement
    elem.find('td >.header_query div >.remove').addClass('head');

    // Handle click for adding new header_statement segment
    // When a new header_statement is added add a condition to handle remove click.
    elem.find('td div >.add').click(function () {
        $(this).parent().siblings('.header_query').append(header_statement);
        var stmts = $(this).parent().siblings('.header_query').find('div >.remove').filter(':not(.head)');
        stmts.unbind('click');
        stmts.click(function () {
            $(this).parent().detach();
        });
    });

    // Handle click to add new root condition
    elem.find('td div > .addHeaderRoot').click(function () {
        addHeaderQueryRoot($(this).parent(), false);
    });
};

//Recursive method to parse the condition and generate the query. Takes the selector for the root condition
var getHeaderCondition = function (rootsel) {
    //Get the columns from table (to find a clean way to do it later) //tbody>tr>td
    var elem = $(rootsel).children().children().children();
    //elem 0 is for operator, elem 1 is for expressions

    var q = {};
    var expressions = [];
    var nestedexpressions = [];
    var operator = $(elem[0]).find(':selected').val();
    q.operator = operator;
    // Get all the expressions in a condition
    var expressionelem = $(elem[1]).find('> .header_query .header_statementDiv');
    for (var i = 0; i < expressionelem.length; i++) {
        expressions[i] = {};
        var headerParam = $(expressionelem[i]).find('.header_param :selected');
        var header_operator = $(expressionelem[i]).find('.header_operator :selected');
        expressions[i].colval = headerParam.val();
        expressions[i].coldisp = headerParam.text();
        expressions[i].opval = header_operator.val();
        expressions[i].opdisp = header_operator.text();
        
    	if($(expressionelem[i]).find('.header_input').val()==""){
    		bootbox.alert("Please Fill All the Headers Fields.").find("div.modal-content").addClass("modalfailure");
    		error1 = true;
    		return null;
    	}
    	expressions[i].val = " '"+$(expressionelem[i]).find('.header_input').val()+"' ";
    }
    q.expressions = expressions;
    // Get all the nested expressions
	 if ($(elem[1]).find('> div > table').length != 0) {
       var len = $(elem[1]).find('> div > table').length;
        for (var k = 0; k < len; k++) {
           nestedexpressions[k] = getHeaderCondition($(elem[1]).find('> div > table')[k]);
        }
    }
	if(error1 == true){
		return null;
	}
    q.nestedexpressions = nestedexpressions;
    return q;
};

//Recursive method to iterate over the condition tree and generate the query
var getHeaderQuery = function (condition) {
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
        var result = getHeaderQuery(nestexpr);
        n.push(result);
    }

    var q = [];
    if (e.length > 0)
        q.push(e.join(op));
		
    if (n.length > 0)
        q.push(n.join(op));

    return ['(', q.join(op), ')'].join(' ');
};