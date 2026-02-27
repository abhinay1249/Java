// Problem Statement: You are given a sorted array ‘arr’ of length ‘n’, which contains positive integer positions of ‘n’ gas stations on the X-axis. 
// You are also given an integer ‘k’. You have to place 'k' new gas stations on the X-axis. 
// You can place them anywhere on the non-negative side of the X-axis, even on non-integer positions. 
// Let 'dist' be the maximum value of the distance between adjacent gas stations after adding k new gas stations. 
// Find the minimum value of ‘dist’.

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

        static double minimumGasStationsDistance(int[] distance,int gasStations){
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

        static double minimumGasStationsDistance_1(int[] nums,int k){
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

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 4;
        double result = minimumGasStationsDistance(nums,k);
        System.out.println(result);
    }
}