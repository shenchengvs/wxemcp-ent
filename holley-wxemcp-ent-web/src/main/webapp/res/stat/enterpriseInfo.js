 $(function() {
	  
	 
        FastClick.attach(document.body);
        var storage= window.localStorage;
        storage = storage ? storage : [];
  
        var infobj1='#tab1';
        var infobj2='#tab2';
        var timeObj="#time2";//月
        var timeObj1="#time3";//日
        var mainDiv='.pullContent';//下滑框
        var dayFlag=1;
        
    
        var pullrefresh1=false;//下拉刷新
        var pullrefresh2=false;//下拉刷新
        
        var oldTime1,oldTime2;
        
        var vKey=storage.getItem('accountKey');//密钥
        var noFlag='- -';
        
        if(storage.entType==='2'){
        	$('.nav-description').removeClass('hidden');
        	$('nav-description').removeClass('hidden');
        	$('#chart1,#chart2,#chart1-1,#chart2-1').closest('.chart-part').removeClass('hidden');
        }

        var barUseChart = echarts.init(document.getElementById('chart1'));//充值
        barUseChart.showLoading({
		   text:'正在加载'
	    })

        var timeChart = echarts.init(document.getElementById('chart2'));//事件
        timeChart.showLoading({
 		   text:'正在加载'
 	    })


        var teleCostChart = echarts.init(document.getElementById('chart3'));//电力能耗
        teleCostChart.showLoading({
  		   text:'正在加载'
  	    })

        var pieUseChart = echarts.init(document.getElementById('chart4'));//电能用途
       
        pieUseChart.showLoading({
   		   text:'正在加载'
   	    })
        
        var partmentChart = echarts.init(document.getElementById('chart5'));//部门用电
        partmentChart.showLoading({
    		   text:'正在加载'
    	})
    	
    	var barUseChart1 = echarts.init(document.getElementById('chart1-1'));//充值
        var timeChart2 = echarts.init(document.getElementById('chart2-1'));//事件
        var teleCostChart3 = echarts.init(document.getElementById('chart3-1'));//电力能耗
        var pieUseChart4 = echarts.init(document.getElementById('chart4-1'));//电能用途
        var partmentChart5 = echarts.init(document.getElementById('chart5-1'));//部门用电
       barUseChart1.showLoading({
	   text:'正在加载'
       })

       timeChart2.showLoading({
		   text:'正在加载'
	   })

       teleCostChart3.showLoading({
 		   text:'正在加载'
 	   })

       pieUseChart4.showLoading({
  		   text:'正在加载'
  	   })
       
       partmentChart5.showLoading({
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
        $(timeObj).val(getNowDate(new Date(),false));//月
        oldTime1=getNowDate(new Date(),false);//月
        $(timeObj1).val(getNowDate(new Date(),true));//日
        oldTime2=getNowDate(new Date(),true);//日
        $(timeObj).addClass('hidden');
        var isDate=$(timeObj1).val().trim();
        
        
        $(timeObj).datetimePicker({//月
        	title: '日期选择',
            monthSplit:'',
            noDay:true,
            times: function () {
              return ;
            },
            onChange: function (picker, values, displayValues) {
             
            },
            onClose:function(vals){
               var str;
               str=vals.value.join('-');//选中的日期
               if(oldTime1!=str){
            	   isDate=str;
            	   initPage('#tab2',false);//初始化tab2
            	   $.showLoading();
               	   oldTime1=str;
               	}
           },
            onOpen:function(){
        	 
              }
          });
        $(timeObj1).datetimePicker({//日
        	title: '日期选择',
            times: function () {
              return;
            },
            onChange: function (picker, values, displayValues) {
             
            },
            onClose:function(vals){
               var str;
               str=vals.value.join('-');//选中的日期
               if(oldTime2!=str){
            	   isDate=str;
            	   initPage('#tab1',false);//初始化tab1
            	   $.showLoading();
               	   oldTime2=str;
               	}
              
           },
            onOpen:function(){
        	  
              }
          });
        
    

       function chongzhi(chart,setObj,vdata){//充值记录
    	   setObj.clear();
    	   $(chart).find('.chart-nodata').remove();
    	   var slib=$(chart).next('.init-item');
    	   slib.find('.init-money').text('');
    	   slib.find('.init-upval1').text('');
    	   slib.find('.init-upval2').text('');
    	  
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
    			   vx.push(vls[i].name);
    			   vy.push(vls[i].money);
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
                     name: '单位(/元)',
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
                	 type:'bar',
//                     name:'充值记录',
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
	                    			value:vls[i].money,
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
    		   slib.find('.init-money').text(vdata.nowRechargeMoney);
        	   slib.find('.init-upval1').text((vdata.upRateThanLa==0)?noFlag:vdata.upRateThanLa);
        	   slib.find('.init-upval2').text((vdata.upRateThanLaLa==0)?noFlag:vdata.upRateThanLaLa);
    		   setObj.hideLoading();

    	   }
    	   
       }
       
       function shijian(chart,setObj,vdata){//事件
    	   setObj.clear();
    	   $(chart).find('.chart-nodata').remove();
    	   
    	   var vx=[],vy=[];
    	   var slib=$(chart).next('.init-item');
    	   slib.removeClass('hidden');
    	   
    	   if((vdata===null)||(vdata.ls.length===0)){
    		   $(chart).append("<p class='text-light-gray chart-nodata'>没有数据</p>");
    		   slib.addClass('hidden');
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
    	                    data:vx,
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
    	                    lineStyle: {
    	                        color: '#e5e5e5',
    	                        width: 0.5,
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
//    	                    name:'事件统计',
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
//    	                    	list.reverse();
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
      
       
       function dianli(chart,setObj,vdata){//电力能耗
    	   setObj.clear();
    	   $(chart).find('.chart-nodata').remove();
    	   var slib=$(chart).next('.init-item');
    	 
    	   slib.find('.init-money').text('');
    	   slib.find('.init-upval1').text('');
    	   slib.find('.init-upval2').text('');
    	  
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
    			   vx.push(vls[i].name);
    			   vy.push(vls[i].consumption);
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
    	                    lineStyle: {
    	                        color: '#e5e5e5',
    	                        width: 0.5,
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
//    	                    name:'电力能耗',
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
    	                    			value:vls[i].consumption,
    	                    			itemStyle:{ 
    	                    				normal:{
    	                    				  color:cr
    	                    				}
    	                    			}
    	                    		})
    	                    	}
//    	                    	list.reverse();
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
    		 
    		   setObj.resize();
    	
    		   slib.find('.init-money').text(vdata.nowsum);
        	   slib.find('.init-upval1').text((vdata.upratethanla==0)?noFlag:vdata.upratethanla);
        	   slib.find('.init-upval2').text((vdata.upratethanlala==0)?noFlag:vdata.upratethanlala);
    		   setObj.hideLoading();

    	   }
    	   
       }
       
       
       function yongtu(chart,setObj,vdata){//电能用途
    	  
    	   setObj.clear();
    	   $(chart).find('.chart-nodata').remove();
    	   
    	   var slib=$(chart).next('.init-item');
    	   slib.removeClass('hidden');
    	   
    	   if((vdata===null)||(vdata.ls.length===0)){
    		   $(chart).append("<p class='text-light-gray chart-nodata'>没有数据</p>");
        	   slib.addClass('hidden');
    		   setObj.hideLoading();
    	   }else{

    		   var vls=vdata.ls;//数据集合    		   
    		   setObj.setOption(  {
    	            color: [
    	                "#32b16c",
    	                "#f0423e",
    	                "#00b7ee",
    	                "#f0bd26",
    	                "#bfbfbf"
    	            ],
    	            tooltip : {
    	                trigger: 'item',
    	                formatter: "{a} <br/>{b} : {c} ({d}%)"
    	            },
    	            legend: {
    	                orient : 'vertical',
//    	                x : 'left',
    	                right:'2%',
    	                top:'center',
    	                itemGap:5,
    	                formatter:function (vname) {
    	                	var index;
    	                	 for(var i in vls){
    	                        if(vls[i].name == vname){
    	                            index = i;
    	                            break;
    	                        }
    	                    };
    	                    return vname+''+(vls[index].baifenshu)+'%';
    	                },
    	                data:(function(){
    	                    var vx = [];
    	                    for(var i in vls){
    	         			   vx.push(vls[i].name);  
    	         		      }
    	                     return vx;
    	                })(),
    	                textStyle: {
    	                    color: 'auto'
    	                }
    	            },
    	            calculable : true,
    	            series : [
    	                {
    	                    name:'电能用途',
    	                    type:'pie',
    	                    radius : '60%',
    	                    center: ['35%', '50%'],
//    	                    label:{           
//                                normal:{
//                                    show:true,
//                                    position:'inner', //标签的位置
//                                    textStyle : {
//                                        fontWeight : 300 ,
//                                        fontSize : 16    //文字的字体大小
//                                    },
//                                    formatter:'{d}%'
//
//                                    
//                                }
//                            },
    	                    data:(function(){ 
    	                    	  var list=[];
    	               	          for(var i in vls){
    	               		       list.push({
    	               		    	   	value:vls[i].baifenshu,
    	               		    	   	name:vls[i].name
    	               		       })
    	               	          }
    	               	          return list;
    	               	      	 })()
//    	                    data:[{value: 69.11, name: "动力"},{value: 30.88, name: "照明"}]

    	                }
    	            ]
    	        });
    		  
    		   setObj.hideLoading();
    		  

    	   }
    	   
       }
       
       function bumen(chart,setObj,vdata){//部门用电
    	   setObj.clear();
    	   $(chart).find('.chart-nodata').remove();
    	   var slib=$(chart).next('.init-item');
    	   slib.removeClass('hidden');
    	  
    	   var vx=[],vy=[];
    	   
    	   
    	   if((vdata===null)||(vdata.ls.length===0)){
    		   $(chart).append("<p class='text-light-gray chart-nodata'>没有数据</p>");
    		   slib.addClass('hidden');
    		   setObj.hideLoading();
    	   }else{
    		   var vls=vdata.ls;//数据集合
    		   for(var i in vls){
    			   vx.push(vls[i].name);
    			   vy.push(vls[i].energyuse);
    		   }
    		   
    		   setObj.setOption(  {
    		        
    	            tooltip: {
    	                trigger: 'axis',
    	                axisPointer: {
    	                    type: 'shadow'
    	                }
    	            },
    	            legend: {
    	                show:false
    	            },
    	            grid: {
    	                x:10,
    	                y:15,
    	                x2:25,
    	                y2:8,
    	                borderColor: '#0b4795',
    	                containLabel: true
    	            },
    	            xAxis: {
    	                type: 'value',
//    	                position: 'top',
    	                boundaryGap: [0, 0.01],
    	                axisLabel: {
    	                    color: '#999'
    	                },
    	                lineStyle: {
    	                    color: '#e5e5e5',
    	                    width: 0.5,
    	                },
    	                axisLine:{
    	                    lineStyle:{
    	                        color:'#999',
    	                        width:1,//这里是为了突出显示加上的
    	                    }
    	                },
    	                splitLine: {
    	                    lineStyle: {
    	                        color: '#e5e5e5',
    	                        width: 0.5,
    	                    }
    	                }
    	            },
    	            yAxis: {
    	                type: 'category',
    	                axisLabel: {
    	                    color: '#999'
    	                },
    	                data:vx.reverse(),
    	                axisLine:{
    	                    lineStyle:{
    	                        color:'#999',
    	                        width:1,//这里是为了突出显示加上的
    	                    }
    	                },
    	                splitLine: {
    	                    lineStyle: {
    	                        color: '#e5e5e5',
    	                        width: 0.5,
    	                    }
    	                }
    	            },
    	            series: [
    	                {
//    	                    name: '2011年',
    	                    type: 'bar',
//    	                    data: [{
//    	                        value:1303,
//    	                        itemStyle:{ normal:{color:'#01ade1'}}
//    	                    },{
//    	                        value:5303,
//    	                        itemStyle:{ normal:{color:'#32b16c'} }
//    	                    }, {
//    	                        value:1303,
//    	                        itemStyle:{ normal:{color:'#f19149'} }
//    	                    }],
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
    	                    			value:vls[i].energyuse,
    	                    			itemStyle:{ 
    	                    				normal:{
    	                    				  color:cr
    	                    				}
    	                    			}
    	                    		})
    	                    	}
    	                    	list.reverse();
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
        
        
        function initPage(tartId,isFresh){ //默认更新

            pullrefresh1=false;//下拉刷新
            pullrefresh2=false;//下拉刷新       
        	
 
            getPages(
                'stat/stat_queryStatistics.action',
                {
                    accountKey:vKey,
                    datatype:dayFlag,//数据类型
                    datetime:isDate//日期
//                    datatype:2,
//                    datetime:'2017-06-05'
                },function (res) {
                	var obj=res.data;
                	$(tartId).find('.arrearage-user1').text((obj.owingusers)===null?'':obj.owingusers);
                	$(tartId).find('.own-money1').text((obj.owingmoney)===null?'':obj.owingmoney);
                	$(tartId).find('.total-money1').text((obj.remainingmoney)===null?'':obj.remainingmoney);
                	console.log(dayFlag)
                	if(dayFlag===1){
                		chongzhi('#chart1',barUseChart,obj.rechargeMoneyBlock);
                		shijian('#chart2',timeChart,obj.eventCountBlock);
                		dianli('#chart3',teleCostChart,obj.electricalConsumptionBlock);
                		yongtu('#chart4',pieUseChart,obj.energyUserBlock);
                		bumen('#chart5',partmentChart,obj.departmentUseBlock);
                		
                	}else{
                		chongzhi('#chart1-1',barUseChart1,obj.rechargeMoneyBlock);
                		shijian('#chart2-1',timeChart2,obj.eventCountBlock);
                		dianli('#chart3-1',teleCostChart3,obj.electricalConsumptionBlock);
                		yongtu('#chart4-1',pieUseChart4,obj.energyUserBlock);
                		bumen('#chart5-1',partmentChart5,obj.departmentUseBlock);
                	}
                	$.hideLoading();
                },function (){
                    if(isFresh){
                    	if(dayFlag===1){
                    		 pullrefresh1=false;
                    		 $(infobj1).pullToRefreshDone();
                    	}else{
                    		pullrefresh2=false;
                    		$(infobj2).pullToRefreshDone();
                    	}
        
                    }
                },function(){
                	$.hideLoading();
                });
        }
        initPage('#tab1',false);//默认刷新界面
       
        var temp=1;
        $('.weui-navbar__item').on('click',function(){
        	dayFlag=1;
        	isDate=$(timeObj1).val().trim();
        	$('.time-to-picker').removeClass('hidden');
        	
        	if($(this).attr('role')==='1'){//日报
        		$(timeObj).addClass('hidden');
        	}else{//月报
        		dayFlag=2;
        		isDate=$(timeObj).val().trim();
        		$(timeObj1).addClass('hidden');
                if(temp===1){
                	
        		       initPage('#tab2',false);//默认刷新界面
                       temp++;
                      
                }
        		
        	}
        })
        
        $(infobj1).pullToRefresh({
        	distance:55
        }).on("pull-to-refresh", function() {//下拉刷新
        	var self=this;
            if(pullrefresh1) return;
            pullrefresh1 = true;
            setTimeout(function() {
            	initPage($(self),true);//搜索出来的结果
            }, 1000);
        });
        $(infobj1).pullToRefresh({
        	distance:55
        }).on("pull-to-refresh", function() {//下拉刷新
        	var self=this;
            if(pullrefresh2) return;
            pullrefresh2 = true;
            setTimeout(function() {
            	initPage($(self),true);//搜索出来的结果
            }, 1000);
        });
        
       $('.more-detail').on("click",function(e){
    	   storage.setItem('detail-datatype',dayFlag);//日期类型
    	   storage.setItem('detail-datetime',isDate);//日期
       })
//        // infinite
//        $(infobj).infinite().on("infinite", function() {
//        	
//            var self=$(this);
//            if(loading) return;
//            loading = true;
//            var ohtl='<div class="weui-loadmore btm-loadmore">' +
//                '<i class="weui-loading"></i>' +
//                '<span class="weui-loadmore__tips">正在加载</span>' +
//                '</div>';
//            $('.weui-panel_access').append(ohtl);
//            setTimeout(function() {
//                if(isOver){//全部数据已经展示
//                    $('.btm-loadmore').remove();
//                    $.toast("已加载全部", function(toast) {
//                        loading = false;
//                        self.destroyInfinite();
//                    });
//                }else{
//                    pindex++;
//                    getPages( 'data/data_queryRealPowers.action',
//                        {
//                    	  accountKey:vKey,
//                          keyWord:$(searchObj).val(),//搜索关键字
//                          pageIndex:pindex,
//                          unit:vUnit,//整数
//                          subUnit:subUnit //整数
//
//                        },function (res) {
//                            var olist=res.data.datas;
//                            var oindex=res.data.pageIndex;//页码
//                            var tpage=res.data.totalPage;//总页数
//
//                            if(oindex===tpage){
//                                isOver=true;
//                            }
//                            getListItem(olist,listDiv);
//
//                        },function (){
//                            loading = false;
//                            $('.btm-loadmore').remove();
//                        });
//                }
//            }, 1000);
//        });
       
        /* 初始化表格 */
        window.onresize = function () {
            barUseChart.resize();//充值
            timeChart.resize();//事件
            teleCostChart.resize();//电力能耗
            pieUseChart.resize();//电力用途
            partmentChart.resize();//部门用电
            
            barUseChart1.resize();//充值
            timeChart2.resize();//事件
            teleCostChart3.resize();//电力能耗
            pieUseChart4.resize();//电力用途
            partmentChart5.resize();//部门用电
        }


    })