$(document).ready(function(){
	$("#noteSetting").collapse();
	$("#main-nav > li:eq(3)").addClass("active");
	
	$("#content").summernote({
	  height: 500,                 // set editor height
	  minHeight: null,             // set minimum height of editor
	  maxHeight: null,             // set maximum height of editor
	  focus: true                  // set focus to editable area after initializing summernote
	});
	
})	