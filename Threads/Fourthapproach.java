//using lambda expressions


public class Fourthapproach {
    
    public static void main(String[] args) throws InterruptedException{

        Runnable r= () ->{
            for(int i=1;i<5;i++){
                System.out.println("Hello "+Thread.currentThread().getName()+" --->>> "+Thread.currentThread().getPriority());
            }
        };
            
        Runnable r1= () -> {
            for(int j=1;j<6;j++){
            System.out.println("Hi "+Thread.currentThread().getName()+" --->>> "+Thread.currentThread().getPriority());
            }
        };
                
        Thread t= new Thread(r, "T1");
        Thread t1= new Thread(r1," T2");
        t.start();
       // t.join();
       // t.sleep(5000);
        t1.start();

    }
}

