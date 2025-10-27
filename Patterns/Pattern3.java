// *-*-*
// *-*-*
// *-*-*

import java.util.Scanner;
public class Pattern3{
public static void main(String[] args) {
    System.out.print("Enter the no of rows: ");
    Scanner sc= new Scanner(System.in);
    int rows= sc.nextInt();
    System.out.print("Enter the no of cols: ");
    int cols = sc.nextInt();
    for(int i=0;i<rows;i++){
        for(int j=0;j<cols;j++){
            System.out.print("*");
            if(j!=cols-1){
                System.out.print("-");
            }   
        }
        System.out.println();
    }  
  }
}