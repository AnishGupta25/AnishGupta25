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
}
