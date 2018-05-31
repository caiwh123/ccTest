<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/view/panel/wrapper.prefix.jsp"%>

  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${sysUser!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${sysUser!=null}">"${BASE_URL}/sysUser/edit"</c:when><c:otherwise>"${BASE_URL}/sysUser/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="companyId" class="col-sm-3 control-label"><font class="red">* </font>归属公司</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="companyId" name="companyId" value="${sysUser.companyId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="officeId" class="col-sm-3 control-label"><font class="red">* </font>归属部门</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="officeId" name="officeId" value="${sysUser.officeId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="loginName" class="col-sm-3 control-label">登录名</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="loginName" name="loginName" value="${sysUser.loginName}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="password" class="col-sm-3 control-label">密码</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="password" name="password" value="${sysUser.password}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="no" class="col-sm-3 control-label"><font class="red">* </font>工号</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="no" name="no" value="${sysUser.no}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-3 control-label">姓名</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="name" name="name" value="${sysUser.name}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="email" class="col-sm-3 control-label"><font class="red">* </font>邮件</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="email" name="email" value="${sysUser.email}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="phone" class="col-sm-3 control-label"><font class="red">* </font>电话</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="phone" name="phone" value="${sysUser.phone}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="mobile" class="col-sm-3 control-label"><font class="red">* </font>手机</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="mobile" name="mobile" value="${sysUser.mobile}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="userType" class="col-sm-3 control-label"><font class="red">* </font>用户类型</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="userType" name="userType" value="${sysUser.userType}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="photo" class="col-sm-3 control-label"><font class="red">* </font>用户头像</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="photo" name="photo" value="${sysUser.photo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="loginIp" class="col-sm-3 control-label"><font class="red">* </font>最后登陆IP</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="loginIp" name="loginIp" value="${sysUser.loginIp}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="loginDate" class="col-sm-3 control-label"><font class="red">* </font>最后登陆时间</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="loginDate" name="loginDate" value="${sysUser.loginDate}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="loginFlag" class="col-sm-3 control-label"><font class="red">* </font>是否可登录</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="loginFlag" name="loginFlag" value="${sysUser.loginFlag}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="createBy" class="col-sm-3 control-label"></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="createBy" name="createBy" value="${sysUser.createBy}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="createDate" class="col-sm-3 control-label"></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="createDate" name="createDate" value="${sysUser.createDate}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="updateBy" class="col-sm-3 control-label"></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="updateBy" name="updateBy" value="${sysUser.updateBy}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="updateDate" class="col-sm-3 control-label"></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="updateDate" name="updateDate" value="${sysUser.updateDate}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="remarks" class="col-sm-3 control-label"><font class="red">* </font></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="remarks" name="remarks" value="${sysUser.remarks}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="delFlag" class="col-sm-3 control-label"><font class="red">* </font></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="delFlag" name="delFlag" value="${sysUser.delFlag}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <input type="hidden" name="id" value="${sysUser.id}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${sysUser==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
                    <button type="button" data_submit_type="submit_cancel" class="btn btn-danger btn-sm input-submit">取消</button>
                    <span id="edit_notice"></span>
                </div>
            </footer>
        </section>
    </aside>
</section>

<jsp:include page="/view/panel/wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/admin/sys/user.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->