<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" pageEncoding="UTF-8" %>
<%@ include file="../common/top.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <%@include file="../common/css.jsp"%>
    <meta charset="UTF-8">
    <title>登录界面</title>
    <%@include file="../common/js.jsp"%>
</head>
<body ontouchstart>
<div class="weui-cells weui-cells_form margin-10 font-16">
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">账号</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input userName" type="text" placeholder="请输入账号" >
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd">
            <label class="weui-label">密码</label>
        </div>
        <div class="weui-cell__bd">
            <input class="weui-input userPwd" type="password" placeholder="请输入密码">
        </div>
    </div>
</div>
<div class="padding-15 text-red text-show" style="height: 30px;">
</div>

<div class="demos-content-padded btn-margin-20">
    <a href="javascript:void(0);" class="weui-btn weui-btn_primary">登录</a>
    <a href="frame/initExperiencePage.action" class="weui-btn weui-btn_default">无账号体验</a>
</div>

<script src="<%=request.getContextPath()%>/res/frame/login.js?v=${version}"></script>
</body>
</html>