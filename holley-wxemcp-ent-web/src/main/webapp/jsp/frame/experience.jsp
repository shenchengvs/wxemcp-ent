<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" pageEncoding="UTF-8" %>
<%@ include file="../common/top.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>绑定账号</title>
    <%@include file="../common/css.jsp"%>
   <%@include file="../common/js.jsp"%>
    <style>
        .weui-vcode-btn{
            line-height: 47px;
            height: 47px;
            width: 102px;
            text-align: center;
            padding-left: 3px;
            padding-right: 3px;
        }
        .choose-checked{
            display: flex;
    		justify-content: center;
        }
        .choose-checked>div{
        	flex:0 1 50%;
        	text-align:center;
        }
    </style>
</head>
<body ontouchstart>
<div class="weui-cells weui-cells_form margin-10 font-16">
    <div class="weui-cell">
        <div class="weui-cell__hd">
            <label class="weui-label">手机号</label>
        </div>
        <div class="weui-cell__bd">
            <input class="weui-input" type="tel" placeholder="手机号" id="telephone" maxlength="11">
        </div>
    </div>
    <div class="weui-cell weui-cell_vcode">
        <div class="weui-cell__hd">
            <label class="weui-label">验证码</label>
        </div>
        <div class="weui-cell__bd">
            <input class="weui-input code" type="number" placeholder="验证码" maxlength="6" >
        </div>
        <div class="weui-cell__ft">
            <button class="weui-vcode-btn text-light-gray">获取验证码</button>
        </div>
    </div>
    <div class="weui-cell choose-checked">
        <div>
        	<input type="radio" id="east" name="chooseType" checked="checked" data-role=1>
          	<label for="east">园区版</label>
        </div>
        <div>
            <input type="radio" id="recharge" name="chooseType" data-role=2>
          	<label for="recharge">费控版</label>
        </div>
      
    </div>
</div>
<div class="padding-15 text-red text-show" style="height: 30px;">
</div>

<div class="demos-content-padded btn-margin-20">
    <a href="javascript:void(0);" class="weui-btn exper-user weui-btn_default">立即体验</a>
</div>


<script src="<%=request.getContextPath()%>/res/frame/experience.js?v=${version}"></script>
<script>
   
</script>
</body>
</html>