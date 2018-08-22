var xml_header_root = '<table><tr><td class="seperator" style="color: rgb(154,154,154);">'
					+'<img src="resources/images/sipeditor/remove.png" style="cursor:pointer" alt="Remove" class="remove" />'
					+'<select style="margin-right:5px"><option value="and">AND</option><option value="or">OR</option></select></td>';
xml_header_root += '<td><div class="xml_header_query" style="float:left"></div>'
					+'<div style="float:left;margin-left:5px"><img class="add" style="cursor:pointer" src="resources/images/sipeditor/add icon.png" alt="Add" />'
					+'<button class="addXmlHeaderRoot" style="margin-left:20px;margin-top:5px;color: rgb(154,154,154);">+()</button></div>';
xml_header_root += '</td></tr></table>';

var xml_header_statement = '<div class="xml_header_statementDiv" style="width:675px;float:left;margin-top:5px;color: rgb(154,154,154);">'
						+'<div class="remove_icon" style="float:left"></div>'
						+'<input class="xml_header_param" style="float:left;margin-left: 20px;width:200px">'
						+'<select class="xml_header_operator" style="width: 105px;float:left;margin-left: 20px">'
						+'<option value=\"EQUALS\">Equals</option><option>Not Equals</option>'
						+'<option value=\"CONTAINS\">Contains</option><option value=\"NOT CONTAINS\">Not Contains</option>'
						+'<option value=\"STARTS\">Starts With</option>'
						+'</select>'
						+'<input type="text" class="xml_header_input" style="width: 200px;float:left;margin-left: 20px"/>'
						+'<br></div>';	

var addXmlHeaderQueryRoot = function (sel, isroot) {
    $(sel).append(xml_header_root);
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
    elem.find('td >.xml_header_query').append(xml_header_statement);

    // Add the head class to the first xml_header_statement
    elem.find('td >.xml_header_query div >.remove').addClass('head');

    // Handle click for adding new xml_header_statement segment
    // When a new xml_header_statement is added add a condition to handle remove click.
    elem.find('td div >.add').click(function () {
        $(this).parent().siblings('.xml_header_query').append(xml_header_statement);
        var stmts = $(this).parent().siblings('.xml_header_query').find('div >.remove').filter(':not(.head)');
        stmts.unbind('click');
        stmts.click(function () {
            $(this).parent().detach();
        });
    });

    // Handle click to add new root condition
    elem.find('td div > .addXmlHeaderRoot').click(function () {
        addXmlHeaderQueryRoot($(this).parent(), false);
    });
};

//Recursive method to parse the condition and generate the query. Takes the selector for the root condition
var getXmlHeaderCondition = function (rootsel) {
    //Get the columns from table (to find a clean way to do it later) //tbody>tr>td
    var elem = $(rootsel).children().children().children();
    //elem 0 is for operator, elem 1 is for expressions

    var q = {};
    var expressions = [];
    var nestedexpressions = [];
    var operator = $(elem[0]).find(':selected').val();
    q.operator = operator;
    // Get all the expressions in a condition
    var expressionelem = $(elem[1]).find('> .xml_header_query .xml_header_statementDiv');
    for (var i = 0; i < expressionelem.length; i++) {
        expressions[i] = {};
        var xml_headerParam = $(expressionelem[i]).find('.xml_header_param');
        var xml_header_operator = $(expressionelem[i]).find('.xml_header_operator :selected');
        expressions[i].colval = xml_headerParam.val();
        expressions[i].coldisp = xml_headerParam.text();
        expressions[i].opval = xml_header_operator.val();
        expressions[i].opdisp = xml_header_operator.text();
        
    	if($(expressionelem[i]).find('.xml_header_input').val()=="" || $(expressionelem[i]).find('.xml_header_param').val()==""){
    		bootbox.alert("Please Fill All the XmlHeaders Fields.").find("div.modal-content").addClass("modalfailure");
    		error2 = true;
    		return null;
    	}
    	expressions[i].val = " '"+$(expressionelem[i]).find('.xml_header_input').val()+"' ";
    }
    q.expressions = expressions;
    // Get all the nested expressions
	 if ($(elem[1]).find('> div > table').length != 0) {
       var len = $(elem[1]).find('> div > table').length;
        for (var k = 0; k < len; k++) {
           nestedexpressions[k] = getXmlHeaderCondition($(elem[1]).find('> div > table')[k]);
        }
    }
	if(error2 == true){
		return null;
	}
    q.nestedexpressions = nestedexpressions;
    return q;
};

//Recursive method to iterate over the condition tree and generate the query
var getXmlHeaderQuery = function (condition) {
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
        var result = getXmlHeaderQuery(nestexpr);
        n.push(result);
    }

    var q = [];
    if (e.length > 0)
        q.push(e.join(op));
		
    if (n.length > 0)
        q.push(n.join(op));

    return ['(', q.join(op), ')'].join(' ');
};