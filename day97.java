public class day97 {
    public int findK(int a[][], int n, int m, int k){
	    int rmin = 0, cmin = 0, rmax = a.length - 1 , cmax = a[0].length - 1 , count = 1;
	    
	    while(count != k){
	        for(int i = rmin , j = cmin; j <= cmax && count < k; j++){
	            if(count == k) return a[i][j];
	            count++;
	        }
	        for(int i = rmin + 1 , j = cmax; i <= rmax && count < k; i++){
	            if(count == k) return a[i][j];
	            count++;
	        }
	        for(int i = rmax , j = cmax - 1; j >= cmin && count < k; j--){
	            if(count == k) return a[i][j];
	            count++;
	        }
	        for(int i = rmax - 1 , j = cmin; i > rmin && count < k; i--){
	            if(count == k) return a[i][j];
	            count++;
	        }
	        rmin++;
            cmin++;
            rmax--;
            cmax--;
	    }
	    return 0;
	}
}
