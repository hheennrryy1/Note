$(document).ready(function() {
		$("#notebookSetting").collapse();
		$("#main-nav > li:eq(2)").addClass("active");
		
		$(".updateStatus").click(function() {
			var href = $(this).prev("a").attr("href");
			var name = $(this).parent().prevAll("a").children().text();
			
			$("#modal-body").text("确定删除" + name + "吗？");
			$("#modal-footer a").attr("href", href);
			
			$("#updateStatusModal").modal();
		});
})