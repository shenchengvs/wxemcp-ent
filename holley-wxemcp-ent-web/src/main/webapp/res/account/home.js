 $(function() {
	   
        var storage=window.localStorage;
        var vhref=storage.getItem('vlocation');
        var isChange=1;
        var flagPush=false;
 
        $.showLoading();
        getPages(
	             'account/account_queryAccount.action',
	             {
	                 accountKey:storage.getItem('accountKey'), 
	                 openId:storage.getItem('openid')
	                 /*openId:'o8Stm0RMbdZ2LOSwUf568YTlslNU'*/
	             },function (res) {
	            	 console.log(res)
	                 $('.userName').text(res.data.account);             
	                 $('.companyName').text(res.data.entName);
	                 $('.telephone').text(res.data.phone);
	               
	                 if(res.data.isShow===1){//1.显示 2.不显示
	                	 $('.msg-push').removeClass('hidden');
	                	 if(res.data.isPush===2){ //1.推送2.不推送
	                	 	  isChange=2
	                		  $('.msg-push').find('.weui-switch-cp__input').removeAttr('checked');
	                	
		                 }else{
		                	 isChange=1;
		                	 $('.msg-push').find('.weui-switch-cp__input').attr('checked');
		               
		                 }
	                 }
	                 $.hideLoading();
	                 console.log('account:'+isChange)
	  
	             },function (){
	                
	             },function(){
	            	 $.hideLoading();
	             });
        
        
        $('#switchCP').on('click',function(e){
        	
        	var self=this;
        	if(flagPush){
        		return;
        	}
        	flagPush=true;
        	
        	e.preventDefault();
        	
        	var text;
        	text=(isChange===1)?'关闭推送':'开启推送';
        	
	    	 $.modal({
	             title: "<p style='padding-top:20px;padding-bottom:20px;'>确定"+text+"</p>",
	             text: "",
	             buttons: [
	               { text: "确定", className:"text-primary",onClick: function(){
	            	 
	            	  getPages(
	     	             'account/account_changePushStatus.action',
	     	             {
	     	                 accountKey:storage.getItem('accountKey'),
	     	                 openId:storage.getItem('openid'),
	     	                 /*openId:'o8Stm0RMbdZ2LOSwUf568YTlslNU',*/
	     	                 pushStatus:((isChange===1)?2:1)
	     	             },function (res) {
	     	            	if(isChange===1){//推送--不推送
	     	            		$(self).removeAttr('checked');
		            		   	$(self).removeClass('weui-switch-cp__input');
		            		   	$(self).prop('checked',false);
				        		isChange=2;
				        		flagPush=false;
				        	}else{           //不推送--推送
				        		
				        		$(self).attr('checked','checked');
				        		$(self).addClass('weui-switch-cp__input');
				        		$(self).prop('checked',true);
				        		isChange=1;
				        		flagPush=false;
				        	}
	     	            	 
	     	                $.hideLoading();
	     	  
	     	             },function (){
	     	            	flagPush=false;
	     	             },function(){
	     	            	 $.hideLoading();
	     	             });
	          	
	            	  
	               } },
	               { text: "取消", className: "default",onClick:function(){
	            	   flagPush=false;
	               }},
	             ]
	           });
        	
        	
        	
        })
        
        $('.sign-up').on('click',function(e){
        	e.stopPropagation();
        	e.preventDefault();
        	$.showLoading();
            getPages(
   	             'account/account_logout.action',
   	             {
   	            	openId:storage.getItem('openid'),
   	            	accountKey:storage.getItem('accountKey')
   	             },function (res) {
   	            	$.hideLoading();
	   	          	storage.clear();
	   	        	storage.setItem('vlocation',vhref);
	   	        	window.location.href='frame/initLoginPage.action';
   	             },function (){
   	                
   	             },function(){
   	            	 $.hideLoading();
   	             });
        	//e.preventDefault();
        })
 });