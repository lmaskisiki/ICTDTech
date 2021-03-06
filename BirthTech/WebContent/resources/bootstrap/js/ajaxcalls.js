function loadCheckups() {

	var maternityId = document.getElementById("maternity").value;
	$.get("/BirthTech/maternity/checkup/all?idnumber=" + maternityId, function(
			result, status) {
		if (status == "success") {
			showCheckups(result);
		}
	});

}

function birthstatusChanged() {
	var childtable = "  <tr class='childinfo'><td></td><td  style='background-color:wheat;'>"
			+ "Child Name :(s) <br/><input type='text' name='childNames'/><br/>"
			+ "Surname : <br/>  <input type='text' name='childSurname'/><br/>"
			+ "Gender : <br/> <input type='text' name='gender'/><br/>"
			+ "Weight : <br/> <input type='text' name='childWeight'/><br/>"
			+ "Race : <br/>  <input type='text' name='childRace'/>"
			+ " </td></tr>";
	var state = $("#labourstatus").val();
	if (state == "success") {
		$("body").find("#labourstatus").closest("tr").after(childtable).show()
				.fadeIn(300);
	} else {
		$("body").find(".childinfo").hide().fadeOut(500);
	}

}
function showCheckups(result) {
	var table = document.createElement("table");
	table.setAttribute("class", "table table-striped");
	var thead = document.createElement("thead");
	var headerRow = document.createElement("tr")
	// CREATE COLUMN NAMES
	var deliveryColumn = document.createElement("th");
	deliveryColumn.appendChild(document.createTextNode("Delivered"));
	var placeColumn = document.createElement("th");
	placeColumn.appendChild(document.createTextNode("Health Center"));
	var commentColumn = document.createElement("th");
	commentColumn.appendChild(document.createTextNode("Diagnosis Details"))
	// APPEND COLUMN NAMES
	headerRow.appendChild(deliveryColumn);
	headerRow.appendChild(placeColumn);
	headerRow.appendChild(commentColumn);
	thead.appendChild(headerRow);
	table.appendChild(thead);
	var tbody = document.createElement("tbody");
	for (x = 0; x < result.length; x++) {
		var tr = document.createElement("tr");
		var deliveryCell = document.createElement("td");
		deliveryCell.appendChild(document.createTextNode(result[x].delivered));
		var placeCell = document.createElement("td");
		placeCell.appendChild(document.createTextNode(result[x].place));
		var commentCell = document.createElement("td");
		commentCell.appendChild(document.createTextNode(result[x].comments));

		tr.appendChild(deliveryCell);
		tr.appendChild(placeCell);
		tr.appendChild(commentCell);
		tbody.appendChild(tr);
	}
	table.appendChild(tbody);
	$(".checkups").empty();
	$(".checkups").append(table).hide().fadeIn(2000);

}

function deliveryStatus() {
	var table = "<table> <tr>"
			+ "<td>Child Name(s)</td> <input type='text' name='childNames'/>"
			+ "<td>Surname</td> <input type='text' name='childSurname'/>"
			+ "<td>Gender</td> <input type='text' name='gender'/>"
			+ "<td>Weight</td> <input type='text' name='childWeight'/>"
			+ "<td>Race</td> <input type='text' name='childRace'/>"
			+ "</tr></table>";
	$(this).closest("tr").find("td").append(table);

}
// [{"checkupId":4,"martenalId":6009081,"comments":"the patient is
// fine","nurse":null,"place":"Ms
// Zamampondo","delivered":false},{"checkupId":5,"martenalId":6009081,"comments":"both
// the patiant and the basy are fine","nurse":null,"place":"Ms
// Zamampondo","delivered":false}]

