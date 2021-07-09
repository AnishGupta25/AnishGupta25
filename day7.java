public class day7 {
    public static void printDecreasing(int n){
        if(n == 0){
            return;
        }
        
        System.out.println(n);
        printDecreasing(n - 1);
    }

    
}
