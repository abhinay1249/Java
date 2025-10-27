import java.io.*;

public class Textfilewriter {
    public static void main(String[] args) throws IOException {
        File f=new File("./textfile.txt");
        if(f.exists())
            System.out.println(f.delete());
        System.out.println(f.createNewFile());

        String s="Hello Abhinay!!";
        FileWriter fw=new FileWriter(f);
         fw.write(s);
         fw.flush();
    }
}