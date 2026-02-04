import java.util.*;

class Main {

    // ==================================== Brute Force Approach ===========================================

        static int countInversions(int[] nums){
        
            int length = nums.length;
	        int count = 0;
    
	        if(length < 2){
	            return count;
	        }           
	        for(int index_1 =0 ; index_1 < length-1 ; index_1++){                   // T.C = O(N^2) S.C = O(1)
	    	    for(int index_2 = index_1+1 ; index_2 < length ; index_2++){
	    		    if(nums[index_1]>nums[index_2]){
	    			    count++;
                    }
                }
            }
            return count;
        }
        
    // ==================================== Optimal Approach ===========================================

        static int merge(int[] nums, int low, int mid, int high){
	        List<Integer> temp = new ArrayList<>();
	        int count = 0;
	        int length = nums.length;
	        int left = low;
	        int right = mid+1;

	        while(left<=mid && right<=high){
	    	    if(nums[left] <= nums[right]){
	    		    temp.add(nums[left]);
	    		    left++;
                }else if(nums[left]>nums[right]){
	                temp.add(nums[right]);
	                count+=(mid-left+1);
	                right++;                             // T.C = O(N LOG N), S.C = O(N) Incase given array cannot be modified then simply clone it.
                }                                                                        // nums1.clone(nums); 
            }

            while(left<=mid){
	            temp.add(nums[left]);
	            left++;
            }

            while(right<=high){
	            temp.add(nums[right]);
	            right++;
            }

            for(int idx = low ; idx <= high ; idx++){
                nums[idx] = temp.get(idx - low);
            }

            return count;
        }

        static int mergeSort(int[] nums, int low, int high){
	        int length = nums.length;
	        int mid = low + ((high - low)/2);
	        int count = 0;

	        if(low >= high) return count;
    
	        count+=mergeSort(nums,low,mid);
	        count+=mergeSort(nums,mid+1,high);
	        count+=merge(nums,low,mid,high);

            return count;
        }

        static int countInversions_1(int[]nums){
	        int length = nums.length;
	        return mergeSort(nums,0,length-1);
        }

    public static void main(String[] args) {
        int[] nums = {5,3,2,1,4};
        int result = countInversions_1(nums);
        System.out.println(result);
    }
}