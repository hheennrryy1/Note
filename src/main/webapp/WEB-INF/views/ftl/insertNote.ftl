<#import "layout/layout.ftl" as l>

<@l.htmlHead "创建笔记">
		<script src="${path}/js/public/summernote.min.js"></script>
		<script src="${path}/js/my/insertNote.js"></script>
		<link rel="stylesheet" href="${path}/css/summernote.css"/>
</@l.htmlHead>

<@l.htmlBody>
	<div class="container col-md-8 col-md-offset-1" id="main-div">
		<form action="${path}/note/insert" method="POST">
		
			<select name="notebook.name" id="notebookName" class="form-control">
				<#list notebooks as notebook>
					<option value="${notebook.name}" <#if note.notebook.name == notebook.name>selected</#if>>
						${notebook.name}
					</option>
				</#list>
			</select>
			
			<div class="form-group">
				<input type="text" class="form-control" name="title" id="title" required="required" placeholder="输入标题"/>
			</div>
			
			<div class="form-group">	
				<textarea class="form-control" name="content" id="content" required="required"></textarea>
			</div>
			
			<button type="submit" class="btn btn-block btn-primary" id="insertNoteButton">创建</button>
		</form>
	</div>
</@l.htmlBody>