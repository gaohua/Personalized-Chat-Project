package com.example.comefreechat.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
/**
 * 图片处理工具类
 * @author wuhr
 *
 */
public class ImageHelper {
	/**
	 *  图片质量压缩
	 * @param image 要压缩的图片
	 * @param compress 压缩率 100表示100% ，1表示 1%
	 * @param imgeSize 最后图片的大小
	 * @param CompressFormat 图片压缩格式   如：Bitmap.CompressFormat.JPEG
	 * @return 反回压缩后的图片
	 */
	public static Bitmap compressImage(Bitmap image,int compress,int imgeSize,CompressFormat format  ) {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		image.compress(format, compress, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
		int options = compress;//压缩率
		while ( baos.toByteArray().length / 1024 >imgeSize) {	//循环判断如果压缩后图片是否大于imgeSize kb,大于继续压缩		
			baos.reset();//重置baos即清空baos
			image.compress(format, (int)options, baos);//这里压缩options%，把压缩后的数据存放到baos中
			if (options==10) {
				break;
			}else {
				options -= 10;//每次都减少10
			}
		}
		ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中
		Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片
		return bitmap;
	}
	/**
	 * 图片按比例大小压缩方法（根据路径获取图片并压缩）：
	 * @param srcPath 图片路径
	 * @return 返回缩放后的图片
	 */
	public static Bitmap getimage(String srcPath,float width,float height) {
		BitmapFactory.Options newOpts = new BitmapFactory.Options();
		//开始读入图片，此时把options.inJustDecodeBounds 设回true了
		newOpts.inJustDecodeBounds = true;
		Bitmap bitmap = BitmapFactory.decodeFile(srcPath,newOpts);//此时返回bm为空
		
		newOpts.inJustDecodeBounds = false;
		int w = newOpts.outWidth;
		int h = newOpts.outHeight;
		//现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
		float hh = height;//这里设置高度
		float ww = width;//这里设置宽度
		//缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
		int be = 1;//be=1表示不缩放
		if (w > h && w > ww) {//如果宽度大的话根据宽度固定大小缩放
			be = (int) (newOpts.outWidth / ww);
		} else if (w < h && h > hh) {//如果高度高的话根据宽度固定大小缩放
			be = (int) (newOpts.outHeight / hh);
		}
		if (be <= 0)
			be = 1;
		newOpts.inSampleSize = be;//设置缩放比例
		//重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
		bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
		return bitmap;//压缩好比例大小后再进行质量压缩
	}
	/**
	 * 图片按比例大小压缩方法（根据Bitmap图片压缩）
	 * @param image 要缩放的图片
	 * @param compress 压缩率 100表示100% ，1表示 1%
	 * @param imgeSize 最后图片的大小 KB 不要大于1024KB避免在生成图片（BitmapFactory.decodeStream）时溢出
	 * @param format 图片压缩格式   如：Bitmap.CompressFormat.JPEG
	 * @return bitmap 返回缩放后的图片
	 */
	@SuppressWarnings("unused")
	public static Bitmap compress(Bitmap image, int width,int height,int compress,int imgeSize,CompressFormat format) {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();		
		image.compress(format, imgeSize, baos);
		if( (baos.toByteArray().length / 1024)>imgeSize) {//判断如果图片大于imgeSize	
			baos.reset();//重置baos即清空baos
			image.compress(format, compress, baos);//这里压缩50%，把压缩后的数据存放到baos中
		}
		ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
		BitmapFactory.Options newOpts = new BitmapFactory.Options();
		//开始读入图片，此时把options.inJustDecodeBounds 设回true了
		newOpts.inJustDecodeBounds = true;
		Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
		newOpts.inJustDecodeBounds = false;
		int w = newOpts.outWidth;
		int h = newOpts.outHeight;
		
		float hh = width;//这里设置高度
		float ww = height;//这里设置宽度
		//缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
		int be = 1;//be=1表示不缩放
		if (w > h && w > ww) {//如果宽度大的话根据宽度固定大小缩放
			be = (int) (newOpts.outWidth / ww);
		} else if (w < h && h > hh) {//如果高度高的话根据宽度固定大小缩放
			be = (int) (newOpts.outHeight / hh);
		}
		if (be <= 0)
			be = 1;
		newOpts.inSampleSize = be;//设置缩放比例
		//重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
		isBm = new ByteArrayInputStream(baos.toByteArray());
		bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
		return bitmap;//压缩好比例大小后再进行质量压缩
	}
	
	/**
	 * 对缩放后有图片进行截取
	 * @param bitmap 要截取的图片
	 * @param width 要截取有宽度
	 * @param height 要截取有高度
	 * @param x 开始坐标x
	 * @param y 开始坐标y
	 * @return
	 */
    public static Bitmap cutBitmap(Bitmap bitmap,int x,int y, int width,int height){
    	Bitmap mBitmap=null;
		if (null == bitmap || width <= 0 ||height <= 0) {//参数错误
			return mBitmap;
		}
		float widthOrg = bitmap.getWidth(); //获取图片的宽度
		float heightOrg = bitmap.getHeight();//获取图片的高度
		if (widthOrg > width && heightOrg > height) {
			try {
				mBitmap = Bitmap.createBitmap(bitmap, x, y, width, height);  
			} catch (Exception e) {
				e.printStackTrace();
			}
		 } 
		return mBitmap;
	}
    /**
     * 对缩放后有图片进行高度的截取
     * @param bitmap 要截取的图片
     * @param x 开始坐标x
     * @param y 开始坐标y
     * @param height 要截取有高度
     * @return
     */
    public static Bitmap cutBitmap(Bitmap bitmap,int x,int y,int height){
    	Bitmap mBitmap=bitmap;
    	if (null == bitmap ||height <= 0) {//参数错误
    		return null;
    	}
    	int widthOrg = bitmap.getWidth(); //获取图片的宽度
    	int heightOrg = bitmap.getHeight();//获取图片的高度
    	if ( heightOrg > height) {
    		try {
    			mBitmap = Bitmap.createBitmap(bitmap, x, y, widthOrg , height);  
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	} 
    	return mBitmap;
    }
    
}
