import java.util.*;

class Main {
    
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
        
        if(length<painters) return -1;
        
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
    public static void main(String[] args) {
        int[] boards = {10,20,30,40};
        int painters = 2;
        int result = minimumTime(boards,painters);
        System.out.println(result);
    }
}