class Main {

    // =========================== Brute Force Approach ==============================

        static String removeOuterParantheses(String s){

            String result = "";
            int counter = 0;

            for(char ch : s.toCharArray()){

                if(ch == '('){
                    if(counter > 0){
                        result+='(';                            // T.C = O(N^2), S.C = O(1)
                    }
                    counter++;
                }else if(ch == ')'){
                    counter--;
                    if(counter > 0){
                        result+=')';
                    }
                }
            }
            return result;
        }
    

    public static void main(String[] args) {

        String s = "(()())(())";
        String result = removeOuterParantheses(s);
        System.out.println(result);
    }
}