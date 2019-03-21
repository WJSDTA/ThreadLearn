/**
 * \* Created with IntelliJ IDEA.
 * \* User: WJ
 * \* Date: 2019/3/18
 * \* Time: 10:01
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class ClassTest {
    public static void main(String[] args) {

    }
}
class A{
    private int id ;

   // public B b = new B();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void send(B b, int id){
        Message message = new Message(this,b,id);

    }

}
class B{
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
class Message{
    private int id ;
    Message(A a,B b,int id){
        this.id =id;

    }

}