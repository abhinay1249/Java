// *****
// *   *
// *   *
// *   *
// *****

import java.util.Scanner;
public class Pattern4{
public static void main(String[] args) {
    System.out.print("Enter the no of rows: ");
    Scanner sc= new Scanner(System.in);
    int rows= sc.nextInt();
    System.out.print("Enter the no of cols: ");
    int cols = sc.nextInt();
    for(int i=0;i<rows;i++){
        for(int j=0;j<cols;j++){
            if(i==0 || i==rows-1 || j==0 || j==cols-1){
                System.out.print("*");
            }
            else{
                System.out.print(" ");
            }     
        } 
        System.out.println();
    }
    sc.close();  
}
}
