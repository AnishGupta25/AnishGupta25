import java.util.*;
public class day98 {
    static long ValidPair(int a[], int n) { 
	    if(n <= 1) return 0;
	 
	    Arrays.sort(a);
	    
	    int i = 0;
	    int j = 0;
	    int k = 0;
	    int mid = 0;
        int temp = 0;
	    long count = 0;
	    while(i < n){
	        j = i+1;
	        k = n-1;
	        temp = 0;
	        while(j <= k){
	            mid = j + (k - j) / 2;
	            if(a[mid] + a[i] > 0){
	                temp = mid;
	                k = mid - 1;
	            }
	            else{
	                j = mid + 1;
	            }
	        }
	        if(temp != 0)
	            count += n - temp;
	        i++;
	    }
	    return count;
	}
}
