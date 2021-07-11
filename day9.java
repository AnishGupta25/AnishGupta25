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

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
          ArrayList<String> my = new ArrayList<>();
          my.add("");
          return my;
        }
    
        ArrayList<String> myPath = new ArrayList<>();
        if (sc <= dc) {
          ArrayList<String> hpath = getMazePaths(sr, sc + 1, dr, dc);
          for (String path : hpath) {
            myPath.add("h" + path);
          }
        }
    
        if (sr <= dr) {
          ArrayList<String> vpath = getMazePaths(sr + 1, sc, dr, dc);
          for (String path : vpath) {
            myPath.add("v" + path);
          }
        }
    
        return myPath;
    }
}
