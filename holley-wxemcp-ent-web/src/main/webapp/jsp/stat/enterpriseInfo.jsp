<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" pageEncoding="UTF-8" %>
<%@ include file="../common/top.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>数据简报</title>
    <%@include file="../common/css.jsp"%>
    <%@include file="../common/js.jsp"%>
<script>
getStorage('stat/initStatPage.action');
</script>
    <style>
        .navbar-circle{
          padding:7px 15px;
          box-sizing:border-box;
          display:flex;
          align-items: center;
          justify-content: space-between;
           z-index:100;
           position: relative;
           border-bottom:1px solid #dcdcdc;
        }
        .navbar-circle .weui-navbar{
          position: relative;
        }
        .navbar-circle .mui-date{
            font-size:15px;
            padding:.4em .4em;
            border-radius: 4px;
            text-align: center;
            border: #e5e5e5 solid 1px;
           
        }
        .navbar-circle .weui-navbg{
            border: #01ade1 solid 1px;
            border-radius: 4px;
        }
        .navbar-circle .weui-navbar__item{
          padding: 5px 4px;
            color: #01ade1;
            background: none;
            font-size: 14px;
        }
        .navbar-circle .weui-bar__item--on {
            background: #01ade1;
            border: none;
            color: #fff;
        }
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
        .navbar-circle > div{
        	flex:0 1 45%;
        }
        .navbar-circle > div:first-of-type{
        	flex:0 1 30%;
        }
       
    </style>
