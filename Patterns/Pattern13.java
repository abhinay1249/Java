// 1
// 12
// 123
// 1234
// 12345
// 123456

public class Pattern13 {
    public static void main(String[] args) {
        int n=6;
        for(int i=0;i<n;i++){
            for(int j=0;j<i+1;j++){
                System.out.print(j+1+" ");
            }
            System.out.println();
        }
    }  
}

