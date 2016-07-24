<#import "layout/layout.ftl" as l>

<@l.htmlHead "笔记本">
		<script src="${path}/js/my/noteBookList.js"></script>
		<style>
		 	#notebookList li:hover {
				background-color:#2980B9;
			}
		</style>
</@l.htmlHead>

<@l.htmlBody>
	<div class="container">
		<ul class="list-group">
			<#list notebooks as notebook>
				<li class="list-group-item">
					<a href="${path}/notebook/noteList/${notebook.id}">
						<h4 class="list-group-item-heading"><i class="fa fa-book"></i>${notebook.name}</h4>
					</a>
					
					<p class="list-group-item-text"></p>
					<input type="text" name="id" class="input" value="${notebook.id}" style="display: none;"/>
					
					<p class="list-group-item-text">
						创建于${notebook.createtime?datetime}
						<a href="${path}/notebook/delete/${notebook.id}" style="display: none;"></a>
						&nbsp;&nbsp;<a class="delete" href="#"><i class="fa fa-trash fa-lg"></i></a>
					</p>
				</li>
				<br />
			</#list>
		</ul>
	</div>
	
    <#--模态框-->
	<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
		    <div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">删除笔记本</h4>
					</div>
					
					<div class="modal-body" id="modal-body">
						
					</div>
					<div class="modal-footer" id="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
						<a href="#" class="btn btn-primary">删除</a>
					</div>
			</div>
		</div>
	</div>
    <#---->    
</@l.htmlBody>