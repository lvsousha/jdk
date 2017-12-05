package com.stone.thread.T11;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public class ThreadPoolTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Logger log = Logger.getRootLogger();
		final ThreadPoolExecutor pool = new ThreadPoolExe1(
				5, 
				5, 
				1, 
				TimeUnit.SECONDS,
	            new ArrayBlockingQueue<Runnable>(5));
		pool.allowCoreThreadTimeOut(true);
			pool.execute(new Runnable() {
				@Override
				public void run() {
					log.info(Thread.currentThread().getName()+" IN");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					log.info(Thread.currentThread().getName()+" OUT");
					log.info(pool.toString());
				}
			});
			pool.execute(new Runnable() {
				@Override
				public void run() {
					log.info(Thread.currentThread().getName()+" IN");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					log.info(Thread.currentThread().getName()+" OUT");
					log.info(pool.toString());
				}
			});
	}

}
