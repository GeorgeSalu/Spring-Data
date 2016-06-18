$(document).ready(function (){
	$('button[id*="button_"]').click(function (a){
		var pageNumber = $(this).val();
		tbody(pageNumber);
	});
});

function tbody(page) {
	
	var url = "/blog/postagem/ajax/page/"+page;
	
	$("#tbody").load(url,function(response,status,xhr){
		if(status == "error"){
			var msg = "Sorry but there was an error";
			$("#info").html(msg,xhr.status+" "+xhr.statusText)
		}
	});
	
}