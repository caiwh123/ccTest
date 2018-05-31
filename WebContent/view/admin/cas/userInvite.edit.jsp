<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/view/panel/wrapper.prefix.jsp"%>

<link href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${casUserInvite!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${casUserInvite!=null}">"${BASE_URL}/casUserInvite/edit"</c:when><c:otherwise>"${BASE_URL}/casUserInvite/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="userid" class="col-sm-3 control-label"><font class="red">* </font>用户id</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="userid" name="userid" value="${casUserInvite.userid}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="beuserid" class="col-sm-3 control-label"><font class="red">* </font>被邀请id</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="beuserid" name="beuserid" value="${casUserInvite.beuserid}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="integral" class="col-sm-3 control-label"><font class="red">* </font>积分</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="integral" name="integral" value="${casUserInvite.integral}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="isregister" class="col-sm-3 control-label"><font class="red">* </font>是否注册</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="isregister" name="isregister" value="${casUserInvite.isregister}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="reserve" class="col-sm-3 control-label"><font class="red">* </font>预留字段</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="reserve" name="reserve" value="${casUserInvite.reserve}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="creattime" class="col-sm-3 control-label"><font class="red">* </font>创建时间</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="creattime" name="creattime" value="${casUserInvite.creattime}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <input type="hidden" name="inviteId" value="${casUserInvite.inviteId}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${casUserInvite==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
                    <button type="button" data_submit_type="submit_cancel" class="btn btn-danger btn-sm input-submit">取消</button>
                    <span id="edit_notice"></span>
                </div>
            </footer>
        </section>
    </aside>
</section>

<jsp:include page="/view/panel/wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/plugins/datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="${STATIC_URL}/plugins/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script src="${STATIC_URL}/admin/cas/userInvite.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->