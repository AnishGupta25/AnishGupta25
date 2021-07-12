import java.util.ArrayList;
import java.util.Stack;
 
public class day10{
    public static class Node{
        int data;
        ArrayList<Node> children;
   
        Node(){
            children = new ArrayList<>();
        }
        Node(int val){
            data = val;
            children = new ArrayList<>();
        }
    }
 
    
}