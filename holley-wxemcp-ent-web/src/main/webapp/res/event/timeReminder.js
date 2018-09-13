$(function() {
	
	  
	
        FastClick.attach(document.body);
        var storage=window.localStorage;
        var timestr;//初始化时间

        var toRefresh1=false;//tab refresh1
        var toRefresh2=false;//tab refresh2
        var toRefresh3=false;//tab refresh3
        
        var loading1=false;//tab loading1
        var loading2=false;//tab loading2
        var loading3=false;//tab loading3
        
        var index1=1;//tab1 页码数
        var index2=1;//tab2 页码数
        var index3=1;//tab3 页码数
        
        var listDiv1='.more-list-content-1';//对象
        var listDiv2='.more-list-content-2';//对象
        var listDiv3='.more-list-content-3';//对象
        
        var infDiv1='#tab1';
        var infDiv2='#tab2';
        var infDiv3='#tab3';
        var flag='- -';
        
        var isOver1=false;//tab1 是否加载完毕
        var isOver2=false;//tab2 是否加载完毕
        var isOver3=false;//tab3 是否加载完毕
        
        var oldSelect1=0;//原先tab1选择的拉合闸初始值
        var oldSelect2=0;//原先tab2选择的充值初始值
        var oldSelect3=0;//原先tab3选择的短信发送初始值
        
        
        /* 获取当前时间 */
        function getNewDate(xDate){
            var oMonth=xDate.getMonth()+1;//月
            function transDt(obj){
            	return ((obj<10)?('0'+obj):obj);
            }
            timestr=xDate.getFullYear()+'-'+(transDt(oMonth))+'-'+(transDt(xDate.getDate()))+' '+(transDt(xDate.getHours()))+':'+(transDt(xDate.getMinutes()))+':'+(transDt(xDate.getSeconds()));
            return timestr;
        }
        
        /*  默认日期为当前年月 */
        function getNowDate(obj){
        	
            var xDate=new Date();
            var oMonth=xDate.getMonth()+1;
            if(oMonth<10){
                oMonth='0'+oMonth;
            }
            timestr=xDate.getFullYear()+'-'+(oMonth);
            obj.val(timestr);
        }
        getNowDate($('.mui-date'));
        
        var oldTime1=timestr;
        var oldTime2=timestr;
        var oldTime3=timestr;
        
      
          
       
        
        function getDatePlugins(objVal,obj,titName,timeCallback){
        	$(obj).datetimePicker({
        		input:objVal,
                title: titName,
                monthSplit:'',
                noDay:true,
                times: function () {
                    return;
                },
                onChange: function (picker, values, displayValues) {
//                    console.log(values);
                },
                onClose:function(vals){
                   var oPar = $(obj).closest('.part-slide-tri');
                    oPar.removeClass('part-slide-tri-after');
                    var str;
                    str=vals.value.join('-');//选中的日期
                    timeCallback(str);
                },
                onOpen:function(){
                	  $('.part-slide-tri').removeClass('part-slide-tri-after');
                      var oPar = $(obj).closest('.part-slide-tri');
                      oPar.addClass('part-slide-tri-after');
                }
            });
        }
        getDatePlugins(getNowDate($('#exterMonth1')),'#exterMonth1','日期选择',function(vTime){
        	if(oldTime1!=vTime){
        	   $.showLoading();
        	   initPage(listDiv1,infDiv1,1,true);//初始化tab1
        	   oldTime1=vTime;
        	}
        });
        getDatePlugins(getNowDate($('#exterMonth2')),'#exterMonth2','日期选择',function(vTime){
        	if(oldTime2!=vTime){
        		$.showLoading();
        	   initPage(listDiv2,infDiv2,2,true);//初始化tab2
        	   oldTime2=vTime;
        	}
        });
        getDatePlugins(getNowDate($('#exterMonth3')),'#exterMonth3','日期选择',function(vTime){
        	if(oldTime3!=vTime){
        		$.showLoading();
        	   initPage(listDiv3,infDiv3,3,true);//初始化tab3
        	   oldTime3=vTime;
        	}
        });
        
   
        /* tab切换时关闭所有pop弹框 */
        $(".weui-pop-div,.weui-navbar__item").on('click',function(e){
            e.preventDefault();
            $('.close-select').click();
        });
        
       
        $(infDiv1).find('.weui-pop-div').val('全部').data({"values":0});
        $(infDiv2).find('.weui-pop-div').val('全部').data({"values":0});
        $(infDiv3).find('.weui-pop-div').val('全部').data({"values":0});
        
        	/* 拉合闸类型 */
            $("#typeBrake").select({
                title: "拉合闸类型",
                items: [{
                    title: "全部",
                    value: 0
                  },
                  {
                    title: "自动拉闸",
                    value: 1
                  },
                  {
                    title: "自动合闸",
                    value: 2
                  },
                  {
                      title: "手动拉闸",
                      value: 3
                  },
                  {
                      title: "手动合闸",
                      value: 4
                  }],
                onChange: function (d) {
                },
                onClose: function (vals) {
                    var selectedOption = vals.data;
                    var obj=$("#typeBrake");

                    var oPar = obj.closest('.part-slide-tri');
                    oPar.removeClass('part-slide-tri-after');

                    var oVal;
                    for (var i in selectedOption.origins) {
                        oVal = selectedOption.origins[i].value;
                    }
                   if(oldSelect1!=oVal){
                	   $.showLoading();
                	   initPage(listDiv1,infDiv1,1,true);//初始化tab1
                	   oldSelect1=oVal;
                   }
                },
                onOpen: function () {
                    $('.part-slide-tri').removeClass('part-slide-tri-after');
                    var oPar = $("#typeBrake").closest('.part-slide-tri');
                    oPar.addClass('part-slide-tri-after');
                }
            });
       
     
        	/* 充值记录 */
            $("#recharge").select({
                title: "充值类型",
                items: [{
                    title: "全部",
                    value: 0
                  },
                  {
                    title: "线下支付",
                    value: 1
                  },
                  {
                    title: "支付宝",
                    value: 2
                  },
                  {
                      title: "微信",
                      value: 3
                  },
                  {
                      title: "接口",
                      value: 4
                  }
                  ],
                onChange: function (d) {
                },
                onClose: function (vals) {
                    var selectedOption = vals.data;
                    var obj=$("#recharge");
                    var oPar = obj.closest('.part-slide-tri');
                    oPar.removeClass('part-slide-tri-after');

                    var oVal;
                    for (var i in selectedOption.origins) {
                        oVal = selectedOption.origins[i].value;
                    }
           
                   if(oldSelect2!=oVal){
                	   $.showLoading();
                	   initPage(listDiv2,infDiv2,2,true);//初始化tab2
                	   oldSelect2=oVal;
                   }
                },
                onOpen: function () {
                    $('.part-slide-tri').removeClass('part-slide-tri-after');
                    var oPar = $("#recharge").closest('.part-slide-tri');
                    oPar.addClass('part-slide-tri-after');
                }
            });
        
        
        	 /* 发送类型 */
            $("#sendType").select({
                title: "发送类型",
                items: [{
                    title: "全部",
                    value: 0
                  },
                  {
                    title: "自动发送",
                    value: 1
                  },
                  {
                    title: "手动发送",
                    value: 2
                  }],
                onChange: function (d) {
                },
                onClose: function (vals) {
                    var selectedOption = vals.data;
                    var obj=$("#sendType");
                    var oPar = obj.closest('.part-slide-tri');
                    oPar.removeClass('part-slide-tri-after');

                    var oVal;
                    for (var i in selectedOption.origins) {
                        oVal = selectedOption.origins[i].value;
                    }
                   
                   if(oldSelect3!=oVal){
                	   initPage(listDiv3,infDiv3,3,true);//初始化tab1
                	   oldSelect3=oVal;
                   }
                },
                onOpen: function () {
                    $('.part-slide-tri').removeClass('part-slide-tri-after');
                    var oPar = $("#sendType").closest('.part-slide-tri');
                    oPar.addClass('part-slide-tri-after');
                }
            });
        
       
          /* mui datepicker */
         $('.mui-date').on('click',function(){
             $('.part-slide-tri').removeClass('part-slide-tri-after');
             var oPar = $(this).closest('.part-slide-tri');
             oPar.addClass('part-slide-tri-after');
         });
        
         
     
        
         //渲染数据tab1
         function getListItem1(vlist,vTart) {
             var listHtml='';
             for(var i in vlist){
            	 var evalVal=((vlist[i].operatetype===null)?flag:vlist[i].operatetype)+((vlist[i].cmdtype===null)?flag:vlist[i].cmdtype);
                 listHtml+='<a href="javascript:void(0);" class="weui-media-box weui-media-box_appmsg wui-cell-nopadding-top">'+'<div class="weui-media-box__bd"><h4 class="weui-media-box__title">'+
                     ((vlist[i].point===null)?flag:vlist[i].point)+'</h4><p class="weui-media-box__desc">'+((vlist[i].dataTime===null)?flag:vlist[i].dataTime)+'</p></div><div class="weui-media-box__hd">'+'<span class="weui-media-box__title-after text-red font-16 white-nowrap clear-right">'+(evalVal)+'</span></div></a>';
             }
             $(vTart).append(listHtml);
         }
         
         //渲染数据tab2
         function getListItem2(vlist,vTart) {
             var listHtml='';
             for(var i in vlist){
            	  var xtime=(vlist[i].dataTime===null)?flag:vlist[i].dataTime;
                  var finalTime=xtime.substring(0,xtime.indexOf(' '));
                  var addClass=vlist[i].payMoney>0?'text-green':'text-red';
                  var valMoney=(vlist[i].payMoney===null)?0:vlist[i].payMoney;
                  valMoney=vlist[i].payMoney>0?'+':'';
                  listHtml+='<a href="javascript:void(0);" class="weui-media-box weui-media-box_appmsg wui-cell-nopadding-top">'+'<div class="weui-media-box__hd weui-media-box-line"></div>'+'<div class="weui-media-box__bd">'+
                 '<h4 class="weui-media-box__title">'+((vlist[i].paywayDesc===null)?flag:vlist[i].paywayDesc)+'<span class="weui-media-box__title-after '+addClass+' font-16">'+valMoney+''+
                     ((vlist[i].payMoney===null)?flag:vlist[i].payMoney)+'</span></h4><p class="weui-media-box__desc">'+((vlist[i].hm===null)?flag:vlist[i].hm)+'<span class="weui-media-box__title-after text-light-gray">'+finalTime+'</span></p>'+'</div></a>';
             }
             $(vTart).append(listHtml);
         }
         function getBgType(type){
        	 switch(type){
        	   case 1:
        		 return 'weui-badge-green';
        		 break;
        	   case 2:
        		 return 'weui-badge-orange';
          		 break;
        	   case 3:
        		 return 'weui-badge-gray';
          		 break;
        	   case 4:
        		 return 'weui-badge-primary';
          		 break;
        	   case 5:
        		 return 'weui-badge-purple';
          		 break;
          	   default:
          		 return '';
        	 }
        	 
         }
         
         //渲染数据tab3
         function getListItem3(vlist,vTart) {
             var listHtml='';
             var bgType;
             
             for(var i in vlist){
            	  var xtime=(vlist[i].dataTime===null)?flag:vlist[i].dataTime;
                  var finalTime=xtime.substring(0,xtime.indexOf(' '));
                  listHtml+=' <a href="javascript:void(0);" class="weui-media-box weui-media-box_appmsg wui-cell-nopadding-top">'+'<div class="weui-media-box__hd weui-media-box-line"></div>'+'<div class="weui-media-box__bd">'+
                 '<h4 class="weui-media-box__title">'+((vlist[i].hm===null)?flag:vlist[i].hm)+'<span class="weui-badge '+getBgType(vlist[i].msgType)+' margin-l5">'+((vlist[i].msgTypeDesc===null)?flag:vlist[i].msgTypeDesc)+'</span>'
                 +'<span class="weui-media-box__title-after text-primary font-16">'+((vlist[i].sendTypeDesc===null)?flag:vlist[i].sendTypeDesc)
       +'</span></h4> <p class="weui-media-box__desc text-green">'+((vlist[i].phone===null)?flag:vlist[i].phone)+'<span class="weui-media-box__title-after text-light-gray">'+finalTime+'</span></p>'+'</div></a>';
             }
             $(vTart).append(listHtml);
         }
         
         
         function initPage(listobj,infobj,tabId,isFresh){ //listobj 加载列表的位置； infobj 滚动加载更多；vindex 当前页码数；tabId 当前tab值；vloading 滚动加载更多；vrefresh 刷新 
             $(listobj).children().remove();
             $(infobj).infinite();
            
             if(tabId===1){//tab1拉合闸记录
            	 
            	 storage.setItem('remoteUpdateTime',getNewDate(new Date()));//缓存拉合闸记录更新时间
            
            	 isOver1=false;//重置有无数据标记
            	 loading1 = false;//重置加载更多标记
            	 toRefresh1=false;//重置下拉刷新标记
            	 index1=1;//默认在第一页
                 var thisTime=$(infobj).find('.mui-date').val().trim();//时间查询
            	 //var thisTime='';//时间查询
                 var selectVal=$(infobj).find('.weui-pop-div').data('values');//选择框
//                 console.log(selectVal+' '+thisTime);
            	 getPages(
            	             'event/event_queryRemotes.action',
            	             {
            	                 accountKey:storage.getItem('accountKey'),
            	                 remoteType:selectVal,//拉合闸类型
            	                 dateTime:thisTime,//时间
            	                 pageIndex:index1,//默认页码数
            	                 messageUpdateTime:storage.getItem('messageUpdateTime'),
            	                 rechargeUpdateTime:storage.getItem('rechargeUpdateTime')
            	             },function (res) {
            	            	
            	                 var olist=res.data.datas;
            	                 var oindex=res.data.pageIndex;//页码
            	                 var tproperty=res.data.totalProperty;//总记录数
            	                 var tpage=res.data.totalPage;//总页数
            	                 
            	                 
            	                 $(infobj).find('.show-record').text(tproperty);//共有记录
            	                 
            	                 $('.weui-navbar__item').find('.weui-badge').remove();//去除所有标记数字
            	                 var newmessage=res.data.newMessageCount;//短信
            	                 var newRecharge=res.data.newRechargeCount;//充值
            	                 
            	  
                                 if(newmessage!=0){
                                	 $('.tab-item-3').append('<span class="weui-badge nav-badge">'+newmessage+'</span>');
                                 }
                                 if(newRecharge!=0){
                                	 $('.tab-item-2').append('<span class="weui-badge nav-badge">'+newRecharge+'</span>');
                                 }
                                 
                                 
            	                 if(oindex===tpage){
            	                	 isOver1=true;
            	                 }
            	                 if((tproperty===0)&&(($(listobj).children().length)===0)){//没有数据的时候
            	                     $(listobj).html('<p class="nodata">没有数据</p>');
            	                     $.hideLoading();
            	                     return;
            	                 }else{
            	                     getListItem1(olist,listobj);
            	                     $.hideLoading();
            	                 }
            	                 
            	             },function (){
            	                 
            	                 if(isFresh){
            	                	 $(infobj).pullToRefreshDone();
            	                	 toRefresh1=false;
            	                	 
            	                 }
            	             },function(){
            	            	 $.hideLoading();
            	             });
            	 
             }else{
            	 if(tabId===2){//tab2充值记录
            		 
            		 storage.setItem('rechargeUpdateTime',getNewDate(new Date()));//缓存充值记录更新时间
            		
                	 isOver2=false;//重置有无数据标记
                	 loading2 = false;//重置加载更多标记
                	 toRefresh2=false;//重置下拉刷新标记
                	 index2=1;//默认在第一页
                     var thisTime=$(infobj).find('.mui-date').val().trim();//时间查询
                	// var thisTime='';//时间查询
                     var selectVal=$(infobj).find('.weui-pop-div').data('values');//选择框
//                     console.log(selectVal+' '+thisTime);
                	 getPages(
                	             'event/event_queryRecharges.action',
                	             {
                	                 accountKey:storage.getItem('accountKey'),
                	                 paywayType:selectVal,//充值类型
                	                 dateTime:thisTime,//时间
                	                 pageIndex:index2,//默认页码数
                	                 remoteUpdateTime:storage.getItem('remoteUpdateTime'),
                	                 messageUpdateTime:storage.getItem('messageUpdateTime')
                	             },function (res) {
                	            	
                	                 var olist=res.data.datas;
                	                 var oindex=res.data.pageIndex;//页码
                	                 var tproperty=res.data.totalProperty;//总记录数
                	                 var tpage=res.data.totalPage;//总页数
                	                 
                	                 $(infobj).find('.show-record').text(tproperty);//共有记录
                	                 
                	                 $('.weui-navbar__item').find('.weui-badge').remove();//去除所有标记数字
                	                 var newRemote=res.data.newRemoteCount;//拉闸
                	                 var newmessage=res.data.newMessageCount;//短信
                	                 
                	  
                                     if(newmessage!=0){
                                    	 $('.tab-item-3').append('<span class="weui-badge nav-badge">'+newmessage+'</span>');
                                     }
                                     if(newRemote!=0){
                                    	 $('.tab-item-1').append('<span class="weui-badge nav-badge">'+newRemote+'</span>');
                                     }

                	                 if(oindex===tpage){
                	                	 isOver2=true;
                	                 }
                	                 if((tproperty===0)&&(($(listobj).children().length)===0)){//没有数据的时候
                	                     $(listobj).html('<p class="nodata">没有数据</p>');
                	                     $.hideLoading();
                	                     return;
                	                 }else{
                	                     getListItem2(olist,listobj);
                	                     $.hideLoading();
                	                 }
                	                
                	             
                	             },function (){
                	                
                	                 if(isFresh){
                	                	 $(infobj).pullToRefreshDone();
                	                	 toRefresh2=false;
                	                	 
                	                 }
                	             },function(){
                	            	 $.hideLoading();
                	             });
            		 
            	 }else{
            		 
            		 storage.setItem('messageUpdateTime',getNewDate(new Date()));//缓存充值记录更新时间
            	
                	 isOver3=false;//重置有无数据标记
                	 loading3 = false;//重置加载更多标记
                	 toRefresh3=false;//重置下拉刷新标记
                	 index3=1;//默认在第一页
                     var thisTime=$(infobj).find('.mui-date').val().trim();//时间查询
                	// var thisTime='';//时间查询
                     var selectVal=$(infobj).find('.weui-pop-div').data('values');//选择框
//                     console.log(selectVal+' '+thisTime);
                	 getPages(
                	             'event/event_queryMessages.action',
                	             {
                	                 accountKey:storage.getItem('accountKey'),
                	                 sendType:selectVal,//短信类型
                	                 dateTime:thisTime,//时间
                	                 pageIndex:index3,//默认页码数
                	                 remoteUpdateTime:storage.getItem('remoteUpdateTime'),
                	                 rechargeUpdateTime:storage.getItem('rechargeUpdateTime')
                	             },function (res) {
                	            	
                	                 var olist=res.data.datas;
                	                 var oindex=res.data.pageIndex;//页码
                	                 var tproperty=res.data.totalProperty;//总记录数
                	                 var tpage=res.data.totalPage;//总页数
                	                 
                	                 $(infobj).find('.show-record').text(tproperty);//共有记录
                	                 
                	                 $('.weui-navbar__item').find('.weui-badge').remove();//去除所有标记数字
                	                 var newRemote=res.data.newRemoteCount;//拉闸
                	                 var newRecharge=res.data.newRechargeCount;//充值
                	                 
                	  
                                     if(newRemote!=0){
                                    	 $('.tab-item-1').append('<span class="weui-badge nav-badge">'+newRemote+'</span>');
                                     }
                                     if(newRecharge!=0){
                                    	 $('.tab-item-2').append('<span class="weui-badge nav-badge">'+newRecharge+'</span>');
                                     }

                	                 if(oindex===tpage){
                	                	 isOver3=true;
                	                 }
                	                 if((tproperty===0)&&(($(listobj).children().length)===0)){//没有数据的时候
                	                     $(listobj).html('<p class="nodata">没有数据</p>');
                	                     $.hideLoading();
                	                     return;
                	                 }else{
                	                     getListItem3(olist,listobj);
                	                     $.hideLoading();
                	                 }
                	                
                	           
                	             },function (){
                	                
                	                 if(isFresh){
                	                	 $(infobj).pullToRefreshDone();
                	                	 toRefresh3=false;
                	                	 
                	                 }
                	             },function(){
                	            	 $.hideLoading();
                	             });
            		 
            	 }
             }
        }
        $.showLoading();
        initPage(listDiv1,infDiv1,1,false);//初始化tab1
        
        $('.weui-navbar__item').on("click",function(){//点击不同tab所触发的事件
        	
        	var vrole=$(this).attr('role');
        	if(vrole==='1'){
        		 $.showLoading();
        		initPage(listDiv1,infDiv1,1,true);//初始化tab1
        	}else{
        		if(vrole==='2'){
        			 $.showLoading();
        			initPage(listDiv2,infDiv2,2,true);//初始化tab2
        		}else{
        			$.showLoading();
        			initPage(listDiv3,infDiv3,3,true);//初始化tab3
        		}
        		
        	}
        	
        })
         
        // pullToRefresh
        //#tab1
        $(infDiv1).pullToRefresh({
        	distance:55
        }).on("pull-to-refresh", function() {
         	 var self=this;
             if(toRefresh1) return;
             toRefresh1 = true;
             setTimeout(function() {
                 initPage(listDiv1,self,1,true);//初始化tab1
             }, 1000);
         });
        //#tab2
        $(infDiv2).pullToRefresh({
        	distance:55
        }).on("pull-to-refresh", function() {
         	 var self=this;
             if(toRefresh2) return;
             toRefresh2 = true;
             setTimeout(function() {
                 initPage(listDiv2,self,2,true);//初始化tab2
             }, 1000);
         });
        
      //#tab3
        $(infDiv3).pullToRefresh({
        	distance:55
        }).on("pull-to-refresh", function() {
         	 var self=this;
             if(toRefresh3) return;
             toRefresh3 = true;
             setTimeout(function() {
                 initPage(listDiv3,self,3,true);//初始化tab3
             }, 1000);
         });
 
        
        
         // infinite
        //tab1
         $(infDiv1).infinite().on("infinite", function() {
             var self=this;
             if(loading1) return;
             loading1 = true;
             
             var ohtl='<div class="weui-loadmore btm-loadmore">' +
             '<i class="weui-loading"></i>' +
             '<span class="weui-loadmore__tips">正在加载</span>' +
             '</div>';
             var div=$(this).find(listDiv1).closest('.load-before');
             div.after(ohtl);
             
             setTimeout(function() {
            	 var thisTime=$(self).find('.mui-date').val().trim();//时间查询
                 var selectVal=$(self).find('.weui-pop-div').data('values');//选择框
            	 
            	 if(isOver1){//全部数据已经展示
            		 div.next('.btm-loadmore').remove();
                     $.toast("已加载全部",800,function(toast) {
                         loading1 = false;
                         $(self).destroyInfinite();
                     });
                 }else{
                     index1++;
                     getPages( 
                    		 'event/event_queryRemotes.action',
            	         {
		    	                 accountKey:storage.getItem('accountKey'),
		    	                 remoteType:selectVal,//拉合闸类型
		    	                 dateTime:thisTime,//时间
		    	                 pageIndex:index1,//默认页码数
		    	                 messageUpdateTime:storage.getItem('messageUpdateTime'),
            	                 rechargeUpdateTime:storage.getItem('rechargeUpdateTime')
                         },function (res) {
                         	
                             var olist=res.data.datas;
                             var oindex=res.data.pageIndex;//页码
                             var tpage=res.data.totalPage;//总页数
                             
                             $('.weui-navbar__item').find('.weui-badge').remove();//去除所有标记数字
        	                 var newmessage=res.data.newMessageCount;//短信
        	                 var newRecharge=res.data.newRechargeCount;//充值
        	                 

                             if(oindex===tpage){
                                 isOver1=true;
                             }
                             getListItem1(olist,listDiv1);

                         },function (){
                          
                             loading1 = false;
                             div.next('.btm-loadmore').remove();
                         });
                 }
                
                 
             }, 1000);
         });
         
         //tab2
         $(infDiv2).infinite().on("infinite", function() {
             var self=this;
             if(loading2) return;
             loading2 = true;
             
             var ohtl='<div class="weui-loadmore btm-loadmore">' +
             '<i class="weui-loading"></i>' +
             '<span class="weui-loadmore__tips">正在加载</span>' +
             '</div>';
             var div=$(this).find(listDiv2).closest('.load-before');
             div.after(ohtl);
             
             setTimeout(function() {
            	 var thisTime=$(self).find('.mui-date').val().trim();//时间查询
                 var selectVal=$(self).find('.weui-pop-div').data('values');//选择框
            	 
            	 if(isOver2){//全部数据已经展示
            		 div.next('.btm-loadmore').remove();
                     $.toast("已加载全部",800,function(toast) {
                         loading2 = false;
                         $(self).destroyInfinite();
                     });
                 }else{
                     index2++;
                     getPages( 
                    		 'event/event_queryRecharges.action',
            	             {
            	                 accountKey:storage.getItem('accountKey'),
            	                 paywayType:selectVal,//充值类型
            	                 dateTime:thisTime,//时间
            	                 pageIndex:index2,//默认页码数
            	                 remoteUpdateTime:storage.getItem('remoteUpdateTime'),
            	                 messageUpdateTime:storage.getItem('messageUpdateTime')
                         },function (res) {
                         	
                             var olist=res.data.datas;
                             var oindex=res.data.pageIndex;//页码
                             var tpage=res.data.totalPage;//总页数

                             if(oindex===tpage){
                                 isOver2=true;
                             }
                             getListItem2(olist,listDiv2);

                         },function (){
                            
                             loading2 = false;
                             div.next('.btm-loadmore').remove();
                         });
                 }
                
                 
             }, 1000);
         });
         
         
         //tab3
         $(infDiv3).infinite().on("infinite", function() {
             var self=this;
             if(loading3) return;
             loading3 = true;
             
             var ohtl='<div class="weui-loadmore btm-loadmore">' +
             '<i class="weui-loading"></i>' +
             '<span class="weui-loadmore__tips">正在加载</span>' +
             '</div>';
             var div=$(this).find(listDiv3).closest('.load-before');
             div.after(ohtl);
           
             
             setTimeout(function() {
            	 
            	 var thisTime=$(self).find('.mui-date').val().trim();//时间查询
                 var selectVal=$(self).find('.weui-pop-div').data('values');//选择框
            	 
            	 if(isOver3){//全部数据已经展示
            		 div.next('.btm-loadmore').remove();
                     $.toast("已加载全部",800,function(toast) {
                         loading3 = false;
                         $(self).destroyInfinite();
                     });
                 }else{
                     index3++;
                     getPages( 
                    		 'event/event_queryMessages.action',
                    		 {
            	                 accountKey:storage.getItem('accountKey'),
            	                 sendType:selectVal,//短信类型
            	                 dateTime:thisTime,//时间
            	                 pageIndex:index3,//默认页码数
            	                 remoteUpdateTime:storage.getItem('remoteUpdateTime'),
            	                 rechargeUpdateTime:storage.getItem('rechargeUpdateTime')
                         },function (res) {
                         	 
                             var olist=res.data.datas;
                             var oindex=res.data.pageIndex;//页码
                             var tpage=res.data.totalPage;//总页数

                             if(oindex===tpage){
                                 isOver3=true;
                             }
                             getListItem3(olist,listDiv3);

                         },function (){

                             loading3 = false;
                             div.next('.btm-loadmore').remove();
                         });
                 }
                
                 
             }, 1000);
         });

    })