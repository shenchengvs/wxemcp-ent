<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" pageEncoding="UTF-8" %>
<%@ include file="../common/top.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>实时水量</title>

    <%@include file="../common/css.jsp"%>
    <%@include file="../common/js.jsp"%>
<script>
getStorage('data/initRealWaterPage.action');
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
                        <input type="search" class="weui-search-bar__input" id="searchInput" placeholder="计量点/所属单位" required="" onkeydown='getkey(event,this.id)'>
                        <a href="javascript:" class="weui-icon-clear" id="searchClear"></a>
                    </div>
                    <label class="weui-search-bar__label" id="searchText" style="transform-origin: 0px 0px 0px; opacity: 1; transform: scale(1, 1);">
                        <i class="weui-icon-search"></i>
                        <span>计量点/所属单位</span>
                    </label>
                </form>
                <a href="javascript:" class="weui-search-bar__cancel-btn text-primary" id="searchCancel">取消</a>
            </div>
            <div class="weui-cell bg-init">
                <div class="weui-cell__hd width-100" >
                    <div class="weui-flex deep-light-gray degree-level">
                     <div class="weui-flex__item part-slide-tri"><input class="weui-input weui-pop-div text-center" id="organization" type="text" value="" placeholder="用能单位"></div>
                        <div class="weui-flex__item part-slide-tri"><input class="weui-input weui-pop-div text-center subPicker hidden" id="" type="text" value="" placeholder="用能单位">
                        <p class="picker-message text-center">- -</p></div>
                     </div>
                </div>
            </div>

            <div class="weui-cell bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left load-before">
                <div class="weui-cell__bd">
                    <div class="weui-panel weui-panel_access">
                        <div class="weui-form-preview more-list">
                          <!--   <div class="weui-form-preview__hd text-primary more-list-head text-left preview-border-left">
                               华立科技股份有限公司
                            </div> -->
                            <div class="more-list-content">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
      
</div>



<div class="weui-tabbar weui-tabbar-1 hidden">
    <a href="data/initRealPowerPage.action" class="weui-tabbar__item">
        <div class="weui-tabbar__icon">
            <img src="res/images/real_ele_normal.png" alt="">
        </div>
        <p class="weui-tabbar__label">实时电量</p>
    </a>
    <a href="data/initRealWaterPage.action" class="weui-tabbar__item weui-bar__item--on">
        <div class="weui-tabbar__icon">
            <img src="res/images/water_active.png" alt="">
        </div>
        <p class="weui-tabbar__label">实时水量</p>
    </a>
    <a href="data/initPowerFeePage.action" class="weui-tabbar__item">
        <div class="weui-tabbar__icon">
            <img src="res/images/ele_fare_normal.png" alt="">
        </div>
        <p class="weui-tabbar__label">电费查询</p>
    </a>
    <a href="data/initWaterFeePage.action" class="weui-tabbar__item">
        <div class="weui-tabbar__icon">
            <img src="res/images/water_pay_normal.png" alt="">
        </div>
        <p class="weui-tabbar__label">水费查询</p>
    </a>
</div>

<div class="weui-tabbar weui-tabbar-2 hidden">
    <a href="data/initRealPowerPage.action" class="weui-tabbar__item">
        <div class="weui-tabbar__icon">
            <img src="res/images/real_ele_normal.png" alt="">
        </div>
        <p class="weui-tabbar__label">实时电量</p>
    </a>
    <a href="data/initRealWaterPage.action" class="weui-tabbar__item weui-bar__item--on">
        <div class="weui-tabbar__icon">
            <img src="res/images/water_active.png" alt="">
        </div>
        <p class="weui-tabbar__label">实时水量</p>
    </a>
    <a href="data/initPowePage.action" class="weui-tabbar__item">
        <div class="weui-tabbar__icon">
            <img src="res/images/ele_fare_normal.png" alt="">
        </div>
        <p class="weui-tabbar__label">电量查询</p>
    </a>
    <a href="data/initWaterPage.action" class="weui-tabbar__item">
        <div class="weui-tabbar__icon">
            <img src="res/images/water_pay_normal.png" alt="">
        </div>
        <p class="weui-tabbar__label">水量查询</p>
    </a>
</div>


<script>
      var storage= window.localStorage;
      var type=parseInt(storage.getItem('entType'));
      $('.weui-tabbar').addClass('hidden');
   
      if(type===1){
    	  $('.weui-tabbar-2').removeClass('hidden');//企业
      }else{
    	  $('.weui-tabbar-1').removeClass('hidden');//费控
      }
</script>
<script src="<%=request.getContextPath()%>/res/data/tab_water.js?v=${version}"></script>

</body>
</html>