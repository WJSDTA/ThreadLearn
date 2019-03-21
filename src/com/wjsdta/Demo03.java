package com.wjsdta;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: WJ
 * \* Date: 2019/3/17
 * \* Time: 21:35
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Demo03 {
    public static void main(String[] args) {

        MyRunable4 myRunable4 = new MyRunable4();
        Thread thread = new Thread(myRunable4);
        thread.setDaemon(true);//把线程设置为守护线程，当用户中没有用户线程时，jvm退出
        thread.start();
        for (int i = 0; i <50 ; i++) {
            System.out.println("main"+i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i==5)
            {
                Thread.yield();//让出本次cpu执行时间片
            }
        }

    }
}
class MyRunable4 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <50 ; i++) {
            System.out.println("--"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}