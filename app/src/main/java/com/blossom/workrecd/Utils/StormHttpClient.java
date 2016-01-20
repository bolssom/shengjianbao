
package com.blossom.workrecd.Utils;

import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

public class StormHttpClient {
    private static HttpClient customHttpClient;
    // 网络连接超时时间
    public static final int SOCKET_TIME_OUT_TIME = 10000;

    // 网络读取时间
    public static final int SOCKET_READ_TIME = 20000;

    private StormHttpClient() {
    }

    public static HttpClient getInstance() {
        if (customHttpClient == null) {
            HttpParams params = new BasicHttpParams();

            HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(params, HTTP.DEFAULT_CONTENT_CHARSET);
            HttpProtocolParams.setUseExpectContinue(params, true);
            // HttpProtocolParams.setUserAgent(params, useragent);

            ConnManagerParams.setTimeout(params, SOCKET_TIME_OUT_TIME);

            HttpConnectionParams.setConnectionTimeout(params, SOCKET_TIME_OUT_TIME);
            HttpConnectionParams.setSoTimeout(params, SOCKET_READ_TIME);

            SchemeRegistry schReg = new SchemeRegistry();
            schReg.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schReg.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));

            ClientConnectionManager conMgr = new ThreadSafeClientConnManager(params, schReg);

            customHttpClient = new DefaultHttpClient(conMgr, params);
        }

        return customHttpClient;
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
