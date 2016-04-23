function ajax(type, url, data, dataType) {
	var res;
	$.ajax({
		type : type,
		async : false,
		url : url,
		data : data,
		dataType : dataType,
		success : function(data) {
			res = data;
		}
	});
	return res;
}