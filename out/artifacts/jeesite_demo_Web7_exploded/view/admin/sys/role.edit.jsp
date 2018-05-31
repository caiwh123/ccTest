<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/view/panel/wrapper.prefix.jsp"%>

  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${sysRole!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${sysRole!=null}">"${BASE_URL}/sysRole/edit"</c:when><c:otherwise>"${BASE_URL}/sysRole/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="officeId" class="col-sm-3 control-label"><font class="red">* </font>归属机构</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="officeId" name="officeId" value="${sysRole.officeId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-3 control-label">角色名称</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="name" name="name" value="${sysRole.name}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="enname" class="col-sm-3 control-label"><font class="red">* </font>英文名称</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="enname" name="enname" value="${sysRole.enname}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="roleType" class="col-sm-3 control-label"><font class="red">* </font>角色类型</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="roleType" name="roleType" value="${sysRole.roleType}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="dataScope" class="col-sm-3 control-label"><font class="red">* </font>数据范围</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="dataScope" name="dataScope" value="${sysRole.dataScope}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="isSys" class="col-sm-3 control-label"><font class="red">* </font>是否系统数据</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="isSys" name="isSys" value="${sysRole.isSys}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="useable" class="col-sm-3 control-label"><font class="red">* </font>是否可用</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="useable" name="useable" value="${sysRole.useable}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="createBy" class="col-sm-3 control-label"></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="createBy" name="createBy" value="${sysRole.createBy}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="createDate" class="col-sm-3 control-label"></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="createDate" name="createDate" value="${sysRole.createDate}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="updateBy" class="col-sm-3 control-label"></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="updateBy" name="updateBy" value="${sysRole.updateBy}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="updateDate" class="col-sm-3 control-label"></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="updateDate" name="updateDate" value="${sysRole.updateDate}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="remarks" class="col-sm-3 control-label"><font class="red">* </font>备注信息</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="remarks" name="remarks" value="${sysRole.remarks}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="delFlag" class="col-sm-3 control-label"><font class="red">* </font></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="delFlag" name="delFlag" value="${sysRole.delFlag}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <input type="hidden" name="id" value="${sysRole.id}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${sysRole==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
                    <button type="button" data_submit_type="submit_cancel" class="btn btn-danger btn-sm input-submit">取消</button>
                    <span id="edit_notice"></span>
                </div>
            </footer>
        </section>
    </aside>
</section>

<jsp:include page="/view/panel/wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/admin/sys/role.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->