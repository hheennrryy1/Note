<#import "layout/layout.ftl" as l>

<@l.htmlHead "笔记本">
		<script src="${path}/js/my/noteBookList.js"></script>
		<script>
			$(document).ready(function(){
				var pageNum = ${page.pageNum}; <#-- 这里从0开始 -->
				var pages = ${page.pages}; <#--总页数-->
				if(pageNum<=5) {
					$("#page ul li").eq(pageNum-1).addClass("active");
				}
				else if(pages == pageNum+2) {
					$("#page ul li").eq(5).addClass("active");
				}
				else if(pages == pageNum+1) {
					$("#page ul li").eq(6).addClass("active");
				}
				else if(pages == pageNum) {
					$("#page ul li").eq(7).addClass("active");
				}
				else {
					$("#page ul li").eq(4).addClass("active");
				}
			})
		</script>
		<style>
		 	.list-group li:hover {
				background-color:#BDC3C7;
			}
		</style>
</@l.htmlHead>

<@l.htmlBody>
	<div class="container">
		<ul class="list-group">
			<#list page.list as notebook>
				<li class="list-group-item">
					<a href="${path}/notebook/noteList/${notebook.id}">
						<h4 class="list-group-item-heading"><i class="fa fa-book"></i>${notebook.name}</h4>
					</a>
					
					<p class="list-group-item-text"></p>
					<input type="text" name="id" value="${notebook.id}" style="display: none;"/>
					
					<p class="list-group-item-text">
						创建于${notebook.createtime?datetime}
						<a href="${path}/notebook/delete/${notebook.id}" style="display: none;"></a>
						&nbsp;&nbsp;<a class="delete" href="#"><i class="fa fa-trash fa-lg"></i></a>
					</p>
				</li>
				<br />
			</#list>
		</ul>
		
		<div id="page">
            <ul class="pagination">
              <#list page.navigatepageNums as i>
              	<li><a href="${path}/notebook/list/${Session.user.id}?pageNum=${i}">${i}</a></li>
              </#list>
            </ul>
            
          	  <span>共${page.pages}页</span>
		</div>
      
      
      
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