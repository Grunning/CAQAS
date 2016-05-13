var id;
var currentPage = 1;
var pageNum = 5;

//点击登陆
function signIn() {
	var array = [];
	var url = window.location.href;
	array = url.split("/CAQAS/");
	var newURL = array[0] + "/CAQAS/login.html";
	self.location = newURL;
}

//判断url是否含有参数
function getUrl() {
	var url = window.location.href;
	if (url.indexOf("?") != -1) {
		var arr = [];
		arr = url.split("?");
		id = arr[1].split("=")[1];
	}
}

//查询常问问题
function selectUsualQuestions() {
	var map = ajax("POST", "selectQuestionsBySearchNum", {"quesCateId":id}, "json");
	var html = "";
	var num = 0;
	html += "<ol class='breadcrumb'><li><span class='word'>最常问前五个问题及答案（点击问题标题展开答案）：</span></li></ol>";
	$.each(map.result,function(i, item){
		if (i == 0) {
			num ++;
			html += "<div class='panel panel-default panel-body'><a data-toggle='collapse' data-parent='#accordion' href='#" + item.quesId + "'>" 
			+ num +"、" + item.quesTitle + "</a><div id='" + item.quesId + "' class='panel-collapse collapse in'><div class='panel-body'><hr>" + item.answContent + "</div><a data-toggle='collapse' data-parent='#accordion' href='#" + item.quesId + "' class='navbar-right' style='margin-right:22px;'>收起 &#8593;</a></div></div>";
		} else {
			num ++;
			html += "<div class='panel panel-default panel-body'><a data-toggle='collapse' data-parent='#accordion' href='#" + item.quesId + "'>" 
			+ num +"、" + item.quesTitle + "</a><div id='" + item.quesId + "' class='panel-collapse collapse'><div class='panel-body'><hr>" + item.answContent + "</div><a data-toggle='collapse' data-parent='#accordion' href='#" + item.quesId + "' class='navbar-right' style='margin-right:22px;'>收起 &#8593;</a></div></div>";
		}
	});
	$("#usualQuestions").html(html);
}

//页面跳转至查询页面
function jumpToSearchPage() {
	var searchTitle = document.getElementById("searchTitle").value;
	var array = [];
	var url = window.location.href;
	array = url.split("/CAQAS/");
	var newURL = array[0] + "/CAQAS/search.html?q="+searchTitle;
	self.location = newURL;
}

//问题提问
function btnSearch() {
	currentPage = 1;
	var quesIdArray = [];
	var searchTitle = document.getElementById("searchTitle").value;
	if (searchTitle != null && searchTitle != "") {
		var data = {"searchTitle":searchTitle, "page":currentPage, "pageNum":pageNum};
		var map = ajax("POST", "selectVagueQuestionsSearch", data, "json");
		var usualQuestionsHtml = "<ol class='breadcrumb'><li><span class='more'>推荐答案：</span></li></ol>";
		var num = 0;
		$.each(map.result, function(i,item){
			if (i == 0) {
				usualQuestionsHtml += "<div class='panel panel-default panel-body'><div class='panel-body'><hr>" + item.answContent + "<hr><div id='useBtnKKK_" + item.quesId + "' class='isUseful'></div></div></div>";
				quesIdArray.push(item.quesId);
			} else if (i == 1) {
				num ++;
				usualQuestionsHtml += "<ol class='breadcrumb'><li><span class='word'>更多相似问题及答案：</span></li></ol>";
				usualQuestionsHtml += "<div class='panel panel-default panel-body'><a data-toggle='collapse' data-parent='#accordion' href='#" + item.quesId + "'>" 
				+ num +"、" + item.quesTitle + "</a><div id='" + item.quesId + "' class='panel-collapse collapse'><div class='panel-body'><hr>" + item.answContent + "<hr><div id='useBtnKKK_" + item.quesId + "' class='isUseful'></div></div></div></div>";
				quesIdArray.push(item.quesId);
			} else {
				num ++;
				usualQuestionsHtml += "<div class='panel panel-default panel-body'><a data-toggle='collapse' data-parent='#accordion' href='#" + item.quesId + "'>" 
				+ num +"、" + item.quesTitle + "</a><div id='" + item.quesId + "' class='panel-collapse collapse'><div class='panel-body'><hr>" + item.answContent + "<hr><div id='useBtnKKK_" + item.quesId + "' class='isUseful'></div></div></div></div>";
				quesIdArray.push(item.quesId);
			}
		});
		if (map.result.length == 0) {
			usualQuestionsHtml += "<div class='panel panel-default panel-body'><div class='panel-body'><hr><p style='font-size:30px;color:red;'>Sorry，未找到相应问题的答案，该问题已被录入问题库，以等待管理人员回答。</p><hr></div></div>";
		}
		$("#searchAnswerContent").html(usualQuestionsHtml);
		//加载是否有用按钮
		$.each(quesIdArray, function(i,quesId){
			$.each(map.result, function(j,item){
				if (quesId == item.quesId) {
					var resultUseNum = ajax("POST", "selectFeedbackByIpAndQuesId", {"feedQuesId":quesId}, "json");
					if (resultUseNum == undefined) {
						$("#useBtnKKK_" + quesId).html("<button type='button' class='btn btn-success btn-sm btn-isUseful' value='" + quesId + "' onclick='javascript:useful(this);'>有用(" + item.quesIsuseNum + ")</button>" +
								"<button type='button' class='btn btn-warning btn-sm' value='" + quesId + "' onclick='javascript:noUseful(this);'>无用(" + item.quesNouseNum + ")</button>");
					} else {
						$("#useBtnKKK_" + quesId).html("<button type='button' class='btn btn-success btn-sm btn-isUseful' disabled>有用(" + item.quesIsuseNum + ")</button>" +
								"<button type='button' class='btn btn-warning btn-sm' disabled>无用(" + item.quesNouseNum + ")</button>");
					}
				}
			});
		});
		if (map.result.length != 0) {
			var btnHtml = "<button type='button' class='btn btn-primary' onclick='javascript:getMoreAnswer(" + num + ");'>GET MORE</button>";
			$("#btnGetMore").html(btnHtml);
		}
	} else {
		alert("请输入要提问的问题！");
	}
}

