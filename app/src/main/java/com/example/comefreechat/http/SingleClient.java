package com.example.comefreechat.http;



import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import com.example.comefreechat.utils.ConfigurationHelper;




public class SingleClient implements HttpClientPool{
	
	private static int timeoutConnection = ConfigurationHelper.getPropertyByInt("client.timeout"); //连接超时时间  
	private static int timeoutSocket = ConfigurationHelper.getPropertyByInt("client.socketout");  //读取数据超时时间
	
	 public SingleClient()
     {
         HttpClient client = new DefaultHttpClient();
         ClientConnectionManager mgr = client.getConnectionManager();
         if (!(mgr instanceof ThreadSafeClientConnManager)) {
             HttpParams params = client.getParams();
             
             HttpConnectionParams.setConnectionTimeout(params, timeoutConnection);// 设置连接超时时间(单位毫秒) 
             HttpConnectionParams.setSoTimeout(params, timeoutSocket); // 设置读数据超时时间(单位毫秒) 
             
             client = new DefaultHttpClient(new ThreadSafeClientConnManager(params,
                     mgr.getSchemeRegistry()), params);
         }
         this.client = client;
     }

     private final HttpClient client;

     public HttpClient getHttpClient()
     {
         return client;
     }
}
