<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
 <div id="lngLatMapModal2">
 <div class="modal-body">
	<div id="lngLatMapDiv2" style="height: 80%;width: 100%">
	
	</div>
</div>
  <div class="modal-footer">
  	<form class="form-inline" role="form">
  	 	 <div class="form-group pull-left">
  	 	 <input id="lngMap2" placeholder="经度" class="form-control input-sm" disabled="disabled"/>
  	 	 <span>-</span>
  	 	 <input id="latMap2" placeholder="纬度" class="form-control input-sm" disabled="disabled"/>
  	 	 </div>
  	 	<div id="btnbar2" class="form-group pull-right">
  	 	  <input id="searchKey2" placeholder="搜索关键字" class="form-control input-sm"/>
  	 	  <button id="searchKeyBtn2" type="button" class="btn btn-primary btn-sm">搜索</button>
  	 	  <button id="lngLatMapSaveBtn2" type="button" class="btn btn-primary btn-sm">确定</button>
	  	</div>
  	</form>
 
           
  </div>
  </div>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=ag2fYhtdY5BgQWqi6Xwsx0Pp"></script>
<script src="res/js/common/component/switchLngLat2.js" type="text/javascript"></script>