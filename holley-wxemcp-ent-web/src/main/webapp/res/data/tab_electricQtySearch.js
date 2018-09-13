 $(function() {
	    
//        FastClick.attach(document.body);
        var storage= window.localStorage;
        storage = storage ? storage : [];
        var pindex=1;//页码
   
        var isOver=false;//是否没有数据
        var listDiv='.more-list-content';//对象
//        var infobj='#tab1';
        var mainDiv='.pullContent';//下滑框
        var timeObj="#time2";
        var timeObj1="#time3";
        var exactTime=".time-to-picker";
        var loading=false;//加载更多
        var pullrefresh=false;//下拉刷新
        var isMonth=1;
        var vKey=window.localStorage.getItem('accountKey');//密钥
        var selectTime=timeObj;
  
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
        /*  默认日期为当前年月 */
        function getNowDate(xDate,isDay){
            var oMonth=xDate.getMonth()+1;
            if(oMonth<10){
                oMonth='0'+oMonth;
            }
            if(isDay){
            	var vday=(xDate.getDay()<10)?('0'+xDate.getDay()):xDate.getDay();
            	timestr=xDate.getFullYear()+'-'+(oMonth)+'-'+(vday)+' ';
                return timestr;
            }else{
            	timestr=xDate.getFullYear()+'-'+(oMonth);
                return timestr;
            }
            
        }
        var oldTime1=getNowDate(new Date());
        $(timeObj).val(getNowDate(new Date(),false));
        $(timeObj1).val(getNowDate(new Date(),true));
        $(timeObj1).addClass('hidden');
        
        /*终端在线*/
        getPages(
                'data/data_rtuPointCount.action',
                {
                    accountKey:vKey,
                    type:1    
                },function (res) {
                	for(var i in res.data){
                		$('.rtuCount').text((res.data.rtuCount===null)?'0':res.data.rtuCount);
                		$('.pointCount').text((res.data.pointCount===null)?'0':res.data.pointCount);
                		$('.onlineRtuCount').text((res.data.onlineRtuCount===null)?'0':res.data.onlineRtuCount);
                		$('.unRealCount').text((res.data.unRealCount===null)?'0':res.data.unRealCount);
                	}
                	$.hideLoading();
                },function (){
          
                },function (){
                	$.hideLoading();
                });
        
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
     

        function getListItem(vlist,vTart) {
            var listHtml='';
            for(var i in vlist){
                listHtml+='<tr >'+'<td>'+
                ((vlist[i].point===null)?flag:vlist[i].point)+'</td><td>'+((vlist[i].startBm===null)?flag:vlist[i].startBm)+'</td><td>'+((vlist[i].endBm===null)?flag:vlist[i].endBm)+'</td><td>'+((vlist[i].multiplyingPower===null)?flag:vlist[i].multiplyingPower)+'</td><td>'+((vlist[i].data===null)?flag:vlist[i].data)+'</td></tr>';
            }
            $(vTart).append(listHtml);
        }

     
        function initPage(oWord,isFresh){ //默认更新

            $(listDiv).children().remove();
            $(mainDiv).infinite();
           
            	   pindex=1;//页码
                   isOver=false;//是否没有数据
                   loading=false;//加载更多
                   pullrefresh=false;//下拉刷新
         
            getPages(
                'data/data_queryPowers.action',
                {
                    accountKey:vKey,
                    keyWord:oWord,//搜索关键字
                    pageIndex:pindex,
                    dateTime:$(selectTime).val().trim(),
                    dateType:isMonth,
                    unit:vUnit,//整数
                    subUnit:subUnit //整数
                },function (res) {
                	
                    var olist=res.data.datas;
                    var oindex=res.data.pageIndex;//页码
                    var tproperty=res.data.totalProperty;//总记录数
                    var  tpage=res.data.totalPage;//总页数

                    if(oindex===tpage){
                        isOver=true;
                    }
                    if((tproperty===0)&&(($(listDiv).children().length)===0)){//没有数据的时候
                        $(listDiv).html('<tr><td colspan="5" class="nodata">没有数据</td></tr>');
                        $.hideLoading();
                        return;
                    }else{
                        getListItem(olist,listDiv);
                        $.hideLoading();
                    }
                   
                },function (){

                    if(isFresh){
                        pullrefresh=false;
                        $(mainDiv).pullToRefreshDone();
                    }else{
                        loading = false;
                    }

                },function (){
                	 $.hideLoading();
                });
        }
       $.showLoading();
       initPage($(searchObj).val(),false);//默认刷新界面
        
       $('.weui-agree').on('click',function(e){
    	   isMonth=1;
    	   var obj=$(this).children("input[type='checkbox']");
    	   $(exactTime).removeClass('hidden');
    	   if(obj.prop('checked')){//确定选择日
    		  $(timeObj).addClass('hidden');
    		  isMonth=2;
    		  selectTime=timeObj1;
    	   }else{
     		  $(timeObj1).addClass('hidden');
     		 selectTime=timeObj;
    	   }
       })
        
        
        $(timeObj).datetimePicker({
        	title: '日期选择',
            monthSplit:'',
            noDay:true,
            times: function () {
              return ;
            },
            onChange: function (picker, values, displayValues) {
             
            },
            onClose:function(vals){
              var oPar = $(timeObj).closest('.part-slide-tri');
               oPar.removeClass('part-slide-tri-after');
               var str;
               str=vals.value.join('-');//选中的日期
               if(oldTime1!=str){
            	   $.showLoading();
            	   initPage($(searchObj).val(),false);//初始化tab1
               	   oldTime1=str;
               	}
              
           },
            onOpen:function(){
        	  $('.part-slide-tri').removeClass('part-slide-tri-after');
              var oPar = $(timeObj).closest('.part-slide-tri');
              oPar.addClass('part-slide-tri-after');
              }
          });
        
        $(timeObj1).datetimePicker({
        	title: '日期选择',
            times: function () {
              return;
            },
            onChange: function (picker, values, displayValues) {
             
            },
            onClose:function(vals){
              var oPar = $(timeObj).closest('.part-slide-tri');
               oPar.removeClass('part-slide-tri-after');
               var str;
               str=vals.value.join('-');//选中的日期
               if(oldTime1!=str){
            	   $.showLoading();
            	   initPage($(searchObj).val(),false);//初始化tab1
               	   oldTime1=str;
               	}
              
           },
            onOpen:function(){
        	  $('.part-slide-tri').removeClass('part-slide-tri-after');
              var oPar = $(timeObj).closest('.part-slide-tri');
              oPar.addClass('part-slide-tri-after');
              }
          });
        
        $(document).on('input',searchObj,function (e) {         
                $.showLoading();
                initPage($(searchObj).val(),false);//搜索出来的结果   
        })
        $('#searchClear,#searchCancel').on('click',function (e) {
        	$(searchObj).val('');
        	$.showLoading();
            initPage($(searchObj).val(),false);//搜索出来的结果
        })

        $(mainDiv).pullToRefresh({
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
        $(mainDiv).infinite().on("infinite", function() {
        	
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
                    getPages( 'data/data_queryPowers.action',
                        {
                    	  accountKey:vKey,
                          keyWord:$(searchObj).val(),//搜索关键字
                          dateTime:$(selectTime).val().trim(),
                          pageIndex:pindex,
                          dateType:isMonth,
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
                        },function (){
                        	
                        });
                }
            }, 1000);
        });
       

    })