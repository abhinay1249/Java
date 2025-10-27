class Animal
{
    public void sound()
    {
        System.out.println("The animal makes a sound");
    }
}

class Dog extends Animal
{
    public void sound()
    {
        System.out.println("DOg Barks");
    }
}

class Demo
{
    public static void main(String[] args)
    {
        Animal myAnimal=new Animal();
        Dog myDog=new Dog();

        myAnimal.sound();
        myDog.sound();
    }
}