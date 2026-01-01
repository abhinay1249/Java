import java.util.*;

class Main {

    // ======================= Brute Force Approach =======================================

    private static boolean linearSearch(int[] arr,int num){
        int n = arr.length;
        
        for(int i = 0; i < n ; i++){
            if(arr[i]==num){
                return true;
            }
        }
        return false;                                       // Time Complexity = O(N^2), Space Complexity = O(1)
                                                            
    }
    
    static int longestConsequence(int[] arr){
        int n = arr.length;
        int maxLength = 0;
        for(int i = 0; i < n;i++){
            int count = 1;
            int x = arr[i];
            
            while(linearSearch(arr,x+1)==true){
                x+=1;
                count++;
            }
            maxLength = Math.max(maxLength,count);
        }
        return maxLength;
    }

    // ======================= Better Approach =======================================

    static int longestSequence(int[] arr){
        Arrays.sort(arr);
        int lastSmallest = Integer.MIN_VALUE;
        int count = 1;
        int longest = 0;
    
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i]-1==lastSmallest){
                count++;                                        // Time Complexity = O(N log N), Space Complexity = O(1)
                lastSmallest = arr[i];
            }else if(arr[i]!=lastSmallest){
                count = 1;
                lastSmallest = arr[i];
            }
            longest = Math.max(longest,count);
        }
        return longest;
    }

    // ======================= Optimal Approach =======================================

    static int longestSequence1(int[] nums){
        int n = nums.length;
        if(n==0) return 0;
        int longest = 1;
        Set<Integer> s = new HashSet<>();
        
        for(int i = 0 ; i <n;i++){
            s.add(nums[i]);
        }
        
        for(int num:s){
            if(!s.contains(num-1)){
                int count = 1;
                int x = num;
                
                while(s.contains(x+1)){
                    count++;
                    x=x+1;
                }
                longest = Math.max(count,longest);
            }
        }
        return longest;
    }


    public static void main(String[] args) {
        int[] arr = {100,4,200,1,2,3};
        int result = longestConsequence(arr);
        int result1 = longestSequence(arr);
        int result2 = longestSequence1(arr);
        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
    }
}