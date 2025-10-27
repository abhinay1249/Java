// using runnable that implements

class Manager implements Runnable{

    @Override
    public void run(){
        System.out.println("Hello "+Thread.currentThread().getName()+" --->>> "+Thread.currentThread().getPriority());

    }
}

class Hr implements Runnable{

    @Override
    public void run(){
        System.out.println("Hi "+Thread.currentThread().getName()+" --->>> "+Thread.currentThread().getPriority());
    }
}

public class Secondapproach {

    public static void main(String[] args) {

        Manager m= new Manager();
        Thread t= new Thread(m,"T1");
        t.start();

        Hr h =new Hr();
        Thread th= new Thread(h,"T2");
        th.start();
    }
}
