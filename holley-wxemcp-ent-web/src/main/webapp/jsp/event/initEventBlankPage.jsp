<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" pageEncoding="UTF-8" %>
<%@ include file="../common/top.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>事件提醒-费控</title>
    <%@include file="../common/css.jsp"%>
    <%@include file="../common/js.jsp"%>

</head>
<body ontouchstart>

<div class="pullContent infinite-div">
    
    <div class="weui-tab">

        <div class="weui-navbar weui-navbg">
            <a class="weui-navbar__item weui-bar__item--on tab-item-1" href="#tab1" role='1'>
                拉闸记录
            </a>
            <a class="weui-navbar__item tab-item-2" href="#tab2" role='2'>
                充值记录
            </a>
            <a class="weui-navbar__item tab-item-3" href="#tab3" role='3'>
                短信记录
            </a>
        </div>
        <div class="weui-tab__bd">
            <div id="tab1" class="weui-tab__bd-item weui-tab__bd-item--active">
               <div class="weui-pull-to-refresh__layer">
                    <div class="refresh"><i class="weui-loading"></i>正在刷新</div>
                </div>
                <div class="weui-cell bg-init ">
                    <div class="weui-cell__hd width-100" >
                            <div class="weui-flex deep-light-gray">
                                <div class="weui-flex__item"><small class="text-light-gray font-15" style="margin-right: 10%;">共有<em class="text-primary show-record">18</em>条记录</small></div>
                                <div class="weui-flex__item part-slide-tri"><input class="weui-input weui-pop-div" id="typeBrake" type="text"></div>
                                <div class="weui-flex__item part-slide-tri"><input class="weui-input mui-date text-left" id="exterMonth1"></div>
                            </div>
                    </div>
                </div>
                <div class="weui-cell bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left">
                    <div class="weui-cell__bd">
                        <div class="weui-panel weui-panel_access">
                            <div class="weui-panel__bd more-list-content more-list-content-1">
                               
                                <a href="javascript:void(0);" class="weui-media-box weui-media-box_appmsg wui-cell-nopadding-top">

                                    <div class="weui-media-box__bd">
                                        <h4 class="weui-media-box__title">
                                            刘亦
                                        </h4>
                                        <p class="weui-media-box__desc">2018-11-9</p>
                                    </div>
                                    <div class="weui-media-box__hd">
                                        <span class="weui-media-box__title-after text-red font-16 white-nowrap clear-right">手动拉闸</span>
                                    </div>
                                </a>
                            </div>
                        </div>


                    </div>
                </div>
            </div>
            <div id="tab2" class="weui-tab__bd-item">
                <div class="weui-pull-to-refresh__layer">
                    <div class="refresh"><i class="weui-loading"></i>正在刷新</div>
                </div>
                <div class="weui-cell bg-init">
                    <div class="weui-cell__hd width-100" >
                            <div class="weui-flex deep-light-gray">
                                <div class="weui-flex__item"><small class="text-light-gray font-15" style="margin-right: 10%;">共有<em class="text-primary show-record"></em>条记录</small></div>
                                <div class="weui-flex__item part-slide-tri"><input class="weui-input weui-pop-div" id="recharge" type="text"></div>
                                <div class="weui-flex__item part-slide-tri"><input class="weui-input mui-date text-left" id="exterMonth2"></div>
                            </div>
                    </div>
                </div>
                <div class="weui-cell bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left">
                    <div class="weui-cell__bd">
                        <div class="weui-panel weui-panel_access">
                            <div class="weui-panel__bd more-list-content more-list-content-2">
           
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="tab3" class="weui-tab__bd-item">
                <div class="weui-pull-to-refresh__layer">
                    <div class="refresh"><i class="weui-loading"></i>正在刷新</div>
                </div>
                <div class="weui-cell bg-init ">
                    <div class="weui-cell__hd width-100" >
                            <div class="weui-flex deep-light-gray">
                                <div class="weui-flex__item"><small class="text-light-gray font-15" style="margin-right: 10%;">共有<em class="text-primary show-record"></em>条记录</small></div>
                                <div class="weui-flex__item part-slide-tri"><input class="weui-input weui-pop-div" id="sendType" type="text" value=""></div>
                                <div class="weui-flex__item part-slide-tri"><input class="weui-input mui-date text-left" id="exterMonth3"></div>
                            </div>
                    </div>
                </div>
                <div class="weui-cell bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left">

                    <div class="weui-cell__bd">
                        <div class="weui-panel weui-panel_access">
                            <div class="weui-panel__bd more-list-content more-list-content-3">
                              
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<script src="<%=request.getContextPath()%>/res/event/initEventBlankPage.js?v=${version}"></script>
</body>
</html>