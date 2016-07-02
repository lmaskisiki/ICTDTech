function loanLoad() {

	function attributeChanged() {
		$(this).closest("#main").find("div").find("span").remove();
		$(this).closest("#main").find("div").append("<span></span>")
		var input = document.createElement("input");
		input.setAttribute("type", "text");
		input.setAttribute("name", this.value)
		var pushbutton = document.createElement("button");
		pushbutton.setAttribute("class", "submitupdate");
		pushbutton.appendChild(document.createTextNode("Update"))
		$(this).closest("#main").find("div").find("span").append(
				"Enter your new " + this.value + ":");
		$(this).closest("#main").find("div").find("span").append(input);
		$(this).closest("#main").find("div").find("span").append(pushbutton);
	}
	
	
	
	
}