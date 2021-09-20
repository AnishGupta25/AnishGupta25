import java.util.*;
public class day78 {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Combination(list , new ArrayList<Integer>() , n , k , 1);
        return list;
    }
    
    public void Combination(ArrayList<ArrayList<Integer>> list , ArrayList<Integer> comb , int n , int k , int start){
        if(k == 0){
            list.add(new ArrayList(comb));
            return;
        }
        
        for(int i = start; i <= n; i++){
            comb.add(i);
            Combination(list , comb , n , k - 1 , i+1);
            comb.remove(comb.size() - 1);
        }
    }
}
