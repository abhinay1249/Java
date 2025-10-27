enum Status{
    Processing, Success, Failed;
}

public class Enum_if_and_switch
{
    public static void main(String[] args) {
        
        Status obj= Status.Success;

        switch(obj)
        {
            case Processing -> System.out.println("wait bro");
            case Success -> System.out.println("done"); 
            case Failed -> System.out.println("mall kotu bro");
            default -> System.out.println("none");
        }

        if(obj == Status.Processing)
        {
            System.out.println("agu bro ayevaraku");
        }
        else if(obj == Status.Success)
        {
            System.out.println("sadinchav");
        }
        else
        {
            System.out.println("mala kotu");
        }
}
}