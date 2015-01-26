
package com.example.comefreechat.utils;




/**
 * 类名: Constants系统常量类 <br/> 
 * 功能: TODO ADD FUNCTION. <br/> 
 * 创建日期: 2014-12-29 上午9:47:28 <br/> 
 *
 * @author wujd
 * @version V1.0
 * @since Jdk 1.6
 * @see       
 *
 */
public class Constants {
    
    /**系统缓存文件名称*/
    public static final String SYS_SETTING_INFO="sys_setting_info";

    /** 记录日志的关键字 */
    public static final String SYS_TAG = "weioa_log";
    
    /** 客户端通讯字符集 */
    public static final String CHAR_SET = "UTF-8";
    
    
    //用户相关
    
    /**用户登录密码*/
    public static final String USER_PASSWORD="user_password";
    /**用户昵称*/
    public static final String USER_NAME="user_name";
    /**用户手机号*/
    public static final String USER_MDN="user_MDN";
    /**用户Id*/
    public static final String USER_ID="user_id";
    /**用户当前圈子ID*/
    public static final String CUR_SET_ID="cur_set_id";
    /**用户当前圈子名称*/
    public static final String CUR_SET_NAME="cur_set_name";
    
    /**接口请求成功*/
    public static final String SUCCESS="S";
    /**接口请求失败*/
    public static final String FAILURE="F";
    
    /**下发验证码类型。0：注册；*/
    public static final String VERCODE_TYPE_REGISTER="0";
    /**下发验证码类型。1：修改密码*/
    public static final String VERCODE_TYPE_CHANGE_PWD="0";
    
    /** 给nma服务发送数据时使用的key */
    public static final String NMA_SERVICE_CODE = "code";

    /**====================自定义action 开始=====================*/
    /** 错误报告自定义的action */
    public static final String NMA_ACTION_ERROR = "com.gsww.weioa.action.NOTIFY_ERROR";   
    /** 网络连接自定义的action */
    public static final String NMA_ACTION_NETWORK_CONNECTED = "com.gsww.weioa.action.NETWORK_CONNECTED";
    /** 网络是否可以自定义的action */
    public static final String NMA_ACTION_NETWORK_UNAVAILABLE = "com.gsww.weioa.action.NETWORK_UNAVAILABLE";
    /** 清除用户数据自定义的title */
    public static final String NOTIFICATION_TYPE_RESET = "117151";
    /** 清除用户数据自定义的action */
    public static final String NOTIFICATION_RESET_CODE = "nma_clear_data";
    /** 接收未读数自定义的action */
    public static final String NMA_ACTION_UNREAD = "com.gsww.nma.action.NOTIFY_UNREAD"; 
    /**客户端SharedPreferences缓存文件*/
    public static final String SAVE_MENU_INFO = "MENU_SETTING"; 
    /** 客户端SharedPreferences缓存文件 */
    public static final String SAVE_CACHE_INFO = "NMA_CACHE";
    /** 未读数刷新 */
    public static final String NMA_ACTION_REFRESH = "com.gsww.nma.action.NOTIFY_REFRESH";   
    /** 网络连接失败的错误提示信息 */
    public static final String DATABASE_APPWIDGET_INFO = "appwidget.db";
    /**====================自定义action 结束=====================*/
    
    /**======================公用数据 开始=======================*/
    /** 首页-拨号 */
    public static final String DIAL = "dial";
    /** 首页-应用 */
    public static final String APP ="app";
    /** 首页-通讯录 */
    public static final String CONTACT = "contact";
    /** 首页-我的 */
    public static final String MINE ="mine";
    /** 数据调用结果：成功 */
    public static final byte RESPONSE_SUCCESS = 0;
    /** 数据调用结果：失败 */
    public static final byte RESPONSE_ERROR = 1;
    public final static int DATABASE_VERSION = 5;
    /** 自定义Toast类型，警告：ALERT，确认： CONFIRM，信息：INFO*/
    public static enum TOAST_TYPE {
        ALERT, CONFIRM, INFO
    }
    /** 通用的头像名称 */
    public static String HEAD_SCULPTURE = "headSculpture.jpg";
    /** 公文类型 */
    public static String DOC_KIND_IN = "00I";
    public static String DOC_KIND_OUT = "00U";
    public static String DOC_TYPE_PADDING = "00D";
    public static String DOC_TYPE_SENDED = "00Y";
    public static String DOC_TYPE_END = "00H";
    public static String DOC_TYPE = "00A";
    /** 正常通知ID */
    public static final int NOTIFICATION_ID = 0;
    /**======================公用数据 结束=======================*/
    
    /**====================客户端缓存数据 开始=====================*/
    public static final String MENU_ECP = "ecp";//电话会议
    /** 用户UserId */
    public static final String SID = "sid";
    /** 会话ID */
    public static final String SESSION_ID = "sessionId";
    /** 登录账号 */
    public static final String LOGIN_NAME = "login_name";
    /** 登录密码 */
    public static final String LOGIN_PWD = "login_pwd";
    /** 自动登录 */
    public static final String LOGIN_AUTO = "login_auto";

