<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="dict" uri="/dictTag"%>
<%@ taglib prefix="su" uri="/suTag"%>
<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>
<%boolean isAjax = com.appcore.util.AjaxUtil.checkIsAjax(request);%>
<c:if test="${isAjax != true}">
<jsp:include page="/view/panel/wrapper.prefix-tiny.jsp"/> 
<body>


<style>
.ellipsis .table{table-layout:fixed;width:100%;}
.ellipsis .table td {
overflow: hidden;
 text-overflow:ellipsis;
 white-space:nowrap;
}
a:hover{color:blue!important}
.ellipsis2 .table{table-layout:fixed;width:100%;}
.ellipsis2 .table td:nth-of-type(8){
overflow: hidden;
 text-overflow:ellipsis;
 white-space:nowrap;
} 
.ellipsis3 .table{table-layout:fixed;width:100%;}
.ellipsis3 .table td:nth-of-type(3){
overflow: hidden;
 text-overflow:ellipsis;
 white-space:nowrap;
} 

</style>

    <script type="text/javascript">
    var subjectType = ["","正在发布","进行中","签订合同","完结"];
	var pushStatus = ["未提交","审核中","未开始","进行中","已结束"];
	var customerStats = ["","初步沟通","补充资料","再次沟通","尽职调查","立项","上风控会","出批复函","确认合作"];

function getDate(date1)
{
	var fmt = 'yyyy-MM-dd';
	var date = new Date(date1);
	var o = {         
		    "M+" : date.getMonth()+1, //月份         
		    "d+" : date.getDate() -1, //日         
		    "h+" : date.getHours()%12 == 0 ? 12 : date.getHours()%12, //小时         
		    "H+" : date.getHours(), //小时         
		    "m+" : date.getMinutes(), //分         
		    "s+" : date.getSeconds(), //秒         
		    "q+" : Math.floor((date.getMonth()+3)/3), //季度         
		    "S" : date.getMilliseconds() //毫秒         
		    };         
		    var week = {         
		    "0" : "/u65e5",         
		    "1" : "/u4e00",         
		    "2" : "/u4e8c",         
		    "3" : "/u4e09",         
		    "4" : "/u56db",         
		    "5" : "/u4e94",         
		    "6" : "/u516d"      
		    };         
		    if(/(y+)/.test(fmt)){         
		        fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));         
		    }         
		    if(/(E+)/.test(fmt)){         
		        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[date.getDay()+""]);         
		    }         
		    for(var k in o){         
		        if(new RegExp("("+ k +")").test(fmt)){         
		            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));         
		        }         
		    }         
		    return fmt;   
}




//校验上传文件大小
function checkfileSize(maxsize,fileId){
//	var maxsize = 0.1*1024*1024;//2M  
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

//校验电话号码
function CheckTel(number) {
    /*验证电话号码 
    验证规则：区号+号码，区号以0开头，3位或4位号码由7位或8位数字组成 
    区号与号码之间可以无连接符，也可以“-”连接 
    如01088888888,010-88888888,0955-7777777 */
    var isPhone = /^0\d{2,3}-?\d{7,8}$/;
    /*验证手机号码
    移动：134(1349除外）135 136 137 138 139 147 150 151 152 157 158 159 182 183 184 187 188
    联通：130 131 132 155 156 185 186 145
    电信：133 153 177 180 181 189*/
    var isMob = /^((\+?86)|(\(\+86\)))?(13[012356789][0-9]{8}|15[012356789][0-9]{8}|18[02356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7})$/;
    if (isMob.test(number) || isPhone.test(number)) {
        return true;
    }
    else {
        return false;
    }
}

function showTooltip(target) {  
    document.getElementById(target.id.replace(/^label/,'tooltip')).style.display = 'block';  
}  
function hideTooltip(target) {  
    document.getElementById(target.id.replace(/^label/,'tooltip')).style.display = 'none';  
}  

function ToDBC(txtstring) 
{ 
	var tmp = ""; 
	for(var i=0;i<txtstring.length;i++) 
	{ 
	if(txtstring.charCodeAt(i)==32) 
	{ 
	tmp= tmp+ String.fromCharCode(12288); 
	} 
	if(txtstring.charCodeAt(i)<127) 
	{ 
	tmp=tmp+String.fromCharCode(txtstring.charCodeAt(i)+65248); 
	} 
} 
return tmp; 
} 
  
</script>        
</c:if> 
