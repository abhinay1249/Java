// Problem Statement: Given an integer array nums of size n containing values from [1, n] and each value appears exactly once in the array, except for A, which appears twice and B which is missing.
// Return the values A and B, as an array of size 2, where A appears in the 0-th index and B in the 1st index.

// Note: You are not allowed to modify the original array.


// Example 1:

// Input : nums = [3, 5, 4, 1, 1]  
// Output : [1, 2]  
// Explanation : 1 appears twice in the array, and 2 is missing from the array. So the output is [1, 2].

// Example 2:

// Input : nums = [1, 2, 3, 6, 7, 5, 7]  
// Output : [7, 4]  
// Explanation : 7 appears twice in the array, and 4 is missing from the array. So the output is [7, 4].

import java.util.*;

class Main {

    // ==================================== Brute Force Approach ===========================================

        public static int[] missingAndRepeated(int[] nums){
            
	        int length = nums.length;
	        int[] numbers = new int[2];
	        int missingNumber = -1;
	        int repeatedNumber = -1;
    
    
	        for(int number = 1; number <= length ; number++){
	            int count = 0;
	    	    for(int index = 0 ; index < length ; index++){                  // T.C = O(N^2), S.C = O(1)
	    		    if(number == nums[index]){
	                    count++;
                    }
                    if(count == 2){
                        repeatedNumber = nums[index];
                    }else if(count == 0){
                        missingNumber = number;
                    }
	    	    }
            }

            numbers[0] = missingNumber;
            numbers[1] = repeatedNumber;
            return numbers;
        }

    // =============================== Better Approach - 1 Using HashMap =====================================


        public static int[] missingAndRepeated_1(int[] nums){
	        int length = nums.length;
	        Map<Integer, Integer> freqCount = new HashMap<>();
	        int[] numbers = new int[2];
	        int missingNumber = -1;
	        int repeatedNumber = -1;

	        for(int idx = 1; idx <= length ; idx++){
		        freqCount.put(idx,freqCount.getOrDefault(idx,0)+1);                 // T.C = O(n log m)*2+O(N), S.C = O(N)
            }

	        for(int idx = 0; idx < length ; idx++){
		        freqCount.put(nums[idx],freqCount.getOrDefault(nums[idx],0)+1);
            }


            for(Map.Entry<Integer,Integer> values : freqCount.entrySet()){
	            if(values.getValue() == 1){
		            missingNumber = values.getKey();
                }else if(values.getValue() == 3){
	                repeatedNumber = values.getKey();
                }
            }       

            numbers[0] = missingNumber;
            numbers[1] = repeatedNumber;

            return numbers;
        }

    // ==================================== Better Approach - 2 Using HashArray ===========================================

        public static int[] missingAndRepeated_2(int[] nums){

	        int length = nums.length;
	        int[] hashArray = new int[length+1];
	        int[] numbers = new int[2];
	        int missingNumber = -1;
	        int repeatedNumber = -1;

	        for(int idx = 0; idx < length ; idx++){
		        hashArray[nums[idx]]++;                                             // T.C = O(2N), S.C = O(N)
            }

	        for(int idx = 1; idx < hashArray.length ; idx++){
                if(hashArray[idx]==0){
                    missingNumber=idx;
                }else if(hashArray[idx]==2){
                    repeatedNumber=idx;
                }
            }     

            numbers[0] = missingNumber;
            numbers[1] = repeatedNumber;

            return numbers;
        }

    // ==================================== Optimal Approach - 1 Using Math ===========================================

        public static int[] missingAndRepeated_3(int[] nums){
        
            long length = nums.length;

            int[] numbers = new int[2];

            long sumOfNumbers = (length * (length+1))/2;

            long sumOfSquaresOfNumbers = (length * (length+1) * (2* length+1))/6;

            long sum = 0, sumOfSquares = 0;

            for(int idx = 0 ; idx < length ; idx++){                                    // T.C = O(N), S.C = O(1)
                sum+=nums[idx];   
                sumOfSquares += (long) nums[idx] *(long) nums[idx];
            }

            long eqn1 = (sum - sumOfNumbers);
            long eqn2 = (sumOfSquares - sumOfSquaresOfNumbers);

            eqn2 = eqn2/eqn1;

            long repeatedNumber = (eqn2+eqn1)/2;
            long missingNumber = eqn2 - repeatedNumber;

            numbers[0] = (int)repeatedNumber;
            numbers[1] = (int)missingNumber;

            return numbers;
        }
    
    // ==================================== Optimal Approach - 2 Using XOR (BIT MANIPULATION) ===========================================

        public static int[] missingAndRepeated_4(int[] nums){
            int length = nums.length;
            int[] numbers = new int[2];
            int xor = 0;
            int missingNumber = -1;
            int repeatedNumber = -1;

            for(int idx = 0 ; idx < length ; idx++){
                xor^=nums[idx];
                xor^=(idx+1);
            }

            int bitNumber = xor & ~(xor-1);                         // T.C = O(4N), S.C = O(1)
                                            
            int zero = 0;
            int one = 0;

            for(int idx = 0 ; idx < length ; idx++){
                if((nums[idx] & bitNumber)!=0){
                    one^=nums[idx];
                }else{
                    zero^=nums[idx];
                }
            }

            for(int idx = 1 ; idx <=length ; idx++){
                if((idx & bitNumber)!=0){
                    one^=idx;
                }else{
                    zero^=idx;
                }
            }

            int count = 0;

            for(int idx = 0 ; idx < length ; idx++){
                if(one == nums[idx]){
                    count++;
                }
            }
            if(count == 2){
                numbers[0]=zero;
                numbers[1]=one;
            }
            numbers[0] = one;
            numbers[1] = zero;
            return numbers;
        }
    


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 6}; 
        int[] result = missingAndRepeated_2(nums);
        
        for(int values : result){
            System.out.print(values+" ");
        }
    }
}