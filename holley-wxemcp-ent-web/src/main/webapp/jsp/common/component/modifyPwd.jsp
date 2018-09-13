<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!-- 模态框（Modal） 修改密码-->
<div  id="modifyPwdModal" style="display: none;">
   <div>
      <div>
        <!--  <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="myModalLabel">修改密码</h4>
         </div> -->
         <div class="modal-body">
		 	<form class="form-horizontal" role="form" id="pwdform"  enctype="multipart/form-data" >
				<div class="form-group">
			      <label class="col-sm-3 control-label">旧密码</label>
			      <div class="col-sm-9">
			      	<input type="password" class="form-control" id="oldpwd" onblur="ispassword(this);" placeholder="请输入旧密码" maxlength="16">
			      	<span class="hide" style="color: red">请输入6-16位数字字母组合的密码!</span>
			      </div>
		    	</div>
		    	<div class="form-group" style="margin-top: 10">
			      <label class="col-sm-3 control-label">新密码</label>
			      <div class="col-sm-9">
			      	<input type="password" class="form-control" id="newpwd" onblur="ispassword(this);" placeholder="请输入新密码" maxlength="16">
			      	<span class="hide" style="color: red">请输入6-16位数字字母组合的密码!</span>
			      </div>
		    	</div>
		    	<div class="form-group" style="margin-top: 10">
			      <label class="col-sm-3 control-label">重新输入新密码</label>
			      <div class="col-sm-9">
			      	<input type="password" class="form-control" id="repeatpwd" onblur="ispassword(this);" placeholder="请再一次输入新密码" maxlength="16">
			      	<span id="repeatpwdmsg" class="hide" style="color: red">请输入6-16位数字字母组合的密码!</span>
			      </div>
		    	</div>
			</form>
         </div>
         <div class="modal-footer">
            <button id="savePwdBtn" type="button" class="btn btn-primary">确定</button>
          <!--   <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> -->
         </div>
      </div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
