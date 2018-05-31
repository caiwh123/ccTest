$(document).ready(function() {
	loadDataGridContent(columnsDefined(), 'formatData');
	
	/**
	 * 刷新或搜索
	 */
	$('body').delegate('.action-refresh, #action_search', 'click', function() {
		$('#content_listing').datagrid('reload');
	});

	/**
	 * 关键字搜索 - 支持回车
	 */
	$("input[name=key]").on('keypress', function(event) {
		if (event.which == '13') {
			$('#content_listing').datagrid('reload');
			return false;
		}
	});

	/**
	 * 单个删除
	 */
	$('body').delegate('.operate-delete', 'click', function() {
		var del = confirm('确定要删除吗？');
		if (!del) {
			return false;
		}
		
				var userId = $(this).attr("userId");
		
		/* 执行 */
		$.ajax({
			type : 'post',
			url : BASE_URL + '/casUser/delete',
			data : 'userId=' + userId,
			dataType : 'json',
			timeout : 10000,
			success : function(data) {
				if (data.status == 0) {
					$("#userId_" + userId).parent().parent().remove();
				} else {
					alert(data.msg);
				}
				return false;
			}
		});
	});
});

function columnsDefined() {
	return [
				{
					property: '_query',
					label: ''
				},
				{
					property : 'userId',
					label : '用户ID',
					sortable : false
				},
				{
					property : 'userGroupId',
					label : '用户所属组别',
					sortable : false
				},
				{
					property : 'userLvId',
					label : '用户所属等级',
					sortable : false
				},
				{
					property : 'username',
					label : '用户账号',
					sortable : false
				},
				{
					property : 'password',
					label : '密码',
					sortable : false
				},
				{
					property : 'freeze',
					label : '冻结器密码',
					sortable : false
				},
				{
					property : 'isthere',
					label : '是否为第三方',
					sortable : false
				},
				{
					property : 'thirdid',
					label : '第三方平台ID',
					sortable : false
				},
				{
					property : 'salt',
					label : 'password',
					sortable : false
				},
				{
					property : 'encrypt',
					label : '',
					sortable : false
				},
				{
					property : 'tel',
					label : '座机号码',
					sortable : false
				},
				{
					property : 'phone',
					label : '用户手机号',
					sortable : false
				},
				{
					property : 'verifiedphone',
					label : '手机验证状态',
					sortable : false
				},
				{
					property : 'email',
					label : '邮箱',
					sortable : false
				},
				{
					property : 'verifiedemail',
					label : '邮箱验证状态',
					sortable : false
				},
				{
					property : 'nickname',
					label : '昵称',
					sortable : false
				},
				{
					property : 'realname',
					label : '真实姓名',
					sortable : false
				},
				{
					property : 'idcard',
					label : '身份证号',
					sortable : false
				},
				{
					property : 'gender',
					label : '性别',
					sortable : false
				},
				{
					property : 'avatar',
					label : '头像',
					sortable : false
				},
				{
					property : 'deviceType',
					label : '设备类型',
					sortable : false
				},
				{
					property : 'deviceNo',
					label : '设备序列号',
					sortable : false
				},
				{
					property : 'channelid',
					label : '通道',
					sortable : false
				},
				{
					property : 'status',
					label : '用户状态',
					sortable : false
				},
				{
					property : 'isVerify',
					label : '是否可用',
					sortable : false
				},
				{
					property : 'isDel',
					label : '是否标记为删除',
					sortable : false
				},
				{
					property : 'lastLoginTime',
					label : '最后登陆时间',
					sortable : false
				},
				{
					property : 'lastLoginIp',
					label : '',
					sortable : false
				},
				{
					property : 'banEtime',
					label : '帐号封停结束时间',
					sortable : false
				},
				{
					property : 'ctime',
					label : '',
					sortable : false
				},
				{
					property : 'mtime',
					label : '',
					sortable : false
				},
				{
					property : 'telphone',
					label : '固话',
					sortable : false
				},
				{
					property : 'numberegral',
					label : '',
					sortable : false
				},
				{
					property : 'signature',
					label : '签名',
					sortable : false
				},
				{
					property : 'type',
					label : ' 类型',
					sortable : false
				},
				{
					property : 'headportraitpath',
					label : '头像',
					sortable : false
				},
				{
					property : 'mobile',
					label : '手机号',
					sortable : false
				},
				{
					property : 'thirdlognumberype',
					label : '第三方登录类型',
					sortable : false
				},
				{
					property : 'isrecycle',
					label : '是否回收',
					sortable : false
				},
				{
					property : 'creatorid',
					label : '创建人ID',
					sortable : false
				},
				{
					property : 'modifierid',
					label : '修改人id',
					sortable : false
				},
				{
					property : 'account',
					label : '账户',
					sortable : false
				},
				{
					property : 'isfreeze',
					label : '是否冻结',
					sortable : false
				},
				{
					property : 'longitude',
					label : '经度',
					sortable : false
				},
				{
					property : 'latitude',
					label : '维度',
					sortable : false
				},
				{
					property : 'storeId',
					label : '商铺ID',
					sortable : false
				},
				{
					property : 'isHaveStore',
					label : '是否有店铺',
					sortable : false
				},
				{
					property : 'address',
					label : '地址',
					sortable : false
				},
				{
					property : 'birthday',
					label : '生日',
					sortable : false
				},
				{
					property : '_action',
					label : '操作',
					sortable : false
				} 
			];
}

function formatData(items) {
	$.each(items, function(index, item) {
		item._query = '<a href="'+BASE_URL+'/casUser/detail?userId=' + item.userId + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';
		item._action = '<a href="' + BASE_URL + '/casUser/edit?userId=' + item.userId
				+ '" class="operating-edit" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" id="userId_' + item.userId + '" userId="' + item.userId
				+ '" title="删除"><i class="fa fa-trash-o"></i></a>';

	});
}