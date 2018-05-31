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
		
				var id = $(this).attr("id");
		
		/* 执行 */
		$.ajax({
			type : 'post',
			url : BASE_URL + '/sysUser/delete',
			data : 'id=' + id,
			dataType : 'json',
			timeout : 10000,
			success : function(data) {
				if (data.status == 0) {
					$("#id_" + id).parent().parent().remove();
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
					property : 'id',
					label : '',
					sortable : false
				},
				{
					property : 'companyId',
					label : '归属公司',
					sortable : false
				},
				{
					property : 'officeId',
					label : '归属部门',
					sortable : false
				},
				{
					property : 'loginName',
					label : '登录名',
					sortable : false
				},
				{
					property : 'password',
					label : '密码',
					sortable : false
				},
				{
					property : 'no',
					label : '工号',
					sortable : false
				},
				{
					property : 'name',
					label : '姓名',
					sortable : false
				},
				{
					property : 'email',
					label : '邮件',
					sortable : false
				},
				{
					property : 'phone',
					label : '电话',
					sortable : false
				},
				{
					property : 'mobile',
					label : '手机',
					sortable : false
				},
				{
					property : 'userType',
					label : '用户类型',
					sortable : false
				},
				{
					property : 'photo',
					label : '用户头像',
					sortable : false
				},
				{
					property : 'loginIp',
					label : '最后登陆IP',
					sortable : false
				},
				{
					property : 'loginDate',
					label : '最后登陆时间',
					sortable : false
				},
				{
					property : 'loginFlag',
					label : '是否可登录',
					sortable : false
				},
				{
					property : 'createBy',
					label : '',
					sortable : false
				},
				{
					property : 'createDate',
					label : '',
					sortable : false
				},
				{
					property : 'updateBy',
					label : '',
					sortable : false
				},
				{
					property : 'updateDate',
					label : '',
					sortable : false
				},
				{
					property : 'remarks',
					label : '',
					sortable : false
				},
				{
					property : 'delFlag',
					label : '',
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
		item._query = '<a href="'+BASE_URL+'/sysUser/detail?id=' + item.id + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';
		item._action = '<a href="' + BASE_URL + '/sysUser/edit?id=' + item.id
				+ '" class="operating-edit" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" id="id_' + item.id + '" id="' + item.id
				+ '" title="删除"><i class="fa fa-trash-o"></i></a>';

	});
}