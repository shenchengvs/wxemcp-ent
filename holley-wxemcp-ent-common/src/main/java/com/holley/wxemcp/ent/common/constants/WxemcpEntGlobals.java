package com.holley.wxemcp.ent.common.constants;

public class WxemcpEntGlobals {

    public static final String ACTIVETAB              = "activeTab";                         // 当前选中的TAB
    public static final short  DEFAULTSYSTEM          = 3;                                   // 当前系统编码：光伏发电系统
    public static final String DEV_MANAGE_MODULEID    = "32000000";                          // 档案管理功能菜单编码
    public static final String SYS_MANAGE_MODULEID    = "31000000";                          // 系统管理功能菜单编码

    public static final String COOKIE_DESKEY          = "holleydpms0704";                    // 加密密钥
    public static final String COOKIE_PV_WEB_ACCOUNT  = "pvWebAccount";                      // 系统登录帐号保存在session的key值
    public static final String DATA_SECURIRY_KEY      = "holleydpms";                        // 传输数据加密部分密钥

    public static final String WEB_ROOT               = "webRoot";                           // 根目录
    public static final String IMG_URL                = "imgUrl";                            // 图片存放地址前缀
    public static final String PROVINCE               = "province";                          // 省信息

    public static String       COMMONREPORTBASEDIR    = "data/tempfile";                     // 通用报表根目录
    public static String       EXCEL_TEMP_PATH        = "D://temp";                          // excel临时文件夹

    public static final String YEAR_START             = "2016";                              // 累计数据开始年份
    public static final String YEAR_END               = "2026";                              // 累计数据结束年份

    public static final int    EXPORT_MAX             = 5000;                                // 导出Excel最多记录数

    // ----超时时间(秒)
    // public static final int TIMEOUT_20 = 20;
    public static final int    TIMEOUT_15             = 15;

    public static String       IMG_PATH               = "data";
    public static String       IMG_FILENAME           = "stationImg";
    public static String       IMG_FILEPATH           = "stationImg_";
    public static String       STATION_IMG_DEFAULT    = "data/stationImg/stationDefault.jpg";

    public static final int    MAX_LIST_SIZE          = 200;

    public static final String NO_DATA_TEXT           = "--";                                // 记录无数据值时显示的文本

    public static final int    MAX_WAIT_TIME          = 30;
    public static final int    MAX_CHATR_DAY          = -3;                                  // echats显示数据的天数
    public static final String ENCODE_KEY             = "ttPfFNeR2DXDT4QU";
    public static final int    DEFAULT_UNREGISTER_ENT = 2;                                   // 默认企业编码

    // wechat
    public static String       WX_APP_SECRET          = "";
    public static String       WX_APP_ID              = "";
    public static String       WX_WARN_TEMPLATE_ID    = "";
    public static int          RELEASE_MODE           = 0;
    public static String       PROXY_IP               = null;
    public static int          PORT                   = 0;
}
