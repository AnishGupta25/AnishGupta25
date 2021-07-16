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
}
