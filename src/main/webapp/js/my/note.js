$(document).ready(function() {
	$("#notebookSetting").collapse();
	$("#main-nav > li:eq(2)").addClass("active");
	
	$('#content').summernote({
	  height: 500,                 // set editor height
	  minHeight: null,             // set minimum height of editor
	  maxHeight: null,             // set maximum height of editor
	  focus: true,                  // set focus to editable area after initializing summernote
	  lang: 'zh-CN'                 // set language
	});
	
	$('input').bind('input propertychange', function() {
		//alert("input");
	});
	
	$("button").click(function() {
		var url = $("form").attr("action");
		$.post(url, $("form").serialize(), function(data) {
			alert(data);
		});
		
	});
	
})