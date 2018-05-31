function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}

var APPID = "";
var TIMESTAMP = "";
var NONCESTR = "";
var SIGNATURE = "";
var DEBUG_PATTERN = true;// 调试模式
var preUrl = "";
