function checkBoxAttribute() {
	var $thr = $('table thead tr');
	var $checkAllTh = $('<th><input type="checkbox"/></th>');
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

function deleteCategory() {
	obj = document.getElementsByName("cateId");
	check_val = [];
	for (k in obj) {
		if (obj[k].checked)
			check_val.push(obj[k].value);
	}
	alert(check_val);
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