package Final;

class Z{
    final int b = 10;
    final int c = 11;
    void display(){
        System.out.println(b);
        System.out.println(c);
    }
}
class A extends Z{
    final int a = 10;
    int b = 11;
    int c = 12;
    A(){
        int b = 10;
        System.out.println(a+b);
    }
    void display(){         //cannot override
        System.out.println(b);
        System.out.println(c);
    }
}

class Main {
    public static void main(String[] args){
        A a = new A();
        //a.a=12;
        System.out.println(a.a);
        a.display();
    }
}