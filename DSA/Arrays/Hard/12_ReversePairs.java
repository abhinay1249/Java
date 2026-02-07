import java.util.*;

class Main {

    static void merge(int[] nums, int low, int mid, int high){
	       List<Integer> temp = new ArrayList<>();
	       int left = low;
	       int right = mid+1;
	       

	       while(left<=mid && right<=high){
	   	    if(nums[left] <= nums[right]){
	   		    temp.add(nums[left]);
	   		    left++;
            }else if(nums[left]>nums[right]){
	               temp.add(nums[right]);
	               right++;
            }
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
    }
    
    static int countPairs(int[] nums, int low, int mid, int high){
        
        int left = low;
        int right = mid+1;
        int count = 0;
        
        for(int idx = left ; idx <= mid ; idx++){
            
	        while(right <= high && (long)nums[idx] > 2 * (long)nums[right]){
	           right++;
	        }
	        count += (right - (mid+1));
	    }
	   return count;
    }

    static int mergeSort(int[] nums, int low, int high){
	       int mid = low + ((high - low)/2);
	       int count = 0;
	       
	       if(low >= high) return count;

	       count+=mergeSort(nums,low,mid);
	       count+=mergeSort(nums,mid+1,high);
	       count+=countPairs(nums,low,mid,high);
	       merge(nums,low,mid,high);
	       
	   return count;
	       
    }
    
    static int reversePairs(int[]nums){
	       int length = nums.length;
	       return mergeSort(nums,0,length-1);
    }

    public static void main(String[] args) {
        int[] nums = {6,13,21,25,1,2,3,4,5,9};
        int result = reversePairs(nums);
        System.out.println(result);
    }
}