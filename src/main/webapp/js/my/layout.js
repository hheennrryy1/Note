$(document).ready(function() {
	
	$("#insertButton").click(function() {
		var name = $("#name").val();
		
		var args = {
				name : name
		};
		
		$.get(path + "/notebook/insert", args, function(data) {
			if(data=="fail") {
				$("#insertFail").text("所输入的笔记本名称已经存在，请换一名称。");
				$("#inputName").addClass("has-error");
			}
			if(data=="success") {
				//这里跳到笔记本里面
				//window.location.href = path + "/notebook/";
			}
		});
	});
	
})