$(document).ready(function() {
	$("button").click(function() {
		var SHA512 = new Hashes.SHA512();			
		var username = $("#username").val();
		var password = $("#password").val();
		password = SHA512.hex(password);	
		var args = {
			username : username,
			password : password
		};
		$.post("login", args, function(data) {
			if(data==-1) {
				alert("用户不存在");						
			}
			else if(data==0) {
				alert("用户名或密码错误");
			}
			else {
				window.location.href = "index";
			}
		});
	});
})	