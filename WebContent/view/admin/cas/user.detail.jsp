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
                                <td class="col-sm-2">用户ID：</td>
                                <td class="col-sm-4">${casUser.userId}</td>
                                <td class="col-sm-2">用户所属组别：</td>
                                <td class="col-sm-4">${casUser.userGroupId}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">用户所属等级：</td>
                                <td class="col-sm-4">${casUser.userLvId}</td>
                                <td class="col-sm-2">用户账号：</td>
                                <td class="col-sm-4">${casUser.username}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">密码：</td>
                                <td class="col-sm-4">${casUser.password}</td>
                                <td class="col-sm-2">冻结器密码：</td>
                                <td class="col-sm-4">${casUser.freeze}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">是否为第三方：</td>
                                <td class="col-sm-4">${casUser.isthere}</td>
                                <td class="col-sm-2">第三方平台ID：</td>
                                <td class="col-sm-4">${casUser.thirdid}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">password：</td>
                                <td class="col-sm-4">${casUser.salt}</td>
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${casUser.encrypt}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">座机号码：</td>
                                <td class="col-sm-4">${casUser.tel}</td>
                                <td class="col-sm-2">用户手机号：</td>
                                <td class="col-sm-4">${casUser.phone}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">手机验证状态：</td>
                                <td class="col-sm-4">${casUser.verifiedphone}</td>
                                <td class="col-sm-2">邮箱：</td>
                                <td class="col-sm-4">${casUser.email}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">邮箱验证状态：</td>
                                <td class="col-sm-4">${casUser.verifiedemail}</td>
                                <td class="col-sm-2">昵称：</td>
                                <td class="col-sm-4">${casUser.nickname}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">真实姓名：</td>
                                <td class="col-sm-4">${casUser.realname}</td>
                                <td class="col-sm-2">身份证号：</td>
                                <td class="col-sm-4">${casUser.idcard}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">性别：</td>
                                <td class="col-sm-4">${casUser.gender}</td>
                                <td class="col-sm-2">头像：</td>
                                <td class="col-sm-4">${casUser.avatar}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">设备类型：</td>
                                <td class="col-sm-4">${casUser.deviceType}</td>
                                <td class="col-sm-2">设备序列号：</td>
                                <td class="col-sm-4">${casUser.deviceNo}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">通道：</td>
                                <td class="col-sm-4">${casUser.channelid}</td>
                                <td class="col-sm-2">用户状态：</td>
                                <td class="col-sm-4">${casUser.status}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">是否可用：</td>
                                <td class="col-sm-4">${casUser.isVerify}</td>
                                <td class="col-sm-2">是否标记为删除：</td>
                                <td class="col-sm-4">${casUser.isDel}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">最后登陆时间：</td>
                                <td class="col-sm-4">${casUser.lastLoginTime}</td>
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${casUser.lastLoginIp}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">帐号封停结束时间：</td>
                                <td class="col-sm-4">${casUser.banEtime}</td>
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${casUser.ctime}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${casUser.mtime}</td>
                                <td class="col-sm-2">固话：</td>
                                <td class="col-sm-4">${casUser.telphone}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">：</td>
                                <td class="col-sm-4">${casUser.numberegral}</td>
                                <td class="col-sm-2">签名：</td>
                                <td class="col-sm-4">${casUser.signature}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2"> 类型：</td>
                                <td class="col-sm-4">${casUser.type}</td>
                                <td class="col-sm-2">头像：</td>
                                <td class="col-sm-4">${casUser.headportraitpath}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">手机号：</td>
                                <td class="col-sm-4">${casUser.mobile}</td>
                                <td class="col-sm-2">第三方登录类型：</td>
                                <td class="col-sm-4">${casUser.thirdlognumberype}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">是否回收：</td>
                                <td class="col-sm-4">${casUser.isrecycle}</td>
                                <td class="col-sm-2">创建人ID：</td>
                                <td class="col-sm-4">${casUser.creatorid}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">修改人id：</td>
                                <td class="col-sm-4">${casUser.modifierid}</td>
                                <td class="col-sm-2">账户：</td>
                                <td class="col-sm-4">${casUser.account}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">是否冻结：</td>
                                <td class="col-sm-4">${casUser.isfreeze}</td>
                                <td class="col-sm-2">经度：</td>
                                <td class="col-sm-4">${casUser.longitude}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">维度：</td>
                                <td class="col-sm-4">${casUser.latitude}</td>
                                <td class="col-sm-2">商铺ID：</td>
                                <td class="col-sm-4">${casUser.storeId}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">是否有店铺：</td>
                                <td class="col-sm-4">${casUser.isHaveStore}</td>
                                <td class="col-sm-2">地址：</td>
                                <td class="col-sm-4">${casUser.address}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">生日：</td>
                                <td class="col-sm-4">${casUser.birthday}</td>
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
<script src="${STATIC_URL}/admin/cas/user.detail.js" type="text/javascript"></script>
