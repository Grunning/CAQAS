var currentPage = 1;// 当前页
var pageNum = 10;// 每页条数
var solved = 2;//是否解决 2：全部，1：已解决，0：未解决
var map = {};
var quesId;

//模态框查看内容
function searchContent(obj) {
	$.each(map.result, function(i, item) {
		if (item.quesId == obj.value) {
			$("#title").html(
			"<h4 class='modal-title' id='myModalLabel'>" + item.quesTitle + "</h4>");
			$("#content").html("<div class='modal-body'>" + item.answContent + "</div>");
		}
	});
}

//问题分配
function distributeQues(obj) {
	quesId = obj.value;
	$.each(map.result, function(i, item) {
		if (item.quesId == obj.value) {
			$("#titleQues").html(
			"<h4 class='modal-title' id='myModalLabel'>" + item.quesTitle + "</h4>");
		}
	});
}

//修改类别
function categoryUpdate(obj) {
	quesId = obj.value;
	$.each(map.result, function(i, item) {
		if (item.quesId == obj.value) {
			$("#titleCategory").html(
			"<h4 class='modal-title' id='myModalLabel'>" + item.quesTitle + "</h4>");
			$("#categorySelect").get(0).value = item.cateName;
		}
	});
}

//部门列表初始化
function selectDepsOfQues() {
	var data = {"page":-1, "pageNum":-1};
	var result = ajax("POST", "selectAllDepartments", data, "json");
	var html = "";
	$.each(result.result, function(i,item){
		html += "<option value='" + item.depName + "'>" + item.depName + "</option>"
	});
	$("#departmentSelect").html(html);
}

//分配用户下拉列表
function selectUserOfQues() {
	var userName = $("#departmentSelect").val();
	var dataDep = {"depName":userName};
	var result = ajax("POST", "selectByDepName", dataDep, "json");
	var userDepId = result.depId;
	var map = ajax("POST", "selectUserByDepId", {"userDepId":userDepId}, "json");
	var html = "";
	$.each(map.result, function(i,item){
		html += "<option value='" + item.userId + "'>" + item.userName + "</option>"
	});
	$("#userSelect").html(html);
}

//问题列表类别
function selectCategoryOfQues() {
	var map = ajax("POST", "selectAllCates", {}, "json");
	var html = "";
	$.each(map.result, function(i,item){
		html += "<option value='" + item.cateName + "'>" + item.cateName + "</option>"
	});
	$("#categorySelect").html(html);
}

//部门列表选择改变用户列表相应改变
function depOnChange() {
	selectUserOfQues();
}

//分配问题给指定用户
function distributeQuesToUser() {
	var quesUserId = $("#userSelect").val();
	var map = ajax("POST", "updateQuestion", {"quesId":quesId, "quesUserId":quesUserId}, "json");
	if (map == 1) {
		alert("分配成功！");
		location.reload();
	} else {
		alert("分配失败！");
	}
}

//修改问题的类别
function updateQuesCategory() {
	var cateName = $("#categorySelect").val();
	var result = ajax("POST", "selectByCateName", {"cateName":cateName}, "json");
	var quesCateId = result.cateId;
	var map = ajax("POST", "updateQuestion", {"quesId":quesId, "quesCateId":quesCateId}, "json");
	if (map == 1) {
		alert("修改成功！");
		location.reload();
	} else {
		alert("修改失败！");
	}
}

/**
 * 页面初始化
 */
