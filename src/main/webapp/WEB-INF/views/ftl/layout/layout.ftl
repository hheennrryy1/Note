<#global path = request.getContextPath()/>

<#macro htmlHead title charset="utf-8" lang="zh-CN">
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>${title}</title>
		<script src="${path}/js/public/jquery.min.js"></script>
		<script src="${path}/js/public/bootstrap.min.js"></script>
		<link rel="stylesheet" href="${path}/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${path}/css/flat-ui.min.css" />
		<link rel="stylesheet" href="${path}/css/font-awesome.min.css" />
		<link rel="stylesheet" href="${path}/css/layout.css" />
		<#nested>
	</head>
</#macro>

<#macro htmlBody>
<body>

	<div class="navbar navbar-static-top" role="navigation">
	        <div class="container-fluid">
	            <div class="navbar-header">
	                <a class="navbar-brand" href="javascript:void(0)" id="logo">NOTE</a>
	            </div>
	        </div>
	</div>
	
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-2">
                <ul id="main-nav" class="nav nav-tabs nav-stacked">
                    <li>
                        <a href="${path}/user/index">
                           	 <i class="fa fa-home fa-fw"></i>首页         
                        </a>
                    </li>
                    <li>
                        <a href="#userSetting" class="nav-header collapsed" data-toggle="collapse">
					    	<i class="fa fa-user fa-fw"></i>用户管理
                        </a>
                        <ul id="userSetting" class="nav nav-list collapse secondmenu" style="height: 0px;">
                            <li><a href="${path}/user/password">修改密码</a></li>
                            <li><a href="${path}/user/logout">登出</a></li>
                            <li><a href="#">功能</a></li>
                            <li><a href="#">功能</a></li>
                            <li><a href="#">功能</a></li>
                        </ul>
                    </li>
                    
                    <li>
                        <a href="#notebookSetting" class="nav-header collapsed" data-toggle="collapse">
					    	<i class="fa fa-book fa-fw"></i>笔记本管理
                        </a>
                        <ul id="notebookSetting" class="nav nav-list collapse secondmenu" style="height: 0px;">
                            <li><a href="#">笔记</a></li>
                            <li><a href="#">笔记</a></li>
                            <li><a href="#">笔记</a></li>
                            <li><a href="#">笔记</a></li>
                            <li><a href="#">笔记</a></li>
                        </ul>
                    </li>
                    
                    <li>
                        <a href="#noteSetting" class="nav-header collapsed" data-toggle="collapse">
					           	<i class="fa fa-sticky-note fa-fw"></i>笔记
                        </a>
                        <ul id="noteSetting" class="nav nav-list collapse secondmenu" style="height: 0px;">
                            <li><a href="#">笔记</a></li>
                            <li><a href="#">笔记</a></li>
                            <li><a href="#">笔记</a></li>
                            <li><a href="#">笔记</a></li>
                            <li><a href="#">笔记</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
			<#nested>
        </div>
    </div>
</body>
</html>
</#macro>