public class day12 {
    public double Pow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        // if(n < 0) return Pow(1 / x, - n);
        
        double k = Pow(x, n / 2);
        
        double res = k * k;
        
        if(n % 2 != 0){
            res *= x;
        }
        
        return res;
    }
    
     public double myPow(double x, int n){
         if(n < 0) return ((double)1 / Pow(x, n));
         return Pow(x , n);
     }
}
