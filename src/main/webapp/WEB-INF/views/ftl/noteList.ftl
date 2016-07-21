<#import "layout/layout.ftl" as l>

<@l.htmlHead "笔记列表">
	<script>
		$(document).ready(function() {
				$("#notebookSetting").collapse();
				$("#main-nav > li:eq(2)").addClass("active");
		})
	</script>
</@l.htmlHead>

<@l.htmlBody>
	<div class="container">
		<h1 class="text-center"><i class="fa fa-book"></i>${notebook.name} <small>${notebook.name}</small></h1>
		
		<ul class="list-group" id="notebookList">
			<#list notebook.notes as note>
				<li class="list-group-item">
					<a href="#">
						<h4 class="list-group-item-heading">
							<i class="fa fa-sticky-note"></i>
							${note.title}
						</h4>
					</a>
					<p class="list-group-item-text">
						最新修改于${note.updatetime?datetime}
						&nbsp;&nbsp;<a data-toggle="modal" data-target="#deleteModal"><i class="fa fa-trash fa-lg"></i></a>
					</p>
				</li>
				
				
			    <#--模态框-->
				<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document">
					    <div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
									<h4 class="modal-title" id="myModalLabel">删除笔记</h4>
								</div>
								
								<div class="modal-body">
									确认${note.title}删除吗？
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
									<a href="${path}/note/delete/${note.id}" class="btn btn-primary">删除</a>
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