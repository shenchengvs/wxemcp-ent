function getkey(event,id){
        event = event || window.event;
        if(event.keyCode==13){
        	var input = document.getElementById("searchInput");  
        	input.blur();  
            event.returnValue = false;
            document.getElementById(id).blur();
            return false;
        }
}

function getStorage(url){
	var storage= window.localStorage;
//	storage.clear();
	var vkey=storage.getItem('accountKey');

	if((vkey===null)||(vkey.trim()=='')){
		storage.setItem('vlocation',url);
		window.location.href='frame/initLoginPage.action';
		return ;
	}
}
function getPages(ourl,objdata,callBack,completeBack,failBack){  //获取数据
    $.ajax({
        url : ourl,
        type : "POST",
        data :objdata,
        dataType : "json",
        success : function(res) {
        	console.log(objdata);
        	console.log(res);
            if(res.ret===0){//如果成功
            	/*console.log(res)*/
//              storage.setItem('accountKey',res.data.accountKey );
            	console.log(objdata);
                callBack(res);
            }else{
            	failBack();
                $.toast(res.msg,"cancel", function(toast) {
                    console.log('失败');
                });
            }
           
        },
        error:function(msg){
        	 $.hideLoading();
            $.toast(msg,"cancel", function(toast) {
                console.log(msg);
            });
        },
        complete:function(){
             completeBack();
        }
    })
}

function GetQueryString(name) { //获取string
	  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	  var r = window.location.search.substr(1).match(reg); //获取url中"?"符后的字符串并正则匹配
	  var context = ""; 
	  if (r != null) 
	     context = r[2];
	  reg = null; 
	  r = null; 
	  return context == null || context == "" || context == "undefined" ? "" : context; 
}

function getOpenId(storage){//获取openId
	
	var appId="wx049c55581733eec3";
    var redirectUri="http%3a%2f%2fent.energyman.cn%2fwxemcpent%2f";
    var oHref=window.location.href;
    var zindex=oHref.indexOf('wxemcpent');
    var tartUrl=(oHref.substring(zindex+10)).replace('/','%2f');//当前界面
    
	if(!(storage.getItem('openid'))){//判断openId  不存在
		  if(!GetQueryString('code')){
    	      window.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appId+"&redirect_uri="+(redirectUri+tartUrl)+"&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
    	      return;
          } 
		
		  $.ajax({
		        url : 'wechat/wechat_authorize.action',
		        type : "POST",
		        data : {
		               code:GetQueryString('code')
	            },
		        dataType : "json",
		        success : function(res) {
		        	
		        	if(res.ret===0){
						
		        		 $.ajax({
		     		        url : 'data/data_saveOpenId.action',
		     		        type : "POST",
		     		        data : {
				                accountKey:window.localStorage.getItem('accountKey'),
				                openId:res.data.openid
				            },
		     		        dataType : "json",
		     		        success : function(rest) {
		     		        	/*console.log(rest)*/
		     		        	if(rest.ret===0){
		     		        		storage.setItem('openid',res.data.openid);
		     					 }else{
		     						 $.hideLoading();
		     						 $.toast(rest.msg,"cancel",function(toast) {});
		     					 }
		     		        },
		     		        error:function(msg){
		     		        	$.hideLoading();
		     		            $.toast('系统错误',"cancel", function(toast) {
		     		                console.log(msg);
		     		            });
		     		        },
		     		        complete:function(){
		     		            
		     		        }
		     		    }) 
						 
					 }else{
						 $.hideLoading();
						 $.toast(res.msg,"cancel",function(toast) {});
					 }
		        },
		        error:function(msg){
		        	$.hideLoading();
		            $.toast('系统错误',"cancel", function(toast) {
		                console.log(msg);
		            });
		        },
		        complete:function(){
		            
		        }
		    })
	  }
}


/*function isExitKey(){//是否存在accoutKey
 * 
*/
 	var storage= window.localStorage;
  /*storage.removeItem('openid');*/
 	/*console.log(storage.getItem('accountKey')+'openid '+storage.getItem('openid'))*/
	/*if(JSON.parse(storage.getItem('accountKey'))){//判断accountKey 存在
*/	if(storage.getItem('accountKey')){//判断accountKey 存在
	   getOpenId(storage);
	}
	
/*}*/
