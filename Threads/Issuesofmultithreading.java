public class Issuesofmultithreading {
    public static void main(String[] args)  throws InterruptedException{

        Brickdiary bd= new Brickdiary();
        
        Runnable r1= () ->{
            for(int i =0;i<15000;i+=50){
                bd.brickincrement();
            }
        };
        Runnable r2= () ->{
            for(int i =0;i<5000;i+=50){
                bd.brickincrement();
            }
        };
        Runnable r3= () ->{
            for(int i =0;i<10000;i+=50){
                bd.brickincrement();
            }
        };
        Thread t1= new Thread(r1);
        Thread t2= new Thread(r2);
        Thread t3= new Thread(r3);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(bd.brickcount);
    }
}

class Brickdiary{
   volatile int brickcount=0;
    volatile int count=0;

     public synchronized  void brickincrement(){
        synchronized(this){
        brickcount+=50;
        }
        count+=1000;
    }
}
