import java.io.*;

public class Textbufferedwriter {
    public static void main(String[] args) throws IOException {
        File f=new File("./textfile.txt");
        if(f.exists())
            System.out.println(f.delete());
        System.out.println(f.createNewFile());

        String s="Bye";
        BufferedWriter bw=new BufferedWriter(new FileWriter(f));
        bw.write(s);
        bw.flush();
    }
}
