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
}
