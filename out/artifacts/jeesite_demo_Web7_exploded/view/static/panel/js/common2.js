/**
 * 定义全局变量
 */
var img_done = "<img src='" + STATIC_URL
		+ "/panel/img/ico-done.gif' border='0' />";
var img_delete = "<img src='" + STATIC_URL
		+ "/panel/img/ico-delete.gif' border='0' />";
var img_warning = "<img src='" + STATIC_URL
		+ "/panel/img/ico-warning.gif' border='0' />";
var img_loading_small = "<img src='" + STATIC_URL
		+ "/panel/img/loading-small.gif' border='0' />";
var img_loading_icon = "<i class='fa fa-spin fa-spinner'></i>";
var back_listing = false; // 编辑表单提交处理完毕后，是否返回列表管理
var cookieName_navigation = 'YZ_LastNavigationHid'; // 定义记录导航轨迹的 cookie 名称



/**
 * 根据父级 ID 获取子级地区
 */
function getRegionByPid(pid, $obj) {
	$
			.ajax({
				type : 'post',
				url : BASE_URL + '/trend/region/getRegionByPid',
				data : 'pid=' + pid,
				dataType : 'json',
				timeout : 60000,
				success : function(data) {
					if (data.status == 0) {
						/* 若已加载，则无需重复加载 */
						if ($obj.find('option').size() > 1) {
							return false;
						}

						/* 加载地区列表 */
						var selected_id = parseInt($obj.attr('data-selected'));
						$(data.data.regions)
								.each(
										function() {
											if (selected_id > 0
													&& selected_id == this.regionId) {
												$obj
														.append('<option value="'
																+ this.regionId
																+ '" selected="selected">'
																+ this.regionName
																+ '</option>');
											} else {
												$obj.append('<option value="'
														+ this.regionId + '">'
														+ this.regionName
														+ '</option>');
											}
										});
					}
				}
			});
}

/**
 * 将数字金额转为大写
 */
function digit_uppercase(n) {
	var fraction = [ '角', '分' ];
	var digit = [ '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' ];
	var unit = [ [ '元', '万', '亿' ], [ '', '拾', '佰', '仟' ] ];
	var head = n < 0 ? '欠' : '';
	n = Math.abs(n);
	var s = '';
	for (var i = 0; i < fraction.length; i++) {
		s += (digit[Math.floor(n * 10 * Math.pow(10, i)) % 10] + fraction[i])
				.replace(/零./, '');
	}
	s = s || '整';
	n = Math.floor(n);
	for (var i = 0; i < unit[0].length && n > 0; i++) {
		var p = '';
		for (var j = 0; j < unit[1].length && n > 0; j++) {
			p = digit[n % 10] + unit[1][j] + p;
			n = Math.floor(n / 10);
		}
		s = p.replace(/(零.)*零$/, '').replace(/^$/, '零') + unit[0][i] + s;
	}
	return head
			+ s.replace(/(零.)*零元/, '元').replace(/(零.)+/g, '零').replace(/^整$/,
					'零元整');
}

/**
 * 载入导航轨迹
 */
function loadNavigation() {
	/*var cookie_nav = $.cookie(cookieName_navigation);
	if (cookie_nav) {
		$('#left_nav').find('.load-content').each(function() {
			if ($(this).attr('hid') == cookie_nav) {
				$(this).parent().addClass('active');
				$(this).parent().parent().show();
				$(this).parent().parent().parent().addClass('active');
			}
		});
	}*/
}

/**
 * 更新导航轨迹
 */
function updateNavigation(hid) {
	if (hid) {
		$.cookie(cookieName_navigation, hid, {
			expires : 36000000,
			path : '/'
		});
	}
}

/**
 * Ajax 加载页面 - 适用于局部，或者使用 js 进行页面跳转
 */
function loadingAjax(href, obj) {
	if (href != '' && href != '#' && href != './') {
		if (!obj) {
			obj = $("#content");
		}
		obj.load(href, function() {
			history.pushState({}, null, href);
		});
	}
}

