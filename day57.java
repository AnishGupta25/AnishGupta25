import java.util.*;
public class day57 {
    public String reverseParentheses(String s) {
        if(s.length() == 0) return s;
        
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                Queue<Character> qu = new ArrayDeque<>();
                while(st.peek() != '('){
                    qu.add(st.pop());
                }
                st.pop();
                while(qu.size() > 0){
                    st.push(qu.remove());
                }
            }
            else{
                st.push(s.charAt(i));
            }
        }
        StringBuilder str = new StringBuilder();
        while(st.size() > 0){
            str.append(st.pop());
        }
        
        return str.reverse().toString();
    }

    public int[] numMovesStones(int a, int b, int c) {
        int max = Math.max(a,Math.max(b,c)) , min = Math.min(a,Math.min(b,c)) , mid = a+b+c-max-min;
        
        int res[] = new int[2];
        res[1] = max - min - 2; 
        
        if(max - mid == 1 && mid - min == 1) res[0] = 0;
        else if(max - mid <= 2 || mid - min <= 2) res[0] = 1;
        else res[0] = 2;
        
        return res;
    }

    class Node{
        int data;
        Node next;
        
        Node(int d){
            data = d;
            next = null;
        }
    }

    boolean isPalindrome(Node head) {
        left = head;
        return isPalindromehelper(head);
    }
    Node left;
    
    boolean isPalindromehelper(Node right){
        if(right == null) return true;
        
        boolean ress = isPalindromehelper(right.next);
        if(!ress) return false;
        else if(left.data != right.data) return false;
        else left = left.next; return true;
    }
}
