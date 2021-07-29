import java.util.ArrayList;

public class day26 {
    public int[] beautifulArray(int n) {
        ArrayList<Integer> beaArr = new ArrayList<>();
        beaArr.add(1);
        
        while(beaArr.size() < n){
            ArrayList<Integer> curr = new ArrayList<>();
            for(int i : beaArr){
                if(i*2 - 1 <= n) curr.add(i*2 - 1);
            }
            for(int i : beaArr){
                if(i*2 <= n) curr.add(i*2);
            }
            beaArr = curr;
        }
        
        int[] res = new int[beaArr.size()];
        for(int i = 0; i < beaArr.size(); i++){
            res[i] = beaArr.get(i);
        }
        return res;
    }

    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        if(haystack.length() < needle.length()) return -1;
        int n = haystack.length() , m = needle.length();
        
        for(int i = 0; i <= n - m; i++){
            int j;
            for(j = 0; j < m; j++){
                if(haystack.charAt(i + j) != needle.charAt(j)) break;
            }
            if(j == m) return i;
        }
        return -1;
    }
}
