$(function() {
	$("#submit .btn").click(function(){
		var userNameValue = $('#username').val();
		var passwordValue = $('#password').val();
		if(!checkName(userNameValue) || !checkPassword(passwordValue)) return;

		$.ajax({
			url: '/login',
			type: 'POST',
			dataType:'text',
			data: {
				username : userNameValue,
				password : passwordValue
			},
			error: function (result) {
				alert("登录失败");
			},
			success: function (result, textStatus, request) {
				var token = request.getResponseHeader("Authorization");
				saveToken(token);
				window.location='/corporation/success';
			}
		});
	});
});

function checkName(name){
	if(name == null || name == ""){
		//提示错误
		alert("用户名不能为空");
		return false;
	}
	var reg = /^\w{3,10}$/;
	if(!reg.test(name)){
		alert("输入3-10个字母或数字或下划线");
		return false;
	}
	return true;
}

function checkPassword(password){
	if(password == null || password == ""){
		//提示错误
		alert("密码不能为空");
		return false;
	}
	var reg = /^\w{3,10}$/;
	if(!reg.test(password)){
		alert("输入3-10个字母或数字或下划线");
		return false;
	}
	return true;
}