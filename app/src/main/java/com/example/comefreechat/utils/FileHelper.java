package com.example.comefreechat.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;



import sun.misc.BASE64Encoder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

/**
 * 文件帮助类
 * 
 * @author ht
 * @date 2012-5-7
 */
public class FileHelper {

	public static final String FILE_DIR = android.os.Environment
			.getExternalStorageDirectory().getPath()
			+ ConfigurationHelper.getPropertyByStr("client.filePath");
	public static final String CACHE_DIR = FILE_DIR + "/cache/";
	public static final String HEAD_PATH = FILE_DIR + "/conhead/"; 
	public static final String HEADER_PATH = FILE_DIR + "/header/";
	public static final String SIGN_PATH = FILE_DIR + "/sign/";
	public static final String ATTACH_PATH = FILE_DIR + "/attach/";
	/** 我的动态图片缓存地址   */
	public static final String MINE_NEWS_PIC = FILE_DIR + "/news_pic/";
	/** 公告图片缓存地址   */
	public static final String NOTICE_NEWS_PIC = FILE_DIR + "/notice_pic/";
	/** 我的动态表情图片缓存地址   */
	public static final String MINE_NEWS_FACE_PIC = FILE_DIR + "/news_face_pic/";
	/** 启动页之节日问候图片缓存地址   */
	public static final String LOGIN_START_PAGE = FILE_DIR + "/login_start_page/";
	/**
	 * 初始化应用目录
	 */
	public static void initDir(){
		try{
			new Thread(new Runnable() {
				public void run() {
					File filesDir = new File(FILE_DIR);
					if (!filesDir.exists()) {
						filesDir.mkdirs();
					}
					File cacheDir = new File(CACHE_DIR);
					if (!cacheDir.exists()) {
						cacheDir.mkdirs();
					}
					File headDir = new File(HEAD_PATH);
					if (!headDir.exists()) {
						headDir.mkdirs();
					}
					File headerDir=new File(HEADER_PATH);
					if (! headerDir.exists()) {
						headerDir.mkdirs();
					}
					File attachDir = new File(ATTACH_PATH);
					if (!attachDir.exists()) {
						attachDir.mkdirs();
					}
					File mineNewsPic = new File(MINE_NEWS_PIC);
					if (!mineNewsPic.exists()) {
						mineNewsPic.mkdirs();
					}
					File noticeNewsPic = new File(NOTICE_NEWS_PIC);
					if (!noticeNewsPic.exists()) {
						noticeNewsPic.mkdirs();
					}
					File mineNewsFacePic = new File(MINE_NEWS_FACE_PIC);
					if (!mineNewsFacePic.exists()) {
						mineNewsFacePic.mkdirs();
					}
					File loginStartPage = new File(LOGIN_START_PAGE);
					if (!loginStartPage.exists()) {
						loginStartPage.mkdirs();
					}
					//删除手写签批的文件
					try {
						File signDirDelete=new File(SIGN_PATH);
						if(signDirDelete.exists()){
							FileHelper.deleteDir(signDirDelete);
						}
					} catch (Exception e) {
						Log.i("com.gsww.nmaphone.activity", "手写签批文件夹删除失败");
					}
					
					filesDir = null;
					cacheDir = null;
					headDir = null;
					headerDir=null;
				}
				
			
			}).start();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 方法描述 : 判断文件是否存在
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean existFile(String fileName) {
		String filePath = getFilePath(fileName);
		File f = new File(filePath);
		return f.exists();
	}
	
	/**
	 * 
	 * 方法描述 : 保存文件到本地
	 * 
	 * @param is
	 * @param fileName
	 * @throws Exception
	 */
	public static void saveFile(InputStream is, String fileName)
			throws Exception {
		String filePath = getFilePath(fileName);
		File filesDir = new File(FILE_DIR);
		if (!filesDir.exists()) {
			filesDir.mkdirs();
		}
		// 文件
		/*
		 * File file = new File(filePath); if (!file.exists()) { try {
		 * file.createNewFile(); } catch (IOException e) { e.printStackTrace();
		 * } }
		 */

		FileOutputStream fos = new FileOutputStream(filePath);
		int ch;
		StringBuffer b = new StringBuffer();
		byte buf[] = new byte[128];
		int numread;
		while ((numread = is.read(buf)) != -1) {
			ch = numread;
			b.append((char) ch);
			fos.write(buf, 0, numread);
			fos.flush();
		}
		/* 将文件写入SdCard */
		/*
		 * BufferedOutputStream os = null; os = new BufferedOutputStream(new
		 * FileOutputStream(file)); byte[] buff = new byte[1024 * 20]; int len;
		 * while ((len = is.read(buff)) != -1) { os.write(buff, 0, len);
		 * os.flush(); }
		 */
		// os.close();
		fos.close();
		is.close();
	}
	/**
	 * 
	 * 方法描述 : 保存文件到本地
	 * 
	 * @param is
	 * @param mFileName
	 * @throws Exception
	 */
	public static void saveFiles(InputStream is, String filePath)throws Exception {
		File file = new File(filePath);
		if(!file.exists())
			file.createNewFile();
		FileOutputStream fos = new FileOutputStream(file);
		int ch;
		StringBuffer b = new StringBuffer();
		byte buf[] = new byte[128];
		int numread;
		while ((numread = is.read(buf)) != -1) {
			ch = numread;
			b.append((char) ch);
			fos.write(buf, 0, numread);
			fos.flush();
		}
		fos.close();
		is.close();
	}

	/**
	 * 
	 * 方法描述 : 将图片压缩并裁剪保存文件到本地
	 * 
	 * @param is
	 * @param mFileName
	 * @throws Exception
	 */
	public static void saveFiles(InputStream is, String filePath,String comeKind)throws Exception {
		Bitmap bm = null;
		InputStream ls = null;
		int height = 0;
		bm = InputStream2Bitmap(is);
//		bm=ImageHelper.compress(bm,Cache.SCREENWIDTH,Cache.SCREENWIDTH,60,100,Bitmap.CompressFormat.PNG);
		bm=ImageHelper.compressImage(bm,60, 100,Bitmap.CompressFormat.PNG) ;
		//适配不同屏幕
		if (Cache.SCREENWIDTH >= 480 && Cache.SCREENWIDTH < 720) {
			height = 240;
		}else{
			height = 400;
		}
		bm = ImageHelper.cutBitmap(bm, 0, 0,height);	
		ls = Bitmap2InputStream(bm);
		
		File file = new File(filePath);
		if(!file.exists())
			file.createNewFile();
		FileOutputStream fos = new FileOutputStream(file);
		int ch;
		StringBuffer b = new StringBuffer();
		byte buf[] = new byte[128];
		int numread;
		while ((numread = ls.read(buf)) != -1) {
			ch = numread;
			b.append((char) ch);
			fos.write(buf, 0, numread);
			fos.flush();
		}
		fos.close();
		ls.close();
		is.close();
	}
	
    // 将InputStream转换成Bitmap  
    public static Bitmap InputStream2Bitmap(InputStream is) {  
        return BitmapFactory.decodeStream(is);  
    }  
    
	  // 将Bitmap转换成InputStream  
    public static InputStream Bitmap2InputStream(Bitmap bm) {  
        ByteArrayOutputStream baos = new ByteArrayOutputStream();  
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);  
        InputStream is = new ByteArrayInputStream(baos.toByteArray());  
        return is;  
    }  
    
	/**
	 * 
	 * 方法描述 : 加载本地文件
	 * 
	 * @param fileName
	 * @return
	 */
	public static InputStream loadFile(String fileName) {
		String filePath = getFilePath(fileName);
		InputStream is = null;
		try {
			is = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return is;
	}

	/**
	 * 
	 * 方法描述 : 加载本地文件
	 * 
	 * @param mFileName
	 * @return
	 */
	public static InputStream loadFileNew(String filePath) {
		InputStream is = null;
		try {
			is = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return is;
	}

	/**
	 * 
	 * 方法描述 : 清除应用数据
	 * 
	 * @param context
	 * @return
	 */
	public static void clearAppData(Context context) {
		File dir = new File(FILE_DIR);
		deleteDir(dir);
		dir = new File(context.getCacheDir().getParent());
		deleteDir(dir);
	}

	/**
	 * 
	 * 方法描述 : 获取文件路径
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getFilePath(String fileName) {
		fileName = fileName.substring(fileName.lastIndexOf("/") + 1,
				fileName.length());
		return FileHelper.ATTACH_PATH + fileName;
	}
	/**
	 * 
	 * 方法描述 : 获取文件路径
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getFilePaths(String fileName,int comeKind) {
		fileName = fileName.substring(fileName.lastIndexOf("/") + 1,
				fileName.length());
		if (comeKind==1) {			
			return FileHelper.FILE_DIR+File.separator+"header"+File.separator + fileName;
		}else if (comeKind==2) {
			return FileHelper.FILE_DIR+File.separator+"appicon"+File.separator + fileName;
		}else {
			return FileHelper.ATTACH_PATH+fileName;
		}
	}

	/**
	 * 删除目录
	 * 
	 * @param dir
	 */
	public static void deleteDir(File dir) {
		if (dir == null || !dir.exists() || !dir.isDirectory())
			return; // 检查参数
		for (File file : dir.listFiles()) {
			if (file.isFile()) {
				file.delete(); // 删除所有文件
			} else if (file.isDirectory()) {
				deleteDir(file); // 递规的方式删除文件夹
			}
		}
		dir.delete();// 删除目录本身
	}

	/******************* 缓存数据相关 **********************/

	public static void saveCacheFiles(String url,String params, String content) {
		FileWriter writer = null;
		try {
			File filesDir = new File(CACHE_DIR);
			if (!filesDir.exists()) {
				filesDir.mkdirs();
			}
			String fileName = new MD5Utils().getMD5ofStr(url+ params);
			writer = new FileWriter(new File(CACHE_DIR + fileName));
			writer.write(content);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(writer!=null){
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static String loadCacheFiles(String url,String params) {
		BufferedReader reader = null;
		try {
			String tempString = null;
			StringBuffer sb = new StringBuffer();
			String fileName = new MD5Utils().getMD5ofStr(url+params);
			reader = new BufferedReader(new FileReader(CACHE_DIR
					+ fileName));
			while ((tempString = reader.readLine()) != null) {
				sb.append(tempString);
			}
			reader.close();
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
                try {
                	reader.close();
                } catch (IOException e1) {
                }
            }
		}
		return "";
	}
	/**把图片转化为字符串*/
	public static String encodeBase64File(File file) throws Exception {
		FileInputStream inputFile = new FileInputStream(file);
		byte[] buffer = new byte[(int) file.length()];
		inputFile.read(buffer);
		inputFile.close();
		return new BASE64Encoder().encode(buffer);

	}
	public static boolean deleteFile(String path){
		try {
			File file=new File(path);
			if (file.exists()) {
				file.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
		return true;
	}
	/**
	 * 根据传入的大小（字节数）返回相应的带单位的大小 
	 * @param size -- 大小（字节数）
	 * @return -- 带单位的大小
	 */
	public static String getShowFileSize(long size) {
		if (size < 1024) {
			return size + "B";
		} else if (size < 1024 * 1024) {
			return (size / 1024) + "KB";
		} else {
			return size / (1024 * 1024) + "MB";
		}
	}
	/**
	 * 将文件大小转化为字节
	 * @param str
	 * @return
	 */
	public static String switchSize(String str) {
		char[] char_arr = str.toCharArray();
		int i = 0;
		for (i = 0; i < char_arr.length; i++) {
			int a=((int)char_arr[i]);
			if (!((a>47 && a <58) || a == 46)) {
				break;
			}
		}
		str = str.substring(0, i);
		return str;
	}
}
