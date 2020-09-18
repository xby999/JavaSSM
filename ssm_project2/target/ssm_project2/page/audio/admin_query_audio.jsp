<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/24 0024
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>数据列表</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css?v=4.1.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/footable/footable.core.css" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox ">
                <div class="ibox-title">
                    <h5>音频标题</h5>
                </div>
                <div class="ibox-content">

                    <!--数据表顶部查询 开始
                        该区域可以将来存放 各种控件
                    -->

                    <!--数据表顶部查询 结束-->
                    <!--数据表开始-->
                    <div class="jqGrid_wrapper">
                        <table class="footable table table-stripped table-hover" data-page-size="8" data-filter=#filter>
                            <!--数据头 开始-->
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>上传用户</th>
                                <th>音频标题</th>
                                <th>上传时间</th>
                                <th>音频路径</th>
                                <th>查看</th>
                            </tr>
                            </thead>
                            <!--数据头 结束-->
                            <!--数据体 开始-->
                            <tbody>

                            <c:forEach items="${list}" var="audioinfo">
                                <tr class="gradeX">
                                    <td>${audioinfo.audio_id}</td>
                                    <td>${audioinfo.business_username}</td>
                                    <td>${audioinfo.audio_title}</td>
                                    <td>${audioinfo.audio_date}</td>
                                    <td>${audioinfo.audio_src}</td>
                                    <td class="center">
                                        <audio src="${pageContext.request.contextPath}${audioinfo.audio_src}"   controls >播放</audio>
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/AudioController/admindeleteAudio.action?audio_id=${audioinfo.audio_id}"><button type="button">删除</button></a>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                            <!--数据体 结束-->
                            <!--数据分页 开始-->
                            <tfoot>
                            <tr>
                                <td colspan="5">
                                    <ul class="pagination pull-right"></ul>
                                </td>
                            </tr>
                            </tfoot>
                            <!--数据分页 结束-->
                        </table>
                    </div>
                    <p>&nbsp;</p>
                    <!--数据表结束-->
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    /*当点击按钮的时候，将对应的src添加到模态框中的video元素中*/

</script>
<!-- Modal -->

<!-- 全局js -->
<script src="${pageContext.request.contextPath}/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${pageContext.request.contextPath}/js/plugins/footable/footable.all.min.js"></script>


<!--
    &lt;!&ndash; Peity &ndash;&gt;
    <script src="../js/plugins/peity/jquery.peity.min.js"></script>
    &lt;!&ndash; jqGrid &ndash;&gt;
    <script src="../js/plugins/jqgrid/i18n/grid.locale-cn.js?0820"></script>
    <script src="../js/plugins/jqgrid/jquery.jqGrid.min.js?0820"></script>
-->


<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/js/content.js?v=1.0.0"></script>
<script>
    $(document).ready(function() {
        $('.footable').footable();
        $('.footable2').footable();
    });

</script>
<script src="js/content.js?v=1.0.0"></script>
<script>
    $(document).ready(function() {
        $('.footable').footable();
        $('.footable2').footable();
    });

    var returnmsg="${msg}";
    if(returnmsg != ""){
        alert(returnmsg);
    }
</script>
</body>

</html>
