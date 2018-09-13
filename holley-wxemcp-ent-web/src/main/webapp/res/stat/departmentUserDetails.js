 $(function() {
	
	 
        FastClick.attach(document.body);
        var storage= window.localStorage;
        storage = storage ? storage : [];
        var monthtype=parseInt(storage.getItem('detail-datatype'));
   
        var mainDiv=document.body;//下滑框
     
        var pullrefresh1=false;//下拉刷新
       
    
        var vKey=storage.getItem('accountKey');//密钥
        var noFlag='- -';
      
       function lazha(chart,setObj,vdata){
    	   setObj.clear();
    	   $(chart).find('.chart-nodata').remove();
    	   var slib=$(chart).next('.init-item');
//    	   slib.find('.init-money').text('');
//    	   slib.find('.init-upval1').text('');
//    	   slib.find('.init-upval2').text('');
    	  
    	   var vx=[],vy=[];

    	   if((vdata===null)||(vdata.ls.length===0)){
    		   $(chart).append("<p class='text-light-gray chart-nodata'>没有数据</p>");
    		   slib.find('.init-money').text(noFlag);
        	   slib.find('.init-upval1').text(noFlag);
        	   slib.find('.init-upval2').text(noFlag);
    		   setObj.hideLoading();
    	   }else{
    		   var vls=vdata.ls;//数据集合
    		   for(var i in vls){
    			   vx.push(vls[i].datename);
    			   vy.push(vls[i].energy);
    		   }
    		   
    		   setObj.setOption( {
             grid:{
                 x:60,
                 y:30,
                 x2:20,
                 y2:20,
                 borderColor: '#e5e5e5'
             },
             tooltip : {
                 trigger: 'axis',
                 axisPointer: {
                     lineStyle: {
                         "color": "#48b"
                     },
                     crossStyle:{
                         "color": "#48b"
                     }
                 }
             },
             legend: {
	                show:false
	            },
             calculable : true,
             xAxis : [
                 {
                     type: 'category',
                     data: vx,
                     axisLine: {
                         lineStyle: {
                             color: '#999',
                             width: 0.5,
                         },
                     },
                     axisLabel: {
                         color: '#999'
                     },
                     splitLine: {
                             lineStyle: {
                                 color: '#e5e5e5',
                                 width: 0.5
                             }
                         }
 
                 }
             ],
             yAxis : [
                 {
                     type: 'value',
                     name: '单位(/kWh)',
                     nameTextStyle: {
                         color:'#999',
                         fontSize: 12
                     },
                     axisLine:{
                         lineStyle:{
                             color:'#999',
                             width:1,//这里是为了突出显示加上的
                         }
                     },
                     axisLabel: {
                         color:'#999'
                     },
                     splitLine: {
                         lineStyle: {
                             color: '#e5e5e5',
                             width: 0.5,
                         }
                     }
                 }
             ],
             axis:{
                 boundaryGap: true
             },
             series : [
                 {
                     /*name:vdata.name,*/
                     type:'bar',
                    // data: vy,// var color1='#01ade1',color2='#32b16c',color3='#f19149';
                     data:function(){
	                    	var list=[];
	                    	var color1='#01ade1',color2='#32b16c',color3='#f19149';
	                    	var cr;
	                    	
	                    	for(var i in vls){
	                    		var mod=i%3;
	                    		switch (mod)
	                    		{
	                    		  case 0:
	                    			  cr=color1;
	                    			  break;
	                    		  case 1:
	                    			  cr=color2;
	                    			  break;
	                    		  default:
	                    			  cr=color3;
	                    		}
	                    		list.push({
	                    			value:vls[i].energy,
	                    			itemStyle:{ 
	                    				normal:{
	                    				  color:cr
	                    				}
	                    			}
	                    		})
	                    	}
//	                    	list.reverse();
	                    	return list;
	                    }(),
	                    barGap: '25%',
	                    barCategoryGap:'40%',
	                    itemStyle: {
	                        normal: {
	                            barBorderRadius: 4

	                        }
	                    }
 
                 }
             ]
         });
    		  
    		   setObj.hideLoading();

    	   }
    	   
       }
       
 
       function getListItem(vlist,vTart) {
    	  
    	   if((vlist.length===0)||(vlist===null)){
    		   $(vTart).html("<p class='text-light-gray chart-nodata'>没有数据</p>");
    	   }else{
           var listHtml='';
           for(var i in vlist){
        	   console.log(vlist[i]);
               listHtml+='<div class="chart-part margin-10"><h4 class="text-center bg-init padding-5 chart-title text-init list-item-name font-r1">'+
               ((vlist[i].name===null)?noFlag:vlist[i].name)+
               '</h4><div class="bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left">'+
               '<div id="chart'+i+'" class="chaet-css"></div>'+'<div class="deep-light-gray padding-5 init-item">'+
               '<div class="text-init font-18 init-item-title">当'+(monthtype>1?'月':'日')+'消耗电能<span class="text-primary init-money">'
               +(vlist[i].nowsum===null?noFlag:vlist[i].nowsum)+'</span>kWh</div><div class="weui-flex">'+
               '<div class="weui-flex__item init-item-sub"><p>同上'+(monthtype>1?'月':'日')+'增长<span class="text-red init-upval1">'+(vlist[i].upratethanla===(null||0)?noFlag:vlist[i].upratethanla)+'</span>%</p>'+'</div><div class="weui-flex__item init-item-sub text-right">'+'<p>同'+
               (monthtype>1?'去年本月':'上周本日')+
               '增长<span class="text-red init-upval2">'+(vlist[i].upratethanlala===(null||0)?noFlag:vlist[i].upratethanlala)+'</span>%</p></div></div>'+'</div></div></div>';
              
           }
           $(vTart).html(listHtml);
          
           for(var j=0;j<vlist.length;j++){   
        	   var temp='tubiao'+j;   
        	   window[temp]= echarts.init(document.getElementById('chart'+j+''));
        	   console.log(window[temp]);
        	   window[temp].showLoading({
       		   text:'正在加载'
       	       });
        	  
        	   lazha(('#chart'+j),window[temp],vlist[j]);

              }
    	   }
       }

       
       
     
        function initPage(tartId,isFresh){ //默认更新

            pullrefresh1=false;//下拉刷新
            getPages(
                'stat/stat_queryDepartmentUserDetails.action',
                {
                    accountKey:vKey,
//                    datatype:2,//数据类型
//                    datetime:'2017-09',//日期
                    datatype:monthtype,//数据类型
                    datetime:storage.getItem('detail-datetime')//日期
                   
                },function (res) {
                	var obj=res.data;
                	var ohtml='';
                	
                	getListItem(obj,'.more-chart');
                	
                	$.hideLoading();
                },function (){
                    if(isFresh){
                    	 pullrefresh1=false;
                         $(mainDiv).pullToRefreshDone();
                    	
                    }
                },function(){
                	$.hideLoading();
                });
        }
        initPage('.more-chart',false);//默认刷新界面
       
    
        
        $(mainDiv).pullToRefresh({
        	distance:55
        }).on("pull-to-refresh", function() {//下拉刷新
        	var self=this;
            if(pullrefresh1) return;
            pullrefresh1 = true;
            setTimeout(function() {
            	initPage($(self),true);//搜索出来的结果
            }, 1000);
        });
      

       
        /* 初始化表格 */
        window.onresize = function () {
            barUseChart.resize();//拉闸
            timeChart.resize();//事件
            teleCostChart.resize();//电力能耗
           
        }


    })