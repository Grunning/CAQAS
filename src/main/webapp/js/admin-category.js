var currentPage = 1;
var pageNum = 10;
var map;
var cateId;
var isAdd = 0; //标记模态框是添加触发
var isUpdate = 0;//标记模态框修改触发

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
				"<td><input type='checkbox' name='cateId' value='" + id
						+ "'/></td>");
	});
}

//初始化查询
function selectAllCategory() {
	var data = {"page":currentPage, "pageNum":pageNum};
	map = ajax("POST", "selectAllCategories", data, "json");
	var html = "";
	var num = 0;
	$.each(map.result,function(i, item){
		num ++;
		html += "<tr id='" + item.cateId + "'><td>" + num + "</td><td>" + item.cateName + "</td></tr>";
	});
	$("#categoryTable").html(html);
}

//删除
function deleteCategory() {
	obj = document.getElementsByName("cateId");
	checkArray = [];
	for (i in obj) {
		if (obj[i].checked)
			checkArray.push(obj[i].value);
	}
	if (checkArray.length > 0) {
		var data = {"cateIds":checkArray.join()};
		var result = ajax("POST", "deleteBatchCategory", data, "json");
		if (result != 0) {
			alert("成功删除 " + result + " 条！");
			location.reload();
		} else {
			alert("删除 " + result + " 条！，删除失败！")
		}
	} else {
		alert("请勾选要删除的行！");
	}
}

//添加
function addCategory() {
	var cateName = document.getElementById("categoryName").value;
	var data = {"cateName":cateName};
	var result = ajax("POST", "insertCategory", data, "json");
	if (result == 1) {
		alert("添加成功！");
		location.reload();
	} else {
		alert("添加失败！");
	}
}

//修改
function updateCategory() {
	var cateName = document.getElementById("categoryName").value;
	var data = {"cateId":cateId, "cateName":cateName};
	var result = ajax("POST", "updateCategory", data, "json");
	if (result == 1) {
		alert("修改成功！");
		location.reload();
	} else {
		alert("修改失败！");
	}
}

//根据标记添加还是修改触发事件
function confirmAddOrUpdate() {
	if (isAdd == 1) {
		addCategory();
		isAdd = 0;
	}
	if (isUpdate == 1) {
		updateCategory();
		isUpdate = 0;
	}
}

//触发添加
function addBtn() {
	document.getElementById("categoryName").value = "";
	isAdd = 1;
}

//触发更新
function updateBtn() {
	obj = document.getElementsByName("cateId");
	checkArray = [];
	for (i in obj) {
		if (obj[i].checked)
			checkArray.push(obj[i].value);
	}
	if (checkArray.length == 1) {
		cateId = checkArray[0];
		if (map.result != null) {
			$.each(map.result,function(i,item){
				if (item.cateId == cateId) {
					document.getElementById("categoryName").value = item.cateName;
				}
			});
		}
		isUpdate = 1;
	} else {
		alert("请勾选一行修改！");
		location.reload();
	}
}

//移除一列复选框
function removeCheckBoxColumn() {
	var th=document.getElementsByTagName("th");
	for (var i = 0; i < th.length; i++) {
		if (th[i].className == "allCheck") {
			th[i].parentNode.removeChild(th[i]);
		}
	}
}

//下一页
function nextPage() {
	currentPage ++;
	removeCheckBoxColumn();
	selectAllCategory();
	checkBoxAttribute();
}

//上一页
function previousPage() {
	if (currentPage > 1) {
		currentPage --;
		removeCheckBoxColumn();
		selectAllCategory();
		checkBoxAttribute();
	}
}