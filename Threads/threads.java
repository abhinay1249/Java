class A extends Thread{
    public void run(){
        for(int pointer = 0 ; pointer < 10 ; pointer++){
            System.out.println("Hi");
            try{
                Thread.sleep(10);
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
class B extends Thread{
    public void run(){
        for(int pointer = 0 ; pointer < 10 ; pointer++){
            System.out.println("Hello");
            try{
                Thread.sleep(10);
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
}

class Threads{
    public static void main(String a[]){
        A obj1 = new A();
        B obj2 = new B();

        obj1.start();
        // try{
        //     Thread.sleep(2);
        // }catch(InterruptedException e){
        //     System.out.println(e);
        // }
        obj2.start();
    }
}