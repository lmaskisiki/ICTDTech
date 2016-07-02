 $(document).ready(function(){
	 	 loadFeeds();
	 	 var res="lizo";
	 	$.get("partial/userprofile",function(data){
	 	$("#main").append(data);
	 	res=data;
	 	});
	 	
 $('button').on('click',function(){
 alert(res);
});
 
 $('select').change(function (){
	 alert("changed");
 });
 
 });