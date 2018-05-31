<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/view/panel/wrapper.prefix.jsp"%>

  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${sysMenu!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${sysMenu!=null}">"${BASE_URL}/sysMenu/edit"</c:when><c:otherwise>"${BASE_URL}/sysMenu/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="parentId" class="col-sm-3 control-label">父级编号</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="parentId" name="parentId" value="${sysMenu.parentId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="parentIds" class="col-sm-3 control-label">所有父级编号</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="parentIds" name="parentIds" value="${sysMenu.parentIds}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-3 control-label">名称</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="name" name="name" value="${sysMenu.name}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="sort" class="col-sm-3 control-label">排序</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="sort" name="sort" value="${sysMenu.sort}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="href" class="col-sm-3 control-label"><font class="red">* </font>链接</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="href" name="href" value="${sysMenu.href}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="target" class="col-sm-3 control-label"><font class="red">* </font>目标</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="target" name="target" value="${sysMenu.target}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="icon" class="col-sm-3 control-label"><font class="red">* </font>图标</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="icon" name="icon" value="${sysMenu.icon}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="isShow" class="col-sm-3 control-label">是否在菜单中显示</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="isShow" name="isShow" value="${sysMenu.isShow}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="permission" class="col-sm-3 control-label"><font class="red">* </font>权限标识</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="permission" name="permission" value="${sysMenu.permission}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="createBy" class="col-sm-3 control-label"></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="createBy" name="createBy" value="${sysMenu.createBy}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="createDate" class="col-sm-3 control-label"></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="createDate" name="createDate" value="${sysMenu.createDate}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="updateBy" class="col-sm-3 control-label"></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="updateBy" name="updateBy" value="${sysMenu.updateBy}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="updateDate" class="col-sm-3 control-label"></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="updateDate" name="updateDate" value="${sysMenu.updateDate}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="remarks" class="col-sm-3 control-label"><font class="red">* </font>备注信息</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="remarks" name="remarks" value="${sysMenu.remarks}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="delFlag" class="col-sm-3 control-label"><font class="red">* </font>删除标记</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="delFlag" name="delFlag" value="${sysMenu.delFlag}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <input type="hidden" name="id" value="${sysMenu.id}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${sysMenu==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
                    <button type="button" data_submit_type="submit_cancel" class="btn btn-danger btn-sm input-submit">取消</button>
                    <span id="edit_notice"></span>
                </div>
            </footer>
        </section>
    </aside>
</section>

<jsp:include page="/view/panel/wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/admin/sys/menu.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->