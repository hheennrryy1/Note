<#import "layout/layout.ftl" as l>

<@l.htmlHead "笔记本">
<script>
	$(document).ready(function(){
		$("#notebookSetting").collapse();
		
		$("#main-nav > li:eq(2)").addClass("active");
		
		
	})
</script>
</@l.htmlHead>

<@l.htmlBody>
	<div class="container">
		<#list notebooks as notebook>
			<div class="list-group">
				<a href="http://www.qq.com" class="list-group-item active">
					<h4 class="list-group-item-heading">${notebook.name}</h4>
					<p class="list-group-item-text">共?条笔记</p>
					<p class="list-group-item-text">创建于 &nbsp;&nbsp;${notebook.createtime?datetime}</p>
	 			 </a>
			</div>
		</#list>
	</div>
</@l.htmlBody>