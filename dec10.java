public class dec10 {
    public int numTilings(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 5;
        
        int one = 1, two = 2, three = 5 ,ans = 0;
        int mod = (int)(Math.pow(10,9)+7);
        
        for(int i = 4; i <= n; i++){
            ans = (2 * three % mod + one) % mod;
            one = two;
            two = three;
            three = ans;
        }
        return ans;
    }
}
