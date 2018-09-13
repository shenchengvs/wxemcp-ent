$(function() {
	   
        FastClick.attach(document.body);
        var pindex=1;//页码
        var statusList1=[],statusList2=[];
        var total1=0,total2=0;
        var listDiv='.more-list-content';//对象
        var mainDiv=document.body;
        var pullrefresh;
        var loading;
        var isOver;//是否没有数据
        var flag='- -';
        
        function getStatusList(type,getlist){
        	if(type===1){                //状态为1
        		statusList1.push({
        			"type":type,
        			"objid":getlist.objid,
        			"objtype":getlist.objtype,
        			"eventparamid":getlist.eventparamid,
        			"occurtimeStr":getlist.occurtimeStr
        		})
        		total1++;
        		return;
        	}else{
        		statusList2.push({
        			"type":type,
        			"objid":getlist.objid,
        			"objtype":getlist.objtype,
        			"eventtimeStr":getlist.eventtimeStr,
        			"eventitemid":getlist.eventitemid,
        			"status":getlist.status
        		})
        		total2++;
        	}
        }
        
        function objData(type,sum){
        	 if(type==1){
          		  return {
          			"accountKey":window.localStorage.getItem('accountKey'),
          			"type":type,
          			"objid":statusList1[sum].objid,
        			"objtype":statusList1[sum].objtype,
        			"eventparamid":statusList1[sum].eventparamid,
        			"occurtime":statusList1[sum].occurtimeStr
          		  }
          	  }else{
          		  return {
          			"accountKey":window.localStorage.getItem('accountKey'),
          			"type":type,
          			"objid":statusList2[sum].objid,
        			"objtype":statusList2[sum].objtype,
        			"eventtime":statusList2[sum].eventtimeStr,
        			"eventitemid":statusList2[sum].eventitemid,
        			"status":statusList2[sum].status
          		  }
          	  }
        }
        
        function aItemClick(){
        	 $('.more-list-content > a.weui-media-box_appmsg').off('click');
        	 
        	 var obj;
        	 $('.more-list-content > a.weui-media-box_appmsg').on('click',function(e){
        	  e.preventDefault();
           	  var showListItem='';
           	  showListItem= "<div><ul clas='show-alert-box' style='list-style: none;text-align:left'>";
           	  console.log($(this).data("type")+' '+$(this).data("sum")+'pindex '+pindex);
           	  
           	  if($(this).data("type")===1){
           		  
           	  }else{
           		 /* console.log(statusList2[$(this).data("sum")])*/
           	  }
           	 /* return false;*/
	           	obj=objData($(this).data("type"),$(this).data("sum"));
	            var xhtml='';
	           
           	    getPages(                                    //事件详情
                      'event/event_queryEventDetail.action',obj,
                      function (res) {
                      	console.log(res);
                      	
                 		  xhtml+="<li style='padding:5px 0'>" +
      	            		  		"<span>" +
      	            		  	     "事件描述"+
      	            		  		"</span>:" +
      	            		  		"<span style='margin-left:10px'>" +
      	            		  		res.data.eventNote +
      	            		  		"</span>"+
             		  			"</li>"+
             		  			"<li style='padding:5px 0'>" +
	  	            		  		"<span>" +
	  	            		  		"事件时间"+
	  	            		  		"</span>:" +
	  	            		  		"<span style='margin-left:10px'>" +
	  	            		  		res.data.eventTimeStr+
	  	            		  		"</span>"+
  	            		  		"</li>"+
	  	            		  	"<li style='padding:5px 0'>" +
		            		  		"<span>" +
		            		  		"事件内容"+
		            		  		"</span>:" +
		            		  		"<span style='margin-left:10px'>" +
		            		  		res.data.eventContent+
		            		  		"</span>"+
		            		  	"</li>";
                     	
                 		      showListItem+=xhtml+"</ul></div>";
                 		      $.modal({
                                 title: "详细信息",
                                 text: showListItem,
                                 buttons: [
                                   { text: "确定", className: "text-primary"},
                                 ]
                               });
              
                      },function (){
                         

                      },function(){
                      	
               });
           	  
           })
        }
        
        function getListItem(vlist,vTart) {
            var listHtml='';
            for(var i in vlist){
                var xtime=((vlist[i].dataTime===null)?flag:vlist[i].dataTime);
               /* var finalTime=xtime.substring(0,xtime.indexOf(' '));*/
                
                listHtml+='<a href="javascript:void(0);" class="weui-media-box weui-media-box_appmsg wui-cell-nopadding-top" data-type='+vlist[i].type+' data-sum='+ ((vlist[i].type===1)?total1:total2) +'>'+' <div class="weui-media-box__bd"><p class="weui-media-box__desc text-green remind-title">'+
                    ((vlist[i].eventDesc===null)?flag:vlist[i].eventDesc)+'</p></div><div class="weui-media-box__hd weui-media-box__desc white-nowrap weui-media-box-width margin-l5">'+(xtime)+'</div></a>';
                getStatusList(vlist[i].type,vlist[i]);
            }
            $(vTart).append(listHtml);   
        }
        
        

        function initPage(isFresh){ //默认更新

            $(listDiv).children().remove();
           

            isOver=false;//重置有无数据标记
            loading = false;//重置加载更多标记
            pullrefresh=false;//重置下拉刷新标记
            pindex=1;//重置页码
            
            statusList1=[];
            statusList2=[];
            total1=0;
            total2=0;

            getPages(                //事件记录
            'event/event_queryEvents.action',
            {
                accountKey:window.localStorage.getItem('accountKey'),
                pageIndex:pindex
            },function (res) {
            	console.log(res)
            	$('.yesterday-events').text(res.data.yesterdayCount);//昨日事件数
            	$('.today-events').text(res.data.todayCount);//昨日事件数
            	
                var olist=res.data.datas;
                var oindex=res.data.pageIndex;//页码
                var tproperty=res.data.totalProperty;//总记录数
                var tpage=res.data.totalPage;//总页数

                if(oindex===tpage){
                    isOver=true;
                }
                if((tproperty===0)&&(($(listDiv).children().length)===0)){//没有数据的时候
                    $(listDiv).html('<p class="nodata">没有数据</p>');
                    $.hideLoading();
                    return;
                }else{
                    getListItem(olist,listDiv);
                    aItemClick();
                    $.hideLoading();
                }
    
            },function (){
                if(isFresh){
                    pullrefresh=false;
                    $(mainDiv).pullToRefreshDone();  
                }
                loading = false;

            },function(){
            	$.hideLoading();
            });
       }
       $.showLoading();
       initPage(false);

        $(mainDiv).pullToRefresh({
        	distance:55
        }).on("pull-to-refresh", function() {//下拉刷新
            if(pullrefresh) return;
            pullrefresh = true;
            setTimeout(function() {
            	$(mainDiv).infinite();
                initPage(true); 
            }, 1000);
        });
   
        $(mainDiv).infinite().on("infinite", function() {
        	if(pullrefresh) return;
            var self=$(this);
            if(loading) return;
            loading = true;
            var ohtl='<div class="weui-loadmore btm-loadmore">' +
                '<i class="weui-loading"></i>' +
                '<span class="weui-loadmore__tips">正在加载</span>' +
                '</div>';
            $('.load-before').after(ohtl);
            setTimeout(function() {
            	
                if(isOver){//全部数据已经展示
                    $('.btm-loadmore').remove();
                    $.toast("已加载全部",800,function(toast) {
                        loading = false;
                        self.destroyInfinite();
                    });
                }else{
                    pindex++;
                    getPages( 'event/event_queryEvents.action',
                        {
                            pageIndex:pindex,
                            accountKey:window.localStorage.getItem('accountKey')
                        },function (res) {
                            console.log(res)
                            var olist=res.data.datas;
                            var oindex=res.data.pageIndex;//页码
                            var tpage=res.data.totalPage;//总页数

                            if(oindex===tpage){
                                isOver=true;
                            }
                            getListItem(olist,listDiv);
                            aItemClick();

                        },function (){
                            loading = false;
                            $('.btm-loadmore').remove();
                        });
                }
            }, 1000);
        });
        
        

    })