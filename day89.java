public class day89 {
    static int maxCandy(int height[], int n) {
	    if(n <= 2) return 0;
	    
	    int i = 0, j = n - 1;
	    int max = 0;
	    while(i < j){
	        int val1 = height[i];
	        int val2 = height[j];
	        
	        int temp = Math.min(val1 , val2) * (j - i - 1);
	        max = Math.max(max , temp);
	        if(val1 < val2) i++;
	        else if(val1 > val2) j--;
	        else{
	            i++;
	            j--;
	        }
	    }
	    return max;
	}
}
