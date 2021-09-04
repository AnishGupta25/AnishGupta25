import java.util.*;
public class day62 {
    public static int solution(int n, int k) {
        if(n == 1) return 0;
        return (solution(n - 1 , k) + k) % n;
    }
    
    static int counter = 1;
    public static void solution(int i, int n, boolean[] used, String asf) {
        if (i > n) {
          System.out.println(counter + "." + asf);
          counter++;
          return;
        }
        if (used[i]) {
          solution(i + 1, n, used, asf);
        }
        else {
          used[i] = true;
          solution(i + 1, n, used, asf + "(" + i + ") ");
    
          for (int j = i + 1; j <= n; j++) {
            if (!used[j]) {
              used[j] = true;
              solution(i + 1, n, used, asf + "(" + i + "," + j + ") ");
              used[j] = false;
            }
          }
          used[i] = false;
        }
    }

  static int max = 0;
  public static void getMaxGold(int[][] arr) {
    boolean[][] visited = new boolean[arr.length][arr[0].length];
    for(int i = 0; i < arr.length; i++){
        for(int j = 0; j < arr[0].length; j++){
            if(arr[i][j] != 0 && !visited[i][j]){
                ArrayList<Integer> bag = new ArrayList<>();
                getMaxGoldHelper(arr , i , j , visited , bag);
                int sum = 0;
                for(int k : bag){
                    sum += k;
                }
                max = Math.max(max , sum);
            }
        }
    }
  }
  public static void getMaxGoldHelper(int[][] arr, int i, int j, boolean[][] visited, ArrayList<Integer> bag){
    if (i < 0  || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 0 || visited[i][j] == true) {
    return;
  }
    
    bag.add(arr[i][j]);
    visited[i][j] = true;
    
    getMaxGoldHelper(arr, i - 1, j, visited, bag);
    getMaxGoldHelper(arr, i , j + 1, visited, bag);
    getMaxGoldHelper(arr, i , j - 1, visited, bag);
    getMaxGoldHelper(arr, i + 1, j, visited, bag);
  }
}
