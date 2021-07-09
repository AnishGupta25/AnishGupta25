public class day7 {
    public static void printDecreasing(int n){
        if(n == 0){
            return;
        }
        
        System.out.println(n);
        printDecreasing(n - 1);
    }

    public static void printIncreasing(int n){
        if(n == 0){
            return;
        }
        
        printIncreasing(n - 1);
        System.out.println(n);
    }

    public static void pdi(int n){
        if(n == 0){
            return;
        }
        
        System.out.println(n);
        pdi(n-1);
        System.out.println(n);
    }

    public static int factorial(int n){
        if(n == 0){
            return 1;
        }
        int fact = factorial(n-1) * n;
        return fact;
    }

    public static int power(int x, int n){
        if(n == 0){
            return 1;
        }
        int k = power(x , n - 1);
        int res = x * k;
        return res;
    }

    public static int lpower(int x, int n) {
        if (n == 0) {
          return 1;
        }
        
        int k = lpower(x , n / 2);
        int res =  k * k;
        if(n % 2 == 1){
            res *= x;
        }
        return res;
    }

    public static void pzz(int n) {
        if(n == 1){
            System.out.print("1 1 1 ");
            return;
        }
        
        System.out.print(n + " ");
        pzz(n - 1);
        System.out.print(n + " ");
        pzz(n- 1);
        System.out.print(n + " ");
    }

    public static void toh(int n, int t1id, int t2id, int t3id){
        if(n == 0){
            return;
        }
        
        toh(n-1, t1id , t3id , t2id);
        System.out.println(n + "[" + t1id + " -> " + t2id + "]");
        toh(n-1 , t3id , t2id , t1id);
    }

    public static void displayArr(int[] arr, int idx) {
        if (idx == arr.length) {
          return;
        }
    
        System.out.println(arr[idx]);
        displayArr(arr, idx + 1);
    }
}
