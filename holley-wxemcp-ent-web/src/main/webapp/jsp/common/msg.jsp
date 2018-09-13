<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"
	language="java" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
<%@include file="css.jsp"%>
</head>
<body>
	<div class="bg" style="height: 75%;">
		<!--main-content-->
		<div class="container main-body" style="height: 50%;">
			<p class="text-center" style="padding-top: 14%;">
				<strong>提示信息：</strong>${msg}
				<!-- <s:if test="#request.type == 'close'">
					<a onclick="window.close();" href="javascript::">关闭</a>
				</s:if>
				<s:else>
					<a onclick="history.go(-1)" href="javascript::">返回</a>
				</s:else> -->
			</p>
		</div>
	</div>
	<%@include file="js.jsp"%>
</body>
<script type="text/javascript">
</script>
</html>