<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" pageEncoding="UTF-8" %>
<%@ include file="../common/top.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>事件提醒-企业</title>
  <%@include file="../common/css.jsp"%>
   <%@include file="../common/js.jsp"%>
<script>
getStorage('event/initParkEventPage.action');
</script>

</head>
<body ontouchstart>
   <div class="weui-pull-to-refresh__layer">
           <div class="down">下拉刷新</div>
           <div class="up">释放刷新</div>
           <div class="refresh"><i class="weui-loading"></i>正在刷新</div>
   </div>
   <div class="weui-cell padding-5">
         <div class="text-light-gray">
               <small class="white-nowrap font-15" style="margin-right:.5em;">昨日异常事件总计<em class="text-red yesterday-events"></em>件</small><small class="white-nowrap  font-15">今日目前<em class="text-primary today-events"></em>件</small>
          </div>
    </div>
    <div class="weui-cell bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left load-before">
           <div class="weui-cell__bd">
                  <div class="weui-panel weui-panel_access more-list-content">
                         
                  </div>
            </div>
    </div>

<script src="<%=request.getContextPath()%>/res/event/timeReminderCom.js?v=${version}"></script>
</body>
</html>