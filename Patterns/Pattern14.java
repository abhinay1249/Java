//           1 
//         2 1
//       3 2 1
//     4 3 2 1
//   5 4 3 2 1

public class Pattern14 {
    public static void main(String[] args) {
        int n=5;
        for(int i=0;i<n;i++){
            for(int k=0;k<n-i-1;k++){
                System.out.print("  ");
            }
            for(int j=i;j>=0;j--){
                System.out.print((j+1)+" ");
            }
            System.out.println();
        }
    }  
}