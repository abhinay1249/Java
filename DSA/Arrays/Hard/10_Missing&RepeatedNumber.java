import java.util.*;

class Main {

    // ==================================== Brute Force Approach ===========================================


        static int[] missingAndRepeated(int[] nums){
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

        static int[] missingAndRepeated_1(int[] nums){
	        int length = nums.length;
	        Map<Integer, Integer> freqCount = new HashMap<>();
	        int[] numbers = new int[2];
	        int missingNumber = -1;
	        int repeatedNumber = -1;

	        for(int idx = 1; idx <= length ; idx++){
		        freqCount.put(idx,freqCount.getOrDefault(idx,0)+1);
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


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 6}; 
        int[] result = missingAndRepeated(nums);
        
        for(int values : result){
            System.out.print(values+" ");
        }
       
    }
}