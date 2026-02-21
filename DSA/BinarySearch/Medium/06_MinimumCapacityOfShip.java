import java.util.*;

class Main {
    
    private static int summationOfWeights(int[] weights){
        int sumOfWeights = 0;
        int length = weights.length;
        for(int weight = 0 ; weight < length ; weight++){
            sumOfWeights += weights[weight];
        }
        return sumOfWeights;
    }
    
    private static int requriedDays(int[] weights, int capacity){
        int daysRequired = 1;
        int load = 0;
        int length = weights.length;
        for(int weight = 0 ; weight < length ; weight++){
            if(load + weights[weight] > capacity){
                daysRequired++;
                load = weights[weight];
            }else{
                load+=weights[weight];
            }
        }
        return daysRequired;
    }
    
    static int minimumCapacity(int[] weights, int days){
        
        int start = Arrays.stream(weights).max().getAsInt(); 
        int end = summationOfWeights(weights);
        
        for(int capacity = start ; capacity <= end ; capacity++){
            
            int noOfDays =  requriedDays(weights,capacity);
            if(noOfDays <= days){
                return capacity;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] weights = {3,2,2,4,1,4};
        int days = 3;
        int result = minimumCapacity(weights,days);
        System.out.println(result);
    }
}