package com.wjsdta;

import java.util.concurrent.locks.ReentrantLock;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: WJ
 * \* Date: 2019/3/17
 * \* Time: 21:45
 * \* To change this template use File | Settings | File Templates.
 * \* Description:多线程共享数据，会发生线程不安全情况（）,必须使用线程锁
 * \
 */
public class Demo04 {
    public static void main(String[] args) {
        MyRunable5 myRunable5 = new MyRunable5();
        Thread thread = new Thread(myRunable5);
        Thread thread1 = new Thread(myRunable5);
        thread.start();
        thread1.start();

    }
}
class MyRunable5 implements Runnable{
    private int ticket = 10;
    private Object j = new Object();
    @Override
    public void run() {
       for (int i = 0; i <10 ; i++) {
          /* synchronized (this){
               ticket--;
               if(ticket >0){
                   //System.out.println();
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println("你购买的票剩余"+ticket+"张");
               }

           }*/
          method();
        }

    }
    private synchronized void method(){//同步方法：同步当前对象

            ticket--;
            if(ticket >0){
                //System.out.println();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("你购买的票剩余的"+ticket+"张");
            }


    }
    //互斥锁
    ReentrantLock lock = new ReentrantLock();
    //LOCk实现同步
    private  void method2(){//同步方法：同步当前对象
        lock.lock();//锁
        ticket--;
        if(ticket >0){
            //System.out.println();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("你购买的票剩余"+ticket+"张");
        }
        lock.unlock();//释放锁

    }
}