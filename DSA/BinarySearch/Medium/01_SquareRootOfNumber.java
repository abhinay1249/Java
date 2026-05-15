// Problem Statement: You are given a positive integer n. 
// Your task is to find and return its square root. 
// If ‘n’ is not a perfect square, then return the floor value of sqrt(n).

class Main {
    
    // =========================== Brute Force Approach ==============================

        public static int sqrtOfNumber(int value){

            if(value == 0) return 0;
            int result = -1;

            for(int index = 1 ; index <= value ; index++){
                int squares = index * index;                                 //T.C = O(N), S.C = O(1)

                if(squares == value){
                    result = index;
                    break;
                }else if(squares > value){
                    result = index - 1;
                    break;
                }
            }
            return result;
        }

    // ===================== Optimal Approach ==========================================

        public static int sqrtOfNumber_1(int value){

            if(value == 0) return 0;

            int low = 1, high = value;
            int result = -1;

            while(low <= high){

                long mid = low + ((high-low)/2);                                 //T.C = O(Log N), S.C = O(1)
                long squares = (mid * mid);

                if(squares <= low){
                    result = (int) mid;
                    low = (int) mid + 1;
                }else if(squares > value){
                    high = (int) mid - 1;
                }
            }
            return result;
        }
    public static void main(String[] args) {
        int number = 1024;
        int result = sqrtOfNumber(number);
        System.out.println(result);
    }
}