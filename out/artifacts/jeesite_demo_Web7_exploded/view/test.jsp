<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="/view/panel/wrapper.prefix.jsp"/>
<body>
	<form class="form-horizontal" method="post"
		enctype="multipart/form-data" id="edit_form"
		action="${BASE_URL_F}/app/find/sendReleaseNote" method="post">
		<div id="thumbnailPreview_div1" style="width: 200px; border: 1px solid #eee;">
					<img id="thumbnailPreview1" alt="缩略图"
						src="${BASE_URL}/images/zhanwei.png"
						style="width: 200px; height: 120px;" />
		</div>
		<input type="file" name="noteImg" id="noteImg" path="${group.picUrl}"
			data-icon="false"
			onchange="previewImage(this, 'thumbnailPreview1', 'thumbnailPreview_div1');"
			data-buttonText="上传图片" data-classbutton="btn btn-default"
			data-classinput="form-control inline input-s" /> 
		<div id="thumbnailPreview_div2" style="width: 200px; border: 1px solid #eee;">
					<img id="thumbnailPreview2" alt="缩略图"
						src="${BASE_URL}/images/zhanwei.png"
						style="width: 200px; height: 120px;" />
		</div>
		<input type="file" name="noteVoice" id="noteVoice"
			path="${group.picUrl}" data-icon="false"
			onchange="previewImage(this, 'thumbnailPreview2', 'thumbnailPreview_div2');"
			data-buttonText="上传图片" data-classbutton="btn btn-default"
			data-classinput="form-control inline input-s" />
		<input name="userId" id="userId">
		<input name="noteContent" id="noteContent">
		<input name="positionX" id="positionX">
		<input name="positionY" id="positionY">
		<input name="address" id="address">
		<input name="teamId" id="teamId">
	<input type="submit">
	</form>
</body>
</html>