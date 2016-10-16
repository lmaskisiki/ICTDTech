//HTML Input builder
function inputBuilderHtml(input) {
	var table = document.createElement("table");
	for (var x = 0; x < input.length; x++) {
		var tr = document.createElement("tr")
		var element = input[x];
		// create a label cell
		var label = document.createElement("td")
		label.innerHTML = element["attribute"];
		// create input cell
		var inpCell = document.createElement("td");

		if (element["hasInputOptions"]) {
			var inp = selectInputBuilder(element);
			inpCell.appendChild(inp);
		} else {
			var inp = textInputBuilder(element);
			inpCell.appendChild(inp);
		}

		tr.appendChild(label);
		tr.appendChild(inpCell);
		table.appendChild(tr);
	}
	return table;

}
// create text input
function textInputBuilder(input) {
	var inpt = document.createElement("input");
	inpt.setAttribute("name", input["attribute"]);
	return inpt;
}
// create a select menu
function selectInputBuilder(input) {
	var select = document.createElement("select");
	select.setAttribute("name", input["attribute"]);
	var dflt = document.createElement("option");
	dflt.innerHTML = "Select One"
	select.appendChild(dflt);
	for ( var x=0; x<input["inputOptionValues"].length;x++) {
		var option = document.createElement("option");
		option.setAttribute("value", input["inputOptionValues"][x])
		option.innerHTML=input["inputOptionValues"][x];
		select.appendChild(option);
	}
	return select;
}