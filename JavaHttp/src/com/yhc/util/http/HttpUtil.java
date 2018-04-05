/**
 * Project Name:JavaHttp
 * File Name:HttpUtil.java
 * Package Name:com.yhc.util.http
 * Date:2017年3月1日上午9:33:36
 * Copyright (c) 2017, yhc8023tm@foxmail.com All Rights Reserved.
 *
*/

package com.yhc.util.http;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ClassName:HttpUtil <br/>
 * Function: TODO 调用API. <br/>
 * Date: 2017年3月1日 上午9:33:36 <br/>
 * 
 * @author YHC
 * @version
 * @since JDK 1.8
 * @see
 */
public class HttpUtil {

	private static String API_KEY_NAME = "apikey";
	private static String API_KEY = "";
	public static String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

	public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
	/**
	 * request:(这里用一句话描述这个方法的作用). <br/>
	 * 
	 * @author YHC
	 * @param httpUrl
	 *            请求链接
	 * @param httpArg
	 *            参数封装“name=123&age=456”
	 * @return 请求结果
	 * @since JDK 1.8
	 */
	public static String request(String httpUrl, String httpArg) {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		httpUrl = httpUrl + "?" + httpArg;

		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			// 填充apikey到HTTP header
			connection.setRequestProperty(API_KEY_NAME, API_KEY);
			connection.setRequestProperty("User-agent", userAgent);
			connection.setUseCaches(false);
			connection.setConnectTimeout(DEF_CONN_TIMEOUT);
			connection.setReadTimeout(DEF_READ_TIMEOUT);
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	/** 
     * 传入要下载的图片的url列表，将url所对应的图片下载到本地 
     * @param urlList 
     */  
    private static void downloadPicture(ArrayList<String> urlList) {  
        URL url = null;  
        int imageNumber = 0;  
          
        for (String urlString : urlList) {  
            try {  
                url = new URL(urlString);  
                DataInputStream dataInputStream = new DataInputStream(url.openStream());  
                String imageName = imageNumber + ".jpg";  
                FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));  
  
                byte[] buffer = new byte[1024];  
                int length;  
  
                while ((length = dataInputStream.read(buffer)) > 0) {  
                    fileOutputStream.write(buffer, 0, length);  
                }  
  
                dataInputStream.close();  
                fileOutputStream.close();  
                imageNumber++;  
            } catch (MalformedURLException e) {  
                e.printStackTrace();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		String httpUrl = "http://api.map.baidu.com/telematics/v3/weather";
		String httpArg = "location=深圳&output=json&ak=6tYzTvGZSOpYB5Oc2YGGOKt8";
		String result = HttpUtil.request(httpUrl, httpArg);
		
		System.out.println(result);
		
		JSONObject object = JSONObject.fromObject(result);
		JSONArray results = object.getJSONArray("results");
		JSONObject resultDet = results.getJSONObject(0);
		System.out.println("空气污染指数："+resultDet.getString("pm25"));
		JSONArray weather_data = resultDet.getJSONArray("weather_data");
		JSONObject today_weather = weather_data.getJSONObject(0);
		System.out.println("城市：武汉");
		System.out.println("当前日期："+today_weather.getString("date"));
		System.out.println("天气："+today_weather.getString("weather"));
		System.out.println("温度："+today_weather.getString("temperature"));
		System.out.println("风向："+today_weather.getString("wind"));
		
		
		
		/*今日天气图片	
		ArrayList<String> urlList = new ArrayList<String>();
		urlList.add(today_weather.getString("dayPictureUrl"));
		urlList.add(today_weather.getString("nightPictureUrl"));
		HttpUtil.downloadPicture(urlList);
		*/
		
	}

}