</head>
<body ontouchstart>
<div  class="pullContent">
  
    <div class="weui-tab">
      <div class="weui-cell bg-init navbar-circle" style="position:fixed;width:100%;">
           <div style=""><input class="weui-input mui-date text-center time-to-picker text-left hidden" id="time2" type="text"><input class="weui-input mui-date text-center time-to-picker text-left" id="time3" type="text"></div>
           <div class="weui-navbar weui-navbg">
               <a class="weui-navbar__item weui-bar__item--on" href="#tab1" role=1>
                   日报
               </a>
               <a class="weui-navbar__item" href="#tab2" role=2>
                   月报
               </a>
           </div>
        </div>
        <div class="weui-tab__bd">
        
            <div id="tab1" class="tabBottomBody weui-tab__bd-item weui-tab__bd-item--active width-100">
                <div class="weui-pull-to-refresh__layer">
                      <div class="down">下拉刷新</div>
                      <div class="up">释放刷新</div>
                      <div class="refresh"><i class="weui-loading"></i>正在刷新</div>
                </div>
               <div class="weui-cell padding-5 padding-15 init-item-sub nav-description hidden">
                 <div class="weui-cell__hd width-100 font-init" >
                    <div class="weui-form-preview__item">
                        <label class="weui-form-preview__label">截止当前欠费用户共&nbsp;<span class="text-red arrearage-user1"></span>&nbsp;户
                        </label>
                        <span class="weui-form-preview__value deep-light-gray text-right">欠费金额&nbsp;<em class="text-red own-money1"></em>&nbsp;元</span>
                    </div>
                    <div class="weui-form-preview__item">
                        <label class="weui-form-preview__label">账户总余额(正)&nbsp;<span class="text-primary total-money1"></span>&nbsp;元
                        </label>
                    </div>
                 </div>
               </div>
              <div class="chart-part hidden">
                <h4 class="text-center bg-init padding-5 chart-title text-init font-r1">充值记录</h4>
                <div class="bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left">

                    <div id="chart1" class="chaet-css">
                    </div>
                    <div class="deep-light-gray padding-5 init-item">
                        <div class="text-init font-18 init-item-title">当日充值<span class="text-primary init-money"></span>元</div>
                        <div class="weui-flex">
                          <div class="weui-flex__item init-item-sub"><p>同上日增长<span class="text-red init-upval1"></span>%</p></div>
                          <div class="weui-flex__item init-item-sub text-right"><p>同上周本日增长<span class="text-red init-upval2"></span>%</p></div>
                        </div>
                    </div>
                </div>
              </div>
			<div class="chart-part hidden">
                <h4 class="text-center bg-init padding-5 chart-title margin-10 text-init font-r1">事件统计</h4>
                <div class="bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left">
                    <div id="chart2" class="chaet-css">
                    </div>
                    <div class="weui-flex deep-light-gray padding-5 init-item padding-15 screen-more">
                        <a href="stat/initEventDetailsPage.action" class="weui-flex__item text-primary more-detail">查看更多&nbsp;>></a>
                    </div>
                </div>
            </div>
            <div  class="chart-part">
                <h4 class="text-center bg-init padding-5 chart-title margin-10 text-init font-r1">电力能耗</h4>
                <div class="bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left">

                    <div id="chart3" class="chaet-css">
                    </div>
                    <div class="deep-light-gray padding-5 init-item">
                        <div class="text-init font-18 init-item-title">当日消耗<span class="text-primary init-money"></span>kWh</div>
                         <div class="weui-flex">
                             <div class="weui-flex__item init-item-sub"><p>同上日增长<span class="text-red init-upval1"></span>%</p></div>
                             <div class="weui-flex__item init-item-sub text-right"><p>同上周本日增长<span class="text-red init-upval2"></span>%</p></div>
                        </div>
                    </div>
                </div>
              </div>
			<div class="chart-part">
                <h4 class="text-center bg-init padding-5 chart-title margin-10 text-init font-r1">电能用途</h4>
                <div class="bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left">

                    <div id="chart4" class="chaet-css">
                    </div>
                    <div class="weui-flex deep-light-gray padding-5 init-item padding-15 screen-more">
                        <a href="stat/initEnergyUseDetailsPage.action" class="weui-flex__item text-primary more-detail">查看更多&nbsp;>></a>

                    </div>
                </div>
              </div>
              <div class="chart-part">
                <h4 class="text-center bg-init padding-5 chart-title margin-10 text-init font-r1">部门用电</h4>
                <div class="bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left">

                    <div id="chart5" class="chaet-css">
                    </div>
                    <div class="weui-flex deep-light-gray padding-5 init-item padding-15 screen-more">
                        <a href="stat/initDepartmentUserDetailsPage.action" class="weui-flex__item text-primary more-detail">查看更多&nbsp;>></a>
                    </div>
                </div>
               </div>
            </div>
             <div id="tab2" class="tabBottomBody weui-tab__bd-item width-100">
                <div class="weui-pull-to-refresh__layer">
                      <div class="down">下拉刷新</div>
                      <div class="up">释放刷新</div>
                      <div class="refresh"><i class="weui-loading"></i>正在刷新</div>
                </div>
               <div class="weui-cell padding-5 padding-15 init-item-sub nav-description hidden">
                 <div class="weui-cell__hd width-100 font-init" >
                    <div class="weui-form-preview__item">
                        <label class="weui-form-preview__label">截止当前欠费用户共&nbsp;<span class="text-red arrearage-user1"></span>&nbsp;户
                        </label>
                        <span class="weui-form-preview__value deep-light-gray text-right">欠费金额&nbsp;<em class="text-red own-money1"></em>&nbsp;元</span>
                    </div>
                    <div class="weui-form-preview__item">
                        <label class="weui-form-preview__label">账户总余额(正)&nbsp;<span class="text-primary total-money1"></span>&nbsp;元
                        </label>
                    </div>
                 </div>
               </div>
              <div class="chart-part hidden">
                <h4 class="text-center bg-init padding-5 chart-title text-init font-r1">充值记录</h4>
                <div class="bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left">

                    <div id="chart1-1" class="chaet-css">
                    </div>
                    <div class="deep-light-gray padding-5 init-item">
                        <div class="text-init font-18 init-item-title">当月充值<span class="text-primary init-money"></span>元</div>
                         <div class="weui-flex">
                          <div class="weui-flex__item init-item-sub"><p>同上月增长<span class="text-red init-upval1"></span>%</p></div>
                          <div class="weui-flex__item init-item-sub text-right"><p>同去年本月增长<span class="text-red init-upval2"></span>%</p></div>
                        </div>
                    </div>
                </div>
              </div>
			 <div class="chart-part hidden">
                <h4 class="text-center bg-init padding-5 chart-title margin-10 text-init font-r1">事件统计</h4>
                <div class="bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left">
                    <div id="chart2-1" class="chaet-css">
                    </div>
                    <div class="weui-flex deep-light-gray padding-5 init-item padding-15 screen-more">
                        <a href="stat/initEventDetailsPage.action" class="weui-flex__item text-primary more-detail">查看更多&nbsp;>></a>
                    </div>
                </div>
              </div>
              <div class="chart-part">
                <h4 class="text-center bg-init padding-5 chart-title margin-10 text-init font-r1">电力能耗</h4>
                <div class="bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left">

                    <div id="chart3-1" class="chaet-css">
                    </div>
                    <div class="deep-light-gray padding-5 init-item">
                        <div class="text-init font-18 init-item-title">当月消耗<span class="text-primary init-money"></span>kWh</div>
                        <div class="weui-flex">
                           <div class="weui-flex__item init-item-sub"><p>同上月增长<span class="text-red init-upval1"></span>%</p></div>
                           <div class="weui-flex__item init-item-sub text-right"><p>同去年本月增长<span class="text-red init-upval2"></span>%</p></div>
                        </div>
                    </div>
                </div>
              </div>
			  <div class="chart-part">
                <h4 class="text-center bg-init padding-5 chart-title margin-10 text-init font-r1">电能用途</h4>
                <div class="bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left">
                    <div id="chart4-1" class="chaet-css">
                    </div>
                    <div class="weui-flex deep-light-gray padding-5 init-item padding-15 screen-more">
                        <a href="stat/initEnergyUseDetailsPage.action" class="weui-flex__item text-primary more-detail">查看更多&nbsp;>></a>
                    </div>
                </div>
               </div>
                <div class="chart-part">
                <h4 class="text-center bg-init padding-5 chart-title margin-10 text-init font-r1">部门用电</h4>
                <div class="bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left">
                    <div id="chart5-1" class="chaet-css">
                    </div>
                    <div class="weui-flex deep-light-gray padding-5 init-item padding-15 screen-more">
                        <a href="stat/initDepartmentUserDetailsPage.action" class="weui-flex__item text-primary more-detail">查看更多&nbsp;>></a>
                    </div>
                </div>
                </div>
               
            </div>
           
        </div>
    </div>


</div>



<script src="<%=request.getContextPath()%>/res/lib/echarts.js"></script>
<script src="<%=request.getContextPath()%>/res/stat/enterpriseInfo.js?v=${version}"></script>

</body>
</html>