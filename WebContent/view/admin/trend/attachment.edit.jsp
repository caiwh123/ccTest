<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../wrapper.prefix.jsp"/>

  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${trendAttachment!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${trendAttachment!=null}">"${BASE_URL}/back/trendAttachment/edit"</c:when><c:otherwise>"${BASE_URL}/back/trendAttachment/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="userid" class="col-sm-3 control-label"><font class="red">* </font></label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="userid" name="userid" value="${trendAttachment.userid}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="title" class="col-sm-3 control-label"></label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="title" name="title" value="${trendAttachment.title}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="description" class="col-sm-3 control-label"></label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="description" name="description" value="${trendAttachment.description}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="label" class="col-sm-3 control-label"></label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="label" name="label" value="${trendAttachment.label}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="mediatype" class="col-sm-3 control-label"><font class="red">* </font></label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="mediatype" name="mediatype" value="${trendAttachment.mediatype}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="mimetype" class="col-sm-3 control-label"></label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="mimetype" name="mimetype" value="${trendAttachment.mimetype}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="suffix" class="col-sm-3 control-label"><font class="red">* </font></label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="suffix" name="suffix" value="${trendAttachment.suffix}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="imageable" class="col-sm-3 control-label"></label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="imageable" name="imageable" value="${trendAttachment.imageable}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="imageWidth" class="col-sm-3 control-label"></label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="imageWidth" name="imageWidth" value="${trendAttachment.imageWidth}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="imageHeight" class="col-sm-3 control-label"></label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="imageHeight" name="imageHeight" value="${trendAttachment.imageHeight}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="ctime" class="col-sm-3 control-label"></label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="ctime" name="ctime" value="${trendAttachment.ctime}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="mtime" class="col-sm-3 control-label"></label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="mtime" name="mtime" value="${trendAttachment.mtime}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="filepath" class="col-sm-3 control-label"></label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="filepath" name="filepath" value="${trendAttachment.filepath}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="filesize" class="col-sm-3 control-label"></label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="filesize" name="filesize" value="${trendAttachment.filesize}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="hashcode" class="col-sm-3 control-label"><font class="red">* </font></label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="hashcode" name="hashcode" value="${trendAttachment.hashcode}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="status" class="col-sm-3 control-label"></label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="status" name="status" value="${trendAttachment.status}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="rev" class="col-sm-3 control-label"></label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="rev" name="rev" value="${trendAttachment.rev}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <input type="hidden" name="attachmentid" value="${trendAttachment.attachmentid}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${trendAttachment==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
                    <button type="button" data_submit_type="submit_cancel" class="btn btn-danger btn-sm input-submit">取消</button>
                    <span id="edit_notice"></span>
                </div>
            </footer>
        </section>
    </aside>
</section>

<jsp:include page="../wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/back/modules/trend/js/attachment.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->