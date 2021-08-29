import java.util.*;

public class day56 {
    public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {
        if (cs == ts) {
          StringBuilder sb = new StringBuilder(asf);
          sb = sb.reverse();
    
          System.out.println(asf + (oddc == null ? "" : oddc) + sb);
          return;
        }
    
        for (char ch : fmap.keySet()) {
          if (fmap.get(ch) > 0) {
            fmap.put(ch, fmap.get(ch) - 1);
            generatepw(cs + 1, ts, fmap, oddc, asf + ch);
            fmap.put(ch, fmap.get(ch) + 1);
          }
        }
    }

    public boolean checkIfPangram(String sentence) {
        if(sentence.length() == 0) return false;
        
        int arr[] = new int[26];
        
        for(int i = 0; i < sentence.length(); i++){
            char ch = sentence.charAt(i);
            arr[ch - 'a']++;
        }
        for(int i : arr){
            if(i == 0) return false;
        }
        return true;
    }

    public static int counter = 1;
    public static void solution(int i, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) {
    if (i > n) {
      if (rssf == k) {
        System.out.print(counter + ". ");
        counter++;
        for (ArrayList<Integer> arr : ans) {
          System.out.print(arr + " ");
        }
        System.out.println();
      }
      return;
    }

    for (int j = 0; j < ans.size(); j++) {
      if (ans.get(j).size() == 0) {
        ans.get(j).add(i);
        solution(i + 1, n, k, rssf + 1, ans);
        ans.get(j).remove(ans.get(j).size() - 1);   
        break;
      }
      else {
        ans.get(j).add(i);
        solution(i + 1, n, k, rssf, ans);
        ans.get(j).remove(ans.get(j).size() - 1);
      }
    }
   }

   public static void printNQueens(boolean[][] board, String asf, int row , int[] bcol , int[] rd , int[] ld) {
    if (row == board.length) {
      System.out.println(asf + ".");
      return;
    }

    for (int col = 0; col < board.length; col++) {
      if (isSafe(board, col, row , bcol , rd , ld)) {
        board[row][col] = true;
        bcol[col] = 1;
        rd[col+row] = 1;
        ld[col-row + board.length - 1] = 1;
        printNQueens(board, asf + row + "-" + col + ", ", row + 1 , bcol , rd , ld);
        bcol[col] = 0;
        rd[col+row] = 0;
        ld[col-row + board.length - 1] = 0;
        board[row][col] = false;
      }
    }
  }
  
  public static boolean isSafe(boolean[][] board, int col, int row , int[] bcol , int[] rd , int[] ld){
    if(bcol[col] != 0) return false;
    if(rd[col+row] != 0) return false;
    if(ld[col-row + board.length - 1] != 0) return false;
    return true;
  }
}
