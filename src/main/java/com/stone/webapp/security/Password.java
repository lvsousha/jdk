package com.stone.webapp.security;

import java.lang.reflect.Method;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Password {

	private static final String HMAC_SHA1 = "HmacSHA1";
	private static final String ENCODING = "UTF-8";
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Password t = new Password();
		String data = "";
		String key = "";
		String result = "";
		byte[] encryData = t.getSignature(data.getBytes(ENCODING), key.getBytes(ENCODING));
		String encode = t.encodeBase64(encryData);
		System.out.println(encode);
		System.out.println(encode.equals(result));
	}
	
	
	public byte[] getSignature(byte[] data, byte[] key) throws InvalidKeyException, NoSuchAlgorithmException {  
        SecretKeySpec signingKey = new SecretKeySpec(key, HMAC_SHA1);  
        Mac mac = Mac.getInstance(HMAC_SHA1);  
        mac.init(signingKey);  
        byte[] rawHmac = mac.doFinal(data);  
        return rawHmac;  
    }
	
	public String encodeBase64(byte[]input) throws Exception{  
        Class<?> clazz=Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");  
        Method mainMethod= clazz.getMethod("encode", byte[].class);  
        mainMethod.setAccessible(true);  
         Object retObj=mainMethod.invoke(null, new Object[]{input});  
         return (String)retObj;  
    }

}
