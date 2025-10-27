//    *
//   * *
//  *   *
// *******

import java.util.Scanner;

public class Pattern10{
    public static void main(String[] args) {
        System.out.print("Enter the stand size: ");
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                System.out.print(" ");
            }
            for(int k=0; k<i*2+1;k++){
                if( i==n-1||k==0||k==2*i){
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