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
                                <td class="col-sm-2">编号：</td>
                                <td class="col-sm-4">${sysDict.id}</td>
                                <td class="col-sm-2">数据值：</td>
                                <td class="col-sm-4">${sysDict.value}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">标签名：</td>
                                <td class="col-sm-4">${sysDict.label}</td>
                                <td class="col-sm-2">类型：</td>
                                <td class="col-sm-4">${sysDict.type}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">描述：</td>
                                <td class="col-sm-4">${sysDict.description}</td>
                                <td class="col-sm-2">排序：</td>
                                <td class="col-sm-4">${sysDict.sort}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">父级编号：</td>
                                <td class="col-sm-4">${sysDict.parentId}</td>
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${sysDict.createBy}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${sysDict.createDate}</td>
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${sysDict.updateBy}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${sysDict.updateDate}</td>
                                <td class="col-sm-2">备注信息：</td>
                                <td class="col-sm-4">${sysDict.remarks}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">删除标记：</td>
                                <td class="col-sm-4">${sysDict.delFlag}</td>
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
<script src="${STATIC_URL}/admin/sys/dict.detail.js" type="text/javascript"></script>
