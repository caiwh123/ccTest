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
                                <td class="col-sm-4">${sysRole.id}</td>
                                <td class="col-sm-2">归属机构：</td>
                                <td class="col-sm-4">${sysRole.officeId}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">角色名称：</td>
                                <td class="col-sm-4">${sysRole.name}</td>
                                <td class="col-sm-2">英文名称：</td>
                                <td class="col-sm-4">${sysRole.enname}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">角色类型：</td>
                                <td class="col-sm-4">${sysRole.roleType}</td>
                                <td class="col-sm-2">数据范围：</td>
                                <td class="col-sm-4">${sysRole.dataScope}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">是否系统数据：</td>
                                <td class="col-sm-4">${sysRole.isSys}</td>
                                <td class="col-sm-2">是否可用：</td>
                                <td class="col-sm-4">${sysRole.useable}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${sysRole.createBy}</td>
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${sysRole.createDate}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${sysRole.updateBy}</td>
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${sysRole.updateDate}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">备注信息：</td>
                                <td class="col-sm-4">${sysRole.remarks}</td>
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${sysRole.delFlag}</td>
                            </tr>
                         
                        </tbody>
                    </table>
                </section>
            </section>
        </section>
    </aside>
</section>

<jsp:include page="/view/panel/wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/admin/sys/role.detail.js" type="text/javascript"></script>
