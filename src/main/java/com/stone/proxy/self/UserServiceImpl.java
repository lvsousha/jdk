package com.stone.proxy.self;

import org.apache.log4j.Logger;

public class UserServiceImpl implements UserService{

	private Logger log = Logger.getRootLogger();
	
	@Override
	public void add() {
		log.info("add");
	}

}