/**
 * 提示信息处理，可定时清除
 * 
 * @param string
 *            obj_id 提示信息对象 ID
 * @param string
 *            msg 提示信息内容
 * @param boolean
 *            clear 是否自动清除
 * @param integer
 *            delayTime 延迟时间
 */
function notice(obj_id, msg, clear, delayTime) {
	$("#" + obj_id).html(msg);
	if (clear) {
		if (!delayTime) {
			delayTime = 5000;
		}
		setTimeout(function() {
			$("#" + obj_id).empty();
		}, delayTime);
	}
}

/**
 * 消息通知 - pnotify
 * 
 * @param string
 *            $msg 必填。提示信息
 * @param string
 *            $type 选填。提示类型，一共四种：warning、info、success、error
 * @param string
 *            $title 选填。提示标题
 */
function pnotify($msg, $type, $title) {
	new PNotify({
		title : $title ? $title : '提醒',
		text : $msg,
		type : $type ? $type : 'warning',
		styling : 'bootstrap3',
	});
}

/**
 * 更新 CKEDITOR 的状态，即值 适用版本：4.0以上
 */
function CKupdate() {
	for (instance in CKEDITOR.instances)
		CKEDITOR.instances[instance].updateElement();
}

/**
 * 判断 js 数组包是否包含某个元素，类似 PHP 的数组函数 in_array() 使用方法： var arr = ["a","b"];
 * alert(arr.in_array("a"));
 */
Array.prototype.S = String.fromCharCode(2);
Array.prototype.in_array = function(e) {
	var r = new RegExp(this.S + e + this.S);
	return (r.test(this.S + this.join(this.S) + this.S));
}

/**
 * ajaxError
 */
function ajaxError(XMLHttpRequest, textStatus, errorThrown) {
	alert('您已经与我们有1小时没有互动了，请重新登陆操作!');
	$('#edit_notice').empty();
	$(".input-submit").removeAttr('disabled');
}

function compareDatStr(begin, end) {
	var begin = getDateFromStr(begin);
	var end = getDateFromStr(end);
	if (begin.getTime() > end.getTime()) {
		return false;
	}
	return true;
}

function getDateFromStr(dateStr) {
	return new Date(dateStr.replace(/-/g, "/"));
}

/**
 * 转换日期格式，将秒型日期转换为yyyy-MM-dd格式的日期
 * 
 * @param milliSecond
 *            java后台传来的秒型日期
 */
function getDate(milliSecond) {
	if (milliSecond != null && milliSecond != "") {
		return new Date(milliSecond).Format("yyyy-MM-dd");
	} else {
		return "";
	}
}

function getDateTime(milliSecond) {
	if (milliSecond != null && milliSecond != "") {
		return new Date(milliSecond).Format("yyyy-MM-dd hh:mm:ss");
	} else {
		""
	}
}

// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
// 例子：
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
// (new Date()).Format("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
Date.prototype.Format = function(fmt) { // author: meizz
	var o = {
		"M+" : this.getMonth() + 1, // 月份
		"d+" : this.getDate(), // 日
		"h+" : this.getHours(), // 小时
		"m+" : this.getMinutes(), // 分
		"s+" : this.getSeconds(), // 秒
		"q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
		"S" : this.getMilliseconds()
	// 毫秒
	};
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	for ( var k in o)
		if (new RegExp("(" + k + ")").test(fmt))
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
}


/**
 * 是否为空
 * @author hapday
 */
var isEmpty = function(str){
	if(undefined !== str && null !== str && "" !== $.trim(str)){
		return false;
	} else {
		return true;
	}
}

/**
 * 是否为不为空
 * @author hapday
 */
var isNotEmpty = function(str){
	if(undefined === str || null === str || "" === $.trim(str)){
		return false;
	} else {
		return true;
	}
}

