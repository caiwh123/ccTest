package com.bluemobi.po.cas;

import java.math.BigDecimal;

import com.appcore.model.AbstractObject;

/**
 * 【】持久化对象 数据库表：CAS_USER
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-10-17 18:00:54
 * 
 */
public class CasUser extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 用户ID，主键
    private String userId;
    // 用户所属组别 ID
    private String userGroupId;
    // 用户所属等级 ID
    private String userLvId;
    // 用户账号
    private String username;
    // 密码
    private String password;
    // 冻结器密码
    private String freeze;
    // 是否为第三方 0 否 1 是
    private Long isthere;
    // 第三方平台ID
    private String thirdid;
    // password enhanced vars
    private String salt;
    // 
    private String encrypt;
    // 座机号码
    private String tel;
    // 用户手机号
    private String phone;
    // 手机验证状态。1：验证通过；0：验证未通过；
    private Short verifiedphone;
    // 邮箱
    private String email;
    // 邮箱验证状态。1：验证通过；0：验证未通过；
    private Short verifiedemail;
    // 昵称
    private String nickname;
    // 真实姓名
    private String realname;
    // 身份证号，18位
    private String idcard;
    // 性别。1：男；2：女；0：未知；
    private Short gender;
    // 头像
    private String avatar;
    // 设备类型。android、iphone、ipad
    private String deviceType;
    // 设备序列号（横店为筛选id）
    private String deviceNo;
    // 通道 ID（适用于安卓推送）
    private String channelid;
    // 用户状态。1：已激活；0：未激活；
    private Short status;
    // 是否可用。1：是；0：否；
    private Short isVerify;
    // 是否标记为删除。1：是；0：否；
    private Short isDel;
    // 最后登陆时间
    private String lastLoginTime;
    // 
    private String lastLoginIp;
    // 帐号封停结束时间
    private String banEtime;
    // 
    private String ctime;
    // 
    private String mtime;
    // 固话
    private String telphone;
    // 
    private Long numberegral;
    // 签名
    private String signature;
    //  类型：（1-普通，第三方；2-注册，内部；3-VIP；4-讲师）
    private Short type;
    // 头像
    private String headportraitpath;
    // 手机号
    private String mobile;
    // 第三方登录类型
    private String thirdlognumberype;
    // 是否回收（1-是；2-否）
    private Short isrecycle;
    // 创建人ID
    private BigDecimal creatorid;
    // 修改人id
    private BigDecimal modifierid;
    // 账户
    private String account;
    // 是否冻结（1-是；2-否）
    private Short isfreeze;
    // 经度
    private String longitude;
    // 维度
    private String latitude;
    // 商铺ID
    private Long storeId;
    // 是否有店铺，1有0没有
    private Short isHaveStore;
    // 地址
    private String address;
    // 生日
    private String birthday;

    /** 获取 用户ID，主键 属性 */
    public String getUserId() {
        return userId;
    }

    /** 设置 用户ID，主键 属性 */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /** 获取 用户所属组别 ID 属性 */
    public String getUserGroupId() {
        return userGroupId;
    }

    /** 设置 用户所属组别 ID 属性 */
    public void setUserGroupId(String userGroupId) {
        this.userGroupId = userGroupId;
    }

    /** 获取 用户所属等级 ID 属性 */
    public String getUserLvId() {
        return userLvId;
    }

    /** 设置 用户所属等级 ID 属性 */
    public void setUserLvId(String userLvId) {
        this.userLvId = userLvId;
    }

    /** 获取 用户账号 属性 */
    public String getUsername() {
        return username;
    }

    /** 设置 用户账号 属性 */
    public void setUsername(String username) {
        this.username = username;
    }

    /** 获取 密码 属性 */
    public String getPassword() {
        return password;
    }

    /** 设置 密码 属性 */
    public void setPassword(String password) {
        this.password = password;
    }

    /** 获取 冻结器密码 属性 */
    public String getFreeze() {
        return freeze;
    }

    /** 设置 冻结器密码 属性 */
    public void setFreeze(String freeze) {
        this.freeze = freeze;
    }

    /** 获取 是否为第三方 0 否 1 是 属性 */
    public Long getIsthere() {
        return isthere;
    }

    /** 设置 是否为第三方 0 否 1 是 属性 */
    public void setIsthere(Long isthere) {
        this.isthere = isthere;
    }

    /** 获取 第三方平台ID 属性 */
    public String getThirdid() {
        return thirdid;
    }

    /** 设置 第三方平台ID 属性 */
    public void setThirdid(String thirdid) {
        this.thirdid = thirdid;
    }

    /** 获取 password enhanced vars 属性 */
    public String getSalt() {
        return salt;
    }

    /** 设置 password enhanced vars 属性 */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /** 获取  属性 */
    public String getEncrypt() {
        return encrypt;
    }

    /** 设置  属性 */
    public void setEncrypt(String encrypt) {
        this.encrypt = encrypt;
    }

    /** 获取 座机号码 属性 */
    public String getTel() {
        return tel;
    }

    /** 设置 座机号码 属性 */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /** 获取 用户手机号 属性 */
    public String getPhone() {
        return phone;
    }

    /** 设置 用户手机号 属性 */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /** 获取 手机验证状态。1：验证通过；0：验证未通过； 属性 */
    public Short getVerifiedphone() {
        return verifiedphone;
    }

    /** 设置 手机验证状态。1：验证通过；0：验证未通过； 属性 */
    public void setVerifiedphone(Short verifiedphone) {
        this.verifiedphone = verifiedphone;
    }

    /** 获取 邮箱 属性 */
    public String getEmail() {
        return email;
    }

    /** 设置 邮箱 属性 */
    public void setEmail(String email) {
        this.email = email;
    }

    /** 获取 邮箱验证状态。1：验证通过；0：验证未通过； 属性 */
    public Short getVerifiedemail() {
        return verifiedemail;
    }

    /** 设置 邮箱验证状态。1：验证通过；0：验证未通过； 属性 */
    public void setVerifiedemail(Short verifiedemail) {
        this.verifiedemail = verifiedemail;
    }

    /** 获取 昵称 属性 */
    public String getNickname() {
        return nickname;
    }

    /** 设置 昵称 属性 */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /** 获取 真实姓名 属性 */
    public String getRealname() {
        return realname;
    }

    /** 设置 真实姓名 属性 */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /** 获取 身份证号，18位 属性 */
    public String getIdcard() {
        return idcard;
    }

    /** 设置 身份证号，18位 属性 */
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    /** 获取 性别。1：男；2：女；0：未知； 属性 */
    public Short getGender() {
        return gender;
    }

    /** 设置 性别。1：男；2：女；0：未知； 属性 */
    public void setGender(Short gender) {
        this.gender = gender;
    }

    /** 获取 头像 属性 */
    public String getAvatar() {
        return avatar;
    }

    /** 设置 头像 属性 */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /** 获取 设备类型。android、iphone、ipad 属性 */
    public String getDeviceType() {
        return deviceType;
    }

    /** 设置 设备类型。android、iphone、ipad 属性 */
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    /** 获取 设备序列号（横店为筛选id） 属性 */
    public String getDeviceNo() {
        return deviceNo;
    }

    /** 设置 设备序列号（横店为筛选id） 属性 */
    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    /** 获取 通道 ID（适用于安卓推送） 属性 */
    public String getChannelid() {
        return channelid;
    }

    /** 设置 通道 ID（适用于安卓推送） 属性 */
    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    /** 获取 用户状态。1：已激活；0：未激活； 属性 */
    public Short getStatus() {
        return status;
    }

    /** 设置 用户状态。1：已激活；0：未激活； 属性 */
    public void setStatus(Short status) {
        this.status = status;
    }

    /** 获取 是否可用。1：是；0：否； 属性 */
    public Short getIsVerify() {
        return isVerify;
    }

    /** 设置 是否可用。1：是；0：否； 属性 */
    public void setIsVerify(Short isVerify) {
        this.isVerify = isVerify;
    }

    /** 获取 是否标记为删除。1：是；0：否； 属性 */
    public Short getIsDel() {
        return isDel;
    }

    /** 设置 是否标记为删除。1：是；0：否； 属性 */
    public void setIsDel(Short isDel) {
        this.isDel = isDel;
    }

    /** 获取 最后登陆时间 属性 */
    public String getLastLoginTime() {
        return lastLoginTime;
    }

    /** 设置 最后登陆时间 属性 */
    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /** 获取  属性 */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /** 设置  属性 */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    /** 获取 帐号封停结束时间 属性 */
    public String getBanEtime() {
        return banEtime;
    }

    /** 设置 帐号封停结束时间 属性 */
    public void setBanEtime(String banEtime) {
        this.banEtime = banEtime;
    }

    /** 获取  属性 */
    public String getCtime() {
        return ctime;
    }

    /** 设置  属性 */
    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    /** 获取  属性 */
    public String getMtime() {
        return mtime;
    }

    /** 设置  属性 */
    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    /** 获取 固话 属性 */
    public String getTelphone() {
        return telphone;
    }

    /** 设置 固话 属性 */
    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    /** 获取  属性 */
    public Long getNumberegral() {
        return numberegral;
    }

    /** 设置  属性 */
    public void setNumberegral(Long numberegral) {
        this.numberegral = numberegral;
    }

    /** 获取 签名 属性 */
    public String getSignature() {
        return signature;
    }

    /** 设置 签名 属性 */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /** 获取  类型：（1-普通，第三方；2-注册，内部；3-VIP；4-讲师） 属性 */
    public Short getType() {
        return type;
    }

    /** 设置  类型：（1-普通，第三方；2-注册，内部；3-VIP；4-讲师） 属性 */
    public void setType(Short type) {
        this.type = type;
    }

    /** 获取 头像 属性 */
    public String getHeadportraitpath() {
        return headportraitpath;
    }

    /** 设置 头像 属性 */
    public void setHeadportraitpath(String headportraitpath) {
        this.headportraitpath = headportraitpath;
    }

    /** 获取 手机号 属性 */
    public String getMobile() {
        return mobile;
    }

    /** 设置 手机号 属性 */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /** 获取 第三方登录类型 属性 */
    public String getThirdlognumberype() {
        return thirdlognumberype;
    }

    /** 设置 第三方登录类型 属性 */
    public void setThirdlognumberype(String thirdlognumberype) {
        this.thirdlognumberype = thirdlognumberype;
    }

    /** 获取 是否回收（1-是；2-否） 属性 */
    public Short getIsrecycle() {
        return isrecycle;
    }

    /** 设置 是否回收（1-是；2-否） 属性 */
    public void setIsrecycle(Short isrecycle) {
        this.isrecycle = isrecycle;
    }

    /** 获取 创建人ID 属性 */
    public BigDecimal getCreatorid() {
        return creatorid;
    }

    /** 设置 创建人ID 属性 */
    public void setCreatorid(BigDecimal creatorid) {
        this.creatorid = creatorid;
    }

    /** 获取 修改人id 属性 */
    public BigDecimal getModifierid() {
        return modifierid;
    }

    /** 设置 修改人id 属性 */
    public void setModifierid(BigDecimal modifierid) {
        this.modifierid = modifierid;
    }

    /** 获取 账户 属性 */
    public String getAccount() {
        return account;
    }

    /** 设置 账户 属性 */
    public void setAccount(String account) {
        this.account = account;
    }

    /** 获取 是否冻结（1-是；2-否） 属性 */
    public Short getIsfreeze() {
        return isfreeze;
    }

    /** 设置 是否冻结（1-是；2-否） 属性 */
    public void setIsfreeze(Short isfreeze) {
        this.isfreeze = isfreeze;
    }

    /** 获取 经度 属性 */
    public String getLongitude() {
        return longitude;
    }

    /** 设置 经度 属性 */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /** 获取 维度 属性 */
    public String getLatitude() {
        return latitude;
    }

    /** 设置 维度 属性 */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /** 获取 商铺ID 属性 */
    public Long getStoreId() {
        return storeId;
    }

    /** 设置 商铺ID 属性 */
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    /** 获取 是否有店铺，1有0没有 属性 */
    public Short getIsHaveStore() {
        return isHaveStore;
    }

    /** 设置 是否有店铺，1有0没有 属性 */
    public void setIsHaveStore(Short isHaveStore) {
        this.isHaveStore = isHaveStore;
    }

    /** 获取 地址 属性 */
    public String getAddress() {
        return address;
    }

    /** 设置 地址 属性 */
    public void setAddress(String address) {
        this.address = address;
    }

    /** 获取 生日 属性 */
    public String getBirthday() {
        return birthday;
    }

    /** 设置 生日 属性 */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CasUser");
        sb.append("{userId=").append(userId);
        sb.append(", userGroupId=").append(userGroupId);
        sb.append(", userLvId=").append(userLvId);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", freeze=").append(freeze);
        sb.append(", isthere=").append(isthere);
        sb.append(", thirdid=").append(thirdid);
        sb.append(", salt=").append(salt);
        sb.append(", encrypt=").append(encrypt);
        sb.append(", tel=").append(tel);
        sb.append(", phone=").append(phone);
        sb.append(", verifiedphone=").append(verifiedphone);
        sb.append(", email=").append(email);
        sb.append(", verifiedemail=").append(verifiedemail);
        sb.append(", nickname=").append(nickname);
        sb.append(", realname=").append(realname);
        sb.append(", idcard=").append(idcard);
        sb.append(", gender=").append(gender);
        sb.append(", avatar=").append(avatar);
        sb.append(", deviceType=").append(deviceType);
        sb.append(", deviceNo=").append(deviceNo);
        sb.append(", channelid=").append(channelid);
        sb.append(", status=").append(status);
        sb.append(", isVerify=").append(isVerify);
        sb.append(", isDel=").append(isDel);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", lastLoginIp=").append(lastLoginIp);
        sb.append(", banEtime=").append(banEtime);
        sb.append(", ctime=").append(ctime);
        sb.append(", mtime=").append(mtime);
        sb.append(", telphone=").append(telphone);
        sb.append(", numberegral=").append(numberegral);
        sb.append(", signature=").append(signature);
        sb.append(", type=").append(type);
        sb.append(", headportraitpath=").append(headportraitpath);
        sb.append(", mobile=").append(mobile);
        sb.append(", thirdlognumberype=").append(thirdlognumberype);
        sb.append(", isrecycle=").append(isrecycle);
        sb.append(", creatorid=").append(creatorid);
        sb.append(", modifierid=").append(modifierid);
        sb.append(", account=").append(account);
        sb.append(", isfreeze=").append(isfreeze);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", storeId=").append(storeId);
        sb.append(", isHaveStore=").append(isHaveStore);
        sb.append(", address=").append(address);
        sb.append(", birthday=").append(birthday);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CasUser) {
            CasUser casUser = (CasUser) obj;
            if (this.getUserId().equals(casUser.getUserId())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String pkStr = "" + this.getUserId();
        return pkStr.hashCode();
    }

}