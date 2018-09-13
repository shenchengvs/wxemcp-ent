<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<style>
.page-btn{
	padding: 0 0;
	margin-top:-5px;
	background: transparent;
	border: none;
	outline: none;
}

</style>
<div class="text-right" id="pagingToolbar">
	<ul class="pagination">
  	  <li>
	  	<button id="firstPage" class="btn btn-md page-btn" disabled="disabled">
	  		<span class="glyphicon glyphicon-step-backward" style="color:#337ab7;"></span>
  		</button>
  	  </li>
	  <li>
	  	<button id="prevPage" class="btn btn-md page-btn" disabled="disabled">
	  		<span class="glyphicon glyphicon-triangle-left" style="color:#337ab7;"></span>
  		</button>
  	  </li>
	</ul>
	当前第  <input class="text-center" id="currentPage" type="text" disabled="disabled" value='1' style="width: 80px;color: #337ab7;"/>  页,
	共  <span id="totalPage" style="color:#337ab7;">0</span>  页,
	共  <span id="totalProperty" style="color:#337ab7;">0</span>  条记录
	<ul class="pagination">
	  <li>
	  	<button id="nextPage" class="btn btn-md page-btn">
	  		<span class="glyphicon glyphicon-triangle-right" style="color:#337ab7;"></span>
  		</button>
  	  </li>
  	  <li>
	  	<button id="lastPage" class="btn btn-md page-btn" disabled="disabled">
	  		<span class="glyphicon glyphicon-step-forward" style="color:#337ab7;"></span>
  		</button>
  	  </li>
	</ul>
</div>
