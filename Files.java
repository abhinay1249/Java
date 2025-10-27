import java.io.*;
import java.util.Date;
public class Files{
    public static void main(String[] args) throws IOException{
        File f=new File("D:/filetest.txt");
        if(f.exists())
            System.out.println(f.delete());
        System.out.println(f.createNewFile());
        System.out.println(f.isHidden());
        System.out.println(f.canWrite());
       f.setWritable(true);
       System.out.println(new Date(f.lastModified()));
        
    }
}