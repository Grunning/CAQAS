var currentPage = 1;
var pageNum = 10;
var map;
var userId;

function checkBoxAttribute() {
	var $thr = $('table thead tr');
	var $checkAllTh = $('<th class="allCheck"><input type="checkbox"/></th>');
	$thr.prepend($checkAllTh);
	var $checkAll = $thr.find('input');
	$checkAllTh.click(function() {
		$(this).find('input').click();
	});
	$checkAll.click(function(event) {
		$('table tbody tr').find('input').prop('checked',
				$(this).prop('checked'));
		if ($(this).prop('checked')) {
			$('table tbody tr').find('input').parent().parent().addClass(
					'warning');
		} else {
			$('table tbody tr').find('input').parent().parent().removeClass(
					'warning');
		}
		event.stopPropagation();
	});

	addCheckBox();

	$('table tbody tr').find('input').click(function(event) {
			$(this).parent().parent().toggleClass('warning');
			$checkAll.prop('checked',$('table tbody tr').find('input:checked').length == $('table tbody tr').length ? true: false);
			event.stopPropagation();
		});
	$('table tbody tr').click(function() {
		$(this).find('input').click();
	});
}

//动态添加复选框
function addCheckBox() {
	$.each($("table tbody").find("tr"), function(i, item) {
		var id = $("table tbody").find("tr:eq(" + i + ")").attr("id");
		$("#" + id).prepend(
				"<td><input type='checkbox' name='userId' value='" + id
						+ "'/></td>");
	});
}

//初始化查询
function selectAllUser() {
	var data = {"page":currentPage, "pageNum":pageNum};
	map = ajax("POST", "selectAllUsers", data, "json");
	var html = "";
	var num = 0;
	$.each(map.result,function(i,item){
		num ++;
		html += "<tr id='" + item.userId + "'><td>" + num + "</td><td>" 
		+ item.userName + "</td><td>" + item.userMail + "</td><td>" + item.userDepName 
		+ "</td></tr>";
	});
	$("#userTable").html(html);
}

//部门列表初始化
function selectDeps() {
	var data = {"page":-1, "pageNum":-1};
	var result = ajax("POST", "selectAllDepartments", data, "json");
	var html = "";
	$.each(result.result, function(i,item){
		html += "<option value='" + item.depName + "'>" + item.depName + "</option>"
	});
	$("#departmentSelectOfUpdate").html(html);
	$("#departmentSelectOfAdd").html(html);
}

//删除
function deleteUser() {
	obj = document.getElementsByName("userId");
	checkArray = [];
	for (i in obj) {
		if (obj[i].checked)
			checkArray.push(obj[i].value);
	}
	if (checkArray.length == 1) {
		var data = {"userId":checkArray[0]};
		var result = ajax("POST", "deleteUser", data, "json");
		if (result == 1) {
			alert("删除成功！");
			location.reload();
		} else {
			alert("删除失败!");
		}
	} else {
		alert("请选择一条删除！");
	}
}

//修改
function updateUser() {
	var userName = document.getElementById("userNameOfUpdate").value;
	var userMail = document.getElementById("userMailOfUpdate").value;
	var userDepName = $("#departmentSelectOfUpdate").val();
	var dataDep = {"depName":userDepName};
	var result = ajax("POST", "selectByDepName", dataDep, "json");
	var userDepId = result.depId;
	var data = {"userId":userId, "userName":userName, "userMail":userMail, "userDepId":userDepId};
	var result = ajax("POST", "updateUser", data, "json");
	if (result == 1) {
		alert("修改成功！");
		location.reload();
	} else {
		alert("修改失败!");
	}
}

//添加
function addUser() {
	var userName = document.getElementById("userNameOfAdd").value;
	var userMail = document.getElementById("userMailOfAdd").value;
	var userDepName = $("#departmentSelectOfAdd").val();
	var dataDep = {"depName":userDepName};
	var result = ajax("POST", "selectByDepName", dataDep, "json");
	var userDepId = result.depId;
	var data = {"userId":userId, "userName":userName, "userMail":userMail, "userDepId":userDepId};
	var result = ajax("POST", "insertUser", data, "json");
	if (result == 1) {
		alert("添加成功！");
		location.reload();
	} else {
		alert("添加失败!");
	}
}

//重置密码
function resetPassword() {
	var data = {"userId":userId};
	var result = ajax("POST", "resetPassword", data, "json");
	if (result == 1) {
		alert("重置密码成功！");
		location.reload();
	} else {
		alert("重置密码失败！");
	}
}

//点击修改按钮触发事件
function updateBtnUser() {
	obj = document.getElementsByName("userId");
	checkArray = [];
	for (i in obj) {
		if (obj[i].checked)
			checkArray.push(obj[i].value);
	}
	if (checkArray.length == 1) {
		userId = checkArray[0];
		if (map.result != null) {
			$.each(map.result,function(i,item){
				if (item.userId == userId) {
					document.getElementById("userNameOfUpdate").value = item.userName;
					document.getElementById("userMailOfUpdate").value = item.userMail;
					$("#departmentSelectOfUpdate").get(0).value = item.userDepName;
				}
			});
		}
	} else {
		alert("请勾选一行修改！");
		location.reload();
	}
}

//下一页
function nextPage() {
	currentPage ++;
	var th=document.getElementsByTagName("th");
	for (var i = 0; i < th.length; i++) {
		if (th[i].className == "allCheck") {
			th[i].parentNode.removeChild(th[i]);
		}
	}
	selectAllUser();
	checkBoxAttribute();
}

//上一页
function previousPage() {
	if (currentPage > 1) {
		currentPage --;
		var th=document.getElementsByTagName("th");
		for (var i = 0; i < th.length; i++) {
			if (th[i].className == "allCheck") {
				th[i].parentNode.removeChild(th[i]);
			}
		}
		selectAllUser();
		checkBoxAttribute();
	}
}