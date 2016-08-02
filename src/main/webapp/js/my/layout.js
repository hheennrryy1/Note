$(document).ready(function() {
	
	$("#insertNotebookButton").click(function() {
		var name = $("#name").val();
		
		var args = {
				name : name
		};
		
		$.get(path + "/notebook/insert", args, function(data) {
			if(data==="fail") {
				$("#insertFail").text("所输入的笔记本名称已经存在，请换一名称。");
				$("#inputName").addClass("has-error");
			}
			if(data==="success") {
				//成功后跳到第一页
				var url = path + "/notebook/list/" + id + "?pageNum=1";
				window.location.href = url;
			}
		});
	});
	
})