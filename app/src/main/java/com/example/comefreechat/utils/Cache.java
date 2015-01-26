package com.example.comefreechat.utils;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;


/**
 * 类名: Cache <br/> 
 * 功能: 缓存变量. <br/> 
 * 创建时间: 2014-9-16 下午3:09:19 <br/> 
 * 
 * @author wchhuangya 
 * @version  
 * @since Jdk 1.6
 */
@SuppressLint("UseSparseArrays")
@SuppressWarnings("rawtypes")
public class Cache implements Parcelable {

	static Cache cache = new Cache();

	public static Cache getInstance() {
		return cache;
	}
	
	
    /** 用户的userId，唯一标识 */
    public static String USER_ID;
    /** 登录账号 */
    public static String USER_ACCOUNT;
    /** 登录密码 */
    public static String USER_PWD;
    /** 用户昵称*/
    public static String USER_NAME;
    /** 用户手机 */
    public static String USER_MDN;
    /** 用户头像下载地址 */
    public static String USER_PHOTO_URL;
    /** 用户当前圈子Id */
    public static String CUR_SET_ID;
    /** 用户当前圈子名称 */
    public static String CUR_SET_NAME;
    /**用户所所属圈子列表*/
    public static List<Map<String, String>> SET_LIST = new ArrayList<Map<String,String>>();
    
    /**用户手机号及头像对应关系*/
    public static Map<String, String> userMDNAndPhotoMaps = new HashMap<String, String>();
    /**用户手机号及昵称对应关系*/
    public static Map<String, String> userMDNAndNickMaps = new HashMap<String, String>();
	/** 手机软、硬件信息 开始 */
	/** 唯一的用户ID。对于GSM手机来说，是IMSI。如果不可用的话，为null； */
	public static String IMSI;
	/** 唯一的设置ID。对于GSM手机来说，是IMEI，对于CDMA手机来说，是MEID或ESN。如果不可用，返回null； */
	public static String IMEI;
	/** 最终产品的最终用户的可见名称 */
	public static String HANDMODEL;
	/** 返回设备的软件版本号。对于GSM手机来说，是IMEI/SV。如果软件版本号不可用，返回null；  */
	public static String HANDSYS;
	/** 手机分辨率。宽*高（单位：像素） */
	public static String RESOLUTION;
	/** NMA的版本号 */
	public static String NMAVERSION;
	/** 手机软、硬件信息 结束 */

	/** 全局的通用属性 开始 */
	/** 当前包里省份编码，值取自config.properties文件 */
	public static String COMMON_PROVINCE_CODE;
	/** 通用的图片缓存 */
	public static Map<String, SoftReference<Drawable>> commonImageCache = new HashMap<String, SoftReference<Drawable>>();
	/** 客户端上传文件大小限制 */
	public static String UPLOAD_FILE_LIMIT_SIZE;
	/** 图片缓存 */
	public static Map<String, SoftReference<Drawable>> imageCache = new HashMap<String, SoftReference<Drawable>>();
	/**保存应用主页要显示的集合*/
	public static  List<Map<String, String>> MENUS_APP;
	/** 全局的通用属性 结束 */
	
	/** 通讯录 开始 */
	/** 缓存通讯录选择的人员 */
//	public static List<User> conPersonSel = new ArrayList<User>();
//	/** 缓存选择部门信息  */
//	public static Map<Integer,Map<String, LinkedHashMap<String, Contact>>> conUnitMap = new HashMap<Integer,Map<String, LinkedHashMap<String, Contact>>>();
//	/** 默认人员中加入通讯录中的人员 */
//	public static Map<String, LinkedHashMap<String, Contact>> mPersonSel = new HashMap<String, LinkedHashMap<String, Contact>>();
//	/** 通讯录 结束 */
	
	/** 记录是否有发布权限的变量。-1：没有；0：默认；1：有； */
	public static int hasPublicRight = 0;
	/**公告类型的未读*/
	public static List<Map<String, Object>> noticeTypeUnread = new ArrayList<Map<String,Object>>();
	/**公告结束*/
	
