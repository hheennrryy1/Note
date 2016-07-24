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
	
	$("#updateButton").click(function() {
		var url = $("form").attr("action");
		$.post(url, $("form").serialize(), function(data) {
			if(data==="success") {
				var success = $("#success");
				success.text("更新成功");
				success.fadeIn("slow");
				setTimeout(function(){success.fadeOut("slow");}, 3000);
			}
			if(data==="fail") {
				var danger = $("#danger");
				danger.text("更新失败");
				danger.fadeIn("slow");
				danger.fadeOut("slow");
			}
		});
		
	});
	
})