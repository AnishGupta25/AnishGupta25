import java.util.*;
public class day100 {
    long countTriplets(long arr[], int n,int sum){
        Arrays.sort(arr);
        long counter = 0;
        for (int i = 0; i < (n - 2); i++) {
            int j = (i + 1), k = (n - 1);
            while (j < k) {
                if (arr[i] + arr[j] + arr[k] < sum) {
                    counter += (k - j);
                    j++;
                } else k--;
            }
        }
        return counter;
    }

    public int guessNumber(int n) {
        int i = 1, j = n;
        
        while(i <= j){
            int mid = i + (j-i) / 2;
            // int pick = guess(mid);
            int pick = mid;
            
            if(pick == 0) return mid;
            else if(pick == 1) i = mid + 1;
            else if(pick == -1) j = mid - 1;
        }
        return -1;
    }
}
