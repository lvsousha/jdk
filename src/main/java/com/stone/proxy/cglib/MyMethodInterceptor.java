package com.stone.proxy.cglib;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyMethodInterceptor implements MethodInterceptor {
  /**
   * sub：cglib生成的代理对象 method：被代理对象方法 objects：方法入参 methodProxy: 代理方法
   */
  @Override
  public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy)
      throws Throwable {
    System.out.println("======插入前置通知======");
    Object object = methodProxy.invokeSuper(sub, objects);
//    Object object = methodProxy.invoke(sub, objects);
    System.out.println("======插入后者通知======");
    return object;
  }
}
