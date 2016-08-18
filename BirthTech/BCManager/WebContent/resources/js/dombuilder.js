 $(document).ready(function(){
	 	 loadFeeds();
	  	$.get("partial/userprofile",function(data){
	 	$("#main").append(data);
	 	});
	  
 
 });