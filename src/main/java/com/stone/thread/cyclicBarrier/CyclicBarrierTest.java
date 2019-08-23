package com.stone.thread.cyclicBarrier;

import java.lang.reflect.Field;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class CyclicBarrierTest {

  private static CyclicBarrier cyclicBarrier;

  static class CyclicBarrierThread extends Thread {
    public void run() {
      System.out.println(Thread.currentThread().getName() + "到了");
      // 等待
      try {
        Field lock = CyclicBarrier.class.getDeclaredField("lock");
        lock.setAccessible(true);
        ReentrantLock reentrantLock = (ReentrantLock) lock.get(cyclicBarrier);
        Field sync = ReentrantLock.class.getDeclaredField("sync");
        sync.setAccessible(true);
        AbstractQueuedSynchronizer aqs = (AbstractQueuedSynchronizer) sync.get(reentrantLock);
        cyclicBarrier.await();
        System.out.println("START:" + aqs.getQueueLength());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    cyclicBarrier = new CyclicBarrier(5, new Runnable() {
      @Override
      public void run() {
        System.out.println("人到齐了，开会吧....");
      }
    });

    for (int i = 0; i < 5; i++) {
      new CyclicBarrierThread().start();
    }
  }
}
