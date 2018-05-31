<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/view/panel/wrapper.prefix.jsp"%>

  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${casUser!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${casUser!=null}">"${BASE_URL}/casUser/edit"</c:when><c:otherwise>"${BASE_URL}/casUser/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="userGroupId" class="col-sm-3 control-label"><font class="red">* </font>用户所属组别</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="userGroupId" name="userGroupId" value="${casUser.userGroupId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="userLvId" class="col-sm-3 control-label"><font class="red">* </font>用户所属等级</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="userLvId" name="userLvId" value="${casUser.userLvId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="username" class="col-sm-3 control-label"><font class="red">* </font>用户账号</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="username" name="username" value="${casUser.username}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="password" class="col-sm-3 control-label"><font class="red">* </font>密码</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="password" name="password" value="${casUser.password}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="freeze" class="col-sm-3 control-label"><font class="red">* </font>冻结器密码</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="freeze" name="freeze" value="${casUser.freeze}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="isthere" class="col-sm-3 control-label"><font class="red">* </font>是否为第三方</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="isthere" name="isthere" value="${casUser.isthere}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="thirdid" class="col-sm-3 control-label"><font class="red">* </font>第三方平台ID</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="thirdid" name="thirdid" value="${casUser.thirdid}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="salt" class="col-sm-3 control-label"><font class="red">* </font>password</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="salt" name="salt" value="${casUser.salt}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="encrypt" class="col-sm-3 control-label"><font class="red">* </font></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="encrypt" name="encrypt" value="${casUser.encrypt}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="tel" class="col-sm-3 control-label"><font class="red">* </font>座机号码</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="tel" name="tel" value="${casUser.tel}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="phone" class="col-sm-3 control-label"><font class="red">* </font>用户手机号</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="phone" name="phone" value="${casUser.phone}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="verifiedphone" class="col-sm-3 control-label"><font class="red">* </font>手机验证状态</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="verifiedphone" name="verifiedphone" value="${casUser.verifiedphone}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="email" class="col-sm-3 control-label"><font class="red">* </font>邮箱</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="email" name="email" value="${casUser.email}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="verifiedemail" class="col-sm-3 control-label"><font class="red">* </font>邮箱验证状态</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="verifiedemail" name="verifiedemail" value="${casUser.verifiedemail}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="nickname" class="col-sm-3 control-label"><font class="red">* </font>昵称</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="nickname" name="nickname" value="${casUser.nickname}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="realname" class="col-sm-3 control-label"><font class="red">* </font>真实姓名</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="realname" name="realname" value="${casUser.realname}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="idcard" class="col-sm-3 control-label"><font class="red">* </font>身份证号</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="idcard" name="idcard" value="${casUser.idcard}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="gender" class="col-sm-3 control-label"><font class="red">* </font>性别</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="gender" name="gender" value="${casUser.gender}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="avatar" class="col-sm-3 control-label"><font class="red">* </font>头像</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="avatar" name="avatar" value="${casUser.avatar}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="deviceType" class="col-sm-3 control-label"><font class="red">* </font>设备类型</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="deviceType" name="deviceType" value="${casUser.deviceType}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="deviceNo" class="col-sm-3 control-label"><font class="red">* </font>设备序列号</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="deviceNo" name="deviceNo" value="${casUser.deviceNo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="channelid" class="col-sm-3 control-label"><font class="red">* </font>通道</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="channelid" name="channelid" value="${casUser.channelid}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="status" class="col-sm-3 control-label"><font class="red">* </font>用户状态</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="status" name="status" value="${casUser.status}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="isVerify" class="col-sm-3 control-label"><font class="red">* </font>是否可用</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="isVerify" name="isVerify" value="${casUser.isVerify}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="isDel" class="col-sm-3 control-label"><font class="red">* </font>是否标记为删除</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="isDel" name="isDel" value="${casUser.isDel}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="lastLoginTime" class="col-sm-3 control-label"><font class="red">* </font>最后登陆时间</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="lastLoginTime" name="lastLoginTime" value="${casUser.lastLoginTime}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="lastLoginIp" class="col-sm-3 control-label"><font class="red">* </font></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="lastLoginIp" name="lastLoginIp" value="${casUser.lastLoginIp}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="banEtime" class="col-sm-3 control-label"><font class="red">* </font>帐号封停结束时间</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="banEtime" name="banEtime" value="${casUser.banEtime}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="ctime" class="col-sm-3 control-label"><font class="red">* </font></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="ctime" name="ctime" value="${casUser.ctime}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="mtime" class="col-sm-3 control-label"><font class="red">* </font></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="mtime" name="mtime" value="${casUser.mtime}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="telphone" class="col-sm-3 control-label"><font class="red">* </font>固话</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="telphone" name="telphone" value="${casUser.telphone}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="numberegral" class="col-sm-3 control-label"><font class="red">* </font></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="numberegral" name="numberegral" value="${casUser.numberegral}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="signature" class="col-sm-3 control-label"><font class="red">* </font>签名</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="signature" name="signature" value="${casUser.signature}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="type" class="col-sm-3 control-label"><font class="red">* </font> 类型</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="type" name="type" value="${casUser.type}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="headportraitpath" class="col-sm-3 control-label"><font class="red">* </font>头像</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="headportraitpath" name="headportraitpath" value="${casUser.headportraitpath}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="mobile" class="col-sm-3 control-label"><font class="red">* </font>手机号</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="mobile" name="mobile" value="${casUser.mobile}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="thirdlognumberype" class="col-sm-3 control-label"><font class="red">* </font>第三方登录类型</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="thirdlognumberype" name="thirdlognumberype" value="${casUser.thirdlognumberype}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="isrecycle" class="col-sm-3 control-label"><font class="red">* </font>是否回收</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="isrecycle" name="isrecycle" value="${casUser.isrecycle}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="creatorid" class="col-sm-3 control-label"><font class="red">* </font>创建人ID</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="creatorid" name="creatorid" value="${casUser.creatorid}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="modifierid" class="col-sm-3 control-label"><font class="red">* </font>修改人id</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="modifierid" name="modifierid" value="${casUser.modifierid}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="account" class="col-sm-3 control-label"><font class="red">* </font>账户</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="account" name="account" value="${casUser.account}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="isfreeze" class="col-sm-3 control-label"><font class="red">* </font>是否冻结</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="isfreeze" name="isfreeze" value="${casUser.isfreeze}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="longitude" class="col-sm-3 control-label"><font class="red">* </font>经度</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="longitude" name="longitude" value="${casUser.longitude}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="latitude" class="col-sm-3 control-label"><font class="red">* </font>维度</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="latitude" name="latitude" value="${casUser.latitude}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="storeId" class="col-sm-3 control-label"><font class="red">* </font>商铺ID</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="storeId" name="storeId" value="${casUser.storeId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="isHaveStore" class="col-sm-3 control-label"><font class="red">* </font>是否有店铺</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="isHaveStore" name="isHaveStore" value="${casUser.isHaveStore}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="address" class="col-sm-3 control-label"><font class="red">* </font>地址</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="address" name="address" value="${casUser.address}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <div class="form-group">
                        <label for="birthday" class="col-sm-3 control-label"><font class="red">* </font>生日</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="birthday" name="birthday" value="${casUser.birthday}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                             </div>
                      </div>
                    <input type="hidden" name="userId" value="${casUser.userId}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${casUser==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
                    <button type="button" data_submit_type="submit_cancel" class="btn btn-danger btn-sm input-submit">取消</button>
                    <span id="edit_notice"></span>
                </div>
            </footer>
        </section>
    </aside>
</section>

<jsp:include page="/view/panel/wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/admin/cas/user.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->