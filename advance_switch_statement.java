class demo
{
    public static void main(String[] args)
    {
        String n="Saturday";

        String result= switch(n)
        {
            case "saturday" -> "lazy";
            case "monday" -> "work";
            default -> "Rest";
        };   // ; because it is a static statement and it is being ended here
        System.out.println(result);
    }
}