// ///////////////////// 预览本地图片 - start /////////////////////
/**
 * js本地图片预览，兼容ie[6-9]、火狐、Chrome17+、Opera11+、Maxthon3
 * 
 * @param fileObject
 * @param previewImageId
 * @param imagePreview_div
 */
function previewImage(fileObject, previewImageId, imagePreview_div) {
	var allowExtention = ".jpg,jpeg,.bmp,.gif,.png";// 允许上传文件的后缀名document.getElementById("hfAllowPicSuffix").value;
	var extention = fileObject.value.substring(
			fileObject.value.lastIndexOf(".") + 1).toLowerCase();
	var browserVersion = window.navigator.userAgent.toUpperCase();
	if (allowExtention.indexOf(extention) > -1) {
		if (fileObject.files) {// HTML5实现预览，兼容chrome、火狐7+等
			if (window.FileReader) {
				var reader = new FileReader();
				reader.onload = function(e) {
					document.getElementById(previewImageId).setAttribute("src",
							e.target.result);
				}
				reader.readAsDataURL(fileObject.files[0]);
			} else if (browserVersion.indexOf("SAFARI") > -1) {
				alert("不支持Safari6.0以下浏览器的图片预览!");
			}
		} else if (browserVersion.indexOf("MSIE") > -1) {
			if (browserVersion.indexOf("MSIE 6") > -1) {// ie6
				document.getElementById(previewImageId).setAttribute("src",
						fileObject.value);
			} else {// ie[7-9]
				fileObject.select();
				if (browserVersion.indexOf("MSIE 9") > -1)
					fileObject.blur();// 不加上document.selection.createRange().text在ie9会拒绝访问
				var newPreview = document.getElementById(imagePreview_div
						+ "New");
				if (newPreview == null) {
					newPreview = document.createElement("div");
					newPreview.setAttribute("id", imagePreview_div + "New");
					newPreview.style.width = document
							.getElementById(previewImageId).width
							+ "px";
					newPreview.style.height = document
							.getElementById(previewImageId).height
							+ "px";
					newPreview.style.border = "solid 1px #d2e2e2";
				}
				newPreview.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src='"
						+ document.selection.createRange().text + "')";
				var tempDivPreview = document.getElementById(imagePreview_div);
				tempDivPreview.parentNode.insertBefore(newPreview,
						tempDivPreview);
				tempDivPreview.style.display = "none";
			}
		} else if (browserVersion.indexOf("FIREFOX") > -1) {// firefox
			var firefoxVersion = parseFloat(browserVersion.toLowerCase().match(
					/firefox\/([\d.]+)/)[1]);
			if (firefoxVersion < 7) {// firefox7以下版本
				document.getElementById(previewImageId).setAttribute("src",
						fileObject.files[0].getAsDataURL());
			} else {// firefox7.0+
				document.getElementById(previewImageId).setAttribute("src",
						window.URL.createObjectURL(fileObject.files[0]));
			}
		} else {
			document.getElementById(previewImageId).setAttribute("src",
					fileObject.value);
		}
	} else {
		alert("仅支持" + allowExtention + "为后缀名的文件!");
		fileObject.value = "";// 清空选中文件
		if (browserVersion.indexOf("MSIE") > -1) {
			fileObject.select();
			document.selection.clear();
		}
		fileObject.outerHTML = fileObject.outerHTML;
	}
}




