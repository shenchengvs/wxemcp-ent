 $(function() {
	    
//        FastClick.attach(document.body);
        var storage= window.localStorage;
        storage = storage ? storage : [];
        var pindex=1;//页码
   
        var isOver=false;//是否没有数据
        var listDiv='.more-list-content';//对象
        var infobj='.pullContent';
        var loading=false;//加载更多
        var pullrefresh=false;//下拉刷新
        var vKey=window.localStorage.getItem('accountKey');//密钥
  
        var vUnit=0;//第一级别用能单位
        var subUnit=0;//第二级别用能单位
        var searchObj='#searchInput';//搜索框对象
        var flag='- -';
        var oldPicker='全部';
        var changePicker='全部';
        
        
        var unitList=[];
        var subUnitList=[];
        
        var showList1=[];
        var showList2=[];
        var zt=0;
        $.showLoading();
        
        /*用能结构*/
        getPages(
                'data/data_subEuuMap.action',
                {
                    accountKey:vKey
                },function (res) {
                	console.log(res);
                	
                	for(var i in res.data){
                		unitList.push({
                			"parent":res.data[i].name,
                			"subeuuid":res.data[i].subeuuid
                		})
                		var vlist=[];
                		if(res.data[i].childList===null){
                			vlist.push({
                				"child":"",
                				"ownerid":res.data[i].subeuuid,
                				"subeuuid":0
                			})
                		}else{
                			for(var j in res.data[i].childList){
                				vlist.push({
                    				"child":res.data[i].childList[j].name,
                    				"ownerid":res.data[i].subeuuid,
                    				"subeuuid":res.data[i].childList[j].subeuuid
                    			});
                			}
                		}
                		subUnitList.push(vlist);//用能单位二级
                	}
                	showList1.push('全部');
                	for(var i in unitList){
                    	showList1.push(unitList[i].parent);
                    }
                	for(var j in subUnitList[zt]){
                		showList2.push(subUnitList[0][j].child);
                    }
                	$.hideLoading();
                },function (){
                	
                   
                },function (){
                	$.hideLoading();
                });

        $("#organization").picker({
            title: "用能单位",
            cols: [
                {
                    textAlign: 'center',
                    values: showList1
                }
            ],
            onOpen: function () {
                $('.part-slide-tri').removeClass('part-slide-tri-after');
                var oPar = $("#organization").closest('.part-slide-tri');
                oPar.addClass('part-slide-tri-after');
            },
            onChange: function(p, v, dv) {
            	changePicker=dv;
            },
            onClose: function(p) {
            	$('.part-slide-tri').removeClass('part-slide-tri-after');
                var oPar = $("#organization").closest('.part-slide-tri');
                oPar.removeClass('part-slide-tri-after');
                
            	if(oldPicker!=changePicker){
            	    showList2.splice(0,showList2.length);
                	var obj=$("#organization");
                    var oPar = obj.closest('.part-slide-tri');
                    oPar.removeClass('part-slide-tri-after');
                    
                    if(changePicker=='全部'){
                    	vUnit=0;
                    }else{
                        for(var i in unitList){
                     		if(unitList[i].parent==changePicker){
                     			vUnit=unitList[i].subeuuid;
                     			zt=i;
                     			break;
                     		}
                     	}
                    }
                
                    showList2.push('全部');
                 	for(var j in subUnitList[zt]){
                 		showList2.push(subUnitList[zt][j].child);
                     }
                 	if((showList2[1]==='')||(changePicker=='全部')){
                 		$(".subPicker").next('.picker-message').removeClass('hidden');
                 		$(".subPicker").addClass("hidden");
                 		subUnit=0;
                 	}else{
                 		$(".subPicker").next('.picker-message').addClass('hidden');
                 		$(".subPicker").removeClass('hidden').val(showList2[0]);
                 		subUnit=0;
              
                 		$(".subPicker").picker({
                             title: "用能单位",
                             cols: [
                                 {
                                     textAlign: 'center',
                                     values: showList2
                                 }
                             ],
                             onOpen: function () {
                                 $('.part-slide-tri').removeClass('part-slide-tri-after');
                                 var oPar = $(".subPicker").closest('.part-slide-tri');
                                 oPar.addClass('part-slide-tri-after');
                                 
                                 var vselect=$('.picker-items-col-wrapper').children('.picker-item').eq(0);
                                 if($('.picker-items-col-wrapper').find('.picker-selected').length>0){
                                	
                                 }else{
                                     vselect.addClass('picker-selected');
                                     $(".subPicker").val(vselect.text());
                                 }
                             },
                             onChange: function(p, v, dv) {

                             },
                             onClose: function(vals) {
                            	var obj=$(".subPicker");
                                var oPar = obj.closest('.part-slide-tri');
                                oPar.removeClass('part-slide-tri-after');
                              
                             	var vunit=$(".subPicker").val().trim();
                             	if(vunit=='全部'){
                             		subUnit=0;
                             	}else{
                             		var sublist=subUnitList[zt];
                                 	for(var i in sublist){
                                 		if(sublist[i].child==vunit){
                                 			subUnit=sublist[i].subeuuid;
                                 		}
                                 	}
                             	}
                            	$.showLoading();
                             	initPage($(searchObj).val(),false);//搜索出来的结果
                             }
                         });
                 	}
                 	$.showLoading();
                 	initPage($(searchObj).val(),false);//搜索出来的结果
                 	oldPicker=changePicker;
            	}
            }
        });
     
//        $.showLoading();
        function getListItem(vlist,vTart) {
            var listHtml='';
            for(var i in vlist){
                listHtml+='<a href="javascript:void(0);" class="weui-media-box weui-media-box_appmsg wui-cell-nopadding-top">'+'<div class="weui-media-box__hd weui-media-box-line"></div><div class="weui-media-box__bd"><h4 class="weui-media-box__title">'+
                ((vlist[i].point===null)?flag:vlist[i].point)+'<span class="weui-media-box__title-after text-red font-16">'+((vlist[i].data===null)?flag:vlist[i].data)+'kWh</span></h4><p class="weui-media-box__desc text-green">'+((vlist[i].ownername===null)?flag:vlist[i].ownername)+'<span class="weui-media-box__title-after text-light-gray">'+((vlist[i].dataTime===null)?flag:vlist[i].dataTime)+'</span></p></div></a>';
            }
            $(vTart).append(listHtml);
        }

       
        function initPage(oWord,isFresh){ //默认更新

            $(listDiv).children().remove();
            $(infobj).infinite();
            
            	   pindex=1;//页码
                   
                   isOver=false;//是否没有数据
                  
                   loading=false;//加载更多
                   pullrefresh=false;//下拉刷新
           
            
            getPages(
                'data/data_queryRealPowers.action',
                {
                    accountKey:vKey,
                    keyWord:oWord,//搜索关键字
                    pageIndex:pindex,
                    unit:vUnit,//整数
                    subUnit:subUnit //整数
                },function (res) {
                	console.log(res.data.datas);
                    var olist=res.data.datas;
                    var oindex=res.data.pageIndex;//页码
                    var tproperty=res.data.totalProperty;//总记录数
                    var  tpage=res.data.totalPage;//总页数

                    if(oindex===tpage){
                        isOver=true;
                    }
                    if((tproperty===0)&&(($(listDiv).children().length)===0)){//没有数据的时候
                        $(listDiv).html('<p class="nodata">没有数据</p>');
                        $.hideLoading();
                        return;
                    }else{
                        getListItem(olist,listDiv);
                        $.hideLoading();
                    }
                   
                },function (){

                    if(isFresh){
                        pullrefresh=false;
                        $(infobj).pullToRefreshDone();
                    }else{
                        loading = false;
                    }

                },function(){
                	 $.hideLoading();
                });
        }
        $.showLoading();
        initPage($(searchObj).val(),false);//默认刷新界面
        

        
        $(document).on('input',searchObj,function (e) {
            $.showLoading();
            initPage($(searchObj).val(),false);//搜索出来的结果
        })
        $('#searchClear,#searchCancel').on('click',function (e) {
        	$(searchObj).val('');
        	$.showLoading();
            initPage($(searchObj).val(),false);//搜索出来的结果
        })

        $(infobj).pullToRefresh({
        	distance:55
        }).on("pull-to-refresh", function() {//下拉刷新
        	var self=this;
            if(pullrefresh) return;
            pullrefresh = true;
            setTimeout(function() {
            	initPage($(searchObj).val(),true);//搜索出来的结果
            }, 1000);
        });
        // infinite
        $(infobj).infinite().on("infinite", function(e) {
        	e.stopPropagation();
        	
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
                    getPages( 'data/data_queryRealPowers.action',
                        {
                    	  accountKey:vKey,
                          keyWord:$(searchObj).val(),//搜索关键字
                          pageIndex:pindex,
                          unit:vUnit,//整数
                          subUnit:subUnit //整数

                        },function (res) {
                            var olist=res.data.datas;
                            var oindex=res.data.pageIndex;//页码
                            var tpage=res.data.totalPage;//总页数

                            if(oindex===tpage){
                                isOver=true;
                            }
                            getListItem(olist,listDiv);

                        },function (){
                            loading = false;
                            $('.btm-loadmore').remove();
                        });
                }
            }, 1000);
        });
       

    })