var title;
var content;

function insertAnswer() {
	var url = window.location.href;
	if (url.indexOf("?") != -1) {
		var arr = [];
		arr = url.split("?");
		var id = arr[1].split("=")[1];
		getParams();
		var jsonData = {
			"quesId" : id,
			"title" : title,
			"content" : content
		};
		var result = ajax("POST", "insertAnswer", jsonData, "json");
		if (result == 1) {
			alert("操作成功！");
			// location.reload();
			var array = [];
			var url = window.location.href;
			array = url.split("/CAQAS/");
			var newURL = array[0] + "/CAQAS/admin-question.html";
			self.location = newURL;
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

function getParams() {
	title = document.getElementById("title").value;
	content = getContent();
}

//根据问题ID查询
function selectTitleAndContent() {
	
}