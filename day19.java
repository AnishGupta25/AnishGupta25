public class day19 {
    static int[] SortBinaryArray(int arr[], int n) { 
	    int i = 0, j = 0;
	    
	    while(i < n){
	        if(arr[i] == 1){
	            i++;
	        }
	        else{
	            int temp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = temp;
	            
	            j++;
	            i++;
	        }
	    }
	    
	    return arr;
	} 
}
