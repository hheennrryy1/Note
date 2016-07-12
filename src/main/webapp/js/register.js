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
		$.post("signin", args, function(data) {
			alert(data);
		});
	});
})	