package com.stone.thread.copyOnWriteArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest1 {// TODO: list是ArrayList对象时，程序会出错。
	// private static List<String> list = new ArrayList<String>();
	private static List<String> list = new CopyOnWriteArrayList<String>();

	public static void main(String[] args) {
		final List<String> list = new CopyOnWriteArrayList<String>();
		list.add("insert");
		// 同时启动两个线程对list进行操作！
		new MyThread("ta").start();
		new MyThread("tb").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000l);
					list.set(0, "update");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					String s = list.get(0);
					System.out.println(s);
					Thread.sleep(10000l);
					System.out.println(s);
					System.out.println("dd"+list.get(0));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}

	private static void printAll() {
		String value = null;
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			value = (String) iter.next();
			System.out.print(value + ", ");
		}
		System.out.println(value+"OUT");
	}

	private static class MyThread extends Thread {
		MyThread(String name) {
			super(name);
		}

		@Override
		public void run() {
			int i = 0;
			while (i++ < 6) {
				// “线程名” + "-" + "序号"
				String val = Thread.currentThread().getName() + "-" + i;
				list.add(val);
				// 通过“Iterator”遍历List。
				printAll();
			}
		}
	}
}
