import java.util.*;
public class day63 {
    static int findLongestConseqSubseq(int arr[], int N){
	    HashSet<Integer> set = new HashSet<>();
	    for(int i = 0; i < N; i++){
	        set.add(arr[i]);
	    }
	    int count = 0;
	    
	    for(int i = 0; i < N; i++){
	        if(!set.contains(arr[i] - 1)){
	            int temp = arr[i];
	            while(set.contains(temp)){
	                temp++;
	            }
	            if(count < temp - arr[i]){
	                count = temp - arr[i];
	            }
	        }
	    }
	    return count;
	}
}
