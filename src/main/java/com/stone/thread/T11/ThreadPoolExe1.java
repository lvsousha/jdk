package com.stone.thread.T11;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public class ThreadPoolExe1 extends ThreadPoolExecutor{

	private Logger log = Logger.getLogger(this.getClass());
	
	public ThreadPoolExe1(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		// TODO Auto-generated constructor stub
	}
	
	protected void afterExecute(Runnable r, Throwable t){
		log.info(this.getQueue().size()+"=="+this.getActiveCount());
		if(this.getQueue().size() == 0 && this.getActiveCount() == 1){
			log.info("IN");
			log.info(this.toString());
			try {
				Thread.sleep(5000);
				this.allowCoreThreadTimeOut(false);
			} catch (InterruptedException e) {
				log.error("",e);
			}
		}
	}
	
	protected void beforeExecute(Thread t, Runnable r){
		if(!this.allowsCoreThreadTimeOut()){
			this.allowCoreThreadTimeOut(true);
		}
	}

	

}
