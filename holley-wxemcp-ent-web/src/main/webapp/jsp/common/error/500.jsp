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
        <h2 class="headline text-red">500</h2>
        <div class="error-content">
          <h3><i class="fa fa-warning text-red"></i>哎呀! 系统发生了一些异常.</h3>
          <p>我们正在抢修!请稍候再访问.</p>
	      <button  type="button" onclick="frameHref('main/main.action')" class="btn btn-danger btn-sm" style="width: 320px;">返回首页</button>
        </div>
      </div>
  </div>
  <%@include file="../js.jsp" %>
</body>
</html>

