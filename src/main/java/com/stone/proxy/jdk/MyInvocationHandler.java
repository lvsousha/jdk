package com.stone.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.apache.log4j.Logger;

public class MyInvocationHandler implements InvocationHandler {
	private Object target;
	private Logger log = Logger.getRootLogger();
	
	public MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		log.info("----- before -----");
		Object result = method.invoke(target, args);
		log.info("----- after -----");
		return result;
	}

}