	/**记录收发文人员选择状态的集合*/
	public static List<Map<String, String>> ls2 = new ArrayList<Map<String,String>>();
	/**记录审批人员选择状态的集合*/
	public static List<Map<String, String>> colLs2 = new ArrayList<Map<String,String>>();
	/** 登录成功后返回的缓存信息 开始 */
	
	/**新建日程时从引擎获取的日程类型列表*/
	public static List<Map<String, String>> calList;
	/**新建日程时从引擎获取的委托人日程类型列表*/
	public static List<Map<String, Map<String, String>>> calAgentList;
	
	/** 用户的userId，唯一标识 */
	public static String SID;
	public static String SESSION_ID;
	/** 电话会议的个人手机 */
	public static String ECP_USER_PHONE;
	/** 用户电话会议单位账号的号码 */
	public static String ECP_ORG_PHONE;
	/** 标识当前用户电话会议账号是单位还是个人 */
	public static String ECP_ORG_OR_USER;
	/** 电话会议Token */
	public static String ECP_TOKEN;
	/** 单位全称 */
	public static String FULL_ORG_NAME;
	/** OA地址 */
	public static String OA_URL;
	/** 获取未读数地址 */
	public static String UNREAD_URL;
	/** 附件下载地址 */
	public static String ATTACHMENT_DOWNLOAD_ADDRESS;
	/** 附件上传地址 */
	public static String ATTACHMENT_UPLOAD_ADDRESS;
	/** 附件删除地址 */
	public static String ATTACHMENT_DELETE_ADDRESS;
	/** 文档下载地址 */
	public static String DOCUMENT_DOWNLOAD_ADDRESS;
	/** 文档上传地址 */
	public static String DOCUMENT_UPLOAD_ADDRESS;
	/** 头像上传地址 */
	public static String PHOTO_UPLOAD_ADDRESS;
	/** 公文正文下载地址 */
	public static String DOC_CONTENT_DOWNLOAD_ADDRESS;
	/** 附件删除地址 */
	public static String FILE_DELETE_URL;
	/** 单位ID */
	public static String ORG_ID;
	public static String REAL_USER_PHONE;//新版人员电话号码
	/** 单位显示名称 */
	public static String ORG_DISPLAY_NAME;
	/** 单位logo */
	public static String ORG_DEFAULT_LOGO;
	/** 登录页面自定义LOGO */
	public static String ORG_LOGO_URL;
	/** 登录页面自定义背景 */
	public static String ORG_BG_URL;
	/** 是否有发送短信的权限；0-没有；1-有； */
	public static String IS_HAVE_SMS_RIGHT;
	/** 体验账号权限控制。"true"|其它 */
	public static String EXPERINCE_STATE;
	/** 是否有关联单位，文件柜使用 ,通讯录中的使用*/
	public static String IS_HAVE_RELATIVEORG;
	/** 是否具体申请会议的权限 */
	public static String IS_HAVE_MEETING_APPLY;
	/** 综合办公在线服务地址 */
	public static String CUST_SERVICE_ONLINE;
	/** 通讯录同步地址 */
	public static String ADDRESS_PC_URL;
	/** 所有日程集合 */
	public static List<Map> calendarList = new ArrayList<Map>();
	/** 个性签名 */
	public static String SIGNATURE;
	/** 办公电话 */
	public static String OFFICE_PHONE;
	/** 部门名称（多个之间以逗号分隔） */
	public static String DEPTS;
	/** 菜单关联单位权限,包含应用菜单 */
	public static List<Map<String, String>> MENUS_RIGHT;
	/**快捷菜单的权限*/
	public static String RIGHTS;
	/**获取菜单*/
	public static List<Map<String, String>> MENU_LIST = new ArrayList<Map<String,String>>();
	/** 登录成功后返回的缓存信息 结束 */
	
