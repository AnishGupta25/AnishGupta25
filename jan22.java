public class jan22 {
    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        for(int i = 1; i*i + i <= 2*n; i++){
            int num = n - (i*(i-1) / 2);
            if(num % i == 0) ans++;
        }
        return ans;
    }

    int m = 1000000007;
    public int kConcatenationMaxSum(int[] arr, int k) {
        int sum = Sum(arr);
        if(k == 1) return Kadens1(arr);
        int kdns = Kadens(arr);
        if(sum > 0){
            long ans = kdns + (long)(k - 2) * sum; 
            return (int)(ans % m);
        } 
        return kdns;
    }
    
    public int Kadens(int[] arr){
        int max = 0;
        int cmax = arr[0];
        for(int i = 1; i < 2*arr.length; i++){
            int idx = i % arr.length;
            if(cmax > 0) cmax += arr[idx];
            else cmax = arr[idx];
            max = Math.max(cmax , max);
        }
        return max;  
    }
    public int Kadens1(int[] arr){
        int max = arr[0];
        int cmax = arr[0];
        for(int i = 1; i < arr.length; i++){
            int idx = i % arr.length;
            if(cmax > 0) cmax += arr[idx];
            else cmax = arr[idx];
            max = Math.max(cmax , max);
        }
        return max;
        
    }
    
    public int Sum(int[] arr){
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        return sum;
    }
}
