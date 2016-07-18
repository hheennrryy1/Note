$(document).ready(function(){
	
	$("#userSetting").collapse();
	
	$("#main-nav li:eq(1)").addClass("active");
	
	$('#passwordForm').validator().on('submit', function (e) {
		  if (e.isDefaultPrevented()) {
		  } else {
			  var SHA512 = new Hashes.SHA512();	
			  var newPassword = $("#password").val();
			  newpassword = SHA512.hex(password);			
			  var args = {
					  password : newPassword
			  };
			  
			  $.post("user/updatePassword", args, function(data) {
				  
			  });
		  }
	});
})