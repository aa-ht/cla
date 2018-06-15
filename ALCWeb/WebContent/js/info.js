$("#button").on('click', function() {
	
	var pswd={pwd: $('#pwd').val()};
	
	
	$.ajax({
		type:"post",
			url : "/ALCWeb/info",
			data: pswd,
		success : function(result) {
			$("#information").html(result);
		}
	});
});