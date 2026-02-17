// Problem Statement: Given two numbers N and M, find the Nth root of M. 
// The nth root of a number M is defined as a number X when raised to the power N equals M. 
// If the 'nth root is not an integer, return -1.

class Main {

    // =========================== Brute Force Approach ==============================

        static int powOfNumber(int number, int root){
            int result = (int) Math.pow(number,root);
            return result;
        }

        static int nthRootOfNumber(int n, int m){

            int number = -1;

            for(int index = 1 ; index < m ; index++){           // T.C = O(LOG N) + O(N), S.C = O(1)
                int product = powOfNumber(index,n);
                if(product == m){
                    number = index;
                    return number;
                }else if(product>m){
                    break;
                }
            }
            return number;
        }
    
    // =========================== Optimal Approach ==============================

        static int powOfNumber_1(int mid, int n, int m){
            // return 1, if it is equal
            // return 0, if the number is less than m
            // return 2, if the number is greater than m

            long ans = 1;

            for(int index = 1; index <= n ; index++){
                ans *= mid;
                if(ans > m) return 2;                                   // T.C = O(N) + O(LOG N) S.C = O(1)
            }
            if(ans == m) return 1;
            return 0;
        }
    
        static int nthRootOfNumber_1(int root, int number){

            int value = -1;
            int low = 1, high = number;

            while(low <= high){
                int mid = low + ((high-low)/2);
                int nthRoot = powOfNumber_1(mid,root,number);

                if(nthRoot == 1){
                    value = mid;
                    return value;
                }
                if(nthRoot == 2){
                    high = mid - 1;
                }else if(nthRoot == 0){
                    low = mid+1;
                }
            }
            return value;
        }

    public static void main(String[] args) {
        int number = 622;
        int root = 4;
        int result = nthRootOfNumber_1(root,number);
        System.out.println(result);
    }
}