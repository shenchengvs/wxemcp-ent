 $(function() {
	
//        FastClick.attach(document.body);
        var pindex=1;//页码
        var timestr;//初始化时间
        
        var storage= window.localStorage;
        storage = storage ? storage : [];
        
        var isOver=false;//是否没有数据
        var listDiv='.more-list-content';//对象
//        var infobj='#tab1';
        var timeObj="#time2";
        var mainDiv='.pullContent';//下滑框
        var loading=false;//加载更多
        var pullrefresh=false;//下拉刷新
        var vKey=window.localStorage.getItem('accountKey');//密钥
       
        var oldSelect1=0;//原先tab1选择的拉合闸初始值
        var flag='- -';
        
        
        var searchObj='#searchInput';//搜索框对象
        
        /*  默认日期为当前年月 */
        function getNowDate(xDate){
            var oMonth=xDate.getMonth()+1;
            if(oMonth<10){
                oMonth='0'+oMonth;
            }
            timestr=xDate.getFullYear()+'-'+(oMonth);
            return timestr
        }
        var oldTime1=getNowDate(new Date());
        $(timeObj).val(getNowDate(new Date()));
        var dateSelect1=getNowDate(new Date());
        var timeNow=getNowDate(new Date());
        
        
        $(mainDiv).find('.weui-pop-div').val('全部').data({"values":0});

        
       
       
        /* 排序记录 */
        $(".selectItem").select({
            title: "排序类型",
            items: [{
                title: "全部",
                value: 0
              },
              {
                title: "天数",
                value: 1
              },
              {
                title: "电费",
                value: 2
              },
              {
                  title: "余额",
                  value: 3
              }],
            onChange: function (d) {
            },
            onClose: function (vals) {
                var selectedOption = vals.data;
                var obj=$(".selectItem");
                var oPar = obj.closest('.part-slide-tri');
                oPar.removeClass('part-slide-tri-after');

                var oVal;
                for (var i in selectedOption.origins) {
                    oVal = selectedOption.origins[i].value;
                }
                
                if(oldSelect1!=oVal){
                  
             	   initPage($(searchObj).val(),false);//初始化tab1
             	   oldSelect1=oVal;
                }
               
            },
            onOpen: function () {
                $('.part-slide-tri').removeClass('part-slide-tri-after');
                var oPar = $(".selectItem").closest('.part-slide-tri');
                oPar.addClass('part-slide-tri-after');
            }
        });



        function getListItem(vlist,vTart) {
            var listHtml='';
            for(var i in vlist){
                listHtml+='<a href="javascript:void(0);" class="more-content-item" name="'+((vlist[i].hm===null)?flag:vlist[i].hm)+'" role="'+((vlist[i].customerid===null)?'0':vlist[i].customerid)+'"><div class="weui-form-preview__bd"> <div class="weui-form-preview__item">'+'<label class="weui-form-preview__label remind-title margin-right-3 text-ellipsis max-name-width">'+((vlist[i].hm===null)?flag:vlist[i].hm)+
              '</label><span class="weui-form-preview__value">预计可用:'+'<em class="text-primary margin-l5">'+((vlist[i].usableDay===null)?'':vlist[i].usableDay)+'天</em></span></div><div class="weui-form-preview__item"><label class="weui-form-preview__label">结算时间:'+'<em class="margin-l5">'+
              ((vlist[i].billTime===null)?flag:vlist[i].billTime)+'</em></label></div><div class="weui-form-preview__item">'+'<label class="weui-form-preview__label">余额:'+'<em class="text-green margin-l5">'+((vlist[i].usableMoney===null)?flag:vlist[i].usableMoney)+'</em></label>'+'<span class="weui-form-preview__value">实际水费:'+'<em class="text-red margin-l5 font-16">'+((vlist[i].fee===null)?flag:vlist[i].fee)+'</em></span>'+'</div></div></a>';
            }
            $(vTart).append(listHtml);
            $('.more-content-item').on('click',function(e){
            	var obj=$(this);
            	storage.setItem('watercustomerid',obj.attr('role'));//缓存用户id
            	storage.setItem('watermonth',$(timeObj).val().trim());//缓存当前日期
            	storage.setItem('waterhm',obj.attr('name'));//缓存户名
            
                window.location.href="data/initWaterFeeDetailPage.action";
            })
        }
     
        function initPage(oWord,isFresh){ //默认更新

            $(listDiv).children().remove();
            $(mainDiv).infinite();
            
            var selectVal=$(mainDiv).find('.weui-pop-div').data('values');//选择框
            
            $('.record-num').text('');
            pindex=1;
            loading=false;//加载更多
            pullrefresh=false;//下拉刷新
            isOver=false;
            
            getPages(
                'data/data_queryWaterFees.action',
                {
                    accountKey:vKey,
                    keyWord:oWord,//搜索关键字
                    pageIndex:pindex,
                    month:$(timeObj).val().trim(),//月份
                    orderType:selectVal //电费查询
                },function (res) {
                    var olist=res.data.datas;
                    var oindex=res.data.pageIndex;//页码
                    var tproperty=res.data.totalProperty;//总记录数
                    var  tpage=res.data.totalPage;//总页数

                    
                    $('.record-num').text(res.data.arrearageUserCount);
                    if(oindex===tpage){
                        isOver=true;
                    }
                    if((tproperty===0)&&(($(listDiv).children().length)===0)){//没有数据的时候
                        $(listDiv).html('<p class="nodata">没有数据</p>');
                        $.hideLoading();
                        return;
                    }else{
                        
                        getListItem(olist,listDiv);
                    }
                    $.hideLoading();

                },function (){
                	
                    if(isFresh){      
                        $(mainDiv).pullToRefreshDone();
                        pullrefresh=false;
                    }else{
                        loading = false;
                    }

                },function(){
                	$.hideLoading();
                });
        }
        $.showLoading();
        initPage($(searchObj).val(),false);//默认刷新界面
        
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
            	   if(timeNow!=str){
           		    $('.selectItem').attr({'disabled':true});   
           	   }else{
           		   $('.selectItem').removeAttr('disabled');
           	   }
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
                    $(this).val(this.value);
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
            	initPage($(searchObj).val(),true);//默认刷新界面
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
            
            var selectVal=$(mainDiv).find('.weui-pop-div').data('values');//选择框
            setTimeout(function() {
                if(isOver){//全部数据已经展示
                    $('.btm-loadmore').remove();
                    $.toast("已加载全部",800,function(toast) {
                        loading = false;
                        self.destroyInfinite();
                    });
                }else{
                    pindex++;
                    getPages(  'data/data_queryWaterFees.action',
                            {
                        accountKey:vKey,
                        keyWord:$(searchObj).val(),//搜索关键字
                        pageIndex:pindex,
                        month:$(timeObj).val().trim(),//月份
                        orderType:selectVal //电费查询
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
        
//        /* mui datepicker */
//        $('.mui-date').on('click',function(){
//            $('.part-slide-tri').removeClass('part-slide-tri-after');
//            var oPar = $(this).closest('.part-slide-tri');
//            oPar.addClass('part-slide-tri-after');
//        });


    })