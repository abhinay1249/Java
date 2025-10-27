class Add{
    //Complie Time Polymorphism
    void sum(){
        System.out.println("In Complie Time Polymorphism");
    }
    void sum(int a, int b){
      int c= a+b;
      System.out.println(c);
    }
}

class Num extends Add{
    //Run Time Polymorphism
    @Override
    void sum(){
        System.out.println("In Run Time Polymorphism");
    }
}

class Main {
    public static void main(String[] args) {
        Num n = new Num();
        n.sum();
        n.sum(1,1);
        
    }
}