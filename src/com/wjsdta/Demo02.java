package com.wjsdta;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: WJ
 * \* Date: 2019/3/15
 * \* Time: 21:40
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Demo02 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        MyRunable3 myRunable3 = new MyRunable3();
        Thread t2 = new Thread(myRunable3);
        t2.start();
        thread.start();
        for (int i = 0; i <50 ; i++) {
            System.out.println(Thread.currentThread().getName()+"--"+i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i==20)
            {
               /* try {
                    thread.join();//让t执行完毕，再执行主线程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
              // thread.interrupt();//中断线程，只是做了一个中断标记
                myRunable3.flag =false;
            }

        }

    }
}
/*
* 中断状态
* */
class MyRunable2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <50 ; i++) {
            if(Thread.interrupted())//测试中断状态，此方法会把中断清除
            {
                break;
            }
            System.out.println(Thread.currentThread().getName()+"--"+i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();//再打中断标记
            }

        }
    }
}
/*
* 自定义标记（推荐）
* */
class MyRunable3 implements Runnable{
    public boolean flag = true;
    public MyRunable3(){
        flag = true;
    }
    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println(Thread.currentThread().getName()+"--"+(i++));
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}