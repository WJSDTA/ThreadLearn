package com.wjsdta;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: WJ
 * \* Date: 2019/3/18
 * \* Time: 15:20
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class ProducterCustomerDome {
    public static void main(String[] args) {
        Food food = new Food();
        Producter producter = new Producter(food);
        Customer customer = new Customer(food);
        Thread thread = new Thread(producter);
        Thread thread1 = new Thread(customer);
        thread.start();
        thread1.start();

    }
}
class Food{
    private String name;
    private String desc;
    private boolean flag = true;//true 正常，
/*
生产
* */
    public synchronized void set(String name,String desc){
        //不能生产
        if (!flag){
            try {
                this.wait();//线程进入等待转台，释放监视器所有权
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setName(name);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setDesc(desc);
        flag = false;
        this.notify();//唤醒等待的线程（随机的其中一个）

    }
    /*
    *
    * 消费
    * */
    public synchronized void get(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName()+"-->"+this.getDesc());
        flag = true;
        this.notify();//唤醒等待的线程（随机的其中一个）

    }
    public Food() {
    }

    public Food(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Producter implements Runnable{
    private Food food;

    public Producter(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            if(i%2==0){
                food.set("锅包肉","酸甜口，爽");
            }
            else{
                food.set("福跳墙","大补，滋阴补阳");
            }

        }

    }
}

class Customer implements  Runnable{
    private Food food;

    public Customer(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            food.get();
        }

    }
}