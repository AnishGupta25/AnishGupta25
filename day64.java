import java.util.*;
public class day64 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int time = releaseTimes[0];
        char ch = keysPressed.charAt(0);
        for(int i = 1; i < releaseTimes.length; i++){
            int val = releaseTimes[i] - releaseTimes[i - 1];
            if(val > time){
                time = val;
                ch = keysPressed.charAt(i);
            }
            else if(val == time){
                if(keysPressed.charAt(i) > ch){
                    ch = keysPressed.charAt(i);
                }
            }
        }
        return ch;
    }

    class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static ArrayList<Integer> printNearNodes(Node root,int low,int high) {
	    ArrayList<Integer> ans = new ArrayList<>();
	    pir(root , low , high , ans);
	    return ans;
    }
    
    public static void pir(Node root,int low,int high, ArrayList<Integer> ans){
        if(root == null) return;
        
        if(root.data < low ){
           pir(root.right , low , high , ans); 
        }
        
        else if(root.data > high){
            pir(root.left , low , high , ans); 
        }
        else{
            pir(root.left , low , high , ans);
            ans.add(root.data);
            pir(root.right , low , high , ans); 
        }
    }
}
