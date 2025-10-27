import java.io.*;
import java.util.*;

public class Propertiesfiles {
    public static void main(String[] args) throws Throwable{

        File f= new File("DBconfig.properties");            //Creation of File
        if(!f.exists()){
            System.out.println(f.createNewFile());
        }
        System.out.println(f.exists());

        // f.delete();                                         Deletion of properties files

        Properties p=new Properties();                              //Creation of properties files
        p.setProperty("url","localhost"); 
        p.setProperty("username","admin123");    
        p.setProperty("password","nimda321");  
        p.setProperty("company","google");  
        p.setProperty("role","SDE");    
        p.setProperty("hours","8");   
        
        p.putIfAbsent("end","bye");
        p.put("company","microsoft");
        p.remove("hours");
               
        FileOutputStream fos= new FileOutputStream(f);      //by using FileOutputStream we can write the data in the properties file 
        p.store(fos, "The property values are written");
     

        System.out.println(p);
        
        FileInputStream fis= new FileInputStream(f);      //by using FileInputStream we can read the data from the properties file
        p.load(fis);
    

        Set<String> keys=p.stringPropertyNames();
        System.out.println(keys);

        Collection<Object> value=p.values();
        System.out.println(value);

        for(Object prop: p.keySet()){
            System.out.println(prop+"--->>>"+p.getProperty((String) prop));
        }

       fos.close();
       fis.close();
    }
}
