<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/view/panel/wrapper.prefix.jsp"%>

  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${sysDict!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${sysDict!=null}">"${BASE_URL}/sysDict/edit"</c:when><c:otherwise>"${BASE_URL}/sysDict/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="value" class="col-sm-3 control-label">数据值</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="value" name="value" value="${sysDict.value}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="label" class="col-sm-3 control-label">标签名</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="label" name="label" value="${sysDict.label}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="type" class="col-sm-3 control-label">类型</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="type" name="type" value="${sysDict.type}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="description" class="col-sm-3 control-label">描述</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="description" name="description" value="${sysDict.description}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="sort" class="col-sm-3 control-label">排序</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="sort" name="sort" value="${sysDict.sort}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="parentId" class="col-sm-3 control-label"><font class="red">* </font>父级编号</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="parentId" name="parentId" value="${sysDict.parentId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="createBy" class="col-sm-3 control-label"></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="createBy" name="createBy" value="${sysDict.createBy}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="createDate" class="col-sm-3 control-label"></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="createDate" name="createDate" value="${sysDict.createDate}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="updateBy" class="col-sm-3 control-label"></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="updateBy" name="updateBy" value="${sysDict.updateBy}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="updateDate" class="col-sm-3 control-label"></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="updateDate" name="updateDate" value="${sysDict.updateDate}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="remarks" class="col-sm-3 control-label"><font class="red">* </font>备注信息</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="remarks" name="remarks" value="${sysDict.remarks}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="delFlag" class="col-sm-3 control-label"><font class="red">* </font>删除标记</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="delFlag" name="delFlag" value="${sysDict.delFlag}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <input type="hidden" name="id" value="${sysDict.id}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${sysDict==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
                    <button type="button" data_submit_type="submit_cancel" class="btn btn-danger btn-sm input-submit">取消</button>
                    <span id="edit_notice"></span>
                </div>
            </footer>
        </section>
    </aside>
</section>

<jsp:include page="/view/panel/wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/admin/sys/dict.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->