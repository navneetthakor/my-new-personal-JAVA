// package multithreading;

class Buffer{
    int info;
   volatile int flag;

    Buffer(){flag = 0;}

    synchronized void put(int item){
        try {
            while(flag != 0){
                wait();
        }
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
        

        info = item;
        flag = 1;
        notify();
    }

    synchronized void get(){
        try {
            while(flag != 1){
                wait();
        }
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
        
        System.out.println(info);
        flag = 0;
        notify();
    }
}

class Producer extends Thread{
    Buffer b_ref;
    Producer(Buffer d_b_ref){
        super();
        b_ref = d_b_ref;
        start();
    }

    @Override
    public void run(){
        for(int i=0; i<5; i++){
            b_ref.put(i);
            try{
                sleep(1000);
            }catch(InterruptedException e){
                System.out.println(e.toString());
            }
        }
    }
}

class Consumer extends Thread{
    Buffer b_ref;

    Consumer(Buffer d_b_ref){
        super();
        b_ref = d_b_ref;
        start();
    }

    public void run(){
        for(int i=0; i<5; i++){
            b_ref.get();
        }
    }

}

public class ProdConusm1 {
    public static void main(String args[]){
        try {
            Buffer b = new Buffer();
            Producer p = new Producer(b);
            Consumer c = new Consumer(b);
            p.join();
            c.join();
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
        
    }
}
