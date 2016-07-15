<#import "layout/layout.ftl" as l>

<@l.htmlHead "更改密码">
	<script src="${path}/js/my/password.js"></script>
</@l.htmlHead>

<@l.htmlBody>
	<div class="container col-md-6 col-md-offset-2" id="password-div">
		<form action="" method="POST">
		
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon"><i class="fa fa-key fa-fw"></i></div>
					<input type="password" class="form-control" name="oldPassword" id="oldPassword" placeholder="旧密码" required="required"/>
				</div>
			</div>
			
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon"><i class="fa fa-key fa-fw"></i></div>
					<input type="password" class="form-control" name="newPassword1" id="newPassword1" placeholder="新密码" required="required"/>
				</div>
			</div>
			
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon"><i class="fa fa-key fa-fw"></i></div>
					<input type="password" class="form-control" name="newPassword2" id="newPassword2" placeholder="确认新密码" required="required"/>
				</div>
			</div>
		
			<button class="btn btn-primary btn-block">提交</button>
		</form>
	</div>
</@l.htmlBody>