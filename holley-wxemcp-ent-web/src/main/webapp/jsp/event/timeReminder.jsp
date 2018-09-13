<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" pageEncoding="UTF-8" %>
<%@ include file="../common/top.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>事件提醒-费控</title>
    <%@include file="../common/css.jsp"%>
    <%@include file="../common/js.jsp"%>
<script>
getStorage('event/initPrepayEventPage.action');
</script>
     <script>
     //initParkEventPage 企业
     //initPrepayEventPage 费控
      var storage= window.localStorage;
      var type=parseInt(storage.getItem('entType'));
      console.log(storage)
      if(type===1){
    	  window.location.href='event/initParkEventPage.action';
      }
    </script>
</head>
<body ontouchstart>

<div class="pullContent">
    
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
              <!--  <div class="weui-pull-to-refresh__layer">
                    <div class="down">下拉刷新</div>
                    <div class="refresh"><i class="weui-loading"></i>正在刷新</div>
                </div> -->
                 <div class="weui-pull-to-refresh__layer">
                      <div class="down">下拉刷新</div>
                      <div class="up">释放刷新</div>
                      <div class="refresh"><i class="weui-loading"></i>正在刷新</div>
                </div>
                <div class="weui-cell bg-init ">
                    <div class="weui-cell__hd width-100" >
                            <div class="weui-flex deep-light-gray">
                                <div class="weui-flex__item"><small class="text-light-gray font-15" style="margin-right: 10%;">共有<em class="text-primary show-record">18</em>条记录</small></div>
                                <div class="weui-flex__item part-slide-tri"><input class="weui-input weui-pop-div text-center" id="typeBrake" type="text"></div>
                                <div class="weui-flex__item part-slide-tri"><input class="weui-input mui-date text-center" id="exterMonth1"></div>
                            </div>
                    </div>
                </div>
                <div class="weui-cell bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left load-before">
                    <div class="weui-cell__bd">
                        <div class="weui-panel weui-panel_access">
                            <div class="weui-panel__bd more-list-content more-list-content-1">
                            
                            </div>
                        </div>


                    </div>
                </div>
            </div>
            <div id="tab2" class="weui-tab__bd-item">
                <div class="weui-pull-to-refresh__layer">
                      <div class="down">下拉刷新</div>
                      <div class="up">释放刷新</div>
                      <div class="refresh"><i class="weui-loading"></i>正在刷新</div>
                </div>
                <div class="weui-cell bg-init">
                    <div class="weui-cell__hd width-100" >
                            <div class="weui-flex deep-light-gray">
                                <div class="weui-flex__item"><small class="text-light-gray font-15" style="margin-right: 10%;">共有<em class="text-primary show-record"></em>条记录</small></div>
                                <div class="weui-flex__item part-slide-tri"><input class="weui-input weui-pop-div text-center" id="recharge" type="text"></div>
                                <div class="weui-flex__item part-slide-tri"><input class="weui-input mui-date text-center" id="exterMonth2"></div>
                            </div>
                    </div>
                </div>
                <div class="weui-cell bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left load-before">
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
                   <div class="down">下拉刷新</div>
                   <div class="up">释放刷新</div>
                   <div class="refresh"><i class="weui-loading"></i>正在刷新</div>
                </div>
                <div class="weui-cell bg-init ">
                    <div class="weui-cell__hd width-100" >
                            <div class="weui-flex deep-light-gray">
                                <div class="weui-flex__item"><small class="text-light-gray font-15" style="margin-right: 10%;">共有<em class="text-primary show-record"></em>条记录</small></div>
                                <div class="weui-flex__item part-slide-tri"><input class="weui-input weui-pop-div text-center" id="sendType" type="text" value=""></div>
                                <div class="weui-flex__item part-slide-tri"><input class="weui-input mui-date text-center" id="exterMonth3"></div>
                            </div>
                    </div>
                </div>
                <div class="weui-cell bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left load-before">

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
<script src="<%=request.getContextPath()%>/res/event/timeReminder.js?v=${version}"></script>
</body>
</html>