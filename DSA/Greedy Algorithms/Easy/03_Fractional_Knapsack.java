// Problem Statement : You have n items; the i-th item has value val[i] and weight wt[i].
// A knapsack can carry at most capacity units of weight. You may take any fraction of an item (i.e. split items).
// Return the maximum total value that can be placed in the knapsack, rounded to exactly 6 decimal places.

// Example 1:

// Input: val = [60,100,120], wt = [10,20,30], capacity = 50
// Output: 240.000000
// Explanation: Take item 0 (w=10, v=60)
// Take item 1 (w=20, v=100)
// Take 2⁄3 of item 2 (w=20, v=80)
// Total value = 60 + 100 + 80 = 240

// Example 2:

// Input: val = [60,100], wt = [10,20], capacity = 50
// Output: 160.000000
// Explanation: Both items fit entirely (total weight 30 ≤ 50).

class Main {

    public static float fractionalKnapsack(int[] values, int[] weights){
        
    }

    public static void main(String[] args) {

        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        
        float result = fractionalKnapsack(values, weights);
        
        System.out.println(result);

    }
}
