<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/25 0025
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>添加数据模板页面</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-sm-4">
        <h2>音频查询</h2>
        <h3>${msg}</h3>
        <ol class="breadcrumb">
            <li>
                <a href="index.html">管理员</a>
            </li>
            <li>
                <strong>查询音频信息</strong>
            </li>
        </ol>
    </div>
    <div class="col-sm-8">
        <div class="title-action">
            <a href="add_date_model.html" class="btn btn-primary">活动区域</a>
        </div>
    </div>
</div>

<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <form method="post" class="form-horizontal" action="${pageContext.request.contextPath}/AudioController/getselectaudio">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">上传用户名</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="business_username" id="business_username">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">起始时间</label>

                            <div class="col-sm-10">
                                <input type="datetime-local" step="01" class="form-control" name="audio_start_date" id="audio_start_date">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">结束时间</label>

                            <div class="col-sm-10">
                                <input type="datetime-local" step="01" class="form-control" name="audio_end_date" id="audio_end_date">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="col-sm-4 col-sm-offset-2">
                            <button class="btn btn-primary" type="submit" >查询</button>
                            <button class="btn btn-white" type="reset">取消</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="${pageContext.request.contextPath}/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.3.6"></script>
<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/js/content.js?v=1.0.0"></script>
<script>

</script>



</body>

</html>

