abstract class Players
{
    public abstract void type();
    public void venue()
    {
        System.out.println("In India");
    }
}

abstract class Cricket extends Players
{
    public void type()
    {
      System.out.println("Domestic");
    }

    public abstract void team();
}

class India extends Cricket   // concrete class
{
      public void team()
      {
        System.out.println("15 players");
      }

}


public class Abstract_class
{
    public static void main(String[] args) {
        
        Cricket obj = new India();    // dynamic method dispatch approach
        obj.type();
        obj.venue();
        obj.team();
    }
}