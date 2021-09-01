import java.util.*;
public class day59 {
  public static void solution(String str, String asf) {
      if (str.length() == 0) {
        System.out.println(asf);
      }
  
      for (int i = 0; i < str.length(); i++) {
        String pal = str.substring(0, i + 1);
        String ros = str.substring(i + 1);
        if (isPalindrome(pal)) {
          solution(ros, asf + "(" + pal + ") ");
        }
      }
  }
  
  public static boolean isPalindrome(String str) {
      int i = 0, j = str.length() - 1;
  
      while (i < j) {
        if (str.charAt(i) != str.charAt(j)) return false;
        j--;
        i++;
      }
      return true;
  }

  static int majorityElement(int a[], int size){
      HashMap<Integer , Integer> map = new HashMap<>();
      for(int i : a){
          map.put(i , map.getOrDefault(i , 0)+1);
      }
      for(int i : map.keySet()){
          if(map.get(i) > size / 2) return i;
      }
      return -1;
  }

  public int arrayNesting(int[] nums) {
      int subLen = 0;
      
      for(int i = 0; i < nums.length; i++){
          if (nums[i] < 0) continue;
          int ans = 1;
          int prev = nums[i];
          while(prev < nums.length && Math.abs(prev) != i){
              prev = nums[Math.abs(prev)];
              nums[Math.abs(prev)] *= -1;
              ans++;
          }
          if(subLen < ans){
              subLen = ans;
          }
      }
      return subLen;
  }

  public static void solution(int[] arr, int vidx, int n, int k, int[] subsetSum, int ssssf, ArrayList<ArrayList<Integer>> ans) {
    if (vidx == n) {
      if (ssssf == k) {
        boolean flag = true;
        for (int i = 0; i < k - 1; i++) {
          if (subsetSum[i] != subsetSum[i + 1]){
            flag = false;
            break;
          } 
        }
        if (flag) {
          for (ArrayList<Integer> list : ans) {
            System.out.print(list + " ");
          }
          System.out.println();
        }
      }
      return;
    }

    for (int i = 0; i < k; i++) {
      if (ans.get(i).size() == 0) {
        ans.get(i).add(arr[vidx]);
        subsetSum[i] += arr[vidx];
        solution(arr, vidx + 1, n, k, subsetSum, ssssf + 1, ans);
        subsetSum[i] -= arr[vidx];
        ans.get(i).remove(ans.get(i).size() - 1);
        break;
      }
      else {
        ans.get(i).add(arr[vidx]);
        subsetSum[i] += arr[vidx];
        solution(arr, vidx + 1, n, k, subsetSum, ssssf, ans);
        subsetSum[i] -= arr[vidx];
        ans.get(i).remove(ans.get(i).size() - 1);
      }
    }
  }

  public static void generateWords(int cc, String str, Character[] spots, HashMap<Character, Integer> lastOccurence) {
    if (cc == str.length()) {
      for (int i = 0; i < spots.length; i++) {
        System.out.print(spots[i]);
      }
      System.out.println();
      return;
    }

    char ch = str.charAt(cc);
    int freq = lastOccurence.get(ch);
    for (int i = freq + 1; i < str.length(); i++) {
      if (spots[i] ==  null) {
        spots[i] = ch;
        lastOccurence.put(ch, i);
        generateWords(cc + 1, str, spots, lastOccurence);
        spots[i] = null;
        lastOccurence.put(ch, freq);
      }
    }
  }
}
