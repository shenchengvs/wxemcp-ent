<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<style>
.form-group {
    margin-bottom: 5px;
}
</style>
<!-- 模态框（Modal） 搜索企业 -->
<div id="switchEnt_modal" style="display:none;">
         <div class="modal-body" style="padding-bottom: 0">
		 	<form class="form-horizontal" id="switchEnt_qryForm" role="form" enctype="multipart/form-data" style="margin-bottom: 0;">
				<div class="form-group">
				  <label class="col-sm-3 control-label">企业名称</label>
			      <div class="col-sm-8">
			      	<input type="text" class="form-control" id="switchEnt_keyword" maxlength="50" style="width: 325px;">
			      </div>
		    	</div>
		    	<div class="form-group">
			      <label class="col-sm-3 control-label">所属区域</label>
			      <div class="col-sm-8 form-inline">
				  	<select id="switchEnt_provinceCombo" name="province" class="form-control" style="width: 160px;">
				     	<option value="0">请选择省</option>
				     	<s:iterator value="#application.province" var="item" status="st">
					     	<option value="${item.cityid}">${item.name}</option>
				     	</s:iterator>
				    </select>
				  	<select id="switchEnt_cityCombo" name="city" class="form-control" style="width: 160px;">
				     	<option value="0">请选择市</option>
				    </select>
				  </div>
		    	</div>
		    	<div class="form-group text-right" style="padding-right: 15px;">
		    		<button id="switchEnt_searchBtn" type="button" class="btn btn-primary btn-sm">搜索</button>
		    	</div>
			</form>
			<div id="switchEnt_entTableDiv">
			    <table id="switchEnt_entTable" class="table table-condensed table-hover table-bordered" data-toggle="table" data-single-select="true">
				    <thead class="table-header">
			   			<tr>
			   				<th data-checkbox="true" data-width="35px;"></th>
			   				<th data-field="disc">企业名称</th>
			   				<th data-field="cityname" data-width="100px;">区域</th>
			   			</tr>
			   		</thead>
				   	<tbody>
				   	</tbody>
				</table>
		    </div>
			<!-- 分页条 -->
	    	<%@include file="pagingtoolbar2.jsp" %>
		     
         </div>
         <div class="modal-footer" style="padding-top: 5px;">
            <button id="switchEnt_clearBtn" type="button" class="btn btn-primary btn-sm pull-left">清除</button>
            <button id="switchEnt_saveBtn" type="button" class="btn btn-primary btn-sm">确定</button>
            <button id="switchEnt_closeBtn" type="button" class="btn btn-primary btn-sm" >关闭</button>
         </div>
</div>

