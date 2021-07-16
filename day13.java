import java.util.Stack;

public class day13 {
  static int floor;
  static int ceil;
  public static void ceilAndFloor(Node node, int data) {
    if (node.data > data) {
      if (node.data < ceil) {
        ceil = node.data;
      }
    }

    if (node.data < data) {
      if (node.data > floor) {
        floor = node.data;
      }
    }

    for (Node child : node.children) {
      ceilAndFloor(child, data);
    }
  }

  public static int kthLargest(Node node, int k) {
    floor = Integer.MIN_VALUE;
    int factor = Integer.MAX_VALUE;
    while (k > 0) {
      ceilAndFloor(node, factor);
      factor = floor;
      floor = Integer.MIN_VALUE;
      k--;
    }
    return factor;
  }

  static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }
  public static void IterativePreandPostOrder(Node node) {
    Stack<Pair> st = new Stack<>();
    st.push(new Pair(node, -1));

    String pre = "";
    String post = "";

    while (st.size() > 0) {
        Pair top = st.peek();
        
        if(top.state == -1){
            pre += top.node.data + " ";
            top.state++;
        }
        else if(top.state == top.node.children.size()){
            post += top.node.data + " ";
            st.pop();
        }
        else{
            st.push(new Pair(top.node.children.get(top.state) , -1));
            top.state++;
        }
    }
    
    System.out.print(pre + "\n" + post);
  }

  public static int size(Node node) {
    int count = 0;
    if(node == null){
        return 0;
    }
    
    count += size(node.left);
    count += size(node.right);
    
    count++;
    
    return count;
  }

  public static int sum(Node node) {
    int sum = 0;
    if(node == null){
        return 0;
    }
    
    sum += sum(node.left);
    sum += sum(node.right);
    
    sum += node.data;
    return sum;
  }

  public static int max(Node node) {
    int max = Integer.MIN_VALUE;
    
    if(node == null){
        return Integer.MIN_VALUE;
    }
    max = max(node.left);
    max = max(node.right);
    
    max = Math.max(node.data , max);
    return max;
  }

  public static int height(Node node) {
    if(node == null){
        return -1;
    }
    
    int lht = height(node.left);
    int rht = height(node.right);
    
    int ht = Math.max(lht , rht) + 1;
    
    return ht;
  }
}
