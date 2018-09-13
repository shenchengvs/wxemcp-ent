 $(function() {
	        FastClick.attach(document.body);
            var text=$('.text-show');
//            window.localStorage.clear();//清除本地数据缓存
            var storage= window.localStorage;
            storage = storage ? storage : [];

            console.log(storage);
           
            
            /* 获取登入成功时的当前时间 */
            function getNowDate(xDate){
                var oMonth=xDate.getMonth()+1;//月
                function transDt(obj){
                	return ((obj<10)?('0'+obj):obj);
                }
                timestr=xDate.getFullYear()+'-'+(transDt(oMonth))+'-'+(transDt(xDate.getDate()))+' '+(transDt(xDate.getHours()))+':'+(transDt(xDate.getMinutes()))+':'+(transDt(xDate.getSeconds()));
                return timestr;
            }
           
            $('.weui-btn_primary').on('click',function(e){//点击登录
//                $.showLoading();
                text.text('');
                var user=$('.userName').val();
                var pwd=$('.userPwd').val();
                var utext=$('.userName').closest('.weui-cell').find('.weui-label').text();
                var upwd=$('.userPwd').closest('.weui-cell').find('.weui-label').text();

                if(user===undefined||user.trim().length===0){
                    text.text(utext+'不能为空');
                }else{
                    if(pwd===undefined||pwd.trim().length===0){
                        text.text(upwd+'不能为空');
                    }else{
                        
                        $.ajax({
                            url : "frame/login_login.action",
                            type : "POST",
                            data : {
                                account:user,
                                password:pwd
                            },
                            dataType : "json",
                            success : function(res) {
                                $.hideLoading();
                                if(res.ret===0){//如果成功
                                	
                                    storage.setItem('accountKey',res.data.accountKey);//缓存密钥
                                    storage.setItem('entType',parseInt(res.data.entType));//缓存用户类型
                                    storage.setItem('entName',res.data.entName);//缓存企业名
                                    
                                    
                                    storage.setItem('messageUpdateTime',getNowDate(new Date()));//缓存短信记录更新时间
                                    storage.setItem('rechargeUpdateTime',getNowDate(new Date()));//缓存充值记录更新时间
                                    storage.setItem('remoteUpdateTime',getNowDate(new Date()));//缓存拉合闸记录更新时间
                                    
                                    $.toast('登录成功',800,function() {
                                       //console.log( window.localStorage.getItem('accountKey')+' '+window.localStorage.getItem('entType'));
                                    	  console.log(storage);
                                    	  var vhref=storage.getItem('vlocation')
                                          window.location.href=vhref;
                                    });
                                }else{
                                    $.toast(res.msg,"cancel",function(toast) {
                                        console.log('fail');
                                    });
                                }
                            },
                            error:function(msg){

                            },
                            complete:function(){

                            }
                        })
                    }
                }

            })
        });