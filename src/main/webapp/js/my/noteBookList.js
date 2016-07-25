$(document).ready(function(){
	$("#notebookSetting").collapse();
	$("#main-nav > li:eq(2)").addClass("active");
	
	var nbid = $("input[name='id']");
	
	nbid.each(function(index, element) {
		var args = {
			id : $(this).val()
		};
		
		$.getJSON(path + "/notebook/count", args, function(data) {
			$(nbid[index]).prev("p").text("共有" + data + "条笔记");
		});
		
	});
	
	$(".delete").click(function() {
		var href = $(this).prev("a").attr("href");
		var name = $(this).parent().prevAll("a").children().text();
		
		$("#modal-body").text("确定删除" + name + "吗？");
		$("#modal-footer > a").attr("href", href);
		
		$("#deleteModal").modal();
	});
})