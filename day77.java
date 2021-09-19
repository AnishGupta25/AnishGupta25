public class day77 {
    static double medianOfArrays(int y, int x, int a[], int b[]) {
        int m = a.length;
        int n = b.length;
        int i = 0, j = 0 , k = 0;
        int[] arr = new int[m+n];
        while(i < m && j < n){
            int val1 = a[i];
            int val2 = b[j];
            
            if(val1 <= val2){
                arr[k] = val1;
                k++;
                i++;
            }
            else if(val1 > val2){
                arr[k] = val2;
                k++;
                j++;
            }
        }
        while(i < m){
            arr[k] = a[i];
            i++;
            k++;
        }
        while(j < n){
            arr[k] = b[j];
            k++;
            j++;
        }
        
        int mod = (m + n);
        
        if(mod % 2 == 0){
            int mid = (m + n) / 2;
            return (double)(arr[mid] + arr[mid-1]) / 2;
        }
        else{
            int mid = (m + n) / 2;
            return (double)(arr[mid]);
        }
    }

    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for(String str : operations){
            if(str.charAt(1) == '+') ans++;
            else ans--;
        }
        return ans;
    }
}
