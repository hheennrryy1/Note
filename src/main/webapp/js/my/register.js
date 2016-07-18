$(document).ready(function() {
		$('#myForm').validator().on('submit', function (e) {
			  if (e.isDefaultPrevented()) {
			  } else {
				  var SHA512 = new Hashes.SHA512();	
				  var username = $("#username").val();
				  var password = $("#password").val();
				  password = SHA512.hex(password);			
				  var args = {
						  username : username,
						  password : password
				  };
				  
				  $.post("user/register", args, function(data) {
					  if(data=="fail") {
						  alert("用户名已存在");
					  }
					  else {
						  alert("成功");
					  }
				  });
			  }
		});
})	