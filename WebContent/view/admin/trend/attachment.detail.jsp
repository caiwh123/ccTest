<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../wrapper.prefix.jsp"/>

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
                                <td class="col-sm-4">${trendAttachment.attachmentid}</td>
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${trendAttachment.userid}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${trendAttachment.title}</td>
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${trendAttachment.description}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${trendAttachment.label}</td>
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${trendAttachment.mediatype}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${trendAttachment.mimetype}</td>
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${trendAttachment.suffix}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${trendAttachment.imageable}</td>
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${trendAttachment.imageWidth}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${trendAttachment.imageHeight}</td>
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${trendAttachment.ctime}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${trendAttachment.mtime}</td>
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${trendAttachment.filepath}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${trendAttachment.filesize}</td>
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${trendAttachment.hashcode}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${trendAttachment.status}</td>
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${trendAttachment.rev}</td>
                            </tr>
                         
                        </tbody>
                    </table>
                </section>
            </section>
        </section>
    </aside>
</section>

<jsp:include page="../wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/back/modules/trend/js/attachment.detail.js" type="text/javascript"></script>
