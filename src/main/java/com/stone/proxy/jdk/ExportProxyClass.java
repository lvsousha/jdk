package com.stone.proxy.jdk;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import sun.misc.ProxyGenerator;

public class ExportProxyClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties propers = System.getProperties();
		for(Object key : propers.keySet()){
			System.out.println(key+"=="+propers.getProperty(key.toString()));
		}
		String path = System.getProperty("user.dir")+"/src/main/resources/$Proxy0.class";
		
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0",  
                UserServiceImpl.class.getInterfaces());  
        FileOutputStream out = null;  
  
        try {  
            out = new FileOutputStream(path);  
            out.write(classFile);  
            out.flush();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                out.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        } 
		
	}

}
