// Problem Statement: You are the owner of a Shipment company. 
// You use conveyor belts to ship packages from one port to another. The packages must be shipped within 'd' days. 
// The weights of the packages are given in an array 'of weights'. 
// The packages are loaded on the conveyor belts every day in the same order as they appear in the array. 
// The loaded weights must not exceed the maximum weight capacity of the ship. 
// Find out the least-weight capacity so that you can ship all the packages within 'd' days .


import java.util.*;

class Main {
    
    // =========================== Brute Force Approach ==============================

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
                if(load + weights[weight] > capacity){                  // T.C = O((maxSum - maxNum)+1) * O(N), S.c = O(1)
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

    // =========================== Optimal Approach ==============================

        private static int requriedDays_1(int[] weights, int capacity){
            int daysRequired = 1;
            int load = 0;
            int length = weights.length;
            for(int weight = 0 ; weight < length ; weight++){
                if(load + weights[weight] > capacity){
                    daysRequired++;
                    load = weights[weight];
                }else{
                    load+=weights[weight];                                // T.C = O(Log((maxSum - maxNum)+1)) * O(N) , S.C = O(1)
                }
            }
            return daysRequired;
        }
    
        static int minimumCapacity_1(int[] weights, int days){
            
            int low = Arrays.stream(weights).max().getAsInt(); 
            int high = Arrays.stream(weights).sum();
            
            while(low <= high){
                int mid = low +((high - low)/2);
                int noOfDays = requriedDays_1(weights,mid);
                
                if(noOfDays <= days){
                    high = mid - 1;
                }else{
                    low = mid+1;
                }
            }
            return low;
        }

    public static void main(String[] args) {
        int[] weights = {3,2,2,4,1,4};
        int days = 3;
        int result = minimumCapacity(weights,days);
        System.out.println(result);
    }
}