$(document).ready(function(){
	
	$("#main-nav > li:eq(0)").addClass("active");
	
	$('#summernote').summernote({
	  height: 500,                 // set editor height
	  minHeight: null,             // set minimum height of editor
	  maxHeight: null,             // set maximum height of editor
	  focus: true                  // set focus to editable area after initializing summernote
	});
	
	//往里写内容
	/*
	  	var markupStr = 'hello world';
		('#summernote').summernote('code', markupStr);
	*/
	
	$("#createButton").click(function() {
		var content = $("#summernote").summernote('code');
		alert(content);
	});
	
})	