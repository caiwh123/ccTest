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
                                <td class="col-sm-4">${sysUser.id}</td>
                                <td class="col-sm-2">归属公司：</td>
                                <td class="col-sm-4">${sysUser.companyId}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">归属部门：</td>
                                <td class="col-sm-4">${sysUser.officeId}</td>
                                <td class="col-sm-2">登录名：</td>
                                <td class="col-sm-4">${sysUser.loginName}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">密码：</td>
                                <td class="col-sm-4">${sysUser.password}</td>
                                <td class="col-sm-2">工号：</td>
                                <td class="col-sm-4">${sysUser.no}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">姓名：</td>
                                <td class="col-sm-4">${sysUser.name}</td>
                                <td class="col-sm-2">邮件：</td>
                                <td class="col-sm-4">${sysUser.email}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">电话：</td>
                                <td class="col-sm-4">${sysUser.phone}</td>
                                <td class="col-sm-2">手机：</td>
                                <td class="col-sm-4">${sysUser.mobile}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">用户类型：</td>
                                <td class="col-sm-4">${sysUser.userType}</td>
                                <td class="col-sm-2">用户头像：</td>
                                <td class="col-sm-4">${sysUser.photo}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">最后登陆IP：</td>
                                <td class="col-sm-4">${sysUser.loginIp}</td>
                                <td class="col-sm-2">最后登陆时间：</td>
                                <td class="col-sm-4">${sysUser.loginDate}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">是否可登录：</td>
                                <td class="col-sm-4">${sysUser.loginFlag}</td>
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${sysUser.createBy}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${sysUser.createDate}</td>
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${sysUser.updateBy}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${sysUser.updateDate}</td>
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${sysUser.remarks}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${sysUser.delFlag}</td>
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
<script src="${STATIC_URL}/admin/sys/user.detail.js" type="text/javascript"></script>
