class A
{

    public void show(){
        System.out.println("in show");
    }

    static class B{   // or class B
        public void activate(){
            System.out.println("activated");
        }  
    }
}

class Inner_class
{
    public static void main(String[] args) {
        A obj=new A();
        obj.show();

        A.B obj1=new A.B(); // or A.bobj1= obj.new B();
        obj1.activate();
    }
}
