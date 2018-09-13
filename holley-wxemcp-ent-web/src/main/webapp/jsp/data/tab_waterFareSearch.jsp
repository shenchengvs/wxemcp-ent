<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" pageEncoding="UTF-8" %>
<%@ include file="../common/top.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>水费查询</title>
    <%@include file="../common/css.jsp"%>
     <%@include file="../common/js.jsp"%>
<script>
getStorage('data/initWaterFeePage.action');
</script>
</head>
<body ontouchstart>
<div class="pullContent">
       <div class="weui-pull-to-refresh__layer">
                      <div class="down">下拉刷新</div>
                      <div class="up">释放刷新</div>
                      <div class="refresh"><i class="weui-loading"></i>正在刷新</div>
                </div>


                <div class="weui-search-bar" id="searchBar">
                <form class="weui-search-bar__form" action="#">
                    <div class="weui-search-bar__box">
                        <i class="weui-icon-search"></i>
                        <input type="search" class="weui-search-bar__input" id="searchInput" placeholder="请输入户号/户名/手机号" required="" onkeydown='getkey(event,this.id)'>
                        <a href="javascript:" class="weui-icon-clear" id="searchClear"></a>
                    </div>
                    <label class="weui-search-bar__label" id="searchText" style="transform-origin: 0px 0px 0px; opacity: 1; transform: scale(1, 1);">
                        <i class="weui-icon-search"></i>
                        <span>请输入户号/户名/手机号</span>
                    </label>
                </form>
                <a href="javascript:" class="weui-search-bar__cancel-btn text-primary" id="searchCancel">取消</a>
            </div>
            <div class="weui-cell bg-init">
                <div class="weui-cell__hd width-100" >
                    <div class="weui-flex deep-light-gray">
                        <div class="weui-flex__item part-slide-tri"><input class="weui-input text-center" id="time2" type="text"></div>
                        <div class="weui-flex__item part-slide-tri"><input class="weui-input weui-pop-div text-center selectItem"  type="text" value=""></div>
                    </div>
                </div>
            </div>

            <div class="weui-cell bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left load-before">
                <div class="weui-cell__bd">
                    <div class="weui-panel weui-panel_access">
                        <div class="weui-form-preview more-list">
                            <div class="weui-form-preview__hd text-light-gray more-list-head text-left">
                                欠费用户共&nbsp;<span class="text-red record-num"></span>&nbsp;户
                            </div>
                            <div class="more-list-content">
                              <!--  <a href="javascript:void(0);" class="more-content-item">
                                    <div class="weui-form-preview__bd">
                                        <div class="weui-form-preview__item">
                                            <label class="weui-form-preview__label remind-title">陈无语</label>
                                            <span class="weui-form-preview__value">实际费用:<em class="text-red margin-l5 font-16">140.52</em></span>
                                        </div>
                                        <div class="weui-form-preview__item">
                                            <label class="weui-form-preview__label">结算时间:<em class="margin-l5">2018-11-14</em></label>
                                        </div>
                                        <div class="weui-form-preview__item">
                                            <label class="weui-form-preview__label">余额:<em class="text-green margin-l5">20.5</em></label>
                                            <span class="weui-form-preview__value">预计可用:<em class="text-primary margin-l5">30天</em></span>
                                        </div>
                                    </div>
                                </a> --> 
                             
                            </div>
                        </div>
                    </div>
                </div>
            </div>
           </div>

<div class="weui-tabbar">
		    <a href="data/initRealPowerPage.action" class="weui-tabbar__item">
		        <div class="weui-tabbar__icon">
		            <img src="res/images/real_ele_normal.png" alt="">
		        </div>
		        <p class="weui-tabbar__label">实时电量</p>
		    </a>
		    <a href="data/initRealWaterPage.action" class="weui-tabbar__item">
		        <div class="weui-tabbar__icon">
		            <img src="res/images/water_normal.png" alt="">
		        </div>
		        <p class="weui-tabbar__label">实时水量</p>
		    </a>
		    <a href="data/initPowerFeePage.action" class="weui-tabbar__item">
		        <div class="weui-tabbar__icon">
		            <img src="res/images/ele_fare_normal.png" alt="">
		        </div>
		        <p class="weui-tabbar__label">电费查询</p>
		    </a>
		    <a href="data/initWaterFeePage.action" class="weui-tabbar__item weui-bar__item--on">
		        <div class="weui-tabbar__icon">
		            <img src="res/images/water_pay_active.png" alt="">
		        </div>
		        <p class="weui-tabbar__label">水费查询</p>
		    </a>
	</div>

<script src="<%=request.getContextPath()%>/res/data/tab_waterFareSearch.js?v=${version}"></script>


</body>
</html>