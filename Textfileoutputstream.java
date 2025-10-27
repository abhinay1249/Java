import java.io.*;

public class Textfileoutputstream {
    public static void main(String[] args) throws IOException {
        File f=new File("./textfile.txt");
        if(f.exists())
            System.out.println(f.delete());
        System.out.println(f.createNewFile());

        String s="Hello Abhinay";
        FileOutputStream fos=new FileOutputStream(f);
        for(char ch:s.toCharArray())
        {
            fos.write((int)ch);
        }
        // fos.write(72);
        // fos.write(69);
        // fos.write(76);
        // fos.write(76);
        // fos.write(79);
        fos.close();
    }
}