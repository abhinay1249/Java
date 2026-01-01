import java.util.*;


class Main{

    // ======================= Brute Force Approach =======================================

    static List<Integer> leaders(int[]arr){
        int n = arr.length;
        int count = 0;
        List<Integer> al = new ArrayList<>();
        for(int i = 0 ;i < n ;i++){
            for(int j = i+1 ;j < n ;j++){
                if(arr[i]>arr[j]){
                    count++;
                }
                if(count==n-1-i){
                    al.add(arr[i]);
                }
            }
            count=0;
        }
        al.add(arr[n-1]);
        for(int num:al){
            System.out.println(num);
        }
        return al;
    }

    // ======================= Optimal Approach =======================================

    static void leaders(int[] arr){
        int n = arr.length;
        int max_right=Integer.MIN_VALUE;
        List<Integer> al = new ArrayList<>();


        for(int i = n-1; i>=0; i--){
            if(arr[i]>max_right){
                al.add(arr[i]);
                max_right = Math.max(max_right,arr[i]);
            }
        }
        Collections.reverse(al);

        for(int nums:al){
            System.out.print(nums+" ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,7,1,0};
        leaders(arr);
    }
}