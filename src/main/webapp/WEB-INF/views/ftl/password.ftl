<#import "layout/layout.ftl" as l>

<@l.htmlHead "更改密码">
	<script src="${path}/js/public/validator.min.js"></script>
	<script src="${path}/js/my/password.js"></script>
</@l.htmlHead>

<@l.htmlBody>
	<div class="container col-md-6 col-md-offset-2" id="password-div">
		<form action="#" method="POST" id="passwordForm" role="form" data-toggle="validator">
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon"><i class="fa fa-key fa-fw"></i></div>
					<input type="password" class="form-control" name="password" id="password" 
						placeholder="旧密码" required="required"/>
				</div>
			</div>
			
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon"><i class="fa fa-key fa-fw"></i></div>
					<input type="password" class="form-control" name="newPassword" id="newPassword" 
						placeholder="新密码" required="required" data-minlength="6"/>
				</div>
				
				<div class="help-block with-errors"></div>
				
			</div>
			
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon"><i class="fa fa-key fa-fw"></i></div>
					<input type="password" class="form-control" name="newPasswordConfirm" id="newPasswordConfirm" 
						placeholder="确认新密码" required="required" data-match="#newPassword" data-match-error="两次输入不一致" data-minlength="6"/>
				</div>
				
				<div class="help-block with-errors"></div>
				
			</div>
		
			<button type="submit" class="btn btn-primary btn-block">提交</button>
		</form>
	</div>
</@l.htmlBody>