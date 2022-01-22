public class jan22 {
    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        for(int i = 1; i*i + i <= 2*n; i++){
            int num = n - (i*(i-1) / 2);
            if(num % i == 0) ans++;
        }
        return ans;
    }
}
