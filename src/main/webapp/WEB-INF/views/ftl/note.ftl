<#import "layout/layout.ftl" as l>

<@l.htmlHead "${note.title}">
		<script src="${path}/js/public/summernote.min.js"></script>
		<script src="${path}/js/public/summernote-zh-CN.min.js"></script>
		<script src="${path}/js/my/note.js"></script>
		<link rel="stylesheet" href="${path}/css/summernote.css"/>
		<script>
			var content = "${note.content}";
			$("#summernote").value = "${note.content}";
		</script>
</@l.htmlHead>

<@l.htmlBody>
	<div class="container col-md-8 col-md-offset-1" id="main-div">
			<form action="${path}/note/update" method="POST">
				<input type="hidden" value="${note.id}" name="id"/>
				
				<div class="form-group">
					<input type="text" class="form-control" name="title" 
						required="required" value="${note.title}"/>
				</div>
				
				<div class="form-group">
					<textarea class="form-control" name="content" id="content">${note.content}</textarea>
				</div>
				<button type="button" class="btn btn-block btn-primary" id="updateButton">更新</button>
			</form>
	</div>
</@l.htmlBody>