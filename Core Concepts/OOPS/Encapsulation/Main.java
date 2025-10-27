class Encapsulation{
    private String name = "Abhinay";

    //getter method: used to get the name that is in private and retrieve from other class
    String getName(){
        return name;
    }
    //setter method: used to update the names
    void setName(String n){
        name = n;
    }
}
class Main {
    public static void main(String[] args) {
        Encapsulation e = new Encapsulation();
         e.setName("Abhi");
        System.out.println(e.getName());
    }
}