import java.util.ArrayList;

public class day9 {
    public static ArrayList<String> gss(String str) {
        if (str.length() == 0) {
          ArrayList<String> res = new ArrayList<>();
          res.add("");
          return res;
        }
        char a = str.charAt(0);
        String roq = str.substring(1);
        ArrayList<String> sub = gss(roq);
        ArrayList<String> res = new ArrayList<>();
        for(String s : sub){
            res.add(s);
        }
        for(String s : sub){
            res.add(a + s);
        }
        
        return res;
    }
}
