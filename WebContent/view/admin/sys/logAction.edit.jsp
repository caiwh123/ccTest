<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/view/panel/wrapper.prefix.jsp"%>

  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${sysLogAction!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${sysLogAction!=null}">"${BASE_URL}/sysLogAction/edit"</c:when><c:otherwise>"${BASE_URL}/sysLogAction/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="actionName" class="col-sm-3 control-label"><font class="red">* </font>动作名称</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="actionName" name="actionName" value="${sysLogAction.actionName}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="actionCode" class="col-sm-3 control-label"><font class="red">* </font>动作编号</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="actionCode" name="actionCode" value="${sysLogAction.actionCode}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <input type="hidden" name="sysLogActionId" value="${sysLogAction.sysLogActionId}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${sysLogAction==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
                    <button type="button" data_submit_type="submit_cancel" class="btn btn-danger btn-sm input-submit">取消</button>
                    <span id="edit_notice"></span>
                </div>
            </footer>
        </section>
    </aside>
</section>

<jsp:include page="/view/panel/wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/admin/sys/logAction.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->