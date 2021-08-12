import java.util.*;
public class day33 {
    int isPlaindrome(String S) {
        int n = S.length();
        char[] str = S.toCharArray();
        int i = 0, j = n - 1;
        while(i <= j){
            if(str[i] != str[j]) return 0;
            i++;
            j--;
        }
        return 1;
    }
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle.size() == 1) return triangle.get(0).get(0);
        int dp[] = new int[triangle.size()];
        
        for(int i = 0; i < triangle.size(); i++){
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for(int i = triangle.size() - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j] , dp[j+1]);
            } 
        }
        
        return dp[0];
    }
}

class GFG {
	public static int findMinRec(int arr[], int i,int sumCalculated,int sumTotal){
		if (i == 0) return Math.abs((sumTotal - sumCalculated) - sumCalculated);
		return Math.min(findMinRec(arr, i - 1, sumCalculated + arr[i - 1], sumTotal),findMinRec(arr, i - 1, sumCalculated, sumTotal));
	}
	public static int findMin(int arr[], int n){
		int sumTotal = 0;
		for (int i = 0; i < n; i++){
			sumTotal += arr[i];
        }
		return findMinRec(arr, n, 0, sumTotal);
	}
	public static void main(String[] args)
	{
		int arr[] = { 3, 1, 4, 2, 2, 1 };
		int n = arr.length;
		System.out.print("The minimum difference" + " between two sets is " + findMin(arr, n));
	}
}
