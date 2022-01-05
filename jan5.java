import java.util.*;
public class jan5 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        helper(s , res , temp);
        return res;
    }
    
    public void helper(String str , List<List<String>> res , List<String> temp){
        if(str.length() == 0){
            res.add(new ArrayList<String>(temp));
        }
        
        for(int i = 0; i < str.length(); i++){
            String lft = str.substring(0,i+1);
            if(isPalindrome(lft)){
                temp.add(lft);
                helper(str.substring(i+1) , res , temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String str){
        int i = 0 , j = str.length()-1;
        
        while(i < j){
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
