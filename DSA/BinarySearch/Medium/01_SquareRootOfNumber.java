

class Main {
    
    // ==================================== Brute Force Approach ===========================================

        static int sqrtOfNumber(int value){

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
    public static void main(String[] args) {
        int number = 1024;
        int result = sqrtOfNumber(number);
        System.out.println(result);
    }
}