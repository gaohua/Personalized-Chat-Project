package com.example.comefreechat.utils;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 自定义toast
 * @auto zhaowt
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>公司名称 : 中国电信甘肃万维公司</p>
 * <p>项目名称 : cdyx</p>
 * <p>创建时间 : 2012-5-30 上午09:57:48</p>
 * <p>类描述 : 持续显示Toast</p>
 *
 *
 * @version 1.0.0
 * @author <a href=" ">gaohq</a>
 */
public class ToastUtil {

	private Toast toast = null;
	private Context context;
	private Handler handler = null;
	private String content = "";
	private Runnable toastThread = new Runnable() {
		public void run() {
			toast.setText(Html.fromHtml(content));
			toast.show();
			// 3.3秒后再度重启，设为4s的话将会看到Toast是断断续续地显示着的。
			handler.postDelayed(toastThread, 3300);
		}
	};

	public ToastUtil(Context context) {
		this.context = context;
		handler = new Handler(this.context.getMainLooper());
		toast = Toast.makeText(this.context, "", Toast.LENGTH_LONG);
		LinearLayout  out= (LinearLayout) toast.getView();
		 //设置Toast文字字体大小  R.id.message  android源码/framework/base目录里
		TextView tv=(TextView) out.findViewById(R.id.message);
		tv.setTextSize(16);
	}

	public void setText(String text) {
		content = text;
	}

	public void showToast(final long length) {
		handler.post(toastThread);
		Thread timeThread = new Thread() {
			public void run() {
				try {
					Thread.sleep(length);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ToastUtil.this.stopToast();
			}
		};
		timeThread.start();
	}

	public void stopToast() {
		// 删除Handler队列中的仍处理等待的消息元素删除
		handler.removeCallbacks(toastThread);
		toast.cancel();
	}

}
