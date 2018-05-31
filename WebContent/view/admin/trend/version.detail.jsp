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
                    <header class="panel-heading">版本管理详情</header>
                    <table class="table table-striped2 m-b-none text-sm">
                        <tbody>

                        <tr>
                            <td class="col-sm-2">平台：</td>
                            <td class="col-sm-4">${version.platform}</td>
                        </tr>
                        <tr>
                            <td class="col-sm-2">版本号：</td>
                            <td class="col-sm-4">${version.VName}</td>
                        </tr>
                        <tr>
                            <td class="col-sm-2">下载地址：</td>
                            <td class="col-sm-4">${version.filepath}</td>
                        </tr>
                        <tr>
                            <td class="col-sm-2">版本详情：</td>
                            <td class="col-sm-4">${version.content}</td>

                        </tr>
                        <tr>
                            <td class="col-sm-2">创建时间：</td>
                            <td class="col-sm-4">
                               ${version.ctime}
                            </td>
                        </tr>
                        <tr>
                            <td class="col-sm-2">最后一次更新时间：</td>
                            <td class="col-sm-4">
                               ${version.mtime}
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
<script src="${STATIC_URL}/admin/trend/version.detail.js" type="text/javascript"></script>
