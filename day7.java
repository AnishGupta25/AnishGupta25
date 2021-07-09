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
}
