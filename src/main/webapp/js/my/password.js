$(document).ready(function(){
	$("#userSetting").collapse();
	
	$("#main-nav > li:eq(1)").addClass("active");
	
	
	$("#passwordForm").validator().on('submit', function (e) {
		  if (e.isDefaultPrevented()) {
			  
		  } else {
			  var SHA512 = new Hashes.SHA512();	
			  var newPassword = $("#newPassword").val();
			  newPassword = SHA512.hex(newPassword);
			  var oldPassword = $("#oldPassword").val();
			  oldPassword = SHA512.hex(oldPassword);
			  var args = {
					  oldPassword : oldPassword,
					  newPassword : newPassword
			  };
			  
			  $.post(path + "/user/updatePassword", args, function(data) {
				  if(data=="success") {
					  $("#message-block").text("修改成功");
				  }
				  if(data=="fail") {
					  $("#message-block").text("旧密码错误");
				  }
			  });
		  }
	});
})