var currentPage = 1;
var pageNum = 10;
var map;
var depId;
var isAdd = 0;
var isUpdate = 0;

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
				"<td><input type='checkbox' name='depId' value='" + id
				+ "'/></td>");
	});
}

//查询初始化
function selectAllDeps() {
	var data = {"page":currentPage, "pageNum":pageNum};
	map = ajax("POST", "selectAllDepartments", data, "json");
	var html = "";
	var num = 0;
	$.each(map.result, function(i, item){
		num ++;
		html += "<tr id='" + item.depId + "'><td>" + num + "</td><td>" + item.depName + "</td></tr>";
	});
	$("#departmentTable").html(html);
}

function updateDepartment() {
	obj = document.getElementsByName("depId");
	checkArray = [];
	for (i in obj) {
		if (obj[i].checked)
			checkArray.push(obj[i].value);
	}
	if (checkArray.length == 1) {
		depId = checkArray[0];
		if (map.result != null) {
			$.each(map.result,function(i,item){
				if (item.depId == depId) {
					document.getElementById("departmentName").value = item.depName;
				}
			});
		}
		isUpdate = 1;
	} else {
		alert("请勾选一行修改！");
		location.reload();
	}
}

//点击添加按钮
function isInsertDep() {
	document.getElementById("departmentName").value = "";
	isAdd = 1;
}

//确认修改
function confirmUpdate() {
	var depName = document.getElementById("departmentName").value;
	var data = {"depId":depId, "depName":depName};
	var result = ajax("POST", "updateDepartment", data, "json");
	if (result == 1) {
		alert("修改成功！");
		location.reload();
	} else {
		alert("修改失败！");
		location.reload();
	}
}

//添加
function insertDepartment() {
	var depName = document.getElementById("departmentName").value;
	var data = {"depName":depName};
	var result = ajax("POST", "insertDepartment", data, "json");
	if (result == 1) {
		alert("添加成功!");
		location.reload();
	} else {
		alert("添加失败！");
		location.reload();
	}
}

//判断是点击添加按钮还是点击修改按钮弹出的模态框
function addAndupdate() {
	if (isUpdate == 1) {
		confirmUpdate();
		isUpdate = 0;
	}
	if (isAdd == 1) {
		insertDepartment();
		isAdd = 0;
	}
}

//删除
function deleteDepartment() {
	obj = document.getElementsByName("depId");
	checkArray = [];
	for (i in obj) {
		if (obj[i].checked)
			checkArray.push(obj[i].value);
	}
	if (checkArray.length > 0) {
		var data = {"depIds":checkArray.join()};
		var result = ajax("POST", "deleteBatchDep", data, "json");
		if (result != 0) {
			alert("成功删除 " + result + " 条！");
			location.reload();
		} else {
			alert("删除 " + result + " 条！，删除失败！")
			location.reload();
		}
	} else {
		alert("请勾选要删除的行！");
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
	selectAllDeps();
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
		selectAllDeps();
		checkBoxAttribute();
	} else {
		alert("已到第一页！");
	}
}
