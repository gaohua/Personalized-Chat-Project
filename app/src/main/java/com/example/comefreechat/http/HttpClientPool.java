package com.example.comefreechat.http;




/**
 * 
 * A source of Apache HttpClient 4 objects.
 * 
 * This class relies on <a href="http://hc.apache.org">Apache HttpClient</a>
 * version 4.
 * 
 * @author Sean Sullivan
 */
public interface HttpClientPool {

    /** Get the appropriate HttpClient for sending a request to the given URL. */
    public org.apache.http.client.HttpClient getHttpClient();

}
