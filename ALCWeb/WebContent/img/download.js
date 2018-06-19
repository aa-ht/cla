$("#download").click(function(e) {	
	$.ajax({		
			url : "/ALCWeb/download",		
	}).done((data) => saveData(data, 'ALChits.xlsx'));
	e.preventDefault();
});
