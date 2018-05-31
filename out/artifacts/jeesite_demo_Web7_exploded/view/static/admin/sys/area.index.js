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
			url : BASE_URL + '/sysArea/delete',
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
					label : '编号',
					sortable : false
				},
				{
					property : 'parentId',
					label : '父级编号',
					sortable : false
				},
				{
					property : 'parentIds',
					label : '所有父级编号',
					sortable : false
				},
				{
					property : 'name',
					label : '名称',
					sortable : false
				},
				{
					property : 'sort',
					label : '排序',
					sortable : false
				},
				{
					property : 'code',
					label : '区域编码',
					sortable : false
				},
				{
					property : 'type',
					label : '区域类型',
					sortable : false
				},
				{
					property : 'createBy',
					label : '创建者',
					sortable : false
				},
				{
					property : 'createDate',
					label : '创建时间',
					sortable : false
				},
				{
					property : 'updateBy',
					label : '更新者',
					sortable : false
				},
				{
					property : 'updateDate',
					label : '更新时间',
					sortable : false
				},
				{
					property : 'remarks',
					label : '备注信息',
					sortable : false
				},
				{
					property : 'delFlag',
					label : '删除标记',
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
		item._query = '<a href="'+BASE_URL+'/sysArea/detail?id=' + item.id + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';
		item._action = '<a href="' + BASE_URL + '/sysArea/edit?id=' + item.id
				+ '" class="operating-edit" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" id="id_' + item.id + '" id="' + item.id
				+ '" title="删除"><i class="fa fa-trash-o"></i></a>';

	});
}