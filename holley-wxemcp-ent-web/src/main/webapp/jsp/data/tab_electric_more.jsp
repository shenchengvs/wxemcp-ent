<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" pageEncoding="UTF-8" %>
<%@ include file="../common/top.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>电费详情</title>
    <%@include file="../common/css.jsp"%>
   <%@include file="../common/js.jsp"%>
</head>
<body ontouchstart class="bg-init">
 <div class="weui-pull-to-refresh__layer">
                      <div class="down">下拉刷新</div>
                      <div class="up">释放刷新</div>
                      <div class="refresh"><i class="weui-loading"></i>正在刷新</div>
 </div>
            <div class="weui-cell more-list-li">
                <div class="weui-cell__hd width-100" >
                        <div class="weui-flex deep-light-gray preview-border-left">
                            <div class="weui-flex__item width-100"><span class="font-16 text-primary index-title"></span><span class="text-light-gray pull-right font-14">
                                &centerdot;电费(/元)&nbsp;&centerdot;电量(/kWh)
                            </span></div>
                        </div>
                </div>
            </div>
                <div class="weui-cell bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left noOut">
               <div class="weui-cell__bd">
                <div class="weui-panel weui-panel_access noOut">
                        <div class="weui-form-preview__bd font-init">
                            <div class="weui-form-preview__item">
                                <label class="weui-form-preview__label">户名:<span class="remind-title margin-l5 account-name"></span>
                                </label>
                                <span class="weui-form-preview__value">电表数:<em class="margin-l5 meter-name text-red font-15"></em></span>
                            </div>
                            <div class="weui-form-preview__item">
                                <label class="weui-form-preview__label">户号:<span class="remind-title margin-l5 account-id"></span>
                                </label>
                            </div>
                            <div class="weui-form-preview__item weui-add-img">
                                <label class="weui-form-preview__label weui-telphone"><img src="res/images/contact_icon.png" /><span class="margin-l5 linkman"></span></label>
                                <a href="" class="weui-form-preview__value to-tel"><img src="res/images/tel_phone_icon.png" /><em class="text-light-gray margin-l5 user-phone"></em></a>
                            </div>
                        </div>
                </div>
                <div class="padding-15">
                    <table class="table width-100" border="1">
                      <!--   <thead>
                        
                        </thead> -->
                        <tbody class="table1">
                        <tr class='th'>
                            <td>计算月份</td>
                            <td>电度电费</td>
                            <td>基本电费</td>
                            <td>基金电费</td>
                        </tr>
                        <tr>
                            <td colspan="4">没有数据</td>
                        </tr>
                        <tr class='th'>
                            <td>力率电费</td>
                            <td>追退电费</td>
                            <td>应付电费</td>
                            <td>账户余额</td>
                        </tr>
                         <tr>
                           <td colspan="4">没有数据</td>
                        </tr>
                        <tr class='th'>
                            <th>消耗电量</th>
                            <th>总余额</th>
                            <th>冻结余额</th>
                            <th>可用余额</th>
                        </tr>
                         <tr>
                            <td colspan="4">没有数据</td>
                        </tr>
                        </tbody>
                    </table>
                 <!--    <table class="table width-100" border="1">
                        <thead>
                        
                        </thead>
                        <tbody class="table2">
                       
                        </tbody>
                    </table>
                     <table class="table width-100" border="1">
                        <thead>
                        <tr>
                            <th>消耗电量</th>
                            <th>总余额</th>
                            <th>冻结余额</th>
                            <th>可用余额</th>
                        </tr>
                        </thead>
                        <tbody class="table3">
                       
                        </tbody>
                    </table> -->
                </div>
            </div>

                </div>
             <div class="more-list-content tabBottomBody">
             
   	         </div>
      


<script src="<%=request.getContextPath()%>/res/data/tab_electric_more.js?v=${version}"></script>

</body>
</html>