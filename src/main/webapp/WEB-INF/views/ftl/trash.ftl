<#import "layout/layout.ftl" as l>

<@l.htmlHead "废纸篓">
		<style>
		 	.list-group li:hover {
				background-color:#BDC3C7;
			}
		</style>
		<script>
			var pageNum = ${page.pageNum};
			var pages = ${page.pages};
		</script>
		<script src="${path}/js/my/page.js"></script>
		<script>
			$(document).ready(function() {
				$("#noteSetting").collapse();
				$("#main-nav > li:eq(3)").addClass("active");
			})
		</script>
</@l.htmlHead>

<@l.htmlBody>
		<div class="container">
		<h1 class="text-center"><i class="fa fa-list"></i>废纸篓 <small>废纸篓</small></h1>
		
		<ul class="list-group" id="notebookList">
			<#list page.list as note>
				<li class="list-group-item">
						<h4 class="list-group-item-heading">
							<i class="fa fa-sticky-note"></i>
							${note.title}
						</h4>
					<p class="list-group-item-text">
						最新修改于${note.updatetime?datetime}
						<a href="" style="display: none;"></a>
						&nbsp;&nbsp;<a href="${path}/note/delete/${note.id}"><i class="fa fa-cut"></i>彻底删除</a>
						&nbsp;&nbsp;<a href="${path}/note/updateStatus/${note.id}?status=1"><i class="fa fa-reply"></i>还原</a> 
					</p>
				</li>
				
				<br />
			</#list>
		</ul>
		
		<div id="page">
            <ul class="pagination">
              <#list page.navigatepageNums as i>
              	<li><a href="${path}/note/list/${Session.user.id}?status=0&pageNum=${i}">${i}</a></li>
              </#list>
            </ul>
          	<span>共${page.pages}页</span>
		</div>
		
	</div>
</@l.htmlBody>