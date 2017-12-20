package com.stone.thread.T5;

public class MyThread extends Thread {

	private String name = "";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		try {
			 t1.start();
			 t2.start();
			Thread.sleep(1000l);
			 t2.interrupt();
			 Thread.sleep(1000l);
			 t1.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("OUT");
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " In");
		try {
		synchronized (this.name) {
			Thread.sleep(5000l);
				while (!this.isInterrupted()) {
//					System.out.println(Thread.currentThread().getName() + " isInterrupted");
					// Thread.sleep(5000l);
					// System.out.println(Thread.currentThread().getName() + "
					// In");
				}
			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(Thread.currentThread().getName() + " Out");
	}

}
