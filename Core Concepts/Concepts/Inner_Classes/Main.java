class ChaiShop{
    String name = "Abhinay";
    
    //INNER CLASS
    class Branches{
        String branch1= "KOTHAPET";
        String branch2= "RTC X ROADS";
        String branch3= "MADHAPUR";
        String branch4= "PATANCHERU";
    }
}
class Main {
    public static void main(String[] args) {
        ChaiShop c1 = new ChaiShop();
        System.out.println(c1.name);
        System.out.println("--------------");
        
        //INNER CLASSES RETRIEVAL
        ChaiShop.Branches b = c1.new Branches();
        System.out.println(b.branch1);
        System.out.println(b.branch2);
        System.out.println(b.branch3);
        System.out.println(b.branch4);
    }
}