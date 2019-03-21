package com.wjsdta;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: WJ
 * \* Date: 2019/3/18
 * \* Time: 15:53
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Demo05 {
    public static void main(String[] args) {
        //创建线程池（4中方法）
        //1.创建一个单线程的线程池
        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        //创建一个固定大小的线程池
       // ExecutorService executorService = Executors.newFixedThreadPool(3);
        //可缓存的线程池
       // ExecutorService executorService = Executors.newCachedThreadPool();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        //ExecutorService executorService = scheduledExecutorService;



        executorService.execute(new MyRunable6());
        executorService.execute(new MyRunable6());
        executorService.schedule(new MyRunable6(),3000, TimeUnit.MILLISECONDS);
       // executorService.shutdown();
    }
}
class MyRunable6 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            System.out.println(Thread.currentThread().getName()+"run-->"+i);

        }
    }
}