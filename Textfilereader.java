import java.io.*;

public class Textfilereader {
    public static void main(String[] args) throws IOException {
        File f=new File("./textfile.txt");
        if(!f.exists())
            System.out.println(f.createNewFile());
        
    FileReader fr=new FileReader(f);
    int a;
    while((a=fr.read()) !=-1)
    {
         System.out.print((char)a);
    }
    fr.close();
    }
}
