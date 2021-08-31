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
}