	/** 未读数 开始 */
	/** 邮件未读数 */
	public static int MAIL_COUNT ;
	/** 公告未读数 */
	public static int INFO_COUNT ;
	/** 会议未读数 */
	public static int MEETING_COUNT ;
	/** 日程未读数 */
	public static int CALENDAR_COUNT ;
	/** 发文未读数 */
	public static int DOC_OUT_COUNT ;
	/** 收文未读数 */
	public static int DOC_IN_COUNT ;
	/** 审批未读数 */
	public static int COL_COUNT ;
	/** 公告分类未读数Map */
	public static Map COL_MAP ;
	/** 任务未读数 */
	public static int MISSION_COUNT ;
	/** 计划未读数 */
	public static int WORKPLAN_COUNT ;
	/** 汇报未读数 */
	public static int REPORT_COUNT ;
	/** 调查未读数 */
	public static int SURVEY_COUNT ;
	/** 投票未读数 */
	public static int VOTE_COUNT ;
	/** 动态未读数 ，若无更新--0，有更新---1 */
	public static int NEWS_COUNT = 0 ;
	/** 未读数 结束 */
	
	/** 我的动态最后一次刷新时间 */
	public static String NEWS_LAST_REFRESH_TIME ;
	/** 我的模块--活动地址 */
	public static String MINE_ACTIVITY_URL = "";
	/** 我的模块活动提示状态    ---false :活动不提醒，---true:活动不提醒  */
	public static Boolean MINE_ACTIVITY_STATE = false;
	/** 我的模块--活动开始时间 */
	public static String MINE_ACTIVITY_START_TIME;
	/** 我的模块--活动 结束时间 */
	public static String MINE_ACTIVITY_END_TIME;
	/**我的模块--帮助*/
	public static String HELP_URL;
	
	
	/**==================登录启动页（节日祝福图片）相关参数===================*/
    /**图片id */
    public static String LOGIN_START_PAGE_ID ;
    /**图片地址 */
    public static String LOGIN_START_PAGE_URL ;
    /**图片启用时间 */
    public static String LOGIN_START_PAGE_START_TIME ;
    /**图片终止时间 */
    public static String LOGIN_START_PAGE_END_TIME ;
    /**图片使用范围编号 */
    public static String LOGIN_START_PAGE_SCOPE_TYPE;
    /**图片使用范围列表 */
    public static String LOGIN_START_PAGE_SCOPE_LIST ;
    /**图片使用有效次数   ，当值为-1时，不限次数 */
    public static int LOGIN_START_PAGE_USEFUL_COUNT = 0 ;
    /**==================登录启动页（节日祝福图片）相关参数  END ===================*/
	
	
	/**桌面控件*/
	public static int currentPage = 1;
	/**获取屏幕宽度*/
	public static int SCREENWIDTH = 0;
	
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(UPLOAD_FILE_LIMIT_SIZE);
		
		dest.writeString(SID);
		dest.writeString(SESSION_ID);//TODO 查一下引擎，看SESSION_ID是否有用，没用就干掉
		dest.writeString(USER_ACCOUNT);
		dest.writeString(USER_PWD);
		dest.writeString(USER_NAME);
		dest.writeString(USER_MDN);
		dest.writeString(ECP_USER_PHONE);
		dest.writeString(ECP_ORG_PHONE);
		dest.writeString(ECP_ORG_OR_USER);
		dest.writeString(ECP_TOKEN);
		dest.writeString(REAL_USER_PHONE);
		dest.writeString(FULL_ORG_NAME);
		dest.writeString(OA_URL);
		dest.writeString(UNREAD_URL);
		dest.writeString(ATTACHMENT_DOWNLOAD_ADDRESS);
		dest.writeString(ATTACHMENT_UPLOAD_ADDRESS);
		dest.writeString(ATTACHMENT_DELETE_ADDRESS);
		dest.writeString(DOCUMENT_DOWNLOAD_ADDRESS);
		dest.writeString(DOCUMENT_UPLOAD_ADDRESS);
		dest.writeString(USER_PHOTO_URL);
		dest.writeString(PHOTO_UPLOAD_ADDRESS);
		dest.writeString(DOC_CONTENT_DOWNLOAD_ADDRESS);
		dest.writeString(FILE_DELETE_URL);
		dest.writeString(ORG_ID);	
		dest.writeString(ORG_DISPLAY_NAME);
		dest.writeString(ORG_DEFAULT_LOGO);
		dest.writeString(ORG_LOGO_URL);
		dest.writeString(ORG_BG_URL);
		dest.writeString(IS_HAVE_SMS_RIGHT);
		dest.writeString(IS_HAVE_RELATIVEORG);
		dest.writeString(IS_HAVE_MEETING_APPLY);
		dest.writeString(CUST_SERVICE_ONLINE);
		dest.writeString(ADDRESS_PC_URL);
		dest.writeString(SIGNATURE);
		dest.writeString(OFFICE_PHONE);
		dest.writeString(DEPTS);
		dest.writeString(RIGHTS);
		dest.writeString(HELP_URL);

