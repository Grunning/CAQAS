function signIn() {
	var array = [];
	var url = window.location.href;
	array = url.split("/CAQAS/");
	var newURL = array[0] + "/CAQAS/login.html";
	self.location = newURL;
}