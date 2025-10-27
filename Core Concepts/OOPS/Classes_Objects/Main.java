class ChaiShop{
    String branchName;
    int cupsSold;
    int price;
    
    // public void fun(){
    //     System.out.println("I am in another class");
    //} 
    // public ChaiShop(){
    //     System.out.println("in default constructor");
    // }
    public ChaiShop(String branchName, int cupsSold, int price){
        // System.out.println("in parameterized constructor");
        // System.out.println(branchName+" "+cupsSold);
        this.branchName= branchName;
        this.cupsSold = cupsSold;
        this.price = price;
    }
    public void annaChai(int n){
        cupsSold+=n;
    }
    public void revenue(){
        System.out.println("Revenue:" + (cupsSold * price));
    }
    public void display(){
        System.out.println(branchName);
        System.out.println(cupsSold);
        System.out.println(price);
        revenue();
    }
}

class Main {
    public static void main(String[] args){
        ChaiShop branch1 = new ChaiShop("Microsoft",0,2);
        branch1.annaChai(5);
        branch1.display();
        //branch1.revenue();
        //branch1.branchName = "Pushpa";
        // branch1.cupsSold = 350;
        // branch1.fun();
        // System.out.println(branch1.branchName);
        // System.out.println(branch1.cupsSold);
        
        ChaiShop branch2 = new ChaiShop("Google",0,4);
        branch2.annaChai(10);
        branch2.display();
        //branch2.revenue();
        // branch2.branchName = "Jalsa";
        // branch2.cupsSold= 200;
        // System.out.println(branch2.branchName);
        // System.out.println(branch2.cupsSold);
    }
}