function previewImage2(fileObject, previewImageId, imagePreview_div) {
	var allowExtention = ".mp3,.mp4,.wav,.avi,.mov";// 允许上传文件的后缀名document.getElementById("hfAllowPicSuffix").value;
	var extention = fileObject.value.substring(
			fileObject.value.lastIndexOf(".") + 1).toLowerCase();
	var browserVersion = window.navigator.userAgent.toUpperCase();
	if (allowExtention.indexOf(extention) > -1) {
		if (fileObject.files) {// HTML5实现预览，兼容chrome、火狐7+等
			if (window.FileReader) {
				var reader = new FileReader();
				reader.onload = function(e) {
					document.getElementById(previewImageId).setAttribute("src",
							e.target.result);
				}
				reader.readAsDataURL(fileObject.files[0]);
			} else if (browserVersion.indexOf("SAFARI") > -1) {
				alert("不支持Safari6.0以下浏览器的图片预览!");
			}
		} else if (browserVersion.indexOf("MSIE") > -1) {
			if (browserVersion.indexOf("MSIE 6") > -1) {// ie6
				document.getElementById(previewImageId).setAttribute("src",
						fileObject.value);
			} else {// ie[7-9]
				fileObject.select();
				if (browserVersion.indexOf("MSIE 9") > -1)
					fileObject.blur();// 不加上document.selection.createRange().text在ie9会拒绝访问
				var newPreview = document.getElementById(imagePreview_div
						+ "New");
				if (newPreview == null) {
					newPreview = document.createElement("div");
					newPreview.setAttribute("id", imagePreview_div + "New");
					newPreview.style.width = document
							.getElementById(previewImageId).width
							+ "px";
					newPreview.style.height = document
							.getElementById(previewImageId).height
							+ "px";
					newPreview.style.border = "solid 1px #d2e2e2";
				}
				newPreview.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src='"
						+ document.selection.createRange().text + "')";
				var tempDivPreview = document.getElementById(imagePreview_div);
				tempDivPreview.parentNode.insertBefore(newPreview,
						tempDivPreview);
				tempDivPreview.style.display = "none";
			}
		} else if (browserVersion.indexOf("FIREFOX") > -1) {// firefox
			var firefoxVersion = parseFloat(browserVersion.toLowerCase().match(
					/firefox\/([\d.]+)/)[1]);
			if (firefoxVersion < 7) {// firefox7以下版本
				document.getElementById(previewImageId).setAttribute("src",
						fileObject.files[0].getAsDataURL());
			} else {// firefox7.0+
				document.getElementById(previewImageId).setAttribute("src",
						window.URL.createObjectURL(fileObject.files[0]));
			}
		} else {
			document.getElementById(previewImageId).setAttribute("src",
					fileObject.value);
		}
	} else {
		alert("仅支持" + allowExtention + "为后缀名的文件!");
		fileObject.value = "";// 清空选中文件
		if (browserVersion.indexOf("MSIE") > -1) {
			fileObject.select();
			document.selection.clear();
		}
		fileObject.outerHTML = fileObject.outerHTML;
	}
}
function previewFile(fileObject, previewImageId, imagePreview_div) {
	var allowExtention = ".xls,.xlsx";// 允许上传文件的后缀名document.getElementById("hfAllowPicSuffix").value;
	var extention = fileObject.value.substring(
			fileObject.value.lastIndexOf(".") + 1).toLowerCase();
	var browserVersion = window.navigator.userAgent.toUpperCase();
	if (allowExtention.indexOf(extention) > -1) {
		if (fileObject.files) {// HTML5实现预览，兼容chrome、火狐7+等
			if (window.FileReader) {
				var reader = new FileReader();
				reader.onload = function(e) {
					document.getElementById(previewImageId).setAttribute("src",
							e.target.result);
				}
				reader.readAsDataURL(fileObject.files[0]);
			} else if (browserVersion.indexOf("SAFARI") > -1) {
				alert("不支持Safari6.0以下浏览器的图片预览!");
			}
		} else if (browserVersion.indexOf("MSIE") > -1) {
			if (browserVersion.indexOf("MSIE 6") > -1) {// ie6
				document.getElementById(previewImageId).setAttribute("src",
						fileObject.value);
			} else {// ie[7-9]
				fileObject.select();
				if (browserVersion.indexOf("MSIE 9") > -1)
					fileObject.blur();// 不加上document.selection.createRange().text在ie9会拒绝访问
				var newPreview = document.getElementById(imagePreview_div
						+ "New");
				if (newPreview == null) {
					newPreview = document.createElement("div");
					newPreview.setAttribute("id", imagePreview_div + "New");
					newPreview.style.width = document
							.getElementById(previewImageId).width
							+ "px";
					newPreview.style.height = document
							.getElementById(previewImageId).height
							+ "px";
					newPreview.style.border = "solid 1px #d2e2e2";
				}
				newPreview.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src='"
						+ document.selection.createRange().text + "')";
				var tempDivPreview = document.getElementById(imagePreview_div);
				tempDivPreview.parentNode.insertBefore(newPreview,
						tempDivPreview);
				tempDivPreview.style.display = "none";
			}
		} else if (browserVersion.indexOf("FIREFOX") > -1) {// firefox
			var firefoxVersion = parseFloat(browserVersion.toLowerCase().match(
					/firefox\/([\d.]+)/)[1]);
			if (firefoxVersion < 7) {// firefox7以下版本
				document.getElementById(previewImageId).setAttribute("src",
						fileObject.files[0].getAsDataURL());
			} else {// firefox7.0+
				document.getElementById(previewImageId).setAttribute("src",
						window.URL.createObjectURL(fileObject.files[0]));
			}
		} else {
			document.getElementById(previewImageId).setAttribute("src",
					fileObject.value);
		}
	} else {
		alert("仅支持" + allowExtention + "为后缀名的文件!");
		fileObject.value = "";// 清空选中文件
		if (browserVersion.indexOf("MSIE") > -1) {
			fileObject.select();
			document.selection.clear();
		}
		fileObject.outerHTML = fileObject.outerHTML;
	}
}
// ///////////////////// 预览本地图片 - end /////////////////////


