<#import "layout/layout.ftl" as l>

<@l.htmlHead "${note.title}">
		<script src="${path}/js/public/summernote.min.js"></script>
		<script src="${path}/js/public/summernote-zh-CN.min.js"></script>
		<script src="${path}/js/my/note.js"></script>
		<link rel="stylesheet" href="${path}/css/summernote.css"/>
</@l.htmlHead>

<@l.htmlBody>
	<div class="container col-md-8 col-md-offset-1" id="main-div">
			<form action="${path}/note/update" method="POST">
				<a href="#" data-toggle="modal" data-target="#infoModal">
					<i class="fa fa-info-circle fa-2x"></i>
				</a>
				
				<a href="#" data-toggle="modal" data-target="#updateStatusModal">
					<i class="fa fa-trash fa-2x"></i>
				</a>
				
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
			
			<div class="alert alert-success text-center" role="alert" id="success" style="display: none;"></div>
			<div class="alert alert-danger text-center" role="alert" id="danger" style="display: none;"></div>
	</div>
	
	<#--模态框-->
	<div class="modal fade" id="infoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
		    <div class="modal-content">
				<div class="modal-header text-center">
					<h4 class="modal-title" id="myModalLabel">笔记信息</h4>
					<h3 class="model-title">${note.title}</h3>
				</div>
				
				<div class="modal-body form-group">
					<p>创建时间：${note.createtime?datetime}</p>
					<p>更新时间：${note.updatetime?datetime}</p>
				</div>
		        	
				<div class="modal-footer">
					<button type="button" class="btn btn-success btn-block" data-dismiss="modal">返回</button>
				</div>
			</div>
		</div>
	</div>
    <#---->    
    
    <#--模态框-->
	<div class="modal fade" id="updateStatusModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
		    <div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title">删除笔记</h4>
					</div>
					
					<div class="modal-body">确定删除${note.title}吗？</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
						<a href="${path}/note/updateStatus/${note.id}?nbid=${note.notebook.id}" class="btn btn-primary">删除</a>
					</div>
			</div>
		</div>
	</div>
    <#---->   
</@l.htmlBody>