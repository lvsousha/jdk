package com.stone.proxy.jdk;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
	
	public static void main(String[] args) {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		UserService userService = new UserServiceImpl();
		MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);

		Object proxy = Proxy.newProxyInstance(
            Thread.currentThread().getContextClassLoader(), 
            userService.getClass().getInterfaces(),
            invocationHandler
            );
		
		UserService userServiceProxy = (UserService) proxy;
		userServiceProxy.add();
		userServiceProxy.delete();
	}
}
