class Palindrome
{
    public static void main(String[] args) 
    {
          String a="bob";
          String b="";
          for(int i=a.length()-1;i>=0;i--)
          {
            b+=a.charAt(i);
            
          }
          if(b.equals(a))                                         //Inorder to compare two Strings use ".equals"
          {
            System.out.println("The string is palindrome");
          }
          else
          {
            System.out.println("The string is not palindrome");
          }
    }
}    


// class Palindrome
// {
//     public static void main(String[] args) {
//         String s="abcdefgeda";
//         boolean palindrome=true;
//         int n=s.length();
//         for(int i=0;i<n/2;i++)
//         {
//             if(s.charAt(i)!=s.charAt(n-i-1))
//             {
//                 System.out.println(i);
//                 palindrome=false;
//                 break;
//             }
//         }    
//         if(palindrome)
//         {
//             System.out.println("Yes");
//         }
//         else
//         {
//             System.out.println("No");
//         }
        
//     }
// }