		dest.writeList(calList);
		dest.writeList(calAgentList);
		dest.writeList(calendarList);
		dest.writeList(MENUS_RIGHT);
		dest.writeList(MENU_LIST);
		dest.writeInt(SCREENWIDTH);
	}

	public static final Parcelable.Creator<Cache> CREATOR = new Parcelable.Creator<Cache>() {
		@SuppressWarnings({ "static-access", "unchecked" })
		@Override
		public Cache createFromParcel(Parcel source) {
			cache.UPLOAD_FILE_LIMIT_SIZE = source.readString();
			
			cache.SID = source.readString();
			cache.SESSION_ID = source.readString();//TODO 查一下引擎，看SESSION_ID是否有用，没用就干掉
			cache.USER_ACCOUNT = source.readString();
			cache.USER_PWD = source.readString();
			cache.USER_NAME = source.readString();
			cache.USER_MDN = source.readString();
			cache.ECP_USER_PHONE = source.readString();
			cache.ECP_ORG_PHONE = source.readString();
			cache.ECP_ORG_OR_USER = source.readString();
			cache.ECP_TOKEN = source.readString();
			cache.FULL_ORG_NAME = source.readString();
			cache.REAL_USER_PHONE = source.readString();
			cache.OA_URL = source.readString();
			cache.UNREAD_URL = source.readString();
			cache.ATTACHMENT_DOWNLOAD_ADDRESS = source.readString();
			cache.ATTACHMENT_UPLOAD_ADDRESS = source.readString();
			cache.ATTACHMENT_DELETE_ADDRESS = source.readString();
			cache.DOCUMENT_DOWNLOAD_ADDRESS = source.readString();
			cache.DOCUMENT_UPLOAD_ADDRESS = source.readString();
			cache.USER_PHOTO_URL = source.readString();
			cache.PHOTO_UPLOAD_ADDRESS = source.readString();
			cache.DOC_CONTENT_DOWNLOAD_ADDRESS = source.readString();
			cache.FILE_DELETE_URL = source.readString();
			cache.ORG_ID = source.readString();
			cache.ORG_DISPLAY_NAME = source.readString();
			cache.ORG_DEFAULT_LOGO = source.readString();
			cache.ORG_LOGO_URL = source.readString();
			cache.ORG_BG_URL = source.readString();
			cache.IS_HAVE_SMS_RIGHT = source.readString();
			cache.IS_HAVE_RELATIVEORG = source.readString();
			cache.IS_HAVE_MEETING_APPLY = source.readString();
			cache.CUST_SERVICE_ONLINE = source.readString();
			cache.ADDRESS_PC_URL = source.readString();
			cache.SIGNATURE = source.readString();
			cache.OFFICE_PHONE = source.readString();
			cache.DEPTS = source.readString();
			cache.RIGHTS = source.readString();
			cache.HELP_URL = source.readString();
			
            cache.calList = source.readArrayList(ArrayList.class.getClassLoader());
            cache.calAgentList = source.readArrayList(ArrayList.class.getClassLoader());
            
			cache.calendarList = source.readArrayList(ArrayList.class.getClassLoader());
			cache.MENUS_RIGHT = source.readArrayList(ArrayList.class.getClassLoader());
			cache.MENU_LIST = source.readArrayList(ArrayList.class.getClassLoader());
			cache.SCREENWIDTH = source.readInt();
			
			return cache;
		}

		@Override
		public Cache[] newArray(int size) {
			return null;
		}
	};
}
