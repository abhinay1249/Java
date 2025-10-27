// *-*-*-*-*
// *-*-*-*-*
// *-*-*-*-*
// *-*-*-*-*
// *-*-*-*-*

import java.util.Scanner;
public class Pattern2{
public static void main(String[] args) {
    System.out.print("Enter the no of lines: ");
    Scanner sc= new Scanner(System.in);
    int n = sc.nextInt();
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            System.out.print("*");
            if(j!=n-1){
                System.out.print("-");
            }   
        }
        System.out.println();
    }  
  }
}