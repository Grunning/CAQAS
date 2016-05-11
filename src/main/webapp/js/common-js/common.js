function putNavContent() {
	var map = ajax("POST", "getUserSession", {}, "json");
	if (map.userRole == 0) {
		$("#nav-content").html("<a class='navbar-brand' href='/CAQAS/answer-search.html'>Home</a> " +
				"<a class='navbar-brand' href='/CAQAS/admin-question.html'>Question</a>" +
				"<a class='navbar-brand' href='/CAQAS/admin-answer.html'>Answer</a> " +
				"<a class='navbar-brand' href='/CAQAS/admin-department.html'>Department</a>" +
				"<a class='navbar-brand' href='/CAQAS/admin-category.html'>Category</a>" +
		"<a class='navbar-brand' href='/CAQAS/admin-user.html'>User</a>");
	} else {
		$("#nav-content").html("<a class='navbar-brand' href='/CAQAS/answer-search.html'>Home</a> " +
				"<a class='navbar-brand' href='/CAQAS/admin-question.html'>Question</a>" +
				"<a class='navbar-brand' href='/CAQAS/admin-answer.html'>Answer</a> " +
				"<a class='navbar-brand' href='/CAQAS/admin-category.html'>Category</a>");
	}
	
	//展示用户信息
	$("#userName").html("<div class='navbar-form navbar-right'>"
			+"<p style='color:white;margin-top:4px;'>用户名："+ map.userName +"</p></div>");
	
	//根据角色按钮禁用
	if (map.userRole == 0) {
		$('#btnOfAdd').attr('disabled',"true");
		$('#btnOfUpdate').attr('disabled',"true");
		$('#btnOfDelete').attr('disabled',"true");
	}
	
	if (map.userRole == 1) {
		$("#btnByRole").html("<button class='btn btn-default btn-sm' style='margin-right:5px;' onclick='javascript:selectAll();'>&nbsp;全&nbsp;部&nbsp;</button>" +
				"<button class='btn btn-primary btn-sm' style='margin-right:5px;' onclick='javascript:selectIsSolved();'>已解决</button>" +
				"<button class='btn btn-warning btn-sm' onclick='javascript:selectNotSolved();'>待解决</button>");
	}
}