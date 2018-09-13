<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" pageEncoding="UTF-8" %>
<%@ include file="../common/top.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>设备查询</title>
  <%@include file="../common/css.jsp"%>
   <%@include file="../common/js.jsp"%>
<script>
getStorage('device/initRtuStatusPage.action');
</script>
<style>
.rtu-list{
  padding-top:8px;
  padding-bottom:8px;
}
.rtu-list .rtu-list-item{
    display: flex;
    align-items: center;
    margin-bottom:5px;
    justify-content: space-between;
}
.rtu-list .rtu-list-after{
	display: flex;
    align-items: center;
    justify-content: space-between;
}
.part-slide-tri:after{
    right: 30%;
}
.weui-select-modal .weui-cell{
	text-align: center;
}
</style>
</head>
<body ontouchstart>
   <div class="weui-pull-to-refresh__layer">
           <div class="down">下拉刷新</div>
           <div class="up">释放刷新</div>
           <div class="refresh"><i class="weui-loading"></i>正在刷新</div>
   </div>
   <div class="weui-cell bg-init">
         <div class="part-slide-tri" style="width:100%;"><input class="weui-input weui-pop-div text-center" id="typeStatus" type="text" placeholder="终端状态"></div>
    </div>
    <div class="weui-cell bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left load-before">
           <div class="weui-cell__bd">
                  <div class="weui-panel weui-panel_access more-list-content">
	                  <a href="javascript:void(0);" class="weui-media-box weui-media-box_appmsg wui-cell-nopadding-top rtu-list" data-type="1" data-sum="0"> 
	                  		<div class="weui-media-box__bd">
	                  		     <div class="rtu-list-item">
	                  		     	<div class="weui-media-box__desc text-green remind-title">用户:李进 【预付费拉闸】 当前剩余金额【-1819.94元】&lt;= 拉闸金额【2.00元】</div>
	                  		     	<p class="text-green">ddddd</p>
	                  		     </div>
	                  		     
	                  		     <div class="text-light-gray rtu-list-after">
	                  		        <span class="">终端地址</span>
	                  		        <span class="">2018-07-26 13:50:25</span>
	                  		     </div>
	                  		</div>	
	                  </a>      
	                  <a href="javascript:void(0);" class="weui-media-box weui-media-box_appmsg wui-cell-nopadding-top rtu-list" data-type="1" data-sum="0"> 
	                  		<div class="weui-media-box__bd">
	                  		     <div class="rtu-list-item">
	                  		     	<div class="weui-media-box__desc text-green remind-title">用户:李进 【预付费拉闸】 当前剩余金额【-1819.94元】&lt;= 拉闸金额【2.00元】</div>
	                  		     	<p class="text-red">ddddd</p>
	                  		     </div>
	                  		     
	                  		     <div class="text-light-gray rtu-list-after">
	                  		        <span class="">终端地址</span>
	                  		        <span class="">2018-07-26 13:50:25</span>
	                  		     </div>
	                  		</div>	
	                  </a>      
                  </div>
            </div>
    </div>
<script src="<%=request.getContextPath()%>/res/device/rtuStatus.js?v=${version}"></script>
</body>
</html>