import java.util.*;

class Main {
    
    
    // ======================= Brute Force Approach =======================================

    static int removeDuplicates(int[]arr){
        
        List<Integer> al = new ArrayList<>();
        int n = arr.length;
        int index = 0;
        for(int i = 0 ; i < n ; i++){
            if(!(al.contains(arr[i]))){
                al.add(arr[i]);
                arr[index]=arr[i];
                index++;
            }
        }
        return index;
    }
    
    
    // ======================= Optimal Approach =======================================

    static int removeDuplicates_1(int[]arr){
        
        int n = arr.length;
        int i = 0;
        
        for(int j = 1; j < n ; j++){

            if(arr[j]!=arr[i]){
                arr[i+1]=arr[j];
                i++;
            }
        }
        return i+1;
    }
    
    public static void main(String[] args) {
        int[] arr={1,1,1,2,2,3,3,4};
        int[] nums={1,1,1,2,2,3,3,4};
        int result = removeDuplicates(arr);
        int result1 = removeDuplicates_1(nums);
        System.out.println("Unique: "+result);
        System.out.println("Unique: "+result1);
        
        for(int i = 0; i <result;i++){
            System.out.print(arr[i]+" ");
        }
    }
}