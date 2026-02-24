// Problem Statement: Given an array/list of length ‘N’, where the array/list represents the boards and each element of the given array/list represents the length of each board. 
// Some ‘K’ numbers of painters are available to paint these boards. Consider that each unit of a board takes 1 unit of time to paint. 
// You are supposed to return the area of the minimum time to get this job done of painting all the ‘N’ boards under the constraint that any painter will only paint the continuous sections of boards.


import java.util.*;

class Main {
    
    // =========================== Brute Force Approach ============================== 

        static int noOfPainters(int[] boards, int boardUnits, int painters){

            int length = boards.length;
            int sumOfUnits = 0;
            int paintersCount = 1;

            for(int index = 0 ; index < length ; index++){

                if(sumOfUnits + boards[index] <= boardUnits){
                    sumOfUnits+=boards[index];
                }else{
                    paintersCount++;
                    sumOfUnits=boards[index];
                }
            }
            return paintersCount;
        }

        static int minimumTime(int[] boards, int painters){

            int length = boards.length;

            if(length<painters) return -1;                          // T.C = O(sumOfElements - maxNumber) * O(N) + O(2N), S.C = O(1)

            int low = Arrays.stream(boards).max().getAsInt();
            int high = Arrays.stream(boards).sum();

            for(int boardUnits = low ; boardUnits <= high ; boardUnits++){

                int paintersCount = noOfPainters(boards,boardUnits,painters);

                if(paintersCount == painters){
                    return boardUnits;
                }
            }
            return -1;
        }

    // =========================== Optimal Approach ============================== 

        static int noOfPainters_1(int[] boards, int boardUnits, int painters){

            int length = boards.length;
            int sumOfUnits = 0;
            int paintersCount = 1;

            for(int index = 0 ; index < length ; index++){

                if(sumOfUnits + boards[index] <= boardUnits){
                    sumOfUnits+=boards[index];
                }else{
                    paintersCount++;
                    sumOfUnits=boards[index];
                }
            }
            return paintersCount;
        }

        static int minimumTime_1(int[] boards, int painters){

            int length = boards.length;

            if(length<painters) return -1;

            int low = Arrays.stream(boards).max().getAsInt();
            int high = Arrays.stream(boards).sum();

            while(low <= high){                                  // T.C = O(Log(sumOfElements - maxNumber)) * O(N) + O(2N) ,S.C = O(1)                                   

                int mid = low + ((high-low)/2);
                int paintersCount = noOfPainters(boards,mid,painters);

                if(paintersCount <= painters){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            
            return low;
        }

    public static void main(String[] args) {
        int[] boards = {10,20,30,40};
        int painters = 2;
        int result = minimumTime(boards,painters);
        System.out.println(result);
    }
}