const saveData = (() => {
  const a = document.createElement('a');
  a.style = 'display: none';
  document.body.appendChild(a);

  return (data, fileName, type = 'octet/stream') => {
    const blob = new Blob([data], { type });

    if (navigator.msSaveBlob) {
      return navigator.msSaveBlob(blob, fileName);
    }

    const url = URL.createObjectURL(blob);
    a.href = url;
    a.download = fileName;
    a.click();
    URL.revokeObjectURL(url);
    return true;
  };
})();

$("#infoform").submit(function(e) {
	
	var pswd={pwd: $('#pwd').val()};	
	
	$.ajax({
		type:"post",
			url : "/ALCWeb/info",
			data: pswd,			
			
		success : function(result) {
			$("#information").html(result);
		}
	});
	e.preventDefault();
});

