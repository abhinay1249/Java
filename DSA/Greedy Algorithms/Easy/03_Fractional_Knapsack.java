
import java.util.Arrays;

class Knapsack{

    int value;
    int weight;

    Knapsack(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

        public static double fractionalKnapsack(int[] values, int[] weights, long capacity){
        
            double knapsackValue = 0.0;
        
            Knapsack[] items = new Knapsack[values.length];
        
            for(int index = 0 ; index < values.length ; index++){
                items[index] = new Knapsack(values[index], weights[index]);
            }
        
            Arrays.sort(items, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));
        
            for(Knapsack item : items){
                if(item.weight <= capacity){
                    capacity -= item.weight;
                    knapsackValue += item.value; 
                }else{
                    knapsackValue += ((double) item.value/item.weight * capacity);
                    break;
                }
            }
        
            return knapsackValue;
        
        }

    public static void main(String[] args) {

        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        long capacity = 50;
        
        double result = fractionalKnapsack(values, weights, capacity);
        
        System.out.println(result);

    }
}
