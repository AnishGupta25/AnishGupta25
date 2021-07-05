public static void main(String[] args) {
    
    static Node leftPal;
    public boolean IsPalindrome() {
      leftPal = this.head;
      boolean res = IsPalindromeHelper(head, 0);
      return res;
    }

    public boolean IsPalindromeHelper(Node node, int idx) {
      if (node == null) {
        return true;
      }
      boolean res = IsPalindromeHelper(node.next, idx + 1);

      if (res) {
        if (idx >= this.size / 2) {
          if (leftPal.data == node.data) {
            leftPal = leftPal.next;
            return true;
          } else {
            return false;
          }
        }
      }

      return res;
    }
}