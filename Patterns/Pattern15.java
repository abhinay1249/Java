//         1 
//       2 1 2 
//     3 2 1 2 3 
//   4 3 2 1 2 3 4 
// 5 4 3 2 1 2 3 4 5 

public class Pattern15 {
    public static void main(String[] args) {
        int n=5;
        for(int i=0;i<n;i++){
            for(int k=0;k<n-i-1;k++){
                System.out.print("  ");
            }
            for(int j=i;j>=0;j--){
                System.out.print((j+1)+" ");
            }
            for(int j=1;j<i+1;j++){
                System.out.print(j+1+" ");
            }
            System.out.println();
        }
    }  
}