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
		<ul class="list-group" id="notebookList">
			<#list notebooks as notebook>
				<li class="list-group-item">
					<a href="${path}/notebook/noteList/${notebook.id}">
						<h4 class="list-group-item-heading"><i class="fa fa-book"></i>${notebook.name}</h4>
					</a>
					<p class="list-group-item-text">共?条笔记</p>
					<p class="list-group-item-text">
						创建于${notebook.createtime?datetime}
						&nbsp;&nbsp;<a data-toggle="modal" data-target="#deleteModal"><i class="fa fa-trash fa-lg"></i></a>
					</p>
				</li>
				
			
                    <#--模态框-->
					<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
						<div class="modal-dialog" role="document">
						    <div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										<h4 class="modal-title" id="myModalLabel">删除笔记本</h4>
									</div>
									
									<div class="modal-body">
										确认${notebook.name}删除吗？
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
										<a href="${path}/notebook/delete/${notebook.id}" class="btn btn-primary">删除</a>
									</div>
							</div>
						</div>
					</div>
                    <#---->    
								
				<br />
			</#list>
		</ul>
	</div>
</@l.htmlBody>