// using thread class 

class Manager extends Thread{

    public Manager(String name){
        super(name);
    }

    @Override
    public void run(){
        System.out.println("Hello "+Thread.currentThread().getName()+" --->>> "+Thread.currentThread().getPriority());

    }

}

class Hr extends Thread{

    public Hr(String name){
        super(name);
    }

    @Override
    public void run(){
        System.out.println("Hi "+Thread.currentThread().getName()+" --->>> "+Thread.currentThread().getPriority());
    }
}

public class Practicemultithreading {
    public static void main(String[] args) {

        System.out.println("Threads before declaration: "+Thread.activeCount());                  //by default it will print 1 because main thread is running
        System.out.println(Thread.currentThread().getName());                                     // by default it will print main because main thread is running
        //System.out.println(Thread.currentThread().getPriority());

        Thread t1= new Thread();
        t1.start();
        Thread t2= new Thread();
        t2.start();
        Thread t3= new Thread();
        t3.start();
        System.out.println("Threads after declaration: "+Thread.activeCount());  

        System.out.println();

        Manager m= new Manager("First thread");
        m.start();

        Hr h= new Hr("Second thread");
        h.start();
        

        
    } 
}
