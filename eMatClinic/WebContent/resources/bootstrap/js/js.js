$(document).ready(
function() {
	
	$("#searchtext").on("change",function(){
		alert("changed");
	});
					$("li#patientsearch").on("mouseleave",function(){
						$("li#searchstring").remove();
					});
					$("li#patientsearch").on("mouseenter",function(){
					 
					$(this).append("<li id='searchstring'><input id='searchvalue'  type='text' onchange='openseachresults()'></input></li>").fadeIn(5000);
					});
			 
					$("#addcheckup").on('click', function() {
						$("#addcheckuptable").fadeIn();
					});
					$("#showcheckups").on("click", function() {
						loadCheckups();
					});
					
					$("#deliverystatus")
							.on(
									"change",
									function() {

										var bsucess = document
												.createElement("select");
										bsucess.setAttribute("id",
												"labourstatus");
										bsucess.setAttribute("name",
												"labourstatus");
										bsucess.setAttribute("onchange",
										"birthstatusChanged()");
										var bsucessValue0 = document
										.createElement("option");
								bsucessValue0.setAttribute("value",
										"failure");
								bsucessValue0.appendChild(document.createTextNode("Select"));
										var bsucessValue1 = document
												.createElement("option");
										bsucessValue1.setAttribute("value",
												"success");
										bsucessValue1.appendChild(document
												.createTextNode("Success"));
										var bsucessValue2 = document
												.createElement("option");
										bsucessValue2.setAttribute("value",
												"failure");
										bsucessValue2.appendChild(document
												.createTextNode("Failure"));
										bsucess.appendChild(bsucessValue0);
										bsucess.appendChild(bsucessValue1);
										bsucess.appendChild(bsucessValue2);
										var span1 = document
												.createElement("span");
										span1.appendChild(bsucess);
									
										if ($(this).closest("select").val() == "yes") {
											$(this).closest("tr").append(span1);
										} else {
											$("#labourstatus").fadeOut(10);
										}

									});
				});


function openseachresults(){
var searchstring =$("#searchvalue").val();
if(isNaN(searchstring)){
	return;
}else{
	window.open("http://localhost:8080/BirthTech/maternity/current?idnumber="+searchstring,true);
}
	
}
