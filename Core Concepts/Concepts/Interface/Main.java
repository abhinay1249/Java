package Interface;

interface Owner{
    String name = "John";
    int age =22;
    void seen();
    // void fun(){
    //     System.out.println(3);
    // }
    // void boom(){
    //     System.out.println("Kaboom");
    // } 
}

interface ChaiPodiSupplier{
    String supplierName = "David";
}
class ChaiShop implements Owner, ChaiPodiSupplier{
    String branchName="Kokapet";
    int cupsSold;
    int price;
    int employees;
  
    public void seen(){
        System.out.println("hi");
    }
    
    // public void fun(){
    //     System.out.println("I am in another class");
    //} 
    // public ChaiShop(){
    //     System.out.println("in default constructor");
    // }
    // public ChaiShop(String branchName, int cupsSold, int price,int employees){
    //     // System.out.println("in parameterized constructor");
    //     // System.out.println(branchName+" "+cupsSold);
    //     this.branchName= branchName;
    //     this.cupsSold = cupsSold;
    //     this.price = price;
    //     this.employees = employees;
    // }
    // public void annaChai(int n){
    //     cupsSold+=n;
    // }
    // public void revenue(){
    //     System.out.println("Revenue:" + (cupsSold * price));
    // }
    // public void display(){
    //     System.out.println(branchName);
    //     System.out.println(cupsSold);
    //     System.out.println(price);
    //     System.out.println(employees);
    //     //revenue();
    // }
    
//     //METHOD OVERRIDING//
//     void fun(){     
//         System.out.println(1);
//     }
}

// class Room extends ChaiShop{
//     int roomNo;
//     int noOfChairs;

//     public Room(int roomNo, int noOfChairs){
//         this.roomNo = roomNo;
//         this.noOfChairs = noOfChairs;
//     }
// }

// class XeroxShop extends Owner{
//     String branchName;
//     int papersSold;
//     int pricePerPaper;
    
//     public XeroxShop(String branchName, int papersSold, int pricePerPaper){
//         this.branchName = branchName;
//         this.papersSold = papersSold;
//         this.pricePerPaper = pricePerPaper;
//     }
//     public void display(){
//         System.out.println(branchName);
//         System.out.println(papersSold);
//         System.out.println(pricePerPaper);
//     }
// }

class Main {
public static void main(String[] args){
    ChaiShop b1 = new ChaiShop();
    b1.seen();
    // System.out.println(b1.name);
    // System.out.println(b1.supplierName);
    
    
    
//   Room r = new Room(3,20);
//   System.out.println(r.roomNo);
//   System.out.println(r.branchName);
//   System.out.println(r.name);
   
   
    
    // b1.fun();

    // Owner o1 = new Owner();
    // o1.boom();
    // ChaiShop branch1 = new ChaiShop("Microsoft",5,2,3);
    // //branch1.display();
    // System.out.println(branch1.name);
    // branch1.boom();
    // System.out.println("===============");
    // XeroxShop x1 = new XeroxShop("khaleja",20,2);
    // //x1.display();
    // System.out.println(x1.age);

    
    //  branch1.annaChai(5);
    //  branch1.display();
    //  branch1.revenue();
    //  branch1.branchName = "Pushpa";
    //   branch1.cupsSold = 350;
    //   branch1.fun();
    //   System.out.println(branch1.branchName);
    //   System.out.println(branch1.cupsSold);

    //  ChaiShop branch2 = new ChaiShop("Google",0,4);
    //  branch2.annaChai(10);
    //  branch2.display();
    //  branch2.revenue();
    //  branch2.branchName = "Jalsa";
    //  branch2.cupsSold= 200;
    //  System.out.println(branch2.branchName);
    //  System.out.println(branch2.cupsSold);
    }
}