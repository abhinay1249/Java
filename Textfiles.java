import java.io.*;

public class Textfiles {
    public static void main(String[] args) throws IOException {
        File f = new File("./textfile.txt");
        System.out.println(f.createNewFile());
 
    //below is used to read the data from the file
        FileInputStream fi=new FileInputStream(f);
        int convert;
        while((convert=fi.read()) != -1)
        {
            System.out.print((char)convert);
        }
       fi.close(); 
    }
}