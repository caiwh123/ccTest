<%@ page contentType="text/html;charset=UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
// 动态获得地址配置
%>
<!DOCTYPE html>
<html lang="zh-CN" class="app">
<head>
<base href="<%=basePath%>">
<script type="text/javascript" language="javaScript">
	// 动态获得地址配置
   	var BASE_URL = '${BASE_URL}';
    var STATIC_URL = '${STATIC_URL}';
    var IMG_URL = '${IMG_URL}';
    var H5_URL = '${H5_URL}';
    var BASE_URL_F = '${BASE_URL_F}';
</script>
<jsp:include page="/view/panel/inc/header.jsp"/> 
<!-- USER DEFINED ASSETS -->
<!-- USER DEFINED ASSETS END@-->
<title>管理员后台</title>
</head>