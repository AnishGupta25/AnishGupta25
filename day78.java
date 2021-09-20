import java.util.*;
public class day78 {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Combination(list , new ArrayList<Integer>() , n , k , 1);
        return list;
    }
    
    public void Combination(ArrayList<ArrayList<Integer>> list , ArrayList<Integer> comb , int n , int k , int start){
        if(k == 0){
            list.add(new ArrayList<>(comb));
            return;
        }
        
        for(int i = start; i <= n; i++){
            comb.add(i);
            Combination(list , comb , n , k - 1 , i+1);
            comb.remove(comb.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Permutations(list , new ArrayList<Integer>() , nums);
        return list;
    }
    
    public void Permutations(List<List<Integer>> list , ArrayList<Integer> permu , int[] nums){
        if(permu.size() == nums.length){
            list.add(new ArrayList<>(permu));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(!permu.contains(nums[i])){
                permu.add(nums[i]);
                Permutations(list , permu , nums);
                permu.remove(permu.size() - 1);
            }
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s.length());
        Permutation(list, s , sb , 0);
        return list;
    }
    
    public void Permutation(List<String> list , String str , StringBuilder sb , int idx){
        if(idx == str.length()){
            list.add(sb.toString());
            return;
        }
        
        int ch = (int)(str.charAt(idx));
        
        if(ch >= 97 && ch <= 122){
            sb.append((char)(ch-32));
            Permutation(list , str , sb , idx+1);
            sb.deleteCharAt(sb.length()-1);
        }
        else if(ch >= 65 && ch <= 90){
            sb.append((char)(ch+32));
            Permutation(list , str , sb , idx+1);
            sb.deleteCharAt(sb.length()-1);
        }
        
        sb.append((char)ch);
        Permutation(list , str , sb , idx+1);
        sb.deleteCharAt(sb.length()-1);
    }
}
