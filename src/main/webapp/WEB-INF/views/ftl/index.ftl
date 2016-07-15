<#import "layout/layout.ftl" as l>

<@l.htmlHead "首页">
		<script src="${path}/js/public/summernote.min.js"></script>
		<link rel="stylesheet" href="${path}/css/summernote.css"/>
		<script>
			$(document).ready(function(){
				$("#main-nav li:eq(0)").addClass("active");
				$('#summernote').summernote({
				  height: 300,                 // set editor height
				  minHeight: null,             // set minimum height of editor
				  maxHeight: null,             // set maximum height of editor
				  focus: true                  // set focus to editable area after initializing summernote
				});
			})	
		</script>
</@l.htmlHead>

<@l.htmlBody>
	<div class="container col-md-6" id="main-div">
		<div id="summernote">Hello Summernote</div>
	</div>
</@l.htmlBody>