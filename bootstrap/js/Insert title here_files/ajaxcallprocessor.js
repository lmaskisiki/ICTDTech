function loadFeeds() {
	var xhttprequest = new XMLHttpRequest();
	xhttprequest.onreadystatechange = function() {
		if (xhttprequest.readyState == 4) {
			if (xhttprequest.status = 200) {
				var response = xhttprequest.responseText;
				var jsonObject = JSON.parse(response);
				if (jsonObject.length > 0) {
					showFeeds(jsonObject);
				}
			}
		}
	};

	xhttprequest.open("GET", "feeds", true);
	xhttprequest.send(null);
}

function feedBehaviour() {
	$("a").on("click", function() {
		$(this).closest("ul").find(".feedbody").toggle();

	});
}
function showFeeds(jsonObject) {
	var div = document.createElement("div");
	for (count = 0; count < jsonObject.length; count++) {
		var feed = document.createElement("ul");
		var feedTitle = document.createElement("li");
		feedTitle.setAttribute("class", "feedtitle");
		var feedTitleLink = document.createElement("a");
		feedTitleLink.setAttribute("href", "#");
		feedTitleLink.appendChild(document
				.createTextNode(jsonObject[count]["title"]));
		feedTitle.appendChild(feedTitleLink);
		var feedBody = document.createElement("li");
		feedBody.setAttribute("class", "feedbody");
		feedBody
				.appendChild(document.createTextNode(jsonObject[count]["body"]));
		feed.appendChild(feedTitle);
		feed.appendChild(feedBody);
		div.appendChild(feed);
	}
	$("#sidebar").append(div);

	feedBehaviour();
}
// LOADING USER PROFILE
function loadUserProfile() {
	var xhttprequest = new XMLHttpRequest();
	xhttprequest.onreadystatechange = function() {
		if (xhttprequest.readyState == 4) {
			if (xhttprequest.status == 200) {
				if (xhttprequest.responseText.length > 0
						|| xhttprequest.responseText != null) {
					showUserProfile(xhttprequest.responseText);
				} else {
					console.log("no records found");
					alert("no records found");
				}
			}

		}
	};
	xhttprequest.open("GET", "account/profile", true);
	xhttprequest.send(null);
}

function showUserProfile(response) {
	var jsonObject = JSON.parse(response);

	// need to confirm if this is areal json object
	var userInfo = jsonObject["useraccount.soap.services.Person"];
	alert(response);
	$("#surname").val(userInfo["lastName"]);
	$("#name").val(userInfo["firstName"]);
	$("#idNumber").val(userInfo["idNumber"]);
	$("#gender").val(userInfo["gender"]);
	$("#cellnumber").val(userInfo["cell"]);
	$("#email").val(userInfo["email"]);

	$(".userprofiletable").toggle();

	// process document information
	var userDocumentsTest = jsonObject["document"];
	if (userDocumentsTest == null || jsonObject["document"][0] == null) {
		$(".showdocuments").on("mouseenter", function() {
			$(this).empty();
			$(this).append("<b>You do not have any document </b>");
		});

	} else {
		var userDocuments = jsonObject["document"][0]["docman.services.FileInfo"];
		$(".showdocuments")
				.on(
						"mouseenter",
						function() {
							$(this).find(".documents").toggle();
							if (userDocuments != null) {
								for (x = 0; x < userDocuments.length; x++) {
									var li = document.createElement("li");
									var link = document.createElement("a");
									link.setAttribute("href", "#");
									link
											.appendChild(document
													.createTextNode(userDocuments[0]["fileName"]))
									li.appendChild(link);
									// $(this).find(".documents").empty();
									$(this).find(".documents").append(li);
								}
							}
						});
	}
}

function updateprofile() {
	var attributes = personattributes();
	var select = document.createElement("select");
	select.setAttribute("name", "attribute");
	select.setAttribute("class", "userattributes")
	for (x = 0; x < attributes.length; x++) {
		var option = document.createElement("option");
		option.setAttribute("value", attributes[x].attribute);
		option.appendChild(document.createTextNode(attributes[x].attribute));
		select.appendChild(option);
	}
	select.addEventListener("change", attributeChangedd, false);

	$("#main").empty();
	$("#main").append("<div></div>");
	$("#main").find("div").append(select);

	function attributeChangedd() {
		$(this).closest("#main").find("div").find("span").remove();
		$(this).closest("#main").find("div").append("<span></span>")
		var input = document.createElement("input");
		input.setAttribute("type", "text");
		input.setAttribute("name", this.value)
		var pushbutton=document.createElement("button");
		pushbutton.setAttribute("class", "submitupdate");
		pushbutton.appendChild(document.createTextNode("Update"))
		$(this).closest("#main").find("div").find("span").append("Enter your new "+this.value+":");
		$(this).closest("#main").find("div").find("span").append(input);
		$(this).closest("#main").find("div").find("span").append(pushbutton);
	}
}