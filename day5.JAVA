public static void main(String[] args) {
    
    
}

static Node leftp;
public void fold() {
    leftp = head;
    foldhelper(head, 0);
}

public void foldhelper(Node node, int idx) {
    if (node == null) {
    return;
    }
    foldhelper(node.next, idx + 1);
    Node right = node;

    if (idx > size / 2) {
    Node temp = leftp.next;
    leftp.next = right;
    right.next = temp;
    leftp = temp;
    }
    else if (idx == size / 2) {
    tail = right;
    tail.next = null;
    return;
    }

    public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
        LinkedList res = new LinkedList();
        int carry = addTwoHelper(one.head, two.head, one.size, two.size, res);
        if (carry > 0) {
          res.addFirst(carry);
        }
        return res;
    }
    
    public static int addTwoHelper(Node n1, Node n2, int size1, int size2, LinkedList res) {
        if (n1 == null && n2 == null) {
          return 0;
        }
        int carry = 0;
        int ans = 0;
        if (size1 > size2 ) {
          carry = addTwoHelper(n1.next, n2, size1 - 1, size2, res);
          ans = carry + n1.data;
        }
        else if (size2 > size1) {
          carry = addTwoHelper(n1, n2.next, size1, size2 - 1, res);
          ans = carry + n2.data;
        }
        else{
            carry = addTwoHelper(n1.next, n2.next , size1 - 1, size2 - 1, res);
            ans = carry + n1.data + n2.data;
        }
        
        carry = ans / 10;
        ans = ans % 10;
        res.addFirst(ans);
        return carry;
    }
}