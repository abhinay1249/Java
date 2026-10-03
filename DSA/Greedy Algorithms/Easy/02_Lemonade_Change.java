// Problem Statement: Each lemonade at a booth sells for $5. Consumers are lining up to place individual orders, following the billing order.
// Every consumer will purchase a single lemonade and may pay with a $5, $10, or $20 bill.
// Each customer must receive the appropriate change so that the net transaction is $5. Initially, there is no change available.

// Determine if it is possible to provide the correct change to every customer.
// Return true if the correct change can be given to every customer, and false otherwise.

// Given an integer array bills, where bills[i] is the bill the ith customer pays,
// return true if the correct change can be given to every customer, and false otherwise.

// Example 1:

// Input : bills = [5, 5, 10, 5, 20]
// Output : true
// Explanation : Initially we have $0 available for change.
// From first two customers, we will collect two $5 bills in order. After the first two customers we have two $5 bills available with us for change.
// From the third customer , we collect bill of $10 and give back $5. After third customer we have one $5 and one $10 bill available with us for change.
// From fourth customer , we collect $5 bill. After fourth customer we have two $5 and one $10 bills available with us for change if required.
// From fifth customer , we collect bill of $20 and give back $15 (one $10 + one $5 bill).
// Since all the customers did receive the change correctly, so we return true.

// Example 2:

// Input : bills = [5, 5, 10, 10, 20]
// Output : false
// Explanation : From first two customers, we will collect two $5 bills in order. After the first two customers we have two $5 bills available with us for change.
// From third customer, we collect $10 and give back $5. After the third customer we have one $5 and one $10 bill available with us for change.
// From fourth customer, we collect $10 and give back $5. After the fourth customer we have two $10 bill available with us for change.
// From fifth customer, we collect $20, we cannot give the $15 change as we have two $10 bills.
// Since all the customers did not receive the change correctly, the we return false.

class Main {

    // ========================== Greedy Algorithm Approach ===============================

        public static boolean lemonadeChange(int[] bills){

            int rs5Count = 0;
            int rs10Count = 0;

            for(int billNo : bills){

                switch(billNo){
                
                    case 5 -> rs5Count++;

                    case 10 ->{ 
                        if(rs5Count >= 1){
                            rs5Count--;
                        }else{
                            return false;                                           // T.C = O(N), S.C = O(1)
                        }
                        rs10Count++;
                    }
                
                    case 20 -> {   
                        if(rs5Count >=1 && rs10Count >= 1){
                           rs5Count--;
                           rs10Count--; 
                        }else if(rs5Count >= 3){
                            rs5Count-=3;
                        }else{
                            return false;
                        }
                    }
                }
            }

            return true;

        }
    public static void main(String[] args) {
        
        int[] bills = {5, 5, 10, 10, 20};

        boolean result = lemonadeChange(bills);

        System.out.println(result);

    }
}