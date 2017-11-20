package com.stone.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostJson {

	private static final String UPLOAD_FILE = "http://localhost:9080/stonecloud/test";
	
	public static void main(String[] args) throws Exception {
		String param = "name=zcl&password=123456";
		PostJson.uploadToFarService(param);
	}
	
	public static void uploadToFarService(String param){
		try {  
            URL url = new URL(UPLOAD_FILE);  
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();  
            // 发送POST请求必须设置如下两行  
            conn.setDoOutput(true);  
            conn.setDoInput(true);  
            conn.setUseCaches(false);  
            conn.setRequestMethod("POST");  
            conn.setRequestProperty("connection", "Keep-Alive");  
            conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");  
            conn.setRequestProperty("Charsert", "UTF-8");  
//            conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");    
//            conn.setRequestProperty("Content-Type","application/json");  
            conn.setRequestProperty("Content-Type","text/plain");    
  
            OutputStream out = new DataOutputStream(conn.getOutputStream());  
            out.write(param.getBytes());
            out.flush();  
            out.close();  
  
            // 定义BufferedReader输入流来读取URL的响应  
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));  
            String line = null;  
            while ((line = reader.readLine()) != null) {  
                System.out.println(line);  
            }  
  
        } catch (Exception e) {  
            System.out.println("发送POST请求出现异常！" + e);  
            e.printStackTrace();  
        }  
    }  
}
