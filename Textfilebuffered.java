import java.io.*;

public class Textfilebuffered {
    public static void main(String[] args) throws IOException {
        File f=new File("./textfile.txt");
        if(!f.exists())
            System.out.println(f.createNewFile());

      //FileReader fr=new FileReader(f);
      FileInputStream fir=new FileInputStream(f);
      InputStreamReader isr=new InputStreamReader(fir);
      BufferedReader br=new BufferedReader(isr);
      String text=new String();
      String line="";
      while((line=br.readLine())!=null)
      {
        text+=line+"\n";
      }
      System.out.print(text);
      br.close();
      //fr.close();
    }
}