//获取更多相似问题及答案
function getMoreAnswer(num) {
	var searchTitle = document.getElementById("searchTitle").value;
	currentPage ++;
	var data = {"searchTitle":searchTitle, "page":currentPage, "pageNum":pageNum};
	var map = ajax("POST", "selectVagueQuestionsSearch", data, "json");
	var html = "";
	var quesIdArray = [];
	if (map.result.length == 0) {
		alert("没有更多内容！");
	} else {
		$.each(map.result, function(i,item){
			num ++;
			html += "<div class='panel panel-default panel-body'><a data-toggle='collapse' data-parent='#accordion' href='#" + item.quesId + "'>" 
			+ num +"、" + item.quesTitle + "</a><div id='" + item.quesId + "' class='panel-collapse collapse'><div class='panel-body'><hr>" + item.answContent + "<hr><div id='useBtnKKK_" + item.quesId + "' class='isUseful'></div></div></div></div>";
			quesIdArray.push(item.quesId);
		});
		$("#searchAnswerContent").children().last().after(html);
		$.each(quesIdArray, function(i,quesId){
			$.each(map.result, function(j,item){
				if (quesId == item.quesId) {
					var resultUseNum = ajax("POST", "selectFeedbackByIpAndQuesId", {"feedQuesId":quesId}, "json");
					if (resultUseNum == undefined) {
						$("#useBtnKKK_" + quesId).html("<button type='button' class='btn btn-success btn-sm btn-isUseful' value='" + quesId + "' onclick='javascript:useful(this);'>有用(" + item.quesIsuseNum + ")</button>" +
								"<button type='button' class='btn btn-warning btn-sm' value='" + quesId + "' onclick='javascript:noUseful(this);'>无用(" + item.quesNouseNum + ")</button>");
					} else {
						$("#useBtnKKK_" + quesId).html("<button type='button' class='btn btn-success btn-sm btn-isUseful' disabled>有用(" + item.quesIsuseNum + ")</button>" +
								"<button type='button' class='btn btn-warning btn-sm' disabled>无用(" + item.quesNouseNum + ")</button>");
					}
				}
			});
		});
	}
}

//点击有用按钮
function useful(obj) {
//	alert(obj.value);
	var quesId = obj.value;
	ajax("POST", "updateIsuseNum", {"quesId":quesId}, "json");
	var map = ajax("POST", "selectByQuesId", {"quesId":quesId}, "json");
	$("#useBtnKKK_" + quesId).html("<button type='button' class='btn btn-success btn-sm btn-isUseful' disabled>有用(" + map.quesIsuseNum + ")</button>" +
			"<button type='button' class='btn btn-warning btn-sm' disabled>无用(" + map.quesNouseNum + ")</button>");
}

//点击无用按钮
function noUseful(obj) {
	var quesId = obj.value;
//	alert(quesId);
	ajax("POST", "updateNouseNum", {"quesId":quesId}, "json");
	var map = ajax("POST", "selectByQuesId", {"quesId":quesId}, "json");
	$("#useBtnKKK_" + quesId).html("<button type='button' class='btn btn-success btn-sm btn-isUseful' disabled>有用(" + map.quesIsuseNum + ")</button>" +
			"<button type='button' class='btn btn-warning btn-sm' disabled>无用(" + map.quesNouseNum + ")</button>");
}

//问题类别云标签
function aTagCloud() {
	var map = ajax("POST", "selectCategoryToTagCloud", {}, "json");
	var html = "";
	$.each(map.result,function(i, item){
		html += "<a href='/CAQAS/answer-search.html?id=" + item.cateId + "' class='tagc" + randomNum() + "'>" + item.cateName + "(" + item.questionNum + ")" + "</a>"
	});
	$("#aTag").html(html);
}

//页面跳转到问题页
function returnQuestion() {
	var array = [];
	var url = window.location.href;
	array = url.split("/CAQAS/");
	var newURL = array[0] + "/CAQAS/admin-question.html";
	self.location = newURL;
}

//生成随机数
function randomNum() {
	return Math.floor(Math.random()*18) + 1;
}