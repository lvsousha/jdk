package com.stone.proxy.jdk;

import org.apache.log4j.Logger;

public class UserServiceImpl implements UserService{

	private Logger log = Logger.getRootLogger();
	
	@Override
	public void add() {
		log.info("add");
		delete();
	}

	@Override
	public void delete() {
		log.info("delete");
		
	}

}