/**
 * 只能是数字
 */
var onlyNumber = function() {
	if (!(event.keyCode == 46) && !(event.keyCode == 8)
			&& !(event.keyCode == 37) && !(event.keyCode == 39))
		if (!((event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 96 && event.keyCode <= 105)))
			event.returnValue = false;
}

/**
 * 时间验证器
 */
var timeValidator = function(time) {
	if (isEmpty(time)) {
		return false;
	}

	var reg = /^([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$/;
	if (reg.test(time)) {
		return true;
	} else {
		return false;
	}
}

/**
 * 尖括号、引号、&、替换为响应的 XML 标识
 */
var specificSymbolToTxt = function(str) {
	var RexStr = /\<|\>|\"|\'|\&/g
	str = str.replace(RexStr, function(MatchStr) {
		switch (MatchStr) {
		case "<":
			return "&lt;";
			break;
		case ">":
			return "&gt;";
			break;
		case "\"":
			return "&quot;";
			break;
		case "'":
			return "&#39;";
			break;
		case "&":
			return "&amp;";
			break;
		default:
			break;
		}
	})
	return str;
}

/**
 * 双引号替换为空字符
 */
var doubleQuotationMarksReplaceBlank = function(object) {
	// var reg = /^[^\%\'\"\?]*$/;
	// var reg = /^[^"]*$/g;
	var reg = /^\"|\"$/g;

	// var str='数据库取出的正则表达式';
	// str.replace(/^\"|\"$/g,'');

	if (reg.test(object.value)) {
		object.value = '';

		return;
	}
}

/**
 * 获取 URL 参数数组
 */
function getUrlParams() {
	var href = window.location.href;
	
	if(undefined === href || null === href || "" === $.trim(href)){
		return;
	}
	
	var questionMarkIndex = href.indexOf("?");
//	var wellMarkIndex = href.indexOf("#");
	
	// 无参数
	if(-1 === questionMarkIndex){
		return null;
	} 
	
	var source = "";
	/*if(-1 !== wellMarkIndex){
		source = href.substring(questionMarkIndex + 1, wellMarkIndex);
	} else {
		source = href.substring(questionMarkIndex + 1, href.length);
	}*/
	source = href.substring(questionMarkIndex + 1, href.length);
	
	if(undefined === source || null === source || "" === $.trim(source)){
		return "";
	}

	var params = source.split("&");

	// 无参数
	if(undefined === params || null === params || "" === $.trim(params)){
		return "";
	}
	
	return params;
}

/**
 * 获取 URL 参数 JSON
 */
function getUrlParamJson() {
	var href = window.location.href;
	
	if(undefined === href || null === href || "" === $.trim(href)){
		return;
	}
	
	var questionMarkIndex = href.indexOf("?");
//	var wellMarkIndex = href.indexOf("#");
	
	if(-1 === questionMarkIndex){
		return null;
	} 
	
	var source = "";
	/*if(-1 !== wellMarkIndex){
		source = href.substring(questionMarkIndex + 1, wellMarkIndex);
	} else {
		source = href.substring(questionMarkIndex + 1, href.length);
	}*/
	source = href.substring(questionMarkIndex + 1, href.length);
	
	if(undefined === source || null === source || "" === $.trim(source)){
		return "";
	}

	var params = source.split("&");

	if(undefined === params || null === params || "" === $.trim(params)){
		return "";
	}
	
	var paramJSON = "{";
	
	for(var index = 0; index < params.length; index++){
		var param = params[index];
		
		if(undefined === params || null === params || "" === $.trim(params)){
			continue;
		}
		
		var items = param.split("=");
		
		var key = items[0];
		var value = items[1];
		
		paramJSON += key + ":'" + value + "',";
	}
	
	if(1 < paramJSON.length){
		paramJSON = paramJSON.substring(0, paramJSON.length - 1);
	}
	
	paramJSON += "}";
	
	return eval("(" + paramJSON + ")");
}

//js startWith() endWith() 方法
String.prototype.endWith = function(str) {
	if(str == null || str == "" || this.length == 0 || str.length > this.length)
	  return false;
	if(this.substring(this.length - str.length) == str)
	  return true;
	else
	  return false;
}

String.prototype.startWith = function(str) {
	if(str == null || str == "" || this.length == 0 || str.length > this.length)
	  return false;
	if(this.substr(0,str.length) == str)
	  return true;
	else
	  return false;
}

String.prototype.betweenWith = function(startStr, endStr) {
	if(this.startWith(startStr) && this.endWith(endStr)) 
	  return true;
	else 
	  return false;
}

/** 时间日期pattern枚举 */
var PATTERN_ENUM = {'time' : 'hh:mm:ss', 'date' : 'yyyy-MM-dd', 'datetime' : 'yyyy-MM-dd hh:mm:ss'};


/**
 * 时间日期类型内容转换方法 pattern: 需要的显示格式,可以从PATTERN_ENUM中取值，也可以自己指定格式 millionSeconds:
 * 毫秒数
 */
function dateConverter(millionSeconds, pattern) {
	if (!millionSeconds || !pattern) {
		return '';
	}
	return new Date(millionSeconds).Format(pattern);
}

/**fuelxu datagrid load*/
function loadDataGridContent(columns, formatFuncName) {
	var DataGridDataSource = function () {};
	
	DataGridDataSource.prototype = {
	    columns: function () {
	        return columns;
	    },
	    data: function (options, callback) {
	    	var param = parseParam();
	    	var url = param.url;
	    	delete param.url;
    		var data = {
    				rstype:"json",
    				pageIndex: options.pageIndex + 1,
    				pageSize: options.pageSize,
    		};
    		data = $.extend({}, options, data, param);
    		
    		$.ajax(url, {
    			data: data,
    			dataType: 'json',
    			async: true,
    			type: 'POST'
    		}).done(function (response) {
    			var data = response.data;
    			if (! data) {
    				return false;
    			}
    			var count=response.count;//设置data.total
    			// PAGING
    			var startIndex = options.pageIndex * options.pageSize;
    			var endIndex = startIndex + options.pageSize;
    			var end = (endIndex > count) ? count : endIndex;
    			var pages = Math.ceil(count / options.pageSize);
    			var page = options.pageIndex + 1;
    			var start = startIndex + 1;
//    			alert(formatFuncName);
    			if (formatFuncName) {
    				try {
    					var formatFunc = eval(formatFuncName);
    					if(typeof(formatFunc) == 'function') {
    						new formatFunc(data);
    					} else {
    						alert(formatFuncName + '不是一个function');
    					}
    				} catch (e) {
    					alert(e)
    					alert(formatFuncName + '未定义111');
    				}
    			}
    			callback({ data: data, start: start, end: end, count: count, pages: pages, page: page });
    		}).fail(function (e) {
    			
    		});
	    }
	};
	
	
	if(verifyColumns() && verifyParam()) {
		$('.datagrid').datagrid({
			dataSource: new DataGridDataSource(),
			loadingHTML: '<span><img src="'+STATIC_URL+'/panel/img/loading.gif"><i class="fa fa-info-sign text-muted" "></i>正在加载……</span>',
			itemsText: '条',
			itemText: '页',
			dataOptions: { pageIndex: 0 }	
		});
	}
	
	function verifyColumns() {
		if(!columns) {
			alert('columns未定义');
			return false;
		}
		if(!JSON.stringify(columns).betweenWith('[',']')) {
			alert('columns必须是json数组');
			return false;
		} 
		if(columns.length == 0) {
			alert('columns信息为空');
			return false;
		}
		for(var i=0; i<columns.length; i++) {
			if(!columns[i].property) {
				alert('columns第'+(i+1)+'个元素中的property属性不存在或为空');
				return false;
			}
		}		
		return true;
	}
	
	function verifyParam() {
		var form = $('#searchForm');
		if(!form) {
			alert('searchForm未定义');
			return false;
		}
		var actionUrl = form.attr('action');
		if(!actionUrl) {
			alert('actionUrl未定义！！！');
			return false;
		}
		return true;
	}
	
	function parseParam() {
		var form = $('#searchForm');
		var actionUrl = form.attr('action');
		var paramInArray = form.serializeArray();
		var paramJson = {};
		for(var i in paramInArray) {
			if (typeof (paramJson[paramInArray[i].name]) == 'undefined') 
				paramJson[paramInArray[i].name] = paramInArray[i].value; 
			else 
				paramJson[paramInArray[i].name] += "," + paramInArray[i].value; 
		}
		return $.extend({}, paramJson, {url : actionUrl} );
	}
	
	
	
	
	
	//校验上传文件大小
	function checkfileSize(maxsize,fileId){
//		var maxsize = 0.1*1024*1024;//2M  
	    var errMsg = "上传的附件文件不能超过1M！！！";  
	    var tipMsg = "您的浏览器暂不支持计算上传文件的大小，确保上传文件不要超过2M，建议使用IE、FireFox、Chrome浏览器。";  
	    var  browserCfg = {};  
	    var ua = window.navigator.userAgent;  
	    if (ua.indexOf("MSIE")>=1){  
	        browserCfg.ie = true;  
	    }else if(ua.indexOf("Firefox")>=1){  
	        browserCfg.firefox = true;  
	    }else if(ua.indexOf("Chrome")>=1){  
	        browserCfg.chrome = true;  
	    }  
	    try{  
	        var obj_file = document.getElementById(fileId);  
	        if(obj_file.value==""){  
	            alert("请先选择上传文件");  
	            return;  
	        }  
	        var filesize = 0;  
	        if(browserCfg.firefox || browserCfg.chrome ){  
	            filesize = obj_file.files[0].size;  
	        }else if(browserCfg.ie){  
	            var obj_img = document.getElementById('tempimg');  
	            obj_img.dynsrc=obj_file.value;  
	            filesize = obj_img.fileSize;  
	        }else{  
	            alert(tipMsg);  
	        return;  
	        }  
	        if(filesize==-1){  
	            alert(tipMsg);  
	            return 'E';//不支持  
	        }else if(filesize>maxsize){  
	            return 'F';//文件过大  
	        }else{  
	            return 'S';//成功  
	        }  
	    }catch(e){  
	        alert(e);  
	    }  
	} 
}
