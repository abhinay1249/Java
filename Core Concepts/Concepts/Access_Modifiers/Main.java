import pack1.Owner;

class ChaiShop extends Owner{
    public String publicBranch="Abids";
    protected String protectedBranch = "Madhapur";
    String defBranch = "Kothapet";
    private String privateBranch = "Meerpet";

    void display(){
        System.out.println(publicBranch);      
        System.out.println(protectedBranch);           
        System.out.println(defBranch);        
        System.out.println(privateBranch); 
        hello();
    }
}

public class Main {
    public static void main(String[] args) {
        ChaiShop c = new ChaiShop();
        c.display();
        // System.out.println(c.name);
        //c.hello();
     
        // System.out.println(c.publicBranch);        
        // System.out.println(c.protectedBranch);        
        // System.out.println(c.defBranch);        
        // System.out.println(c.privateBranch);    //private cannot be accessed outside the class where the variable has been created    
    }
    
}
