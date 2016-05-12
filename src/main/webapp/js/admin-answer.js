var title;
var content;

function insertAnswer() {
	var url = window.location.href;
	if (url.indexOf("?") != -1) {
		var arr = [];
		arr = url.split("?");
		if (arr[1].split("=")[0] == "quesId") {
			var id = arr[1].split("=")[1];
			getParams();
			var jsonData = {
				"quesId" : id,
				"title" : title,
				"content" : content
			};
			var result = ajax("POST", "insertAnswer", jsonData, "json");
			if (result == 1) {
				alert("回答成功！");
				// location.reload();
				var array = [];
				var url = window.location.href;
				array = url.split("/CAQAS/");
				var newURL = array[0] + "/CAQAS/admin-question.html";
				self.location = newURL;
			}
		} else {
			var id = arr[1].split("=")[1];//id为问题Id
			var mapAnsw = ajax("POST", "selectByQuesId", {"quesId":id}, "json");
			var answId = mapAnsw.answId;//答案Id
			getParams();
			var jsonData = {
				"quesId" : id,
				"answId" : answId,
				"title" : title,
				"content" : content
			};
			var result = ajax("POST", "updateAnswerAndQuestion", jsonData, "json");
			if (result == 1) {
				alert("修改成功！");
				var array = [];
				var url = window.location.href;
				array = url.split("/CAQAS/");
				var newURL = array[0] + "/CAQAS/admin-question.html";
				self.location = newURL;
			}
		}
	} else {
		getParams();
		var data = {"title" : title, "content" : content};
		var result = ajax("POST", "addAnswerAndQuestion", data, "json");
		if (result == 1) {
			alert("添加成功！");
			location.reload();
		}
	}
}

//初始化加载问题下拉框
function setQuestionSelect() {
	var map = ajax("POST", "selectAllQuestionsByUserId", {}, "json");
	var html = "";
	$.each(map.result, function(i,item){
		html += "<option value='" + item.quesAnswId + "'>" + item.quesTitle.substring(0,20) + "</option>";
	});
	$("#questionSelect").html(html);
}

//问题的答案指向
function confirmPointToQuestion() {
	var url = window.location.href;
	if (url.indexOf("?") != -1) {
		var arr = [];
		arr = url.split("?");
		var id = arr[1].split("=")[1];
		getParams();
		var quesAnswId = $("#questionSelect").val();
		var jsonData = {
			"quesId" : id,
			"quesAnswId" : quesAnswId
		};
		var result = ajax("POST", "updateQuestion", jsonData, "json");
		if (result == 1) {
			alert("问题答案指向成功！");
			var array = [];
			var url = window.location.href;
			array = url.split("/CAQAS/");
			var newURL = array[0] + "/CAQAS/admin-question.html";
			self.location = newURL;
		}
	} else {
		getParams();
		var quesAnswId = $("#questionSelect").val();
		var data = {
			"quesTitle" : title,
			"quesAnswId" : quesAnswId
		};
		var result = ajax("POST", "insertQuestionAndAnswerSelective", data, "json");
		if (result == 1) {
			alert("问题和答案添加成功！");
			var array = [];
			var url = window.location.href;
			array = url.split("/CAQAS/");
			var newURL = array[0] + "/CAQAS/admin-question.html";
			self.location = newURL;
		}
	}
}

function getParams() {
	title = document.getElementById("title").value;
	content = getContent();
}

//根据问题ID查询
function selectTitleAndContent() {
	
}