<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" pageEncoding="UTF-8" %>
<%@ include file="../common/top.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>水量查询</title>
    <%@include file="../common/css.jsp"%>
    <%@include file="../common/js.jsp"%>
<script>
getStorage('data/initWaterPage.action');
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
                        <input type="search" class="weui-search-bar__input" id="searchInput" placeholder="用能单位/计量点名称" required="" onkeydown='getkey(event,this.id)'>
                        <a href="javascript:" class="weui-icon-clear" id="searchClear"></a>
                    </div>
                    <label class="weui-search-bar__label" id="searchText" style="transform-origin: 0px 0px 0px; opacity: 1; transform: scale(1, 1);">
                        <i class="weui-icon-search"></i>
                        <span>用能单位/计量点名称</span>
                    </label>
                </form>
                 <a href="javascript:" class="weui-search-bar__cancel-btn text-primary" id="searchCancel">取消</a>
            </div>
            <div class="weui-cell bg-init">
                <div class="weui-cell__hd width-100" >
                    <div class="weui-flex deep-light-gray">
                        <div class="weui-flex__item part-slide-tri"><input class="weui-input weui-pop-div text-center" id="organization" type="text" value="" placeholder="用能单位"></div>
                        <div class="weui-flex__item part-slide-tri"><input class="weui-input weui-pop-div text-center subPicker hidden" id="" type="text" value="" placeholder="用能单位">
                        <p class="picker-message text-center">- -</p></div>
                        <div class="weui-flex__item part-slide-tri"><input class="weui-input text-center time-to-picker" id="time2" type="text"><input class="weui-input text-center time-to-picker" id="time3" type="text"></div>
                    </div>
                </div>
            </div>
            <label for="weuiAgree" class="weui-agree">
                <input id="weuiAgree" type="checkbox" class="weui-agree__checkbox">
                <span class="weui-agree__text">
                  是否按日筛选
                </span>
            </label>

            <div class="weui-cell bg-init wui-cell-noborder">
                <div class="weui-cell__bd width-100" >
                    <div class="weui-flex deep-light-gray">
                        <div class="weui-flex__item text-green">终端个数:<span class="weui-badge margin-l5 weui-badge-green rtuCount"></span></div>
                        <div class="weui-flex__item text-orange">计量点个数:<span class="weui-badge margin-l5 weui-badge-orange pointCount"></span></div>
                    </div>
                    <div class="weui-flex deep-light-gray">
                        <div class="weui-flex__item">在线个数:<span class="weui-badge margin-l5 weui-badge-gray onlineRtuCount"></span></div>
                        <div class="weui-flex__item text-primary">未实时上报个数:<span class="weui-badge margin-l5 weui-badge-primary unRealCount"></span></div>
                    </div>
                </div>

            </div>

            <div class="padding-15 bg-init padding-b15">
                <table class="table width-100 load-before" border="1">
                    <thead>
                    <tr>
                        <th>计量点</th>
                        <th>起码</th>
                        <th>止码</th>
                        <th>倍率</th>
                        <th>水量m<sup>3</sup></th>
                    </tr>
                    </thead>
                    <tbody class="font-14 more-list-content">
                    </tbody>
                </table>
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
    <a href="data/initPowePage.action" class="weui-tabbar__item">
        <div class="weui-tabbar__icon">
            <img src="res/images/ele_fare_normal.png" alt="">
        </div>
        <p class="weui-tabbar__label">电量查询</p>
    </a>
    <a href="data/initWaterPage.action" class="weui-tabbar__item weui-bar__item--on">
        <div class="weui-tabbar__icon">
            <img src="res/images/water_pay_active.png" alt="">
        </div>
        <p class="weui-tabbar__label">水量查询</p>
    </a>
</div>



<script src="<%=request.getContextPath()%>/res/data/tab_waterQtySearch.js?v=${version}"></script>


</body>
</html>