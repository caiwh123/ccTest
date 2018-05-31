<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            $("#userType").select2();
			if($("#userType").val()==1){
                $("#lab").hide();
                $("#lib").val("");
                $("#center").show();
			}else if($("#userType").val()==2){
                $("#lab").show();
                $("#email").val("");
                $("#center").hide();
			}else{
                $("#lab").hide();
                $("#center").hide();
                $("#libId").val("");
                $("#center").val("");
			}
            $("#userType").off().on("change",function(){
                var num = $(this).val();
				$("userType").val(num);
                if(num==1){
                    $("#lab").hide();
                    $("#lib").val("");
                    $("#center").show();
                }else if(num==2){
                    $("#lab").show();
                    $("#email").val("");
                    $("#center").hide();
                }else{
                    $("#lab").hide();
                    $("#center").hide();
                    $("#libId").val("");
                    $("#center").val("");
                }
            });
            // 手机号码验证
			jQuery.validator.addMethod("isMobile", function(value, element) {
			  var length = value.length;
			  var mobile =/^(((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
			  return this.optional(element) || (length == 11 && mobile.test(value));
			}, "请正确填写您的手机号码");

			$("#no").focus();
			$("#inputForm").validate({
				rules: {
					loginName: {remote: "${ctx}/sys/user/checkLoginName?oldLoginName=" + encodeURIComponent('${user.loginName}')},
			  		
				},
				messages: {
					loginName: {remote: "用户登录名已存在"},
					confirmNewPassword: {equalTo: "输入与上面相同的密码"}
				},
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});

	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sys/user/list">用户列表</a></li>
		<li class="active"><a href="${ctx}/sys/user/form?id=${user.id}">用户<shiro:hasPermission name="sys:user:edit">${not empty user.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sys:user:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="user" action="${ctx}/sys/user/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">类型:</label>
			<div class="controls">
				<select id="userType"  name="userType" style="width: 220px">
					<option value="0" <c:if test="${user.userType==0}">selected</c:if>请选择</option>
					<option value="1" <c:if test="${user.userType==1}">selected</c:if>>分中心</option>
					<option value="2" <c:if test="${user.userType==2}">selected</c:if>>实验室</option>
				</select>
			</div>
		</div>
			<div class="control-group" id="center" style="display: none">
				<label class="control-label">所属分中心:</label>
				<div class="controls">
					<select id="email" name="email" style="width: 220px">
					<c:forEach items="${branchCenter}" var="center">
					<c:if test="${user.email  eq center.branchCenterId}">
						<option value="${center.branchCenterId }" selected="selected">${center.centerName}</option>
					</c:if>
					<c:if test="${user.email  ne center.branchCenterId}">
						<option value="${center.branchCenterId }">${center.centerName}</option>
					</c:if>
					</c:forEach>
					</select>
				</div>
			</div>
			<div class="control-group" id="lab" style="display: none">
				<label class="control-label">所属实验室:</label>
				<div class="controls">
					<select id="labId" name="labId" style="width: 220px">
						<c:forEach items="${labList}" var="labInfo">
							<c:if test="${user.labId  eq labInfo.labId}">
								<option value="${labInfo.labId}" selected="selected">${labInfo.labName}</option>
							</c:if>
							<c:if test="${user.labId  ne labInfo.labId}">
								<option value="${labInfo.labId }">${labInfo.labName}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
			</div>
		<div class="control-group">
			<label class="control-label">姓名:</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="50" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">登录名:</label>
			<div class="controls">
				<input id="oldLoginName" name="oldLoginName" type="hidden" value="${user.loginName}">
				<form:input path="loginName" htmlEscape="false" maxlength="50" class="required userName"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">密码:</label>
			<div class="controls">
				<input id="newPassword" name="newPassword" type="password" value="" maxlength="50" minlength="3" class="${empty user.id?'required':''}"/>
				<c:if test="${empty user.id}"><span class="help-inline"><font color="red">*</font> </span></c:if>
				<c:if test="${not empty user.id}"><span class="help-inline">若不修改密码，请留空。</span></c:if>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">确认密码:</label>
			<div class="controls">
				<input id="confirmNewPassword" name="confirmNewPassword" type="password" value="" maxlength="50" minlength="3" equalTo="#newPassword"/>
				<c:if test="${empty user.id}"><span class="help-inline"><font color="red">*</font> </span></c:if>
			</div>
		</div>
	<%-- 	<div class="control-group">
			<label class="control-label">邮箱:</label>
			<div class="controls">
				<form:input path="email" htmlEscape="false" maxlength="100" class="email"/>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">电话:</label>
			<div class="controls">
				<form:input path="phone" htmlEscape="false" id="phone" maxlength="100"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">手机:</label>
			<div class="controls">
				<form:input path="mobile" htmlEscape="false" maxlength="100"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否允许登录:</label>
			<div class="controls">
				<form:select path="loginFlag">
					<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> “是”代表此账号允许登录，“否”则表示此账号不允许登录</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">用户角色:</label>
			<div class="controls">
				<form:radiobuttons path="roleIdList" items="${allRoles}" itemLabel="name" itemValue="id" htmlEscape="false" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="3" maxlength="200" class="input-xlarge"/>
			</div>
		</div>
		<%-- <c:if test="${not empty user.id}">
			<div class="control-group">
				<label class="control-label">创建时间:</label>
				<div class="controls">
					<label class="lbl"><fmt:formatDate value="${user.createDate}" type="both" dateStyle="full"/></label>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">最后登陆:</label>
				<div class="controls">
					<label class="lbl">IP: ${user.loginIp}&nbsp;&nbsp;&nbsp;&nbsp;时间：<fmt:formatDate value="${user.loginDate}" type="both" dateStyle="full"/></label>
				</div>
			</div>
		</c:if> --%>
		<div class="form-actions">
			<shiro:hasPermission name="sys:user:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>

</html>