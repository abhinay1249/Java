import java.util.*;

class Main {

    // =========================== Brute Force Approach ============================== 

        static int noOfStudents(int[]pages,int maxPages,int students){

            int length = pages.length;
            int studentsCount = 1;
            int sumOfPages = 0;

            for(int totalPages = 0 ; totalPages < length ; totalPages++){

                if(sumOfPages + pages[totalPages] <= maxPages){
                    sumOfPages += pages[totalPages];
                }else{
                    studentsCount++;
                    sumOfPages = pages[totalPages];
                }
            }
            return studentsCount;
        }

        static int allocateBooks(int[] pages, int students){

            int length = pages.length;

            if(length<students) return -1;                           // T.C = O(sumOfElements - maxNumber) * O(N) + O(2N), S.C = O(1)
            if(length == 1) return Arrays.stream(pages).sum();

            int low = Arrays.stream(pages).max().getAsInt();
            int high = Arrays.stream(pages).sum();

            for(int maxPages = low ; maxPages <= high ; maxPages++){

                int countOfStudents = noOfStudents(pages,maxPages,students);

                if(countOfStudents == students){
                    return maxPages;
                }
            }
            return -1;
        }

    // =========================== Optimal Approach ============================== 

        static int noOfStudents_1(int[]pages,int maxPages,int students){
        
            int length = pages.length;
            int studentsCount = 1;
            int sumOfPages = 0;

            for(int totalPages = 0 ; totalPages < length ; totalPages++){

                if(sumOfPages + pages[totalPages] <= maxPages){
                    sumOfPages += pages[totalPages];
                }else{
                    studentsCount++;
                    sumOfPages = pages[totalPages];
                }
            }
            return studentsCount;
        }

        static int allocateBooks_1(int[] pages, int students){

            int length = pages.length;

            if(length<students) return -1;                      
            if(length == 1) return Arrays.stream(pages).sum();

            int low = Arrays.stream(pages).max().getAsInt();          
            int high = Arrays.stream(pages).sum();
    
            while(low <= high){                             // T.C = O(Log(sumOfElements - maxNumber)) * O(N) + O(2N) ,S.C = O(1) 
                int mid = low + ((high-low)/2);

                int countOfStudents = noOfStudents_1(pages,mid,students);

                if(countOfStudents <= students){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            return low;
        }

    public static void main(String[] args) {
        int[] pages = {12, 34, 67, 90};
        int students = 2;
        int result = allocateBooks(pages,students);
        System.out.println(result);
    }
}