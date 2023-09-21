class SyncMethods{
    int prev2 = 0;
    int prev = 1;
    int current;

    synchronized void fib(int id){
        for(int i=id; i<id+5; i++){
            current = prev + prev2;
            System.out.println(current);
            prev2 = prev;
            prev = current;
        }
    }
}

class Fibothread extends Thread{
    SyncMethods ref;
    int tid;
    static int id = 2;

    Fibothread(SyncMethods d_ref){
        super();
        tid = id;
        id += 5;
        ref = d_ref;
        start();
    }

    public void run(){
        try {
            sleep(200);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        if(tid==2){
            System.out.println(0 + "\n" + 1);
        }
        ref.fib(tid);
    }

}

public class SyncBlock {
    public static void main(String args[])
    {
        SyncMethods ref = new SyncMethods();
        Fibothread fb1 = new Fibothread(ref);
        Fibothread fb2 = new Fibothread(ref);
        Fibothread fb3 = new Fibothread(ref);

        try{
            fb1.join();
            fb2.join();
            fb3.join();
        }catch(InterruptedException e){
            System.out.println(e.toString());
        }
    }
}