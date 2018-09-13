<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" pageEncoding="UTF-8" %>
<%@ include file="../common/top.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>事件统计</title>
    <%@include file="../common/css.jsp"%>
    <%@include file="../common/js.jsp"%>
<script>
getStorage('stat/initEventDetailsPage.action');
</script>
    <style>
     
        .chart-title{
            font-weight: 400;
        }
        .init-item-title{
            font-size: 1.1rem;
            white-space: nowrap;
           /* line-height:2.5em;*/
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
<div  class="more-chart">
              <div class="chart-part margin-10">
                <h4 class="text-center bg-init padding-5 chart-title text-init font-r1">拉闸次数</h4>
                <div class="bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left">
                    <div id="chart1" class="chaet-css">
                    </div>
                    <div class="deep-light-gray padding-5 init-item">
                        <div class="text-init font-18 init-item-title">当<span class="day-type"></span>拉闸<span class="text-primary init-money"></span>次</div>
                        <div class="weui-flex">
                        <div class="weui-flex__item init-item-sub"><p>同上<span class="day-type"></span>增长<span class="text-red init-upval1"></span>%</p></div>
                         <div class="weui-flex__item init-item-sub text-right"><p>同<span class="day-compare"></span>增长<span class="text-red init-upval2"></span>%</p></div>
                       </div>
                    </div>
                </div>
              </div>
			 <div class="chart-part margin-10">
                <h4 class="text-center bg-init padding-5 chart-title text-init font-r1">充值次数</h4>
                <div class="bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left">

                    <div id="chart2" class="chaet-css">
                    </div>
                    <div class="deep-light-gray padding-5 init-item">
                        <div class="text-init font-18 init-item-title">当<span class="day-type"></span>充值<span class="text-primary init-money"></span>次</div>
                       <div class="weui-flex">
                        <div class="weui-flex__item init-item-sub"><p>同上<span class="day-type"></span>增长<span class="text-red init-upval1"></span>%</p></div>
                        <div class="weui-flex__item init-item-sub text-right"><p>同<span class="day-compare"></span>增长<span class="text-red init-upval2"></span>%</p></div>
                       </div>
                     </div>
                </div>
              </div>
              
               <div class="chart-part margin-10 tabBottomBody">
                <h4 class="text-center bg-init padding-5 chart-title text-init font-r1">催费次数</h4>
                <div class="bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left">

                    <div id="chart3" class="chaet-css">
                    </div>
                    <div class="deep-light-gray padding-5 init-item">
                        <div class="text-init font-18 init-item-title">当<span class="day-type"></span>催费<span class="text-primary init-money"></span>次</div>
                       <div class="weui-flex">
                        <div class="weui-flex__item init-item-sub"><p>同上<span class="day-type"></span>增长<span class="text-red init-upval1"></span>%</p></div>
                        <div class="weui-flex__item init-item-sub text-right"><p>同<span class="day-compare"></span>增长<span class="text-red init-upval2"></span>%</p></div>
                       </div>
                    </div>
                </div>
              </div>
			
</div>

<script src="<%=request.getContextPath()%>/res/lib/echarts.js"></script>
<script src="<%=request.getContextPath()%>/res/stat/eventDetails.js?v=${version}"></script>

</body>
</html>