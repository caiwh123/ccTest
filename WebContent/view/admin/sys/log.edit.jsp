<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/view/panel/wrapper.prefix.jsp"%>

  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${sysLog!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${sysLog!=null}">"${BASE_URL}/sysLog/edit"</c:when><c:otherwise>"${BASE_URL}/sysLog/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="type" class="col-sm-3 control-label"><font class="red">* </font>日志类型</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="type" name="type" value="${sysLog.type}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="title" class="col-sm-3 control-label"><font class="red">* </font>日志标题</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="title" name="title" value="${sysLog.title}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="createBy" class="col-sm-3 control-label"><font class="red">* </font></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="createBy" name="createBy" value="${sysLog.createBy}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="createDate" class="col-sm-3 control-label"><font class="red">* </font></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="createDate" name="createDate" value="${sysLog.createDate}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="remoteAddr" class="col-sm-3 control-label"><font class="red">* </font>操作IP地址</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="remoteAddr" name="remoteAddr" value="${sysLog.remoteAddr}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="userAgent" class="col-sm-3 control-label"><font class="red">* </font>用户代理</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="userAgent" name="userAgent" value="${sysLog.userAgent}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="requestUri" class="col-sm-3 control-label"><font class="red">* </font>请求URI</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="requestUri" name="requestUri" value="${sysLog.requestUri}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="method" class="col-sm-3 control-label"><font class="red">* </font>操作方式</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="method" name="method" value="${sysLog.method}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="params" class="col-sm-3 control-label"><font class="red">* </font>操作提交的数据</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="params" name="params" value="${sysLog.params}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="exception" class="col-sm-3 control-label"><font class="red">* </font>异常信息</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="exception" name="exception" value="${sysLog.exception}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <input type="hidden" name="id" value="${sysLog.id}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${sysLog==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
                    <button type="button" data_submit_type="submit_cancel" class="btn btn-danger btn-sm input-submit">取消</button>
                    <span id="edit_notice"></span>
                </div>
            </footer>
        </section>
    </aside>
</section>

<jsp:include page="/view/panel/wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/admin/sys/log.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->