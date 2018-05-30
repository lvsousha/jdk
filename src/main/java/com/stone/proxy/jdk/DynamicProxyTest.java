package com.stone.proxy.jdk;

public class DynamicProxyTest {
	
	public static void main(String[] args) {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		UserService userService = new UserServiceImpl();
		MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);

		UserService proxy = (UserService) invocationHandler.getProxy();
		proxy.add();
		proxy.delete();
	}
}
