$(document).ready(function() {
	$("#notebookSetting").collapse();
	$("#main-nav > li:eq(2)").addClass("active");
	
	$('#summernote').summernote({
	  height: 500,                 // set editor height
	  minHeight: null,             // set minimum height of editor
	  maxHeight: null,             // set maximum height of editor
	  focus: true                  // set focus to editable area after initializing summernote
	});
	
})