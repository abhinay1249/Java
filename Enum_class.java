enum Laptop
{
    Vostro(60000), Thinkpad(20000), Hp, Macbook(45000);
 
    private int price;
    private Laptop()
    { 
        price=10000;
    }
    private Laptop(int price)
    { 
        this.price=price;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

public class Enum_class
{
    public static void main(String[] args) 
    {
        Laptop laptop=Laptop.Hp;
        System.out.println(laptop+":"+laptop.getPrice());
        System.out.println();
        
        for(Laptop lap: Laptop.values())
        {
            System.out.println(lap +":"+lap.getPrice());
        }
        
    }
}