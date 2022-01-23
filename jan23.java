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
    
    public String pushDominoes(String dominoes) {
        dominoes = "L" + dominoes + "R";
        StringBuilder sb = new StringBuilder(dominoes);
        
        int i = 0;
        while(i < dominoes.length() - 1){
            int j = i+1;
            
            while(j < dominoes.length() && dominoes.charAt(j) == '.'){
                j++;
            }
            
            update(sb , i , j);
            i = j;
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(0);
        
        return sb.toString();
    }
    void update(StringBuilder sb , int i , int j){
        if(sb.charAt(i) == 'L' && sb.charAt(j) == 'L'){
            for(int n = i+1; n < j; n++){
                sb.setCharAt(n , 'L');
            }
        }
        else if(sb.charAt(i) == 'R' && sb.charAt(j) == 'R'){
            for(int n = i+1; n < j; n++){
                sb.setCharAt(n , 'R');
            }
        }
        else if(sb.charAt(i) == 'R' && sb.charAt(j) == 'L'){
            int n = i+1 , m = j-1;
            while(n < m){
                sb.setCharAt(n , 'R');
                sb.setCharAt(m , 'L');
                n++;
                m--;
            }
        }
        
    }
}
