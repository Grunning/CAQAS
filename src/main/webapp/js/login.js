var userName;
var userPassword;

function getParam() {
	userName = document.getElementById("userName").value;
	userPassword = document.getElementById("userPassword").value;
}

//登录
function login() {
	getParam();
	var data = {"userName":userName, "userPassword":userPassword};
	var map = ajax("POST", "login", data, "json");
	if (map.result == "验证成功") {
		var array = [];
		var url = window.location.href;
		array = url.split("/CAQAS/");
		var newURL = array[0] + "/CAQAS/admin-question.html";
		self.location = newURL;
	} else {
		alert("用户名或密码错误！");
	}
}

//注销
function logout() {
	var judge = confirm("是否注销？");
	if (judge == true) {
		var data = {};
		var map = ajax("POST", "logout", data, "json");
		if (map.result == 1) {
			alert("注销成功！");
			self.location = window.location.href;
		} else {
			alert("注销失败！");
		}
	}
}