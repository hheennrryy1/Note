<#import "layout/layout.ftl" as l>

<@l.htmlHead "所有笔记">
		<script src="${path}/js/my/allNoteList.js"></script>
		<script>
			var pageNum = ${page.pageNum};
			var pages = ${page.pages};
		</script>
		<script src="${path}/js/my/page.js"></script>
		<style>
		 	.list-group li:hover {
				background-color:#BDC3C7;
			}
		</style>
</@l.htmlHead>

<@l.htmlBody>
	<div class="container">
		<h1 class="text-center"><i class="fa fa-list"></i>所有笔记 <small>所有笔记</small></h1>
		
		<ul class="list-group" id="notebookList">
			<#list page.list as note>
				<li class="list-group-item">
					<a href="${path}/note/select/${note.id}">
						<h4 class="list-group-item-heading">
							<i class="fa fa-sticky-note"></i>
							${note.title}
						</h4>
					</a>
					<p class="list-group-item-text">
						最新修改于${note.updatetime?datetime}
						<a href="${path}/note/updateStatus/${note.id}?status=0" style="display: none;"></a>
						&nbsp;&nbsp;<a class="updateStatus"><i class="fa fa-trash fa-lg"></i></a>
					</p>
				</li>
				
				<br />
			</#list>
		</ul>
		
		<div id="page">
            <ul class="pagination">
              <#list page.navigatepageNums as i>
              	<li><a href="${path}/note/list/${Session.user.id}?status=1&pageNum=${i}">${i}</a></li>
              </#list>
            </ul>
          	<span>共${page.pages}页</span>
		</div>
		
	</div>
	
    <#--模态框-->
	<div class="modal fade" id="updateStatusModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
		    <div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">删除笔记</h4>
					</div>
					
					<div class="modal-body" id="modal-body"></div>
					<div class="modal-footer" id="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
						<a href="#" class="btn btn-primary">删除</a>
					</div>
			</div>
		</div>
	</div>
    <#---->   
</@l.htmlBody>