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
	
	function fade(element, text) {
		element.text(text);
		element.fadeIn("slow");
		setTimeout(function(){element.fadeOut("slow");}, 3000);
	}
	
	//改变笔记所在的笔记本
	$("#notebookName").change(function() {
		var notebookName =  $(this).val();
		var noteId = $("input[name='id']").val();
		
		var args = {
			notebookName : notebookName,
			noteId : noteId
		};
		
		$.post(path + "/note/updateNotebookId", args, function(data) {
			var updateNbIdMessage = $("#updateNbIdMessage");
			
			if(data==="success") {
				updateNbIdMessage.addClass("alert-success");
				fade(updateNbIdMessage, "已将笔记移动到" + notebookName);
			}
			if(data==="fail") {
				updateNbIdMessage.addClass("alert-danger");
				fade(updateNbIdMessage, "笔记移动失败");				
			}
		});
		
	});
	
	$("#updateButton").click(function() {
		var url = $("form").attr("action");
		
		$.post(url, $("form").serialize(), function(data) {
			var updateMessage = $("#updateMessage");
			
			if(data==="success") {
				updateMessage.addClass("alert-success");
				fade(updateMessage, "更新成功");
			}
			if(data==="fail") {
				updateMessage.addClass("alert-danger");
				fade(updateMessage, "更新失败");
			}
		});
	});
	
})