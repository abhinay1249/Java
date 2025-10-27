public class Wrapper_class
{
    public static void main(String[] args) {
        int i=20;
        double b= 20.5;

        // Wrapper_class obj= new Wrapper_class();
        // System.out.println(obj);  // object class which would create an hexadecimal string
        
        Integer obj=Integer.valueOf(i); //boxing done explicitly
        System.out.println(obj);
        
        Double obj1= b;   // auto boxing done directly
        System.out.println(obj1);

        int i1= obj.intValue();   // unboxing done explicitly
        System.out.println(i1);
       
        double d1=obj1;         // auto unboxing done directly
        System.out.println(d1);

        String s="18";
        int num=Integer.parseInt(s)*2;  //parseInt is used to return the primitive datatype
        System.out.println(num);
    }
}