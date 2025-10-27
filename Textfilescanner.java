import java.io.*;
import java.util.*;

public class Textfilescanner {
    public static void main(String[] args) throws IOException {
        File f=new File("./textfile.txt");
        if(!f.exists())
            System.out.println(f.createNewFile());

        FileInputStream fi =new FileInputStream(f);
        Scanner sc=new Scanner(fi);
        //String text="";
        while(sc.hasNextLine())
        {
            //text+=sc.nextLine() + "\n";
            System.out.println(sc.nextLine());
        }  
        //System.out.println(text);
        sc.close();
        fi.close();
    }
}

        
        