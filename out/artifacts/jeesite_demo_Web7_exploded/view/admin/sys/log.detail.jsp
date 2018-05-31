<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/view/panel/wrapper.prefix.jsp"%>
<section class="hbox stretch">
    <aside class="bg-white">
        <section class="vbox">
            <header class="header bg-white b-b clearfix">
                <div class="m-t-sm">
                    <a href="#subNav" data-toggle="class:hide" class="btn btn-sm btn-default active btn-nav-goods" btn_nav_goods_index="0">
                        <i class="fa fa-caret-right text fa-lg"></i>
                        <i class="fa fa-caret-left text-active fa-lg"></i>
                    </a>
                        <a href="javascript:;" class="btn btn-sm btn-default" id="button_cancel"><i class="fa fa-reply"></i> 返回</a>
                </div>
            </header>
              
            <section class="scrollable wrapper">
                <section class="panel panel-default portlet-item">
	                <header class="panel-heading">详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${sysLog.id}</td>
                                <td class="col-sm-2">日志类型：</td>
                                <td class="col-sm-4">${sysLog.type}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">日志标题：</td>
                                <td class="col-sm-4">${sysLog.title}</td>
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${sysLog.createBy}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${sysLog.createDate}</td>
                                <td class="col-sm-2">操作IP地址：</td>
                                <td class="col-sm-4">${sysLog.remoteAddr}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">用户代理：</td>
                                <td class="col-sm-4">${sysLog.userAgent}</td>
                                <td class="col-sm-2">请求URI：</td>
                                <td class="col-sm-4">${sysLog.requestUri}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">操作方式：</td>
                                <td class="col-sm-4">${sysLog.method}</td>
                                <td class="col-sm-2">操作提交的数据：</td>
                                <td class="col-sm-4">${sysLog.params}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">异常信息：</td>
                                <td class="col-sm-4">${sysLog.exception}</td>
                                <td class="col-sm-2"></td>
                                <td class="col-sm-4"></td>
                            </tr>
                         
                        </tbody>
                    </table>
                </section>
            </section>
        </section>
    </aside>
</section>

<jsp:include page="/view/panel/wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/admin/sys/log.detail.js" type="text/javascript"></script>
