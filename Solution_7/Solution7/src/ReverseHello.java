import java.security.PublicKey;

public class ReverseHello extends Thread {
    private int count;

    public ReverseHello(int count){
        super("Thread" + count);
        this.count = count;
    }

    public void run(){
        count++;
        if(count <= 51) {
            ReverseHello th = new ReverseHello(count);
            th.start();
            try{
                th.join();
                System.out.println("Hello from " + getName() + "!");
            } catch (Exception e){
                System.out.println("Errors occur while running threads......");
            }
        }
    }

    public static void main(){
        ReverseHello th1 = new ReverseHello(1);
        th1.run();
    }
}
