package com.stone.proxy.cglib;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BookServiceBean {
	private Logger log = LogManager.getLogger(this.getClass());

	public BookServiceBean() {
		log.info("this is bookservicebean 的构造方法");
	}

	public void create() {
		System.out.println("create() is running!");
	}

	public void query() {
		System.out.println("query() is running!");
	}
}
