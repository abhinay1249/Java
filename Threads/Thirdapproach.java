// using anonymous classes

public class Thirdapproach {
    public static void main(String[] args){

        Runnable r= new Runnable() {
            
            public void run(){
                System.out.println("Hello "+Thread.currentThread().getName()+" --->>> "+Thread.currentThread().getPriority());
            }
        };

        Runnable r1= new Runnable(){

            public void run(){
                System.out.println("Hi "+Thread.currentThread().getName()+" --->>> "+Thread.currentThread().getPriority());
            }
        };

        Thread t= new Thread(r);
        t.start();
        Thread t1= new Thread(r1);
        t1.start();

        System.out.println("Threads after declaration: "+Thread.activeCount());  
 
    } 
}
