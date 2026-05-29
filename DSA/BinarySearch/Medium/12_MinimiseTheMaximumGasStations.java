// Problem Statement: You are given a sorted array ‘arr’ of length ‘n’, which contains positive integer positions of ‘n’ gas stations on the X-axis. 
// You are also given an integer ‘k’. You have to place 'k' new gas stations on the X-axis. 
// You can place them anywhere on the non-negative side of the X-axis, even on non-integer positions. 
// Let 'dist' be the maximum value of the distance between adjacent gas stations after adding k new gas stations. 
// Find the minimum value of ‘dist’.


// Example 1:

// Input Format: N = 5, arr[] = {1,2,3,4,5}, k = 4
// Result: 0.5
// Explanation: One of the possible ways to place 4 gas stations is {1,1.5,2,2.5,3,3.5,4,4.5,5}. 
// Thus the maximum difference between adjacent gas stations is 0.5. Hence, the value of ‘dist’ is 0.5. 
// It can be shown that there is no possible way to add 4 gas stations in such a way that the value of ‘dist’ is lower than this. 

// Example 2:

// Input Format: N = 10, arr[] = {1,2,3,4,5,6,7,8,9,10}, k = 1
// Result: 1
// Explanation: One of the possible ways to place 1 gas station is {1,1.5,2,3,4,5,6,7,8,9,10}. 
// Thus the maximum difference between adjacent gas stations is still 1. Hence, the value of ‘dist’ is 1. 
// It can be shown that there is no possible way to add 1 gas station in such a way that the value of ‘dist’ is lower than this. 


import java.util.*;

class Pair{
    double distance;
    int index;
    
    Pair(double distance, int index){
        this.distance = distance;
        this.index = index;
    }
}

class Main {

    // =========================== Brute Force Approach ============================== 

        public static double minimumGasStationsDistance(int[] distance,int gasStations){
            int length = distance.length;
            int[] howMany = new int[length-1];

            for(int gasStation = 0 ; gasStation <= length-1 ; gasStation++){
                double maxSection = -1;
                int maxIndex = -1;

                for(int index = 0 ; index < length - 1 ; index++){
                    int difference = distance[index+1]-distance[index];
                    double sectionLength = difference/(double)(howMany[index]+1);
                    if(maxSection < sectionLength){
                        maxSection = sectionLength;
                        maxIndex = index;
                    }
                }
                howMany[maxIndex]++;                            // T.C = O(gasStations*N) + O(N), S.C = O(Length-1) 
            }

            double maxAns = -1;

            for(int index = 0 ; index < length - 1 ; index++){
                int difference = distance[index+1]-distance[index];
                double sectionLength = difference/(double)(howMany[index]+1);

                maxAns = Math.max(maxAns,sectionLength);
            }
            return maxAns;
        }

    // =========================== Better Approach ============================== 

        public static double minimumGasStationsDistance_1(int[] nums,int k){
            int length = nums.length;
            int[] howMany = new int[length-1];

            Queue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(b.distance,a.distance));

            for(int index = 0 ; index < length -1 ; index++){
                pq.add(new Pair(nums[index+1]-nums[index],index));
            }

            for(int gasStation = 1; gasStation <=k ; gasStation++){
                Pair top = pq.poll();
                int index = top.index;
                howMany[index]++;                                   // T.C = O(N LOG N)+O(K LOG N), S.C = 2(O(Length-1))

                double difference = nums[index+1]-nums[index];
                double newDistance = difference/(howMany[index]+1);
                pq.add(new Pair(newDistance,index));
            }
            return pq.peek().distance;
        }
    
    // =========================== Optimal Approach ============================== 

        private static int gasStationsRequired(double distance, int[] nums){
            int count = 0;
            int length = nums.length;

            for(int index = 1 ; index < length;index++){
                int numbersInBetween =(int) ((nums[index]-nums[index-1])/distance);
                if((nums[index]-nums[index-1]) == numbersInBetween*distance){
                    numbersInBetween--;
                }
                count+=numbersInBetween;
            }
            return count;
        }

        public static double minimiseTheMaximumDistance_2(int[] nums, int k){

            int length = nums.length;
            int maxDifference = -1;

            for(int index = 0 ; index < length - 1 ; index++){
                maxDifference = Math.max(nums[index+1]-nums[index],maxDifference);
            }

            double low = 0, high = maxDifference;

            double maxVal = 1e-6;

            while((high-low)>maxVal){                             // T.C = O(Length-1) + O(Length-1 log(maxDifference)), S.C = O(1)
                double mid = low + ((high-low)/2);
                int count = gasStationsRequired(mid,nums);

                if(count > k){
                    low = mid;
                }else{
                    high = mid;
                }
            }
           return high; 
        }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 4;
        double result = minimiseTheMaximumDistance_2(nums,k);
        System.out.println(result);
    }
}