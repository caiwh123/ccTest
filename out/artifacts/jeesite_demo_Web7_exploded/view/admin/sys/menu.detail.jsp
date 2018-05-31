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
                                <td class="col-sm-4">${sysMenu.id}</td>
                                <td class="col-sm-2">父级编号：</td>
                                <td class="col-sm-4">${sysMenu.parentId}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">所有父级编号：</td>
                                <td class="col-sm-4">${sysMenu.parentIds}</td>
                                <td class="col-sm-2">名称：</td>
                                <td class="col-sm-4">${sysMenu.name}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">排序：</td>
                                <td class="col-sm-4">${sysMenu.sort}</td>
                                <td class="col-sm-2">链接：</td>
                                <td class="col-sm-4">${sysMenu.href}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">目标：</td>
                                <td class="col-sm-4">${sysMenu.target}</td>
                                <td class="col-sm-2">图标：</td>
                                <td class="col-sm-4">${sysMenu.icon}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">是否在菜单中显示：</td>
                                <td class="col-sm-4">${sysMenu.isShow}</td>
                                <td class="col-sm-2">权限标识：</td>
                                <td class="col-sm-4">${sysMenu.permission}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${sysMenu.createBy}</td>
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${sysMenu.createDate}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${sysMenu.updateBy}</td>
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${sysMenu.updateDate}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">备注信息：</td>
                                <td class="col-sm-4">${sysMenu.remarks}</td>
                                <td class="col-sm-2">删除标记：</td>
                                <td class="col-sm-4">${sysMenu.delFlag}</td>
                            </tr>
                         
                        </tbody>
                    </table>
                </section>
            </section>
        </section>
    </aside>
</section>

<jsp:include page="/view/panel/wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/admin/sys/menu.detail.js" type="text/javascript"></script>
