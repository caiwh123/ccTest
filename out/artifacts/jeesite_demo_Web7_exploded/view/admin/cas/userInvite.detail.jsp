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
                                <td class="col-sm-2">id：</td>
                                <td class="col-sm-4">${casUserInvite.inviteId}</td>
                                <td class="col-sm-2">用户id：</td>
                                <td class="col-sm-4">${casUserInvite.userid}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">被邀请id：</td>
                                <td class="col-sm-4">${casUserInvite.beuserid}</td>
                                <td class="col-sm-2">积分：</td>
                                <td class="col-sm-4">${casUserInvite.integral}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">是否注册：</td>
                                <td class="col-sm-4">${casUserInvite.isregister}</td>
                                <td class="col-sm-2">预留字段：</td>
                                <td class="col-sm-4">${casUserInvite.reserve}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">创建时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${casUserInvite.creattime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
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
<script src="${STATIC_URL}/admin/cas/userInvite.detail.js" type="text/javascript"></script>
