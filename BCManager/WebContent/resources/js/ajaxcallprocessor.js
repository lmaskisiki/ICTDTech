$(document)
		.ready(
				function() {

					$("a#showpdf")
							.on(
									"click",
									function() {
										var filepath = $(this).closest("div")
												.find("input").val();
										var iframe = "<iframe  width='600px' src='ftp://localhost/"
												+ filepath + "'></iframe>";
										$(this).closest("div").find("#pdfview")
												.empty();
										$(this).closest("div").find("#pdfview")
												.append(iframe).toggle();

									});

					$("button#approve")
							.on(
									"click",
									function() {
										$
												.post(
														"http://localhost:8080/BCManager/application/approve/",
														$(this).val(),
														function(status, data) {
															if (data == "success") {
																window.close();
															}

														});
									});
					function getApplications() {

						$.get("bc/applications/all", function(results, status) {

							alert("ok")
						});
					}
				});

function getApplications() {
	var results = [];
	$.get("bc/applications/all?parent=" + $("#searchbyparent").val(),
					function(result, status) {
						if (status == "success") {
							results = result;
						}
						if (results != null /* or undefined */) {
							var table = document.createElement("table");
							table
									.setAttribute("class",
											"table table-condensed")
							var thead = document.createElement("thead");
							var thr = document.createElement("tr");
							var thc1 = document.createElement("th");
							thc1.appendChild(document
									.createTextNode("Birth No."));
							var thc2 = document.createElement("th");
							thc2.appendChild(document
									.createTextNode("Childs Null Name"));
							var thc3 = document.createElement("th");
							thc3.appendChild(document.createTextNode("Gender"));
							var thc4 = document.createElement("th");
							thc4.appendChild(document.createTextNode("Application Date"));
							var thc5 = document.createElement("th");
							thc5.appendChild(document
									.createTextNode("Parents Full Name"));
							var thc6 = document.createElement("th");
							thc6.appendChild(document
									.createTextNode("Action(s)"));
							thr.appendChild(thc1);
							thr.appendChild(thc2);
							thr.appendChild(thc3);
							thr.appendChild(thc4);
							thr.appendChild(thc5);
							thr.appendChild(thc6);
							thead.appendChild(thr);
							table.appendChild(thead);
							var tbody = document.createElement("tbody")
							for (x = 0; x < results.length; x++) {
								var tr = document.createElement("tr");
								var cel1 = document.createElement("td");
								cel1
										.appendChild(document
												.createTextNode(results[x]['birthNumber']));
								tr.appendChild(cel1);
								var cel2 = document.createElement("td");
								cel2
										.appendChild(document
												.createTextNode(results[x]['childNames']
														+ " "
														+ results[x]['surname']));
								tr.appendChild(cel2);
								var cel3 = document.createElement("td");
								cel3.appendChild(document
										.createTextNode(results[x]['gender']));
								tr.appendChild(cel3);
								var cel4 = document.createElement("td");
								cel4.appendChild(document
										.createTextNode(new Date(
												results[x]['creationDate'])));
								tr.appendChild(cel4);
								var cel5 = document.createElement("td");
								cel5
										.appendChild(document
												.createTextNode(results[x]['parentFullNames']));
								tr.appendChild(cel5);
								var processButton = document
										.createElement("button");
								processButton.appendChild(document
										.createTextNode("Process"));
								processButton.setAttribute("class",
										"btn btn-primary");
								processButton.setAttribute("id",
										"processbutton");
								processButton.addEventListener("click",
										processAppl, true)
								processButton.setAttribute("value",
										results[x]['parentFullNames']);
								results[x]['collectReady'] == true ? processButton
										.setAttribute("disabled", "disabled")
										: "";
								tr.appendChild(processButton);
								tbody.appendChild(tr);
							}
							table.appendChild(tbody);
							$("#main").empty();
							$("#main").append(table);
						}
					});
}
function processAppl() {
	var wn = window.open(
			"http://localhost:8080/BCManager/application/parent/profile?fullname="
					+ $(this).val(), '');

}
