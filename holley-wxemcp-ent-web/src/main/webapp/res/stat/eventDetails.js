 $(function() {
	 
	   
        FastClick.attach(document.body);
        var storage= window.localStorage;
        storage = storage ? storage : [];
        var monthtype=parseInt(storage.getItem('detail-datatype'));
    
        $('.day-type').text(monthtype>1?'月':'日');
        
        $('.day-compare').text(monthtype>1?'去年本月':'上周本日');
  
       
        var mainDiv=document.body;//下滑框
     
        var pullrefresh1=false;//下拉刷新
       
    
        var vKey=storage.getItem('accountKey');//密钥
        var flag='- -';
        console.log(storage);
       

        var barUseChart = echarts.init(document.getElementById('chart1'));//拉闸
        barUseChart.showLoading({
		   text:'正在加载'
	    })

        var timeChart = echarts.init(document.getElementById('chart2'));//充值
        timeChart.showLoading({
 		   text:'正在加载'
 	    })


        var teleCostChart = echarts.init(document.getElementById('chart3'));//催费
        teleCostChart.showLoading({
  		   text:'正在加载'
  	    })

     
  


        /* 默认日期为当前年月 */
        function getNowDate(xDate,isDay){
            var oMonth=xDate.getMonth()+1;
            if(oMonth<10){
                oMonth='0'+oMonth;
            }
            if(isDay){
            	var vday=(xDate.getDate()<10)?('0'+xDate.getDate()):xDate.getDate();
            	timestr=xDate.getFullYear()+'-'+(oMonth)+'-'+(vday)+' ';
                return timestr;
            }else{
            	timestr=xDate.getFullYear()+'-'+(oMonth);
                return timestr;
            }  
        }
   
       function lazha(chart,setObj,vdata){//拉闸次数
    	   setObj.clear();
    	   $(chart).find('.chart-nodata').remove();
    	   var slib=$(chart).next('.init-item');
    	   slib.find('.init-money').text('');
    	   slib.find('.init-upval1').text('');
    	   slib.find('.init-upval2').text('');
    	  
    	   var vx=[],vy=[];

    	   if((vdata===null)||(vdata.ls.length===0)){
    		   $(chart).append("<p class='text-light-gray chart-nodata'>没有数据</p>");
    		   slib.find('.init-money').text(flag);
        	   slib.find('.init-upval1').text(flag);
        	   slib.find('.init-upval2').text(flag);
    		   setObj.hideLoading();
    	   }else{
    		   var vls=vdata.ls;//数据集合
    		   for(var i in vls){
    			   vx.push(vls[i].name);
    			   vy.push(vls[i].count);
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
                     name: '单位(/次)',
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
//                     name:'拉闸次数',
                     type:'bar',
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
	                    			value:vls[i].count,
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
    		   slib.find('.init-money').text(vdata.nowcount);
        	   slib.find('.init-upval1').text((vdata.upratethanla==0)?flag:vdata.upratethanla);
        	   slib.find('.init-upval2').text((vdata.upratethanlala==0)?flag:vdata.upratethanlala);
    		   setObj.hideLoading();

    	   }
    	   
       }
       
       
       function chongzhi(chart,setObj,vdata){//充值次数
    	   setObj.clear();
    	   $(chart).find('.chart-nodata').remove();
    	   var slib=$(chart).next('.init-item');
    	   slib.find('.init-money').text('');
    	   slib.find('.init-upval1').text('');
    	   slib.find('.init-upval2').text('');
    	  
    	   var vx=[],vy=[];

    	   if((vdata===null)||(vdata.ls.length===0)){
    		   $(chart).append("<p class='text-light-gray chart-nodata'>没有数据</p>");
    		   slib.find('.init-money').text(flag);
        	   slib.find('.init-upval1').text(flag);
        	   slib.find('.init-upval2').text(flag);
    		   setObj.hideLoading();
    	   }else{
    		   var vls=vdata.ls;//数据集合
    		   for(var i in vls){
    			   vx.push(vls[i].name);
    			   vy.push(vls[i].count);
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
                     name: '单位(/次)',
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
//                     name:'充值次数',
                     type:'bar',
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
	                    			value:vls[i].count,
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
    		   slib.find('.init-money').text(vdata.nowcount);
        	   slib.find('.init-upval1').text((vdata.upratethanla==0)?flag:vdata.upratethanla);
        	   slib.find('.init-upval2').text((vdata.upratethanlala==0)?flag:vdata.upratethanlala);
    		   setObj.hideLoading();

    	   }
    	   
       }
       
       function cuifei(chart,setObj,vdata){//催费次数
    	   setObj.clear();
    	   $(chart).find('.chart-nodata').remove();
    	   var slib=$(chart).next('.init-item');
    	   slib.find('.init-money').text('');
    	   slib.find('.init-upval1').text('');
    	   slib.find('.init-upval2').text('');
    	  
    	   var vx=[],vy=[];

    	   if((vdata===null)||(vdata.ls.length===0)){
    		   $(chart).append("<p class='text-light-gray chart-nodata'>没有数据</p>");
    		   slib.find('.init-money').text(flag);
        	   slib.find('.init-upval1').text(flag);
        	   slib.find('.init-upval2').text(flag);
    		   setObj.hideLoading();
    	   }else{
    		   var vls=vdata.ls;//数据集合
    		   for(var i in vls){
    			   vx.push(vls[i].name);
    			   vy.push(vls[i].count);
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
                     name: '单位(/次)',
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
//                     name:'催费次数',
                     type:'bar',
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
	                    			value:vls[i].count,
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
    		   slib.find('.init-money').text(vdata.nowcount);
        	   slib.find('.init-upval1').text((vdata.upratethanla==0)?flag:vdata.upratethanla);
        	   slib.find('.init-upval2').text((vdata.upratethanlala==0)?flag:vdata.upratethanlala);
    		   setObj.hideLoading();

    	   }
    	   
       }
       
       
     
        function initPage(tartId,isFresh){ //默认更新

            pullrefresh1=false;//下拉刷新
           
            getPages(
                'stat/stat_queryEventDetails.action',
                {
                    accountKey:vKey,
                    datatype:monthtype,//数据类型
                    datetime:storage.getItem('detail-datetime')//日期
                },function (res) {
                	var obj=res.data;
                	lazha('#chart1',barUseChart,obj.laZhaCountBlock);//拉闸次数
                	chongzhi('#chart2',timeChart,obj.rechargeCountBlock);//充值次数
                	cuifei('#chart3',teleCostChart,obj.cuiFeiCountBlock);//催费次数
                	
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
      
       
       $('.more-detail').on("click",function(e){
    	   storage.setItem('detail-datatype',dayFlag);//日期类型
    	   storage.setItem('detail-datetime',isDate);//日期
       })

        /* 初始化表格 */
        window.onresize = function () {
            barUseChart.resize();//拉闸
            timeChart.resize();//事件
            teleCostChart.resize();//电力能耗
           
        }


    })