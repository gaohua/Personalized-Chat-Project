package com.example.comefreechat.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.example.comefreechat.utils.ConfigurationHelper;
import com.example.comefreechat.utils.Constants;
import com.example.comefreechat.utils.LogUtils;

import android.util.Log;



/**
 * http 数据通讯工具类
 * 
 * @date 2012-5-2
 * 
 */
public class HttpClient implements java.io.Serializable {

	private static final long serialVersionUID = -176092625883595547L;
	
	private static final String LOGTAG = LogUtils
            .makeLogTag(HttpClient.class);
	
	private static final int OK = 200; // OK: Success!
	private static final int NOT_MODIFIED = 304; // Not Modified: There was no
													// new data to return.
	private static final int BAD_REQUEST = 400; // Bad Request: The request was
												// invalid. An accompanying
												// error message will explain
												// why. This is the status code
												// will be returned during rate
												// limiting.
	private static final int NOT_AUTHORIZED = 401; // Not Authorized:
													// Authentication
													// credentials were missing
													// or incorrect.
	private static final int FORBIDDEN = 403; // Forbidden: The request is
												// understood, but it has been
												// refused. An accompanying
												// error message will explain
												// why.
	private static final int NOT_FOUND = 404; // Not Found: The URI requested is
												// invalid or the resource
												// requested, such as a user,
												// does not exists.
	private static final int NOT_ACCEPTABLE = 406; // Not Acceptable: Returned
													// by the Search API when an
													// invalid format is
													// specified in the request.
	private static final int INTERNAL_SERVER_ERROR = 500; // Internal Server
															// Error: Something
															// is broken. Please
															// post to the group
															// so the Weibo team
															// can investigate.
	private static final int BAD_GATEWAY = 502; // Bad Gateway: Weibo is down or
												// being upgraded.
	private static final int SERVICE_UNAVAILABLE = 503; // Service Unavailable:
														// The Weibo servers are
														// up, but overloaded
														// with requests. Try
														// again later. The
														// search and trend
														// methods use this to
														// indicate when you are
														// being rate limited.

	/**
	 * 引擎地址
	 */
	private static String SERVER_URL = ConfigurationHelper
			.getPropertyByStr("server.url");

