<#import "layout/layout.ftl" as l>

<@l.htmlHead "笔记">
		<script src="${path}/js/public/summernote.min.js"></script>
		<script src="${path}/js/my/note.js"></script>
		<link rel="stylesheet" href="${path}/css/summernote.css"/>
</@l.htmlHead>

<@l.htmlBody>
	<div class="container col-md-8 col-md-offset-1" id="main-div">
		<form action="" method="POST">
			<div class="form-group">
				<input type="text" class="form-control" required="required" value="${note.title}"/>
			</div>
			
			<div class="form-group">	
				<textarea class="form-control" id="summernote">${note.content}</textarea>
			</div>
			
			<button type="button" class="btn btn-block btn-primary" id="updateButton">更新</button>
		</form>
	</div>
</@l.htmlBody>