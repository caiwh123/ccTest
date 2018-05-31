<%@ page contentType="text/html;charset=UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  <body>
  <form action="f/app/common/commonUpVideo" enctype="multipart/form-data" method="post">
  
  <input type="submit"> qqqq
  <!-- <audio src="http://180.163.192.28:8888/1.mp3" controls="controls">
  </audio> -->
  </form>
  </body>
</html>
