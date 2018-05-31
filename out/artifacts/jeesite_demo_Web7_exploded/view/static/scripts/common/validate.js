/*
 * 校验是正的小数 小数点后2位
 */
function validIntAndPoint(val){
	var regu=/^[0-9]+[\.][0-9]{0,2}$/;
	var re = new RegExp(regu);
	return  re.test(val);
}
/*
 * 校验是正的小数
 */
function validPoint(val){
	var regu=/^[0-9]+[\.][0-9]{0,10}$/;
	var re = new RegExp(regu);
	return  re.test(val);
}
/*
 * 校验是正的小数 小数点后2位 或整的数
 */
function validIntAndPoint2(val){
	var regu1=/^[0-9]+[\.][0-9]{0,2}$/;
	var re1 = new RegExp(regu1);
	var regu2=/^[0-9]+[\.][0-9]{0,1}$/;
	var re2 = new RegExp(regu2);
	var regu3=/^[0-9]+$/;
	var re3 = new RegExp(regu3);
	return  re1.test(val)||re2.test(val)||re3.test(val);
}
/*
 * 校验是正的小数 小数点后2位 或整的数
 */
function validIntAndPoint3(val){
	var regu1=/^\d{1,1}+[\.][0-9]{0,2}$/;
	var re1 = new RegExp(regu1);
	var regu2=/^\d{1,1}+[\.][0-9]{0,1}$/;
	var re2 = new RegExp(regu2);
	var regu3=/^\d{1,1}+$/;
	var re3 = new RegExp(regu3);
	return  re1.test(val)||re2.test(val)||re3.test(val);
}
/*
 * 校验是正整数
 */
function validInt(val){
	var regu=/^[0-9]+$/;
	var re = new RegExp(regu);
	return  re.test(val);
}

/*
 * 校验是字母和数字
 */
function validNumOrLetter(val){
	var regu=/^[A-Za-z0-9]+$/;
	var re = new RegExp(regu);
	return  re.test(val);
}

/*
 * 校验是邮箱
 */
function validEmail(val){
	var regu=/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var re = new RegExp(regu);
	return  re.test(val);
}

function validTel(val){
	var isPhone = /^([0-9]{3,4}-)?[0-9]{7,8}$/;
	var isMob=/^((\+?86)|(\(\+86\)))?(13[0123456789][0-9]{8}|15[0123456789][0-9]{8}|18[012356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7})$/;
	var re1 = new RegExp(isPhone);
	var re2 = new RegExp(isMob);
	return re1.test(val)||re2.test(val);
}


/*
 * 比较两个时间的大小
 */
function compareTime(val1,val2){
	 var t1 = new Date(val1);   
	 var t2 = new Date(val2);  
	 if(t2-t1<0){
		 return false;
	 }else{
		 return true;
	 }
}

function clearNoNum(obj){
	obj.value = obj.value.replace(/[^\d.]/g,""); //清除"数字"和"."以外的字符
	obj.value = obj.value.replace(/^\./g,""); //验证第一个字符是数字而不是
	obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的
	obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
	obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3'); //只能输入两个小数
}

//验证由数字和字母组成的字符串
function validLetterAndNumber(val){
	var isLetterAndNumber = /[0-9]+[a-zA-Z]+[0-9a-zA-Z]*|[a-zA-Z]+[0-9]+[0-9a-zA-Z]*/;
	var re = new RegExp(isLetterAndNumber);
	return re.test(val);
}