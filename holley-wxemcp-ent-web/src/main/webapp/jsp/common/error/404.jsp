<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" pageEncoding="UTF-8" %>
<%@ include file="../top.jsp" %>
<html lang="zh-CN">
<head>
  <%@include file="../css.jsp"%>
</head>
<body>
  <!--main-content-->
  <div id="mainContent" class="content">
  	<div class="error-page">
  		<h2 class="headline text-yellow"> 404</h2>
  		<div class="error-content">
          <h3><i class="fa fa-warning text-yellow"></i> 哎呀! 您可能迷路了.</h3>
          <p>系统暂时找不到您想要访问的界面.</p>
          <button type="button" onclick="frameHref('main/main.action')" class="btn btn-block btn-warning btn-sm" style="width: 260px;">返回首页</button>
        </div>
  	</div>
  </div>
  <%@include file="../js.jsp" %>
</body>
</html>

