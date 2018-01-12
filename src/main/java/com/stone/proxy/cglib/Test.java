package com.stone.proxy.cglib;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

public class Test {
	public static void main(String[] args) {
		Logger log = Logger.getRootLogger();
		BookServiceBean service = BookServiceFactory.getProxyInstance(new MyCglibProxy("张三"));
		service.create();

		log.info("我们得到的bean是：" + service.getClass());
		System.out.println("实际调用者的父类：" + service.getClass().getSuperclass());
		try {
			Class<?> c = Class.forName(service.getClass().getName());
			Class<?> beanc = Class.forName(service.getClass().getSuperclass().getName());

			Method[] beanc_method = beanc.getMethods();
			int i = 1;
			System.out.println("原始的bean的方法总共" + beanc_method.length + "个");
			for (Method method : beanc_method) {

				System.out.println("原始的bean方法" + i++ + method.getName());

			}
			i = 1;
			Method[] methods = c.getMethods();
			System.out.println("我们得到的bean的方法总共" + methods.length + "个");
			for (Method method : methods) {
				System.out.println("我们得到的bean的方法" + i++ + method.getName());
			}
			System.out.println("原始的bean的父类：" + beanc.getSuperclass());
			System.out.println("我们得到的bean的父类：" + c.getSuperclass());

			Field[] bean_fields = beanc.getDeclaredFields();
			i = 1;
			for (Field field : bean_fields) {
				System.out.println("原始bean的属性 " + i++ + field);
			}

			Field[] fields = c.getDeclaredFields();
			i = 1;
			for (Field field : fields) {
				System.out.println("我们得到的bean的属性 " + i++ + field);
			}
			Class<?> proxyGenerator = Class.forName("sun.misc.ProxyGenerator");
			Method[] methods2 = proxyGenerator.getMethods();
			for (Method method : methods2) {
				System.out.println(method);
				byte[] TempProxySuper = (byte[]) method.invoke(proxyGenerator, "TempProxySuper", new Class[] { c.getSuperclass() });
				byte[] TempProxy = (byte[]) method.invoke(proxyGenerator, "TempProxy", new Class[] { c });
				byte[] TempBean = (byte[]) method.invoke(proxyGenerator, "TempBean", new Class[] { beanc });
				createClassFile("TempProxy", TempProxy);
				createClassFile("TempProxySuper", TempProxySuper);
				createClassFile("TempBean", TempBean);
				break;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 生成class文件
	 * 
	 * @param fileName
	 * @param classFile
	 */
	public static void createClassFile(String fileName, byte[] classFile) {
		try {
			File file;
			FileOutputStream fos = new FileOutputStream(file = new File(fileName + ".class"));
			fos.write(classFile);
			fos.flush();
			fos.close();
			System.out.println(file.getAbsolutePath());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