    /** 用户手机 */
    public static String USER_PHONE = "user_phone";
    /** 电话会议个人账号，以逗号分隔--这个待定 */
    public static String ECP_USER_PHONE = "ecp_user_phone";
    /** 电话会议单位账号，以逗号分隔--这个待定 */
    public static String ECP_ORG_PHONE = "ecp_org_phone";
    /** 当前电话会议用户类型，用户：USER_电话号码，单位：ORG_电话号码 */
    public static String ECP_ORG_OR_USER = "ecp_org_or_user";
    /** 单位全称 */
    public static String FULL_ORG_NAME="full_org_name";
    /** 电话会议Token */
    public static String ECP_TOKEN = "ecp_token";
    /** oa地址 */
    public static String OA_URL = "oa_url";
    /** 未读数地址 */
    public static String UNREAD_URL = "unread_url";
    /** 附件下载地址 */
    public static String ATTACHMENT_DOWNLOAD_ADDRESS = "attachment_download_address";
    /** 附件上传地址 */
    public static String ATTACHMENT_UPLOAD_ADDRESS = "attachment_upload_address";
    /** 附件删除地址 */
    public static String ATTACHMENT_DELETE_ADDRESS = "attachment_delete_address";
    /** 文件柜下载地址 */
    public static String DOCUMENT_DOWNLOAD_ADDRESS = "document_download_address";
    /** 文件柜上传地址 */
    public static String DOCUMENT_UPLOAD_ADDRESS = "document_upload_address";
    /** 头像下载地址 */
    public static String PHOTO_DOWNLOAD_ADDRESS = "photo_download_address";
    /** 头像上传地址 */
    public static String PHOTO_UPLOAD_ADDRESS = "photo_upload_address";
    /** 公文正文下载地址 */
    public static String DOC_CONTENT_DOWNLOAD_ADDRESS = "doc_document_download_address";
    /** 单位ID */
    public static String ORG_ID = "org_id";
    /** 单位显示名称 */
    public static String ORG_DISPLAY_NAME = "org_display_name";
    /** 单位默认logo地址 */
    public static String ORG_DEFAULT_LOGO = "org_default_logo";
    /** 登录页面logo地址 */
    public static String ORG_LOGO_URL = "org_logo_url";
    /** 登录页面背景地址 */
    public static String ORG_BG_URL = "org_bg_url";
    /** 是否有短信权限，有权限时值为1 */
    public static String SMS_RIGHT = "sms_right";
    /** 综合办公在线服务链接地址 */
    public static final String CUST_SERVICE_ONLINE = "cust_service_online"; 
    /** 从引擎获取到的字符串，用于判断是有关联单位的权限 */
    public static String IS_HAVE_RELATIVEORG = "is_have_relativeorg";
    /** 通讯录同步地址 */
    public static String ADDRESS_PC_URL = "address_pc_url";
    /** 日程列表 */
    public static String CALENDAR_LIST = "calendar_list";
    /** 菜单关联单位权限,包含应用菜单 */
    public static String MENUS_RIGHT="menu_right";
    public static String MENU_LIST = "menu_list";
    /**====================客户端缓存数据 结束=====================*/
    
    /**==========SharedPreference文件名称 开始===========*/
    /** 客户端设置的SharedPreferences文件 */
    public static final String SAVE_SETTING_INFO = "NMA_SETTING";
    /**==========SharedPreference文件名称 结束===========*/
    /**
     * 通讯录切换
     */
    public static String CONTACT_SWITH_DEPT ="contact_swith_dept";
    public static String CONTACT_SWITH_NAME ="contact_swith_name";
    public static String CONTACT_SWITH_COMBINE ="contact_swith_combine";
    
    /**===============数据库表名 开始====================*/
    /** 登录账号数据库 */
    public static final String DATABASE_LOGIN_INFO = "logininfo.db";
    public static final String DATABASE_NAME = "nma.db";
    /**===============数据库表名 结束====================*/
    /** 省略号 */
    public static String SIGN_AND_SO_ON = "*********";
    
    /**保存来电弹屏的的字段*/
    public static String SCREEN_POPUP = "SCREEN_POPUP";
    /** 保存消息推送状态字段     */
    public static String PUSH_SET = "PUSH_SET";
    /** 保存是否首次安装    空表示首次登录，非首次登录设为1  */
    public static String FIRST_INSTALL = "FIRST_INSTALL";
    /** 保存应用版本号  */
    public static String APP_VERSION_CODE = "APP_VERSION_CODE";
    /** 我的动态最后一次刷新时间 */
    public static String NEWS_LAST_REFRESH_TIME = "NEWS_LAST_REFRESH_TIME"  ;
    /** 我的模块活动提示状态值   */
    public static String MINE_DOING_STATE_VALUE = "MINE_ACTIVITY_STATE";
    /** 我的模块--活动地址  */
    public static String MINE_ACTIVITY_URL = "MINE_ACTIVITY_URL";
    /** 我的模块--活动开始时间 */
    public static String MINE_ACTIVITY_START_TIME ="MINE_ACTIVITY_START_TIME";
    /** 我的模块--活动 结束时间 */
    public static String MINE_ACTIVITY_END_TIME = "MINE_ACTIVITY_END_TIME";
    /**我的模块--帮助*/
    public static String HELP_URL = "HELP_URL";
    
