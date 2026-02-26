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

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 4;
        double result = minimumGasStationsDistance(nums,k);
        System.out.println(result);
    }
}