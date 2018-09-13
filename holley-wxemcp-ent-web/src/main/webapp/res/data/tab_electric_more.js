 $(function() {
//        
        var storage= window.localStorage;
        storage = storage ? storage : [];
        var pindex=1;//页码
   
        var isOver=false;//是否没有数据
        var listDiv='.more-list-content';//对象
        var mainDiv=document.body;//下滑框
//        var loading=false;//加载更多
        var pullrefresh=false;//下拉刷新
        var vKey=storage.getItem('accountKey');//密钥
        var flag='- -';
  
        var vUnit=0;//第一级别用能单位
        var subUnit=0;//第二级别用能单位
        var searchObj='#searchInput';//搜索框对象
        
        
        var unitList=[];
        var subUnitList=[];
        
        var showList1=[];
        var showList2=[];
        var zt=0;
       
        function getListItem(vlist,vTart) {
            var listHtml='';
          
            for(var i in vlist){
                listHtml+='<div class="weui-cell bg-init wui-cell-noborder wui-cell-nopadding-top wui-cell-nopadding-left noOut">'+
                                '<div class="weui-cell__bd"><div class="weui-panel weui-panel_access noOut">'+
                	                  '<div class="weui-form-preview__bd font-init">'+
                	                      '<p class="text-left"><span class="font-16 text-green title-margin">'+((vlist[i].pointname===null)?flag:vlist[i].pointname)+'</span></p>'+
                	                      '<div class="weui-form-preview__item">'+
                	                        '<label class="weui-form-preview__label">所属单位:'+((vlist[i].ownername===null)?flag:vlist[i].ownername)+'<span class="margin-l5">'+'</span></label>'+
                	                        '<span class="weui-form-preview__value">分摊占比:<em class="text-primary margin-l5">'+(vlist[i].percent===null?flag:vlist[i].percent)+'%</em></span>'+
                	                       '</div>'+
                	                       '<p class="text-left">抄表开始时间:<span class="margin-l5">'+((vlist[i].startbmtime===null)?flag:vlist[i].startbmtime).replace('T',' ')+'</span></p>'+
                	                       '<p class="text-left">抄表结束时间:<span class="margin-l5">'+((vlist[i].endbmtime===null)?flag:vlist[i].endbmtime).replace('T',' ')+'</span></p>'
                                      '</div>'+
                                 '</div>'+
                                 '<div class="padding-15 more-content">'; 
                var rule=vlist[i].pricerule;
                if(rule.type===1){
                	listHtml+='<table class="table width-100 margin-10" border="1">'+'<thead><tr>'+'<th>费率</th>'+'<th>上期示数</th>'+'<th>本期示数</th>'+
                	'<th>倍率</th>'+'<th>单价(元/度)</th>'+'<th>电量(度)</th>'
                	+'</tr></thead><tbody><tr>'+
                	'<td>'+'总'+'</td><td>'+((vlist[i].startbmzongzy===null)?flag:vlist[i].startbmzongzy)
                	+'</td><td>'+((vlist[i].endbmzongzy===null)?flag:vlist[i].endbmzongzy)+
                	'</td><td>'+((vlist[i].rate===null)?flag:vlist[i].rate)+
                	'</td><td>'+((rule.value1===null)?flag:rule.value1)+
                	'</td><td>'+((vlist[i].energyzong===null)?flag:(vlist[i].energyzong))+'</td></tr><tr>'+
                	'<td>总金额</td><td>'+((vlist[i].totalfee===null)?flag:(vlist[i].totalfee))+'</td><td>分摊</td>'+
                	'<td>'+((vlist[i].percent===null)?flag:(vlist[i].percent))+'</td><td>金额(元)</td><td>'
                	+((vlist[i].fee===null)?flag:(vlist[i].fee))+'</td></tr></tbody></table></div></div>';
                }else{
                	if(rule.type===2){
                		listHtml+='<table class="table width-100 margin-10" border="1">'+'<thead><tr>'+'<th>费率</th>'+'<th>上期示数</th>'+'<th>本期示数</th>'+
                    	'<th>倍率</th>'+'<th>单价(元/度)</th>'+'<th>电量(度)</th>'
                    	+'</tr></thead><tbody>'+'<tr><td>'
                    	+'总'+'</td><td>'+((vlist[i].startbmzongzy===null)?flag:vlist[i].startbmzongzy)
                    	+'</td><td>'+((vlist[i].endbmzongzy===null)?flag:vlist[i].endbmzongzy)+
                    	'</td><td rolspan="5">'+((vlist[i].rate===null)?flag:vlist[i].rate)+
                    	'</td><td>/'+
                    	'</td><td>'+((vlist[i].energyzong===null)?flag:(vlist[i].energyzong))+'</td></tr>'+
                    	'<tr><td>'
                    	+'尖'+'</td><td>'+((vlist[i].startbmjianzy===null)?flag:vlist[i].startbmjianzy)
                    	+'</td><td>'+((vlist[i].endbmjianzy===null)?flag:vlist[i].endbmjianzy)+
                    	'</td><td >'+((rule.value1===null)?flag:rule.value1)+
                    	'</td>'+
                    	'<td>'+((vlist[i].energyjian===null)?flag:(vlist[i].energyjian))+'</td></tr>'+
                    	'<tr><td>'
                    	+'峰'+'</td><td>'+((vlist[i].startbmfengzy===null)?flag:vlist[i].startbmfengzy)
                    	+'</td><td>'+((vlist[i].endbmfengzy===null)?flag:vlist[i].endbmfengzy)+
                    	'</td><td >'+((rule.value2===null)?flag:rule.value2)+
                    	'</td>'+
                    	'<td>'+((vlist[i].energyfeng===null)?flag:(vlist[i].energyfeng))+'</td></tr>'+
                    	'<tr><td>'
                    	+'平'+'</td><td>'+((vlist[i].startbmpingzy===null)?flag:vlist[i].startbmpingzy)
                    	+'</td><td>'+((vlist[i].endbmpingzy===null)?flag:vlist[i].endbmpingzy)+
                    	'</td><td >'+((rule.value3===null)?flag:rule.value3)+
                    	'</td>'+
                    	'<td>'+((vlist[i].energyping===null)?flag:(vlist[i].energyping))+'</td></tr>'+
                    	'<tr><td>'
                    	+'谷'+'</td><td>'+((vlist[i].startbmguzy===null)?flag:vlist[i].startbmguzy)
                    	+'</td><td>'+((vlist[i].endbmguzy===null)?flag:vlist[i].endbmguzy)+
                    	'</td><td >'+((rule.value4===null)?flag:rule.value4)+
                    	'</td>'+
                    	'<td>'+((vlist[i].energygu===null)?flag:(vlist[i].energygu))+'</td></tr>'+
                    	'<tr><td>总金额</td><td>'+((vlist[i].totalfee===null)?flag:(vlist[i].totalfee))+'</td><td>分摊</td>'+
                    	'<td>'+((vlist[i].percent===null)?flag:(vlist[i].percent))+'</td><td>金额(元)</td><td>'
                    	+((vlist[i].fee===null)?flag:(vlist[i].fee))+'</td></tr></tbody></table></div></div>';
                	}else{
                		var jishu=rule.energy2-rule.energy1;
                		listHtml+='<table class="table width-100 margin-10" border="1">'+'<thead><tr>'+'<th>费率</th>'+'<th>上期示数</th>'+'<th>本期示数</th>'+
                    	'<th>倍率</th>'+'<th>单价(元/度)</th>'+'<th>电量(度)</th>'
                    	+'</tr></thead><tbody>'+
                    	'<tr><td>'
                    	+'总'+'</td><td>'+((vlist[i].startbmzongzy===null)?flag:vlist[i].startbmzongzy)
                    	+'</td><td>'+((vlist[i].endbmzongzy===null)?flag:vlist[i].endbmzongzy)+
                    	'</td><td>'+((vlist[i].rate===null)?flag:vlist[i].rate)+
                    	'</td><td>见备注'+
                    	'</td><td>'+((vlist[i].energyzong===null)?flag:(vlist[i].energyzong))+'</td></tr>'+
                    	'<tr><td>总金额</td><td>'+((vlist[i].totalfee===null)?flag:(vlist[i].totalfee))+'</td><td>分摊</td>'+
                    	'<td>'+((vlist[i].percent===null)?flag:(vlist[i].percent))+'</td><td>金额(元)</td><td>'
                    	+((vlist[i].fee===null)?flag:(vlist[i].fee))+'</td></tr>'+
                    	'<tr><td>备注</td>'+'<td colspan="5">';
                		
                		
                		var priceList = [
                			rule.value1,
                			rule.value2,
                			rule.value3,
                			rule.value4,
                			rule.value5
                		];
                		var energyList = [
                			rule.energy1,
                			rule.energy2,
                			rule.energy3,
                			rule.energy4,
                			rule.energy5
                		];
                		var chineseNum = ['一', '二', '三', '四', '五'];

                		for(var k = 0; k < 5; k++) { // 最多可能有5个电价
                			if(k == 4 || priceList[k + 1] == null) { // 已经是最后一条，或者本条的下一条不存在，意为本条套用结尾格式
                				listHtml += '<p>第'+chineseNum[k]+'阶梯电价'+priceList[k]+'元/度, 已用'+
                				(vlist[i].energyzong!= null && vlist[i].energyzong)>energyList[k]?(vlist[i].energyzong - energyList[k]):0+'</p>';
                				break; // 结束循环
                			} else {
                				var used;
                				if(vlist[i].energyzong > energyList[k + 1]) {
                					used = (energyList[k + 1] - energyList[k]);
                				} else if(vlist[i].energyzong > energyList[k]) {
                					used = (vlist[i].energyzong - energyList[k]);
                				} else {
                					used = 0;
                				}
                				listHtml += '<p>第'+chineseNum[k]+'阶梯电价'+priceList[k]+'元/度, 基数'+(energyList[k + 1] - energyList[k])+', 已用'+used+'</p>';
                			}
                		}
                		listHtml+='</td></tr>'+'</tbody></table></div></div>';
                	}
                }

            }
            $(vTart).append(listHtml);
        }

  
        function initPage(isFresh){ //默认更新

            $(listDiv).children().remove();//列表所有子内容删除
            pullrefresh=false;//下拉刷新
            $('.index-title').text(storage.getItem('month'));//日期
	    	$('.account-name').text(storage.getItem('hm'));//户名
	    	
	    	$('.to-tel').attr('href','');
	    	    
	    	$('.account-id').text('');//户号
	    	$('.user-phone').text('');//电话号码
	    	$('.meter-name').text('');//电表数
	    	$('.linkman').text('');//联系人
	    	    
            getPages(
            		'data/data_queryPowerFeeDetail.action',
          	      {
          	          accountKey:vKey,
          	          customerid:storage.getItem('customerid'),
          	          month:storage.getItem('month')//月份
//          	          month:'2017-12'
                  },function (res) {
                	
                    var olist=res.data.datas;
       	    	    var rest=res.data;
       	    	    $('.meter-name').text((olist.length===0)?flag:olist.length);//电表数
       	    	    $('.to-tel').attr('href','tel:'+((rest.phone===null)?flag:rest.phone));
       	    	    
       	    	    $('.account-id').text((rest.hh===null)?flag:rest.hh);//户号
       	    	    $('.user-phone').text((rest.phone===null)?flag:rest.phone);//电话号码
       	    	    $('.linkman').text((rest.linkman===null)?flag:rest.linkman);//联系人 
       	    	    
       	    	    var t1='';//表1
       	    	    t1+='<tr class="th"><td>计算月份</td>'+'<td>电度电费</td>'+
                        '<td>基本电费</td>'+'<td>基金电费</td>'+'</tr>';
       	    	    t1+='<tr><td>'+((rest.billTime===null)?flag:rest.billTime)+'</td><td>'
       	    	    +((rest.ddFee===null)?flag:rest.ddFee)+'</td><td>'
       	    	    +((rest.jbFee===null)?flag:rest.jbFee)+'</td><td>'
       	    	    +((rest.jjFee===null)?flag:rest.jjFee)+'</td></tr>'
       	    	    +'<tr class="th">'+'<td>力率电费</td>'+
                    '<td>追退电费</td>'+'<td>应付电费</td>'+'<td>账户余额</td></tr>'
                    +'<tr><td>'+((rest.llFee===null)?flag:rest.llFee)+'</td><td>'
                    +((rest.ztFee===null)?flag:rest.ztFee)+'</td><td>'
                    +((rest.fee===null)?flag:rest.fee)+'</td><td>'
                    +((rest.usableMoney===null)?flag:rest.usableMoney)+'</td></tr>'
                    +'<tr class="th"><td>消耗电量</td>'+
                    '<td>总余额</td>'+'<td>冻结余额</td>'+'<td>可用余额</td></tr>'
                    +'<tr><td>'+((rest.used===null)?flag:rest.used)+'</td><td>'
                    +((rest.total===null)?flag:rest.total)+'</td><td>'
                    +((rest.freeze===null)?flag:rest.freeze)+'</td><td>'
                    +((rest.usable===null)?flag:rest.usable)+'</td></tr>';
       	    	     	    	    
       	    	    $('.table1').html(t1);	    	  
//       	    	    var t2='';//表2
//       	    	    t2+='<tr><td>'+((rest.llFee===null)?flag:rest.llFee)+'</td><td>'+((rest.ztFee===null)?flag:rest.ztFee)+'</td><td>'+((rest.fee===null)?flag:rest.fee)+'</td><td>'+((rest.usableMoney===null)?flag:rest.usableMoney)+'</td></tr>';
//    	    	    $('.table2').html(t2);
//    	    	    
//    	    	    var t3='';//表3
//       	    	    t3+='<tr><td>'+((rest.used===null)?flag:rest.used)+'</td><td>'+((rest.total===null)?flag:rest.total)+'</td><td>'+((rest.freeze===null)?flag:rest.freeze)+'</td><td>'+((rest.usable===null)?flag:rest.usable)+'</td></tr>';
//    	    	    $('.table3').html(t3);
       	    	 
                    if(((olist.length)===0)&&(($(listDiv).children().length)===0)){//没有数据的时候
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
                        $(mainDiv).pullToRefreshDone();
                    }
                },function(){
                	$.hideLoading();
                });
        }
        $.showLoading();
        initPage(false);//默认刷新界面
     
        $(mainDiv).pullToRefresh({
        	distance:55
        }).on("pull-to-refresh", function() {//下拉刷新
        	var self=this;
            if(pullrefresh) return;
            pullrefresh = true;
            setTimeout(function() {
            	initPage(true);//搜索出来的结果
            }, 1000);
        });
       

    })