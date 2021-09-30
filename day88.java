import java.util.*;
public class day88 {
    static int candies(int m, int n){
        int x = (n * m) - n - m;
        return (x / 2) + 1;
    }

    public List<Integer> pathInZigZagTree(int n) {
        List<Integer> list = new ArrayList<>();
        
        int clvl = 0 , llvl = 1;
        while(clvl < n){
            clvl += llvl;
            llvl *= 2;
        }
        llvl /= 2;
        
        while(n != 0){
            list.add(n);
            n = (3 * llvl - n - 1) / 2;
            llvl /= 2;
        }
        Collections.reverse(list);
        return list;
    }
}
