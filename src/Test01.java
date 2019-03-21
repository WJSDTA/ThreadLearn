/**
 * \* Created with IntelliJ IDEA.
 * \* User: WJ
 * \* Date: 2019/3/18
 * \* Time: 10:36
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Test01 {
    public static void main(String[] args) {
        L1 l1 = new L1();
        L2 l2 = new L2();
        Thread thread1 = new Thread(l1);
        Thread thread2 = new Thread(l2);
        thread1.start();
        thread2.start();
        //l1.setValues("L1 to L2");
        //l1.send(l2);

       // System.out.println(l2.getValues());

    }
}
class L1 implements Runnable{
    private int id;
    private String values;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }
    public void send(L2 l2){
        l2.setValues(this.id+this.values);

    }

    @Override
    public void run() {
        if (id<65535)
        {
            id++;
        }else {
            id=0;
        }
        System.out.println(Thread.currentThread().getName()+id);
    }
}
class L2 implements Runnable{
    private int id=0;
    private String values;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }
    public void get(L1 l1){

    }

    @Override
    public void run() {
        if (id<65535)
        {
            id++;
        }else {
            id=0;
        }
        System.out.println(Thread.currentThread().getName()+id);
    }
}