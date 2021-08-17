import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class day44 {
    public static int kthSmallest(int[] arr, int l, int r, int k) { 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i <= r; i++){
            if(pq.size() < k){
                pq.add(arr[i]);
            }
            else if(pq.peek() > arr[i]){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    } 

    public static int doUnion(int a[], int n, int b[], int m) {
        HashMap<Integer , Integer> elem = new HashMap<>();
        
        for(int i : a){
            elem.put(i , elem.getOrDefault(i,0)+1);
        }
        for(int i : b){
            elem.put(i , elem.getOrDefault(i,0)+1);
        }
        
        return elem.size();
    }

    int maxSubarraySum(int arr[], int n){
        
        int MaxSum = Integer.MIN_VALUE;
        int max = 0;
        
        for(int i = 0; i < n; i++){
            max += arr[i];
            if(max > MaxSum){
                MaxSum = max;
            }
            if(max < 0) max = 0;
        }
        return MaxSum;
    }

    public void merge(int arr1[], int arr2[], int n, int m) {
        int i = 0 , j = 0 , k = arr1.length - 1;
        
        while(i < arr1.length && j < arr2.length){
            int val1 = arr1[i];
            int val2 = arr2[j];
            if(val1 <= val2){
                i++;
            }
            else{
                arr2[j] = arr1[k];
                arr1[k] = val2;
                k--;
                j++;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
