<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" pageEncoding="UTF-8" %>
<%@ include file="../common/top.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>个人中心</title>
<%@include file="../common/css.jsp"%>
<%@include file="../common/js.jsp"%>
<script>
getStorage('account/initAccountPage.action');
</script>

</head>
<body ontouchstart>
	<div class="weui-cells weui-cells_form margin-10" style="margin-bottom:40px;">
		<div class="weui-cell">
			<div class="weui-cell__hd">
				<label class="weui-label">用户名</label>
			</div>
			<div class="weui-cell__bd">
			    <p class="weui-input userName"></p>
			</div>
		</div>
		<div class="weui-cell">
			<div class="weui-cell__hd">
				<label class="weui-label">公司名</label>
			</div>
			<div class="weui-cell__bd">
				<p class="weui-input companyName"></p>
			</div>
		</div>
		<div class="weui-cell">
			<div class="weui-cell__hd">
				<label class="weui-label">联系电话</label>
			</div>
			<div class="weui-cell__bd">
				<p class="weui-input telephone"></p>
			</div>
		</div>
		<div class="weui-cell msg-push hidden">
			<div class="weui-cell__hd">
				<label class="weui-label">开启告警推送</label>
			</div>
			<div class="weui-cell__bd" style="display: flex;justify-content: flex-end;">
				  <label for="switchCP" >
		            <input id="switchCP" class="weui-switch-cp__input hidden" type="checkbox" checked="checked"><!-- weui-switch-cp__input  -->
		            <div class="weui-switch-cp__box"></div>
          		 </label>
			</div>
		</div>
	</div>
	<div class="demos-content-padded btn-margin-40" style="padding:0;margin:15px;">
		<div class="weui-btn weui-btn_primary sign-up">注销</div>
	</div>

	<script src="<%=request.getContextPath()%>/res/account/home.js?v=${version}"></script>
	
</body>
</html>