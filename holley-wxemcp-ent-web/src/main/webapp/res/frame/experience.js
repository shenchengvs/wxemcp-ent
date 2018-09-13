 $(function() {
	    var storage= window.localStorage;
        storage = storage ? storage : [];
        var text=$('.text-show');
        var otart=$('.weui-vcode-btn');
        var otel;
        var time=60;
        var ocode=$('.code');
        var ocodeVal;
        
      
        /* 获取登入成功时的当前时间 */
        function getNowDate(xDate){
            var oMonth=xDate.getMonth()+1;//月
            function transDt(obj){
            	return ((obj<10)?('0'+obj):obj);
            }
            timestr=xDate.getFullYear()+'-'+(transDt(oMonth))+'-'+(transDt(xDate.getDate()))+' '+(transDt(xDate.getHours()))+':'+(transDt(xDate.getMinutes()))+':'+(transDt(xDate.getSeconds()));
            return timestr;
        }

        $(document).on('input','#telephone',function (e) {
                otel=this.value; 
                if(otel.length===11){
                    otart.addClass('text-primary');
                }else{
                    otart.removeClass('text-primary');
                }
        })
        $(document).on('input','.code',function (e) {
                ocodeVal=this.value;
                if(ocodeVal.trim().length>0){
                    $('.exper-user').addClass('weui-btn_primary');
                }else{
                    $('.exper-user').removeClass('weui-btn_primary');
                }
        })

        function getIsFull() {
            otel=$('#telephone').val();
            ocodeVal=ocode.val();
            if(otel.trim().length===0){
                return 1;
            }else{
                if(ocodeVal.trim().length===0){
                    return 2;
                }else{
                    return 3;
                }
            }
        }
        otart.on('click',function(e){//点击验证码
           text.text('');
           if($(this).hasClass('text-primary')){
               var self=$(this);

               if(/^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0-9])|(17[0-9]))\d{8}$/.test(otel)){

                   var getTime=function(){
                       if (time == 0) {
                           self.text("获取验证码");
                           time=60;
                           self.addClass('text-primary');
                           return;
                       } else {
                           self.text("("+ time + "s)重新获取");
                           time--;
                           if(time>58){
                        	 //发送手机验证码数据
                               $.ajax({
                                   url : "frame/login_sendPhoneCode.action",
                                   type : "POST",
                                   data : {
                                	   phone:$('#telephone').val()//手机号
                                   },
                                   dataType : "json",
                                   success : function(res) {
                                	   console.log($('#telephone').val());
//                                       $.hideLoading();
                                       if(res.ret===0){//如果成功
                                           $.toast('发送成功',800,function() {
                                               console.log('success');
                                           });
                                       }else{
                                           $.toast(res.msg,"cancel", function(toast) {
                                               console.log('fail');
                                           });
                                       }
                                   },
                                   error:function(msg){
                                	   $.toast(msg,"cancel", function(toast) {
                                           console.log(msg);
                                       });
                                   },
                                   complete:function(){

                                   }
                               })
                           }
                           

                       }
                       setTimeout(function () {
                           getTime();
                           
                       }, 1000)
                   }
                   self.removeClass('text-primary');
                   getTime();
               }else{
                   text.text('手机号格式错误');
               }

            }

        })
            $('.exper-user').on('click',function(e){//点击登录
            	$.showLoading();
                text.text('');
                var flag=getIsFull();
                if(flag<3){
                    flag<2?text.text('手机号不能为空'):text.text('验证码不能为空');
                    $.hideLoading();
                    return;
                }
               var oType;
               $('.choose-checked input[type="radio"]').each(function(i){
            	   if($(this).prop('checked')===true){
            		   oType=$(this).data('role');
            	   }
               })
          
               // 立即体验
              $.ajax({
                    url : "frame/login_experience.action",
                    type : "POST",
                    data : {
                    	phone:$('#telephone').val(),
                        code:ocode.val(),
                        entType:oType
                    },
                    dataType : "json",
                    success : function(res) {
                    	
                        if(res.ret===0){//如果成功
                        	
                        	 storage.setItem('accountKey',res.data.accountKey);//缓存密钥
                             storage.setItem('entType',res.data.entType);//缓存用户类型
                             storage.setItem('entName',res.data.entName);//缓存企业名
                             
                             storage.setItem('messageUpdateTime',getNowDate(new Date()));//缓存短信记录更新时间
                             storage.setItem('rechargeUpdateTime',getNowDate(new Date()));//缓存充值记录更新时间
                             storage.setItem('remoteUpdateTime',getNowDate(new Date()));//缓存拉合闸记录更新时间
                             console.log(storage);
                            $.hideLoading();
                            $.toast('登录成功',800,function() {
                            	 var vhref=storage.getItem('vlocation');
                            	 if(vhref===null){
                            		 window.location.href='data/initRealPowerPage.action'
                            	 }else{
                            		 window.location.href=vhref;
                            	 }
                                 
                            },1000);
                            
                        }else{
                        	$.hideLoading();
                            $.toast(res.msg,"cancel", function(toast) {
                                console.log('fail');
                            },3000);
                           
                        }
                    },
                    error:function(msg){
                    	$.hideLoading();
                    	$.toast(msg,"cancel", function(toast) {
                            console.log(msg);
                        });
                    },
                    complete:function(){

                    }
                })
            })
     
        });