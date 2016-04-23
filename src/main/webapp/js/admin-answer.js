var title;
var content;

function insertAnswer() {
	getParams();
	var jsonData = {"title":title, "content":content};
	var result = ajax("POST", "insertAnswer", jsonData, "json");
	if (result == 1) {
		alert("添加成功！");
		location.reload();
	}
}

function getParams() {
	title = document.getElementById("title").value;
	content = getContent();
}