public class dec11 {
    public int nthMagicalNumber(int n, int a, int b) {
        long A = a, B = b;
        long mod = (long)(Math.pow(10,9)+7);
        long gcd = GCD(A , B);
        long lcm = (a * b) / gcd;
        
        long l = Math.min(a , b) , r = (long)n * Math.min(a , b);
        
        while(l < r){
            Long mid = l + (r - l) / 2;
            
            if((mid / a) +( mid / b) - (mid / lcm)  < n) l = mid + 1;
            else r = mid;
        }
        return (int)(l % mod);
    }
    
    public long GCD(long a , long b){
        while(b > 0){
            long temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
}
