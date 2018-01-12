package com.stone.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class BookServiceFactory {
	
	private BookServiceFactory() {

	}

	public static BookServiceBean getProxyInstance(MyCglibProxy myProxy) {
		Enhancer enhancer = new Enhancer();
		// 将Enhancer中的superclass属性赋值成BookServiceBean
		enhancer.setSuperclass(BookServiceBean.class);
		// 将Enhancer中的callbacks属性赋值成myProxy
		enhancer.setCallback(myProxy);
		return (BookServiceBean) enhancer.create();
	}
}
