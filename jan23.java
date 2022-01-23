import java.util.*;
public class jan23 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> sequentialDigits(int low, int high) {
        for(int i = 1; i <= 9; i++){
            dfs(i , low , high , 0);
        }
        Collections.sort(list);
        return list;
    }
    void dfs(int i, int low , int high , int num){
        if(num >= low && num <= high) list.add(num);
        if(num > high || i > 9) return;
        dfs(i+1 , low , high , num*10 + i);
    }
}
