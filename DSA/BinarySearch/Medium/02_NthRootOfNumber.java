class Main {
    
    static int powOfNumber(int number, int root){
        int result = (int) Math.pow(number,root);
        return result;
    }
    static int nthRootOfNumber(int n, int m){
        
        int number = -1;
        
        for(int index = 1 ; index < m ; index++){
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

    public static void main(String[] args) {
        int number = 622;
        int root = 4;
        int result = nthRootOfNumber_1(root,number);
        System.out.println(result);
    }
}