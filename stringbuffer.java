class hello
{
    public static void main(String[] args) 
    {
         StringBuffer sb=new StringBuffer("Abhi");  //for string builder replace the word with string buffer
         sb.append("nay");
         sb.insert(7, " Marise!");
         sb.deleteCharAt(14);
         System.out.println(sb);   
         System.out.println(sb.reverse());

    
    }
}
