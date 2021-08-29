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
}