    /** ----------------------- weioa定义应用模块编码 ------------------------------ */
    public static final String APP_SYS = "9000";
    /**用户头像*/
    public static final String APP_SYS_USER_PHOTO = "9010";//用户头像
    /**任务*/
    public static final String APP_TASK = "1000";//任务
    /**汇报*/
    public static final String APP_REPORT = "2000";//汇报
    /**公告*/
    public static final String APP_BULLETIN = "3000";//公告
    /**签到*/
    public static final String APP_ATTENDANCE = "4000";//签到
    /**无业务群聊(单群聊)*/
    public static final String APP_HANGOUT = "5000";//无业务群聊(单群聊)

    
    /**===============各应用代码======================*/
    /**日程*/
    public static final String APP_CALENDAR = "2700";
    /**外网邮件*/
    public static final String APP_OUT_MAIL = "2800";
    /**技术社区*/
    public static final String APP_JSSQ = "2900";
    /**单位logo*/
    public static final String APP_SYS_ORG_LOGO = "9001";
    /**客户端logo*/
    public static final String APP_SYS_CLIENT_LOGO = "9002";
    /**客户端背景*/
    public static final String APP_SYS_CLIENT_BG = "9003";
    /**邮件*/
    public static final String APP_MAIL = "1000";
    /**公告*/
    public static final String APP_INFO = "1100";
    /**文件柜*/
    public static final String APP_DOCUMENT = "1200";
    /**开会*/
    public static final String APP_MEET = "1300";
    /**视频会议*/
    public static final String APP_VMEET = "1400";
    /**公文*/
    public static final String APP_DOC = "1500";
    /**审批*/
    public static final String APP_COLLABORATE = "1600";
    /**计划*/
    public static final String APP_PLAN = "1800";
    /**短信*/
    public static final String APP_SMS = "2000";
    /**通讯录*/
    public static final String APP_CONTACT = "2100";
    /**考勤*/
    public static final String APP_ATTENDENCE = "2200";
    /**投票*/
    public static final String APP_VOTE = "2300";
    /**调查*/
    public static final String APP_SURVEY = "2400";
    /**话题*/
    public static final String APP_TOPIC = "2500";
    /**客户*/
    public static final String APP_CUSTOM = "2600";
    /**收文*/
    public static final String APP_DOC_IN = "1501";
    /**发文*/
    public static final String APP_DOC_OUT = "1502";
    /**公文阅读*/
    public static final String APP_DOC_READ = "1503";
    /**动态*/
    public static final String APP_NEWS = "8300";
   /**==================模块代码结束===================*/
    
    /**==================登录启动页（节日祝福图片）相关参数===================*/
    /**图片id */
    public static final String LOGIN_START_PAGE_ID = "LOGIN_START_PAGE_ID";
    /**图片地址 */
    public static final String LOGIN_START_PAGE_URL = "LOGIN_START_PAGE_URL";
    /**图片启用时间 */
    public static final String LOGIN_START_PAGE_START_TIME = "LOGIN_START_PAGE_START_TIME";
    /**图片终止时间 */
    public static final String LOGIN_START_PAGE_END_TIME = "LOGIN_START_PAGE_END_TIME";
    /**图片使用范围编号 */
    public static final String LOGIN_START_PAGE_SCOPE_TYPE = "LOGIN_START_PAGE_SCOPE_TYPE";
    /**图片使用范围列表 */
    public static final String LOGIN_START_PAGE_SCOPE_LIST = "LOGIN_START_PAGE_RANGE_LIST";
    /**图片使用有效次数 */
    public static final String LOGIN_START_PAGE_USEFUL_COUNT = "LOGIN_START_PAGE_USEFUL_COUNT";
    /**==================登录启动页（节日祝福图片）相关参数  END ===================*/
    /**办公列表未读*/
    public static final String ACTION_NAME_OFFICE = "com.gsww.REFRESH_OFFICE_LIST";
    /**应用模块的未读数*/
    public static final String ACTION_NAME_APP = "com.gsww.REFRESH_APP_VIEW";
    /** 注册更新我的模块广播接收器 */
    public static final String ACTION_NAME_MINE = "com.gsww.REFRESH_NEW_VIEW";
    /**公告类型未读*/
    public static final String ACTION_NAME_NOTICE_TYPE = "com.gsww.REFRESH_TYPE_UNREAD";
    
    
 

}
