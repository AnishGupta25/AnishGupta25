import java.util.Arrays;

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

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int x = m+n;
        double arr[] = new double[x];
        int i = 0,j=0, k=0;
        while(i != m && j != n){
            double val1 = nums1[i];
            double val2 = nums2[j];
            
            if(val1 <= val2){
                arr[k] = val1;
                k++;
                i++;
            }
            else if(val2 < val1){
                arr[k] = val2;
                k++;
                j++;
            }
        }
        while(i != m){
            double val = nums1[i];
            arr[k] = val;
            k++;
            i++;
        }
        while(j != n){
            double val = nums2[j];
            arr[k] = val;
            k++;
            j++;
        }
        
        int mod = x % 2;
        double median = 0.0;
        if(mod == 0){
            int mid = x / 2;
            median = (arr[mid] + arr[mid - 1]) / 2;
        }
        else{
            int mid = x / 2;
            median = arr[mid];
        }
        
        return median;
    }

    public int lengthOfLastWord(String s) {
        String str[] = s.split(" ");
        int len = 0;
        if(str.length == 0){
            return 0;
        }
        else{
            String res = str[str.length - 1];
            len = res.length();
        }
        return len;
    }
    // merge 2 sorted arrays without using extra space
    public void merge(int arr1[], int arr2[], int n, int m) {
        int i = 0 , j = 0, k = arr1.length - 1;
        
        while(i < arr1.length && j < arr2.length){
            int val1 = arr1[i];
            int val2 = arr2[j];
            if(val1 <= val2){
                i++;
            }
            else{
                arr2[j] = arr1[k];
                arr1[k] = val2;
                j++;
                k--;
            }
        }
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
