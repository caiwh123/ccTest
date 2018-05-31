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
			url : BASE_URL + '/sysLog/delete',
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
					property : 'type',
					label : '日志类型',
					sortable : false
				},
				{
					property : 'title',
					label : '日志标题',
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
					property : 'remoteAddr',
					label : '操作IP地址',
					sortable : false
				},
				{
					property : 'userAgent',
					label : '用户代理',
					sortable : false
				},
				{
					property : 'requestUri',
					label : '请求URI',
					sortable : false
				},
				{
					property : 'method',
					label : '操作方式',
					sortable : false
				},
				{
					property : 'params',
					label : '操作提交的数据',
					sortable : false
				},
				{
					property : 'exception',
					label : '异常信息',
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
		item._query = '<a href="'+BASE_URL+'/sysLog/detail?id=' + item.id + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';
		item._action = '<a href="' + BASE_URL + '/sysLog/edit?id=' + item.id
				+ '" class="operating-edit" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" id="id_' + item.id + '" id="' + item.id
				+ '" title="删除"><i class="fa fa-trash-o"></i></a>';

	});
}