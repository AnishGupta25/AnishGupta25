import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class day28 {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> res = new ArrayList<>();
        int carry = 0;
        for(int i = digits.length - 1; i >= 0; i--){
            int nums = digits[i] + carry;
            if(i == digits.length - 1){
                nums += 1;
            }
            carry = nums / 10;
            nums = nums%10;
            res.add(0 , nums);
        }
        if(carry != 0){
            res.add(0 , carry);
        }
        int[] r = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            r[i] = res.get(i);
        }
        return r;
    }

    public boolean isValid(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        
        for(int i = 1; i < n; i++){
            char ch = chars[i];
            
            if(chars[i] == '(' || chars[i] == '{' || chars[i] == '['){
                st.push(ch);
            }
            
            else{
                if(st.size() == 0) return false;
                char pre = st.peek();
                if(pre == '(' && chars[i] == ')') st.pop();
                else if(pre == '[' && chars[i] == ']') st.pop();
                else if(pre == '{' && chars[i] == '}') st.pop();
                
                else return false;
            }
        }
        
        if(st.size() > 0) return false;
        return true;
    }

    public static int Infection(ArrayList<Edge>[] graph, int src, int t) {
        int[] visited = new int[graph.length];
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, 1));
        int count = 0;
        while (queue.size() > 0) {
          Pair head = queue.remove();
          if(visited[head.vtx] != 0) continue;
          if(visited[head.vtx] == 0){
            visited[head.vtx] = head.toi;
            if(head.toi > t) break;
            count++;
            for(Edge e : graph[head.vtx]){
                if(visited[e.nbr] == 0){
                    queue.add(new Pair(e.nbr , head.toi+1));
                }
            }
          }
        }
        return count;
    }
    
    public static class Pair {
        int vtx, toi;
        Pair(int vtx, int toi) {
          this.vtx = vtx;
          this.toi = toi;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        boolean[][] visited = new boolean[image.length][image[0].length];
        int prev = image[sr][sc];
        if(prev == newColor) return image;
        floodFillHelper(image , sr , sc , newColor , visited , prev);
        return image;
    }
    
    public void floodFillHelper(int[][] image, int sr, int sc, int newColor , boolean[][] visited , int prev){
        if(sr < 0 || sc < 0 || sr == image.length || sc == image[0].length) return;
        if(image[sr][sc] != prev) return;
        if(visited[sr][sc]) return;
        if(!visited[sr][sc]){
            image[sr][sc] = newColor;
        }
        visited[sr][sc] = true;
        
        floodFillHelper(image , sr - 1 , sc , newColor , visited , prev);
        floodFillHelper(image , sr , sc + 1 , newColor , visited , prev);
        floodFillHelper(image , sr + 1 , sc , newColor , visited , prev);
        floodFillHelper(image , sr , sc - 1 , newColor , visited , prev);
    }
}
