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
		
				var inviteId = $(this).attr("inviteId");
		
		/* 执行 */
		$.ajax({
			type : 'post',
			url : BASE_URL + '/casUserInvite/delete',
			data : 'inviteId=' + inviteId,
			dataType : 'json',
			timeout : 10000,
			success : function(data) {
				if (data.status == 0) {
					$("#inviteId_" + inviteId).parent().parent().remove();
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
					property : 'inviteId',
					label : 'id',
					sortable : false
				},
				{
					property : 'userid',
					label : '用户id',
					sortable : false
				},
				{
					property : 'beuserid',
					label : '被邀请id',
					sortable : false
				},
				{
					property : 'integral',
					label : '积分',
					sortable : false
				},
				{
					property : 'isregister',
					label : '是否注册',
					sortable : false
				},
				{
					property : 'reserve',
					label : '预留字段',
					sortable : false
				},
				{
					property : 'creattime',
					label : '创建时间',
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
		item._query = '<a href="'+BASE_URL+'/casUserInvite/detail?inviteId=' + item.inviteId + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';
		item._action = '<a href="' + BASE_URL + '/casUserInvite/edit?inviteId=' + item.inviteId
				+ '" class="operating-edit" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" id="inviteId_' + item.inviteId + '" inviteId="' + item.inviteId
				+ '" title="删除"><i class="fa fa-trash-o"></i></a>';

		item.creattime = dateConverter(item.creattime, PATTERN_ENUM.datetime);
	});
}