function selectAllQuestions() {
	var session = ajax("POST", "getUserSession", {}, "json");
	if (session.userRole == 1) {
		var data = {"page":currentPage, "pageNum":pageNum, "solved":solved};
		map = ajax("POST", "selectQuestionsByUserId", data, "json");
		var html = "";
		var num = 0;
		$.each(map.result,function(i, item) {
							if (item.answContent == null || item.answContent == "") {
								num ++;
								html += "<div class='panel panel-warning panel-body'><span>"
										+ num + "、" + item.quesTitle + "</span><button class='btn btn-warning btn-xs navbar-right' style='margin-right: 20px;' value='" + item.quesId + "' onclick='javascript:putAnswer(this);'>回答</button>" +
												"<button class='btn btn-danger btn-xs navbar-right' value='" + item.quesId + "' style='margin-right: 5px;' onclick='javascript:deleteByQuesId(this);'>删除</button>" +
												"<button class='btn btn-success btn-xs navbar-right' value='" + item.quesId + "' style='margin-right: 5px;' data-toggle='modal' data-target='#categoryUpdateModel' onclick='javascript:categoryUpdate(this);'>修改类别</button>" +
												"<span class='navbar-right' style='margin-right: 20px;'>时间：" + item.quesCreateTime + "</span><span class='navbar-right' style='margin-right: 20px;'>频次："
												+ item.searchNum +"</span><span class='navbar-right' style='margin-right: 20px;'>类别：" + item.cateName + "</span></div>";
							} else {
								num ++;
								html += "<div class='panel panel-info panel-body'><span>"
										+ num + "、" + item.quesTitle
										+ "</span><button class='btn btn-primary btn-xs navbar-right' value='"
										+ item.quesId
										+ "' onclick='javascript:updateAnswer(this);' style='margin-right: 20px;'>修改</button>" +
												"<button class='btn btn-info btn-xs navbar-right' value='" + item.quesId + "' data-toggle='modal' data-target='#myModal' onclick='javascript:searchContent(this);' style='margin-right: 5px;'>查看</button>" +
												"<button class='btn btn-success btn-xs navbar-right' value='" + item.quesId + "' style='margin-right: 5px;' data-toggle='modal' data-target='#categoryUpdateModel' onclick='javascript:categoryUpdate(this);'>修改类别</button>" +
												"<span class='navbar-right' style='margin-right: 20px;'>时间：" + item.quesCreateTime + "</span><span class='navbar-right' style='margin-right: 20px;'>频次："
												+ item.searchNum +"</span><span class='navbar-right' style='margin-right: 20px;'>类别：" + item.cateName + "</span></div>"
							}
						});
		$("#question").html(html);
	} else {
		var data = {"page":currentPage, "pageNum":pageNum};
		map = ajax("POST", "selectQuestionsByAdmin", data, "json");
		var html = "";
		var num = 0;
		$.each(map.result,function(i, item) {
			num ++;
			html += "<div class='panel panel-warning panel-body'><span>"
					+ num + "、" + item.quesTitle + "</span>" +
							"<button class='btn btn-danger btn-xs navbar-right' value='" + item.quesId + "' style='margin-right: 20px;' onclick='javascript:deleteByQuesId(this);'>删除</button>" +
							"<button class='btn btn-primary btn-xs navbar-right' value='" + item.quesId + "' data-toggle='modal' data-target='#distributeQuesModel' onclick='javascript:distributeQues(this);' style='margin-right: 5px;'>问题分配</button>" +
							"<span class='navbar-right' style='margin-right: 20px;'>时间：" + item.quesCreateTime + "</span><span class='navbar-right' style='margin-right: 20px;'>频次："
							+ item.searchNum +"</span></div>";
		});
		$("#question").html(html);
	}
}

//已解决
function selectIsSolved() {
	currentPage = 1;
	solved = 1;
	selectAllQuestions();
}

//未解决
function selectNotSolved() {
	currentPage = 1;
	solved = 0;
	selectAllQuestions();
}

//全部
function selectAll() {
	currentPage = 1;
	solved = 2;
	selectAllQuestions();
}

//根据问题Id删除
function deleteByQuesId(obj) {
	var data = {"quesId":obj.value};
	var map = ajax("POST", "deleteByQuesId", data, "json");
	if (map == 1) {
		alert("删除成功！");
		window.location.reload();
	} else {
		alert("删除失败！");
		window.location.reload();
	}
}

//回答
function putAnswer(obj) {
//	var deliverTitle;
//	$.each(map.result, function(i, item) {
//		if (item.quesId == obj.value) {
//			deliverTitle = item.quesTitle;
//		}
//	});
	var array = [];
	var url = window.location.href;
	array = url.split("/CAQAS/");
	var newURL = array[0] + "/CAQAS/admin-answer.html?"+ "id=" + obj.value;
	self.location = newURL;
}

//修改
function updateAnswer(obj) {
//	var title;
//	var content;
//	$.each(map.result, function(i, item) {
//		if (item.quesId == obj.value) {
//			title = item.quesTitle;
//			content = item.answContent;
//		}
//	});
	var array = [];
	var url = window.location.href;
	array = url.split("/CAQAS/");
	var newURL = array[0] + "/CAQAS/admin-answer.html?"+ "id=" + obj.value;
	self.location = newURL;
}

//下一页
function getNextPage() {
	currentPage ++;
	selectAllQuestions();
}

//上一页
function getPreviousPage() {
	if (currentPage > 1) {
		currentPage --;
		selectAllQuestions();
	} else {
		alert("已到第一页！");
	}
}