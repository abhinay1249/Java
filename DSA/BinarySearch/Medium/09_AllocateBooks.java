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

            if(length<students) return -1;                              // T.C = O(sumOfElements - maxNumber) * O(N) S.C = O(1)
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
    public static void main(String[] args) {
        int[] pages = {12, 34, 67, 90};
        int students = 2;
        int result = allocateBooks(pages,students);
        System.out.println(result);
    }
}