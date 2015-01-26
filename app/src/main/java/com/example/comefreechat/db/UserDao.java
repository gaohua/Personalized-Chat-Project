package com.example.comefreechat.db;

import android.content.Context;


public class UserDao {
	public static final String TABLE_NAME = "uers";
	/**用户手机号码环信默认叫username*/
	public static final String COLUMN_USER_MDN = "usermdn";
	/**用户Id*/
	public static final String COLUMN_USER_ID = "userid";
	/**用户手机头像连接地址*/
	public static final String COLUMN_USER_PHOTO_URL = "user_photo_url";
	/**用户昵称*/
	public static final String COLUMN_NAME_NICK = "nick";
	public static final String COLUMN_NAME_IS_STRANGER = "is_stranger";

	private DbOpenHelper dbHelper;

	public UserDao(Context context) {
		dbHelper = DbOpenHelper.getInstance(context);
	}

	/**
	 * 保存好友list
	 * 
	 * @param contactList
	 */
//	public void saveContactList(List<User> contactList) {
//		SQLiteDatabase db = dbHelper.getWritableDatabase();
//		if (db.isOpen()) {
//			db.delete(TABLE_NAME, null, null);
//			for (User user : contactList) {
//				ContentValues values = new ContentValues();
//				values.put(COLUMN_USER_ID, user.getUserId());
//				values.put(COLUMN_USER_PHOTO_URL, user.getUserPhotoUrl());
//				values.put(COLUMN_USER_MDN, user.getUsername());
//				if(user.getNick() != null)
//					values.put(COLUMN_NAME_NICK, user.getNick());
//				db.replace(TABLE_NAME, null, values);
//			}
//	}
//	}

}
