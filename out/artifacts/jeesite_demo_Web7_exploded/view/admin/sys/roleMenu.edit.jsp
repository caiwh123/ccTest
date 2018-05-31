<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/view/panel/wrapper.prefix.jsp"%>

  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${sysRoleMenu!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${sysRoleMenu!=null}">"${BASE_URL}/sysRoleMenu/edit"</c:when><c:otherwise>"${BASE_URL}/sysRoleMenu/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="roleId" class="col-sm-3 control-label"></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="roleId" name="roleId" value="${sysRoleMenu.roleId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="menuId" class="col-sm-3 control-label"></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="menuId" name="menuId" value="${sysRoleMenu.menuId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${sysRoleMenu==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
                    <button type="button" data_submit_type="submit_cancel" class="btn btn-danger btn-sm input-submit">取消</button>
                    <span id="edit_notice"></span>
                </div>
            </footer>
        </section>
    </aside>
</section>

<jsp:include page="/view/panel/wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/admin/sys/roleMenu.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->