<!DOCTYPE html>
<html>
	<#assign path = request.getContextPath()>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>首页</title>
		<link rel="stylesheet" href="${path}/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${path}/css/flat-ui.min.css" />
		<link rel="stylesheet" href="${path}/css/font-awesome.min.css" />
		<link rel="stylesheet" href="${path}/css/index.css" />
		<script src="${path}/js/jquery.min.js"></script>
		<script src="${path}/js/bootstrap.min.js"></script>
	</head>
<body>

	<div class="navbar navbar-static-top" role="navigation">
	        <div class="container-fluid">
	            <div class="navbar-header">
	                <a class="navbar-brand" href="${path}/index" id="logo">NOTE</a>
	            </div>
	        </div>
	</div>

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-2">
                <ul id="main-nav" class="nav nav-tabs nav-stacked">
                    <li class="active">
                        <a href="#">
                           	 首页         
                        </a>
                    </li>
                    <li>
                        <a href="#systemSetting" class="nav-header collapsed" data-toggle="collapse">
					                            系统管理
                               <span class="pull-right glyphicon glyphicon-chevron-down"></span>
                        </a>
                        <ul id="systemSetting" class="nav nav-list collapse secondmenu" style="height: 0px;">
                            <li><a href="#">用户管理</a></li>
                            <li><a href="#">菜单管理</a></li>
                            <li><a href="#">角色管理</a></li>
                            <li><a href="#">修改密码</a></li>
                            <li><a href="#">日志查看</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="./plans.html">
                        	XXXX      
                        </a>
                    </li>
 
                    <li>
                        <a href="./grid.html">
                         	   XXXX
                            <span class="label label-warning pull-right">5</span>
                        </a>
                    </li>
 
                    <li>
                        <a href="./charts.html">
                     		XXXX
                        </a>
                    </li>
                    <li>
                        <a href="#">
                           	XXXX
                        </a>
                    </li>
 
                </ul>
            </div>
            
            
            <div class="col-md-10">
				主窗口
            </div>
            
        </div>
    </div>
</body>
</html>