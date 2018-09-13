<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<html>
	<head>
		<base href="<%=basePath%>/">
		<script type="text/javascript">
        	window.location = 'frame/initLoginPage.action'
        </script> 
	</head>
	<body>
	</body>
</html>