	/**
	 * 调用后台引擎
	 * 
	 * @param api
	 *            //请求接口
	 * @param params
	 *            //请求参数
	 * @return
	 * @throws Exception
	 */
	public static String post(String api, List<BasicNameValuePair> params)
			throws Exception {
		Log.d(LOGTAG, "Request:");
		Log.d(LOGTAG, "POST:" + SERVER_URL + api);

		HttpClientPool httpClientPool = new SingleClient();
		org.apache.http.client.HttpClient httpClient = httpClientPool
				.getHttpClient();

		for(BasicNameValuePair p :params){
			Log.d(LOGTAG,p.getName()+"......"+p.getValue());
		}
		// post方法提交
		HttpPost post = new HttpPost(SERVER_URL + api);
		try {
			post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage(), e);
		}
		HttpResponse httpResponse;
		try {
			httpResponse = httpClient.execute(post);

			if (httpResponse.getStatusLine().getStatusCode() == OK) {

				String strResult = EntityUtils.toString(
						httpResponse.getEntity(), Constants.CHAR_SET);
				// 缓存数据
//				if (cache != null && cache.equals("true")&&!isException(api)) {
//					FileHelper.saveCacheFiles(api, params.toString(), strResult);
//				}
				Log.d(LOGTAG, "Result:" + strResult);
				return strResult;
			} else {
				Log.e(LOGTAG, "Error Response: "
						+ httpResponse.getStatusLine().toString());
				throw new Exception("服务响应错误: "
						+ getErrorCause(httpResponse.getStatusLine()
								.getStatusCode()));
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new Exception("网络连接错误,请检查您的网络！", e);
		} catch (HttpHostConnectException e1) {
			throw new Exception("服务器连接失败，请联系管理员！", e1);
		} catch (java.net.SocketTimeoutException e1) {
			throw new Exception("连接超时，请重试！", e1);
		} catch (IOException e2) {
			e2.printStackTrace();
			throw new Exception("网络连接错误，请检查您的网络！", e2);
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
	}

	/**
	 * 调用特定接口后台引擎
	 * 
	 * @param url
	 *            //请求接口
	 * @param params
	 *            //请求参数
	 * @return
	 * @throws Exception
	 */
	public static String postParticular(String url, List<BasicNameValuePair> params)
			throws Exception {
		Log.d(LOGTAG, "Request:");
		Log.d(LOGTAG, "POST Particular:" +  url);

		HttpClientPool httpClientPool = new SingleClient();
		org.apache.http.client.HttpClient httpClient = httpClientPool
				.getHttpClient();

		// post方法提交
		HttpPost post = new HttpPost(url);
		for(BasicNameValuePair p :params){
			Log.d(LOGTAG,p.getName()+"......"+p.getValue());
		}
		try {
			post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage(), e);
		}
		HttpResponse httpResponse;
		try {
			httpResponse = httpClient.execute(post);

			if (httpResponse.getStatusLine().getStatusCode() == OK) {

				String strResult = EntityUtils.toString(
						httpResponse.getEntity(), Constants.CHAR_SET);
				Log.d(LOGTAG, "Result:" + strResult);
				return strResult;
			} else {
				Log.e(LOGTAG, "Error Response: "
						+ httpResponse.getStatusLine().toString());
				throw new Exception("服务响应错误: "
						+ getErrorCause(httpResponse.getStatusLine()
								.getStatusCode()));
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new Exception("网络连接错误,请检查您的网络！", e);
		} catch (HttpHostConnectException e1) {
			throw new Exception("服务器连接失败，请联系管理员！", e1);
		} catch (java.net.SocketTimeoutException e1) {
			throw new Exception("连接超时，请重试！", e1);
		} catch (IOException e2) {
			e2.printStackTrace();
			throw new Exception("网络连接错误，请检查您的网络！", e2);
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
	}
	
	 
	/**
	 * 读取远程资源
	 * 
	 * @param url
	 * @return
	 */
	public static InputStream loadResource(String url) throws Exception {
		try {
			URL m;
			URLConnection c;
			InputStream i = null;
			m = new URL(url);
			c = m.openConnection();
			c.setConnectTimeout(ConfigurationHelper
					.getPropertyByInt("client.timeout"));
			c.setReadTimeout(ConfigurationHelper.getPropertyByInt("client.socketout"));
	        if (c.getContent()== null) {
				return null;
			}else {
				i = c.getInputStream();
			}
			return i;
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("网络连接错误，请检查您的网络！", e);
		}
	}

	/**
	 * 获取异常原因
	 * 
	 * @param statusCode
	 * @return
	 */
	private static String getErrorCause(int statusCode) {
		String cause = null;
		switch (statusCode) {
		case NOT_MODIFIED:
			break;
		case BAD_REQUEST:
			cause = "（错误请求）服务器不理解请求的语法.";
			break;
		case NOT_AUTHORIZED:
			cause = "（未授权） 请求要求进行身份验证.";
			break;
		case FORBIDDEN:
			cause = "（已禁止） 服务器拒绝请求.";
			break;
		case NOT_FOUND:
			cause = "（未找到） 服务器找不到请求的网页.";
			break;
		case NOT_ACCEPTABLE:
			cause = "（不接受） 无法使用请求的内容特性来响应.";
			break;
		case INTERNAL_SERVER_ERROR:
			cause = "（服务器内部错误）服务器遇到错误，无法完成请求.";
			break;
		case BAD_GATEWAY:
			cause = "（错误网关） 服务器作为网关或**，从上游服务器收到了无效的响应.";
			break;
		case SERVICE_UNAVAILABLE:
			cause = "（服务不可用） 目前无法使用服务器（由于超载或进行停机维护）.";
			break;
		default:
			cause = "";
		}
		return cause;
	}
}
