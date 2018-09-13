<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" pageEncoding="UTF-8" %>
<%@ include file="../common/top.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>部门用能</title>
    <%@include file="../common/css.jsp"%>
    <%@include file="../common/js.jsp"%>
<script>
getStorage('stat/initDepartmentUserDetailsPage.action');
</script>
    <style>
     
        .chart-title{
            font-weight: 400;
        }
        .init-item-title{
            font-size: 1.1rem;
            white-space: nowrap;
            line-height:2.5em;
        }
        .init-item-sub{
            font-size: .9rem;
        }
        .init-item{
          padding-left: 8px;padding-right:8px;
        }
     
        .weui-pull-to-refresh__layer{
           position：relative;
           z-index:0;
        }
       
    </style>
</head>
<body ontouchstart>
 <div class="weui-pull-to-refresh__layer">
                      <div class="down">下拉刷新</div>
                      <div class="up">释放刷新</div>
                      <div class="refresh"><i class="weui-loading"></i>正在刷新</div>
                </div>
<div class="more-chart">
  

</div>


<script src="<%=request.getContextPath()%>/res/lib/echarts.js"></script>
<script src="<%=request.getContextPath()%>/res/stat/departmentUserDetails.js?v=${version}"></script>
</body>
</html>